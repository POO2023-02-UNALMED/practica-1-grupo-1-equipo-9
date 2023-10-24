package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.Decimales;
import java.io.Serializable;

public abstract class Persona implements Serializable, Decimales {
    /***
     * Autores: David Toro Arboleda, Santiago Lopez Ayala, Juan Andres Jimenez Velez, Mariana Valencia Cubillos, Samuel Mira Alvarez
     * Descripcion de la clase: Esta clase ha sido diseñada con la finalidad de ser heredada por diferentes entidades utilizadas en el programa, como son los patrocinadores, pilotos y directores de carrera.
     */
    private static final long serialVersionUID = 9152973937117015465L;
    // Atributos
    static int idActual = 1;
    protected int id;
    protected String nombre;
    protected String pais;
    protected double plata;

    // Constructores
    public Persona(String nombre, String pais, double plata) {
        this.id = Persona.getIdActual();
        this.nombre = nombre;
        this.pais = pais;
        Persona.idActual++;
        this.plata = plata;
    }

    public Persona(String nombre, String pais) {
        this(nombre, pais, 0);
    }


    public Persona(String nombre) {
        this(nombre, "Alemania", 0);
    }

    public Persona(String nombre, double plata) {
        this(nombre, "Alemania", plata);
    }

    public Persona() {
        this("NPC");
    }

    public void redondear() {
        this.plata = dosDecimales(this.plata);
    }

    {
        this.redondear();
    }

    //Metodos abstractos
    public abstract void recibirPlata(double plata);
    public abstract void sinPlata();

    //Metodos de clase
    public static int getIdActual() {
        return idActual;
    }

    // Lista de m todos set y get
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
