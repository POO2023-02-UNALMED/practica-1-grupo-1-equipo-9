package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.Equipo;
import gestorAplicacion.campeonato.VehiculoCarrera;
import java.io.Serializable;
import java.util.*;

public class Chasis implements Serializable{
    private static final long serialVersionUID = 7166096271225774034L;

    public static ArrayList<Chasis> listaChasis = new ArrayList<Chasis>();

    private String marca;
    private String modelo;
    private double velocidad; //Cantidad que se mueve en cada segundo de la carrera
    private double maniobrabilidad; //Probabilidad de que se choque
    private double precio; //Precio inicial de uso

    //Constructores
    public Chasis(String marca, String modelo, double velocidad, double maniobrabilidad, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
        this.maniobrabilidad = maniobrabilidad;
        this.precio = precio;
        Chasis.listaChasis.add(this);
    }

    public Chasis(String marca, String modelo, double velocidad, double maniobrabilidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
        this.maniobrabilidad = maniobrabilidad;
        this.precio = 0;
        Chasis.listaChasis.add(this);
    }

    public static ArrayList<Chasis> chasisDisponible(Piloto piloto){
        double precioMaximo = piloto.getPresupuestoVehiculo() * 0.6;
        ArrayList<Chasis> listaChasis = new ArrayList<Chasis>();
        for (Chasis chasis : Chasis.listaChasis) {
            if (chasis.getPrecio() > precioMaximo) {
                listaChasis.add(chasis);
            }
        }
        return listaChasis;
    }

    public static ArrayList<Chasis> getListaChasis() {
        return listaChasis;
    }

    public static void setListaChasis(ArrayList<Chasis> listaChasis) {
        Chasis.listaChasis = listaChasis;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public VehiculoCarrera comprar(Piloto piloto) {
        piloto.getEquipo().setPlata(piloto.getEquipo().getPlata() - this.precio);
        VehiculoCarrera vehiculo = new VehiculoCarrera(this, piloto);
        return vehiculo;
    }
    //Metodos de instancia

    // Metodo que se usa para ligadura dinamica
    public void morir() {
        this.setVelocidad(0);
        this.setManiobrabilidad(0);
    }

}
