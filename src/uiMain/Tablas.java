package uiMain;

import gestorAplicacion.campeonato.Ciudad;
import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;
import java.util.*;
import uiMain.Tablas;
import uiMain.AsciiArt.*;

public interface Tablas {
    // Aqui es para poner el codigo de las tablas

    public static void tablaCampeonatos(ArrayList<Campeonato> campeonatos) {
        // Obtener la longitud máxima de las cadenas en las columnas
        int maxNombre = 0;
        for (Campeonato campeonato : campeonatos) {
            int nombre = campeonato.getNombre().length();
            int opcion = String.valueOf(campeonato.getId()).length();
            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7; // 7 para los espacios y los bordes

        // Imprimir la tabla con el título centrado
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



}
