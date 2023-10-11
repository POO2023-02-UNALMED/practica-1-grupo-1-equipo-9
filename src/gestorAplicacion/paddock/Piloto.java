package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.Equipo;
import gestorAplicacion.campeonato.Campeonato;
import java.io.Serializable;
import java.util.ArrayList;

public class Piloto extends Persona implements Serializable{
	private static final long serialVersionUID = 2266843321181044951L;
	
	private Equipo equipo;
    private int puntos; //Puntos en el campeonato 
    private int sanciones;
    private double habilidad; //Probabilidad de chocarse
    private boolean disponible;
    public static Piloto pilotoElegido; //Este es el piloto que tiene el usuario
    private ArrayList<String> victorias;
    //Lista de pilotos
	public static ArrayList<Piloto> listaPilotos = new ArrayList<Piloto>();


    //Constructores
    public Piloto(String nombre, String pais, Equipo equipo, double habilidad) {
    	super(nombre,pais);
    	this.equipo=equipo;
    	this.habilidad=habilidad;
    	equipo.agregarPiloto(this);
    	Piloto.listaPilotos.add(this);
    }
    
    //Atributos de instancia
    public void sumarPuntos(int puntos) {
    	this.puntos+=puntos;
    }
    
    public void agregarVictoria(Campeonato campeonato) {
    	victorias.add(campeonato.toString());
    }

    //Metodo abstracto heredado
    public void recibirPlata(double plata){
        this.getEquipo().setPlata(this.getEquipo().getPlata()+plata);
    }
    
    //Atributos de clase 
    
    // Lista de m�todos set y get
    public Equipo getEquipo() {return this.equipo;}
    public void setEquipo(Equipo equipo) {this.equipo = equipo;}

    public int getPuntos() {return this.puntos;}
    public void setPuntos(int puntos) {this.puntos = puntos;}

    public int getSanciones() {return this.sanciones;}
    public void setSanciones(int sanciones) {this.sanciones = sanciones;}

    public double getHabilidad() {return this.habilidad;}
    public void setHabilidad(double hab) {this.habilidad = hab;}

    public boolean isDisponible() {return this.disponible;}
    public void setDisponible(boolean disp) {this.disponible = disp;}

    public ArrayList<String> getVictorias() {return victorias;}
    
    public static ArrayList<Piloto> getListaPilotos() {return Piloto.listaPilotos;}

}
