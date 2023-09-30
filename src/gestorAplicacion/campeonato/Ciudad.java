package gestorAplicacion.campeonato;

import java.util.ArrayList;

public class Ciudad {
    //Lista de las ciudades
	static ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>();
	
	//Atributos
    private String nombre;
    private Continente continente;
    
    //Constructores
    public Ciudad(String nombre, Continente continente) {
    	this.nombre=nombre; 
    	this.continente=continente;
    	}
    
    //Metodos de instancia
    public String toString() {
    	return this.nombre;
    }
    
    //Metodos de clase
    public static ArrayList<Ciudad> getListaCiudades() {
    	return listaCiudades;
    }
    public static Continente convertirContinente(char id) {
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

    // Lista de metodos set y get
    public String getNombre() {return this.nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Continente getContinente() {return this.continente;}
    public void setContinente(Continente continente) {this.continente = continente;}


    // Lista de continentes
    enum Continente {
        Africa, America, Asia, Europa, Oceania
    }
}
