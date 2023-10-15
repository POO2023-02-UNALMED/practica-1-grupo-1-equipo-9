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


    public Pieza(int id, boolean danado, double velocidadAnadida, double maniobrabilidadAnadida, String nombre, double precio, String tipo) {
        this.id = id;
        this.danado = danado;
        this.velocidadAnadida = velocidadAnadida;
        this.maniobrabilidadAnadida = maniobrabilidadAnadida;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

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


    public static ArrayList<ArrayList<Pieza>> combinacionesDisponibles(VehiculoCarrera vehiculoCarrera, Pieza neumatico) {
        ArrayList<ArrayList<Pieza>> combinaciones = new ArrayList<ArrayList<Pieza>>();
        ArrayList<Pieza> motoresDisponibles = Pieza.motoresDisponibles(vehiculoCarrera.getMarca());
        ArrayList<Pieza> aleronDisponible = Pieza.aleronesDisponibles(vehiculoCarrera.getMarca());
        ArrayList<Pieza> neumaticosDisponibles = Pieza.neumaticosDisponibles(vehiculoCarrera.getMarca());
        for (Pieza motor : motoresDisponibles) {
            for (Pieza aleron: aleronDisponible) {
                ArrayList<Pieza> combinacion = new ArrayList<Pieza>();
                combinacion.add(motor);
                combinacion.add(aleron);
                combinacion.add(neumatico);
                double precio = motor.getPrecio() + aleron.getPrecio() + neumatico.getPrecio();
                if (precio <= vehiculoCarrera.getPiloto().getEquipo().getPlata()) {
                    combinaciones.add(combinacion);
                }
                combinaciones.add(combinacion);
            }
        }
        return combinaciones;
    }

    public static ArrayList<ArrayList<Pieza>> combinacionesDisponibles(VehiculoCarrera vehiculoCarrera, Pieza aleron, ArrayList<ArrayList<Pieza>> combinaciones) {
        for (ArrayList<Pieza> combinacion : combinaciones) {
             if(!combinacion.contains(aleron)){
                 combinaciones.remove(combinacion);
             }
        }
        return combinaciones;
    }

    public static ArrayList<ArrayList<Pieza>> combinaciones(VehiculoCarrera vehiculoCarrera) {
        ArrayList<ArrayList<Pieza>> combinaciones = new ArrayList<ArrayList<Pieza>>();
        ArrayList<Pieza> motoresDisponibles = Pieza.motoresDisponibles(vehiculoCarrera.getMarca());
        ArrayList<Pieza> aleronDisponible = Pieza.aleronesDisponibles(vehiculoCarrera.getMarca());
        ArrayList<Pieza> neumaticosDisponibles = Pieza.neumaticosDisponibles(vehiculoCarrera.getMarca());
        for (Pieza motor : motoresDisponibles) {
            for (Pieza aleron: aleronDisponible) {
                for (Pieza neumatico : neumaticosDisponibles) {
                    ArrayList<Pieza> combinacion = new ArrayList<Pieza>();
                    combinacion.add(motor);
                    combinacion.add(aleron);
                    combinacion.add(neumatico);
                    if (motor.getPrecio() + aleron.getPrecio() + neumatico.getPrecio() <= vehiculoCarrera.getPiloto().getEquipo().getPlata()) {
                        combinaciones.add(combinacion);
                    }
                }
            }
        }
        return combinaciones;
    }

    public static ArrayList<Pieza> filterAlerones(ArrayList<ArrayList<Pieza>> combinaciones) {
        ArrayList<Pieza> alerones = new ArrayList<Pieza>();
        for (ArrayList<Pieza> combinacion : combinaciones) {
            for (Pieza pieza : combinacion) {
                if (pieza.getTipo().equals("A")) {
                    alerones.add(pieza);
                }
            }
        }
        return alerones;
    }

    public static ArrayList<Pieza> filterNeumaticos(ArrayList<ArrayList<Pieza>> combinaciones) {
        ArrayList<Pieza> neumaticos = new ArrayList<Pieza>();
        for (ArrayList<Pieza> combinacion : combinaciones) {
            for (Pieza pieza : combinacion) {
                if (pieza.getTipo().equals("N")) {
                    neumaticos.add(pieza);
                }
            }
        }
        return neumaticos;
    }

    public static ArrayList<Pieza> filterMotores(ArrayList<ArrayList<Pieza>> combinaciones) {
        ArrayList<Pieza> motores = new ArrayList<Pieza>();
        for (ArrayList<Pieza> combinacion : combinaciones) {
            for (Pieza pieza : combinacion) {
                if (pieza.getTipo().equals("M")) {
                    motores.add(pieza);
                }
            }
        }
        return motores;
    }

    public static ArrayList<Pieza> piezasDisponibles() {
        ArrayList<Pieza> piezasDisponibles = new ArrayList<Pieza>();
        for (Pieza pieza : Pieza.piezas) {
            if (!pieza.isDanado()) {
                piezasDisponibles.add(pieza);
            }
        }
        return piezasDisponibles;
    }

    public static ArrayList<Pieza> motoresDisponibles(String marca) {
        ArrayList<Pieza> motoresDisponibles = new ArrayList<Pieza>();
        ArrayList<Pieza> piezasDisponibles = Pieza.piezasDisponibles();
        for (Pieza pieza : piezasDisponibles) {
            if (pieza.getTipo().equals("M") && pieza.getNombre().equals(marca)) {
                motoresDisponibles.add(pieza);
            }
        }
        return motoresDisponibles;
    }

    public static ArrayList<Pieza> neumaticosDisponibles(String marca){
        ArrayList<Pieza> neumaticosDisponibles = new ArrayList<Pieza>();
        ArrayList<Pieza> piezasDisponibles = Pieza.piezasDisponibles();
        for (Pieza pieza : piezasDisponibles) {
            if (pieza.getTipo().equals("N") && pieza.getNombre().equals(marca)) {
                neumaticosDisponibles.add(pieza);
            }
        }
        return neumaticosDisponibles;
    }

    public static ArrayList<Pieza> aleronesDisponibles(String marca) {
        ArrayList<Pieza> aleronesDisponibles = new ArrayList<Pieza>();
        ArrayList<Pieza> piezasDisponibles = Pieza.piezasDisponibles();
        for (Pieza pieza : piezasDisponibles) {
            if (pieza.getTipo().equals("A") && pieza.getNombre().equals(marca)) {
                aleronesDisponibles.add(pieza);
            }
        }
        return aleronesDisponibles;
    }

    public static double precioTotal(ArrayList<Pieza> piezas, VehiculoCarrera vehiculoCarrera) {
        double precioTotal = 0;
        for (Pieza pieza : piezas) {
            precioTotal += pieza.getPrecio();
        }
        vehiculoCarrera.setPiezasComprar(piezas);
        return precioTotal;
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
