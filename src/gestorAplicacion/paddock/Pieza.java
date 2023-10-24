package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.Decimales;
import gestorAplicacion.campeonato.Equipo;
import gestorAplicacion.campeonato.VehiculoCarrera;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Pieza implements Serializable, Decimales {
    /***
     * Autores: David Toro Arboleda, Santiago Lopez Ayala, Juan Andres Jimenez Velez, Mariana Valencia Cubillos, Samuel Mira Alvarez
     * Descripcion de la clase: La funcion principal de esta clase es la asignacion de atributos a cada una de las piezas de los vehiculos que compiten en las carreras del campeonato.
     */
	private static final long serialVersionUID = 3981603915201008050L;
	
	static int idActual = 0;
    static ArrayList<Pieza> piezas = new ArrayList<Pieza>();
    static ArrayList<Pieza> piezasContrabando = new ArrayList<Pieza>();
    private int id;
    private boolean danado;
    private double velocidadAnadida;
    private double maniobrabilidadAnadida;
    private String marca; // esta es la marca
    private String nombre;
    private double precio;
    private String tipo;


    // Constructores


    public Pieza(boolean danado, double velocidadAnadida, double maniobrabilidadAnadida, String marca, String nombre, double precio, String tipo) {
        this.id = idActual++;
        this.danado = danado;
        this.velocidadAnadida = velocidadAnadida;
        this.maniobrabilidadAnadida = maniobrabilidadAnadida;
        this.marca = marca;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        Pieza.piezas.add(this);
    }

    public Pieza(boolean danado, double velocidadAnadida, double maniobrabilidadAnadida, String marca, String nombre, double precio, String tipo, boolean contrabando) {
        this.id = idActual++;
        this.danado = danado;
        this.velocidadAnadida = velocidadAnadida;
        this.maniobrabilidadAnadida = maniobrabilidadAnadida;
        this.marca = marca;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        if (contrabando) {
            Pieza.piezasContrabando.add(this);
        } else {
            Pieza.piezas.add(this);
        }
    }

    public Pieza(String nombre, String tipo, String marca){
        Random random = new Random();
        this.id = idActual++;
        this.marca = marca;
        this.nombre = nombre;
        this.tipo = tipo;
        this.maniobrabilidadAnadida = 0.1 + (0.4 - 0.1) * random.nextDouble();
        this.precio = Math.random() * 1000;
        this.danado = false;
        this.velocidadAnadida = Math.random() * 20;
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
        /***
         * Descripcion del metodo: este metodo se encarga de actualizar la maniobrabilidad del vehiculo dependiendo la pieza que se haya elegido, tambien actualiza el saldo de plata que tiene el equipo del piloto
         * Parametros de entrada:  vehiculoCarrera de tipo VehiculoCarrera
         * Parametros de salida: boolean
         */
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

    public static Pieza piezaNoElegida(String tipo) {
        Random random = new Random();
        // crear pieza de marca default con atributos random
        return new Pieza(false, Math.random() * 20, 0.1 + (0.4 - 0.1) * random.nextDouble(), "Default", "", 0, tipo);
    }

    public static ArrayList<ArrayList<Pieza>> combinacionesDisponibles(VehiculoCarrera vehiculoCarrera, Pieza neumatico) {
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de piezas dependiendo de la marca y dependiendo de el dinero disponible por el equipo del piloto
         * Parametros de entrada:  vehiculoCarrera de tipo VehiculoCarrera y neumatico de tipo Pieza
         * Parametros de salida: ArrayList<ArrayList<Pieza>>
         */
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
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de piezas dependiendo de la marca y dependiendo de el dinero disponible por el equipo del piloto
         * Parametros de entrada:  vehiculoCarrera de tipo VehiculoCarrera , aleron de tipo Pieza y combinaciones de tipo ArrayList<ArrayList<Pieza>>
         * Parametros de salida: ArrayList<ArrayList<Pieza>>
         */
        ArrayList<ArrayList<Pieza>> combinacionesDisponibles = new ArrayList<ArrayList<Pieza>>();
        combinacionesDisponibles.addAll(combinaciones);
        for (ArrayList<Pieza> combinacion : combinaciones) {
             if(!combinacion.contains(aleron)){
                 combinacionesDisponibles.remove(combinacion);
             }
        }
        return combinacionesDisponibles;
    }

    public static ArrayList<ArrayList<Pieza>> combinaciones(VehiculoCarrera vehiculoCarrera) {
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de piezas dependiendo de la marca y dependiendo de el dinero disponible por el equipo del piloto
         * Parametros de entrada:  vehiculoCarrera de tipo VehiculoCarrera
         * Parametros de salida: ArrayList<ArrayList<Pieza>>
         */
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
                        if (!combinaciones.contains(combinacion)) {
                            combinaciones.add(combinacion);
                        }
                    }

                }
            }
        }
        return combinaciones;
    }

    public static ArrayList<Pieza> filterAlerones(ArrayList<ArrayList<Pieza>> combinaciones) {
        /***
     * Descripcion del metodo: este metodo se encarga de filtrar una lista de piezas mostrando solo los alerones
     * Parametros de entrada:  combinaciones de tipo ArrayList<ArrayList<Pieza>>
     * Parametros de salida: ArrayList<Pieza>
     */
        ArrayList<Pieza> alerones = new ArrayList<Pieza>();
        for (ArrayList<Pieza> combinacion : combinaciones) {
            for (Pieza pieza : combinacion) {
                if (pieza.getTipo().equals("A")) {
                    alerones.add(pieza);
                }
            }
        }
        // alerones distintos
        ArrayList<Pieza> aleronesDistintos = new ArrayList<Pieza>();
        for (Pieza aleron : alerones) {
            if (!aleronesDistintos.contains(aleron)) {
                aleronesDistintos.add(aleron);
            }
        }
        return aleronesDistintos;
    }

    public static ArrayList<Pieza> filterNeumaticos(ArrayList<ArrayList<Pieza>> combinaciones) {
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de piezas mostrando solo los neumaticos
         * Parametros de entrada:  combinaciones de tipo ArrayList<ArrayList<Pieza>>
         * Parametros de salida: ArrayList<Pieza>
         */

        ArrayList<Pieza> neumaticos = new ArrayList<Pieza>();
        for (ArrayList<Pieza> combinacion : combinaciones) {
            for (Pieza pieza : combinacion) {
                if (pieza.getTipo().equals("N")) {
                    neumaticos.add(pieza);
                }
            }
        }
        // neumaticos distintos
        ArrayList<Pieza> neumaticosDistintos = new ArrayList<Pieza>();
        for (Pieza neumatico : neumaticos) {
            if (!neumaticosDistintos.contains(neumatico)) {
                neumaticosDistintos.add(neumatico);
            }
        }
        return neumaticosDistintos;
    }

    public static ArrayList<Pieza> filterMotores(ArrayList<ArrayList<Pieza>> combinaciones) {
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de piezas mostrando solo los motores
         * Parametros de entrada:  combinaciones de tipo ArrayList<ArrayList<Pieza>>
         * Parametros de salida: ArrayList<Pieza>
         */
        ArrayList<Pieza> motores = new ArrayList<Pieza>();
        for (ArrayList<Pieza> combinacion : combinaciones) {
            for (Pieza pieza : combinacion) {
                if (pieza.getTipo().equals("M")) {
                    motores.add(pieza);
                }
            }
        }
        // motores distintos
        ArrayList<Pieza> motoresDistintos = new ArrayList<Pieza>();
        for (Pieza motor : motores) {
            if (!motoresDistintos.contains(motor)) {
                motoresDistintos.add(motor);
            }
        }
        return motoresDistintos;
    }

    public static ArrayList<Pieza> piezasDisponibles() {
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de piezas mostrando solo las piezas que no estan danadas
         * Parametros de entrada:  combinaciones de tipo ArrayList<ArrayList<Pieza>>
         * Parametros de salida: ArrayList<Pieza>
         */

        ArrayList<Pieza> piezasDisponibles = new ArrayList<Pieza>();
        for (Pieza pieza : Pieza.piezas) {
            if (!pieza.isDanado()) {
                piezasDisponibles.add(pieza);
            }
        }
        return piezasDisponibles;
    }

    public static ArrayList<Pieza> motoresDisponibles(String marca) {
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de piezas mostrando solo las piezas que no estan danadas, son motores y son de una marca especifica
         * Parametros de entrada:  marca de tipo String
         * Parametros de salida: ArrayList<Pieza>
         */
        ArrayList<Pieza> motoresDisponibles = new ArrayList<Pieza>();
        ArrayList<Pieza> piezasDisponibles = Pieza.piezasDisponibles();
        for (Pieza pieza : piezasDisponibles) {
            if (pieza.getTipo().equals("M") && pieza.getMarca().equals(marca)) {
                motoresDisponibles.add(pieza);
            }
        }
        return motoresDisponibles;
    }

    public static ArrayList<Pieza> neumaticosDisponibles(String marca){
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de piezas mostrando solo las piezas que no estan danadas, son neumaticos y son de una marca especifica
         * Parametros de entrada:  marca de tipo String
         * Parametros de salida: ArrayList<Pieza>
         */
        ArrayList<Pieza> neumaticosDisponibles = new ArrayList<Pieza>();
        ArrayList<Pieza> piezasDisponibles = Pieza.piezasDisponibles();
        for (Pieza pieza : piezasDisponibles) {
            if (pieza.getTipo().equals("N") && pieza.getMarca().equals(marca)) {
                neumaticosDisponibles.add(pieza);
            }
        }
        return neumaticosDisponibles;
    }

    public static ArrayList<Pieza> aleronesDisponibles(String marca) {
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de piezas mostrando solo las piezas que no estan danadas, son alerones y son de una marca especifica
         * Parametros de entrada:  marca de tipo String
         * Parametros de salida: ArrayList<Pieza>
         */
        ArrayList<Pieza> aleronesDisponibles = new ArrayList<Pieza>();
        ArrayList<Pieza> piezasDisponibles = Pieza.piezasDisponibles();
        for (Pieza pieza : piezasDisponibles) {
            if (pieza.getTipo().equals("A") && pieza.getMarca().equals(marca)) {
                aleronesDisponibles.add(pieza);
            }
        }
        return aleronesDisponibles;
    }

    public static double precioTotal(ArrayList<Pieza> piezas, VehiculoCarrera vehiculoCarrera) {
        /***
         * Descripcion del metodo: este metodo se encarga de asignar al vehiculo las piezas por comprar y calcula el precio de toda la compra
         * Parametros de entrada:  marca de tipo String
         * Parametros de salida: double
         */
        double precioTotal = 0;
        for (Pieza pieza : piezas) {
            precioTotal += pieza.getPrecio();
        }
        vehiculoCarrera.setPiezasComprar(piezas);
        return precioTotal;
    }

    public void redondear() {
        this.precio = dosDecimales(this.precio);
        this.velocidadAnadida = dosDecimales(this.velocidadAnadida);
        this.maniobrabilidadAnadida = dosDecimales(this.maniobrabilidadAnadida);
    }

    {
        this.redondear();
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
