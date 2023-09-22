package gestorAplicaci�n.campeonato;

public class Ciudad {
	//Atributos
	private String nombre;
	private Continente continente;
	
	// Lista de continentes
	enum Continente {
		�frica,
		Am�rica,
		Asia,
		Europa,
		Ocean�a}
	
	// Lista de m�todos set y get		
		public void setNombre(String nombre) {this.nombre = nombre;}
		public String getNombre() {return this.nombre;}
		
		public void setContinente(Continente continente) {this.continente = continente;}
		public Continente getContinente() {return this.continente;}
}
