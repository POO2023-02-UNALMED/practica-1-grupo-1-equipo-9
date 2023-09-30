package gestorAplicacion.campeonato;

public class Ciudad {
    //Atributos
    private String nombre;
    private Continente continente;

    public String getNombre() {
        return this.nombre;
    }

    // Lista de métodos set y get
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Continente getContinente() {
        return this.continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    // Lista de continentes
    enum Continente {
        Africa, America, Asia, Europa, Oceania
    }
}
