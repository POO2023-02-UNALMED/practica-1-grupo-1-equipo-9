package gestorAplicacion.paddock;

import java.util.*;
import gestorAplicacion.campeonato.*;

public class Piloto extends Persona {
	private Equipo equipo;
	private int puntos;
	private int sanciones;
	private double habilidad; //Probabilidad de chocarse
	private boolean disponible;
	private ArrayList<String> victorias;

	// Lista de métodos set y get
	public void setEquipo(Equipo equipo) {this.equipo = equipo;}
	public Equipo getEquipo() {return this.equipo;}
	
	public void setPuntos(int puntos) {this.puntos = puntos;}
	public int getPuntos() {return this.puntos;}
	
	public void setSanciones(int sanciones) {this.sanciones = sanciones;}
	public int getSanciones() {return this.sanciones;}
	
	public void setHabilidad(double hab) {this.habilidad = hab;}
	public double getHabilidad() {return this.habilidad;}
	
	public void setDisponible(boolean disp) {this.disponible = disp;}
	public boolean isDisponible() {return this.disponible;}
	
	public ArrayList<String> getVictorias() {return victorias;}
}
