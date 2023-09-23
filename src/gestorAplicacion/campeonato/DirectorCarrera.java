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

    public DirectorCarrera() {
        super();
    }

    public void ponerSancion(Piloto piloto) {
        piloto.setSanciones(piloto.getSanciones() + 1);
    }

    public ArrayList<String> favoresEspeciales(double plata) {
        ArrayList<String> favores = new ArrayList<>();
        favores.add("Poner sanción");
        favores.add("Cambiar posición inicial");
        favores.add("Tunear vehículo");
        favores.add("Hacer chocar");
        favores.add("Apuestas subterráneas");
        //to-do
        return favores;
    }

    public int verStatsCompetidores(double plataMetida) {
        //to-do
        return 0;
    }

    public int cambiarPosIniciales(double plataMetida, int posicion) {
        int sanciones = 0;
        //to-do
        return sanciones;
    }
}
