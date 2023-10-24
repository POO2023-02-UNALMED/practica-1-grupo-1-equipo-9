package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Patrocinador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Ciudad implements Serializable, Decimales{
	
    /**
     * Autores: David Toro Arboleda, Santiago Lopez Ayala, Juan Andres Jimenez Velez, Mariana Valencia Cubillos, Samuel Mira Alvarez
     * Finalidad: Descripcion de la clase: Esta clase representa una ciudad, la cual tiene un nombre, un continente, y una lista de patrocinadores y un precio de estadía. Es en las ciudades donde se llevan a cabo las carreras de loa campeonatos
     * de acuero al continente donde se realice el campeonato.
     **/

	private static final long serialVersionUID = -8026803019433813720L;
	//Lista de las ciudades
	public static ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>();
	
	//Atributos
    private String nombre;
    private Continente continente;

	private Patrocinador host;
	private double precioEstadia;

	Random random = new Random();
    //Constructores
    public Ciudad(String nombre, Continente continente) {
    	this.nombre=nombre;
    	this.continente=continente;
		Ciudad.listaCiudades.add(this);
		// seleccionar host
		this.host = Patrocinador.listaPatrocinadores.get(random.nextInt(Patrocinador.listaPatrocinadores.size()));
		this.precioEstadia = (double) (random.nextInt(500) + 100);
	}

	public Ciudad(String nombre) {
		this.nombre=nombre;
		this.continente=Continente.values()[random.nextInt(5)];
	}
    
    //Metodos de instancia
    public String toString() {
    	return this.nombre;
    }
    
    //Metodos de clase
    public static ArrayList<Ciudad> getListaCiudades() {
    	return listaCiudades;
    }
    public static Continente convertirContinente(int id) { 
    	/*
         * Descripcion del metodo: Convierte un caracter del 1 al 5 en su continente correspondiente 
         * Parametros de entrada: int id
         * Parametros de salida: Continente
         */
    	Continente continente = null;
    	switch(id) {
    	case 1:
    		continente=Continente.Africa;
    		break;
    	case 2:
    		continente=Continente.America;
    		break;
    	case 3:
    		continente=Continente.Asia;
    		break;
    	case 4:
    		continente=Continente.Europa;
    		break;
    	case 5:
    		continente=Continente.Oceania;
    		break;
    	}
    	return continente;
    }

	public static ArrayList<Ciudad> ciudadesContinente(Continente continente) {
    	/*
         * Descripcion del metodo: El método se encarga de filtrar todas las ciudades disponibles para guardar en una lkista las ciudades que pertenecen a determinado continente
         * Parametros de entrada: continente del tipo Continente
         * Parametros de salida: ArrayList<Ciudad>
         */
		ArrayList<Ciudad> listaCompleta = Ciudad.getListaCiudades();
		ArrayList<Ciudad> listaDisponibles = new ArrayList<Ciudad>();
		for (Ciudad ciudad : listaCompleta) {
			if (ciudad.getContinente() == continente) {
				listaDisponibles.add(ciudad);
			}
		}
		return listaDisponibles;
	}

	public void estadia(Carrera carrera) {
    	/*
         * Descripcion del metodo: El método se encarga de calcular el costo de la estadía de un equipo en la ciudad donde se llevará a cabo la carera y restar ese costo al dinero que tiene disponible el equipo
         * Parametros de entrada: carrera del tipo Carrera
         * Parametros de salida: null
         */
		Campeonato campeonato = carrera.getCampeonato();
		for (Equipo equipo : campeonato.getListaEquipos()) {
			double precio = carrera.getCiudad().getPrecioEstadia() * equipo.getCrewMembers();
			this.host.setDinero(this.host.getPlata() - precio);
		}
	}

	public void hostRosca(Carrera carrera) {
    	/*
         * Descripcion del metodo: El método se encarga de filtrar los equipos cuyos patrocinadores tienen como ciudad preferida la ciudad en donde se desarrolla determinada carrera, y los establece como equipos beneficiados
         * Parametros de entrada: carrera del tipo Carrera
         * Parametros de salida: null
         */
		Campeonato campeonato = carrera.getCampeonato();
		ArrayList<Equipo> equipos = campeonato.getListaEquipos();
		ArrayList<Equipo> equiposBeneficiados = new ArrayList<Equipo>();
		for (Equipo equipo : campeonato.getListaEquipos()) {
			if (equipo.getPatrocinadoresEquipo().contains(this.host)) {
				equiposBeneficiados.add(equipo);
			}
		}
		carrera.setEquiposBeneficiados(equiposBeneficiados);
	}

	public void redondear() {
		this.precioEstadia = dosDecimales(this.precioEstadia);
	}

	{
		this.redondear();
	}

    // Lista de metodos set y get
    public String getNombre() {return this.nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Continente getContinente() {return this.continente;}
    public void setContinente(Continente continente) {this.continente = continente;}

	public static void setListaCiudades(ArrayList<Ciudad> listaCiudades) {
		Ciudad.listaCiudades = listaCiudades;
	}

	public Patrocinador getHost() {
		return host;
	}

	public void setHost(Patrocinador host) {
		this.host = host;
	}

	public double getPrecioEstadia() {
		return precioEstadia;
	}

	public void setPrecioEstadia(double precioEstadia) {
		this.precioEstadia = precioEstadia;
	}

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ciudad miClase = (Ciudad) o;
		return nombre.equals(miClase.nombre) ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

}
