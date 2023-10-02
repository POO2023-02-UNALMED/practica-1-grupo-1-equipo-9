package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.Equipo;
import gestorAplicacion.campeonato.VehiculoCarrera;

import java.util.ArrayList;
import java.util.Random;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int ano;
    private Pieza aleron;
    private Pieza neumaticos;
    private Pieza motor;
    private double velocidad; //Cantidad que se mueve en cada segundo de la carrera
    private double maniobrabilidad; //Probabilidad de que se choque
    private double precioUtilizar; //Precio inicial de uso

    //Constructores 
    public Vehiculo(String marca, String modelo, int ano, Pieza aleron, Pieza neumaticos, Pieza motor, double velocidad, double maniobrabilidad, double precioUtilizar) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.aleron = aleron;
        this.neumaticos = neumaticos;
        this.motor = motor;
        this.velocidad = velocidad;
        this.maniobrabilidad = maniobrabilidad;
        this.precioUtilizar = precioUtilizar;
    }

    public Vehiculo() {
        this.marca = "";
        this.modelo = "";
        this.ano = 0;
        this.aleron = new Pieza();
        this.neumaticos = new Pieza();
        this.motor = new Pieza();
        this.velocidad = 0;
        this.maniobrabilidad = 0;
        this.precioUtilizar = 0;
    }

    //Metodos de instancia
    public String toString() {
        return "Marca: " + this.marca + "\nModelo: " + this.modelo + "\nAño: " + this.ano + "\nAlerón: " + this.aleron.toString() + "\nNeumáticos: " + this.neumaticos.toString() + "\nMotor: " + this.motor.toString() + "\nVelocidad: " + this.velocidad + "\nManiobrabilidad: " + this.maniobrabilidad + "\nPrecio de utilización: " + this.precioUtilizar;
    } // vamos a usar la interfaz para imprimir los stats lindos en tablas

    //comprar vehiculo: se crea el vehiculo de carrera
    public void comprar(Piloto piloto) {
        Equipo equipo = piloto.getEquipo();
        if (equipo.getPlata() >= this.precioUtilizar) {
            equipo.setPlata(equipo.getPlata() - this.precioUtilizar);
            VehiculoCarrera vehiculoCarrera = new VehiculoCarrera(this.marca, this.modelo, this.ano, this.aleron, this.neumaticos, this.motor, this.velocidad, this.maniobrabilidad, this.precioUtilizar, piloto);
            equipo.getVehiculosDisponibles().add(vehiculoCarrera);
        }
    }

    // Metodo que se usa para ligadura dinamica
    public void morir() {
        this.setVelocidad(0);
        this.setManiobrabilidad(0);
        this.getAleron().setDanado(true);
        this.getNeumaticos().setDanado(true);
        this.getMotor().setDanado(true);
    }

    //Metodos get y set
    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Pieza getAleron() {
        return aleron;
    }

    public void setAleron(Pieza aleron) {
        this.aleron = aleron;
    }

    public Pieza getNeumaticos() {
        return neumaticos;
    }

    public void setNeumaticos(Pieza neumaticos) {
        this.neumaticos = neumaticos;
    }

    public Pieza getMotor() {
        return motor;
    }

    public void setMotor(Pieza motor) {
        this.motor = motor;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getManiobrabilidad() {
        return maniobrabilidad;
    }

    public void setManiobrabilidad(double maniobrabilidad) {
        this.maniobrabilidad = maniobrabilidad;
    }

    public double getPrecioUtilizar() {
        return precioUtilizar;
    }

    public void setPrecioUtilizar(double precioUtilizar) {
        this.precioUtilizar = precioUtilizar;
    }
}
