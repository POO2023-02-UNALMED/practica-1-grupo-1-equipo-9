package uiMain;

import gestorAplicacion.campeonato.Ciudad;
import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;


import java.util.Scanner;

public class MainUI {
    public static void main(String[] args) {
        // Variables Necesarias
        Scanner sc = new Scanner(System.in);

        // Mensaje de bienvenida
        System.out.println("¡Bienvenido al Proyecto de la Fédération Internationale de l'Automobile!");
        System.out.println("\n");


        // Mensaje de introduccion
        System.out.println("¡Hola! En este juego, serás un piloto de un equipo de carreras de Fórmula 1.");
        System.out.println("Tu objetivo es ganar el campeonato de carreras, para ello, deberás competir en carreras y obtener puntos.");
        System.out.println("¡Buena suerte!");
        System.out.println("\n");

        System.out.println("Primero debes preparar el campeonato en el que competirás.");
        System.out.println("¡Comencemos!");
        System.out.println("\n");
        System.out.println("\n");

        // FUNCIONALIDAD PREPARAR CAMPEONATO
        // Pasos para Preparar el Campeonato
        System.out.println("Preparar el Campeonato");
        System.out.println("\n");
        // Paso 1: Escoge un Campeonato
        System.out.println("Escoge un Campeonato");
        // Llamar las tablas

        boolean validaciones = false;

        while (validaciones == false) {
            System.out.println("Elige uno de los 5 campeonatos, escribe un numero del 1 al 5.");
            int n = sc.nextInt();
            // Validar que el numero sea del 1 al 5
            if (n < 1 || n > 5) {
                // Si no es del 1 al 5, imprimir el mensaje de error
                System.out.println("Por favor, escribe un numero del 1 al 5.");
            } else {
                // Si es del 1 al 5, imprimir el mensaje de exito
                // Si es del 1 al 5, cambiar validaciones a true

                System.out.println("¡Campeonato elegido!");
                validaciones = true;
            }
        }

        // Paso 2: Elige el Año
        System.out.println("Elige el Año");
        System.out.println("Indica el año en el que quieres que se celebre el campeonato.");

        System.out.println("¡Tu campeonato quedo configurado!");
        // imprmir como se ve con tablitas


        // Paso 3: Selecciona tu Equipo
        System.out.println("Selecciona tu Escudería");
        // imprimir equipos
        System.out.println("Escoge una escudería para competir en el campeonato, escribe un numero del 1 al 10.");


        // Paso 4: Mira los Pilotos de tu Equipo
        System.out.println("Mira los Pilotos de tu Escuderia");
        // imprimir pilotos con stats

        // Paso 5: Escoge tus Pilotos
        System.out.println("Escoge tu Piloto");


        System.out.println("Escoge tu compañero de equipo");

        // Paso 6: Negocia con Patrocinadores
        System.out.println("Actualmente, tu equipo no tiene dinero :(.");
        System.out.println("Si deseas, puedes realizar negociaciones con patrocinadores para obtener financiamiento.");
        System.out.println("Mira la lista de patrocinadores disponibles:");
        // imprimir patrocinadores con el dinero que estan dispuestos a dar

        System.out.println("Escoge un patrocinador para negociar, escribe un numero del 1 al 10.");

        System.out.println("Decide cuánto dinero quieres pedirle:");


        // Paso 7: Verifica tu Dinero
        System.out.println("Ahora, tu equipo tiene: " + "Dolares");
        System.out.println("¿Quieres negociar con otro patrocinador? (S/N)");

        System.out.println("Comprueba la cantidad de dinero que has recibido de los patrocinadores.");

        // Mensaje de despedida
        System.out.println("¡Listo! Ahora estás preparado para comenzar tu emocionante campeonato de carreras. ¡Diviértete!");
    }

    static {
        // Podemos crear aqui los objetos para los tests
        // Campeonatos
        Campeonato campeonatoEuropa = new Campeonato("Campeonato Europa", 2023, Ciudad.Continente.Europa, 5);
        Campeonato campeonatoAsia = new Campeonato("Campeonato Asia", 2023, Ciudad.Continente.Asia, 4);
        Campeonato campeonatoAmerica = new Campeonato("Campeonato América", 2023, Ciudad.Continente.America, 6);
        Campeonato campeonatoAfrica = new Campeonato("Campeonato África", 2023, Ciudad.Continente.Africa, 3);
        Campeonato campeonatoOceania = new Campeonato("Campeonato Oceanía", 2023, Ciudad.Continente.Oceania, 2);

        // Ciudades y Carreras
        Ciudad ciudad1 = new Ciudad("Montecarlo", Ciudad.Continente.Europa);
        Carrera carrera1 = new Carrera("Gran Premio de Mónaco", 260.0, 1000000.0, ciudad1, 4.2);
        Ciudad ciudad2 = new Ciudad("Monza", Ciudad.Continente.Europa);
        Carrera carrera2 = new Carrera("Gran Premio de Italia", 306.0, 900000.0, ciudad2, 3.8);
        Ciudad ciudad3 = new Ciudad("Silverstone", Ciudad.Continente.Europa);
        Carrera carrera3 = new Carrera("Gran Premio de Gran Bretaña", 308.0, 950000.0, ciudad3, 4.0);
        Ciudad ciudad4 = new Ciudad("Baku", Ciudad.Continente.Europa);
        Carrera carrera4 = new Carrera("Gran Premio de Azerbaiyán", 306.0, 900000.0, ciudad4, 3.8);
        Ciudad ciudad5 = new Ciudad("Barcelona", Ciudad.Continente.Europa);
        Carrera carrera5 = new Carrera("Gran Premio de España", 308.0, 950000.0, ciudad5, 4.0);
        Ciudad ciudad6 = new Ciudad("Shanghái", Ciudad.Continente.Asia);
        Carrera carrera6 = new Carrera("Gran Premio de China", 305.0, 900000.0, ciudad6, 3.8);
        Ciudad ciudad7 = new Ciudad("Sakhir", Ciudad.Continente.Asia);
        Carrera carrera7 = new Carrera("Gran Premio de Baréin", 308.0, 950000.0, ciudad7, 4.0);
        Ciudad ciudad8 = new Ciudad("Singapur", Ciudad.Continente.Asia);
        Carrera carrera8 = new Carrera("Gran Premio de Singapur", 305.0, 900000.0, ciudad8, 3.8);
        Ciudad ciudad9 = new Ciudad("Yeda", Ciudad.Continente.Asia);
        Carrera carrera9 = new Carrera("Gran Premio de Arabia Saudita", 308.0, 950000.0, ciudad9, 4.0);
        Ciudad ciudad10 = new Ciudad("Austin", Ciudad.Continente.America);
        Carrera carrera10 = new Carrera("Gran Premio de Estados Unidos", 305.0, 900000.0, ciudad10, 3.8);
        Ciudad ciudad11 = new Ciudad("Monterrey", Ciudad.Continente.America);
        Carrera carrera11 = new Carrera("Gran Premio de México", 308.0, 950000.0, ciudad11, 4.0);
        Ciudad ciudad12 = new Ciudad("Sao Paulo", Ciudad.Continente.America);
        Carrera carrera12 = new Carrera("Gran Premio de Brasil", 305.0, 900000.0, ciudad12, 3.8);
        Ciudad ciudad13 = new Ciudad("Buenos Aires", Ciudad.Continente.America);
        Carrera carrera13 = new Carrera("Gran Premio de Argentina", 308.0, 950000.0, ciudad13, 4.0);
        Ciudad ciudad14 = new Ciudad("Ciudad del Cabo", Ciudad.Continente.Africa);
        Carrera carrera14 = new Carrera("Gran Premio de Sudáfrica", 305.0, 900000.0, ciudad14, 3.8);
        Ciudad ciudad15 = new Ciudad("El Cairo", Ciudad.Continente.Africa);
        Carrera carrera15 = new Carrera("Gran Premio de Egipto", 308.0, 950000.0, ciudad15, 4.0);
        Ciudad ciudad16 = new Ciudad("Nairobi", Ciudad.Continente.Africa);
        Carrera carrera16 = new Carrera("Gran Premio de Kenia", 305.0, 900000.0, ciudad16, 3.8);
        Ciudad ciudad17 = new Ciudad("Melbourne", Ciudad.Continente.Oceania);
        Carrera carrera17 = new Carrera("Gran Premio de Australia", 308.0, 950000.0, ciudad17, 4.0);
        Ciudad ciudad18 = new Ciudad("Auckland", Ciudad.Continente.Oceania);
        Carrera carrera18 = new Carrera("Gran Premio de Nueva Zelanda", 305.0, 900000.0, ciudad18, 3.8);
        Ciudad ciudad19 = new Ciudad("Sídney", Ciudad.Continente.Oceania);
        Carrera carrera19 = new Carrera("Gran Premio de Australia", 308.0, 950000.0, ciudad19, 4.0);
        Ciudad ciudad20 = new Ciudad("Adelaida", Ciudad.Continente.Oceania);
        Carrera carrera20 = new Carrera("Gran Premio de Australia", 305.0, 900000.0, ciudad20, 3.8);

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
        Patrocinador patrocinador1 = new Patrocinador("Red Bull", 10000.0);
        Patrocinador patrocinador2 = new Patrocinador("Pirelli", 80000.0);
        Patrocinador patrocinador3 = new Patrocinador("Shell", 90000.0);
        Patrocinador patrocinador4 = new Patrocinador("MegaCorp", 10000.0);
        Patrocinador patrocinador5 = new Patrocinador("Stark Industries", 20000.0);
        Patrocinador patrocinador6 = new Patrocinador("Wayne Enterprises", 10000.0);
        Patrocinador patrocinador7 = new Patrocinador("Acme Corporation", 55000.0);
        Patrocinador patrocinador8 = new Patrocinador("Tech Innovations Ltd.", 30000.0);
        Patrocinador patrocinador9 = new Patrocinador("Global Motorsport Group", 75000.0);
        Patrocinador patrocinador10 = new Patrocinador("Puma", 15000.0);

        // Equipos
        Equipo equipo1 = new Equipo("Mercedes-AMG Petronas Formula One Team", "Alemania");
        Equipo equipo2 = new Equipo("Scuderia Ferrari", "Italia");
        Equipo equipo3 = new Equipo("Red Bull Racing", "Austria");
        Equipo equipo4 = new Equipo("McLaren Racing", "Reino Unido");
        Equipo equipo5 = new Equipo("Aston Martin Cognizant Formula One Team", "Reino Unido");
        Equipo equipo6 = new Equipo("Alpine F1 Team", "Francia");
        Equipo equipo7 = new Equipo("Williams Racing", "Reino Unido");
        Equipo equipo8 = new Equipo("Alfa Romeo Racing", "Suiza");
        Equipo equipo9 = new Equipo("Haas F1 Team", "Estados Unidos");
        Equipo equipo10 = new Equipo("Uralkali Haas F1 Team", "Estados Unidos");

        // Pilotos
        // Crea pilotos para cada equipo con habilidades entre 0 y 0.4
        Piloto piloto1Equipo1 = new Piloto("H. Ham", "GER", equipo1, Math.random() * 0.4);
        Piloto piloto2Equipo1 = new Piloto("V. Bot", "GER", equipo1, Math.random() * 0.4);
        Piloto piloto3Equipo1 = new Piloto("L. Ham", "GER", equipo1, Math.random() * 0.4);
        Piloto piloto4Equipo1 = new Piloto("N. Ros", "GER", equipo1, Math.random() * 0.4);
        Piloto piloto5Equipo1 = new Piloto("G. Rus", "GER", equipo1, Math.random() * 0.4);

        Piloto piloto1Equipo2 = new Piloto("C. Lec", "ITA", equipo2, Math.random() * 0.4);
        Piloto piloto2Equipo2 = new Piloto("C. San", "ITA", equipo2, Math.random() * 0.4);
        Piloto piloto3Equipo2 = new Piloto("M. Gat", "ITA", equipo2, Math.random() * 0.4);
        Piloto piloto4Equipo2 = new Piloto("C. Sci", "ITA", equipo2, Math.random() * 0.4);
        Piloto piloto5Equipo2 = new Piloto("L. Bin", "ITA", equipo2, Math.random() * 0.4);

        Piloto piloto1Equipo3 = new Piloto("M. Ver", "AUT", equipo3, Math.random() * 0.4);
        Piloto piloto2Equipo3 = new Piloto("S. Per", "AUT", equipo3, Math.random() * 0.4);
        Piloto piloto3Equipo3 = new Piloto("A. Alb", "AUT", equipo3, Math.random() * 0.4);
        Piloto piloto4Equipo3 = new Piloto("P. Gas", "AUT", equipo3, Math.random() * 0.4);
        Piloto piloto5Equipo3 = new Piloto("Y. Tsu", "AUT", equipo3, Math.random() * 0.4);

        Piloto piloto1Equipo4 = new Piloto("L. Nor", "GBR", equipo4, Math.random() * 0.4);
        Piloto piloto2Equipo4 = new Piloto("D. Ric", "AUS", equipo4, Math.random() * 0.4);
        Piloto piloto3Equipo4 = new Piloto("L. Sai", "ESP", equipo4, Math.random() * 0.4);
        Piloto piloto4Equipo4 = new Piloto("N. Yea", "GBR", equipo4, Math.random() * 0.4);
        Piloto piloto5Equipo4 = new Piloto("C. Nor", "GBR", equipo4, Math.random() * 0.4);

        Piloto piloto1Equipo5 = new Piloto("S. Vet", "DEU", equipo5, Math.random() * 0.4);
        Piloto piloto2Equipo5 = new Piloto("L. Str", "CAN", equipo5, Math.random() * 0.4);
        Piloto piloto3Equipo5 = new Piloto("F. Stt", "MEX", equipo5, Math.random() * 0.4);
        Piloto piloto4Equipo5 = new Piloto("G. ALO", "ESP", equipo5, Math.random() * 0.4);
        Piloto piloto5Equipo5 = new Piloto("Y. Tsu", "GBR", equipo5, Math.random() * 0.4);
    }
}
