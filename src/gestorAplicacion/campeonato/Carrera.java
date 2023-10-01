package gestorAplicacion.campeonato;

import java.util.ArrayList;
import gestorAplicacion.campeonato.Ciudad.Continente;
import java.util.Random;

public class Carrera {
    //Atributos
    private static int idActual=1;
	private int id;
    private String nombreCircuito;
    private int mes; //El mes determina el orden de la carrera
    private double distancia; //Distancia de la carrera
    private double premioEfectivo; //Este premio se distribuye entre los 3 primeros puestos
    private Ciudad ciudad;
    private DirectorCarrera directorCarrera; 
    private static Campeonato campeonato;
    private double clima; //.05 soleado, .10 lluvia, .15 tormenta, se le suma a la probabilidad de chocarse del vehiculo
    private double dificultad; //Se le suma a la probabilidad de chocarse del vehiculo
    
    private ArrayList<VehiculoCarrera> posiciones = new ArrayList<VehiculoCarrera>();
    
    //Constructores
    public Carrera(String nombre, int mes, double distancia, double premio, Ciudad ciudad, DirectorCarrera director, double dificultad) {
    	this.id = idActual;
    	Carrera.idActual++;
    	this.nombreCircuito=nombre;
    	this.mes=mes;
    	this.distancia=distancia;
    	this.premioEfectivo=premio;
    	this.ciudad=ciudad;
    	this.directorCarrera=director;
    	this.dificultad=dificultad;
    	Random rand = new Random();
    	double lowerBound=0.0;
    	double upperBound=0.2;
    	double numRandom=lowerBound+(upperBound-lowerBound)*rand.nextDouble();
    	this.clima=numRandom; //Se le asiga un valor aleatorio entre 0.0 y 0.2 al clima
    }
    
    //Metodos de instancia
    public void iniciarCarrera() {}//Inicializa la carrera
    
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
