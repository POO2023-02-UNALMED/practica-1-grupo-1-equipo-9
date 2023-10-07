package gestorAplicacion.campeonato;

import java.util.ArrayList;

public class Ciudad {
    //Lista de las ciudades
	static ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>();
	
	//Atributos
    private String nombre;
    private Continente continente;
	private Carrera carrera;
    
    //Constructores
    public Ciudad(String nombre, Continente continente) {
    	this.nombre=nombre;
    	this.continente=continente;
		Ciudad.listaCiudades.add(this);
    	}
    
    //Metodos de instancia
    public String toString() {
    	return this.nombre;
    }
    
    //Metodos de clase
    public static ArrayList<Ciudad> getListaCiudades() {
    	return listaCiudades;
    }
    public static Continente convertirContinente(char id) { //Convierte un caracter del 1 al 5 en su continente correspondiente 
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

	public static ArrayList<Ciudad> mostrarCiudadesDisponibles(Continente continente) {
		ArrayList<Ciudad> listaCompleta = Ciudad.getListaCiudades();
		ArrayList<Ciudad> listaDisponibles = new ArrayList<Ciudad>();
		for (Ciudad ciudad : listaCompleta) {
			if (ciudad.getContinente() == continente) {
				listaDisponibles.add(ciudad);
			}
		}
		return listaDisponibles;
	}

    // Lista de metodos set y get
    public String getNombre() {return this.nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Continente getContinente() {return this.continente;}
    public void setContinente(Continente continente) {this.continente = continente;}

	public static void setListaCiudades(ArrayList<Ciudad> listaCiudades) {
		Ciudad.listaCiudades = listaCiudades;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	// Lista de continentes
    public enum Continente {
        Africa, America, Asia, Europa, Oceania
    }
}
