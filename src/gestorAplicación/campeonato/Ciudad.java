package gestorAplicación.campeonato;

public class Ciudad {
	//Atributos
	private String nombre;
	private Continente continente;
	
	// Lista de continentes
	enum Continente {
		África,
		América,
		Asia,
		Europa,
		Oceanía}
	
	// Lista de métodos set y get		
		public void setNombre(String nombre) {this.nombre = nombre;}
		public String getNombre() {return this.nombre;}
		
		public void setContinente(Continente continente) {this.continente = continente;}
		public Continente getContinente() {return this.continente;}
}
