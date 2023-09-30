package gestorAplicacion.campeonato;

import java.util.ArrayList;

public class Campeonato {
    private static ArrayList<Carrera> listaCarreras;
    private static ArrayList<Equipo> listaEquipos;
    // Lista de campeonatos
    private static ArrayList<Campeonato> campeonatos;
    // Atributos
    private int id;
    private String nombre;
    private int ano;
    private Continente continente;
    private int numCarreras;
    private int premio;

    public static ArrayList<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    // Métodos de instancia


    // Métodos de clase

    public static ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public static ArrayList<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public int getId() {
        return this.id;
    }

    // Lista de métodos set y get
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Continente getContinente() {
        return this.continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    public int getNumCarreras() {
        return this.numCarreras;
    }

    public void setNumCarreras(int numCarreras) {
        this.numCarreras = numCarreras;
    }

    public int getPremio() {
        return this.premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }

    // Lista de continentes
    enum Continente {
        Africa, America, Asia, Europa, Oceania
    }
}
