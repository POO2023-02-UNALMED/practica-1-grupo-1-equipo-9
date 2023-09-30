package gestorAplicacion.campeonato;

import java.util.ArrayList;
import gestorAplicacion.campeonato.Ciudad.Continente;

public class Carrera {
    // Atributos
    private static int idActual=1;
	private int id;
    private String nombreCircuito;
    private int mes;
    private double distancia;
    private double premioEfectivo;
    private Ciudad ciudad;
    private DirectorCarrera directorCarrera;
    private static Campeonato campeonato;
    private double clima; //.05 soleado, .10 lluvia, .15 tormenta (esto es muerte)
    private double dificultad;
    
    private ArrayList<VehiculoCarrera> posiciones = new ArrayList<VehiculoCarrera>();
    
    //Constructores
    public Carrera(String nombre, int mes, double distancia, double premio, Ciudad ciudad, DirectorCarrera director, double clima, double dificultad) {
    	this.id = idActual;
    	Carrera.idActual++;
    	this.nombreCircuito=nombre;
    	this.mes=mes;
    	this.distancia=distancia;
    	this.premioEfectivo=premio;
    	this.ciudad=ciudad;
    	this.directorCarrera=director;
    	this.clima=clima;
    	this.dificultad=dificultad;
    	
    }
    
    //Metodos de instancia
    public void iniciarCarrera() {}
    
    //Metodos de clase
    public static ArrayList<Ciudad> mostrarCiudadesDisponibles() {
    	ArrayList<Ciudad> listaCompleta = Ciudad.getListaCiudades();
    	Continente continente = campeonato.getContinente();
    	ArrayList <Ciudad> listaDisponibles = new ArrayList<Ciudad>(); 
    	for (Ciudad ciudad: listaCompleta){
    		if (ciudad.getContinente()== continente){listaDisponibles.add(ciudad);}
    	}
    	return listaDisponibles;
    }

   
    // Lista de metodos set y get
    public int getId() {return this.id;}
    public void setId(int id) {this.id = id;}

    public int getMes() {return this.mes;}
    public void setMes(int mes) {this.mes = mes;}

    public String getNombreCircuito() {return this.nombreCircuito;}
    public void setNombreCircuito(String nombre) {this.nombreCircuito = nombre;}

    public double getDistancia() {return this.distancia;}
    public void setDistancia(double distancia) {this.distancia = distancia;}

    public double getPremioEfectivo() {return this.premioEfectivo;}
    public void setPremioEfectivo(double premio) {this.premioEfectivo = premio;}

    public DirectorCarrera getDirectorCarrera() {return this.directorCarrera;}
    public void setDirectorCarrera(DirectorCarrera director) {this.directorCarrera = director;}

    public static Campeonato getCampeonato() {return campeonato;}
    public static void setCampeonato(Campeonato campeonatico) {campeonato = campeonatico;}

    public Ciudad getCiudad() {return this.ciudad;}
    public void setCiudad(Ciudad ciudad) {this.ciudad = ciudad;}

    public double getClima() {return this.clima;}
    public void setClima(double clima) {this.clima = clima;}

    public double getDificultad() {return this.dificultad;}
    public void setDificultad(double dificultad) {this.dificultad = dificultad;}

    public ArrayList<VehiculoCarrera> getPosiciones() {return posiciones;}
    


}
