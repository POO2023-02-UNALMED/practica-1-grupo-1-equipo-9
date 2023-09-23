package gestorAplicacion.campeonato;

import java.util.ArrayList;
import gestorAplicacion.paddock.Vehiculo;
import gestorAplicacion.paddock.Piloto;
import gestorAplicacion.paddock.Pieza;


public class VehiculoCarrera extends Vehiculo {
    //Atributos
    private Piloto piloto; //Conductor
    private double tiempo; //Cuanto se demora en terminar la carrera, solo se calcula al final para obtener la posición final
    private double distanciaRecorrida; //Se usa sólo dentro del ciclo, se calcula en cada iteración para obtener la posición actual
    private boolean terminado; // Mira si terminó la carrera. Si se choca, esto pasa a true.
    private boolean morido; // Si está morido, lo manda al final de la lista de posiciones.
    private double velocidadTuneao;
    private double probabilidadChoque;
    private int gasolina;

    //Constructor
    public VehiculoCarrera(String nombre, String color, int numero, double velocidad, double velocidadTuneao, double probabilidadChoque, int gasolina) {
        super(nombre, color, numero, velocidad);
        this.tiempo = 0;
        this.distanciaRecorrida = 0;
        this.terminado = false;
        this.morido = false;
        this.velocidadTuneao = velocidadTuneao;
        this.probabilidadChoque = probabilidadChoque;
        this.gasolina = gasolina;
    }
    //Métodos
    public void chocar() { //Coloca tiempo en 0, velocidad en 0, terminado en true y morido en true
        this.tiempo = 0;
        this.velocidad = 0;
        this.terminado = true;
        this.morido = true;
    }

    public void cambiarMotor(Pieza motor, double dinero) {
        if (dinero >= motor.getPrecio()) {
            this.motor = motor;
            this.velocidadTuneao = this.velocidad * motor.getVelocidad();
        }
    }

    public void cambiarLlantas(Pieza llantas, double dinero) {
        if (dinero >= llantas.getPrecio()) {
            this.llantas = llantas;
            this.probabilidadChoque = this.probabilidadChoque * llantas.getProbabilidadChoque();
        }
    }

    public void cambiarAleron(Pieza aleron, double dinero) {
        if (dinero >= aleron.getPrecio()) {
            this.aleron = aleron;
            this.probabilidadChoque = this.probabilidadChoque * aleron.getProbabilidadChoque();
        }
    }

    public void repararVehiculo(double dinero) {
        if (dinero >= 100) {
            this.morido = false;
        }
    }

    public void llenarGasolina() {
        this.gasolina = 100;
    }

    public void setPiloto(Piloto piloto) {this.piloto = piloto;}
    public Piloto getPiloto() {return this.piloto;}

    public void setTiempo(double tiempo) {this.t
}
