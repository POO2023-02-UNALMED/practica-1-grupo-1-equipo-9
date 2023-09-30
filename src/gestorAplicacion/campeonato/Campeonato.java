package gestorAplicacion.campeonato;

import java.util.ArrayList;
import gestorAplicacion.campeonato.Ciudad.Continente;

public class Campeonato {
    // Lista de campeonatos
    static ArrayList<Campeonato> campeonatos = new ArrayList<Campeonato>(); //Esta es la lista donde están todos los campeonatos disponibles
    
	//Listas de carreras y equipos
	private ArrayList<Carrera> listaCarreras = new ArrayList<Carrera>(); //Cuando se escoja el campeonato, en esta lista se colocan las carreras
    private static ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>(); //Los equipos participantes se deben de colocar en esta lista
    
    // Atributos
    private static int idActual = 1;
    private int id; 
    private String nombre;
    private int ano; 
    private Continente continente; //Cada campeonato tiene un continente diferente
    private double premio; //Premio total que se lleva el equipo cuando se gana el campeonato
    public static Equipo equipoElegido; //Este es el equipo que tiene el ususario
    public static Campeonato campeonatoElegido; //Campeonato que elije el usuario


    //Constructores
    public Campeonato(String nombre, Continente continente) { //Cuando se inicialice cada campeonato, se le pasa el nombre y el continente
    	this.id = idActual;
    	Campeonato.idActual++;
    	this.nombre = nombre;
    	this.continente = continente;
    }
    
    // Metodos de instancia
    public String toString() {
    	return (this.nombre + " " + this.ano);
    }
    
    public void agregarCarrera(Carrera carrerita) {
    	this.listaCarreras.add(carrerita);
    }
    

    //Metodos de clase
    public static ArrayList<Equipo> getListaEquipos() {return listaEquipos;}
    
    public static ArrayList<Campeonato> getCampeonatos() {return campeonatos;}
    
    public static void elegirCampeonato(Campeonato campeonato) {
    	campeonatoElegido = campeonato;
    	Carrera.setCampeonato(campeonato);
    }
    
    public static void elegirEquipo(Equipo equipo) {
    	equipoElegido = equipo;
    }
    
    public static int getIdActual() {return idActual;}
    
    public static void setAno(int ano) {
    	for (Campeonato campeonatico : campeonatos) {
    		campeonatico.ano=ano;
    	}
    }

    //Lista de metodos set y get
    public int getId() {return this.id;}
    public void setId(int id) {this.id = id;}

    public String getNombre() {return this.nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getAno() {return this.ano;}
    //public void setAno(int ano) {this.ano = ano;}

    public Continente getContinente() {return this.continente;}
    public void setContinente(Continente continente) {this.continente = continente;}

    public int getNumCarreras() {return this.listaCarreras.size();}
    
    public double getPremio() {return this.premio;}
    public void setPremio(double premio) {this.premio = premio;}
    
    public ArrayList<Carrera> getListaCarreras() {return listaCarreras;}


}
