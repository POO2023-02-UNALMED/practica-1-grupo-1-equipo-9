package gestorAplicacion.campeonato;

import java.util.*;

public class Carrera {
	// Atributos
	private int id;
	private int mes;
	private String nombreCircuito;
	private double distancia;
	private double premioEfectivo;
	private Ciudad ciudad;
	private DirectorCarrera directorCarrera;
	private Campeonato campeonato;
	private double clima; //.05 soleado, .10 lluvia, .15 tormenta (esto es muerte)
	private double dificultad;
	private ArrayList<VehiculoDeCarrera> posiciones;

	
	
	// Lista de métodos set y get
	public void setId(int id) {this.id = id;}
	public int getId() {return this.id;}
	
	public void setMes(int mes) {this.mes = mes;}
	public int getMes() {return this.mes;}
	
	public void setNombreCircuito(String nombre) {this.nombreCircuito = nombre;}
	public String getNombreCircuito() {return this.nombreCircuito;}
	
	public void setDistancia(double distancia) {this.distancia = distancia;}
	public double getDistancia() {return this.distancia;}
	
	public void setPremioEfectivo(double premio) {this.premioEfectivo = premio;}
	public double getPremioEfectivo() {return this.premioEfectivo;}
	
	public void setDirectorCarrera(DirectorCarrera director) {this.directorCarrera = director;}
	public DirectorCarrera getDirectorCarrera() {return this.directorCarrera;}
	
	public void setCampeonato(Campeonato campeonato) {this.campeonato = campeonato;}
	public Campeonato getCampeonato() {return this.campeonato;}
	
	public void setCiudad(Ciudad ciudad) {this.ciudad = ciudad;}
	public Ciudad getCiudad() {return this.ciudad;}
	
	public void setClima(double clima) {this.clima = clima;}
	public double getClima() {return this.clima;}
	
	public void setDificultad(double dificultad) {this.dificultad = dificultad;}
	public double getDificultad() {return this.dificultad;}
	
	public ArrayList<VehiculoDeCarrera> getListaCarreras() {return posiciones;}
	
	
}
