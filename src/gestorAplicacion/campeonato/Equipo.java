package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Patrocinador;
import gestorAplicacion.paddock.Piloto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;


public class Equipo implements Serializable {
	
	   /***
     * Autores: David Toro Arboleda, Santiago Lopez Ayala, Juan Andres Jimenez Velez, Mariana Valencia Cubillos, Samuel Mira Alvarez
     * Descripcion de la clase: Esta clase se encarga de la creacion y gention de los quipos que seran utlizados en los campeonatos
     */
	
    private static final long serialVersionUID = 6129409994157579682L;

    public static ArrayList<Equipo> equipos = new ArrayList<Equipo>(); //Lista de equipos
    public static Equipo equipoElegido;

    //Atributos
    static int idActual = 0;
    private int id;
    private String nombre;
    private double plata;
    private int puntos; //Puntos que lleva el equipo en el campeonato
    private boolean ocupado = false; //Si el equipo esta ocupado, no se puede jugar
    private ArrayList<Ciudad> sedes = new ArrayList<Ciudad>(); //Lista de ciudades donde se puede ubicar la sede del equipo
    private ArrayList<Patrocinador> patrocinadoresEquipo = new ArrayList<Patrocinador>(); //Lista de patrocinadores que patrocinan al equipo

    private boolean elegido = false;
    private int crewMembers = 5;

    private int cantContratos = 0;

    // Constructores
    public Equipo() {
        this.id = idActual++;
        this.nombre = "";
        this.plata = 0;
        this.puntos = 0;
        Equipo.equipos.add(this);
    }

    public Equipo(int id, String nombre, double plata, int puntos, boolean ocupado, ArrayList<Ciudad> sedes, ArrayList<Patrocinador> patrocinadoresEquipo, boolean elegido, int crewMembers, int cantContratos) {
        this.id = id;
        this.nombre = nombre;
        this.plata = plata;
        this.puntos = puntos;
        this.ocupado = ocupado;
        this.sedes = sedes;
        this.patrocinadoresEquipo = patrocinadoresEquipo;
        this.elegido = elegido;
        this.crewMembers = crewMembers;
        this.cantContratos = cantContratos;
    }

    public Equipo(String nombre, double plata, int puntos, ArrayList<Piloto> pilotosDisponibles) {
        this.id = idActual++;
        this.nombre = nombre;
        this.plata = plata;
        this.puntos = puntos;
        Equipo.equipos.add(this);

    }

    public Equipo(int id, String nombre, double plata, int puntos, boolean ocupado, ArrayList<Piloto> pilotosDisponibles, ArrayList<Ciudad> sedes, ArrayList<Patrocinador> patrocinadoresEquipo) {
        this.id = id;
        this.nombre = nombre;
        this.plata = plata;
        this.puntos = puntos;
        this.ocupado = ocupado;

        this.sedes = sedes;
        this.patrocinadoresEquipo = patrocinadoresEquipo;
        Equipo.equipos.add(this);
    }

    public Equipo(String nombre) {
        this.id = idActual++;
        this.nombre = nombre;
        this.plata = 0;
        this.puntos = 0;
        Random random = new Random();
        for (Ciudad ciudad : Ciudad.getListaCiudades()) {
            if (random.nextInt(10) == 3) {
                this.agregarSede(ciudad);
            }
        }
        Equipo.equipos.add(this);
        this.crewMembers = (int) (Math.random() * 5);
    }


    // Metodos de clase
    public static ArrayList<Equipo> organizarEquiposPuntos(Campeonato campeonato) {
        /***
         * Descripcion del metodo: este metodo se encarga de organizar los equipos de un campeonato segun sus puntos
         * Parametros de entrada: campeonato de tipo Campeonato
         * Parametros de salida: ArrayList<Equipo>
         */
        ArrayList<Equipo> listaOrganizada = new ArrayList<Equipo>();
        for (Equipo equipo : campeonato.getListaEquipos()) {
            listaOrganizada.add(equipo);
            equipo.setPuntos(Math.abs(equipo.getPuntos()));
        }
        listaOrganizada.sort(Comparator.comparing(Equipo::getPuntos).reversed());
        return listaOrganizada;
    }

    public static void setEquipos(ArrayList<Equipo> equipos) {
        Equipo.equipos = equipos;
    }

    public static ArrayList<Equipo> equiposContinente(Campeonato campeonato) {
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de equipos, segun su continente
         * Parametros de entrada:  campeonato de tipo Campeonato
         * Parametros de salida: ArrayList<Equipo>
         */
        Continente continente = campeonato.getContinente();
        ArrayList<Equipo> equiposContinente = new ArrayList<Equipo>();
        for (Equipo equipo : equipos) {
            for (Ciudad ciudad : equipo.getSedes()) {
                if (ciudad.getContinente() == continente) {
                    equiposContinente.add(equipo);
                    break;
                }
            }
        }
        return equiposContinente;
    }

    public static ArrayList<Equipo> equiposDisponibles(ArrayList<Equipo> equipos) {
    	
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de equipos disponibles para un campeonato, segun su atributo ocupado.
         * Parametros de entrada:  ArrayList<Equipo>
         * Parametros de salida: ArrayList<Equipo>
         */
    	
        ArrayList<Equipo> equiposDisponibles = new ArrayList<Equipo>();
        for (Equipo equipo : equipos) {
            if (!equipo.isOcupado()) {
                equiposDisponibles.add(equipo);
            }
        }
        return equiposDisponibles;
    }

    public static ArrayList<Equipo> equiposContrato() {
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de equipos según su cantidad de contratos, dada por su atributo CantContratos
         * Parametros de entrada:  sin argumentos
         * Parametros de salida: ArrayList<Equipo>
         */
    	
        ArrayList<Equipo> equiposContrato = new ArrayList<Equipo>();
        for (Equipo equipo : equipos) {
            if (equipo.getCantContratos() == 0) {
                equiposContrato.add(equipo);
            }
        }
        if (equiposContrato.isEmpty()) {
            for (Equipo equipo : equipos) {
                if (equipo.getCantContratos() == 1) {
                    equiposContrato.add(equipo);
                }
            }
        }
        if (equiposContrato.isEmpty()) {
            for (Equipo equipo : equipos) {
                if (equipo.getCantContratos() == 2) {
                    equiposContrato.add(equipo);
                }
            }
        }
        if (equiposContrato.isEmpty()) {
            equiposContrato = equipos;
        }
        return equiposContrato;
    }

    public static void equiposOcupados(ArrayList<Equipo> equipos) {
        /***
         * Descripcion del metodo: este metodo se encarga de cambiar el estado ocupado a disponible, de los equipos que se pasan como parametro 
         * Parametros de entrada:  ArrayList<Equipo>
         * Parametros de salida: void
         */
        for (Equipo equipo : equipos) {
            equipo.setOcupado(true);
        }
    }

    public static ArrayList<Equipo> elegirContrincantes(Equipo equipo, Campeonato campeonato, ArrayList<Equipo> equipos) {
    	
        /***
         * Descripcion del metodo: este metodo se encarga de seleccionar y asignar los equipos contrincantes en el campeonato.
         * Parametros de entrada:  equipo de tipo Equipo, campeonato de tipo Campeonato, ArrayList<Equipo> 
         * Parametros de salida: ArrayList<Equipo>
         */
    	
        ArrayList<Equipo> contrincantes = new ArrayList<Equipo>();

        // Elegir 9 contrincantes
        int n = 0;
        while (n < 4) {
            int i = (int) (Math.random() * equipos.size());
            Equipo contrincante = equipos.get(i);
            if (contrincante != equipo && !contrincantes.contains(contrincante)) {
                // Si el contrincante no es el mismo equipo y no esta en la lista de contrincantes
                contrincantes.add(contrincante);
                n++;
            }
        }
        campeonato.setListaEquipos(contrincantes);
        // poner equipos como ocupados y no elegidos
        for (Equipo equipo1 : contrincantes) {
            equipo1.setOcupado(true);
            equipo1.setElegido(false);
        }
        contrincantes.add(0, equipo);

        return contrincantes;
    }

    public static int getIdActual() {
        return idActual;
    }

    public static void setIdActual(int idActual) {
        Equipo.idActual = idActual;
    }

    public static void puntuarEquipos(ArrayList<VehiculoCarrera> terminados, double plata, Campeonato campeonato) {
    	
        /***
         * Descripcion del metodo: este metodo se encarga asignar los puntos actaules a los equipos del campeonato.
         * Parametros de entrada:  ArrayList<VehiculoCarrera> , plata de tipo double,  campeonato de tipo Campeonato
         * Parametros de salida: void
         */
    	
        int puntosActuales = 13;
        for (VehiculoCarrera vehiculo : terminados) {
            if (!vehiculo.isMorido()) {
                vehiculo.getPiloto().setPuntos(vehiculo.getPiloto().getPuntos() + puntosActuales);
                vehiculo.getPiloto().getEquipo().recalcularPuntos(campeonato);
                if (puntosActuales >= 8) {
                    puntosActuales -= 2;
                } else {
                    puntosActuales--;
                }
            }
            if (vehiculo.getPiloto().getSanciones() != 0) {
                vehiculo.getPiloto().setPuntos(vehiculo.getPiloto().getPuntos() + puntosActuales);
            }
            vehiculo.getPiloto().registrarTiempo(vehiculo.getTiempo());
        }
        terminados.get(0).getPiloto().recibirPlata(plata * 0.9);
        for (Patrocinador patrocinador : terminados.get(0).getPiloto().getEquipo().getPatrocinadoresEquipo()) {
            patrocinador.recibirPlata(plata * 0.5);
        }
        terminados.get(1).getPiloto().recibirPlata(plata * 0.3);
        terminados.get(2).getPiloto().recibirPlata(plata * 0.2);
        Equipo.organizarEquiposPuntos(campeonato);
    }

    //Metodos de instancia
    public void recalcularPuntos(Campeonato campeonato) {
    	
        /***
         * Descripcion del metodo: este metodo se encarga de recalcular los puntos del campeonato.
         * Parametros de entrada:  campeonato de tipo Campeonato
         * Parametros de salida: void
         */
    	
        int nuevosPuntos = 0;
        for (Piloto piloto : campeonato.getListaPilotos()) {
            if (piloto.getEquipo().equals(this)) {
                nuevosPuntos += piloto.getPuntos();
            }
        }
        this.setPuntos(nuevosPuntos);
    }

    public void recibirPlata(double plata) {
        this.setPlata(this.getPlata() + plata);
    }

    public boolean descuento(double precioTotal, VehiculoCarrera vehiculoCarrera) {
        /***
         * Descripcion del metodo: este metodo se encarga de calcular si se hace desceunto, si la habiliad del piloto es mayor al porcentaje que es preciototal del dinero del equipo se hace descuento.
         * Parametros de entrada:   precioTotal de tipo double, vehiculoCarrera de tipo vehiculoCarrera
         * Parametros de salida: boolean
         */
        Piloto piloto = vehiculoCarrera.getPiloto();
        // si la habiliad del piloto es mayor al porcentaje que es preciototal del dinero del equipo se hace descuento
        return piloto.getHabilidad() > (precioTotal / this.getPlata());
    }

    public double calcularDescuento(double precioTotal, VehiculoCarrera vehiculoCarrera) {
        /***
         * Descripcion del metodo: este metodo se encarga de calcular el % de descuento.
         * Parametros de entrada:   precioTotal de tipo double, vehiculoCarrera de tipo vehiculoCarrera
         * Parametros de salida: boolean
         */
        Piloto piloto = vehiculoCarrera.getPiloto();
        double descuento = 0;
        double porcentaje = 0;
        if (piloto.getHabilidad() > (precioTotal / this.getPlata())) {
            descuento = precioTotal * (piloto.getHabilidad() - (precioTotal / this.getPlata()));
            // calcular porcentaje
            porcentaje = descuento / precioTotal;
        }
        return porcentaje * 100;
    }

    public void comprarPiezas(double precioTotal, VehiculoCarrera vehiculoCarrera) {
        /***
         * Descripcion del metodo: este metodo se encarga de comprar las piezas para los vehiculos.
         * Parametros de entrada:   precioTotal de tipo double, vehiculoCarrera de tipo vehiculoCarrera
         * Parametros de salida: void
         */
        double descuento = this.calcularDescuento(precioTotal, vehiculoCarrera);
        double precioFinal = precioTotal - descuento * precioTotal;
        this.setPlata(this.getPlata() - precioFinal);
        vehiculoCarrera.configurarVehiculo(vehiculoCarrera.getPiezasComprar());
    }

    public void agregarPatrocinador(Patrocinador patrocinador) {
        this.patrocinadoresEquipo.add(patrocinador);
    }

    public void agregarSede(Ciudad ciudad) {
        this.sedes.add(ciudad);
    }

    // Lista de metodos set y get
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPlata() {
        return this.plata;
    }

    public void setPlata(double plata) {
        double decimales = Math.round(plata * 100.0) / 100.0;
        this.plata = decimales;
        if (this.plata < 0) {
            for (Patrocinador patrocinador : this.patrocinadoresEquipo) {
                // el patrocinador le da mas plata al equipo
                patrocinador.setPlata(patrocinador.getPlata() + this.plata * 2);
                this.setPlata(Math.abs(this.plata));
            }
        }
    }

    public int getPuntos() {
        return this.puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public ArrayList<Patrocinador> getPatrocinadoresEquipo() {
        return patrocinadoresEquipo;
    }

    public void setPatrocinadoresEquipo(ArrayList<Patrocinador> patrocinadoresEquipo) {
        this.patrocinadoresEquipo = patrocinadoresEquipo;
    }

    public ArrayList<Ciudad> getSedes() {
        return sedes;
    }

    public void setSedes(ArrayList<Ciudad> sedes) {
        this.sedes = sedes;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isElegido() {
        return elegido;
    }

    public void setElegido(boolean elegido) {
        this.elegido = elegido;
    }

    public int getCantContratos() {
        return cantContratos;
    }

    public void setCantContratos(int cantContratos) {
        this.cantContratos = cantContratos;
    }

    public int getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(int crewMembers) {
        this.crewMembers = crewMembers;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo miClase = (Equipo) o;
        return id == miClase.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
