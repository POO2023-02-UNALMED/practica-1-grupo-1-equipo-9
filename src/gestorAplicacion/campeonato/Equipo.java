package gestorAplicacion.campeonato;

import java.util.*;
import gestorAplicacion.paddock.Piloto;
import gestorAplicacion.paddock.Vehiculo;

public class Equipo {

    static ArrayList<Equipo> equipos = new ArrayList<Equipo>();
    static int idActual = 0;
    private int id;
    private String nombre;
    private String pais;
    private double plata;
    private int puntos;
    private ArrayList<Vehiculo> vehiculosDisponibles = new ArrayList<Vehiculo>();
    private ArrayList<Piloto> pilotosDisponibles = new ArrayList<Piloto>();
    private Piloto piloto1;
    private Piloto piloto2;

    // Métodos de instancia
    public boolean negociar() {

        return false;
    }

    public double bajarPatrocinio() {
        return 0;
    }

    public double subirPatrocinio() {
        return 0;
    }

    public Piloto elegirPiloto1(int id) {
        return null;
    }

    public Piloto elegirPiloto2(int id) {
        return null;
    }

    // Métodos de clase
    public static ArrayList<Equipo> getEquipos() {
        return null;
    }

    // Lista de métodos set y get
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getPais() {
        return this.pais;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }
    public double getPlata() {
        return this.plata;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public int getPuntos() {
        return this.puntos;
    }

    public ArrayList<Vehiculo> getVehiculosDisponibles() {
        return this.vehiculosDisponibles;
    }

    public ArrayList<Piloto> getPilotosDisponibles() {
        return this.pilotosDisponibles;
    }

    public void setPiloto1(Piloto piloto1) {
        this.piloto1 = piloto1;
    }
    public Piloto getPiloto1() {
        return this.piloto1;
    }

    public void setPiloto2(Piloto piloto2) {
        this.piloto2 = piloto2;
    }
    public Piloto getPiloto2() {
        return this.piloto2;
    }

    // Constructor
    public Equipo(String nombre, String pais, double plata, int puntos, ArrayList<Vehiculo> vehiculosDisponibles, ArrayList<Piloto> pilotosDisponibles, Piloto piloto1, Piloto piloto2) {
        this.id = idActual++;
        this.nombre = nombre;
        this.pais = pais;
        this.plata = plata;
        this.puntos = puntos;
        this.vehiculosDisponibles = vehiculosDisponibles;
        this.pilotosDisponibles = pilotosDisponibles;
        this.piloto1 = piloto1;
        this.piloto2 = piloto2;
        Equipo.equipos.add(this);
    }
}
