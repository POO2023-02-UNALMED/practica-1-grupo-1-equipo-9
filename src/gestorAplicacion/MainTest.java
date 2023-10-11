package gestorAplicacion;

import java.io.IOException;
//Para hacer tests
import java.sql.SQLOutput;
import java.util.*;
import gestorAplicacion.campeonato.*;
import gestorAplicacion.campeonato.Ciudad.Continente;
import gestorAplicacion.paddock.*;
import baseDatos.*;


public class MainTest {

    public static void main(String[] args) throws IOException {
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
        Campeonato.campeonatoElegido = new Campeonato("Campeonato 1", 2020, Continente.Europa, 3);
        // Equipo
        Equipo.equipoElegido = new Equipo("AMG", "Alemania", 0, 0, null, null);
        // Pilotos
        Piloto piloto1 = new Piloto("Lewis Hamilton", "Reino Unido", Equipo.equipoElegido, 0.2);
        Piloto piloto2 = new Piloto("Valtteri Bottas", "Finlandia", Equipo.equipoElegido, 0.09);
        Equipo.equipoElegido.setPiloto1(piloto1);
        Equipo.equipoElegido.setPiloto2(piloto2);
        System.out.println("\n");
        System.out.println("Piloto: " + piloto1.getNombre() + "\nPais: " + piloto1.getPais() + "\nEquipo: " + piloto1.getEquipo().getNombre() + "\nHabilidad: " + piloto1.getHabilidad());
        System.out.println("\n");
        System.out.println("Piloto: " + piloto2.getNombre() + "\nPais: " + piloto2.getPais() + "\nEquipo: " + piloto2.getEquipo().getNombre() + "\nHabilidad: " + piloto2.getHabilidad());
        System.out.println("\n");

        // Vehiculos
        Pieza aleronMercedes = new Pieza(false, 25.0, 0.20, "Aler�n Mercedes", 500.0, null);
        Pieza neumaticosMercedes = new Pieza(false, 10.0, 0.30, "Neum�ticos Mercedes", 800.0, null);
        Pieza motorMercedes = new Pieza(false, 10.0, 0.10, "Motor Mercedes", 5000.0, null);
        Vehiculo vehiculo1 = new Vehiculo("Mercedes", "AMG W11", 2021, aleronMercedes, neumaticosMercedes, motorMercedes, 350.0, 9.5, 200.0);
        Vehiculo vehiculo2 = new Vehiculo("Mercedes", "AMG GT", 2022, aleronMercedes, neumaticosMercedes, motorMercedes, 330.0, 9.0, 180.0);

        System.out.println("Vehiculo: " + vehiculo1.getMarca() + " " + vehiculo1.getModelo() + "\nA�o: " + vehiculo1.getAno() + "\nAler�n: " + vehiculo1.getAleron().getNombre() + "\nNeum�ticos: " + vehiculo1.getNeumaticos().getNombre() + "\nMotor: " + vehiculo1.getMotor().getNombre() + "\nVelocidad: " + vehiculo1.getVelocidad() + "\nManiobrabilidad: " + vehiculo1.getManiobrabilidad() + "\nPrecio de utilizaci�n: " + vehiculo1.getPrecioUtilizar());
        System.out.println("\n");
        System.out.println("Vehiculo: " + vehiculo2.getMarca() + " " + vehiculo2.getModelo() + "\nA�o: " + vehiculo2.getAno() + "\nAler�n: " + vehiculo2.getAleron().getNombre() + "\nNeum�ticos: " + vehiculo2.getNeumaticos().getNombre() + "\nMotor: " + vehiculo2.getMotor().getNombre() + "\nVelocidad: " + vehiculo2.getVelocidad() + "\nManiobrabilidad: " + vehiculo2.getManiobrabilidad() + "\nPrecio de utilizaci�n: " + vehiculo2.getPrecioUtilizar());
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
                System.out.println("Se intent� negociar con " + patrocinador.getNombre() + " por " + val + " d�lares.");
                System.out.println("El equipo " + Equipo.equipoElegido.getNombre() + " tiene " + Equipo.equipoElegido.getPlata() + " d�lares.");
                System.out.println("\n");
            }
        }

        vehiculo1.comprar(piloto1);
        vehiculo2.comprar(piloto2);
        VehiculoCarrera v1 = VehiculoCarrera.vehiculoElegido;
        Equipo e1 = Equipo.equipoElegido;

        System.out.println("Vehiculo" + v1.getMarca() + " " + v1.getModelo() + "\nA�o: " + v1.getAno() + "\nAler�n: " + v1.getAleron().getNombre() + "\nNeum�ticos: " + v1.getNeumaticos().getNombre() + "\nMotor: " + v1.getMotor().getNombre() + "\nVelocidad: " + v1.getVelocidad() + "\nManiobrabilidad: " + v1.getManiobrabilidad() + "\nPrecio de utilizaci�n: " + v1.getPrecioUtilizar() + "\nPiloto:" + v1.getPiloto().getNombre() + "\nVelocidad T: " + v1.getVelocidadTuneao());
        System.out.println("\n");

        System.out.println("Equipo: " + e1.getNombre() + "\nPa�s: " + e1.getPais() + "\nPlata: " + e1.getPlata() + "\nPiloto 1: " + e1.getPiloto1().getNombre() + "\nPiloto 2: " + e1.getPiloto2().getNombre());
        System.out.println("\n");

        // Preparar Carrera test

        Continente europa = Continente.Europa;

        Ciudad ciudad1 = new Ciudad("Montecarlo", europa);
        DirectorCarrera director1 = new DirectorCarrera("Michael Schmidt", "M�naco", 500000.0, true);

        Carrera carrera1 = new Carrera("Gran Premio de M�naco", 260.0, 1000000.0, ciudad1, director1, 4.2);

        Ciudad ciudad2 = new Ciudad("Monza", europa);
        DirectorCarrera director2 = new DirectorCarrera("Luigi Rossi", "Italia", 450000.0, true);

        Carrera carrera2 = new Carrera("Gran Premio de Italia", 306.0, 900000.0, ciudad2, director2, 3.8);

        Ciudad ciudad3 = new Ciudad("Silverstone", europa);
        DirectorCarrera director3 = new DirectorCarrera("James Smith", "Reino Unido", 520000.0, true);

        Carrera carrera3 = new Carrera("Gran Premio de Gran Breta�a", 308.0, 950000.0, ciudad3, director3, 4.0);

        System.out.println("Carrera: " + carrera1.getNombreCircuito() + "\nDistancia: " + carrera1.getDistancia() + "\nPremio: " + carrera1.getPremioEfectivo() + "\nCiudad: " + carrera1.getCiudad().getNombre() + "\nDirector: " + carrera1.getDirectorCarrera().getNombre());
        System.out.println("\n");
        System.out.println("Carrera: " + carrera2.getNombreCircuito() + "\nDistancia: " + carrera2.getDistancia() + "\nPremio: " + carrera2.getPremioEfectivo() + "\nCiudad: " + carrera2.getCiudad().getNombre() + "\nDirector: " + carrera2.getDirectorCarrera().getNombre());
        System.out.println("\n");
        System.out.println("Carrera: " + carrera3.getNombreCircuito() + "\nDistancia: " + carrera3.getDistancia() + "\nPremio: " + carrera3.getPremioEfectivo() + "\nCiudad: " + carrera3.getCiudad().getNombre() + "\nDirector: " + carrera3.getDirectorCarrera().getNombre());
        System.out.println("\n");

        // Setear meses
        carrera1.setMes(1);
        carrera2.setMes(2);
        carrera3.setMes(3);

        // Dificultad
        carrera1.setDificultad(2);
        carrera2.setDificultad(1.8);
        carrera3.setDificultad(3.0);

        Pieza aleron = new Pieza(false, 10.0, 0.8, "Aler�n Est�ndar", 500.0, null);
        Pieza motor = new Pieza(false, 11.0, 0.5, "Motor Potente", 200.0, null);
        Pieza neumaticos = new Pieza(false, 20.0, 0.7, "Neum�ticos Deportivos", 800.0, null);
        Pieza frenos = new Pieza(false, 5.0, 0.9, "Frenos de Alto Rendimiento", 350.0, null);
        Pieza aleronContrabando = new Pieza(false, 15.0, 0.6, "Aler�n de Contrabando", 800.0, null);
        Pieza turbo = new Pieza(false, 30.0, 0.4, "Turbo Clandestino", 1200.0, null);

        // Tunear el carro
        v1.setNeumaticos(neumaticos);
        v1.setAleron(aleron);
        System.out.println("Vehiculo" + v1.getMarca() + " " + v1.getModelo() + "\nA�o: " + v1.getAno() + "\nAler�n: " + v1.getAleron().getNombre() + "\nNeum�ticos: " + v1.getNeumaticos().getNombre() + "\nMotor: " + v1.getMotor().getNombre() + "\nVelocidad: " + v1.getVelocidad() + "\nManiobrabilidad: " + v1.getManiobrabilidad() + "\nPrecio de utilizaci�n: " + v1.getPrecioUtilizar() + "\nPiloto:" + v1.getPiloto().getNombre() + "\nVelocidad T: " + v1.getVelocidadTuneao());
        System.out.println("\n");

        // Corrupcion
        v1.setMotor(turbo);
        

        // Test serializado
        
        Serializado.serializarCampeonatos(Campeonato.getCampeonatos());
        Serializado.serializarCiudades(Ciudad.getListaCiudades());
        //Serializado.serializarDirectores(DirectorCarrera.getListaDirectores());
        Serializado.serializarEquipos(Equipo.getEquipos());
        Serializado.serializarPatrocinadores(Patrocinador.getListaPatrocinadores()); 
        Serializado.serializarPiezas(Pieza.getPiezas());
        Serializado.serializarPiezasContrabando(Pieza.getPiezasContrabando());
        Serializado.serializarPilotos(Piloto.getListaPilotos());
        Serializado.serializarVehiculos(Vehiculo.getListaVehiculos());
        
    }
}
