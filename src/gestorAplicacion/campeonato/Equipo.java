package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Patrocinador;
import gestorAplicacion.paddock.Piloto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class Equipo implements Serializable {
    private static final long serialVersionUID = 6129409994157579682L;

    public static ArrayList<Equipo> equipos = new ArrayList<Equipo>(); //Lista de equipos

    //Atributos
    static int idActual = 0;
    private int id;
    private String nombre;
    private double plata;
    private int puntos; //Puntos que lleva el equipo en el campeonato
    private boolean ocupado = false; //Si el equipo esta ocupado, se puede jugar
    private ArrayList<Ciudad> sedes = new ArrayList<Ciudad>(); //Lista de ciudades donde se puede ubicar la sede del equipo
    private ArrayList<Patrocinador> patrocinadoresEquipo = new ArrayList<Patrocinador>(); //Lista de patrocinadores que patrocinan al equipo TODO: Perdon, toque tu clase :,(

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
            if (random.nextInt(5) == 3) {
                this.agregarSede(ciudad);
            }
        }
        Equipo.equipos.add(this);
        this.crewMembers = (int) (Math.random() * 5);
    }


    // M�todos de clase
    public static ArrayList<Equipo> getEquipos() {
        return null;
    }

    public static void setEquipos(ArrayList<Equipo> equipos) {
        Equipo.equipos = equipos;
    }

    public static ArrayList<Equipo> equiposContinente(Campeonato campeonato) {
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
        ArrayList<Equipo> equiposDisponibles = new ArrayList<Equipo>();
        for (Equipo equipo : equipos) {
            if (!equipo.isOcupado()) {
                equiposDisponibles.add(equipo);
            }
        }
        return equiposDisponibles;
    }

    public static ArrayList<Equipo> equiposContrato() {
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

    public static ArrayList<Equipo> elegirContrincantes(Equipo equipo, Campeonato campeonato, ArrayList<Equipo> equipos) {
        ArrayList<Equipo> contrincantes = new ArrayList<Equipo>();

        // Elegir 9 contrincantes
        int n = 0;
        while (n < 5) {
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

    // M�todos de instancia
    /*public boolean negociar(Patrocinador patrocinador) {
        //Esto es para aceptar las probabilidades de que acepte un patrocinador
        return patrocinador.pensarNegocio(this);
    }*/

/*    public String negociar(double cantidad, Patrocinador patrocinador) {//Sobrecarga para cambiar el dinero que se le pide al patrocinador. A menor cantidad, mayor probabilidad de aceptar.
        if (cantidad < 0) {
            //System.out.println("Esa es una cantidad de dinero negativa. �Acaso piensas en patrocinar al patrocinador?");
            return "Esa es una cantidad de dinero negativa. �Acaso piensas en patrocinar al patrocinador?";
        } else if (cantidad == 0) {
            //System.out.println("�Por qu� 0? �Es que no quieres dinero?");
            return "�Por qu� 0? �Es que no quieres dinero?";
        } else if (cantidad > patrocinador.getDinero()) {
            patrocinador.setPatrocinando(true);
            //System.out.println("�Eso es m�s dinero del que puede dar! \n!Has asustado al patrocinador!");
            return "�Eso es m�s dinero del que puede dar! \n!Has asustado al patrocinador!";
        } else {
            this.negociar(patrocinador);
            return "�Se ha evaluado la opcion de patrocinar a tu equipo!";
        }
    }*/


/*    public void negociar(Patrocinador patrocinador, boolean equipoNoElegido) {
        //Sobrecarga: Esto es para ver si alg�n equipo que no es elegido por el usuario es patrocinado por alg�n patrocinador
        patrocinador.pensarNegocio(this, equipoNoElegido);
    }*/

    public static int getIdActual() {
        return idActual;
    }

    public static void setIdActual(int idActual) {
        Equipo.idActual = idActual;
    }

    public void recibirPlata(double plata) {
        this.setPlata(this.getPlata() + plata);
    }

    public boolean descuento(double precioTotal, VehiculoCarrera vehiculoCarrera) {
        Piloto piloto = vehiculoCarrera.getPiloto();
        // si la habiliad del piloto es mayor al porcentaje que es preciototal del dinero del equipo se hace descuento
        return piloto.getHabilidad() > (precioTotal / this.getPlata());
    }

    public double calcularDescuento(double precioTotal, VehiculoCarrera vehiculoCarrera) {
        Piloto piloto = vehiculoCarrera.getPiloto();
        double descuento = 0;
        double porcentaje = 0;
        if (piloto.getHabilidad() > (precioTotal / this.getPlata())) {
            descuento = precioTotal * (piloto.getHabilidad() - (precioTotal / this.getPlata()));
            // calcular porcentaje
            porcentaje = descuento / precioTotal;
        }
        return porcentaje;
    }

    public void comprarPiezas(double precioTotal, VehiculoCarrera vehiculoCarrera) {
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

    // Lista de m�todos set y get
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
                patrocinador.setPlata(patrocinador.getPlata() + this.plata*2);
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
}
