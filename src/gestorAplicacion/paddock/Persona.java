package gestorAplicacion.paddock;

import java.io.Serializable;

public abstract class Persona implements Serializable{
    // Atributos
    static int idActual = 1;
    protected int id;
    protected String nombre;
    protected String pais;
    protected double plata;

    // Constructores
    public Persona(String nombre, String pais) {
        this.id = Persona.getIdActual();
        this.nombre = nombre;
        this.pais = pais;
        Persona.idActual++;
        this.plata = 0;
    }
    public Persona(String nombre, String pais, double plata) {
        this.id = Persona.getIdActual();
        this.nombre = nombre;
        this.pais = pais;
        Persona.idActual++;
        this.plata = plata;
    }
    
    public Persona(String nombre) {
    	this.id = Persona.getIdActual();
    	this.nombre = nombre;
        Persona.idActual++;
        this.plata = 0;
    }

    public Persona(String nombre, double plata) {
        this.id = Persona.getIdActual();
        this.nombre = nombre;
        Persona.idActual++;
        this.plata = plata;
    }
    
    public Persona() {
        this.id = Persona.getIdActual();
        Persona.idActual++;
        this.plata = 0;
    }

    //Metodos abstractos
    public abstract void recibirPlata(double plata);
    public abstract void sinPlata();

    //Metodos de clase
    public static int getIdActual() {
        return idActual;
    }
    
    // Lista de m�todos set y get
    public int getId() {return this.id;}
    public void setId(int id) {this.id = id;}

    public String getNombre() {return this.nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getPais() {return this.pais;}

    public void setPais(String pais) {this.pais = pais;}

    public static void setIdActual(int idActual) {
        Persona.idActual = idActual;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }
}
