package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.Equipo;

public class Patrocinador extends Persona {
    // Atributos
    private double dinero;
    private double dineroOfrecer;
    private double probAceptar;
    private Equipo equipoPatrocinado;

    public double getDinero() {
        return this.dinero;
    }

    // Lista de métodos set y get
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public double getProbAceptar() {
        return this.probAceptar;
    }

    public void setProbAceptar(double prob) {
        this.probAceptar = prob;
    }

    public Equipo getEquipo() {
        return this.equipoPatrocinado;
    }

    public void setEquipo(Equipo equipo) {
        this.equipoPatrocinado = equipo;
    }

}
