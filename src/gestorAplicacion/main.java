package gestorAplicacion;

//Para hacer tests
import java.util.*;
import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;
import gestorAplicacion.campeonato.Ciudad.Continente;


public class main {

    public static void main(String[] args) {
    	//Para hacer pruebas
    	Random rand = new Random();
    	double lowerBound=0.2;
    	double upperBound=0.8;
    	double numRandom=lowerBound+(upperBound-lowerBound)*rand.nextDouble(); //Generating a number within certain bouns
    	//System.out.println(numRandom);

		Scanner sc = new Scanner(System.in);

		//Para hacer pruebas

		//Preparar Campeonato test

		// Campeonato
        Campeonato.campeonatoElegido = new Campeonato("Campeonato 1", 2020, Continente.America, 3);
		// Equipo
		Equipo.equipoElegido = new Equipo("AMG", "Alemania", 0, 0, null, null);
		// Pilotos
		Piloto piloto1 = new Piloto("Lewis Hamilton", "Reino Unido", Equipo.equipoElegido, 0.2);
		Piloto piloto2 = new Piloto("Valtteri Bottas", "Finlandia", Equipo.equipoElegido, 0.09);
		Equipo.equipoElegido.setPiloto1(piloto1);
		Equipo.equipoElegido.setPiloto2(piloto2);
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("Piloto: " + piloto1.getNombre() + "\nPais: " + piloto1.getPais() + "\nEquipo: " + piloto1.getEquipo().getNombre() + "\nHabilidad: " + piloto1.getHabilidad());
		System.out.println("\n");
		System.out.println("Piloto: " + piloto2.getNombre() + "\nPais: " + piloto2.getPais() + "\nEquipo: " + piloto2.getEquipo().getNombre() + "\nHabilidad: " + piloto2.getHabilidad());
		System.out.println("\n");
		System.out.println("\n");

		// Vehiculos
		Pieza aleronMercedes = new Pieza(false, 25.0, 0.20, "Alerón Mercedes", 500.0);
		Pieza neumaticosMercedes = new Pieza(false, 10.0, 0.30, "Neumáticos Mercedes", 800.0);
		Pieza motorMercedes = new Pieza(false, 10.0, 0.10, "Motor Mercedes", 5000.0);
		Vehiculo vehiculo1 = new Vehiculo("Mercedes", "AMG W11", 2021, aleronMercedes, neumaticosMercedes, motorMercedes, 350.0, 9.5, 200.0);
		Vehiculo vehiculo2 = new Vehiculo("Mercedes", "AMG GT", 2022, aleronMercedes, neumaticosMercedes, motorMercedes, 330.0, 9.0, 180.0);

		System.out.println("Vehiculo: " + vehiculo1.getMarca() + " " + vehiculo1.getModelo() + "\nAño: " + vehiculo1.getAno() + "\nAlerón: " + vehiculo1.getAleron().getNombre() + "\nNeumáticos: " + vehiculo1.getNeumaticos().getNombre() + "\nMotor: " + vehiculo1.getMotor().getNombre() + "\nVelocidad: " + vehiculo1.getVelocidad() + "\nManiobrabilidad: " + vehiculo1.getManiobrabilidad() + "\nPrecio de utilización: " + vehiculo1.getPrecioUtilizar());
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("Vehiculo: " + vehiculo2.getMarca() + " " + vehiculo2.getModelo() + "\nAño: " + vehiculo2.getAno() + "\nAlerón: " + vehiculo2.getAleron().getNombre() + "\nNeumáticos: " + vehiculo2.getNeumaticos().getNombre() + "\nMotor: " + vehiculo2.getMotor().getNombre() + "\nVelocidad: " + vehiculo2.getVelocidad() + "\nManiobrabilidad: " + vehiculo2.getManiobrabilidad() + "\nPrecio de utilización: " + vehiculo2.getPrecioUtilizar());
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");

		// Patrocinadores
		Patrocinador patrocinador1 = new Patrocinador("Acme Corporation", 5000.0);
		Patrocinador patrocinador2 = new Patrocinador("Tech Innovations Ltd.", 3000.0);
		Patrocinador patrocinador3 = new Patrocinador("Global Motorsport Group", 7500.0);
		Patrocinador patrocinador4 = new Patrocinador("MegaCorp", 10000.0);
		Patrocinador patrocinador5 = new Patrocinador("Stark Industries", 2000.0);
		Patrocinador patrocinador6 = new Patrocinador("Wayne Enterprises", 1000.0);

		// Negociar
		while (Equipo.equipoElegido.getPlata() < 5000) {
			for (Patrocinador patrocinador : Patrocinador.listaPatrocinadores) {
				int val = rand.nextInt(901) + 1000;
				Equipo.equipoElegido.negociar(val, patrocinador); //Se intenta
				System.out.println("Se intentó negociar con " + patrocinador.getNombre() + " por " + val + " dólares.");
				System.out.println("El equipo " + Equipo.equipoElegido.getNombre() + " tiene " + Equipo.equipoElegido.getPlata() + " dólares.");
				System.out.println("\n");

			}
		}

		vehiculo1.comprar(piloto1);
		vehiculo2.comprar(piloto2);
		VehiculoCarrera v1 = VehiculoCarrera.vehiculoElegido;
		Equipo e1 = Equipo.equipoElegido;

		System.out.println("Vehiculo" + v1.getMarca() + " " + v1.getModelo() + "\nAño: " + v1.getAno() + "\nAlerón: " + v1.getAleron().getNombre() + "\nNeumáticos: " + v1.getNeumaticos().getNombre() + "\nMotor: " + v1.getMotor().getNombre() + "\nVelocidad: " + v1.getVelocidad() + "\nManiobrabilidad: " + v1.getManiobrabilidad() + "\nPrecio de utilización: " + v1.getPrecioUtilizar() + "\nPiloto:" + v1.getPiloto().getNombre() + "\nVelocidad T: " + v1.getVelocidadTuneao());
		System.out.println("\n");
		System.out.println("\n");

		System.out.println("Equipo: " + e1.getNombre() + "\nPaís: " + e1.getPais() + "\nPlata: " + e1.getPlata() + "\nPiloto 1: " + e1.getPiloto1().getNombre() + "\nPiloto 2: " + e1.getPiloto2().getNombre());
		System.out.println("\n");

	}
}
