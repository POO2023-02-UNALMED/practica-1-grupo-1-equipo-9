package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Pieza;
import gestorAplicacion.paddock.Piloto;
import gestorAplicacion.paddock.Vehiculo;


public class VehiculoCarrera extends Vehiculo {
    //Atributos
    private Piloto piloto; //Conductor
    private double tiempo; //Cuanto se demora en terminar la carrera, solo se calcula al final para obtener la posición final
    private double distanciaRecorrida; //Se usa sólo dentro del ciclo, se calcula en cada iteración para obtener la posición actual
    private boolean terminado; // Mira si terminó la carrera. Si se choca, esto pasa a true.
    private boolean morido; // Si está morido, lo manda al final de la lista de posiciones.
    private double velocidadTuneao; //Velocidad del vehículo + velocidad de las piezas
    private double probabilidadChoque;
    private int gasolina;
    public static VehiculoCarrera vehiculoElegido; //Vehículo que elije el usuario

    public VehiculoCarrera(String marca, String modelo, int ano, Pieza aleron, Pieza neumaticos, Pieza motor, double velocidad, double maniobrabilidad, double precioUtilizar, Piloto piloto) {
        super(marca, modelo, ano, aleron, neumaticos, motor, velocidad, maniobrabilidad, precioUtilizar);
        this.piloto = piloto;
        this.tiempo = 0;
        this.distanciaRecorrida = 0;
        this.terminado = false;
        this.morido = false;
        this.velocidadTuneao = 0;
        this.probabilidadChoque = maniobrabilidad + neumaticos.getManiobrabilidadAnadida() + aleron.getManiobrabilidadAnadida();
        this.gasolina = 100;
        this.actualizarVelocidadT();
    }

    //Métodos
    public void chocar() { //Coloca tiempo en 0, velocidad en 0, terminado en true y morido en true
        this.tiempo = 0;
        this.terminado = true;
        this.morido = true;
    }

    public void cambiarMotor(Pieza pieza) {
        if (Equipo.equipoElegido.getPlata() >= pieza.getPrecio()) {
            Equipo.equipoElegido.setPlata(Equipo.equipoElegido.getPlata() - pieza.getPrecio()); // Cobrar
            this.setMotor(pieza); //Cambiar motor
            this.actualizarVelocidadT(); //Actualizar velocidad tuneada
        }
    }

    public void cambiarNeumaticos(Pieza pieza, double dinero) {
        if (Equipo.equipoElegido.getPlata() >= pieza.getPrecio()) {
            Equipo.equipoElegido.setPlata(Equipo.equipoElegido.getPlata() - pieza.getPrecio()); // Cobrar
            this.setNeumaticos(pieza); //Cambiar neumáticos
            this.actualizarVelocidadT(); //Actualizar velocidad tuneada
        }
    }

    public void cambiarAleron(Pieza pieza) {
        if (Equipo.equipoElegido.getPlata() >= pieza.getPrecio()) {
            Equipo.equipoElegido.setPlata(Equipo.equipoElegido.getPlata() - pieza.getPrecio()); // Cobrar
            this.setAleron(pieza); //Cambiar alerón
            this.actualizarVelocidadT(); //Actualizar velocidad tuneada
        }
    }

    public void repararVehiculo() {
        double precio = 100; //preguntar precio
        if (Equipo.equipoElegido.getPlata() >= precio) {
            Equipo.equipoElegido.setPlata(this.piloto.getEquipo().getPlata() - precio); // Cobrar
            //Arreglar piezas
            this.getAleron().arreglar();
            this.getMotor().arreglar();
            this.getNeumaticos().arreglar();
        }
    }

    public void llenarGasolina() {
        this.gasolina = 100; //Llenar gasolina al 100%
    }

    public void actualizarVelocidadT() { //Actualiza la velocidad tuneada para cuando se cambie una pieza
        this.velocidadTuneao = this.getVelocidad() + this.getMotor().getVelocidadAnadida() + this.getNeumaticos().getVelocidadAnadida() + this.getAleron().getVelocidadAnadida();
    }

//    public void hacerRandom(int num) {
//        switch (
//            num
//        ) {
//            case 1:
//                this.cambiarMotor(this.getMotor().getPiezasDisponibles().get(0));
//                break;
//            case 2:
//                this.cambiarNeumaticos(this.getNeumaticos().getPiezasDisponibles().get(0), 0);
//                break;
//            case 3:
//                this.cambiarAleron(this.getAleron().getPiezasDisponibles().get(0));
//                break;
//            case 4:
//                this.repararVehiculo();
//                break;
//            case 5:
//                this.llenarGasolina();
//                break;
//            default:
//                break;
//        }
//    }

    // Ligadura Dinamica
    public void morir() {
        Vehiculo vehiculo = this;
    }

    // Getters y setters

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    public boolean isMorido() {
        return morido;
    }

    public void setMorido(boolean morido) {
        this.morido = morido;
    }

    public double getVelocidadTuneao() {
        return velocidadTuneao;
    }

    public void setVelocidadTuneao(double velocidadTuneao) {
        this.velocidadTuneao = velocidadTuneao;
    }

    public double getProbabilidadChoque() {
        return probabilidadChoque;
    }

    public void setProbabilidadChoque(double probabilidadChoque) {
        this.probabilidadChoque = probabilidadChoque;
    }

    public int getGasolina() {
        return gasolina;
    }

    public void setGasolina(int gasolina) {
        this.gasolina = gasolina;
    }

    public Piloto getPiloto() {
        return this.piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public double getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

}
