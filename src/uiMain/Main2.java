package uiMain;
import gestorAplicacion.*;
import gestorAplicacion.campeonato.Campeonato;
import gestorAplicacion.campeonato.Ciudad.Continente;

import java.util.*;



public class Main2 {
 
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner (System.in);
		
		Campeonato c1 = new Campeonato("CampeonatoAf", Continente.Africa, 1);
		Campeonato.campeonatos.add(c1);
		
		Campeonato c2 = new Campeonato("CampeonatoAm", Continente.America, 1);
		Campeonato.campeonatos.add(c2);

		Campeonato c3 = new Campeonato("CampeonatoAs", Continente.Asia, 1);
		Campeonato.campeonatos.add(c3);

		Campeonato c4 = new Campeonato("CampeonatoEu", Continente.Europa, 1);
		Campeonato.campeonatos.add(c4);
		
		Campeonato c5 = new Campeonato("CampeonatoOc", Continente.Oceania, 1);
		Campeonato.campeonatos.add(c5);
		
		
		
		System.out.println("---Bienvenido a la Federation Internationale de l'Automobile!---\n");
		
		System.out.println("Primero selecciona tu campeonato:\n");
		
		System.out.printf ("---------------------------------%n");
		System.out.printf ("           CAMPEONATOS           %n");
		System.out.printf ("---------------------------------%n");
		System.out.printf ("| %-13s | %-13s |%n", "NOMBRE", "OPCION");
		System.out.printf ("---------------------------------%n");
		System.out.printf ("| %-13s | %-13s |%n", Campeonato.campeonatos.get(0).getNombre(), "1");
		System.out.printf ("| %-13s | %-13s |%n", Campeonato.campeonatos.get(1).getNombre(), "2");
		System.out.printf ("| %-13s | %-13s |%n", Campeonato.campeonatos.get(2).getNombre(), "3");
		System.out.printf ("| %-13s | %-13s |%n", Campeonato.campeonatos.get(3).getNombre(), "4");
		System.out.printf ("| %-13s | %-13s |%n", Campeonato.campeonatos.get(4).getNombre(), "5");
		System.out.printf ("---------------------------------%n");
		
		System.out.println("Primero selecciona tu campeonato:");
		
		int seguir = 1;
		
		do {
			
			int opcion = scanner.nextInt();
			
			
		switch (opcion) {
			case 1:
				System.out.println("ha seleccionado " + Campeonato.campeonatos.get(0).getNombre() + " en el continente " + Campeonato.campeonatos.get(0).getContinente());
				seguir ++;
				break;
				
			case 2:
				System.out.println("ha seleccionado " + Campeonato.campeonatos.get(1).getNombre()+ " en el continente " + Campeonato.campeonatos.get(1).getContinente());
				seguir ++;
				break;
				
			case 3:
				System.out.println("ha seleccionado " + Campeonato.campeonatos.get(2).getNombre()+ " en el continente " + Campeonato.campeonatos.get(2).getContinente());
				seguir ++;
				break;
				
			case 4:
				System.out.println("ha seleccionado " + Campeonato.campeonatos.get(3).getNombre()+ " en el continente " + Campeonato.campeonatos.get(3).getContinente());
				seguir ++;
				break;
				
			case 5:
				System.out.println("ha seleccionado " + Campeonato.campeonatos.get(4).getNombre()+ " en el continente " + Campeonato.campeonatos.get(4).getContinente());
				seguir ++;
				break;
				
			default:
				System.out.println("Opcion incorrecta, selecciona una de las opciones de la tabla");
				break;
		
		} 
		
		} while ( seguir == 1 );
		
		
	}
}
