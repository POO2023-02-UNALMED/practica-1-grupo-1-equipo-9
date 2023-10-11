package uiMain;

import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;
import baseDatos.*;
import java.util.*;
import java.util.Random;

import static uiMain.Tablas.*;


public class Main2 {
 
	public static void main(String [] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
		
      //  tablaCampeonatos(Campeonato.campeonatos);
		tablaCampeonatos(Campeonato.campeonatos);
        tablaEquipos(Equipo.equipos);
        tablaDirectoresCarrera(DirectorCarrera.listaDirectores);
        tablaPatrocinadores(Patrocinador.listaPatrocinadores);
        tablaPiezas(Pieza.getPiezas());
        tablaPiezasContrabando(Pieza.getPiezasContrabando());
        Equipo.equipoElegido = Equipo.equipos.get(0);
        tablaVehiculos(Equipo.equipoElegido.getVehiculosDisponibles());
        ArrayList<VehiculoCarrera> veh = new ArrayList<VehiculoCarrera>();
        Equipo.equipoElegido.setPlata(100000000);
        for (Equipo equipo : Equipo.equipos) {
            equipo.setPlata(100000000);
            for (Vehiculo vehiculo : equipo.getVehiculosDisponibles()) {
                int n = rand.nextInt(5);
                vehiculo.comprar(Equipo.equipoElegido.getPilotosDisponibles().get(n));
                veh.add(VehiculoCarrera.vehiculoElegido);
            }
        }

        System.out.println("\n");
        boolean validaciones = false;

        while (!validaciones) {
            /*Descomentar
            int n = sc.nextInt();*/
            int n = rand.nextInt(5); //Test
            // Validar que el numero sea del 1 al 5
            if (n < 1 || n > 5) {
                // Si no es del 1 al 5, imprimir el mensaje de error
                System.out.println("Por favor, escribe un numero del 1 al 5.");
            } else {
                // Si es del 1 al 5, imprimir el mensaje de exito
                // Si es del 1 al 5, cambiar validaciones a true
                Campeonato.campeonatoElegido = Campeonato.campeonatos.get(n - 1);
                System.out.println("¡Campeonato elegido!");
                // Imprimir campeonato actual con tabla
                System.out.println("\n");
                validaciones = true;
            }
        }


        /*Descomentar
        int n = sc.nextInt();*/
        int n = 2023;
        validaciones = false;
        // Validar que el numero sea mayor que 1950 y menor que 9999

        while (!validaciones) {
            if (n < 1950 || n > 9999) {
                // Si no es mayor que 1950 y menor que 9999, imprimir el mensaje de error
                System.out.println("Por favor, escribe un numero mayor que 1950 y menor que 9999.");
                n = sc.nextInt(); // Para que no se quede en un loop infinito xd
            } else {
                // Si es mayor que 1950 y menor que 9999, imprimir el mensaje de exito

                validaciones = true;
            }
        }

        tablaPosiciones(veh);
        Collections.shuffle(veh);
        tablaPosicionesTiempos(veh);
        ArrayList<Carrera> carreras = new ArrayList<Carrera>();
        for (Ciudad ciudad : Ciudad.listaCiudades) {
            int mes = rand.nextInt(12) ;
            int dificultad = rand.nextInt(3) ;
            Carrera carrera = new Carrera(ciudad, mes, dificultad);
            DirectorCarrera directorCarrera = DirectorCarrera.listaDirectores.get(rand.nextInt(2));
            carrera.setDirectorCarrera(directorCarrera);
            Circuito circuito = Circuito.PATTERN_1;
            carrera.setCircuito(circuito);
            carreras.add(carrera);
        }
        Campeonato.campeonatoElegido.setListaCarreras(carreras);
        tablaCarreras(Campeonato.campeonatoElegido);
        // public VehiculoCarrera(String marca, String modelo, int ano, Pieza aleron, Pieza neumaticos, Pieza motor, double velocidad, double maniobrabilidad, double precioUtilizar, Piloto piloto) {
        VehiculoCarrera vehiculoCarrera = new VehiculoCarrera("Mercedes", "AMG W11", 2021, Equipo.equipoElegido.getVehiculosDisponibles().get(0).getAleron(), Equipo.equipoElegido.getVehiculosDisponibles().get(0).getNeumaticos(), Equipo.equipoElegido.getVehiculosDisponibles().get(0).getMotor(), Equipo.equipoElegido.getVehiculosDisponibles().get(0).getVelocidad(), Equipo.equipoElegido.getVehiculosDisponibles().get(0).getManiobrabilidad(), Equipo.equipoElegido.getVehiculosDisponibles().get(0).getPrecioUtilizar(), Equipo.equipoElegido.getPilotosDisponibles().get(0));
        tablaStatsActuales(vehiculoCarrera);

	}

    public double random() {
            Random random = new Random();
            double numeroAleatorio = 200 + random.nextDouble() * (500 - 200);
            return Math.round(numeroAleatorio * 100.0) / 100.0;
        }

    static {
        Random rand = new Random();
        // Podemos crear aqui los objetos para los tests
        // Esto despues se va a serliaizar

        // Campeonatos
        Campeonato campeonatoEuropa = new Campeonato("Campeonato Europa", 2023, Ciudad.Continente.Europa, 4);
        Campeonato campeonatoAsia = new Campeonato("Campeonato Asia", 2023, Ciudad.Continente.Asia, 4);
        Campeonato campeonatoAmerica = new Campeonato("Campeonato América", 2023, Ciudad.Continente.America, 3);
        Campeonato campeonatoAfrica = new Campeonato("Campeonato África", 2023, Ciudad.Continente.Africa, 2);
        Campeonato campeonatoOceania = new Campeonato("Campeonato Oceanía", 2023, Ciudad.Continente.Oceania, 2);

        // Ciudades y Carreras
        // Europa
        Ciudad ciudad1 = new Ciudad("Montecarlo", Ciudad.Continente.Europa);
        Ciudad ciudad2 = new Ciudad("Monza", Ciudad.Continente.Europa);
        Ciudad ciudad3 = new Ciudad("Silverstone", Ciudad.Continente.Europa);
        Ciudad ciudad4 = new Ciudad("Baku", Ciudad.Continente.Europa);
        Ciudad ciudad5 = new Ciudad("Barcelona", Ciudad.Continente.Europa);
        // Asia
        Ciudad ciudad6 = new Ciudad("Shanghái", Ciudad.Continente.Asia);
        Ciudad ciudad7 = new Ciudad("Sakhir", Ciudad.Continente.Asia);
        Ciudad ciudad8 = new Ciudad("Singapur", Ciudad.Continente.Asia);
        Ciudad ciudad9 = new Ciudad("Jeddah", Ciudad.Continente.Asia);
        // América
        Ciudad ciudad10 = new Ciudad("Austin", Ciudad.Continente.America);
        Ciudad ciudad11 = new Ciudad("Monterrey", Ciudad.Continente.America);
        Ciudad ciudad12 = new Ciudad("Sao Paulo", Ciudad.Continente.America);
        Ciudad ciudad13 = new Ciudad("Buenos Aires", Ciudad.Continente.America);
        // África
        Ciudad ciudad14 = new Ciudad("Ciudad del Cabo", Ciudad.Continente.Africa);
        Ciudad ciudad15 = new Ciudad("El Cairo", Ciudad.Continente.Africa);
        Ciudad ciudad16 = new Ciudad("Nairobi", Ciudad.Continente.Africa);

        // Oceanía
        Ciudad ciudad17 = new Ciudad("Melbourne", Ciudad.Continente.Oceania);
        Ciudad ciudad18 = new Ciudad("Auckland", Ciudad.Continente.Oceania);
        Ciudad ciudad19 = new Ciudad("Sídney", Ciudad.Continente.Oceania);
        Ciudad ciudad20 = new Ciudad("Adelaida", Ciudad.Continente.Oceania);

        // Directores de Carrera
        DirectorCarrera director1 = new DirectorCarrera("Michael Schmidt", "Mónaco", 500000.0, true);
        DirectorCarrera director2 = new DirectorCarrera("Luigi Rossi", "Italia", 450000.0, true);
        DirectorCarrera director3 = new DirectorCarrera("James Smith", "Reino Unido", 520000.0, true);
        DirectorCarrera director4 = new DirectorCarrera("Javier Hernández", "España", 400000.0, true);
        DirectorCarrera director5 = new DirectorCarrera("Pierre Lefebvre", "Francia", 480000.0, true);
        DirectorCarrera director6 = new DirectorCarrera("Yoshiro Nakamura", "Japón", 600000.0, true);
        DirectorCarrera director7 = new DirectorCarrera("Chen Wei", "China", 550000.0, true);
        DirectorCarrera director8 = new DirectorCarrera("Sergio Gutiérrez", "México", 450000.0, true);
        DirectorCarrera director9 = new DirectorCarrera("Ricardo Silva", "Brasil", 500000.0, true);
        DirectorCarrera director10 = new DirectorCarrera("John Smith", "Estados Unidos", 600000.0, true);

        // Patrocinadores
        Patrocinador patrocinador1 = new Patrocinador("Red Bull", 10000000.0);
        Patrocinador patrocinador2 = new Patrocinador("Pirelli", 80000000.0);
        Patrocinador patrocinador3 = new Patrocinador("Shell", 90000000.0);
        Patrocinador patrocinador4 = new Patrocinador("MegaCorp", 10000000.0);
        Patrocinador patrocinador5 = new Patrocinador("Stark Industries", 20000000.0);
        Patrocinador patrocinador6 = new Patrocinador("Wayne Enterprises", 10000000.0);
        Patrocinador patrocinador7 = new Patrocinador("Acme Corporation", 55000000.0);
        Patrocinador patrocinador8 = new Patrocinador("Tech Innovations Ltd.", 30000000.0);
        Patrocinador patrocinador9 = new Patrocinador("Global Motorsport Group", 75000000.0);
        Patrocinador patrocinador10 = new Patrocinador("Puma", 150000000.0);

        // Creación de equipos
        Equipo equipo1 = new Equipo("Mercedes-AMG", "Alemania");
        Equipo equipo2 = new Equipo("Scuderia Ferrari", "Italia");
        Equipo equipo3 = new Equipo("Red Bull Racing", "Austria");
        Equipo equipo4 = new Equipo("McLaren Racing", "Reino Unido");
        Equipo equipo5 = new Equipo("Aston Martin", "Reino Unido");
// Creación de pilotos para cada equipo
        Piloto piloto1Equipo1 = new Piloto("H. Ham", "GER", equipo1, Math.random() * 0.4);
        Piloto piloto2Equipo1 = new Piloto("V. Bot", "FIN", equipo1, Math.random() * 0.4);
        Piloto piloto3Equipo1 = new Piloto("G. Rus", "FIN", equipo1, Math.random() * 0.4);
        Piloto piloto4Equipo1 = new Piloto("L. Ham", "GBR", equipo1, Math.random() * 0.4);
        Piloto piloto5Equipo1 = new Piloto("N. Ros", "GER", equipo1, Math.random() * 0.4);

        Piloto piloto1Equipo2 = new Piloto("C. LeC", "MON", equipo2, Math.random() * 0.4);
        Piloto piloto2Equipo2 = new Piloto("C. Sai", "ESP", equipo2, Math.random() * 0.4);
        Piloto piloto3Equipo2 = new Piloto("D. Ric", "AUS", equipo2, Math.random() * 0.4);
        Piloto piloto4Equipo2 = new Piloto("L. Nor", "GBR", equipo2, Math.random() * 0.4);
        Piloto piloto5Equipo2 = new Piloto("A. Gio", "ITA", equipo2, Math.random() * 0.4);

        Piloto piloto1Equipo3 = new Piloto("M. Ver", "NED", equipo3, Math.random() * 0.4);
        Piloto piloto2Equipo3 = new Piloto("S. Per", "MEX", equipo3, Math.random() * 0.4);
        Piloto piloto3Equipo3 = new Piloto("S. Gas", "FRA", equipo3, Math.random() * 0.4);
        Piloto piloto4Equipo3 = new Piloto("Y. Tsn", "JPN", equipo3, Math.random() * 0.4);
        Piloto piloto5Equipo3 = new Piloto("P. Alx", "THA", equipo3, Math.random() * 0.4);

        Piloto piloto1Equipo4 = new Piloto("L. Nor", "GBR", equipo4, Math.random() * 0.4);
        Piloto piloto2Equipo4 = new Piloto("D. Ric", "AUS", equipo4, Math.random() * 0.4);
        Piloto piloto3Equipo4 = new Piloto("L. Ham", "GBR", equipo4, Math.random() * 0.4);
        Piloto piloto4Equipo4 = new Piloto("A. Rai", "FIN", equipo4, Math.random() * 0.4);
        Piloto piloto5Equipo4 = new Piloto("C. Sci", "LOR", equipo4, Math.random() * 0.4);

        Piloto piloto1Equipo5 = new Piloto("S. Vet", "GER", equipo5, Math.random() * 0.4);
        Piloto piloto2Equipo5 = new Piloto("L. Str", "CAN", equipo5, Math.random() * 0.4);
        Piloto piloto3Equipo5 = new Piloto("L. Hld", "DEN", equipo5, Math.random() * 0.4);
        Piloto piloto4Equipo5 = new Piloto("Y. Tsu", "JPN", equipo5, Math.random() * 0.4);
        Piloto piloto5Equipo5 = new Piloto("P. Lbe", "GBR", equipo5, Math.random() * 0.4);


        // Agregar a equipo1
        equipo1.agregarPiloto(piloto1Equipo1);
        equipo1.agregarPiloto(piloto2Equipo1);
        equipo1.agregarPiloto(piloto3Equipo1);
        equipo1.agregarPiloto(piloto4Equipo1);
        equipo1.agregarPiloto(piloto5Equipo1);
        // Agregar a equipo2
        equipo2.agregarPiloto(piloto1Equipo2);
        equipo2.agregarPiloto(piloto2Equipo2);
        equipo2.agregarPiloto(piloto3Equipo2);
        equipo2.agregarPiloto(piloto4Equipo2);
        equipo2.agregarPiloto(piloto5Equipo2);
        // Agregar a equipo3
        equipo3.agregarPiloto(piloto1Equipo3);
        equipo3.agregarPiloto(piloto2Equipo3);
        equipo3.agregarPiloto(piloto3Equipo3);
        equipo3.agregarPiloto(piloto4Equipo3);
        equipo3.agregarPiloto(piloto5Equipo3);
        // Agregar a equipo4
        equipo4.agregarPiloto(piloto1Equipo4);
        equipo4.agregarPiloto(piloto2Equipo4);
        equipo4.agregarPiloto(piloto3Equipo4);
        equipo4.agregarPiloto(piloto4Equipo4);
        equipo4.agregarPiloto(piloto5Equipo4);
        // Agregar a equipo5
        equipo5.agregarPiloto(piloto1Equipo5);
        equipo5.agregarPiloto(piloto2Equipo5);
        equipo5.agregarPiloto(piloto3Equipo5);
        equipo5.agregarPiloto(piloto4Equipo5);
        equipo5.agregarPiloto(piloto5Equipo5);

        // Partes
        // Alerones
        Pieza aleronMercedes = new Pieza(false, 25.0, 0.20, "Alerón Mercedes", rand.nextInt(301) + 200);
        Pieza aleronFerrari = new Pieza(false, 25.0, 0.20, "Alerón Ferrari", rand.nextInt(301) + 200);
        Pieza aleronRedBull = new Pieza(false, 25.0, 0.20, "Alerón Red Bull", rand.nextInt(301) + 200);
        Pieza aleronMcLaren = new Pieza(false, 25.0, 0.20, "Alerón McLaren", rand.nextInt(301) + 200);
        Pieza aleronAstonMartin = new Pieza(false, 25.0, 0.20, "Alerón Aston Martin", rand.nextInt(301) + 200);
        Pieza aleronAlpine = new Pieza(false, 25.0, 0.20, "Alerón Alpine", rand.nextInt(301) + 200);
        Pieza aleronWilliams = new Pieza(false, 25.0, 0.20, "Alerón Williams", rand.nextInt(301) + 200);
        Pieza aleronAlfaRomeo = new Pieza(false, 25.0, 0.20, "Alerón Alfa Romeo", rand.nextInt(301) + 200);
        Pieza aleronHaas = new Pieza(false, 25.0, 0.20, "Alerón Haas", rand.nextInt(301) + 200);
        Pieza aleronUralkali = new Pieza(false, 25.0, 0.20, "Alerón Uralkali", rand.nextInt(301) + 200);
        // Neumaticos
        Pieza neumaticosMercedes = new Pieza(false, 10.0, 0.30, "Neumáticos Mercedes", rand.nextInt(301) + 300);
        Pieza neumaticosFerrari = new Pieza(false, 10.0, 0.30, "Neumáticos Ferrari", rand.nextInt(301) + 300);
        Pieza neumaticosRedBull = new Pieza(false, 10.0, 0.30, "Neumáticos Red Bull", rand.nextInt(301) + 300);
        Pieza neumaticosMcLaren = new Pieza(false, 10.0, 0.30, "Neumáticos McLaren", rand.nextInt(301) + 300);
        Pieza neumaticosAstonMartin = new Pieza(false, 10.0, 0.30, "Neumáticos Aston Martin", rand.nextInt(301) + 300);
        Pieza neumaticosAlpine = new Pieza(false, 10.0, 0.30, "Neumáticos Alpine", rand.nextInt(301) + 300);
        Pieza neumaticosWilliams = new Pieza(false, 10.0, 0.30, "Neumáticos Williams", rand.nextInt(301) + 300);
        Pieza neumaticosAlfaRomeo = new Pieza(false, 10.0, 0.30, "Neumáticos Alfa Romeo", rand.nextInt(301) + 300);
        Pieza neumaticosHaas = new Pieza(false, 10.0, 0.30, "Neumáticos Haas", rand.nextInt(301) + 300);
        Pieza neumaticosUralkali = new Pieza(false, 10.0, 0.30, "Neumáticos Uralkali", rand.nextInt(301) + 300);
        // Motores
        Pieza motorMercedes = new Pieza(false, 10.0, 0.10, "Motor Mercedes", rand.nextInt(301) + 200);
        Pieza motorFerrari = new Pieza(false, 10.0, 0.10, "Motor Ferrari", rand.nextInt(301) + 200);
        Pieza motorRedBull = new Pieza(false, 10.0, 0.10, "Motor Red Bull", rand.nextInt(301) + 200);
        Pieza motorMcLaren = new Pieza(false, 10.0, 0.10, "Motor McLaren", rand.nextInt(301) + 200);
        Pieza motorAstonMartin = new Pieza(false, 10.0, 0.10, "Motor Aston Martin", rand.nextInt(301) + 200);
        Pieza motorAlpine = new Pieza(false, 10.0, 0.10, "Motor Alpine", rand.nextInt(301) + 200);
        Pieza motorWilliams = new Pieza(false, 10.0, 0.10, "Motor Williams", rand.nextInt(301) + 200);
        Pieza motorAlfaRomeo = new Pieza(false, 10.0, 0.10, "Motor Alfa Romeo", rand.nextInt(301) + 200);
        Pieza motorHaas = new Pieza(false, 10.0, 0.10, "Motor Haas", rand.nextInt(301) + 200);
        Pieza motorUralkali = new Pieza(false, 10.0, 0.10, "Motor Uralkali", rand.nextInt(301) + 200);

        // Piezas contrabando
        Pieza motorContrabando1 = new Pieza(false, 10.0, 0.10, "Motor de Carrera Ilegal", rand.nextInt(301) + 200, true);
        Pieza motorContrabando2 = new Pieza(false, 12.0, 0.08, "Motor Turbo Prohibido", rand.nextInt(301) + 200, true);
        Pieza motorContrabando3 = new Pieza(false, 8.0, 0.12, "Motor Veloz Oscuro", rand.nextInt(301) + 200, true);

        Pieza aleronContrabando1 = new Pieza(false, 6.0, 0.15, "Alerón Sigiloso", rand.nextInt(301) + 200, true);
        Pieza aleronContrabando2 = new Pieza(false, 8.0, 0.10, "Alerón Furtivo", rand.nextInt(301) + 200, true);
        Pieza aleronContrabando3 = new Pieza(false, 7.0, 0.12, "Alerón Sombra Rápida", rand.nextInt(301) + 200, true);

        Pieza neumaticoContrabando1 = new Pieza(false, 10.0, 0.08, "Neumático de Goma Nocturna", rand.nextInt(301) + 200, true);
        Pieza neumaticoContrabando2 = new Pieza(false, 9.0, 0.09, "Neumático Misterioso", rand.nextInt(301) + 200, true);
        Pieza neumaticoContrabando3 = new Pieza(false, 11.0, 0.07, "Neumático Fugitivo", rand.nextInt(301) + 200, true);

        // Vehiculos
        Vehiculo vehiculo1 = new Vehiculo("Mercedes", "AMG W11", 2021, aleronMercedes, neumaticosMercedes, motorMercedes, 350.0, 9.5, 200.0);
        Vehiculo vehiculo2 = new Vehiculo("Mercedes", "AMG GT", 2022, aleronMercedes, neumaticosMercedes, motorMercedes, 330.0, 9.0, 180.0);
        Vehiculo vehiculo3 = new Vehiculo("Ferrari", "SF21", 2021, aleronFerrari, neumaticosFerrari, motorFerrari, 340.0, 9.0, 190.0);
        Vehiculo vehiculo4 = new Vehiculo("Ferrari", "SF22", 2022, aleronFerrari, neumaticosFerrari, motorFerrari, 320.0, 8.5, 170.0);
        Vehiculo vehiculo5 = new Vehiculo("Red Bull", "RB16B", 2021, aleronRedBull, neumaticosRedBull, motorRedBull, 330.0, 9.0, 180.0);
        Vehiculo vehiculo6 = new Vehiculo("Red Bull", "RB17", 2022, aleronRedBull, neumaticosRedBull, motorRedBull, 310.0, 8.5, 160.0);
        Vehiculo vehiculo7 = new Vehiculo("McLaren", "MCL35M", 2021, aleronMcLaren, neumaticosMcLaren, motorMcLaren, 320.0, 8.5, 170.0);
        Vehiculo vehiculo8 = new Vehiculo("McLaren", "MCL36", 2022, aleronMcLaren, neumaticosMcLaren, motorMcLaren, 300.0, 8.0, 150.0);
        Vehiculo vehiculo9 = new Vehiculo("Aston Martin", "AMR21", 2021, aleronAstonMartin, neumaticosAstonMartin, motorAstonMartin, 310.0, 8.5, 160.0);
        Vehiculo vehiculo10 = new Vehiculo("Aston Martin", "AMR22", 2022, aleronAstonMartin, neumaticosAstonMartin, motorAstonMartin, 290.0, 8.0, 140.0);
        Vehiculo vehiculo11 = new Vehiculo("Alpine", "A521", 2021, aleronAlpine, neumaticosAlpine, motorAlpine, 300.0, 8.0, 150.0);
        Vehiculo vehiculo12 = new Vehiculo("Alpine", "A522", 2022, aleronAlpine, neumaticosAlpine, motorAlpine, 280.0, 7.5, 130.0);
        Vehiculo vehiculo13 = new Vehiculo("Williams", "FW43B", 2021, aleronWilliams, neumaticosWilliams, motorWilliams, 290.0, 8.0, 140.0);
        Vehiculo vehiculo14 = new Vehiculo("Williams", "FW44", 2022, aleronWilliams, neumaticosWilliams, motorWilliams, 270.0, 7.5, 120.0);
        Vehiculo vehiculo15 = new Vehiculo("Alfa Romeo", "C41", 2021, aleronAlfaRomeo, neumaticosAlfaRomeo, motorAlfaRomeo, 280.0, 7.5, 130.0);
        Vehiculo vehiculo16 = new Vehiculo("Alfa Romeo", "C42", 2022, aleronAlfaRomeo, neumaticosAlfaRomeo, motorAlfaRomeo, 260.0, 7.0, 110.0);
        Vehiculo vehiculo17 = new Vehiculo("Haas", "VF-21", 2021, aleronHaas, neumaticosHaas, motorHaas, 270.0, 7.5, 120.0);
        Vehiculo vehiculo18 = new Vehiculo("Haas", "VF-22", 2022, aleronHaas, neumaticosHaas, motorHaas, 250.0, 7.0, 100.0);
        Vehiculo vehiculo19 = new Vehiculo("Uralkali Haas", "VF-23", 2023, aleronUralkali, neumaticosUralkali, motorUralkali, 230.0, 6.5, 90.0);
        Vehiculo vehiculo20 = new Vehiculo("Uralkali Haas", "VF-24", 2024, aleronUralkali, neumaticosUralkali, motorUralkali, 210.0, 6.0, 70.0);

        // Agregar a Equipos
        equipo1.agregarVehiculo(vehiculo1);
        equipo1.agregarVehiculo(vehiculo2);
        equipo2.agregarVehiculo(vehiculo3);
        equipo2.agregarVehiculo(vehiculo4);
        equipo3.agregarVehiculo(vehiculo5);
        equipo3.agregarVehiculo(vehiculo6);
        equipo4.agregarVehiculo(vehiculo7);
        equipo4.agregarVehiculo(vehiculo8);
        equipo5.agregarVehiculo(vehiculo9);
        equipo5.agregarVehiculo(vehiculo10);
        
        
    }
	}

	
        
        
        
		
	
	

