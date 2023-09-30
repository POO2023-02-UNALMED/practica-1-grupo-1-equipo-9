package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Patrocinador;
import gestorAplicacion.paddock.Piloto;
import gestorAplicacion.paddock.Vehiculo;

import java.util.ArrayList;
import java.util.Random;

public class Equipo {

    static ArrayList<Equipo> equipos = new ArrayList<Equipo>();
    static int idActual = 0;
    private int id;
    private String nombre;
    private String pais;
    private double plata;
    private int puntos;
    private ArrayList<Vehiculo> vehiculosDisponibles = new ArrayList<Vehiculo>(); // Lista de vehículos disponibles
    private ArrayList<Piloto> pilotosDisponibles = new ArrayList<Piloto>(); // Lista de pilotos disponibles
    private Piloto piloto1;
    private Piloto piloto2;

    // Constructores
    public Equipo() {
        this.id = idActual++;
        this.nombre = "";
        this.pais = "";
        this.plata = 0;
        this.puntos = 0;
        this.vehiculosDisponibles = null;
        this.pilotosDisponibles = null;
        this.piloto1 = null;
        this.piloto2 = null;
        Equipo.equipos.add(this);
    }

    public Equipo(String nombre, String pais, double plata, int puntos, ArrayList<Vehiculo> vehiculosDisponibles, ArrayList<Piloto> pilotosDisponibles) {
        this.id = idActual++;
        this.nombre = nombre;
        this.pais = pais;
        this.plata = plata;
        this.puntos = puntos;
        this.vehiculosDisponibles = vehiculosDisponibles;
        this.pilotosDisponibles = pilotosDisponibles;
        this.piloto1 = null;
        this.piloto2 = null;
        Equipo.equipos.add(this);
    }

    // Métodos de clase
    public static ArrayList<Equipo> getEquipos() {
        return null;
    }

    public static void setEquipos(ArrayList<Equipo> equipos) {
        Equipo.equipos = equipos;
    }

    // Métodos de instancia
    public boolean negociar(double cantidad, Patrocinador patrocinador) {
        double probabilidad = patrocinador.getProbAceptar(); // Probabilidad de aceptar
        Random random = new Random(); // Generador de números aleatorios
        double numeroRandom = random.nextDouble(); // Número aleatorio entre 0 y 1
        if (numeroRandom < probabilidad) { // Si el número aleatorio es menor a la probabilidad de aceptar
            patrocinador.setDinero(patrocinador.getDinero() - cantidad);
            this.setPlata(this.getPlata() + cantidad);
            return true;
        } else {
            return false;
        }
    }

    //Metodos de instancia
    //Sobrecarga para negociar con probabilidad
    public boolean negociar(double cantidad, Patrocinador patrocinador, double probabilidad) {
        probabilidad = probabilidad + patrocinador.getProbAceptar(); // Probabilidad de aceptar
        Random random = new Random();   // Generador de números aleatorios
        double numeroRandom = random.nextDouble(); // Número aleatorio entre 0 y 1
        if (numeroRandom < probabilidad) { // Si el número aleatorio es menor a la probabilidad de aceptar
            patrocinador.setDinero(patrocinador.getDinero() - cantidad);
            this.setPlata(this.getPlata() + cantidad);
            return true;
        } else {
            return false;
        }
    }

    public boolean bajarPatrocinio(double cantidad, Patrocinador patrocinador) {
        return this.negociar(cantidad, patrocinador, 0.3); // Aumenta probabilidad de aceptar
    }

    public boolean subirPatrocinio(double cantidad, Patrocinador patrocinador) {
        return this.negociar(cantidad, patrocinador, -0.2); // Disminuye probabilidad de aceptar
    }

    public Piloto elegirPiloto1(int id) {
        return null;
    }

    public Piloto elegirPiloto2(int id) {
        return null;
    }

    public void agregarPiloto(Piloto piloto) {
        this.pilotosDisponibles.add(piloto);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculosDisponibles.add(vehiculo);
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

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getPlata() {
        return this.plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public ArrayList<Vehiculo> getVehiculosDisponibles() {
        return this.vehiculosDisponibles;
    }

    public ArrayList<Piloto> getPilotosDisponibles() {
        return this.pilotosDisponibles;
    }

    public Piloto getPiloto1() {
        return this.piloto1;
    }

    public void setPiloto1(Piloto piloto1) {
        this.piloto1 = piloto1;
    }

    public Piloto getPiloto2() {
        return this.piloto2;
    }

    public void setPiloto2(Piloto piloto2) {
        this.piloto2 = piloto2;
    }


}
