package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.*;

import java.util.*;

public class Circuito implements java.io.Serializable, Decimales{
    /***
     * Autores: David Toro Arboleda, Santiago Lopez Ayala, Juan Andres Jimenez Velez, Mariana Valencia Cubillos, Samuel Mira Alvarez
     * Descripcion de la clase: La clase "Circuito" facilita la creacion y asignacion de atributos esenciales para cada uno de los circuitos requeridos en el campeonato de carreras. Estos atributos incluyen detalles como el precio, nombre y ubicacion geografica de cada circuito. Esta informacion es crucial para la gestion y organizacion de las carreras, permitiendo una representacion precisa y detallada de los distintos escenarios en los que se llevan a cabo las carreras del campeonato.
     */
	private static final long serialVersionUID = 6748994374640828496L;

    private static int idActual = 0;
    private int id = idActual++;
	
	public static ArrayList<Circuito> circuitos = new ArrayList<Circuito>();
    private String nombre;
    private double Precio;
    private ArrayList<Continente> continentes = new ArrayList<Continente>();
    private ArrayList<Integer> disponibilidad = new ArrayList<Integer>();


    //constructor
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


    //constructor
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
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de circuitos de un campeonato dependiendo su ubicacion
         * Parametros de entrada:  campeonato de tipo Campeonato
         * Parametros de salida: ArrayList<Circuito>
         */
        ArrayList<Circuito> circuitosUbicacion = new ArrayList<Circuito>();
        for (Circuito circuito : circuitos) {
            if (circuito.getContinentes().contains(campeonato.getContinente())) {
                circuitosUbicacion.add(circuito);
            }
        }
        return circuitosUbicacion;
    }
    public static ArrayList<Circuito> circuitosVender(DirectorCarrera dir, ArrayList<Circuito> circuitosDisponibles){
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de circuitos que el director de carrera puede comprar en base a su plata
         * Parametros de entrada:  dir de tipo DirectorCarrera y circuitos de tipo ArrayList<Circuito>
         * Parametros de salida: ArrayList<Circuito>
         */
        ArrayList<Circuito> circuitosVender = new ArrayList<Circuito>();
        for (Circuito circuito : circuitosDisponibles) {
            if (dir.getPlata() >= circuito.getPrecio()) {
                circuitosVender.add(circuito);
            }
        }
        return circuitosVender;
    }

    public static ArrayList<Circuito> circuitosDisponibles(int mes, ArrayList<Circuito> circuitos){
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de circuitos que esten en el mismo mes
         * Parametros de entrada:  mes de tipo int y circuitos de tipo ArrayList<Circuito>
         * Parametros de salida: ArrayList<Circuito>
         */
        ArrayList<Circuito> circuitosDisponibles = new ArrayList<Circuito>();
        for (Circuito circuito : circuitos) {
            if (circuito.verDisponibilidad(mes)) {
                circuitosDisponibles.add(circuito);
            }
        }
        return circuitosDisponibles;
    }

    public void venderCircuito(DirectorCarrera dir, int mes){
        /***
         * Descripcion del metodo: este metodo se encarga de asignar un mes para el cirtuito y de actualizar el dinero del director de carrera luego de la compra del circuito
         * Parametros de entrada: dir de tipo Director Carrera y mes de tipo int
         * Parametros de salida: void
         */
        dir.setPlata(dir.getPlata() - this.getPrecio());
        this.getDisponibilidad().removeIf(num -> num == mes);
    }

    public void redondear() {
        this.Precio = dosDecimales(this.Precio);
    }

    {
        this.redondear();
    }

    //setters n getters
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

    public static int getIdActual() {
        return idActual;
    }

    public static void setIdActual(int idActual) {
        Circuito.idActual = idActual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        Circuito.random = random;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circuito miClase = (Circuito) o;
        return id == miClase.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
