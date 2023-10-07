package uiMain;

import gestorAplicacion.*;
import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;
import java.util.*;
import uiMain.Tablas;
import uiMain.AsciiArt.*;

public interface Tablas {
    // Aqui es para poner el codigo de las tablas


    public static void tablaCampeonatos(ArrayList<Campeonato> campeonatos) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;
        for (Campeonato campeonato : campeonatos) {
            int nombre = campeonato.getNombre().length();
            int opcion = String.valueOf(campeonato.getId()).length();
            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   CAMPEONATOS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-"+maxNombre+"s | %-"+10+"s |\n", "NOMBRE", "OPCION");
        System.out.println("-".repeat(tablaAncho));

        for (Campeonato campeonato : campeonatos) {
            System.out.printf("| %-"+maxNombre+"s | %-"+10+"s |\n", campeonato.getNombre(), campeonato.getId());
        }

        System.out.println("-".repeat(tablaAncho));
    }
    
    // tablas para equipos
    public static void tablaEquipos(ArrayList<Equipo> equipos) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;
        int maxPais = 0;
        for (Equipo equipo : equipos) {
            int nombre = equipo.getNombre().length();
            int pais = equipo.getPais().length();
            int opcion = String.valueOf(equipo.getId()).length();
            maxPais = Math.max(maxPais, pais);
            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7 + maxPais; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   EQUIPOS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-"+maxNombre+"s | %-"+maxPais+"s | %-7s |\n", "NOMBRE", "PAIS","OPCION");
        System.out.println("-".repeat(tablaAncho));

        for (Equipo equipo : equipos) {
            System.out.printf("| %-"+maxNombre+"s | %-"+maxPais+"s | %-7s |\n", equipo.getNombre(),equipo.getPais(), equipo.getId());
        }

        System.out.println("-".repeat(tablaAncho));
    }
    
    
    //tabla para directores de carrera
    public static void tablaDirectoresCarrera(ArrayList<DirectorCarrera> listaDirectores) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;
        int maxPais = 0;
        for (DirectorCarrera directorCarrera : listaDirectores) {
            int nombre = directorCarrera.getNombre().length();
            int pais = directorCarrera.getPais().length();
            int opcion = String.valueOf(directorCarrera.getId()).length();
            maxPais = Math.max(maxPais, pais);
            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7 + maxPais; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   DIRECTORES", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-"+maxNombre+"s | %-"+maxPais+"s | %-"+7+"s |\n ", "NOMBRE", "PAIS","OPCION");
        System.out.println("-".repeat(tablaAncho));

        for (DirectorCarrera directorCarrera : listaDirectores) {
            System.out.printf("| %-"+maxNombre+"s | %-"+maxPais+"s | %-"+7+"s |\n", directorCarrera.getNombre(),directorCarrera.getPais(), directorCarrera.getId());
        }

        System.out.println("-".repeat(tablaAncho));
    }
    
    //tabla para patrocinadores
    public static void tablaPatrocinadores(ArrayList<Patrocinador> listaPatrocinadores) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;
        
        for (Patrocinador patrocinador : listaPatrocinadores) {
            int nombre = patrocinador.getNombre().length();
            double dinero = patrocinador.getDinero();
            int opcion = String.valueOf(patrocinador.getId()).length();
            
            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7 +18; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   DIRECTORES", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-"+maxNombre+"s | %-"+18+"s | %-"+7+"s |\n ", "NOMBRE", "DINERO DISPONIBLE","OPCION");
        System.out.println("-".repeat(tablaAncho));

        for (Patrocinador patrocinador : listaPatrocinadores) {
            System.out.printf("| %-"+maxNombre+"s | %-"+18+"s | %-"+7+"s |\n", patrocinador.getNombre(),patrocinador.getDinero()+"$", patrocinador.getId());
        }

        System.out.println("-".repeat(tablaAncho));
    }
    
    //tabla para piezas
    public static void tablaPiezas(ArrayList<Pieza> piezas) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;
        
        for (Pieza pieza : piezas) {
            int nombre = pieza.getNombre().length();
            double precio = pieza.getPrecio();
            double maniobrabilidad = pieza.getManiobrabilidadAnadida();
            int opcion = String.valueOf(pieza.getId()).length();
            
            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16 + 10 +7; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   PIEZAS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s |%-"+7+"s |\n ", "NOMBRE", "MANIOBRABILIDAD","PRECIO","OPCION");
        System.out.println("-".repeat(tablaAncho));

        for (Pieza pieza : piezas) {
            System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s | %-"+7+"s|\n", pieza.getNombre(),pieza.getManiobrabilidadAnadida(), pieza.getPrecio() , pieza.getId());
        }

        System.out.println("-".repeat(tablaAncho));
    }
    



}
