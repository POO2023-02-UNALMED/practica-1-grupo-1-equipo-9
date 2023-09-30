package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.Equipo;

import java.util.ArrayList;

public class Piloto extends Persona {
    private Equipo equipo;
    private int puntos;
    private int sanciones;
    private double habilidad; //Probabilidad de chocarse
    private boolean disponible;
    private ArrayList<String> victorias;

    public Equipo getEquipo() {
        return this.equipo;
    }

    // Lista de métodos set y get
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getSanciones() {
        return this.sanciones;
    }

    public void setSanciones(int sanciones) {
        this.sanciones = sanciones;
    }

    public double getHabilidad() {
        return this.habilidad;
    }

    public void setHabilidad(double hab) {
        this.habilidad = hab;
    }

    public boolean isDisponible() {
        return this.disponible;
    }

    public void setDisponible(boolean disp) {
        this.disponible = disp;
    }

    public ArrayList<String> getVictorias() {
        return victorias;
    }

}
