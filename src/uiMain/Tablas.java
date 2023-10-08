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

        int i = 1;
        for (Campeonato campeonato : campeonatos) {
            System.out.printf("| %-"+maxNombre+"s | %-"+10+"s |\n", campeonato.getNombre(), i);
            i++;
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

        System.out.printf("| %-"+maxNombre+"s | %-"+maxPais+"s | %-"+7+"s |\n", "NOMBRE", "PAIS","OPCION");

        System.out.printf("| %-"+maxNombre+"s | %-"+maxPais+"s | %-7s |\n", "NOMBRE", "PAIS","OPCION");

        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (Equipo equipo : equipos) {

            System.out.printf("| %-"+maxNombre+"s | %-"+maxPais+"s | %-"+7+"s |\n", equipo.getNombre(),equipo.getPais(),i);
            i++;

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
        System.out.printf("| %-"+maxNombre+"s | %-"+maxPais+"s | %-"+7+"s |\n", "NOMBRE", "PAIS","OPCION");
        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (DirectorCarrera directorCarrera : listaDirectores) {
            System.out.printf("| %-"+maxNombre+"s | %-"+maxPais+"s | %-"+7+"s |\n", directorCarrera.getNombre(),directorCarrera.getPais(), i);
            i++;
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
        System.out.printf("| %-"+maxNombre+"s | %-"+18+"s | %-"+7+"s |\n", "NOMBRE", "DINERO DISPONIBLE","OPCION");
        System.out.println("-".repeat(tablaAncho));

        int i = 1;
        for (Patrocinador patrocinador : listaPatrocinadores) {
            System.out.printf("| %-"+maxNombre+"s | %-"+18+"s | %-"+7+"s |\n", patrocinador.getNombre(),patrocinador.getDinero()+"$", i);
            i++;
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
        int tablaAncho = maxNombre + 7 + 16 + 10 + 7 + 5; // 7 para los espacios y los bordes

        // Imprimir la tabla con el tï¿½tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   PIEZAS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s |%-"+7+"s |\n", "NOMBRE", "MANIOBRABILIDAD","PRECIO","OPCION");
        System.out.println("-".repeat(tablaAncho));

        
        int i = 1;
        for (Pieza pieza : piezas) {
            System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s | %-"+7+"s|\n", pieza.getNombre(),"+"+pieza.getManiobrabilidadAnadida(), pieza.getPrecio() + "$", i);
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }
    
    //tabla piezas contrabando
    public static void tablaPiezasContrabando(ArrayList<Pieza> piezasContrabando) {
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
        int tablaAncho = maxNombre + 7 + 16 + 10 + 7 + 5; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   PIEZAS CONTRABANDO", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s |%-"+7+"s |\n", "NOMBRE", "MANIOBRABILIDAD","PRECIO","OPCION");
        System.out.println("-".repeat(tablaAncho));

        
        int i = 1;
        for (Pieza piezaContrabando : piezasContrabando) {
            System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s | %-"+7+"s|\n", piezaContrabando.getNombre(),"+"+piezaContrabando.getManiobrabilidadAnadida(), piezaContrabando.getPrecio() + "$", i);
            i++;
        }

        System.out.println("-".repeat(tablaAncho));
    }
    
    //tabla vehiculos
    public static void tablaVehiculos(ArrayList<Vehiculo> vehiculosDisponibles) {
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
        System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s |%-"+7+"s |\n", "NOMBRE", "VELOCIDAD","PRECIO","OPCION");
        System.out.println("-".repeat(tablaAncho));

        
        int i = 1;
        for (Vehiculo vehiculo : vehiculosDisponibles) {

        	
        	System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s | %-"+7+"s|\n", vehiculo.getMarca() +" "+ vehiculo.getModelo(), vehiculo.getVelocidad(), vehiculo.getPrecioUtilizar() + "$", i);
        	i++;
        	
        	
        	
        }

        System.out.println("-".repeat(tablaAncho));
    }
    
    
    //tabla posiciones
    public static void tablaPosiciones(ArrayList<VehiculoCarrera> posiciones) {
        // Obtener la longitud m�xima de las cadenas en las columnas
        int maxNombre = 0;
        
        for (VehiculoCarrera posicion : posiciones) {
            int nombre = posicion.getPiloto().getNombre().length();
            double distancia = posicion.getDistanciaRecorrida();
            double velocidad = posicion.getTiempo();
           
            
            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16 + 10 + 7 + 5; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "   TABLA DE POSICIONES", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s |%-"+7+"s |\n", "PILOTO", "DISTANCIA","TIEMPO","PUESTO");
        System.out.println("-".repeat(tablaAncho));

        
        int i = 1;
        for (VehiculoCarrera posicion : posiciones) {

        	
        	System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s | %-"+7+"s|\n", posicion.getPiloto().getNombre() ,posicion.getDistanciaRecorrida(), posicion.getTiempo() , i);
        	i++;
        	
        	
        	
        }

        System.out.println("-".repeat(tablaAncho));
    }
    
    
    //tabla carreras
    public static void tablaCarreras(Campeonato campeonato) {
        // Obtener la longitud m�xima de las cadenas en las columnas
        int maxNombre = 0;
        
        for (Carrera carrera : campeonato.getListaCarreras()) {
            int nombre = carrera.getNombreCircuito().length();
            int ciudad = carrera.getCiudad().getNombre().length();
            double dificultad = carrera.getDificultad();
           
            
            maxNombre = Math.max(maxNombre, nombre);
        }

        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16 + 10 + 7 + 5 +3; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "CALENDARIO DE CARRERAS", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s |%-"+7+"s |\n", "CARRERA", "CIUDAD","FECHA","DIFICULTAD");
        System.out.println("-".repeat(tablaAncho));

        
        
        for (Carrera carrera : campeonato.getListaCarreras()) {

        	
        	System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s | %-"+10+"s|\n", carrera.getNombreCircuito() ,carrera.getCiudad().getNombre(), carrera.getMes(),carrera.getDificultad());
        	
        	
        	
        	
        }

        System.out.println("-".repeat(tablaAncho));
    }



    //tabla stats actuales
    public static void tablaStatsActuales(VehiculoCarrera vehiculoElegido) {
        // Obtener la longitud m�xima de las cadenas en las columnas
        int maxNombre = 30;
        // Calcular el ancho total de la tabla
        int tablaAncho = maxNombre + 7 + 16 + 10 + 7 + 5 +3; // 7 para los espacios y los bordes

        // Imprimir la tabla con el t�tulo centrado
        String tituloCentrado = String.format("%" + ((tablaAncho - 18) / 2) + "s%s%" + ((tablaAncho - 18) / 2) + "s", "", "STATS ACTUALES", "");
        System.out.println("-".repeat(tablaAncho));
        System.out.println(tituloCentrado);
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s |%-"+10+"s | %-"+10+"s | %-"+10+"s |\n", "PILOTO", "VELOCIDAD","GASOLINA","ESTADO ALERON","ESTADO MOTOR", "ESTADO NEOMATICOS");
        System.out.println("-".repeat(tablaAncho));
        System.out.printf("| %-"+maxNombre+"s | %-"+16+"s | %-"+10+"s | %-"+10+"s| %-"+10+"s | %-"+10+"s |\n", vehiculoElegido.getPiloto().getNombre() ,vehiculoElegido.getVelocidadActual(), vehiculoElegido.getGasolina(), vehiculoElegido.getAleron().isDanado(),vehiculoElegido.getMotor().isDanado(),vehiculoElegido.getNeumaticos().isDanado()                                            );

        System.out.println("-".repeat(tablaAncho));
    }
    
    	
   }
