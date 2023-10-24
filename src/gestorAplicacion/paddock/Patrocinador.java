package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.Ciudad;
import gestorAplicacion.campeonato.Equipo;
import gestorAplicacion.campeonato.Decimales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class Patrocinador extends Persona implements Serializable, Decimales{

    /***
     * Autores: David Toro Arboleda, Santiago Lopez Ayala, Juan Andres Jimenez Velez, Mariana Valencia Cubillos, Samuel Mira Alvarez
     * Descripcion de la clase: La clase "Patrocinador" desempeña un papel fundamental al crear y asignar los atributos asociados. Su importancia radica en su rol de proveer a los equipos con los recursos financieros necesarios para participar en el campeonato. El flujo de dinero es esencial para el funcionamiento fluido de las interacciones dentro del campeonato.
     */

	private static final long serialVersionUID = -3407371441746326606L;
	
	//Lista de patrocinadores
    public static ArrayList<Patrocinador> listaPatrocinadores = new ArrayList<Patrocinador>();
    //Atributos
    private double dineroOfrecer;
    private double probAceptar;
    private boolean patrocinando;
    private boolean rosca = true;

    private ArrayList<Ciudad> ciudadesPreferidas = new ArrayList<Ciudad>();

    //Constructores


    public Patrocinador(String nombre, double plata, double dineroOfrecer, double probAceptar, boolean patrocinando, boolean rosca, ArrayList<Ciudad> ciudadesPreferidas) {
        super(nombre, plata);
        this.dineroOfrecer = dineroOfrecer;
        this.probAceptar = probAceptar;
        this.patrocinando = patrocinando;
        this.rosca = rosca;
        this.ciudadesPreferidas = ciudadesPreferidas;
        Patrocinador.listaPatrocinadores.add(this);
    }


    public Patrocinador(String nombre, double dineroDisponible) {
        super(nombre, dineroDisponible);
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
        this.probAceptar = numRandom; //Se le asigna una probabilidad entre 100% menos la proporci�n del dinero ofrecido/disponible y 100% (Entre menos dinero ofrecido, m�s alta la probabilidad de aceptar).
        Patrocinador.listaPatrocinadores.add(this);
    }

    public Patrocinador(String nombre) {
        super(nombre, ((random.nextDouble() * 9000.0) + 20000.0));
        Random rand = new Random();
        double lowerBound = 0.2;
        double upperBound = 0.8;
        double numRandom = lowerBound + (upperBound - lowerBound) * rand.nextDouble();
		/*DecimalFormat formato = new DecimalFormat("#.##");
        //this.dineroOfrecer = dineroDisponible*numRandom; //Se le asigna una cantidad del 20% al 80% del dinero que tiene el patrocinador para que lo ofrezca.
		this.dineroOfrecer = Double.parseDouble(formato.format(dineroDisponible*numRandom));*/
        this.dineroOfrecer = this.getPlata() * numRandom; // A ver si asi te corre
        this.probAceptar = 0.2 + (0.9 - 0.2) * new java.util.Random().nextDouble();;
        //Se le asigna una probabilidad entre 100% menos la proporci�n del dinero ofrecido/disponible y 100% (Entre menos dinero ofrecido, m�s alta la probabilidad de aceptar).
        Patrocinador.listaPatrocinadores.add(this);
    }

    public Patrocinador(String nombre, double dineroDisponible, double dineroOfrecer, double probAceptar, boolean patrocinando, boolean rosca) {
        super(nombre, dineroDisponible);
        Random rand = new Random();
        this.dineroOfrecer = dineroOfrecer;
        this.probAceptar = probAceptar;
        this.patrocinando = patrocinando;
        this.rosca = rosca;
        Patrocinador.listaPatrocinadores.add(this);
    }

    //Metodos de clase
    public static ArrayList<Patrocinador> getListaPatrocinadores() {
        return listaPatrocinadores;
    }

    public static ArrayList<Patrocinador> patrocinadoresDisponibles() {
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de patrocinadores dependiendo si estan o no patrocinando a un piloto, tambien se encarga de poner un patrocinador por defecto parar asegurar que la lista no este vacia
         * Parametros de entrada:  sin argumentos
         * Parametros de salida: ArrayList<Patrocinador>
         */
    	ArrayList<Patrocinador> patrocinadoresDisponibles = new ArrayList<Patrocinador>();
    	for (Patrocinador patrocinador : Patrocinador.listaPatrocinadores) {
    		if (!patrocinador.isPatrocinando()) {
    			patrocinadoresDisponibles.add(patrocinador);
    		}
    	}
        if (patrocinadoresDisponibles.isEmpty()) { // para siempre hay al menos un patrocinador
            listaPatrocinadores.get(0).setDinero(100000);
            listaPatrocinadores.get(0).setDineroOfrecido(90000);
            patrocinadoresDisponibles.add(listaPatrocinadores.get(0));
        }
    	return patrocinadoresDisponibles;
    }

    public static ArrayList<Patrocinador> patrocinadorPiloto(Piloto piloto, ArrayList<Patrocinador> patrocinadores) {
        /***
         * Descripcion del metodo: este metodo se encarga de filtrar una lista de patrocinadores de acuerdo al precio de contrato mas el precio del vehiculo de un piloto, teniendo en cuenta el atributo dineroOfrecer
         * Parametros de entrada:  piloto de tipo Piloto y patrocinadores de tipo ArrayList<Patrocinador>
         * Parametros de salida: ArrayList<Patrocinador>
         */
    	ArrayList<Patrocinador> patrocinadoresPiloto = new ArrayList<Patrocinador>();
        double valor = piloto.getValorContrato() + piloto.getPresupuestoVehiculo();
    	for (Patrocinador patrocinador : patrocinadores) {
    		if (patrocinador.dineroOfrecer >= valor) {
    			patrocinadoresPiloto.add(patrocinador);
    		}
    	}
        if (patrocinadoresPiloto.isEmpty()) { // para siempre hay al menos un patrocinador
            patrocinadores.get(0).setDinero(valor*2);
            patrocinadores.get(0).setDineroOfrecido(valor);
            patrocinadoresPiloto.add(patrocinadores.get(0));
        }
    	return patrocinadoresPiloto;
    }

    public static Patrocinador patrocinadorPiloto(Piloto piloto, ArrayList<Patrocinador> patrocinadores, boolean x) {
        /***
         * Descripcion del metodo: este metodo elige un patrocinador de la lista y se lo asigna a un piloto de un equipo contrincante
         * Parametros de entrada:  piloto de tipo Piloto , patrocinadores de tipo ArrayList<Patrocinador> y x de tipo boolean
         * Parametros de salida: Patrocinador
         */

        double valor = piloto.getValorContrato() + piloto.getPresupuestoVehiculo();
        Random rand = new Random();

        ArrayList<Patrocinador> patrocinadoresPiloto = new ArrayList<Patrocinador>();
        for (Patrocinador patrocinador : patrocinadores) {
            if (patrocinador.dineroOfrecer >= valor) {
                patrocinadoresPiloto.add(patrocinador);
            }
        }
        if (patrocinadoresPiloto.isEmpty()) { // para siempre hay al menos un patrocinador
            patrocinadores.get(0).setDinero(valor*2);
            patrocinadores.get(0).setDineroOfrecido(valor);
            patrocinadoresPiloto.add(patrocinadores.get(0));
        }

        int n = rand.nextInt(patrocinadoresPiloto.size());
        Patrocinador patrocinador = patrocinadoresPiloto.get(n);

        return patrocinador;
    }

    //Metodos de instancia
    public String toString() {
        return "Nombre: " + this.getNombre() + "\nCantidad que patrocina:" + this.dineroOfrecer + "\nProbabilidad de aceptar: " + this.probAceptar;
    }


    //Metodo abstracto heredado
    public void recibirPlata(double plata) {
        this.setDinero(this.getPlata() + plata);
    }

    public boolean pensarNegocio(Piloto piloto) {
        /***
         * Descripcion del metodo: calcula si acepta o no un trato con el piloto dependiendo las probabilidades de aceptar que tenga el patrocinador
         * Parametros de entrada:  piloto de tipo Piloto
         * Parametros de salida: boolean
         */
        Random rand = new Random();
        double lowerBound = 0.0;
        double upperBound = this.probAceptar;
        double numRandom = lowerBound + (upperBound - lowerBound) * rand.nextDouble();
        if (numRandom < this.probAceptar) {
            piloto.getEquipo().agregarPatrocinador(this);
            this.setPatrocinando(true);
            // Dar plata
            piloto.recibirPlata(this.dineroOfrecer);
            this.setDinero(this.getPlata() - this.dineroOfrecer);
            piloto.setPatrocinador(this);
            return true;
        } else {
            return false;
        }
    }

    public void beneficiarPiloto(Piloto piloto) {
    	piloto.setHabilidad(piloto.getHabilidad() + 0.1);
    }

    public void sinPlata() {
        this.setDinero((Math.random() * 90001) + 1000);
    }

    //Lista de metodos set y get

    public void setDinero(double dinero) {

        this.setPlata(dinero);
        this.setDineroOfrecido(dinero);
        if (this.getPlata() <= 0) {
            sinPlata();
            this.setDineroOfrecido(this.getPlata());
        }
    }

    public double getDineroOfrecido() {
        return this.dineroOfrecer;
    }

    public void setPatrocinadorCampeonato() {
        /***
         * Descripcion del metodo: este metodo se encarga de asignar 5 ciudades aleaotrias a una lista de ciudadesPreferidas en las cuales si se llega a ganar una carrera el premio se multiplica
         * Parametros de entrada:  sin argumentos
         * Parametros de salida: void
         */
        Random rand = new Random();
        // 5 ciudades random
        ArrayList<Ciudad> ciudades = Ciudad.getListaCiudades();
        Collections.shuffle(ciudades);
        this.ciudadesPreferidas.add(ciudades.get(0));
        this.ciudadesPreferidas.add(ciudades.get(1));
        this.ciudadesPreferidas.add(ciudades.get(2));
        this.ciudadesPreferidas.add(ciudades.get(3));
        this.ciudadesPreferidas.add(ciudades.get(4));
        this.setPlata(this.getPlata() * 5000);
    }

    public void redondear() {
        this.dineroOfrecer = dosDecimales(this.dineroOfrecer);
        this.probAceptar = dosDecimales(this.probAceptar);
        this.dineroOfrecer = dosDecimales(this.dineroOfrecer);
        super.redondear();
    }

    {
        this.redondear();
    }

    public void setDineroOfrecido(double dinero) {
        this.dineroOfrecer = dinero;
//        Random rand = new Random();
//        double lowerBound = 1.0 - this.dineroOfrecer / dineroDisponible;
//        double upperBound = 1.0;
//        this.probAceptar = lowerBound + (upperBound - lowerBound) * rand.nextDouble(); //Se le asigna una probabilidad entre 100% menos la proporci�n del dinero ofrecido/disponible y 100% (Entre menos dinero ofrecido, m�s alta la probabilidad de aceptar).
    }


    public double getProbAceptar() {
        return this.probAceptar;
    }

    public void setProbAceptar(double prob) {
        this.probAceptar = prob;
    }

/*    public Equipo getEquipo() {
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
    }*/

    public boolean isPatrocinando() {
        return this.patrocinando;
    }

    public void setPatrocinando(boolean patrocinando) {
        this.patrocinando = patrocinando;
    }

    public boolean isRosca() {
    	return this.rosca;
    }

    public void setRosca(boolean rosca) {
    	this.rosca = rosca;
    }

    public static void setListaPatrocinadores(ArrayList<Patrocinador> listaPatrocinadores) {
        Patrocinador.listaPatrocinadores = listaPatrocinadores;
    }

    public double getDineroOfrecer() {
        return dineroOfrecer;
    }

    public void setDineroOfrecer(double dineroOfrecer) {
        this.dineroOfrecer = dineroOfrecer;
    }

    public ArrayList<Ciudad> getCiudadesPreferidas() {
        return ciudadesPreferidas;
    }

    public void setCiudadesPreferidas(ArrayList<Ciudad> ciudadesPreferidas) {
        this.ciudadesPreferidas = ciudadesPreferidas;
    }
    public static Random random = new Random();

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patrocinador miClase = (Patrocinador) o;
        return id == miClase.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
