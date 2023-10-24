package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class Piloto extends Persona implements Serializable, Decimales {
    private static final long serialVersionUID = 2266843321181044951L;
    //Lista de pilotos
    public static ArrayList<Piloto> listaPilotos = new ArrayList<Piloto>();
    static Random random = new Random();
    public ArrayList<String> victorias = new ArrayList<String>();
    private Equipo contrato;
    private int puntos; //Puntos en el campeonato
    private int sanciones;
    private double habilidad; //Probabilidad de chocarse
    private boolean lesionado = false; //Si el piloto esta disponible, se puede contratar
    private boolean desbloqueado = false; // Si el piloto esta desbloqueado, se puede jugar
    private boolean elegido = false;
    private double valorContrato = 0;
    private double presupuestoVehiculo = 0;
    public ArrayList<Double> tiemposCarreras = new ArrayList<Double>();


    //Constructores
    private Patrocinador patrocinador;

    {
        this.redondear();
    }

    public Piloto(String nombre, Equipo contrato, int puntos, int sanciones, double habilidad, boolean lesionado, boolean desbloqueado, boolean elegido, double valorContrato, double presupuestoVehiculo, Patrocinador patrocinador) {
        super(nombre);
        this.contrato = contrato;
        this.puntos = puntos;
        this.sanciones = sanciones;
        this.habilidad = habilidad;
        this.lesionado = lesionado;
        this.desbloqueado = desbloqueado;
        this.elegido = elegido;
        this.valorContrato = valorContrato;
        this.presupuestoVehiculo = presupuestoVehiculo;
        this.patrocinador = patrocinador;
    }

    public Piloto(String nombre, String pais, Equipo contrato, int puntos, int sanciones, double habilidad, ArrayList<String> victorias, boolean lesionado, boolean desbloqueado, boolean elegido, double valorContrato, double presupuestoVehiculo, Patrocinador patrocinador) {
        super(nombre, pais);
        this.contrato = contrato;
        this.puntos = puntos;
        this.sanciones = sanciones;
        this.habilidad = habilidad;
        this.victorias = victorias;
        this.lesionado = lesionado;
        this.desbloqueado = desbloqueado;
        this.elegido = elegido;
        this.valorContrato = valorContrato;
        this.presupuestoVehiculo = presupuestoVehiculo;
        this.patrocinador = patrocinador;
    }

    public Piloto(String nombre) {
        super(nombre);
        this.habilidad = 0.1 + (0.3 - 0.1) * Math.random();
        this.puntos = 0;
        this.sanciones = 0;
        this.lesionado = false;
        this.valorContrato = (int) (Math.random() * 4001) + 1000;
        Piloto.listaPilotos.add(this);
    }

    public static ArrayList<Piloto> pilotosDesbloqueados() {
        ArrayList<Piloto> pilotosDesbloqueados = new ArrayList<Piloto>();
        for (Campeonato campeonato : Campeonato.campeonatosDesbloqueados()) {
            for (Piloto piloto : campeonato.getListaPilotos()) {
                if (piloto.isElegido()) {
                    pilotosDesbloqueados.add(piloto);
                }
            }
        }
        return pilotosDesbloqueados;
    }

    // Metodos de clase
    public static Piloto pilotoAleatorio() {
        int n = (int) (Math.random() * Piloto.listaPilotos.size());
        return Piloto.listaPilotos.get(n);
    }

    public static ArrayList<Piloto> pilotosDisponibles() {
        ArrayList<Piloto> pilotosDisponibles = new ArrayList<Piloto>();
        for (Piloto piloto : Piloto.listaPilotos) {
            if (!piloto.isLesionado()) {
                pilotosDisponibles.add(piloto);
            }
        }
        return pilotosDisponibles;
    }

    public static ArrayList<Piloto> pilotosEquipo(Equipo equipo, ArrayList<Piloto> pilotos) {
        ArrayList<Piloto> pilotosEquipo = new ArrayList<Piloto>();
        for (Piloto piloto : pilotos) {
            if (piloto.getEquipo().equals(equipo)) {
                pilotosEquipo.add(piloto);
            }
        }
        return pilotosEquipo;

    }

    public static void desbloquearPilotos(ArrayList<Piloto> pilotos) {
        for (Piloto piloto : pilotos) {
            piloto.setDesbloqueado(true);
        }
    }

    public static void asignarEquipo() {
        ArrayList<Piloto> pilotos = Piloto.listaPilotos;
        Collections.shuffle(pilotos);
        int i = 0;
        int c = 0;
        for (Piloto piloto : pilotos) {
            if (piloto.getEquipo() == null) {
                piloto.setEquipo(Equipo.equipos.get(i % Equipo.equipos.size()));
                c++;
                if (c % 5 == 0) {
                    i++;
                }
            }
        }
    }

    public static Piloto pilotoContrato(ArrayList<Piloto> pilotos, Equipo equipo) {
        Random rand = new Random();
        int n = rand.nextInt(pilotos.size());
        Piloto piloto = pilotos.get(n);
        piloto.contratar();
        return piloto;
    }

    public static ArrayList<Piloto> getListaPilotos() {
        return Piloto.listaPilotos;
    }

    public static void setListaPilotos(ArrayList<Piloto> listaPilotos) {
        Piloto.listaPilotos = listaPilotos;
    }

    //Metodos de instancia
    public void registrarTiempo (double tiempo){
        this.tiemposCarreras.add(tiempo);
    }
    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public void agregarVictoria(Campeonato campeonato) {
        victorias.add(campeonato.toString());
    }

    public void contratar() {
        Equipo equipo = this.getEquipo();
        equipo.setPlata(equipo.getPlata() - this.valorContrato);
        this.setPresupuestoVehiculo(this.valorContrato * this.habilidad * 10);
    }

    public Piloto buscarPiloto(Piloto piloto) {
        for (Piloto piloto1 : Piloto.listaPilotos) {
            if (piloto1.equals(piloto)) {
                return piloto1;
            }
        }
        return piloto;
    }

    public ArrayList<VehiculoCarrera> maldecirPiloto(double plata, Piloto piloto, DirectorCarrera directorCarrera, Campeonato campeonato) { //Esto es para maldecir a un piloto desde los tratos especiales con el director de carrera
        ArrayList<VehiculoCarrera> vehiculosDevolver = new ArrayList<VehiculoCarrera>();
        vehiculosDevolver.add(VehiculoCarrera.vehiculosPiloto(piloto).get(0));
        VehiculoCarrera vehiculoMaldito = null;
        for (VehiculoCarrera vehiculoCarrera : VehiculoCarrera.getListaVehiculosCarrera()) {
            if (vehiculoCarrera.getPiloto().equals(this)) {
                vehiculoMaldito = vehiculoCarrera;
            }
            if (campeonato.getListaPilotos().contains(vehiculoCarrera.getPiloto()) && vehiculoCarrera.getPiloto() != piloto){
                vehiculosDevolver.add(vehiculoCarrera);
            }
        }
        //Maldecir al piloto dependiendo del dinero que se tenga
        if (plata >= (this.getValorContrato() * 3 / 4)) {
            this.setHabilidad(Math.max(this.getHabilidad()-0.1,0.0));
        } else if (plata >= (this.getValorContrato() / 3)) {
            this.setHabilidad(this.getHabilidad() / 2);
        } else {
            directorCarrera.ponerSancion(piloto);
        }
        return vehiculosDevolver;
    }

    //Metodo abstracto heredado
    public void recibirPlata(double plata) {
        this.getEquipo().setPlata(this.getEquipo().getPlata() + plata);
    }

    public void noEsElegido() {
        this.setElegido(false);
        if (VehiculoCarrera.vehiculosPiloto(this).isEmpty()) {
            VehiculoCarrera.crearVehiculoPilotosNoElegidos(this);
        }
    }

    public boolean isDesbloqueado() {
        return desbloqueado;
    }

    public void setDesbloqueado(boolean desbloqueado) {
        this.desbloqueado = desbloqueado;
    }

    public void redondear() {
        this.habilidad = dosDecimales(this.habilidad);
        this.valorContrato = dosDecimales(this.valorContrato);
        this.presupuestoVehiculo = dosDecimales(this.presupuestoVehiculo);
    }

    public int getPuntos() {
        return this.puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getSanciones() {
        return this.sanciones;
    }

    public void setSanciones(int sanciones) {
        this.sanciones = sanciones;
    }

    public double getHabilidad() {
        return this.habilidad;
    }

    public void setHabilidad(double hab) {
        double habAnterior = this.habilidad;
        this.habilidad = hab;
        ArrayList<VehiculoCarrera> vehiculos = VehiculoCarrera.vehiculosPiloto(this);
        if (!vehiculos.isEmpty()){
            for (VehiculoCarrera vehiculoCarrera : vehiculos){
                vehiculoCarrera.actualizarProbabilidadChoque(this.habilidad-habAnterior);
            }
        }
    }

    public boolean isLesionado() {
        return this.lesionado;
    }

    public void setLesionado(boolean disp) {
        this.lesionado = disp;
    }

    public ArrayList<String> getVictorias() {
        return victorias;
    }

    // Lista de metodos set y get
    public void setVictorias(ArrayList<String> victorias) {
        this.victorias = victorias;
    }

    public Equipo getEquipo() {
        return this.contrato;
    }

    public void setEquipo(Equipo equipo) {
        this.contrato = equipo;
    }

    public Equipo getContrato() {
        return contrato;
    }

    public void setContrato(Equipo contrato) {
        this.contrato = contrato;
    }

    public boolean isElegido() {
        return elegido;
    }

    public void setElegido(boolean elegido) {
        this.elegido = elegido;
    }

    public double getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(double valorContrato) {
        this.valorContrato = valorContrato;
    }

    public double getPresupuestoVehiculo() {
        return presupuestoVehiculo;
    }

    public void setPresupuestoVehiculo(double presupuestoVehiculo) {
        this.presupuestoVehiculo = presupuestoVehiculo;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public ArrayList<Double> getTiemposCarreras() {
        return tiemposCarreras;
    }

    public void setTiemposCarreras(ArrayList<Double> tiemposCarreras) {
        this.tiemposCarreras = tiemposCarreras;
    }

    public void sinPlata() {
        this.getEquipo().recibirPlata((Math.random() * 90000) + 10000);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piloto miClase = (Piloto) o;
        return id == miClase.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
