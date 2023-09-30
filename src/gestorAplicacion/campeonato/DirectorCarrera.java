package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Persona;
import gestorAplicacion.paddock.Piloto;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.ToDoubleBiFunction;


public class DirectorCarrera extends Persona {
    private double plata;
    private boolean licencia;
    private Carrera carrera;
    private int corrupcion;

    // Constructores
    public DirectorCarrera() {
        super();
    }

    public DirectorCarrera(String nombre, String pais, double plata, boolean licencia, Carrera carrera) {
        super(nombre, pais);
        this.plata = plata;
        this.licencia = licencia;
        this.carrera = carrera;
        this.corrupcion = 0;
    }

    public DirectorCarrera(String nombre, String pais, double plata, boolean licencia, Carrera carrera, int corrupcion) {
        super(nombre, pais);
        this.plata = plata;
        this.licencia = licencia;
        this.carrera = carrera;
        this.corrupcion = corrupcion;
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

    public ArrayList<ArrayList<String>> verStatsCompetidores(double plataMetida, Equipo equipo) {
        this.corrupcion += 1;
        equipo.setPlata(equipo.getPlata() - plata); // Se le quita la plata al equipo
        ArrayList<VehiculoCarrera> listaCompetidores = this.carrera.getPosiciones();
        ArrayList<ArrayList<String>> listaStats = new ArrayList<>();
        for (VehiculoCarrera vc : listaCompetidores) {
            ArrayList<String> stats = new ArrayList<>();
            Piloto piloto = vc.getPiloto();
            stats.add(piloto.getNombre());
            stats.add(String.valueOf(piloto.getSanciones()));
            stats.add(String.valueOf(piloto.getHabilidad()));
            listaStats.add(stats);
        }
        return listaStats;
    }

    public ArrayList<VehiculoCarrera> cambiarPosIniciales(double plataMetida, int posicion, Equipo equipo) {
        this.corrupcion += 1;
        equipo.setPlata(equipo.getPlata() - plata); // Se le quita la plata al equipo
        if (plataMetida < 1000000) {
            return this.carrera.getPosiciones();
        } else {
            // Cambiar posiciones metodo carrera
            //TODO
            return this.carrera.getPosiciones();
        }
    }

    public void tunearShaddy(double plataMetida, int idPieza, VehiculoCarrera vehiculo) {
        this.corrupcion += 1;
        //comprar pieza
        //llamar metodo en vehiculo
        //TODO
    }


    public void hacerChocar(double plataMetida, VehiculoCarrera vehiculo) {
        this.corrupcion += 1;
        //llamar metodo en vehiculo
        //TODO
    }


    public void apuestasSub(double plataMetida, int numero, Equipo equipo) {
        this.corrupcion += 1;
        equipo.setPlata(equipo.getPlata() - plataMetida); // Se le quita la plata al equipo
        Random random = new Random(); // Generador de números aleatorios
        int randomNumber = random.nextInt(15) + 1; // Número aleatorio entre 1 y 15
        if (numero == randomNumber) {
            equipo.setPlata(equipo.getPlata() + plataMetida * 2); // Se le da el doble de plata al equipo
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
