package gestorAplicacion.paddock;

import java.util.ArrayList;
import java.util.Random;
import gestorAplicacion.campeonato.Equipo;

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
    	double lowerBound=0.2;
    	double upperBound=0.8;
    	double numRandom=lowerBound+(upperBound-lowerBound)*rand.nextDouble();
    	this.dineroOfrecer = dineroDisponible*numRandom; //Se le asigna una cantidad del 20% al 80% del dinero que tiene el patrocinador para que lo ofrezca.
    	lowerBound=1.0-this.dineroOfrecer/dineroDisponible;
    	upperBound=1.0;
    	numRandom=lowerBound+(upperBound-lowerBound)*rand.nextDouble();
    	this.probAceptar = numRandom; //Se le asigna una probabilidad entre 100% menos la proporción del dinero ofrecido/disponible y 100% (Entre menos dinero ofrecido, más alta la probabilidad de aceptar).
    }
    
    //Metodos de instancia
   public String toString() {
	   return "Nombre: " + this.getNombre() + "\nCantidad que patrocina:" + this.dineroOfrecer + "\nProbabilidad de aceptar: " + this.probAceptar; 
   }
   
   public boolean pensarNegocio(Equipo equipo) {
	Random rand = new Random();
   	double lowerBound=0.0;
   	double upperBound=this.probAceptar;
   	double numRandom=lowerBound+(upperBound-lowerBound)*rand.nextDouble();
   	if (numRandom<this.probAceptar) {
   		this.setEquipo(equipo);
   		this.equipoPatrocinado.setPlata(this.equipoPatrocinado.getPlata()+this.dineroOfrecer);
   		return true;
   	} else {
   		return false;
   	}
   }
   
   public boolean pensarNegocio(Equipo equipo, boolean equipoNoElegido) { //Sobrecargar para que algunos equipos no elegidos por el usuario puedan ser patrocinados
	Random rand = new Random();
   	double lowerBound=0.0;
   	double upperBound=this.probAceptar;
   	double numRandom=lowerBound+(upperBound-lowerBound)*rand.nextDouble();
   	if (numRandom<this.probAceptar) {
   		this.equipoPatrocinado = equipo;
   		this.equipoPatrocinado.setPlata(this.equipoPatrocinado.getPlata()+this.dineroOfrecer);
   		return true;
   	} else {
   		return false;
   	}
   }
    
    //Metodos de clase
    public static String mostrarPatrocinadores() {
    	String tabla = null;
    	for (Patrocinador patrocinador : Patrocinador.listaPatrocinadores) {
    		if (patrocinador.isPatrocinando()) {
    			if (patrocinador.getEquipo()==null) {
    				tabla += patrocinador.toString() + "(\n¡No está dispuesto a patrocinar!";
    			} else {
    				tabla += patrocinador.toString() + "(\n¡Sin equipo patrocinado!";
    				}
    		} else {
    			tabla += patrocinador.toString() + "(\nPatrocinando a:" + patrocinador.getEquipo() + ")";
    		}
    	}
    	return tabla;
    }
    
    public static ArrayList<Patrocinador> getListaPatrocinadores(){return listaPatrocinadores;}

    //Lista de metodos set y get
    public double getDinero() {return this.dineroDisponible;}
    public void setDinero(double dinero) {this.dineroDisponible = dinero;}
    
    public double getDineroOfrecido() {return this.dineroOfrecer;}
    public void setDineroOfrecido(double dinero) {
    	this.dineroOfrecer=dinero;
    	Random rand = new Random();
    	double lowerBound=1.0-this.dineroOfrecer/dineroDisponible;
    	double upperBound=1.0;
    	double numRandom=lowerBound+(upperBound-lowerBound)*rand.nextDouble();
    	this.probAceptar = numRandom; //Se le asigna una probabilidad entre 100% menos la proporción del dinero ofrecido/disponible y 100% (Entre menos dinero ofrecido, más alta la probabilidad de aceptar).
    }
    

    public double getProbAceptar() {return this.probAceptar;}
    public void setProbAceptar(double prob) {this.probAceptar = prob;}

    public Equipo getEquipo() {return this.equipoPatrocinado;}
    public void setEquipo(Equipo equipo) {
    	if (this.patrocinando==true && this.equipoPatrocinado==null) { //Si falló el intento de patrocinio
    		System.out.println("¡El patrocinador " + this.getNombre() + " no está dispuesto a patrocinar!");
    	} else if (this.patrocinando==true) { //Si ya está patrocinando a un equipo
    		System.out.println("El patrocinador " + this.getNombre() + " ya está patrocinando a " + this.equipoPatrocinado.getNombre());
    	} else { // Si no está patrocinando a un equipo
    		this.equipoPatrocinado = equipo;
    		this.patrocinando=true;
    	}
    	}
    
    public boolean isPatrocinando() {return this.patrocinando;}
    public void setPatrocinando(boolean patrocinando) {this.patrocinando = patrocinando;}

}
