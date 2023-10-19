package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.DirectorCarrera;
import gestorAplicacion.campeonato.Equipo;
import gestorAplicacion.campeonato.Campeonato;
import gestorAplicacion.campeonato.VehiculoCarrera;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Piloto extends Persona implements Serializable{
	private static final long serialVersionUID = 2266843321181044951L;
	
	private Equipo contrato;
    private int puntos; //Puntos en el campeonato 
    private int sanciones;
    private double habilidad; //Probabilidad de chocarse
    private ArrayList<String> victorias = new ArrayList<String>();
    //Lista de pilotos
	public static ArrayList<Piloto> listaPilotos = new ArrayList<Piloto>();
    private boolean lesionado = false; //Si el piloto esta disponible, se puede contratar

    private boolean desbloqueado = false; // Si el piloto esta desbloqueado, se puede jugar
    private boolean elegido = false;

    private double valorContrato;

    private double presupuestoVehiculo;
    private Patrocinador patrocinador;


    //Constructores


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

    public Piloto(String nombre){
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
    
    //Metodos de instancia
    public void sumarPuntos(int puntos) {
    	this.puntos+=puntos;
    }
    
    public void agregarVictoria(Campeonato campeonato) {
    	victorias.add(campeonato.toString());
    }

    public void contratar(Equipo equipo) {
        equipo.setPlata(equipo.getPlata()-this.valorContrato);
        this.setPresupuestoVehiculo(this.valorContrato * this.habilidad * 10);
    }

    public VehiculoCarrera maldecirPiloto(double plata, Piloto piloto, DirectorCarrera directorCarrera){
        //Busqueda del carro
        VehiculoCarrera vehiculoMaldito = null;
        for (VehiculoCarrera vehiculoCarrera : VehiculoCarrera.getListaVehiculosCarrera()){
            if (vehiculoCarrera.getPiloto().equals(this)) {
                vehiculoMaldito = vehiculoCarrera;
            }
        }
        //Maldecir al piloto y al vehiculo
        double difHabilidad = this.getHabilidad();
        if (plata>=this.getValorContrato()){
            this.setHabilidad(0);
            vehiculoMaldito.setProbabilidadChoque(vehiculoMaldito.getProbabilidadChoque()+difHabilidad);
        } else if(plata>=this.getValorContrato()/2) {
            this.setHabilidad(this.getHabilidad()/2);
            vehiculoMaldito.setProbabilidadChoque(vehiculoMaldito.getProbabilidadChoque()+difHabilidad/2);
        } else {
            directorCarrera.ponerSancion(piloto);
        }
        return vehiculoMaldito;
    }

    //Metodo abstracto heredado
    public void recibirPlata(double plata){
        this.getEquipo().setPlata(this.getEquipo().getPlata()+plata);
    }
    
    // Metodos de clase
    public static Piloto pilotoAleatorio() {
    	int n = (int) (Math.random()*Piloto.listaPilotos.size());
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
            if (piloto.getEquipo() == equipo) {
                pilotosEquipo.add(piloto);
            }
        }
    	return pilotosEquipo;

    }

    public static void asignarEquipo(){
        ArrayList<Piloto> pilotos = Piloto.listaPilotos;
        Collections.shuffle(pilotos);
        int i = 0;
        int c = 0;
        for (Piloto piloto: pilotos) {
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
        piloto.contratar(equipo);
        return piloto;
    }

    public void noEsElegido(){
        this.setElegido(false);
        VehiculoCarrera.crearVehiculoPilotosNoElegidos(this);
    }

    // Lista de metodos set y get
    public void setVictorias(ArrayList<String> victorias) {
        this.victorias = victorias;
    }

    public static void setListaPilotos(ArrayList<Piloto> listaPilotos) {
        Piloto.listaPilotos = listaPilotos;
    }

    public boolean isDesbloqueado() {
        return desbloqueado;
    }

    public void setDesbloqueado(boolean desbloqueado) {
        this.desbloqueado = desbloqueado;
    }

    public int getPuntos() {return this.puntos;}
    public void setPuntos(int puntos) {this.puntos = puntos;}

    public int getSanciones() {return this.sanciones;}
    public void setSanciones(int sanciones) {this.sanciones = sanciones;}

    public double getHabilidad() {return this.habilidad;}
    public void setHabilidad(double hab) {this.habilidad = hab;}

    public boolean isLesionado() {return this.lesionado;}
    public void setLesionado(boolean disp) {this.lesionado = disp;}

    public ArrayList<String> getVictorias() {return victorias;}
    
    public static ArrayList<Piloto> getListaPilotos() {return Piloto.listaPilotos;}

    public Equipo getEquipo() {return this.contrato;}

    public void setEquipo(Equipo equipo) {this.contrato = equipo;}

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

    static Random random = new Random();

    public void sinPlata() {
        this.getEquipo().recibirPlata((Math.random() * 90000) + 10000);
    }
}
