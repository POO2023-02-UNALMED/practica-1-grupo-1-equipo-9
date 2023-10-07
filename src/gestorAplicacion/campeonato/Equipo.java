package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Patrocinador;
import gestorAplicacion.paddock.Piloto;
import gestorAplicacion.paddock.Vehiculo;

import java.util.ArrayList;
import java.util.Objects;
import java.text.*;

public class Equipo {
    public static ArrayList<Equipo> equipos = new ArrayList<Equipo>(); //Lista de equipos

    //Atributos
    static int idActual = 0;
    private int id;
    private String nombre;
    private String pais;
    private double plata;
    private int puntos; //TODO: Preguntar si los puntos son generales (serializados) o son unicos a cada campeonato y luego se borran
    private ArrayList<Vehiculo> vehiculosDisponibles = new ArrayList<Vehiculo>(); // Lista de veh�culos disponibles
    public static Equipo equipoElegido; //Este es el equipo que tiene el ususario
    private ArrayList<Piloto> pilotosDisponibles = new ArrayList<Piloto>(); // Lista de pilotos disponibles
    private Piloto piloto1;
    private Piloto piloto2;
    private ArrayList<Patrocinador> patrocinadoresEquipo = new ArrayList<Patrocinador>(); //Lista de patrocinadores que patrocinan al equipo TODO: Perdon, toque tu clase :,(

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

    public Equipo(String nombre, String pais) {
        this.id = idActual++;
        this.nombre = nombre;
        this.pais = pais;
        this.plata = 0;
        this.puntos = 0;
        Equipo.equipos.add(this);
    }

    public Equipo(String nombre, String pais, double plata, int puntos, ArrayList<Vehiculo> vehiculosDisponibles, ArrayList<Piloto> pilotosDisponibles) {
        this.id = idActual++;
        this.nombre = nombre;
        this.pais = pais;
        this.plata = plata;
        this.puntos = puntos;
        Equipo.equipos.add(this);
        if (vehiculosDisponibles != null) {
            this.vehiculosDisponibles = vehiculosDisponibles;
        } else {
            this.vehiculosDisponibles = new ArrayList<Vehiculo>();
        }
        this.pilotosDisponibles = Objects.requireNonNullElseGet(pilotosDisponibles, ArrayList::new);
    }

    // M�todos de clase
    public static ArrayList<Equipo> getEquipos() {
        return null;
    }

    public static void setEquipos(ArrayList<Equipo> equipos) {
        Equipo.equipos = equipos;
    }

    // M�todos de instancia
    public boolean negociar(Patrocinador patrocinador) {
        //Esto es para aceptar las probabilidades de que acepte un patrocinador
        return patrocinador.pensarNegocio(this);
    }

    public String negociar(double cantidad, Patrocinador patrocinador) {//Sobrecarga para cambiar el dinero que se le pide al patrocinador. A menor cantidad, mayor probabilidad de aceptar.
        if (cantidad < 0) {
            //System.out.println("Esa es una cantidad de dinero negativa. �Acaso piensas en patrocinar al patrocinador?");
            return "Esa es una cantidad de dinero negativa. �Acaso piensas en patrocinar al patrocinador?";
        } else if (cantidad == 0) {
            //System.out.println("�Por qu� 0? �Es que no quieres dinero?");
            return "�Por qu� 0? �Es que no quieres dinero?";
        } else if (cantidad > patrocinador.getDinero()) {
            patrocinador.setPatrocinando(true);
            //System.out.println("�Eso es m�s dinero del que puede dar! \n!Has asustado al patrocinador!");
            return "�Eso es m�s dinero del que puede dar! \n!Has asustado al patrocinador!";
        } else {
            this.negociar(patrocinador);
            return "�Se ha evaluado la opcion de patrocinar a tu equipo!";
        }
    }


    public void negociar(Patrocinador patrocinador, boolean equipoNoElegido) {
        //Sobrecarga: Esto es para ver si alg�n equipo que no es elegido por el usuario es patrocinado por alg�n patrocinador
        patrocinador.pensarNegocio(this, equipoNoElegido);
    }

    public String toString() {
        return (this.nombre + " P1: " + this.piloto1.getNombre() + " P2: " + this.piloto2.getNombre());
    }

    public void agregarPiloto(Piloto piloto) {
        this.pilotosDisponibles.add(piloto);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculosDisponibles.add(vehiculo);
    }


    // Lista de m�todos set y get
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
        double decimales = Math.round(plata * 100.0) / 100.0;
        this.plata = decimales;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public ArrayList<Vehiculo> getVehiculosDisponibles() {
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

    public ArrayList<Patrocinador> getPatrocinadoresEquipo() {
        return patrocinadoresEquipo;
    }

    public void setPatrocinadoresEquipo(ArrayList<Patrocinador> patrocinadoresEquipo) {
        this.patrocinadoresEquipo = patrocinadoresEquipo;
    }


}
