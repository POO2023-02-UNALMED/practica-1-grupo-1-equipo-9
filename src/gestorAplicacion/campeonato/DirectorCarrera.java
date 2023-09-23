package gestorAplicacion.campeonato;

import java.util.ArrayList;
import gestorAplicacion.paddock.Piloto;
import gestorAplicacion.paddock.Persona;
import gestorAplicacion.campeonato.VehiculoCarrera;


public class DirectorCarrera extends Persona {
    private double plata;
    private boolean licencia;
    private Carrera carrera;
    private int corrupcion;

    public DirectorCarrera(String nombre, String pais, double plata, boolean licencia, Carrera carrera, int corrupcion) {
        super(nombre, pais);
        this.plata = plata;
        this.licencia = licencia;
        this.carrera = carrera;
        this.corrupcion = corrupcion;
    }

    public DirectorCarrera(String nombre, String pais, double plata, boolean licencia, Carrera carrera) {
        super(nombre, pais);
        this.plata = plata;
        this.licencia = licencia;
        this.carrera = carrera;
        this.corrupcion = 0;
    }

    public DirectorCarrera() {
        super();
    }

    public void ponerSancion(Piloto piloto) {
        piloto.setSanciones(piloto.getSanciones() + 1);
    }

    public ArrayList<String> favoresEspeciales(double plata) {
        ArrayList<String> favores = new ArrayList<>();
        favores.add("Ver stats de competidores");
        favores.add("Cambiar posición inicial");
        favores.add("Comprar partes de contrabando para el vehículo");
        favores.add("Hacer chocar");
        favores.add("Apuestas subterráneas");
        return favores;
    }

    public ArrayList<ArrayList<String>> verStatsCompetidores(double plataMetida) {
        ArrayList<VehiculoCarrera> listaCompetidores = this.carrera.getPosiciones();
        ArrayList<ArrayList<String>> listaStats = new ArrayList<>();
        for (VehiculoCarrera vc : listaCompetidores) {
            ArrayList<String> stats = new ArrayList<>();
            Piloto piloto = vc.getPiloto();
            stats.add(piloto.getNombre());
            stats.add(String.valueOf(piloto.getSanciones()));
            //stats.add(String.valueOf(piloto.getHabilidad())); preguntar
            listaStats.add(stats);
        }
        return listaStats;
    }

    public int cambiarPosIniciales(double plataMetida, int posicion) {
        //llamar metodo en carrera
        return 0;
    }

    public void comprarPartesContrabando(double plataMetida, VehiculoCarrera vehiculo) {
        //llamar metodo en vehiculo
    }

    public void hacerChocar(double plataMetida, VehiculoCarrera vehiculo) {
        //llamar metodo en vehiculo
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
