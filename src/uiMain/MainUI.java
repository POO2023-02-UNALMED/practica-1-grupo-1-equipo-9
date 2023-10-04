package uiMain;

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
}
