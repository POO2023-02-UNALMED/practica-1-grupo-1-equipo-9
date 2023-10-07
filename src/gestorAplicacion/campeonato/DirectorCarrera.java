package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Persona;
import gestorAplicacion.paddock.Piloto;
import gestorAplicacion.paddock.Pieza;
import gestorAplicacion.campeonato.VehiculoCarrera;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.ToDoubleBiFunction;


public class DirectorCarrera extends Persona {
    //Lista directores de carrera
    public static ArrayList<DirectorCarrera> listaDirectores= new ArrayList<DirectorCarrera>();
	
	private double plata;
    private boolean licencia;
    private Carrera carrera;
    private int corrupcion;

    // Constructores
    public DirectorCarrera() {
        super();
    }

    public DirectorCarrera(String nombre, String pais, double plata, boolean licencia) {
        super(nombre, pais);
        this.plata = plata;
        this.licencia = licencia;
        this.corrupcion = 0;
        DirectorCarrera.listaDirectores.add(this);
    }

    public DirectorCarrera(String nombre, String pais, double plata, boolean licencia, Carrera carrera, int corrupcion) {
        super(nombre, pais);
        this.plata = plata;
        this.licencia = licencia;
        this.carrera = carrera;
        this.corrupcion = corrupcion;
        DirectorCarrera.listaDirectores.add(this);
    }
    //Metodo abstracto heredado
    public void recibirPlata(double plata) {
        this.setPlata(this.getPlata()+plata);
    }
    // Métodos de instancia
    public void ponerSancion(Piloto piloto) {
        piloto.setSanciones(piloto.getSanciones() + 1);
    }

    public ArrayList<String> favoresEspeciales(double plata, Equipo equipo) {
        equipo.setPlata(equipo.getPlata() - plata); // Se le quita la plata al equipo
        ArrayList<String> favores = new ArrayList<>();
        favores.add("Ver stats de competidores");
        favores.add("Cambiar posición inicial");
        favores.add("Comprar partes de contrabando para el vehículo");
        favores.add("Hacer chocar");
        favores.add("Apuestas subterráneas");
        return favores;
    }

    public ArrayList<ArrayList<String>> verStatsCompetidores() {
        double precio = 1000000;
        ArrayList<ArrayList<String>> listaStats = new ArrayList<>();
        if (Equipo.equipoElegido.getPlata() >= precio) {
            this.corrupcion += 1;
            Equipo equipo = Equipo.equipoElegido;
            equipo.setPlata(equipo.getPlata() - plata); // Se le quita la plata al equipo
            ArrayList<VehiculoCarrera> listaCompetidores = this.carrera.getPosiciones();
            for (VehiculoCarrera vc : listaCompetidores) {
                ArrayList<String> stats = new ArrayList<>();
                Piloto piloto = vc.getPiloto();
                stats.add(piloto.getNombre());
                stats.add(String.valueOf(piloto.getSanciones()));
                stats.add(String.valueOf(piloto.getHabilidad()));
                listaStats.add(stats);
            }
        }
        return listaStats;
    }

    public ArrayList<VehiculoCarrera> cambiarPosIniciales(int posicion) {
        double precio = 1000000;
        Equipo equipo = Equipo.equipoElegido;
        if (Equipo.equipoElegido.getPlata() >= precio) {
            this.corrupcion += 1;
            equipo.setPlata(equipo.getPlata() - plata); // Se le quita la plata al equipo
            // Cambiar posiciones metodo carrera
            // TODO
        }
        return this.carrera.getPosiciones();
    }

    // Para tunear Shaddy primero hay que comprar la pieza de contrabando
    // El proceso es el mismo que comprar una pieza normal
    public void tunearShaddy(Pieza pieza, int parte) {
        double precio = 1000000;
        Equipo equipo = Equipo.equipoElegido;
        if (Equipo.equipoElegido.getPlata() >= precio) {
            this.corrupcion += 1;
            equipo.setPlata(equipo.getPlata() - precio); // Se le quita la plata al equipo
            switch (parte) {
                case 1: // Neuamaticos
                    VehiculoCarrera.vehiculoElegido.setNeumaticos(pieza);
                    break;
                case 2: // Motor
                    VehiculoCarrera.vehiculoElegido.setMotor(pieza);
                    break;
                case 3: // Aleron
                    VehiculoCarrera.vehiculoElegido.setAleron(pieza);
                    break;
            }
        }
    }

    //Para hacer chocar primero hay que elegir a quien se va a chocar de la lista de puestos
    public void hacerChocar(VehiculoCarrera vehiculo) {
        double precio = 1000000;
        if (Equipo.equipoElegido.getPlata() >= precio) {
            this.corrupcion += 1;
            Equipo.equipoElegido.setPlata(Equipo.equipoElegido.getPlata() - precio); // Cobrar
            vehiculo.chocar();
        }
    }

    public boolean apuestasSub(double plataMetida, int numero) {
        this.corrupcion += 1;
        Equipo equipo = Equipo.equipoElegido;
        equipo.setPlata(equipo.getPlata() - plataMetida); // Se le quita la plata al equipo
        Random random = new Random(); // Generador de números aleatorios
        int randomNumber = random.nextInt(15) + 1; // Número aleatorio entre 1 y 15
        if (numero == randomNumber) {
            equipo.setPlata(equipo.getPlata() + plataMetida * 2); // Se le da el doble de plata al equipo
            return true;
        } else {
            return false;
        }
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public boolean isLicencia() {
        return licencia;
    }

    public void setLicencia(boolean licencia) {
        this.licencia = licencia;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getCorrupcion() {
        return corrupcion;
    }

    public void setCorrupcion(int corrupcion) {
        this.corrupcion = corrupcion;
    }
}
