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

    // aqui podriamos usar eso de especializar - herencia

//    public VehiculoCarrera(String nombre, String color, int numero, double velocidad, double velocidadTuneao, double probabilidadChoque, int gasolina) {
//        super(nombre, color, numero, velocidad);
//        this.tiempo = 0;
//        this.distanciaRecorrida = 0;
//        this.terminado = false;
//        this.morido = false;
//        this.velocidadTuneao = velocidadTuneao;
//        this.probabilidadChoque = probabilidadChoque;
//        this.gasolina = gasolina;
//    }

    //Métodos
    public void chocar() { //Coloca tiempo en 0, velocidad en 0, terminado en true y morido en true
        this.tiempo = 0;
        this.terminado = true;
        this.morido = true;
    }

    public void cambiarMotor(Pieza motor, double dinero) {
        if (dinero >= motor.getPrecio()) {
            this.setMotor(motor);
            this.piloto.getEquipo().setPlata(this.piloto.getEquipo().getPlata() - motor.getPrecio());
            this.velocidadTuneao = getVelocidad() + motor.getVelocidadAnadida();
        }
    }

    public void cambiarNeumaticos(Pieza neumaticos, double dinero) {
        if (dinero >= neumaticos.getPrecio()) {
            this.setNeumaticos(neumaticos);
            this.piloto.getEquipo().setPlata(this.piloto.getEquipo().getPlata() - neumaticos.getPrecio());
            this.probabilidadChoque = this.probabilidadChoque + neumaticos.getManiobrabilidadAnadida();
        }
    }

    public void cambiarAleron(Pieza aleron, double dinero) {
        if (dinero >= aleron.getPrecio()) {
            this.setAleron(aleron); ;
            this.probabilidadChoque = this.probabilidadChoque + aleron.getManiobrabilidadAnadida();
        }
    }

    public void repararVehiculo(double dinero) {
        double precio = 100;
        if (dinero >= precio) { //preguntar precio
            this.getAleron().arreglar();
            this.getMotor().arreglar();
            this.getNeumaticos().arreglar();
            this.piloto.getEquipo().setPlata(this.piloto.getEquipo().getPlata() - precio);
        }
    }

    public void llenarGasolina(double plata ) {
        double precio = 100;
        if (plata >= precio) {
            this.gasolina = 100;
            this.piloto.getEquipo().setPlata(this.piloto.getEquipo().getPlata() - precio);
        }
    }

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

    public void setPiloto(Piloto piloto) {this.piloto = piloto;}
    public Piloto getPiloto() {return this.piloto;}

    public void setTiempo(double tiempo) {this.tiempo = tiempo;}
    public double getTiempo() {return this.tiempo;}

}
