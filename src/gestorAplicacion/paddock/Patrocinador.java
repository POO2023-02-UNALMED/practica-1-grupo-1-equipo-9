package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.Equipo;

import java.util.ArrayList;
import java.util.Random;

public class Patrocinador extends Persona {
    //Lista de patrocinadores
    public static ArrayList<Patrocinador> listaPatrocinadores = new ArrayList<Patrocinador>();
    //Atributos
    private double dineroDisponible;
    private double dineroOfrecer;
    private double probAceptar;
    private Equipo equipoPatrocinado;
    private boolean patrocinando;

    //Constructores
    public Patrocinador(String nombre, double dineroDisponible) {
        super(nombre);
        this.dineroDisponible = dineroDisponible;
        Random rand = new Random();
        double lowerBound = 0.2;
        double upperBound = 0.8;
        double numRandom = lowerBound + (upperBound - lowerBound) * rand.nextDouble();
		/*DecimalFormat formato = new DecimalFormat("#.##");
        //this.dineroOfrecer = dineroDisponible*numRandom; //Se le asigna una cantidad del 20% al 80% del dinero que tiene el patrocinador para que lo ofrezca.
		this.dineroOfrecer = Double.parseDouble(formato.format(dineroDisponible*numRandom));*/
        double dineroOfrecer = dineroDisponible * numRandom;
        double dineroOfrecerDecimales = Math.round(dineroOfrecer * 100.0) / 100.0;
        this.dineroOfrecer = dineroOfrecerDecimales; // A ver si asi te corre
        lowerBound = 1.0 - this.dineroOfrecer / dineroDisponible;
        upperBound = 1.0;
        numRandom = lowerBound + (upperBound - lowerBound) * rand.nextDouble();
        this.probAceptar = numRandom; //Se le asigna una probabilidad entre 100% menos la proporción del dinero ofrecido/disponible y 100% (Entre menos dinero ofrecido, más alta la probabilidad de aceptar).
        Patrocinador.listaPatrocinadores.add(this);
    }

    //Metodos de clase
    public static String mostrarPatrocinadores() { //TODO: Preguntar si quieren una tabla diferente
        String tabla = null;
        for (Patrocinador patrocinador : Patrocinador.listaPatrocinadores) {
            if (patrocinador.isPatrocinando()) {
                if (patrocinador.getEquipo() == null) {
                    tabla += patrocinador + "(\n¡No está dispuesto a patrocinar!";
                } else {
                    tabla += patrocinador + "(\n¡Sin equipo patrocinado!";
                }
            } else {
                tabla += patrocinador + "(\nPatrocinando a:" + patrocinador.getEquipo() + ")";
            }
        }
        return tabla;
    }

    public static ArrayList<Patrocinador> getListaPatrocinadores() {
        return listaPatrocinadores;
    }

    //Metodos de instancia
    public String toString() {
        return "Nombre: " + this.getNombre() + "\nCantidad que patrocina:" + this.dineroOfrecer + "\nProbabilidad de aceptar: " + this.probAceptar;
    }

    //Metodo abstracto heredado
    public void recibirPlata(double plata) {
        this.setDinero(this.getDinero() + plata);
    }

    public boolean pensarNegocio(Equipo equipo) {
        Random rand = new Random();
        double lowerBound = 0.0;
        double upperBound = this.probAceptar;
        double numRandom = lowerBound + (upperBound - lowerBound) * rand.nextDouble();
        if (numRandom < this.probAceptar) {
            this.setEquipo(equipo);
            this.equipoPatrocinado.setPlata(this.equipoPatrocinado.getPlata() + this.dineroOfrecer);
            return true;
        } else {
            return false;
        }
    }

    public boolean pensarNegocio(Equipo equipo, boolean equipoNoElegido) { //Sobrecargar para que algunos equipos no elegidos por el usuario puedan ser patrocinados
        Random rand = new Random();
        double lowerBound = 0.0;
        double upperBound = this.probAceptar;
        double numRandom = lowerBound + (upperBound - lowerBound) * rand.nextDouble();
        if (numRandom < this.probAceptar) {
            if (this.setEquipo(equipo)) {
                return false;
            } else {
                this.equipoPatrocinado.setPlata(this.equipoPatrocinado.getPlata() + this.dineroOfrecer);
                return true;
            }
        } else {
            return false;
        }
    }

    //Lista de metodos set y get
    public double getDinero() {
        return this.dineroDisponible;
    }

    public void setDinero(double dinero) {
        this.dineroDisponible = dinero;
    }

    public double getDineroOfrecido() {
        return this.dineroOfrecer;
    }

    public void setDineroOfrecido(double dinero) {
        this.dineroOfrecer = dinero;
        Random rand = new Random();
        double lowerBound = 1.0 - this.dineroOfrecer / dineroDisponible;
        double upperBound = 1.0;
        this.probAceptar = lowerBound + (upperBound - lowerBound) * rand.nextDouble(); //Se le asigna una probabilidad entre 100% menos la proporción del dinero ofrecido/disponible y 100% (Entre menos dinero ofrecido, más alta la probabilidad de aceptar).
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

    public boolean setEquipo(Equipo equipo) {
        if (this.patrocinando) { //Si esta patrocinando a un equipo
            return false;
        } else { // Si no esta patrocinando a un equipo
            this.equipoPatrocinado = equipo;
            this.patrocinando = true;
            this.equipoPatrocinado.getPatrocinadoresEquipo().add(this);
            return true;
        }
    }

    public boolean isPatrocinando() {
        return this.patrocinando;
    }

    public void setPatrocinando(boolean patrocinando) {
        this.patrocinando = patrocinando;
    }

}
