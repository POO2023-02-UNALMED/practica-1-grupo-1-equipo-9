package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.Equipo;
import gestorAplicacion.campeonato.VehiculoCarrera;

import java.io.Serializable;
import java.util.ArrayList;

public class Pieza implements Serializable{
	private static final long serialVersionUID = 3981603915201008050L;
	
	static int idActual = 0;
    static ArrayList<Pieza> piezas = new ArrayList<Pieza>();
    static ArrayList<Pieza> piezasContrabando = new ArrayList<Pieza>();
    private int id;
    private boolean danado;
    private double velocidadAnadida;
    private double maniobrabilidadAnadida;
    private String nombre;
    private double precio;
    private String tipo;

    // Constructores
    public Pieza(boolean danado, double velocidadAnadida, double maniobrabilidadAnadida, String nombre, double precio, String tipo) {
        this.id = idActual++;
        this.danado = danado;
        this.velocidadAnadida = velocidadAnadida;
        this.maniobrabilidadAnadida = maniobrabilidadAnadida;
        this.nombre = nombre;
        this.precio = precio;
        Pieza.piezas.add(this);
    }

    public Pieza(boolean danado, double velocidadAnadida, double maniobrabilidadAnadida, String nombre, double precio, boolean contrabando, String tipo) {
        this.id = idActual++;
        this.danado = danado;
        this.velocidadAnadida = velocidadAnadida;
        this.maniobrabilidadAnadida = maniobrabilidadAnadida;
        this.nombre = nombre;
        this.precio = precio;
        if (contrabando) {
            Pieza.piezasContrabando.add(this);
        } else {
            Pieza.piezas.add(this);
        }
    }

    public Pieza() {
        this.id = idActual++;
        this.danado = false;
        this.velocidadAnadida = 0;
        this.maniobrabilidadAnadida = 0;
        this.nombre = "";
        this.precio = 0;
        Pieza.piezas.add(this);
    }

    public static int getIdActual() {
        return idActual;
    }

    public static void setIdActual(int idActual) {
        Pieza.idActual = idActual;
    }

    public static ArrayList<Pieza> getPiezas() {
        return piezas;
    }

    public static void setPiezas(ArrayList<Pieza> piezas) {
        Pieza.piezas = piezas;
    }

    public static ArrayList<Pieza> getPiezasContrabando() {
        return piezasContrabando;
    }

    public static void setPiezasContrabando(ArrayList<Pieza> piezasContrabando) {
        Pieza.piezasContrabando = piezasContrabando;
    }

    // Metodos de clase
    public void agregarPieza(Pieza pieza) {
        piezas.add(pieza);
    }

    public void agregarPiezaContrabando(Pieza pieza) {
        piezasContrabando.add(pieza);
    }

    // Metodos de instancia
    public void arreglar() {
        this.danado = false;
    }

    public boolean comprar(VehiculoCarrera vehiculoCarrera) {
        Equipo equipo = vehiculoCarrera.getPiloto().getEquipo();
        if (this.precio <= equipo.getPlata()) {
            equipo.setPlata(equipo.getPlata() - this.precio);
            this.setDanado(false);
            vehiculoCarrera.setManiobrabilidad(vehiculoCarrera.getManiobrabilidad() + this.maniobrabilidadAnadida);
            return true;
        } else {
            return false;
        }
    }

    // Getters y setters
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
