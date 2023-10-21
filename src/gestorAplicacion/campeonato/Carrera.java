package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Circuito;
import gestorAplicacion.paddock.Patrocinador;
import gestorAplicacion.paddock.Piloto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Carrera implements Decimales, Serializable {
	private static final long serialVersionUID = 5592556885641211247L;

	public  ArrayList<VehiculoCarrera> posiciones = new ArrayList<VehiculoCarrera>(); //Lista de posiciones de los vehiculos

    public  ArrayList<VehiculoCarrera> terminados = new ArrayList<VehiculoCarrera>(); //Lista de carros que ya terminaron

    public static ArrayList<Carrera> listaCarreras = new ArrayList<Carrera>(); //Lista de carreras

    private ArrayList<Equipo> equiposBeneficiados = new ArrayList<Equipo>(); //Lista de pilotos que tienen trato preferencial

    //Atributos
    private static int idActual = 1;
    private Campeonato campeonato;
    private int id;
    private String nombreCircuito;
    private String fecha;
    private int mes; //El mes determina el orden de la carrera
    private double distancia = 0; //Distancia de la carrera
    private double premioEfectivo = 0; //Este premio se distribuye entre los 3 primeros puestos
    private Ciudad ciudad;
    private DirectorCarrera directorCarrera;
    private double clima = 0 ; //.05 soleado, .10 lluvia, .15 tormenta, se le suma a la probabilidad de chocarse del vehiculo
    private int dificultad = 0; //Se le suma a la probabilidad de chocarse del vehiculo

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
        this.dificultad = (int) dificultad;
        Random rand = new Random();
        double lowerBound = 0.0;
        double upperBound = 0.2;
        this.clima = lowerBound + (upperBound - lowerBound) * rand.nextDouble(); //Se le asiga un valor aleatorio entre 0.0 y 0.2 al clima
    }

    public Carrera(Campeonato campeonato, int id, String nombreCircuito, String fecha, int mes, double distancia, double premioEfectivo, Ciudad ciudad, DirectorCarrera directorCarrera, double clima, int dificultad, Circuito circuito) {
        this.campeonato = campeonato;
        this.id = id;
        this.nombreCircuito = nombreCircuito;
        this.fecha = fecha;
        this.mes = mes;
        this.distancia = distancia;
        this.premioEfectivo = premioEfectivo;
        this.ciudad = ciudad;
        this.directorCarrera = directorCarrera;
        this.clima = clima;
        this.dificultad = dificultad;
        this.circuito = circuito;
    }

    public Carrera(String nombre, int mes, double distancia, double premio, Ciudad ciudad, DirectorCarrera director) {
        this.id = idActual;
        Carrera.idActual++;
        this.nombreCircuito = nombre;
        this.mes = mes;
        this.distancia = distancia;
        this.premioEfectivo = premio;
        this.ciudad = ciudad;
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
        this.dificultad = (int) dificultad;
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
        this.dificultad = (int) dificultad;
        Random rand = new Random();
        double lowerBound = 0.0;
        double upperBound = 0.2;
        this.clima = lowerBound + (upperBound - lowerBound) * rand.nextDouble(); //Se le asiga un valor aleatorio entre 0.0 y 0.2 al clima
    }

    public Carrera(Ciudad ciudad, double dificultad, Campeonato campeonato, Circuito circuito, int mes, DirectorCarrera directorCarrera) { //El chakalito y la chakalita xd
        this.id = idActual++;
        Random rand = new Random();
        ArrayList<String> poolNombres = new ArrayList<String>();
        poolNombres.add("Grand Prix de ");
        poolNombres.add("Trofeo de ");
        this.ciudad = ciudad;
        this.mes = mes;
        this.dificultad = (int) dificultad;
        this.campeonato = campeonato;
        this.circuito = circuito;
        this.directorCarrera = directorCarrera;
        this.nombreCircuito = poolNombres.get(rand.nextInt(2)) + this.ciudad.getNombre();
        this.distancia = (rand.nextInt(11) + 5) * 1000;
        this.premioEfectivo = (rand.nextInt(3) + 1) * 1000;
        Random random = new Random();
        int randomNumber = random.nextInt(28) + 1;
        this.fecha = randomNumber + "/" + this.mes + "/" + campeonato.getAno();
    }


    public void actualizarGasolina(Piloto piloto) { //Cada iteracion se debe actualizar la gasolina.
        VehiculoCarrera carroElegidoCarrerra = null;
        for (VehiculoCarrera vehiculoCarrera : VehiculoCarrera.getListaVehiculosCarrera()){
            if (vehiculoCarrera.getPiloto()==piloto){
                carroElegidoCarrerra = vehiculoCarrera;
            }
        }
        if (carroElegidoCarrerra.getGasolina() > 3) { //Si hay suficiente gasolina, se reduce el nivel.
            carroElegidoCarrerra.setGasolina(carroElegidoCarrerra.getGasolina() - 3);
        } else { //Si no hay suficiente gasolina, el carro choca.
            carroElegidoCarrerra.chocar();
        }
    }

    public void actualizarPosiciones() {
        for (VehiculoCarrera vehiculo : this.posiciones) {
            vehiculo.setDistanciaRecorrida(vehiculo.getDistanciaRecorrida() + vehiculo.getVelocidadActual());
            vehiculo.setTiempo(vehiculo.getTiempo() + 1.0);
            if (vehiculo.getDistanciaRecorrida() >= this.getDistancia()) {
                terminados.add(vehiculo);
                vehiculo.setTerminado(true);
                posiciones.remove(vehiculo);
            }
        }
        posiciones.sort(Comparator.comparing(VehiculoCarrera::getDistanciaRecorrida));
    }

    public ArrayList<Boolean> actualizarOpciones() { //Este metodo selecciona aleatoriamente que opciones se van a mostrar
        ArrayList<Boolean> listaOpciones = new ArrayList<Boolean>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int numRandom = rand.nextInt(10);
            if (numRandom >= 3) {
                listaOpciones.add(true);
            } else {
                listaOpciones.add(false);
            }
        }
        return listaOpciones; //Retorna lista de 5 posiciones donde puede haber "true" o "false"
    }

    //Metodos para el final de la carrera
    public boolean actualizarTerminado() {
        boolean todosTerminados = true;
        for (VehiculoCarrera vehiculoCarrera : posiciones) {
            if (!vehiculoCarrera.isTerminado()) {
                todosTerminados = false;
                break;
            }
        }
        return todosTerminados;
    }

    public void verificarPorChoques(){
        for (VehiculoCarrera vehiculoCarrera : VehiculoCarrera.getListaVehiculosCarrera()){
            if (vehiculoCarrera.isMorido() && this.getCampeonato().getListaPilotos().contains(vehiculoCarrera.getPiloto())){
                this.terminados.add(vehiculoCarrera);
            }
        }
    }

    @Override

    public void redondear() {
        this.distancia = dosDecimales(this.distancia);
        this.premioEfectivo = dosDecimales(this.premioEfectivo);
        this.clima = dosDecimales(this.clima);
    }

    {
        this.redondear();
    }

    public void agregarVehiculoCarrerra(VehiculoCarrera vehiculoCarrera) {
        this.posiciones.add(vehiculoCarrera);
    }

    public static int getIdActual() {
        return idActual;
    }

    public static void setIdActual(int idActual) {
        Carrera.idActual = idActual;
    }

    public ArrayList<VehiculoCarrera> getTerminados() {
        return terminados;
    }

    public void setTerminados(ArrayList<VehiculoCarrera> terminados) {
        this.terminados = terminados;
    }

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

    public int getDificultad() {
        return this.dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public ArrayList<VehiculoCarrera> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<VehiculoCarrera> posiciones) {
        this.posiciones = posiciones;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public static ArrayList<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public static void setListaCarreras(ArrayList<Carrera> listaCarreras) {
        Carrera.listaCarreras = listaCarreras;
    }

    public ArrayList<Equipo> getEquiposBeneficiados() {
        return equiposBeneficiados;
    }

    public void setEquiposBeneficiados(ArrayList<Equipo> equiposBeneficiados) {
        this.equiposBeneficiados = equiposBeneficiados;
    }

}
