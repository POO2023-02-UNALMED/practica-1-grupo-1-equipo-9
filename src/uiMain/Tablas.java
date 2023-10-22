package uiMain;

import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;
import gestorAplicacion.paddock.Patrocinador;
import gestorAplicacion.paddock.Pieza;
import gestorAplicacion.paddock.Piloto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import java.util.ArrayList;

public interface Tablas extends Decimales {
    // Aqui es para poner el codigo de las tablas

    static void tablaCampeonatos(ArrayList<Campeonato> campeonatos) {
        // Obtener la longitud maxima de las cadenas en las columnas

        int maxNombre = 0;
        for (Campeonato campeonato : campeonatos) {
            int nombre = campeonato.getNombre().length();
            int opcion = String.valueOf(campeonato.getId()).length();
            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "  CAMPEONATOS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + 10 + "s | %-" + maxNombre + "s |\n", "OPCION", "NOMBRE");
        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (Campeonato campeonato : campeonatos) {
            campeonato.redondear();
            System.out.printf("| %-" + 10 + "s | %-" + maxNombre + "s |\n", i, campeonato.getNombre());
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }

    // tablas para equipos
    static void tablaEquipos(ArrayList<Equipo> equipos) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;
        int maxPais = 0;
        for (Equipo equipo : equipos) {
            int nombre = equipo.getNombre().length();
            //int pais = equipo.getPais().length();
            int opcion = String.valueOf(equipo.getId()).length();
            //maxPais = Math.max(maxPais, pais);
            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7 + maxPais; // 7 para los espacios y los bordes

        // Imprimir la tabla con el titulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   EQUIPOS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));

        System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s | %-" + maxPais + "s |\n", "OPCION", "NOMBRE", "PAIS");


        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (Equipo equipo : equipos) {

            //System.out.printf("| %-"+7+"s | %-"+maxNombre+"s | %-"+maxPais+"s |\n",i ,equipo.getNombre(),equipo.getPais());
            System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s | %-" + maxPais + "s |\n", i, equipo.getNombre());
            i++;


        }

        System.out.println("-".repeat(tablaAncho));
    }

    static void tablaEquipos1(ArrayList<Equipo> equipos) {
        // Obtener la longitud máxima de las cadenas en las columnas
        int maxNombre = 0;
        for (Equipo equipo : equipos) {
            int nombre = equipo.getNombre().length();
            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7-3; // 7 para los espacios y los bordes

        // Imprimir la tabla con el título centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   EQUIPOS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));

        System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s |\n", "OPCION", "NOMBRE");

        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (Equipo equipo : equipos) {
            System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s |\n", i, equipo.getNombre());
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }


    //tabla para directores de carrera
    static void tablaDirectoresCarrera(ArrayList<DirectorCarrera> listaDirectores) {
        // Obtener la longitud maxima de las cadenas en las columnas
        int maxNombre = 1;
        int maxPais = 1;
        for (DirectorCarrera directorCarrera : listaDirectores) {
            directorCarrera.redondear();
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
        System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s | %-" + maxPais + "s |\n", "OPCION", "NOMBRE", "PAIS");
        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (DirectorCarrera directorCarrera : listaDirectores) {
            System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s | %-" + maxPais + "s |\n", i, directorCarrera.getNombre(), directorCarrera.getPais());
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }

    //tabla para patrocinadores
    static void tablaPatrocinadores(ArrayList<Patrocinador> listaPatrocinadores) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;

        for (Patrocinador patrocinador : listaPatrocinadores) {
            patrocinador.redondear();
            int nombre = patrocinador.getNombre().length();
            double dinero = patrocinador.getDineroOfrecer();
            int opcion = String.valueOf(patrocinador.getId()).length();

            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7 + 10 + 12; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   PATROCINADORES", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s | %-" + 22 + "s |\n", "OPCION", "NOMBRE", "DINERO");
        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (Patrocinador patrocinador : listaPatrocinadores) {
            System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s | %-" + 22 + "s |\n", i, patrocinador.getNombre(), String.format("%.0f", patrocinador.getPlata()) + "$", i);
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }

    //tabla para piezas
    static void tablaPiezas(ArrayList<Pieza> piezas) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;

        for (Pieza pieza : piezas) {
            pieza.redondear();
            int nombre = pieza.getNombre().length();
            double precio = pieza.getPrecio();
            double maniobrabilidad = pieza.getManiobrabilidadAnadida();
            int opcion = String.valueOf(pieza.getId()).length();

            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16 + 10 + 7 + 5 + 19+3; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   PIEZAS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("|%-" + 7 + "s | %-" + maxNombre + "s | %-" + 16 + "s | %-" + 10 + "s |%-" + 20 + "s |\n", "OPCION", "NOMBRE", "MANIOBRABILIDAD", "PRECIO", "VELOCIDAD ADICIONAL");
        System.out.println("-".repeat(tablaAncho));


        int i = 1;
        for (Pieza pieza : piezas) {
            System.out.printf("|%-" + 7 + "s | %-" + maxNombre + "s | %-" + 16 + "s | %-" + 10 + "s | %-" + 20 + "s|\n", i, pieza.getNombre(), "+" + pieza.getManiobrabilidadAnadida(), pieza.getPrecio() + "$", "+" + pieza.getVelocidadAnadida());
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }

    //tabla piezas contrabando
    static void tablaPiezasContrabando(ArrayList<Pieza> piezasContrabando) {
        // Obtener la longitud m�xima de las cadenas en las columnas
        int maxNombre = 0;

        for (Pieza piezaContrabando : piezasContrabando) {
            int nombre = piezaContrabando.getNombre().length();
            double precio = piezaContrabando.getPrecio();
            double maniobrabilidad = piezaContrabando.getManiobrabilidadAnadida();
            int opcion = String.valueOf(piezaContrabando.getId()).length();

            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16 + 10 + 7 + 5 + 19; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   PIEZAS CONTRABANDO", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("|%-" + 7 + "s | %-" + maxNombre + "s | %-" + 16 + "s | %-" + 10 + "s |%-" + 17 + "s |\n", "OPCION", "NOMBRE", "MANIOBRABILIDAD", "PRECIO", "VELOCIDAD AÑADIDA");
        System.out.println("-".repeat(tablaAncho));


        int i = 1;
        for (Pieza piezaContrabando : piezasContrabando) {
            System.out.printf("|%-" + 7 + "s | %-" + maxNombre + "s | %-" + 16 + "s | %-" + 10 + "s | %-" + 17 + "s|\n", i, piezaContrabando.getNombre(), "+" + piezaContrabando.getManiobrabilidadAnadida(), piezaContrabando.getPrecio() + "$", "+" + piezaContrabando.getVelocidadAnadida());
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }

    //tabla vehiculos
    /*public static void tablaVehiculos(ArrayList<Vehiculo> vehiculosDisponibles) {
        // Obtener la longitud m�xima de las cadenas en las columnas
        int maxNombre = 0;
        
        for (Vehiculo vehiculo : vehiculosDisponibles) {
            int nombre = vehiculo.getMarca().length() + vehiculo.getModelo().length() +2;
            double precio = vehiculo.getPrecioUtilizar();
            double velocidad = vehiculo.getVelocidad();
           // int opcion = String.valueOf(vehiculo.getId()).length();
            
            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16 + 10 + 7 + 5; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   VEHICULOS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("|%-"+7+"s | %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s |\n","OPCION" , "NOMBRE", "VELOCIDAD","PRECIO");
        System.out.println("-".repeat(tablaAncho));

        
        int i = 1;
        for (Vehiculo vehiculo : vehiculosDisponibles) {

        	
        	System.out.printf("|%-"+7+"s | %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s |\n", i, vehiculo.getMarca() +" "+ vehiculo.getModelo(), vehiculo.getVelocidad()+" Km/h", vehiculo.getPrecioUtilizar() + "$");
        	i++;
        	
        	
        	
        }

        System.out.println("-".repeat(tablaAncho));
    }
    */

    //tabla posiciones
    static void tablaPosiciones(ArrayList<VehiculoCarrera> posiciones) {
        // Obtener la longitud m�xima de las cadenas en las columnas
        int maxNombre = 0;

        for (VehiculoCarrera posicion : posiciones) {
            int nombre = posicion.getPiloto().getNombre().length();
            double distancia = posicion.getDistanciaRecorrida();
            double velocidad = posicion.getTiempo();


            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "TABLA DE POSICIONES", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + maxNombre + "s | %-" + 16 + "s |\n", "PILOTO", "    POSICION");
        System.out.println("-".repeat(tablaAncho));


        int i = 1;
        for (VehiculoCarrera posicion : posiciones) {


            System.out.printf("| %-" + maxNombre + "s | %-" + 16 + "s |\n", posicion.getPiloto().getNombre(), "       " + i);
            i++;


        }

        System.out.println("-".repeat(tablaAncho));
    }

    //tabla posiciones con tiempos
    static void tablaPosicionesTiempos(ArrayList<VehiculoCarrera> posiciones) {
        // Obtener la longitud m�xima de las cadenas en las columnas
        int maxNombre = 0;

        for (VehiculoCarrera posicion : posiciones) {
            int nombre = posicion.getPiloto().getNombre().length();
            double distancia = posicion.getDistanciaRecorrida();
            double velocidad = posicion.getTiempo();


            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16 + 19; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "TABLA DE TIEMPOS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + maxNombre + "s | %-" + 16 + "s | %-" + 16 + "s |\n", "PILOTO", "TIEMPO", "    POSICION");
        System.out.println("-".repeat(tablaAncho));


        int i = 1;
        for (VehiculoCarrera posicion : posiciones) {


            System.out.printf("| %-" + maxNombre + "s | %-" + 16 + "s | %-" + 16 + "s |\n", posicion.getPiloto().getNombre(), posicion.getTiempo(), "       " + i);
            i++;


        }

        System.out.println("-".repeat(tablaAncho));
    }


    //tabla carreras
    static void tablaCarreras(Campeonato campeonato) {
        // Obtener la longitud m�xima de las cadenas en las columnas
        int maxNombre = 0;

        for (Carrera carrera : campeonato.getListaCarreras()) {
            carrera.redondear();
            int nombre = carrera.getNombreCircuito().length();
            int ciudad = carrera.getCiudad().getNombre().length();
            double dificultad = carrera.getDificultad();


            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16 + 10 + 7 + 5 + 3; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "CALENDARIO DE CARRERAS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + maxNombre + "s | %-" + 16 + "s | %-" + 10 + "s |%-" + 7 + "s |\n", "CARRERA", "CIUDAD", "FECHA", "DIFICULTAD");
        System.out.println("-".repeat(tablaAncho));


        for (Carrera carrera : campeonato.getListaCarreras()) {


            System.out.printf("| %-" + maxNombre + "s | %-" + 16 + "s | %-" + 10 + "s | %-" + 10 + "s|\n", carrera.getNombreCircuito(), carrera.getCiudad().getNombre(), carrera.getFecha(), carrera.getDificultad());


        }

        System.out.println("-".repeat(tablaAncho));
    }

    static void tablaCarreras1(ArrayList<Carrera> carreras) {
        // Obtener la longitud m�xima de las cadenas en las columnas
        int maxNombre = 1;

        for (Carrera carrera : carreras) {
            int nombre = carrera.getNombreCircuito().length();
            int ciudad = carrera.getCiudad().getNombre().length();
            double dificultad = carrera.getDificultad();


            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16 + 10 + 7 + 5 + 3; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "CALENDARIO DE CARRERAS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + maxNombre + "s | %-" + 16 + "s | %-" + 10 + "s |%-" + 7 + "s |\n", "CARRERA", "CIUDAD", "FECHA", "DIFICULTAD");
        System.out.println("-".repeat(tablaAncho));


        for (Carrera carrera : carreras) {

            carrera.redondear();
            System.out.printf("| %-" + maxNombre + "s | %-" + 16 + "s | %-" + 10 + "s | %-" + 10 + "s|\n", carrera.getNombreCircuito(), carrera.getCiudad().getNombre(), carrera.getFecha(), carrera.getDificultad());


        }

        System.out.println("-".repeat(tablaAncho));
    }


    //tabla stats actuales
    static void tablaStatsActuales(VehiculoCarrera vehiculoElegido) {


        System.out.print("-------------------------------------\n");
        System.out.print("            STATS ACTUALES           \n");
        System.out.print("-------------------------------------\n");

        System.out.printf("| %-" + 15 + "s | %-" + 15 + "s |\n", "PILOTO", vehiculoElegido.getPiloto().getNombre());
        System.out.printf("| %-" + 15 + "s | %-" + 15 + "s |\n", "VELOCIDAD", vehiculoElegido.getVelocidadActual());
        System.out.printf("| %-" + 15 + "s | %-" + 15 + "s |\n", "GASOLINA", vehiculoElegido.getGasolina());
        if (vehiculoElegido.getAleron().isDanado()) {
            System.out.printf("| %-" + 15 + "s  | %-" + 15 + "s |\n", "ALERON", "DAÑADO");
        } else {
            System.out.printf("| %-" + 15 + "s | %-" + 15 + "s |\n", "ALERON", "OK");
        }
        if (vehiculoElegido.getMotor().isDanado()) {
            System.out.printf("| %-" + 15 + "s | %-" + 15 + "s |\n", "MOTOR", "DAÑADO");
        } else {
            System.out.printf("| %-" + 15 + "s | %-" + 15 + "s |\n", "MOTOR", "OK");
        }
        if (vehiculoElegido.getNeumaticos().isDanado()) {
            System.out.printf("| %-" + 15 + "s | %-" + 15 + "s |\n", "NEUMATICOS", "DAÑADOS");
        } else {
            System.out.printf("| %-" + 15 + "s | %-" + 15 + "s |\n", "NEUMATICOS", "OK");
        }
        System.out.print("-------------------------------------\n");


    }


    static void tablaContinentes() {
        // Obtener la longitud maxima de las cadenas en las columnas

        int maxNombre = 10;

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   CONTINENTES", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + 10 + "s | %-" + maxNombre + "s |\n", "OPCION", "NOMBRE");
        System.out.println("-".repeat(tablaAncho));

        String[] continentes = {"Africa", "America", "Asia", "Europa", "Oceania"};


        for (int i = 1; i < continentes.length + 1; i++) {
            System.out.printf("| %-" + 10 + "s | %-" + maxNombre + "s |\n", i, continentes[i - 1]);

        }

        System.out.println("-".repeat(tablaAncho));
    }


    static void tablaPilotosEquipo(ArrayList<Piloto> listaPilotosoEquipo) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;
        int maxEquipo = listaPilotosoEquipo.get(0).getEquipo().getNombre().toUpperCase().length();
        for (Piloto piloto : listaPilotosoEquipo) {
            piloto.redondear();
            int nombre = piloto.getNombre().length();
            double dinero = piloto.getPlata();
            int opcion = String.valueOf(piloto.getId()).length();

            maxNombre = Math.max(Math.max(maxNombre, nombre), maxEquipo);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7 + 10; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - maxEquipo) / 2) + "s%s%" + ((tablaAncho - maxEquipo) / 2) + "s", "", listaPilotosoEquipo.get(0).getEquipo().getNombre().toUpperCase(), "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s | %-" + 10 + "s |\n", "OPCION", "NOMBRE", "HABILIDAD");
        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (Piloto piloto : listaPilotosoEquipo) {
            System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s | %-" + 10 + "s |\n", i, piloto.getNombre(), piloto.getHabilidad());
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }

    static void tablaPilotosDesfavorecidos(ArrayList<Piloto> listaPilotosoEquipo) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;
        int maxEquipo = listaPilotosoEquipo.get(0).getEquipo().getNombre().toUpperCase().length();
        for (Piloto piloto : listaPilotosoEquipo) {
            piloto.redondear();
            int nombre = piloto.getNombre().length();
            double dinero = piloto.getPlata();
            int opcion = String.valueOf(piloto.getId()).length();

            maxNombre = Math.max(Math.max(maxNombre, nombre), maxEquipo);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7 + 10; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   PILOTOS ", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s | %-" + 10 + "s |\n", "OPCION", "NOMBRE", "HABILIDAD");
        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (Piloto piloto : listaPilotosoEquipo) {
            System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s | %-" + 10 + "s |\n", i, piloto.getNombre(), piloto.getHabilidad());
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }


    static void tablaEquiposPuntos(ArrayList<Equipo> listaEquipos) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;

        for (Equipo equipo : listaEquipos) {
            int nombre = equipo.getNombre().length();
            double dinero = equipo.getPlata();
            int opcion = String.valueOf(equipo.getId()).length();

            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 10 + 7 + 10; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "  EQUIPOS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s | %-" + 10 + "s |\n", "POSICION", "NOMBRE", "PUNTOS");
        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (Equipo equipo : listaEquipos) {
            System.out.printf("| %-" + 7 + "s | %-" + maxNombre + "s | %-" + 10 + "s |\n", i, equipo.getNombre(), equipo.getPuntos());
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }

    static void tablaPilotosParticipantes(ArrayList<Piloto> listaPilotos, Campeonato campeonato) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;
        int maxEquipo = 0;
        int maxCamp = campeonato.getNombre().length();
        for (Piloto piloto : listaPilotos) {
            int nombre = piloto.getNombre().length();
            int equipo = piloto.getEquipo().getNombre().length();
            int opcion = String.valueOf(piloto.getId()).length();

            maxNombre = Math.max(maxNombre, nombre);
            maxEquipo = Math.max(maxEquipo, equipo);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = 76+10; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - maxCamp) / 2) + "s%s%" + ((tablaAncho - maxCamp) / 2) + "s", "", campeonato.getNombre().toUpperCase(), "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + 25 + "s | %-" + 11 + "s | %-" + 40 + "s |\n", "NOMBRE", "HABILIDAD", "EQUIPO");
        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (Piloto piloto : listaPilotos) {
            System.out.printf("| %-" + 25 + "s | %-" + 11 + "s | %-" + 40 + "s |\n", piloto.getNombre(), String.format("%.2f", piloto.getHabilidad()), piloto.getEquipo().getNombre());
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }


    static void tablaCiudades(ArrayList<Ciudad> ciudades) {
        // Obtener la longitud maxima de las cadenas en las columnas

        int maxNombre = 0;
        for (Ciudad ciudad : ciudades) {
            ciudad.redondear();
            int nombre = ciudad.getNombre().length();

            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = 25 + 10 + 7 +20 +3; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   CIUDADES", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + 10 + "s | %-" + 25 + "s | %-" + 20 + "s |\n","OPCION", "NOMBRE", "PRECIO ESTADIA");
        System.out.println("-".repeat(tablaAncho));

        String[] continentes = {"Africa", "America", "Asia", "Europa", "Oceania"};

        int i = 1;
        for (Ciudad ciudad : ciudades) {
            System.out.printf("| %-" + 10 + "s | %-" + 25 + "s | %-" + 20 + "s |\n", i ,ciudad.getNombre(), ciudad.getPrecioEstadia() + "$");
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }

    static void tablaCarrerasCalencario(ArrayList<Carrera> listaCarreras) {
        // Obtener la longitud m�xima de las cadenas en las columnas
        int maxNombre = 0;

        for (Carrera carrera : listaCarreras) {
            carrera.redondear();
            int nombre = carrera.getNombreCircuito().length();


            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = 30 + 7 + 16 + 10 + 7 + 5 + 18 + 10; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "CARRERAS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + 30 + "s |%-" + 17 + "s | %-" + 10 + "s | %-" + 15 + "s |%-" + 17 + "s |\n", "NOMBRE", "FECHA", "DIFICULTAD", "PREMIO EFECTIVO", "CIUDAD");
        System.out.println("-".repeat(tablaAncho));


        int i = 1;
        for (Carrera carrera : listaCarreras) {
            System.out.printf("| %-" + 30 + "s |%-" + 17 + "s | %-" + 10 + "s | %-" + 15 + "s | %-" + 17 + "s|\n", carrera.getNombreCircuito(), carrera.getFecha(), carrera.getDificultad(), carrera.getPremioEfectivo() + "$", carrera.getCiudad());
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }

    static void tablaCircuitos(ArrayList<Circuito> listaCircuitos) {
        // Obtener la longitud mï¿½xima de las cadenas en las columnas
        int maxNombre = 0;
        int maxEquipo = 0;
        for (Circuito circuito : listaCircuitos) {
            circuito.redondear();
            int nombre = circuito.getNombre().length();


            maxNombre = Math.max(maxNombre, nombre);

        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 11 + 7 + 4 + 11; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "CIRCUITOS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + 11 + "s | %-" + maxNombre + "s | %-" + 11 + "s |\n", "OPCION" ,"NOMBRE", "PRECIO");
        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (Circuito circuito : listaCircuitos) {
            System.out.printf("| %-" + 11 + "s | %-" + maxNombre + "s | %-" + 11 + "s |\n", i ,circuito.getNombre(), circuito.getPrecio());
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }

    static void tablaVehiculos(ArrayList<VehiculoCarrera> listaVehiculo) {
        // Obtener la longitud m�xima de las cadenas en las columnas
        int maxNombre = 0;

        for (VehiculoCarrera vehiculoCarrera : listaVehiculo) {
            vehiculoCarrera.redondear();
            int nombre = vehiculoCarrera.getModelo().length() + vehiculoCarrera.getMarca().length();


            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16 + 10 + 7 + 5 + 19; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "VEHICULO", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + maxNombre + "s |%-" + 10 + "s | %-" + 10 + "s | %-" + 10 + "s | %-" + 10 + "s |%-" + 10 + "s |\n", "NOMBRE", "VELOCIDAD", "ALERON", "MOTOR", "NEUMATICOS", "GASOLINA");
        System.out.println("-".repeat(tablaAncho));


        for (VehiculoCarrera vehiculoCarrera : listaVehiculo) {
            String aleron;
            String motor;
            String neumaticos;

            if (vehiculoCarrera.getAleron().isDanado()) {
                aleron = "DAÑADO";
            } else {
                aleron = "OK";
            }

            if (vehiculoCarrera.getMotor().isDanado()) {
                motor = "DAÑADO";
            } else {
                motor = "OK";
            }

            if (vehiculoCarrera.getNeumaticos().isDanado()) {
                neumaticos = "DAÑADO";
            } else {
                neumaticos = "OK";
            }


            System.out.printf("| %-" + maxNombre + "s |%-" + 10 + "s | %-" + 10 + "s | %-" + 10 + "s | %-" + 10 + "s | %-" + 10 + "s|\n", vehiculoCarrera.getModelo() + " " + vehiculoCarrera.getMarca(), vehiculoCarrera.getVelocidad(), aleron, motor, neumaticos, vehiculoCarrera.getGasolina());

        }

        System.out.println("-".repeat(tablaAncho));
    }

    static void tablaCarreraCiudad(ArrayList<Carrera> listaCarreras) {
        // Obtener la longitud m�xima de las cadenas en las columnas
        int maxNombre = 0;

        for (Carrera carrera : listaCarreras) {
            carrera.redondear();
            int nombre = carrera.getNombreCircuito().length();
            int ciudad = carrera.getCiudad().getNombre().length();
            double dificultad = carrera.getDificultad();


            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16 + 10 + 7 + 5 + 3; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", " CARRERAS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-" + maxNombre + "s | %-" + 16 + "s |\n", "NOMBRE", "CIUDAD");
        System.out.println("-".repeat(tablaAncho));


        for (Carrera carrera : listaCarreras) {


            System.out.printf("| %-" + maxNombre + "s | %-" + 16 + "s |\n", carrera.getNombreCircuito(), carrera.getCiudad().getNombre());


        }

        System.out.println("-".repeat(tablaAncho));
    }

    public static void tablaChasis(ArrayList<Chasis> chasisList) {
        // Obtener la longitud máxima de las cadenas en las columnas
        int maxMarca = 0;
        int maxModelo = 0;
        int maxVelocidad = 0;
        int maxPrecio = 0;

        for (Chasis chasis : chasisList) {
            maxMarca = Math.max(maxMarca, chasis.getMarca().length());
            maxModelo = Math.max(maxModelo, chasis.getModelo().length());
            maxVelocidad = Math.max(maxVelocidad, String.valueOf(chasis.getVelocidad()).length());
            maxPrecio = Math.max(maxPrecio, String.valueOf(chasis.getPrecio()).length());
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxMarca + maxModelo + maxVelocidad + maxPrecio + 18+18;

        // Imprimir la tabla con el título centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 21) / 2) + "s%s%" + ((tablaAncho - 21) / 2) + "s", "", "   CHASIS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));

        System.out.printf("| %-" + 10 + "s | %-" + maxMarca + "s | %-" + maxModelo + "s | %-" + 15 + "s | %-" + maxPrecio + "s |\n",
                "OPCION","MARCA", "MODELO", "VELOCIDAD", "PRECIO");

        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (Chasis chasis : chasisList) {
            chasis.redondear();
            System.out.printf("| %-" + 10 + "s | %-" + maxMarca + "s | %-" + maxModelo + "s | %-" + 15 + "s | %-" + maxPrecio + "s |\n",
                    i,chasis.getMarca(), chasis.getModelo(), chasis.getVelocidad(), chasis.getPrecio());
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
        }
}