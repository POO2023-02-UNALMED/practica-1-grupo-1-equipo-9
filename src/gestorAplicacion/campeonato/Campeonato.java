package gestorAplicacion.campeonato;

import java.util.ArrayList;
import java.util.Comparator;

import gestorAplicacion.campeonato.Ciudad.Continente;

public class Campeonato {
    public static ArrayList<Campeonato> campeonatos = new ArrayList<Campeonato>(); //Esta es la lista donde están todos los campeonatos disponibles
	private static ArrayList<Carrera> listaCarreras = new ArrayList<Carrera>(); //Cuando se escoja el campeonato, en esta lista se colocan las carreras
    public static Campeonato campeonatoElegido; //Campeonato que elije el usuario
    
    // Atributos
    private static int idActual = 1;
    private int id; 
    private String nombre;
    private int ano; 
    private Continente continente; //Cada campeonato tiene un continente diferente
    private int cantidadMaxCarreras;
    private double premio; //Premio total que se lleva el equipo cuando se gana el campeonato


    //Constructores
    public Campeonato(String nombre, int ano, Continente continente, int cantCarreras) { //Cuando se inicialice cada campeonato, se le pasa el nombre y el continente
    	this.id = idActual;
    	Campeonato.idActual++;
    	this.nombre = nombre;
    	this.ano = ano;
    	this.continente = continente;
    	this.cantidadMaxCarreras = cantCarreras;
        campeonatos.add(this);
    }
    // Sin ano
    public Campeonato(String nombre, Continente continente, int cantCarreras) { //Cuando se inicialice cada campeonato, se le pasa el nombre y el continente
        this.id = idActual;
        Campeonato.idActual++;
        this.nombre = nombre;
        this.continente = continente;
        this.cantidadMaxCarreras = cantCarreras;
        campeonatos.add(this);
    }
    
    // Metodos de instancia
    public String toString() {
    	return (this.nombre + " " + this.ano);
    }
    
    public void agregarCarrera(Carrera carrerita) {
    	if (this.getNumCarreras()<this.cantidadMaxCarreras) {
    		this.listaCarreras.add(carrerita);
    	}
//        else {
//    		System.out.println("Se ha alcanzado el máximo número de carreras para el campeonato, no se ha añadido la carrera.");
//    	}
    }

    public static void organizarCarreras(){ //TODO: Verificar que este metodo funcione
        Campeonato.listaCarreras.sort(Comparator.comparing(Carrera::getMes));
    }

    //Metodos de clase    
    public static ArrayList<Campeonato> getCampeonatos() {return campeonatos;}
    
    public static void elegirCampeonato(Campeonato campeonato) {
    	campeonatoElegido = campeonato;
    	Carrera.setCampeonato(campeonato);
    }
    
    public static int getIdActual() {return idActual;}

    //Lista de metodos set y get
    public int getId() {return this.id;}
    public void setId(int id) {this.id = id;}

    public String getNombre() {return this.nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getAno() {return this.ano;}
    public void setAno(int ano) {this.ano = ano;}

    public Continente getContinente() {return this.continente;}
    public void setContinente(Continente continente) {this.continente = continente;}

    public int getCantidadMaxCarreras() {return this.cantidadMaxCarreras;}
    public void setCantidadMaxCarreras(int cantidadCarreras) {this.cantidadMaxCarreras=cantidadCarreras;}
    
    public int getNumCarreras() {return this.listaCarreras.size();}
    
    public double getPremio() {return this.premio;}
    public void setPremio(double premio) {this.premio = premio;}
    
    public ArrayList<Carrera> getListaCarreras() {return listaCarreras;}

    public static void setCampeonatos(ArrayList<Campeonato> campeonatos) {
        Campeonato.campeonatos = campeonatos;
    }

    public void setListaCarreras(ArrayList<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    public static void setIdActual(int idActual) {
        Campeonato.idActual = idActual;
    }

    public static Campeonato getCampeonatoElegido() {
        return campeonatoElegido;
    }

    public static void setCampeonatoElegido(Campeonato campeonatoElegido) {
        Campeonato.campeonatoElegido = campeonatoElegido;
    }
}
