package gestorAplicacion.paddock;

import java.util.*;
import gestorAplicacion.campeonato.VehiculoCarrera;

public class Pieza {
    private boolean danado;
    private double velocidadAnadida;
    private double maniobrabilidadAnadida;
    private String nombre;
    private double precio;

    public Pieza(boolean danado, double velocidadAnadida, double maniobrabilidadAnadida, String nombre, double precio) {
        this.danado = danado;
        this.velocidadAnadida = velocidadAnadida;
        this.maniobrabilidadAnadida = maniobrabilidadAnadida;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Pieza() {
    }

    public void arreglar() {
        this.danado = false;
    }

    public void comprar(VehiculoCarrera veh) {
//        veh.setVelocidad(veh.getVelocidad() + this.velocidadAnadida);
//        veh.setManiobrabilidad(veh.getManiobrabilidad() + this.maniobrabilidadAnadida);
    }

    public boolean isDanado() {
        return danado;
    }

    public void setDanado(boolean danado) {
        this.danado = danado;
    }

    public double getVelocidadAnadida() {
        return velocidadAnadida;
    }

    public void setVelocidadAnadida(double velocidadAnadida) {
        this.velocidadAnadida = velocidadAnadida;
    }

    public double getManiobrabilidadAnadida() {
        return maniobrabilidadAnadida;
    }

    public void setManiobrabilidadAnadida(double maniobrabilidadAnadida) {
        this.maniobrabilidadAnadida = maniobrabilidadAnadida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
