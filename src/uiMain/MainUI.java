package uiMain;

import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import static uiMain.AsciiArt.*;
import static uiMain.Tablas.*;

public class MainUI {
    static {
        Random rand = new Random();
        // Podemos crear aqui los objetos para los tests
        // Esto despues se va a serliaizar

        // Campeonatos
        Campeonato campeonatoEuropa = new Campeonato("Campeonato Europa", 2023, Ciudad.Continente.Europa, 4);
        Campeonato campeonatoAsia = new Campeonato("Campeonato Asia", 2023, Ciudad.Continente.Asia, 4);
        Campeonato campeonatoAmerica = new Campeonato("Campeonato Am?rica", 2023, Ciudad.Continente.America, 3);
        Campeonato campeonatoAfrica = new Campeonato("Campeonato ?frica", 2023, Ciudad.Continente.Africa, 2);
        Campeonato campeonatoOceania = new Campeonato("Campeonato Ocean?a", 2023, Ciudad.Continente.Oceania, 2);

        // Ciudades y Carreras
        // Europa
        Ciudad ciudad1 = new Ciudad("Montecarlo", Ciudad.Continente.Europa);

        Ciudad ciudad2 = new Ciudad("Monza", Ciudad.Continente.Europa);

        Ciudad ciudad3 = new Ciudad("Silverstone", Ciudad.Continente.Europa);
        Ciudad ciudad4 = new Ciudad("Baku", Ciudad.Continente.Europa);
        Ciudad ciudad5 = new Ciudad("Barcelona", Ciudad.Continente.Europa);
        // Asia
        Ciudad ciudad6 = new Ciudad("Shangh?i", Ciudad.Continente.Asia);
        Ciudad ciudad7 = new Ciudad("Sakhir", Ciudad.Continente.Asia);
        Ciudad ciudad8 = new Ciudad("Singapur", Ciudad.Continente.Asia);
        Ciudad ciudad9 = new Ciudad("Jeddah", Ciudad.Continente.Asia);
        // Am?rica
        Ciudad ciudad10 = new Ciudad("Austin", Ciudad.Continente.America);
        Ciudad ciudad11 = new Ciudad("Monterrey", Ciudad.Continente.America);
        Ciudad ciudad12 = new Ciudad("Sao Paulo", Ciudad.Continente.America);
        Ciudad ciudad13 = new Ciudad("Buenos Aires", Ciudad.Continente.America);
        // ?frica
        Ciudad ciudad14 = new Ciudad("Ciudad del Cabo", Ciudad.Continente.Africa);
        Ciudad ciudad15 = new Ciudad("El Cairo", Ciudad.Continente.Africa);
        Ciudad ciudad16 = new Ciudad("Nairobi", Ciudad.Continente.Africa);

        // Ocean?a
        Ciudad ciudad17 = new Ciudad("Melbourne", Ciudad.Continente.Oceania);
        Ciudad ciudad18 = new Ciudad("Auckland", Ciudad.Continente.Oceania);
        Ciudad ciudad19 = new Ciudad("S?dney", Ciudad.Continente.Oceania);
        Ciudad ciudad20 = new Ciudad("Adelaida", Ciudad.Continente.Oceania);

        // Directores de Carrera
        DirectorCarrera director1 = new DirectorCarrera("Michael Schmidt", "M?naco", 500000.0, true);
        DirectorCarrera director2 = new DirectorCarrera("Luigi Rossi", "Italia", 450000.0, true);
        DirectorCarrera director3 = new DirectorCarrera("James Smith", "Reino Unido", 520000.0, true);
        DirectorCarrera director4 = new DirectorCarrera("Javier Hern?ndez", "Espa?a", 400000.0, true);
        DirectorCarrera director5 = new DirectorCarrera("Pierre Lefebvre", "Francia", 480000.0, true);
        DirectorCarrera director6 = new DirectorCarrera("Yoshiro Nakamura", "Jap?n", 600000.0, true);
        DirectorCarrera director7 = new DirectorCarrera("Chen Wei", "China", 550000.0, true);
        DirectorCarrera director8 = new DirectorCarrera("Sergio Guti?rrez", "M?xico", 450000.0, true);
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

        // Creaci?n de equipos
        Equipo equipo1 = new Equipo("Mercedes-AMG", "Alemania");
        Equipo equipo2 = new Equipo("Scuderia Ferrari", "Italia");
        Equipo equipo3 = new Equipo("Red Bull Racing", "Austria");
        Equipo equipo4 = new Equipo("McLaren Racing", "Reino Unido");
        Equipo equipo5 = new Equipo("Aston Martin", "Reino Unido");
// Creaci?n de pilotos para cada equipo
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
        Pieza aleronMercedes = new Pieza(false, 25.0, 0.20, "Aler?n Mercedes", rand.nextInt(301) + 200, "A");
        Pieza aleronFerrari = new Pieza(false, 25.0, 0.20, "Aler?n Ferrari", rand.nextInt(301) + 200, "A");
        Pieza aleronRedBull = new Pieza(false, 25.0, 0.20, "Aler?n Red Bull", rand.nextInt(301) + 200, "A");
        Pieza aleronMcLaren = new Pieza(false, 25.0, 0.20, "Aler?n McLaren", rand.nextInt(301) + 200, "A");
        Pieza aleronAstonMartin = new Pieza(false, 25.0, 0.20, "Aler?n Aston Martin", rand.nextInt(301) + 200, "A");
        Pieza aleronAlpine = new Pieza(false, 25.0, 0.20, "Aler?n Alpine", rand.nextInt(301) + 200, "A");
        Pieza aleronWilliams = new Pieza(false, 25.0, 0.20, "Aler?n Williams", rand.nextInt(301) + 200, "A");
        Pieza aleronAlfaRomeo = new Pieza(false, 25.0, 0.20, "Aler?n Alfa Romeo", rand.nextInt(301) + 200, "A");
        Pieza aleronHaas = new Pieza(false, 25.0, 0.20, "Aler?n Haas", rand.nextInt(301) + 200, "A");
        Pieza aleronUralkali = new Pieza(false, 25.0, 0.20, "Aler?n Uralkali", rand.nextInt(301) + 200, "A");
        // Neumaticos
        Pieza neumaticosMercedes = new Pieza(false, 10.0, 0.30, "Neum?ticos Mercedes", rand.nextInt(301) + 300, "N");
        Pieza neumaticosFerrari = new Pieza(false, 10.0, 0.30, "Neum?ticos Ferrari", rand.nextInt(301) + 300, "N");
        Pieza neumaticosRedBull = new Pieza(false, 10.0, 0.30, "Neum?ticos Red Bull", rand.nextInt(301) + 300, "N");
        Pieza neumaticosMcLaren = new Pieza(false, 10.0, 0.30, "Neum?ticos McLaren", rand.nextInt(301) + 300, "N");
        Pieza neumaticosAstonMartin = new Pieza(false, 10.0, 0.30, "Neum?ticos Aston Martin", rand.nextInt(301) + 300, "N");
        Pieza neumaticosAlpine = new Pieza(false, 10.0, 0.30, "Neum?ticos Alpine", rand.nextInt(301) + 300, "N");
        Pieza neumaticosWilliams = new Pieza(false, 10.0, 0.30, "Neum?ticos Williams", rand.nextInt(301) + 300, "N");
        Pieza neumaticosAlfaRomeo = new Pieza(false, 10.0, 0.30, "Neum?ticos Alfa Romeo", rand.nextInt(301) + 300, "N");
        Pieza neumaticosHaas = new Pieza(false, 10.0, 0.30, "Neum?ticos Haas", rand.nextInt(301) + 300, "N");
        Pieza neumaticosUralkali = new Pieza(false, 10.0, 0.30, "Neum?ticos Uralkali", rand.nextInt(301) + 300, "N");
        // Motores
        Pieza motorMercedes = new Pieza(false, 10.0, 0.10, "Motor Mercedes", rand.nextInt(301) + 200, "M");
        Pieza motorFerrari = new Pieza(false, 10.0, 0.10, "Motor Ferrari", rand.nextInt(301) + 200, "M");
        Pieza motorRedBull = new Pieza(false, 10.0, 0.10, "Motor Red Bull", rand.nextInt(301) + 200, "M");
        Pieza motorMcLaren = new Pieza(false, 10.0, 0.10, "Motor McLaren", rand.nextInt(301) + 200, "M");
        Pieza motorAstonMartin = new Pieza(false, 10.0, 0.10, "Motor Aston Martin", rand.nextInt(301) + 200, "M");
        Pieza motorAlpine = new Pieza(false, 10.0, 0.10, "Motor Alpine", rand.nextInt(301) + 200, "M");
        Pieza motorWilliams = new Pieza(false, 10.0, 0.10, "Motor Williams", rand.nextInt(301) + 200, "M");
        Pieza motorAlfaRomeo = new Pieza(false, 10.0, 0.10, "Motor Alfa Romeo", rand.nextInt(301) + 200, "M");
        Pieza motorHaas = new Pieza(false, 10.0, 0.10, "Motor Haas", rand.nextInt(301) + 200, "M");
        Pieza motorUralkali = new Pieza(false, 10.0, 0.10, "Motor Uralkali", rand.nextInt(301) + 200, "M");

        // Piezas contrabando
        Pieza motorContrabando1 = new Pieza(false, 10.0, 0.10, "Motor de Carrera Ilegal", rand.nextInt(301) + 200, true, "M");
        Pieza motorContrabando2 = new Pieza(false, 12.0, 0.08, "Motor Turbo Prohibido", rand.nextInt(301) + 200, true, "M");
        Pieza motorContrabando3 = new Pieza(false, 8.0, 0.12, "Motor Veloz Oscuro", rand.nextInt(301) + 200, true, "M");

        Pieza aleronContrabando1 = new Pieza(false, 6.0, 0.15, "Aler?n Sigiloso", rand.nextInt(301) + 200, true, "A");
        Pieza aleronContrabando2 = new Pieza(false, 8.0, 0.10, "Aler?n Furtivo", rand.nextInt(301) + 200, true, "A");
        Pieza aleronContrabando3 = new Pieza(false, 7.0, 0.12, "Aler?n Sombra R?pida", rand.nextInt(301) + 200, true, "A");

        Pieza neumaticoContrabando1 = new Pieza(false, 10.0, 0.08, "Neum?tico de Goma Nocturna", rand.nextInt(301) + 200, true, "N");
        Pieza neumaticoContrabando2 = new Pieza(false, 9.0, 0.09, "Neum?tico Misterioso", rand.nextInt(301) + 200, true, "N");
        Pieza neumaticoContrabando3 = new Pieza(false, 11.0, 0.07, "Neum?tico Fugitivo", rand.nextInt(301) + 200, true, "N");

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

    /**
     * This is the "ui"
     */
    public static void main(String[] args) {
        // Variables Necesarias
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("\n");
        // Mensaje de bienvenida
        bienvenida();
        System.out.println("\n");
        /*Descomentar
        sc.nextLine();*/

        // Mensaje de introduccion
        System.out.println("?Hola! En este juego, ser?s un piloto de un equipo de carreras de F?rmula 1.");
        System.out.println("Tu objetivo es ganar el campeonato de carreras, para ello, deber?s competir en carreras y obtener puntos.");
        System.out.println("?Buena suerte!\n");

        /*Descomentar
        System.out.println("\n");
        sc.nextLine();*/


        System.out.println("Primero debes preparar el campeonato en el que competir?s.");
        System.out.println("?Comencemos!");
        System.out.println("\n");

        // FUNCIONALIDAD PREPARAR CAMPEONATO
        // Pasos para Preparar el Campeonato
        //System.out.println("Preparar el Campeonato");
        // Paso 1: Escoge un Campeonato
        System.out.println("Elige uno de los 5 campeonatos, escribe un numero del 1 al 5.");
        tablaCampeonatos(Campeonato.campeonatos);
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
                System.out.println("?Campeonato elegido!");
                // Imprimir campeonato actual con tabla
                System.out.println("\n");
                validaciones = true;
            }
        }

        // Paso 2: Elige el A?o
        System.out.println("Elige el Anio");
        System.out.println("Indica el anioo en el que quieres que se celebre el campeonato.");
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
                System.out.println("Anio elegido!");
                System.out.println("\n");
                validaciones = true;
            }
        }

        System.out.println("?Tu campeonato quedo configurado!");
        // imprmir como se ve con tablitas
        // Descomentar -
        System.out.println("Campeonato actual: " + Campeonato.campeonatoElegido.getNombre() + " " + Campeonato.campeonatoElegido.getAno());
        System.out.println("\n");


        // TODO banner();
        // Paso 3: Selecciona tu Equipo
        System.out.println("Selecciona tu Escuderia");
        // imprimir equipos
        tablaEquipos(Equipo.equipos);
        System.out.println("Escoge una escuderia para competir en el campeonato, escribe un numero del 1 al 5.");
        System.out.println("\n");
        validaciones = false;
        // Validar que sea un numero del 1 al 10
        /*Descomentar
        n = sc.nextInt();*/
        n = rand.nextInt(5) + 1;

        while (!validaciones) {
            if (n < 1 || n > 5) {
                // Si no es del 1 al 10, imprimir el mensaje de error
                System.out.println("Por favor, escribe un numero del 1 al 5.");
                n = sc.nextInt(); // Para que no se quede en un loop infinito xd
            } else {
                Equipo.equipoElegido = Equipo.equipos.get(n - 1);
                System.out.println("Escuderia elegida!"); // Si es del 1 al 5, imprimir el mensaje de exito

                System.out.println("\n");
                validaciones = true; // Si es del 1 al 5, cambiar validaciones a true
            }
        }


        // Paso 4: Mira los Pilotos de tu Equipo
        System.out.println("Mira los Pilotos de tu Escuderia");
        // TODO imprimir pilotos con stats

        // Paso 5: Escoge tus Pilotos
        System.out.println("Escoge tu Piloto, escribe un numero del 1 al 5.");
        System.out.println("\n");

        validaciones = false;
        // Validar que sea un numero del 1 al 5
        /*Descomentar
        n = sc.nextInt();*/
        n = rand.nextInt(5) + 1;

        while (!validaciones) {
            if (n < 1 || n > 5) {
                // Si no es del 1 al 5, imprimir el mensaje de error
                System.out.println("Por favor, escribe un numero del 1 al 5.");
                n = sc.nextInt(); // Para que no se quede en un loop infinito xd
            } else {
                Piloto.pilotoElegido = Equipo.equipoElegido.getPilotosDisponibles().get(n - 1);
                Equipo.equipoElegido.getPilotosDisponibles().remove(Piloto.pilotoElegido);
                Equipo.equipoElegido.setPiloto1(Piloto.pilotoElegido);
                System.out.println("?Piloto elegido!"); // Si es del 1 al 5, imprimir el mensaje de exito
                System.out.println("\n");
                validaciones = true; // Si es del 1 al 5, cambiar validaciones a true
            }
        }

        System.out.println("Escoge tu compa?ero de equipo");
        // imprimir pilotos con stats
        // Paso 5: Escoge tus Pilotos
        System.out.println("Escoge tu Piloto, escribe un numero del 1 al 4.");
        System.out.println("\n");

        validaciones = false;
        // Validar que sea un numero del 1 al 4
        /*Descomentar
        n = sc.nextInt();*/
        n = rand.nextInt(4) + 1;

        while (!validaciones) {
            if (n < 1 || n > 4) {
                // Si no es del 1 al 4, imprimir el mensaje de error
                System.out.println("Por favor, escribe un numero del 1 al 4.");
                n = sc.nextInt(); // Para que no se quede en un loop infinito xd
            } else {
                Equipo.equipoElegido.setPiloto2(Equipo.equipoElegido.getPilotosDisponibles().get(n - 1));
                Equipo.equipoElegido.getPilotosDisponibles().remove(Equipo.equipoElegido.getPiloto2());
                System.out.println("?Has elegido tu compa?ero de equipo!"); // Si es del 1 al 4, imprimir el mensaje de exito
                System.out.println("\n");
                validaciones = true; // Si es del 1 al 4, cambiar validaciones a true
            }
        }

        // Imprimir equipo elegido con tabla linda
        System.out.println(Equipo.equipoElegido + "\n"); // Borrar-tabla

        // Elegir pilotos a competir de los otros equipos
        for (Equipo equipo : Equipo.equipos) {
            if (equipo != Equipo.equipoElegido) {
                equipo.setPiloto1(equipo.getPilotosDisponibles().get(rand.nextInt(5)));
                equipo.getPilotosDisponibles().remove(equipo.getPiloto1());
                equipo.setPiloto2(equipo.getPilotosDisponibles().get(rand.nextInt(4)));
                equipo.getPilotosDisponibles().remove(equipo.getPiloto2());
                System.out.println(equipo + "\n");
            }
        }

        // Paso 6: Negocia con Patrocinadores

        // Negociar: Equipos No elegidos
        for (Equipo equipo : Equipo.equipos) {
            /*Descomentar
            if (equipo != Equipo.equipoElegido) {*/
            for (Patrocinador patrocinador : Patrocinador.listaPatrocinadores) {
                if (equipo.getPlata() > 1000) {
                    break;
                } else {
                    equipo.negociar(patrocinador, true); //Se intenta
                    System.out.println(equipo.getNombre() + " intent? negociar con " + patrocinador.getNombre() + " por " + patrocinador.getDineroOfrecido() + " d?lares.");
                    System.out.println("El equipo " + equipo.getNombre() + " tiene " + equipo.getPlata() + " d?lares.");
                    System.out.println("\n");
                }
            }
//            }
        }

       /* for (Equipo equipo : Equipo.equipos) {
            System.out.println(equipo.getNombre() + " tiene " + equipo.getPlata() + " d?lares.");
            System.out.println("\n");
        }*/

        /*Descomentar
        System.out.println("Actualmente, tu equipo no tiene dinero :(.");
        MainUI.negociar();*/


        // FUNCIONALIDAD Planificar Calendario de Carreras

        System.out.println("?Listo! Ahora est?s preparado para comenzar tu emocionante campeonato de carreras. ?Divi?rtete!");

        banner("?Que comience el " + Campeonato.campeonatoElegido.getNombre() + "!", String.valueOf(Campeonato.campeonatoElegido.getAno()));
        System.out.println("\n");

        // for de acuerdo al numero de carreras en le campeonato elegido
        // Crear carreras
        System.out.println("Es hora de preparar todas las carreras en las que competir?s.");
        System.out.println("?Comencemos!");

        // list of months
        ArrayList<Integer> meses = new ArrayList<>();

        // Add numbers from 1 to 12 to the ArrayList
        for (int i = 1; i <= 12; i++) {
            meses.add(i);
        }

        for (int i = 0; i < Campeonato.campeonatoElegido.getCantidadMaxCarreras(); i++) {
            System.out.println("Elige la cuidad en la que quieres que sea la carrera, escribe un numero de acuerdo a la opcion que quieras");

            ArrayList<Ciudad> ciudades = Ciudad.mostrarCiudadesDisponibles(Campeonato.campeonatoElegido.getContinente());
            validaciones = false;
            n = sc.nextInt();
            Ciudad ciudad = null;
            while (!validaciones) {
                if (n < 1 || n > ciudades.size()) {
                    System.out.println("Por favor, escribe un numero del 1 al " + ciudades.size() + ".");
                    n = sc.nextInt(); // Para que no se quede en un loop infinito xd
                } else {
                    ciudad = ciudades.get(n - 1);
                    System.out.println("?Ciudad elegida!");
                    System.out.println("\n");
                    validaciones = true;
                }
            }
            // Elegir director de carrera
            System.out.println("Elige el director de carrera, escribe un numero de acuerdo a la opcion que quieras \n");
            tablaDirectoresCarrera(DirectorCarrera.listaDirectores);
            validaciones = false;
            n = sc.nextInt();
            DirectorCarrera directorCarrera = null;
            while (!validaciones) {
                if (n < 1 || n > DirectorCarrera.listaDirectores.size()) {
                    System.out.println("Por favor, escribe un numero del 1 al " + DirectorCarrera.listaDirectores.size() + ".");
                    n = sc.nextInt(); // Para que no se quede en un loop infinito xd
                } else {
                    directorCarrera = DirectorCarrera.listaDirectores.get(n - 1);
                    System.out.println("?Director de carrera elegido!");
                    System.out.println("\n");
                    validaciones = true;
                }
            }
            // Elegir mes de la carrera
            System.out.println("Elige el mes en el que quieres que sea la carrera, escribe un numero del 1 al 12.");
            System.out.println("Nota: Las carreras deben ser en meses distintos.");
            validaciones = false;
            n = sc.nextInt();
            int mes = 0;
            while (!validaciones) {
                if (n < 1 || n > 12 || !meses.contains(n)) {
                    System.out.println("Por favor, escribe un numero del 1 al 12.");
                    System.out.println("Nota: Las carreras deben ser en meses distintos.");
                    n = sc.nextInt(); // Para que no se quede en un loop infinito xd
                } else {
                    mes = n;
                    meses.remove(Integer.valueOf(n));
                    System.out.println("?Mes elegido!");
                    System.out.println("\n");
                    validaciones = true;
                }
            }
            // Elegir dificultad del 1 al 3
            System.out.println("Elige la dificultad de la carrera, escribe un numero del 1 al 3.");
            System.out.println("+------------------+-------+");
            System.out.println("|   Dificultad    | Opci?n|");
            System.out.println("+------------------+-------+");
            System.out.println("|  Avanzado        |   1   |");
            System.out.println("|  Experto         |   2   |");
            System.out.println("|  Maestro         |   3   |");
            System.out.println("+------------------+-------+");
            validaciones = false;
            n = sc.nextInt();

            int dificultad = 0;
            while (!validaciones) {
                if (n < 1 || n > 3) {
                    System.out.println("Por favor, escribe un numero del 1 al 3.");
                    n = sc.nextInt(); // Para que no se quede en un loop infinito xd
                } else {
                    dificultad = n;
                    System.out.println("?Dificultad elegida!");
                    System.out.println("\n");
                    validaciones = true;
                }
            }

            Carrera carrera = new Carrera(ciudad, mes, dificultad);
            carrera.setDirectorCarrera(directorCarrera);

            System.out.println("Es momento de que elijas el circuito de la carrera.");
            // Imprimir circuitos
            for (Circuito circuito : Circuito.values()) {
                System.out.println("Circuito 1: $" + circuito.getPrecio());
                System.out.println(circuito.getPattern());
                System.out.println("\n");
            }

            Circuito circuito = null;
            validaciones = false;
            while (!validaciones) {
                n = sc.nextInt();
                if (n < 1 || n > Circuito.values().length) {
                    System.out.println("Por favor, escribe un numero del 1 al " + Circuito.values().length + ".");
                } else {
                    int randomNumber = rand.nextInt(2) + 1;
                    if (randomNumber == 1) {
                        circuito = Circuito.values()[n - 1];
                        carrera.setCircuito(circuito); // asignar circuito a la carrera
                        carrera.getDirectorCarrera().setPlata(carrera.getDirectorCarrera().getPlata() - circuito.getPrecio()); // restar plata al director de carrera
                        System.out.println("?Circuito elegido!");
                        System.out.println("\n");
                        validaciones = true;
                    } else {
                        System.out.println("?Al director de carrera no le gusto el circuito! Intenta de nuevo.");
                        System.out.println("\n");
                    }
                }
            }
            Campeonato.campeonatoElegido.agregarCarrera(carrera); // agregar carrera al campeonato
        }
        //Organizar las carreras por mes
        Campeonato.organizarCarreras();

        // TODO: Calendario de carreras tabla

        // ANTES DE INICIAR LA CARRERA
        System.out.println("Es hora de elegir tu vehiculo de carrera.");
        System.out.println("?Comencemos!");
        System.out.println("\n");
        System.out.println("Elige tu vehiculo de carrera, escribe un numero de acuerdo a la opcion que quieras.");
        // Imprimir vehiculos
        tablaVehiculos(Equipo.equipoElegido.getVehiculosDisponibles());
        n = sc.nextInt();
        validaciones = false;
        VehiculoCarrera vehiculo1 = null;
        while (!validaciones) {
            if (n < 1 || n > Equipo.equipoElegido.getVehiculosDisponibles().size()) {
                System.out.println("Por favor, escribe un numero del 1 al " + Equipo.equipoElegido.getVehiculosDisponibles().size() + ".");
                n = sc.nextInt(); // Para que no se quede en un loop infinito xd
            } else {
                Vehiculo vehiculo = Equipo.equipoElegido.getVehiculosDisponibles().get(n - 1);
                Carrera.agregarVehiculoCarrerra(VehiculoCarrera.vehiculoElegido);
                vehiculo1 = VehiculoCarrera.vehiculoElegido;
                System.out.println("?Veh?culo elegido!");
                System.out.println("\n");
                validaciones = true;
            }
        }

        System.out.println("Es hora de elegir el vehiculo de carrera de tu compa?ero de equipo.");
        System.out.println("?Comencemos!");
        System.out.println("\n");
        System.out.println("Elige tu vehiculo de carrera, escribe un numero de acuerdo a la opcion que quieras.");
        // Imprimir vehiculos
        tablaVehiculos(Equipo.equipoElegido.getVehiculosDisponibles());
        n = sc.nextInt();
        validaciones = false;
        while (!validaciones) {
            if (n < 1 || n > Equipo.equipoElegido.getVehiculosDisponibles().size()) {
                System.out.println("Por favor, escribe un numero del 1 al " + Equipo.equipoElegido.getVehiculosDisponibles().size() + ".");
                n = sc.nextInt(); // Para que no se quede en un loop infinito xd
            } else {
                Vehiculo vehiculo = Equipo.equipoElegido.getVehiculosDisponibles().get(n - 1);
                vehiculo.comprar(Equipo.equipoElegido.getPiloto2());
                System.out.println("?Veh?culo elegido!");
                System.out.println("\n");
                validaciones = true;
            }
        }

        // elegir vehiculos de los otros equipos
        for (Equipo equipo : Equipo.equipos) {
            if (equipo != Equipo.equipoElegido) {
                n = rand.nextInt(equipo.getVehiculosDisponibles().size()) + 1;
                Vehiculo vehiculo = equipo.getVehiculosDisponibles().get(n - 1);
                vehiculo.comprar(equipo.getPiloto1());
                Carrera.agregarVehiculoCarrerra(VehiculoCarrera.vehiculoElegido);
                n = rand.nextInt(equipo.getVehiculosDisponibles().size()) + 1;
                vehiculo = equipo.getVehiculosDisponibles().get(n - 1);
                vehiculo.comprar(equipo.getPiloto2());
                Carrera.agregarVehiculoCarrerra(VehiculoCarrera.vehiculoElegido);
            }
        }

        // Shuffle posiciones de los vehiculos
        ArrayList<VehiculoCarrera> vehiculosCarrera = Carrera.posiciones;
        Collections.shuffle(vehiculosCarrera);
        Carrera.posiciones = vehiculosCarrera;
        // Vehiculo de carrera del usuario
        VehiculoCarrera.vehiculoElegido = vehiculo1;

        for (Carrera carrera : Campeonato.campeonatoElegido.getListaCarreras()) {
            Carrera.comenzarCarrera(carrera);
            //Falta un dia para la carrera
            Boolean comenzar = false;
            while (!comenzar) {
                System.out.println("Falta un d?a para la carrera en " + carrera.getCiudad().getNombre() + ".");
                System.out.println("Todavia estas a tiempo de: ");
                System.out.println("1. Revisar el calendario de carreras.");
                System.out.println("2. Revisar tu vehiculo de carrera.");
                System.out.println("3. Cultivar una amistad con el director de carrera y obtener favores especiales.");
                System.out.println("4. Quiero comenzar la carrera, estoy listo.");

                n = sc.nextInt();
                System.out.println("\n");
                switch (n) {
                    case 1:
                        tablaCarreras(Campeonato.campeonatoElegido);
                        break;
                    case 2:
                        //Tunear el carro
                        tunearCarro(VehiculoCarrera.vehiculoElegido);
                        break;
                    case 3:
                        if (Piloto.pilotoElegido.getEquipo().getPlata() < 1000) {
                            System.out.println("No estas a la altura del Director de Carrera");
                            System.out.println("\n");
                            break;
                        } else {
                            System.out.println("El Director de Carrera te ha invitado a su casa");
                            System.out.println("\n");
                            corrupcion(carrera);
                            break;
                        }
                        // Corrupcion
                        break;
                    case 4:
                        comenzar = true;
                        simularCarrera(carrera);
                        break;
                }
            }
        }
    }

    public static void corrupcion(Carrera carrera) {
        System.out.println("No puedes llegar a donde el Director de Carrera sin un regalo");
        System.out.println("Escribe tu presupuesto para el \"regalo\" del Director de Carrera");
        Scanner sc = new Scanner(System.in);
        boolean validaciones = false;
        while (!validaciones) {
            double presupuesto = sc.nextDouble();
            if (presupuesto > Equipo.equipoElegido.getPlata()) {
                System.out.println("No tienes suficiente dinero para sobornar al Director de Carrera");
            } else if (presupuesto < 0) {
                System.out.println("No puedes darle un regalo negativo al Director de Carrera");
            } else if (presupuesto == 0) {
                System.out.println("No puedes darle un regalo de 0 al Director de Carrera");
            }else {
                validaciones = true;
                System.out.println("El Director de Carrera acepta tu regalo");
                Equipo.equipoElegido.setPlata(Equipo.equipoElegido.getPlata() - presupuesto);
                carrera.getDirectorCarrera().setPlata(carrera.getDirectorCarrera().getPlata());
                System.out.println("El Director ha decidido invitarte a una reunion privada y exclusiva");
                sitAndTalk();
            }
        }

    }
    public static void negociar() {
        boolean validaciones;
        Scanner sc = new Scanner(System.in);
        System.out.println("Puedes realizar negociaciones con patrocinadores para obtener financiamiento.");
        // imprimir patrocinadores con el dinero que estan dispuestos a dar
        //System.out.println(Patrocinador.mostrarPatrocinadores());

        String ans = "S";
/*        Descomentar
        validaciones = false;*/
        validaciones = false;
        int n;


        while (!validaciones) {
            if (ans.equals("S")) {
                // Si es S, volver al paso 6
                System.out.println("Mira la lista de patrocinadores disponibles:");
                // imprimir patrocinadores con el dinero que estan dispuestos a dar
                //System.out.println(Patrocinador.mostrarPatrocinadores());
                System.out.println("Escoge un patrocinador para negociar, escribe un numero del 1 al 10.");
                boolean validaciones2 = false;
                n = sc.nextInt();
                // Validar que sea un numero del 1 al 10
                while (!validaciones2) {
                    if (n < 1 || n > 10) {
                        // Si no es del 1 al 10, imprimir el mensaje de error
                        System.out.println("Por favor, escribe un numero del 1 al 10.");
                        n = sc.nextInt(); // Para que no se quede en un loop infinito xd
                    } else {
                        // Si es del 1 al 10, imprimir el mensaje de exito
                        Patrocinador patrocinador = Patrocinador.listaPatrocinadores.get(n - 1);
                        System.out.println("?Patrocinador elegido!");
                        System.out.println("\n");
                        System.out.println("Decide cu?nto dinero quieres pedirle:");
                        double cantidad = sc.nextDouble();
                        boolean validaciones3 = false;
                        while (!validaciones3) {
                            if (cantidad < 0) {
                                System.out.println("Esa es una cantidad de dinero negativa. ?Acaso piensas en patrocinar al patrocinador?");
                                System.out.println("Estas haciendo al patrocinador perder su tiempo y se ha ido. \n?No te preocupes, puedes intentarlo de nuevo!");
                                validaciones3 = true;
                            } else if (cantidad == 0) {
                                System.out.println("?Por qu? 0? ?Es que no quieres dinero?");
                                System.out.println("Estas haciendo al patrocinador perder su tiempo y se ha ido. \n?No te preocupes, puedes intentarlo de nuevo!");
                                validaciones3 = true;
                            } else if (cantidad > patrocinador.getDinero()) {
                                patrocinador.setPatrocinando(true);
                                System.out.println("?Eso es m?s dinero del que puede dar! \n!Has asustado al patrocinador y nunca lo olvidara!");
                                validaciones3 = true;
                            } else {
                                double aux = Equipo.equipoElegido.getPlata();
                                Equipo.equipoElegido.negociar(cantidad, patrocinador);
                                System.out.println("Se intent? negociar con " + patrocinador.getNombre() + " por " + cantidad + " d?lares.");
                                if (aux == Equipo.equipoElegido.getPlata()) {
                                    System.out.println("El patrocinador no acepto.");
                                } else {
                                    System.out.println(Equipo.equipoElegido.getNombre() + " fue patrocinado y ahora tiene " + Equipo.equipoElegido.getPlata() + " d?lares.");
                                }
                                System.out.println("\n");
                                validaciones3 = true;
                            }
                        }
                        validaciones2 = true; // Si es del 1 al 10, cambiar validaciones a true
                    }
                }
                ans = sc.nextLine(); // Para que no se quede en un loop infinito xd
            } else if (ans.equals("N")) {
                // Si es N, continuar
                System.out.println("\n");
                validaciones = true;
            } else {
                // Si no es S o N, imprimir el mensaje de error
                System.out.println("?Quieres negociar con otro patrocinador?, escribe S o N.");
                ans = sc.nextLine(); // Para que no se quede en un loop infinito xd
            }
        }
    }

    public static void tunearCarro(VehiculoCarrera vehiculoC) {
        Scanner sc = new Scanner(System.in);
        Equipo equipo = Equipo.equipoElegido;
        Vehiculo vehiculo = VehiculoCarrera.vehiculoElegido;
        System.out.println("Es hora de tunear tu vehiculo de carrera!");
        System.out.println("Comencemos!");
        System.out.println("\n");

        System.out.println("Actualmente tu equipo dispone de un presupuesto de " + equipo.getPlata() + " d?lares.");
        System.out.println("\n");
        System.out.println("?Te gustaria obtener mas dinero para tunear tu vehiculo de carrera? Escribe S o N.");
        String ans = sc.nextLine();
        boolean validaciones = false;

        while (!validaciones) {
            if (ans.equals("S")) {
                negociar();
            } else if (ans.equals("N")) {
                System.out.println("Genial! Comencemos a tunear tu vehiculo de carrera!");
                System.out.println("\n");
                validaciones = true;
            } else {
                System.out.println("Quieres obtener mas dinero para tunear tu vehiculo de carrera? Escribe S o N.");
                ans = sc.nextLine(); // Para que no se quede en un loop infinito xd
            }
        }

        // imprimir stats del carro
        System.out.println("Estos son los stats de tu vehiculo de carrera:");
        bigCar();

        System.out.println("\n");
        boolean salir = false;

        while (!salir) {
            System.out.println("Escoge una opcion para tunear tu vehiculo de carrera");
            System.out.println("1. Arreglar una parte del carro");
            System.out.println("2. Comparar una parte del carro");
            System.out.println("3. Volver al menu principal");
            System.out.println("\n");
            int n = sc.nextInt();
            double plata = equipo.getPlata();

            switch (n) {
                case 1: // Arreglar una parte del carro
                    boolean salir1 = false;
                    while (!salir1) {
                        System.out.println("Escoge una parte del carro para arreglar");
                        System.out.println("1. Motor: " + vehiculo.getMotor().getNombre() + " " + vehiculo.getMotor().getPrecio() + "$");
                        System.out.println("2. Neumaticos: " + vehiculo.getNeumaticos().getNombre() + " " + vehiculo.getNeumaticos().getPrecio() + "$");
                        System.out.println("3. Aleron " + vehiculo.getAleron().getNombre() + " " + vehiculo.getAleron().getPrecio() + "$");
                        System.out.println("4. Arreglar el carro : 1000$");
                        System.out.println("5. Llenar de Gasolina");
                        System.out.println("6. Volver al menu principal");
                        System.out.println("\n");

                        int m = sc.nextInt();

                        switch (m) {
                            case 1: // Arreglar el motor
                                if (plata >= vehiculoC.getMotor().getPrecio()) {
                                    vehiculoC.getMotor().comprar(vehiculoC);
                                    System.out.println("Motor arreglado!");
                                } else {
                                    System.out.println("No tienes suficiente dinero para arreglar el motor");
                                }
                                break;
                            case 2: // Arreglar los neumaticos
                                if (plata >= vehiculoC.getNeumaticos().getPrecio()) {
                                    vehiculoC.getNeumaticos().comprar(vehiculoC);
                                    System.out.println("Neumaticos arreglados!");
                                } else {
                                    System.out.println("No tienes suficiente dinero para arreglar los neumaticos");
                                }
                                break;
                            case 3: // Arreglar el aleron
                                if (plata >= vehiculoC.getAleron().getPrecio()) {
                                    vehiculoC.getAleron().comprar(vehiculoC);
                                    System.out.println("Aleron arreglado!");
                                } else {
                                    System.out.println("No tienes suficiente dinero para arreglar el aleron");
                                }
                                break;
                            case 4: // Arreglar el carro
                                if (plata >= 1000) {
                                    vehiculoC.repararVehiculo();
                                    System.out.println("Carro arreglado!");
                                } else {
                                    System.out.println("No tienes suficiente dinero para arreglar el carro");
                                }
                                break;
                            case 5: // Llenar de gasolina
                                vehiculoC.llenarGasolina();
                                System.out.println("Gasolina llenada!");
                                break;
                            case 6: // Volver al menu principal
                                salir1 = true;
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean salir2 = false;
                    while (!salir2) {
                        System.out.println("Bienvenido a la tienda!");
                        System.out.println("Estos son las piezas de carro disponibles:");
                        tablaPiezas(Pieza.getPiezas());
                        System.out.println("Escoge una pieza para comparar");
                        System.out.println("1. Motor");
                        System.out.println("2. Neumaticos");
                        System.out.println("3. Aleron");
                        System.out.println("4. Volver al menu principal");
                        System.out.println("\n");

                        int o = sc.nextInt();
                        ArrayList<Pieza> motores = new ArrayList<>(); // Piezas de tipo motor
                        for (Pieza pieza : Pieza.getPiezas()) {
                            if ("M".equals(pieza.getTipo())) {
                                motores.add(pieza);
                            }
                        }
                        ArrayList<Pieza> neumaticos = new ArrayList<>(); // Piezas de tipo neumaticos
                        for (Pieza pieza : Pieza.getPiezas()) {
                            if ("N".equals(pieza.getTipo())) {
                                motores.add(pieza);
                            }
                        }
                        ArrayList<Pieza> aleron = new ArrayList<>(); // Piezas de tipo aleron
                        for (Pieza pieza : Pieza.getPiezas()) {
                            if ("A".equals(pieza.getTipo())) {
                                motores.add(pieza);
                            }
                        }
                        switch (o) {
                            case 1:
                                System.out.println("Estos son los motores disponibles:");
                                tablaPiezas(motores);
                                System.out.println("Escoge un motor para comparar ");
                                int p = sc.nextInt();
                                Pieza pieza = motores.get(p - 1);
                                System.out.println("1. Comprar");
                                System.out.println("2. Volver al menu principal");
                                int q = sc.nextInt();
                                switch (q) {
                                    case 1:
                                        if (plata >= pieza.getPrecio()) {
                                            pieza.comprar(vehiculoC);
                                            System.out.println("Motor comprado!");
                                        } else {
                                            System.out.println("No tienes suficiente dinero para comprar el motor");
                                        }
                                        break;
                                    case 2:

                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Estos son los neumaticos disponibles:");
                                tablaPiezas(neumaticos);
                                System.out.println("Escoge unos neumaticos para comparar");
                                p = sc.nextInt();
                                pieza = neumaticos.get(p - 1);
                                System.out.println("1. Comprar");
                                System.out.println("2. Volver al menu principal");
                                q = sc.nextInt();
                                switch (q) {
                                    case 1:
                                        if (plata >= pieza.getPrecio()) {
                                            pieza.comprar(vehiculoC);
                                            System.out.println("Neumaticos comprados!");
                                        } else {
                                            System.out.println("No tienes suficiente dinero para comprar los neumaticos");
                                        }
                                        break;
                                    case 2:

                                        break;
                                }
                                break;
                            case 3:
                                System.out.println("Estos son los alerones disponibles:");
                                tablaPiezas(neumaticos);
                                System.out.println("Escoge un aleron para comparar");
                                p = sc.nextInt();
                                pieza = neumaticos.get(p - 1);
                                System.out.println("1. Comprar");
                                System.out.println("2. Volver al menu principal");
                                q = sc.nextInt();
                                switch (q) {
                                    case 1:
                                        if (plata >= pieza.getPrecio()) {
                                            pieza.comprar(vehiculoC);
                                            System.out.println("Aleron comprado!");
                                        } else {
                                            System.out.println("No tienes suficiente dinero para comprar el aleron");
                                        }
                                        break;
                                    case 2:

                                        break;
                                }
                                break;
                            case 4:
                                salir2 = true;
                                break;
                        }
                    }
                    break;
                case 3:
                    salir = true;
                    break;

            }
        }
    }

    public static void resetearCondicionesCarrera() { //Resetea las condiciones de la carrera
        //Shuffle de las posiciones
        ArrayList<VehiculoCarrera> nuevasPosiciones = Carrera.terminados;
        Collections.shuffle(nuevasPosiciones);
        Carrera.posiciones = nuevasPosiciones;
        //Colocando cada uno de los atributos en sus puntos iniciales
        for (VehiculoCarrera vehiculo : Carrera.posiciones) {
            vehiculo.setVelocidadActual(vehiculo.getVelocidadTuneao());
            vehiculo.setTerminado(false);
            vehiculo.setMorido(false);
            vehiculo.setTiempo(0.0);
            vehiculo.setDistanciaRecorrida(0.0);
        }
    }

    public static void simularCarrera(Carrera carrera) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int n;
        System.out.println("Ha comenzado el " + carrera.getNombreCircuito() + "!");
        double probOpciones = 0.0; //Probabilidad que se muestren las opciones para el usuario
        while (!Carrera.actualizarTerminado()) { //Mientras no todos esten terminados
            Carrera.actualizarGasolina();
            Carrera.actualizarPosiciones();
            if (rand.nextDouble() > 1 - probOpciones && !VehiculoCarrera.vehiculoElegido.isMorido()) {
                //TODO: Imprimir tabla de posiciones y de terminados
                tablaPosiciones(Carrera.posiciones);
                tablaStatsActuales(VehiculoCarrera.vehiculoElegido);
                ArrayList<Boolean> opcionesMostrar = Carrera.actualizarOpciones();
                for (int i = 0; i < 5; i++) {
                    if (opcionesMostrar.get(i)) {
                        switch (i) {
                            case 0:
                                System.out.println("1. Aprovechar el DRS.");
                                break;
                            case 1:
                                System.out.println("2. FRENA POR FAVOR TODOVAMUYRAPIDO (Debes frenar si deseas entrar a Pits).");
                                break;
                            case 2:
                                System.out.println("3. Hacer Ultra-Mega-Super-Maniobra");
                                break;
                            case 3:
                                System.out.println("4. Defender la posicion.");
                                break;
                            case 4:
                                System.out.println("5. ?Tokyo Drift!");
                                break;
                        }
                    }
                }
                if (VehiculoCarrera.vehiculoElegido.getVelocidadActual() < 100) {
                    System.out.println("6. ?Realizar Pit Stop!");
                }
                n = sc.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("?Aprovechas el DRS!");
                        VehiculoCarrera.vehiculoElegido.aprovecharDRS();
                        break;
                    case 2:
                        System.out.println("?Frenaste!");
                        VehiculoCarrera.vehiculoElegido.frenar();
                        break;
                    case 3:
                        System.out.println("Realizas una Ultra-Mega-Super-Maniobra!!!");
                        VehiculoCarrera.vehiculoElegido.hacerManiobra();
                        break;
                    case 4:
                        System.out.println("Defiendes tu posicion");
                        VehiculoCarrera.vehiculoElegido.defender();
                        break;
                    case 5:
                        System.out.println("Derrapas!");
                        VehiculoCarrera.vehiculoElegido.derrapar();
                        break;
                    case 6:
                        System.out.println("Entras a Pit Stop!");
                        //TODO: HACER PITSTOP
                        break;
                }
                probOpciones = 0.0;
            } else {
                probOpciones += 0.2;
            }
        }
        System.out.println("Ha terminado el " + carrera.getNombreCircuito() + "!");
        System.out.println("Los resultados de la carrera han quedado as?!");
        //TODO: Imprimir tabla de terminados
        tablaPosicionesTiempos(Carrera.terminados);
        //Impresion temporal de resultados
       /* int m = 1;
        System.out.println("+------------+----------------+------------+");
        System.out.println("|   Equipo   |    Posicion    |   Tiempo   |");
        System.out.println("+------------+----------------+------------+");
        for (VehiculoCarrera vehiculo : Carrera.terminados) {
            System.out.println("|   " + vehiculo.getPiloto().getEquipo() + "   |    " + m + "    |   " + vehiculo.getTiempo() + "s   |");
            m++;
        }
        System.out.println("+------------+----------------+------------+");*/
        Carrera.premiarCarrera();

        //TODO: Imprimir tabla de los puntos de los equipos
        //Una vez terminada toda la carrera, se deben resetear todas las cosas.
        MainUI.resetearCondicionesCarrera();
    }


}
