package gestorAplicacion.paddock;

import gestorAplicacion.campeonato.*;
import java.util.*;

public class Patrocinador extends Persona{
	// Atributos
	private double dinero;
	private double dineroOfrecer;
	private double probAceptar;
	private Equipo equipoPatrocinado;

	// Lista de métodos set y get
	public void setDinero(double dinero) {this.dinero = dinero;}
	public double getDinero() {return this.dinero;}
	
	public void setProbAceptar(double prob) {this.probAceptar = prob;}
	public double getProbAceptar() {return this.probAceptar;}
	
	public void setEquipo(Equipo equipo) {this.equipoPatrocinado = equipo;}
	public Equipo getEquipo() {return this.equipoPatrocinado;}
	
}
