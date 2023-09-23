package gestorAplicacion.paddock;

public class Persona {
	// Atributos
	static int idActual = 1;
	private int id;
	private String nombre;
	private String pais;
	
	// Lista de métodos set y get
	public void setId(int id) {this.id = id;}
	public int getId() {return this.id;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getNombre() {return this.nombre;}
	
	public void setPais(String pais) {this.pais = pais;}
	public String getPais() {return this.pais;}

	public static int getIdActual() {return idActual;}
	
	// Constructor
	public Persona(String nombre, String pais) {
		this.id = Persona.getIdActual();
		this.nombre = nombre;
		this.pais = pais;
		Persona.idActual++;
	}

	public Persona() {
		this.id = Persona.getIdActual();
		Persona.idActual++;
	}
}
