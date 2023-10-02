package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Patrocinador;
import gestorAplicacion.paddock.Piloto;
import gestorAplicacion.paddock.Vehiculo;

import java.util.ArrayList;
import java.util.Random;

public class Equipo {

    static ArrayList<Equipo> equipos = new ArrayList<Equipo>(); //Lista de equipos
    static int idActual = 0;
    private int id;
    private String nombre;
    private String pais;
    private double plata;
    private int puntos;
    private static ArrayList<Vehiculo> vehiculosDisponibles = new ArrayList<Vehiculo>(); // Lista de vehículos disponibles
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
    public void negociar(Patrocinador patrocinador) {//Esto es para aceptar las probabilidades de que acepte un patrocinador
    	boolean patrocinado=patrocinador.pensarNegocio(this);
    	if (patrocinado) {System.out.println("¡Se ha patrocinado a tu equipo!");} 
    	else {System.out.println("No se ha patrocinado a tu equipo :(");}
    }
    
    public void negociar(double cantidad, Patrocinador patrocinador) {//Sobrecarga para cambiar el dinero que se le pide al patrocinador. A menor cantidad, mayor probabilidad de aceptar.
        if (cantidad<0) {System.out.println("Esa es una cantidad de dinero negativa. ¿Acaso piensas en patrocinar al patrocinador?");} 
        else if (cantidad==0) {System.out.println("¿Por qué 0? ¿Es que no quieres dinero?");}
        else if (cantidad>patrocinador.getDinero()){
        	patrocinador.setPatrocinando(true);
        	System.out.println("¡Eso es más dinero del que puede dar! \n!Has asustado al patrocinador!");
        	}
        else {this.negociar(patrocinador);} 
    }
    
    public void negociar(Patrocinador patrocinador, boolean equipoNoElegido) {//Sobrecarga: Esto es para ver si algún equipo que no es elegido por el usuario es patrocinado por algún patrocinador
    	patrocinador.pensarNegocio(this);
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

    public static void agregarVehiculo(Vehiculo vehiculo) {
        vehiculosDisponibles.add(vehiculo);
    }



    // Lista de métodos set y get
    public int getId() {
        return this.id;
    }
    
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

    public static ArrayList<Vehiculo> getVehiculosDisponibles() {
        return vehiculosDisponibles;
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
