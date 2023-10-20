package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.*;

import java.util.*;

public class Circuito implements java.io.Serializable, Decimales{

    public static ArrayList<Circuito> circuitos = new ArrayList<Circuito>();
    private String nombre;
    private double Precio;
    private ArrayList<Continente> continentes = new ArrayList<Continente>();
    private ArrayList<Integer> disponibilidad = new ArrayList<Integer>();

    public Circuito(String nombre, double precio, ArrayList<Continente> continente) {
    	this.nombre=nombre;
    	this.Precio=precio;
    	this.continentes=continente;
        // disponibilidad es una lista del 1 al 12
        for (int i = 1; i <= 12; i++) {
            disponibilidad.add(i);
        }
        circuitos.add(this);
    }



    public Circuito(String nombre){
        this.nombre = nombre;
        this.Precio = (double) (random.nextInt(40001) + 10000) /3;
        // elegir 3 continentes al azar;
        ArrayList<Continente> continentes = new ArrayList<Continente>();
        for (int i = 0; i < 3; i++) {
            Continente continente = Continente.values()[random.nextInt(5)];
            if (!continentes.contains(continente)) {
                continentes.add(continente);
            }
        }
        this.continentes = continentes;
        // disponibilidad es una lista del 1 al 12
        for (int i = 1; i <= 12; i++) {
            disponibilidad.add(i);
        }
        circuitos.add(this);
    }

    public static ArrayList<Circuito> circuitosUbicacion(Campeonato campeonato){
        ArrayList<Circuito> circuitosUbicacion = new ArrayList<Circuito>();
        for (Circuito circuito : circuitos) {
            if (circuito.getContinentes().contains(campeonato.getContinente())) {
                circuitosUbicacion.add(circuito);
            }
        }
        return circuitosUbicacion;
    }
    public static ArrayList<Circuito> circuitosVender(DirectorCarrera dir, ArrayList<Circuito> circuitosDisponibles){
        ArrayList<Circuito> circuitosVender = new ArrayList<Circuito>();
        for (Circuito circuito : circuitosDisponibles) {
            if (dir.getPlata() >= circuito.getPrecio()) {
                circuitosVender.add(circuito);
            }
        }
        return circuitosVender;
    }

    public static ArrayList<Circuito> circuitosDisponibles(int mes, ArrayList<Circuito> circuitos){
        ArrayList<Circuito> circuitosDisponibles = new ArrayList<Circuito>();
        for (Circuito circuito : circuitos) {
            if (circuito.verDisponibilidad(mes)) {
                circuitosDisponibles.add(circuito);
            }
        }
        return circuitosDisponibles;
    }


    public void venderCircuito(DirectorCarrera dir, int mes){
        dir.setPlata(dir.getPlata() - this.getPrecio());
        this.getDisponibilidad().removeIf(num -> num == mes);
    }

    public void redondear() {
        this.Precio = dosDecimales(this.Precio);
    }

    {
        this.redondear();
    }

    public boolean verDisponibilidad(int dia) {
        return disponibilidad.contains((Integer) dia);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public ArrayList<Integer> getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(ArrayList<Integer> disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public static ArrayList<Circuito> getCircuitos() {
        return circuitos;
    }

    public static void setCircuitos(ArrayList<Circuito> circuitos) {
        Circuito.circuitos = circuitos;
    }

    public ArrayList<Continente> getContinentes() {
        return continentes;
    }

    public void setContinentes(ArrayList<Continente> continentes) {
        this.continentes = continentes;
    }

    static Random random = new Random();
}
