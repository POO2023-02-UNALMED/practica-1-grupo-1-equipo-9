package gestorAplicacion.campeonato;

import java.util.ArrayList;
import gestorAplicacion.paddock.Piloto;
import gestorAplicacion.campeonato.VehiculoCarrera;

//Atributos
//        double plata
//        boolean licencia
//        Carrera carrera
//        int corrupcion
//        Métodos
//        void ponerSancion(Piloto piloto) //le coloca una sanción
//        ArrayList<String> favoresEspeciales(double plata) //Recibe el dinero y devuelve las acciones
//        int verStatsCompetidores(double platametida) //Devuelve lo de las sanciones
//        int cambiarPosIniciales(double platametida,int posicion) //Devuelve sanciones
//        int tunearShaddy(double platametida, VehiculoCarrera veh)
//        int hacerChocar(double platametida, VehiculoCarrera vehChocar) //Update chocado to true.
//        int apuestasSubterraneas(double plata, VehiculoCarrera veh) // Triki

public class DirectorCarrera {
    private double plata;
    private boolean licencia;
    private Carrera carrera;
    private int corrupcion;

    public void ponerSancion(Piloto piloto) {
        piloto.setSancion(Piloto.getSancion() + 1);
    }

    public ArrayList<String> favoresEspeciales(double plata) {
        return null;
    }

    public int verStatsCompetidores(double platametida) {
        return 0;
    }

    public int cambiarPosIniciales(double platametida,int posicion) {
        return 0;
    }

    public int tunearShaddy(double platametida, VehiculoCarrera vehiculoCarrera) {
        return 0;
    }

    public int hacerChocar(double platametida, VehiculoCarrera vehiculoCarrera) {
        return 0;
    }

    public int apuestasSubterraneas(double plata, VehiculoCarrera vehiculoCarrera) {
        return 0;
    }
}
