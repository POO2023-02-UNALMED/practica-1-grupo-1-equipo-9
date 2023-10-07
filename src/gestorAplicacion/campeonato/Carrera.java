package gestorAplicacion.campeonato;

import gestorAplicacion.campeonato.Ciudad.Continente;
import gestorAplicacion.paddock.Circuito;
import gestorAplicacion.paddock.Patrocinador;
import gestorAplicacion.paddock.Vehiculo;

import java.util.*;

public class Carrera {
    public static Carrera carreraActual;     //Carrera actual durante el main

    public static ArrayList<VehiculoCarrera> posiciones = new ArrayList<VehiculoCarrera>(); //Lista de posiciones de los vehiculos

    public static ArrayList<VehiculoCarrera>  terminados= new ArrayList<VehiculoCarrera>(); //Lista de carros que ya terminaron

    //Atributos
    private static int idActual = 1;
    private static Campeonato campeonato;
    private int id;
    private String nombreCircuito;
    private String fecha;
    private int mes; //El mes determina el orden de la carrera
    private double distancia; //Distancia de la carrera
    private double premioEfectivo; //Este premio se distribuye entre los 3 primeros puestos
    private Ciudad ciudad;
    private DirectorCarrera directorCarrera;
    private double clima; //.05 soleado, .10 lluvia, .15 tormenta, se le suma a la probabilidad de chocarse del vehiculo
    private double dificultad; //Se le suma a la probabilidad de chocarse del vehiculo

    private Circuito circuito;

    //Constructores
    public Carrera(String nombre, int mes, double distancia, double premio, Ciudad ciudad, DirectorCarrera director, double dificultad) {
        this.id = idActual;
        Carrera.idActual++;
        this.nombreCircuito = nombre;
        this.mes = mes;
        this.distancia = distancia;
        this.premioEfectivo = premio;
        this.ciudad = ciudad;
        this.directorCarrera = director;
        director.setCarrera(this);
        this.dificultad = dificultad;
        Random rand = new Random();
        double lowerBound = 0.0;
        double upperBound = 0.2;
        this.clima = lowerBound + (upperBound - lowerBound) * rand.nextDouble(); //Se le asiga un valor aleatorio entre 0.0 y 0.2 al clima
    }

    public Carrera(String nombre, int mes, double distancia, double premio, Ciudad ciudad, DirectorCarrera director) {
        this.id = idActual;
        Carrera.idActual++;
        this.nombreCircuito = nombre;
        this.mes = mes;
        this.distancia = distancia;
        this.premioEfectivo = premio;
        this.ciudad = ciudad;
        ciudad.setCarrera(this);
        this.directorCarrera = director;
        director.setCarrera(this);
        Random rand = new Random();
        double lowerBound = 0.0;
        double upperBound = 0.2;
        this.clima = lowerBound + (upperBound - lowerBound) * rand.nextDouble(); //Se le asiga un valor aleatorio entre 0.0 y 0.2 al clima
    }

    public Carrera(String nombre, double distancia, double premio, Ciudad ciudad, DirectorCarrera director, double dificultad) {
        this.id = idActual;
        Carrera.idActual++;
        this.nombreCircuito = nombre;
        this.distancia = distancia;
        this.premioEfectivo = premio;
        this.ciudad = ciudad;
        this.directorCarrera = director;
        director.setCarrera(this);
        this.dificultad = dificultad;
        Random rand = new Random();
        double lowerBound = 0.0;
        double upperBound = 0.2;
        this.clima = lowerBound + (upperBound - lowerBound) * rand.nextDouble(); //Se le asiga un valor aleatorio entre 0.0 y 0.2 al clima
    }

    public Carrera(String nombre, double distancia, double premio, Ciudad ciudad, double dificultad) {
        this.id = idActual;
        Carrera.idActual++;
        this.nombreCircuito = nombre;
        this.distancia = distancia;
        this.premioEfectivo = premio;
        this.ciudad = ciudad;
        this.dificultad = dificultad;
        Random rand = new Random();
        double lowerBound = 0.0;
        double upperBound = 0.2;
        this.clima = lowerBound + (upperBound - lowerBound) * rand.nextDouble(); //Se le asiga un valor aleatorio entre 0.0 y 0.2 al clima
    }
    public Carrera(Ciudad ciudad, int mes, double dificultad){ //El chakalito y la chakalita xd
        this.id = idActual;
        Carrera.idActual++;
        Random rand = new Random();
        ArrayList<String> poolNombres = new ArrayList<String>(); //TODO: Preguntar por estos nombres de carreras
        poolNombres.add("Grand Prix de ");
        poolNombres.add("Trofeo de ");
        poolNombres.add("Carrera en las Calles de ");
        this.ciudad = ciudad;
        this.mes = mes; //TODO: Hacer verificacion de que no hay meses repetidos
        this.dificultad = dificultad;
        this.nombreCircuito = poolNombres.get(rand.nextInt(3))+this.ciudad.getNombre();
        this.distancia = (rand.nextInt(11)+5)*1000;
        this.premioEfectivo = (rand.nextInt(3)+1)*1000;
        Random random = new Random();
        int randomNumber = random.nextInt(28) + 1;
        this.fecha = randomNumber + "/" + String.valueOf(this.mes) + "/" + String.valueOf(Campeonato.campeonatoElegido.getAno());
    }

    //Metodos de clase

    public static Campeonato getCampeonato() {
        return campeonato;
    }

    public static void setCampeonato(Campeonato campeonatico) {
        campeonato = campeonatico;
    }

    //Metodos para el ciclo de la carrera
    public static void comenzarCarrera(Carrera carrera) { //Metodo para comenzar cada carrera. Cada carrera se trabajara estaticamente.
        carreraActual = carrera;
    }

    public static void actualizarGasolina() { //Cada iteracion se debe actualizar la gasolina.
        if (VehiculoCarrera.vehiculoElegido.getGasolina()>3) { //Si hay suficiente gasolina, se reduce el nivel.
            VehiculoCarrera.vehiculoElegido.setGasolina(VehiculoCarrera.vehiculoElegido.getGasolina()-3);
        }
        else { //Si no hay suficiente gasolina, el carro choca.
            VehiculoCarrera.vehiculoElegido.chocar();
        }
    }

    public static void actualizarPosiciones() { //Cada iteracion del ciclo, se deben actualizar las posiciones  TODO: Preguntar por imprimir dos tablas en paralelo durante el ciclo
        for (VehiculoCarrera vehiculo: posiciones){
            vehiculo.setDistanciaRecorrida(vehiculo.getDistanciaRecorrida() + vehiculo.getVelocidadActual());
            if (vehiculo.getDistanciaRecorrida()>= carreraActual.getDistancia()){
                terminados.add(vehiculo);
                vehiculo.setTerminado(true);
                posiciones.remove(vehiculo);
            }
        }
        posiciones.sort(Comparator.comparing(VehiculoCarrera::getDistanciaRecorrida));
    }

    public static ArrayList<Boolean> actualizarOpciones() { //Este metodo selecciona aleatoriamente que opciones se van a mostrar
        ArrayList<Boolean> listaOpciones = new ArrayList<Boolean>();
        Random rand = new Random();
        for (int i=0 ; i<5 ; i++) {
            int numRandom= rand.nextInt(10);
            if (numRandom>=3) {
                listaOpciones.add(true);
            }
            else {
                listaOpciones.add(false);
            }
        }
        return listaOpciones; //Retorna lista de 5 posiciones donde puede haber "true" o "false"
    }
    //Metodos para el final de la carrera
    public static boolean actualizarTerminado(){
        boolean todosTerminados=true;
        for (VehiculoCarrera vehiculoCarrera : posiciones){
            if (!vehiculoCarrera.isTerminado()){
                todosTerminados=false;
                break;
            }
        }
        return todosTerminados;
    }
    public static void premiarCarrera(){ //Metodo para otorgar los puntos y el premio en efectivo al final de cada carrera
        int puntosActuales = 8;
        for (VehiculoCarrera vehiculo : terminados){
            vehiculo.getPiloto().setPuntos(vehiculo.getPiloto().getPuntos()+puntosActuales);
            puntosActuales--;
        }
        terminados.get(0).getPiloto().recibirPlata(carreraActual.getPremioEfectivo()*0.7);
        for (Patrocinador patrocinador : terminados.get(0).getPiloto().getEquipo().getPatrocinadoresEquipo()) {
            patrocinador.recibirPlata(carreraActual.getPremioEfectivo() * 0.1);
        }
        terminados.get(1).getPiloto().recibirPlata(carreraActual.getPremioEfectivo()*0.2);
        terminados.get(2).getPiloto().recibirPlata(carreraActual.getPremioEfectivo()*0.1);
    } //TODO: Preguntar por la cantidad que gana cada equipo

    // Lista de metodos set y get
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNombreCircuito() {
        return this.nombreCircuito;
    }

    public void setNombreCircuito(String nombre) {
        this.nombreCircuito = nombre;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEfectivo() {
        return this.premioEfectivo;
    }

    public void setPremioEfectivo(double premio) {
        this.premioEfectivo = premio;
    }

    public DirectorCarrera getDirectorCarrera() {
        return this.directorCarrera;
    }

    public void setDirectorCarrera(DirectorCarrera director) {
        this.directorCarrera = director;
        director.setCarrera(this);
    }

    public Ciudad getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public double getClima() {
        return this.clima;
    }

    public void setClima(double clima) {
        this.clima = clima;
    }

    public double getDificultad() {
        return this.dificultad;
    }

    public void setDificultad(double dificultad) {
        this.dificultad = dificultad;
    }

    public ArrayList<VehiculoCarrera> getPosiciones() {
        return posiciones;
    }

    public static Carrera getCarreraActual() {
        return carreraActual;
    }

    public static void setCarreraActual(Carrera carreraActual) {
        Carrera.carreraActual = carreraActual;
    }

    public static int getIdActual() {
        return idActual;
    }

    public static void setIdActual(int idActual) {
        Carrera.idActual = idActual;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }
}
