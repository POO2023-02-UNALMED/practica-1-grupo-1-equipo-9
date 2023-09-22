package gestorAplicación.campeonato;

import java.util.*;

public class Campeonato {
	// Atributos
	private int id;
	private String nombre;
	private int ano;
	private Continente continente;
	private int numCarreras;
	private int premio;
	private static ArrayList<Carrera> listaCarreras;
	private static ArrayList<Equipo> listaEquipos;
	
	// Lista de campeonatos
	private static ArrayList<Campeonato> campeonatos;
	
	// Lista de continentes
	enum Continente {
		África,
		América,
		Asia,
		Europa,
		Oceanía}
	
	// Métodos de instancia
	
	
	// Métodos de clase
	
	
	// Lista de métodos set y get
	public void setId(int id) {this.id = id;}
	public int getId() {return this.id;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getNombre() {return this.nombre;}
	
	public void setAno(int ano) {this.ano = ano;}
	public int getAno() {return this.ano;}
	
	public void setContinente(Continente continente) {this.continente = continente;}
	public Continente getContinente() {return this.continente;}
	
	public void setNumCarreras(int numCarreras) {this.numCarreras = numCarreras;}
	public int getNumCarreras() {return this.numCarreras;}
	
	public void setPremio(int premio) {this.premio = premio;}
	public int getPremio() {return this.premio;}
	
	public static ArrayList<Carrera> getListaCarreras() {return listaCarreras;}
	
	public static ArrayList<Equipo> getListaEquipos() {return listaEquipos;}
	
	public static ArrayList<Campeonato> getCampeonatos() {return campeonatos;}
}
