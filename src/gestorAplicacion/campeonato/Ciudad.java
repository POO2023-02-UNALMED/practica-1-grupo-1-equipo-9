package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Patrocinador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Ciudad implements Serializable, Decimales{
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
    public static Continente convertirContinente(int id) { //Convierte un caracter del 1 al 5 en su continente correspondiente
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
		Campeonato campeonato = carrera.getCampeonato();
		for (Equipo equipo : campeonato.getListaEquipos()) {
			double precio = carrera.getCiudad().getPrecioEstadia() * equipo.getCrewMembers();
			this.host.setDinero(this.host.getPlata() - precio);
		}
	}

	public void hostRosca(Carrera carrera) {
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
}
