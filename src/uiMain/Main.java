package uiMain;

import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import baseDatos.Deserializado;
import baseDatos.serializador;

import static uiMain.AsciiArt.bienvenida;
import static uiMain.AsciiArt.sitAndTalk;
import static uiMain.Tablas.*;

public class Main {
    // NO USAR CARACTERES ESPECIALES
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static int opcion;
    static String opcionYN;
    static int n;

    static {

        //Deserializado.deserializacion();
        CrearObjetos.crearObjetos();
        serializador.serializar();
    }

    public static void main(String[] args) {
        System.out.println("\n");
        // Mensaje de bienvenida
        bienvenida();
        System.out.println("\n");

        // Mensade de introduccion
        System.out.println("Hola! En este juego seras un piloto de un equipo de Formula 1");
        System.out.println("Buena suerte!");
        System.out.println("\n");
        sc.nextLine();

        boolean jugar = true;
        while (jugar) {
            // Menu
            System.out.println("Menu Principal");
            System.out.println("1. Prepara un nuevo campeonato");
            System.out.println("2. Disenar Ruta de Campeonato");
            System.out.println("3. Personaliza tu Vehiculo de Carreras");
            System.out.println("4. Forjar Alianza con el Maestro de Carreras");
            System.out.println("5. Poner a Prueba Tus Habilidades en la Pista");
            System.out.println("6. Salir");

            opcion = validaciones(1, 6);
            System.out.println("\n");

            switch (opcion) {
                case 1:
                    //metodo para crear un campeonato
                    prepararCampeonato();
                    continue;
                case 2:
                    //metodo para crear calendario de carreras
                    calendarioCarreras();
                    continue;
                case 3:
                    //metodo para personalizar vehiculo
                    tunearCarro();
                    break;
                case 4:
                    //metodo para corrupcion
                    corrupcion();
                    break;
                case 5:
                    //metodo para correr carreras
                    simulacionGranPrix();
                    break;
                case 6:
                    //salir
                    System.out.println("Gracias por jugar!");
                    jugar = false;
                    //TODO: Borrar los datos innecesarios!
                    break;
            }
        }
    }

    private static void prepararCampeonato() {
        // elegir continente
        System.out.println("Has decidido crear preparar un nuevo campeonato. Comencemos.");
        System.out.println("Elige un continente donde se llevara a cabo");
        // TODO tabla de continentes
        Tablas.tablaContinentes();
        n = validaciones(1, 5);
        Continente continente = Ciudad.convertirContinente(n);
        System.out.println("Has elegido " + continente);
        System.out.println("\n");

        // elegir campeonato
        // Que sea del continente elegido
        ArrayList<Campeonato> campeonatos = Campeonato.campeonatosContinente(continente);
        // Que no este desbloqueado
        ArrayList<Campeonato> campeonatosDisponibles = Campeonato.campeonatosDisponibles(campeonatos);

        System.out.println("Estos son los campeonatos disponibles en el continente " + continente);
        System.out.println("Elige un campeonato");
        tablaCampeonatos(campeonatosDisponibles);
        n = validaciones(1, campeonatosDisponibles.size());
        Campeonato campeonato = campeonatosDisponibles.get(n - 1);
        campeonato.setDesbloqueado(true);
        System.out.println("Has elegido " + campeonato.getNombre());
        System.out.println("\n");

        // elegir equipo
        // elegir equipos con sede en el continente del campeonato
        ArrayList<Equipo> equipos = Equipo.equiposContinente(campeonato);
        // elegir equipos que no esten en otro campeonato
        ArrayList<Equipo> equiposDisponibles = Equipo.equiposDisponibles(equipos);
        System.out.println("Estos son los equipos que tienen sede en alguna ciudad del continente " + continente + " y que no estan en otro campeonato");
        tablaEquipos1(equiposDisponibles);
        System.out.println("Elige un equipo");
        n = validaciones(1, equiposDisponibles.size());
        Equipo equipo = equiposDisponibles.get(n - 1);
        System.out.println("Has elegido " + equipo.getNombre());
        equipo.setElegido(true);
        System.out.println("\n");

        // elegir equipos competidores
        ArrayList<Equipo> participantes = Equipo.elegirContrincantes(equipo, campeonato, equiposDisponibles);
        System.out.println("Estos son los equipos que competiran en el campeonato, presiona enter para continuar");
        Equipo.equiposOcupados(participantes);
        tablaEquipos1(participantes);
        campeonato.setListaEquipos(participantes);
        sc.nextLine();

        // elegir pilotos del los equipos
        // se eligen los pilotos disponibles
        ArrayList<Piloto> pilotosDisponibles = Piloto.pilotosDisponibles();

        boolean elegir = false;
        ArrayList<Piloto> pilotosParticipar = new ArrayList<Piloto>();

        ArrayList<Piloto> pilotosEquipo = Piloto.pilotosEquipo(equipo, pilotosDisponibles);
        System.out.println("Mira los Pilotos de tu Escuderia");
        // TODO tabla de pilotos
        Tablas.tablaPilotosEquipo(pilotosEquipo);

        // elegir piloto 1
        System.out.println("Elige tu piloto");
        n = validaciones(1, pilotosEquipo.size());
        Piloto piloto1 = pilotosEquipo.get(n - 1);
        pilotosEquipo.remove(piloto1);
        pilotosParticipar.add(piloto1);
        piloto1.setElegido(true);
        piloto1.setDesbloqueado(true);
        System.out.println("Has elegido " + piloto1.getNombre());

        // elegir piloto 2
        System.out.println("Elige a tu companero de equipo");
        Tablas.tablaPilotosEquipo(pilotosEquipo);
        n = validaciones(1, pilotosEquipo.size());
        Piloto piloto2 = pilotosEquipo.get(n - 1);
        piloto2.setElegido(false);
        pilotosEquipo.remove(piloto2);
        pilotosParticipar.add(piloto2);
        System.out.println("Has elegido " + piloto2.getNombre());
        System.out.println("\n");

        participantes.remove(equipo);

        // preguntar si quiere elegir contrincantes
        System.out.println("Quieres elegir los pilotos de equipos contrincantes?");
        System.out.println("Y/N");
        elegir = validacionesYN();

        // se eligen los pilotos que participaran por cada equipo
        for (Equipo equipo1 : participantes) {
            pilotosEquipo = Piloto.pilotosEquipo(equipo1, pilotosDisponibles);
            if (elegir) {
                System.out.println("\n");
                System.out.println("Mira los Pilotos de la Escuderia " + equipo1.getNombre());
                // TODO tabla de pilotos
                Tablas.tablaPilotosEquipo(pilotosEquipo);
                // elegir piloto 1
                System.out.println("Elige un piloto");
                n = validaciones(1, pilotosEquipo.size());
                Piloto pilotoNo1 = pilotosEquipo.get(n - 1);
                pilotosEquipo.remove(pilotoNo1);
                pilotosParticipar.add(pilotoNo1);
                System.out.println("Has elegido " + pilotoNo1.getNombre());
                System.out.println("\n");

                // elegir piloto 2
                // TODO tabla de pilotos

                Tablas.tablaPilotosEquipo(pilotosEquipo);

                System.out.println("Elige a el companero de equipo");
                n = validaciones(1, pilotosEquipo.size());
                Piloto pilotoNo2 = pilotosEquipo.get(n - 1);
                pilotoNo2.noEsElegido();
                pilotosEquipo.remove(pilotoNo2);
                pilotosParticipar.add(pilotoNo2);
                System.out.println("Has elegido " + pilotoNo2.getNombre());
                System.out.println("\n");
            } else {
                equipo1.setElegido(false);
                // elegir contrincantes aleatoriamente
                // piloto 1
                Piloto pilotoN = pilotosEquipo.get(rand.nextInt(pilotosEquipo.size()));
                //
                pilotoN.noEsElegido();
                pilotosParticipar.add(pilotoN);
                pilotosEquipo.remove(pilotoN);

                // piloto 2
                pilotoN = pilotosEquipo.get(rand.nextInt(pilotosEquipo.size()));
                pilotoN.noEsElegido();
                pilotosParticipar.add(pilotoN);
                pilotosEquipo.remove(pilotoN);
            }
        }
        campeonato.setListaPilotos(pilotosParticipar);

        // elegir patrocinador

        // se eligen los patrocinadores que no esten patrocinando
        ArrayList<Patrocinador> patrocinadoresDisponibles = Patrocinador.patrocinadoresDisponibles();


        for (Piloto piloto : campeonato.getListaPilotos()) {
            boolean repetir = true;
            while (repetir) {
                // se eligen patrocinadores que tengan el dinero suficiente para patrocinar a cada piloto
                ArrayList<Patrocinador> patrocinadoresPiloto = Patrocinador.patrocinadorPiloto(piloto, patrocinadoresDisponibles);
                if (piloto.getEquipo().isElegido()) { // si es del equipo elegido
                    System.out.println("Estos son los patrocinadores que pueden patrocinar a " + piloto.getNombre());
                    tablaPatrocinadores(patrocinadoresPiloto);
                    System.out.println("Elige un patrocinador para el piloto " + piloto.getNombre());
                    n = validaciones(1, patrocinadoresPiloto.size());
                    Patrocinador patrocinador = patrocinadoresPiloto.get(n - 1);
                    System.out.println("Se va a negociar con " + patrocinador.getNombre());
                    // hacer negociacion
                    if (patrocinador.pensarNegocio(piloto)) {
                        System.out.println("Se ha llegado a un acuerdo con " + patrocinador.getNombre() + "\n");
                        System.out.println("Presiona enter para continuar");
                        sc.nextLine();
                        repetir = false;
                    } else {
                        System.out.println("No se ha llegado a un acuerdo con " + patrocinador.getNombre() + "\n");
                    }
                } else { // si no es del equipo elegido
                    Patrocinador patrocinador = Patrocinador.patrocinadorPiloto(piloto, patrocinadoresDisponibles, true);
                    repetir = !patrocinador.pensarNegocio(piloto);
                }
            }
        }

        // mirar si el patrocinador tiene rosca
        for (Piloto piloto5 : pilotosParticipar) {
            if (piloto5.getPatrocinador().isRosca()) {
                piloto5.getPatrocinador().beneficiarPiloto(piloto5);
            }
        }

        // Mostrar como quedo el campeonto con sus participantes
        System.out.println("Este es el campeonato que has creado");
        // TODO tabla de pilotos
        Piloto.desbloquearPilotos(pilotosParticipar);
        Tablas.tablaPilotosParticipantes(pilotosParticipar, campeonato);
        System.out.println("\n");

        serializador.serializar();

        // Reset variables
        campeonato = null;
        continente = null;
        equipos = null;
        equiposDisponibles = null;
        pilotosParticipar = null;
        pilotosDisponibles = null;
        participantes = null;
        patrocinadoresDisponibles = null;


    }

    private static void calendarioCarreras() {
        System.out.println("Ahora es momento de disenar la ruta de carreras del Campeonato.");
        System.out.println("Primero, elige el campeonato al que disenaras la ruta de carreras");
        tablaCampeonatos(Campeonato.campeonatosDesbloqueados());
        n = validaciones(1, Campeonato.campeonatosDesbloqueados().size());
        Campeonato campeonato = Campeonato.campeonatosDesbloqueados().get(n - 1);
        System.out.println("Has elegido " + campeonato.getNombre());
        System.out.println("\n");

        ArrayList<Carrera> carrerasCamp = new ArrayList<Carrera>();

        ArrayList<Circuito> circuitos = Circuito.circuitosUbicacion(campeonato);
        ArrayList<Circuito> circuitosVender = null;

        // para la cantidad de carreras en el campeonato

        System.out.println("Tienes que preparar " + campeonato.getCantCarreras() + " carreras");

        for (int i = 0; i < campeonato.getCantCarreras(); i++) {

            boolean again = true;
            DirectorCarrera directorCarrera = null;
            while (again) {
                // elegir Director de carreras
                System.out.println("Estos son los directores de carrera que tienen la licencia vigente:");
                tablaDirectoresCarrera(DirectorCarrera.dcDisponibles());
                System.out.println("Elige un director de carrera");
                n = validaciones(1, DirectorCarrera.dcDisponibles().size());
                directorCarrera = DirectorCarrera.dcDisponibles().get(n - 1);
                System.out.println("Has elegido " + directorCarrera.getNombre());
                System.out.println("\n");
                dineroSuficiente(directorCarrera);
                circuitosVender = Circuito.circuitosVender(directorCarrera, circuitos);
                if (circuitosVender.isEmpty()) {
                    System.out.println("No hay circuitos disponibles para el director de carrera " + directorCarrera.getNombre());
                    System.out.println("Intenta con otro director de carrera");
                    System.out.println("\n");
                } else {
                    again = false;
                }
            }

            boolean repetir = true;
            Circuito circuito = null;

            int mes = 0;
            while (repetir) {
                // elegir mes
                mes = 0;

                boolean validaciones = false;

                // verificar que el mes no este ocupado
                while (!validaciones) {
                    if (!campeonato.getMesesCarreras().contains(mes)) {
                        System.out.println("Escribe el numero del mes en el que quieres reservar el circuito");
                        System.out.println("Nota: Las carreras deben ser en meses distintos.");
                        mes =validaciones(1, 12); // Para que no se quede en un loop infinito xd
                    } else {
                        campeonato.actualizarMesCarreras(mes);
                        System.out.println("Mes elegido!");
                        System.out.println("\n");
                        validaciones = true;
                    }
                }

                // elegir circuito
                ArrayList<Circuito> circuitosDisponibles = Circuito.circuitosDisponibles(mes, circuitosVender);

                if (circuitosDisponibles.isEmpty()) {
                    System.out.println("No hay circuitos disponibles en este mes ");
                    System.out.println("Quieres intentar en otro mes?");
                } else {
                    System.out.println("Estos son los circuitos disponibles en el mes " + mes + " que puede pagar el director de carrera en el continente " + campeonato.getContinente());
                    // TODO tabla con circuitos
                    Tablas.tablaCircuitos(circuitosDisponibles);
                    System.out.println("Elige un circuito");
                    n = validaciones(1, circuitosVender.size());
                    circuito = circuitosVender.get(n - 1);
                    System.out.println("\n");
                    circuito.venderCircuito(directorCarrera, mes);
                    repetir = false;
                }
            }

            // elegir dificultad
            System.out.println("Elige la dificultad de la carrera");
            System.out.println("1. Facil");
            System.out.println("2. Normal");
            System.out.println("3. Dificil");
            n = validaciones(1, 3);
            int dificultad = n;
            System.out.println("\n");

            // elegir ciudad de la carrera
            ArrayList<Ciudad> ciudades = Ciudad.ciudadesContinente(campeonato.getContinente());
            System.out.println("Estas son las ciudades disponibles en el continente " + campeonato.getContinente());
            // TODO tabla de ciudades
            Tablas.tablaCiudades(ciudades);
            System.out.println("Elige una ciudad");
            n = validaciones(1, ciudades.size());
            Ciudad ciudad = ciudades.get(n - 1);
            Carrera c = new Carrera(ciudad, dificultad, campeonato, circuito, mes, directorCarrera);
            carrerasCamp.add(c);
            System.out.println("\n");

            // Descontar dinero de estadia
            ciudad.estadia(c);
            // Asignar beneficios a equipos
            ciudad.hostRosca(c);
        }

        // Asignar carreras al campeonato
        campeonato.setListaCarreras(carrerasCamp);
        // Organizar carreras de acuerdo a la fecha
        campeonato.organizarCarreras();

        // carreras preferidas
        ArrayList<Carrera> carrerasPreferidas = campeonato.carrerasPreferidas();
        ArrayList<Carrera> carrerasPreferidasU = new ArrayList<Carrera>();
        if (carrerasPreferidas.isEmpty()) {
            System.out.println("No hay carreras preferidas por el patrocinador del campeonato en este campeonato");
        } else {
            System.out.println("Estas son las carreras preferidas por el patrocinador del campeonato");
            tablaCarreras1(carrerasPreferidas);
            System.out.println("Elige cuantas de estas quieres que tengan mas peso en el campeonato");
            n = validaciones(1, carrerasPreferidas.size());
            int cantCarrerasPreferidas = n;

            carrerasPreferidasU = campeonato.carrerasPreferidas();

            for (int i = 0; i < cantCarrerasPreferidas; i++) {
                System.out.println("Elige una carrera");
                n = validaciones(1, carrerasPreferidas.size());
                Carrera carrera = carrerasPreferidas.get(n - 1);
                carrerasPreferidasU.add(carrera);
                carrerasPreferidas.remove(carrera);
                System.out.println("\n");
            }
        }

        // Elegir premio en efectivo para las carreras
        System.out.println("Elige el valor del premio del ganador del campeonato, debe ser menor a " + campeonato.getPatrocinadorCampeonato().getPlata());
        n = validaciones(1, (int) campeonato.getPatrocinadorCampeonato().getPlata());
        double premio = n;
        System.out.println("\n");
        System.out.println("Elige el premio en efectivo destinado para premiar todas las carreras, debe ser menor a " + campeonato.getPatrocinadorCampeonato().getPlata());
        System.out.println("El premio en efectivo debe ser menor a " + campeonato.getPatrocinadorCampeonato().getPlata());
        n = validaciones(1, (int) campeonato.getPatrocinadorCampeonato().getPlata());
        double presupuesto = n;
        dineroSuficiente(campeonato.getPatrocinadorCampeonato(), presupuesto + premio);
        System.out.println("El equipo de logistica esta repartiendose el dinero para los premios...");
        System.out.println("\n");
        campeonato.logisticaPremios(premio, presupuesto, carrerasPreferidasU);

        System.out.println("Este es el calendario de carreras del campeonato");
        // TODO tabla de carreras
        campeonato.organizarCarreras();
        tablaCarrerasCalencario(campeonato.getListaCarreras());
        System.out.println("\n");
    }

    private static void tunearCarro() {
        // elegir pilotos disponibles
        ArrayList<Piloto> pilotosDisponibles = Piloto.pilotosDesbloqueados();

        System.out.println("Es momento de tunear tu vehiculo de carreras. Primero, veamos a que piloto le vas a personalizar el vehiculo");
        System.out.println("De acuerdo a los campeonatos desbloqueados, estan disponibles los siguientes pilotos");
        // TODO pilotos tabla
        Tablas.tablaPilotosEquipo(pilotosDisponibles);
        System.out.println("Elige un piloto");
        n = validaciones(1, pilotosDisponibles.size());
        Piloto piloto = pilotosDisponibles.get(n - 1);
        VehiculoCarrera vehiculoCarrera;
        // verificar si tiene vehiculos asociados
        ArrayList<VehiculoCarrera> vehiculos = VehiculoCarrera.vehiculosPiloto(piloto);
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos asociados a " + piloto.getNombre());
            System.out.println("Tienes que comprar un chasis y configurar tu vehiculo");
            System.out.println("\n");

            // elegir chasis
            ArrayList<Chasis> chasisDisponibles = Chasis.chasisDisponible(piloto);
            System.out.println("Estos son los chasis disponibles para " + piloto.getNombre() + " de acuerdo a su presupuesto");
            // TODO tabla de chasis
            tablaChasis(chasisDisponibles);
            System.out.println("Elige un chasis");
            n = validaciones(1, chasisDisponibles.size());
            Chasis chasis = chasisDisponibles.get(n - 1);
            vehiculoCarrera = chasis.comprar(piloto);
            ArrayList<ArrayList<Pieza>> combinaciones = Pieza.combinaciones(vehiculoCarrera);

            System.out.println("Estos son los alerones disponibles para " + piloto.getNombre() + " de acuerdo a su presupuesto");
            // elegir aleron
            ArrayList<Pieza> aleronesDisponibles = Pieza.filterAlerones(combinaciones);
            tablaPiezas(aleronesDisponibles);
            System.out.println("Elige un aleron");
            n = validaciones(1, aleronesDisponibles.size());
            Pieza aleron = aleronesDisponibles.get(n - 1);

            // elegir llantas
            System.out.println("Estas son los neumaticos disponibles para " + piloto.getNombre() + " de acuerdo a su presupuesto");
            ArrayList<ArrayList<Pieza>> combinaciones2 = Pieza.combinacionesDisponibles(vehiculoCarrera, aleron, combinaciones);
            ArrayList<Pieza> llantasDisponibles = Pieza.filterNeumaticos(combinaciones2);
            tablaPiezas(llantasDisponibles);
            System.out.println("Elige un neumatico");
            n = validaciones(1, llantasDisponibles.size());
            Pieza llanta = llantasDisponibles.get(n - 1);

            // elegir motor
            System.out.println("Estos son los motores disponibles para " + piloto.getNombre() + " de acuerdo a su presupuesto");
            ArrayList<ArrayList<Pieza>> combinaciones3 = Pieza.combinacionesDisponibles(vehiculoCarrera, llanta, combinaciones2);
            ArrayList<Pieza> motoresDisponibles = Pieza.filterMotores(combinaciones3);
            tablaPiezas(motoresDisponibles);
            System.out.println("Elige un motor");
            n = validaciones(1, motoresDisponibles.size());
            Pieza motor = motoresDisponibles.get(n - 1);

            ArrayList<Pieza> piezasAsignar = new ArrayList<Pieza>();
            piezasAsignar.add(aleron);
            piezasAsignar.add(llanta);
            piezasAsignar.add(motor);

            double precioTotal = Pieza.precioTotal(piezasAsignar, vehiculoCarrera);
            Equipo equipo = vehiculoCarrera.getPiloto().getEquipo();

            System.out.println("Tu equipo esta haciendo la negociacion con los proveedores...");
            System.out.println("\n");

            boolean descuento = equipo.descuento(precioTotal, vehiculoCarrera);
            if (descuento) {
                System.out.println("Has impresionado a los proveedores");
                double porcentaje = equipo.calcularDescuento(precioTotal, vehiculoCarrera);
                System.out.println("Les han hecho un descuento del " + Decimales.dosDecimalesP(porcentaje) + "% debido a tus habilidades y el dinero del equipo");
                equipo.comprarPiezas(precioTotal, vehiculoCarrera);
            } else {
                System.out.println("No has impresionado a los proveedores, no te han hecho descuento");
                equipo.comprarPiezas(precioTotal, vehiculoCarrera);
                System.out.println("El vehiculo no ha sido configurado");
                System.out.println("\n");
            }
            System.out.println("Tu equipo ha comprado: " + aleron.getNombre() + ", " + llanta.getNombre() + ", " + motor.getNombre());
            System.out.println("El vehiculo ha sido configurado");
            System.out.println("\n");
        } else { // si tiene vehiculos asociados
            System.out.println("Estos son los vehiculos disponibles para " + piloto.getNombre());
            // TODO tabla de vehiculos
            Tablas.tablaVehiculos(vehiculos);
            System.out.println("Elige un vehiculo");
            n = validaciones(1, vehiculos.size());
            vehiculoCarrera = vehiculos.get(n - 1);
            System.out.println("\n");

            // elegir piezas a cambiar
            ArrayList<Pieza> piezasCambiar = new ArrayList<Pieza>();
            System.out.println("Quieres cambiar el aleron?");
            System.out.println("Y/N");
            boolean cambiar = validacionesYN();
            if (cambiar) {
                ArrayList<ArrayList<Pieza>> combinaciones = Pieza.combinaciones(vehiculoCarrera);
                System.out.println("Estos son los alerones disponibles para " + piloto.getNombre() + " de acuerdo a su presupuesto");
                // elegir aleron
                ArrayList<Pieza> aleronesDisponibles = Pieza.filterAlerones(combinaciones);
                tablaPiezas(aleronesDisponibles);
                System.out.println("Elige un aleron");
                n = validaciones(1, aleronesDisponibles.size());
                Pieza aleron = aleronesDisponibles.get(n - 1);
                piezasCambiar.add(aleron);
            }
            System.out.println("Quieres cambiar los neumaticos?");
            System.out.println("Y/N");
            cambiar = validacionesYN();
            if (cambiar) {
                ArrayList<ArrayList<Pieza>> combinaciones = Pieza.combinaciones(vehiculoCarrera);
                System.out.println("Estos son los neumaticos disponibles para " + piloto.getNombre() + " de acuerdo a su presupuesto");
                // elegir llantas
                ArrayList<Pieza> llantasDisponibles = new ArrayList<Pieza>();
                if (piezasCambiar.isEmpty()) {
                    llantasDisponibles = Pieza.filterNeumaticos(combinaciones);
                } else {
                    ArrayList<ArrayList<Pieza>> combinaciones2 = Pieza.combinacionesDisponibles(vehiculoCarrera, piezasCambiar.get(0), combinaciones);
                    llantasDisponibles = Pieza.filterNeumaticos(combinaciones2);
                }
                tablaPiezas(llantasDisponibles);
                System.out.println("Elige un neumatico");
                n = validaciones(1, llantasDisponibles.size());
                Pieza llanta = llantasDisponibles.get(n - 1);
                piezasCambiar.add(llanta);
            }
            System.out.println("Quieres cambiar el motor?");
            System.out.println("Y/N");
            cambiar = validacionesYN();
            if (cambiar) {
                ArrayList<ArrayList<Pieza>> combinaciones = Pieza.combinaciones(vehiculoCarrera);
                System.out.println("Estos son los motores disponibles para " + piloto.getNombre() + " de acuerdo a su presupuesto");
                // elegir motor
                ArrayList<Pieza> motoresDisponibles = new ArrayList<Pieza>();
                if (piezasCambiar.isEmpty()) {
                    motoresDisponibles = Pieza.filterMotores(combinaciones);
                } else if (piezasCambiar.size() == 1) {
                    ArrayList<ArrayList<Pieza>> combinaciones2 = Pieza.combinacionesDisponibles(vehiculoCarrera, piezasCambiar.get(0), combinaciones);
                    motoresDisponibles = Pieza.filterMotores(combinaciones2);
                } else {
                    ArrayList<ArrayList<Pieza>> combinaciones2 = Pieza.combinacionesDisponibles(vehiculoCarrera, piezasCambiar.get(0), combinaciones);
                    ArrayList<ArrayList<Pieza>> combinaciones3 = Pieza.combinacionesDisponibles(vehiculoCarrera, piezasCambiar.get(1), combinaciones2);
                    motoresDisponibles = Pieza.filterMotores(combinaciones3);
                }
                tablaPiezas(motoresDisponibles);
                System.out.println("Elige un motor");
                n = validaciones(1, motoresDisponibles.size());
                Pieza motor = motoresDisponibles.get(n - 1);
                piezasCambiar.add(motor);
            }

            double precioTotal = Pieza.precioTotal(piezasCambiar, vehiculoCarrera);
            Equipo equipo = vehiculoCarrera.getPiloto().getEquipo();

            System.out.println("Tu equipo esta haciendo la negociacion con los proveedores...");
            System.out.println("\n");

            boolean descuento = equipo.descuento(precioTotal, vehiculoCarrera);
            if (descuento) {
                System.out.println("Has impresionado a los proveedores");
                double porcentaje = equipo.calcularDescuento(precioTotal, vehiculoCarrera);
                System.out.println("Les han hecho un descuento del " + porcentaje + "% debido a tus habilidades y el dinero del equipo");
                equipo.comprarPiezas(precioTotal, vehiculoCarrera);
            } else {
                System.out.println("No has impresionado a los proveedores, no te han hecho descuento");
                equipo.comprarPiezas(precioTotal, vehiculoCarrera);
                System.out.println("El vehiculo no ha sido configurado");
                System.out.println("\n");
            }
            System.out.println("El vehiculo ha sido configurado");
            System.out.println("\n");
        }
        System.out.println("Este es tu vehiculo personalizado");
        vehiculoCarrera.actualizarVelicidadActual();
        vehiculoCarrera.actualizarVelocidadT();
        tablaStatsActuales(vehiculoCarrera);
        System.out.println("\n");
    }

    private static void corrupcion() {
        System.out.println("Asi que decidiste forjar una alianza con el Maestro de Carreras. Esperamos que no te arrepientas...");
        System.out.println("Primero, debemos escoger que piloto desea formar una amistad con el Maestro de Carreras");
        System.out.println("De acuerdo a los campeonatos desbloqueados, estan disponibles los siguientes pilotos");
        //Elegir pilotos disponibles
        ArrayList<Piloto> pilotosDisponibles = Piloto.pilotosDesbloqueados();
        // TODO pilotos tabla
        Tablas.tablaPilotosEquipo(pilotosDisponibles);
        System.out.println("Elige un piloto");
        n = validaciones(1, pilotosDisponibles.size());
        Piloto piloto = pilotosDisponibles.get(n - 1);

        System.out.println("De las carreras del campeonato del piloto elegido, estan los siguientes Maestros de Carrera");
        //Elegir carreras y Directores de Carrera disponibles
        Campeonato campeonatoElegido = Campeonato.campeonatoPiloto(piloto);
        ArrayList<DirectorCarrera> maestrosDeCarrera = Campeonato.directoresCarrera(campeonatoElegido);
        Tablas.tablaDirectoresCarrera(maestrosDeCarrera);
        System.out.println("Elige un maestro de carrera");
        n = validaciones(1, maestrosDeCarrera.size());
        DirectorCarrera maestroDeCarrera = maestrosDeCarrera.get(n - 1);

        //Iniciando minifuncionalidad 1: Apuesta Ilegal
        System.out.println("Al acercarse al Maestro de Carrera, te habla de ciertos 'problemas economicos' que lo tienen pensando");
        sitAndTalk();
        System.out.println("Quizas darle un 'incentivo' pueda llamar su atencion");

        System.out.println("Ofrece una cantidad de dinero (Tu equipo tiene " + (int) piloto.getEquipo().getPlata() + ")");
        n = validaciones(0, (int) piloto.getEquipo().getPlata());
        int plataOfrecida = n;


        System.out.println("El maestro de carrera " + maestroDeCarrera.getNombre() + " te ha propuesto (" + piloto.getNombre() + ") ir a un lugar mas tranquilo.");
        System.out.println("Llegan a un lugar con poca luz, te invita a sentarte, y pronto, tienes 25 cartas delante tuyo");
        AsciiArt.cards();

        System.out.println("El Maestro de Carrera te dice que elijas una de ellas (elige un numero del 1 al 25)");
        int cartaElegida = rand.nextInt(24) + 1;
        double multiplicadorGanancia = 5.5;
        ArrayList<Integer> cartasYaEscogidas = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25));
        while (true) {
            while (true) {
                n = validaciones(1, 25);
                if (cartasYaEscogidas.contains((Integer) n)){
                    cartasYaEscogidas.remove((Integer) n);
                    break;
                } else {
                    System.out.println("Esa carta ya fue escogida. Elige otra");
                }
            }
            if (n == cartaElegida) {
                break;
            } else if (cartasYaEscogidas.size()>20) {
                System.out.println("Te has equivocado. Poco a poco vas perdiendo el dinero que ofreciste");
                multiplicadorGanancia -= 0.15;
                cartasYaEscogidas.remove((Integer) n);
                System.out.println("Intentalo de nuevo");
            } else {
                System.out.println("Te has quedado sin intentos. Has perdido la mitad de dinero que ofreciste");
                multiplicadorGanancia = 0.5;
                break;
            }
        }
        double plataGanada = plataOfrecida * multiplicadorGanancia;
        System.out.println("El dinero que tienes para negociar con el Maestro de Carrera es " + plataGanada);
        ArrayList<Piloto> pilotosDesfavorecidos = maestroDeCarrera.pilotosDesfavorecidos(plataGanada, piloto);
        //Iniciando minifuncionalidad 2: Negociar para Maldecir Piloto
        System.out.println("El Maestro de Carrera te muestra una lista de los pilotos que esta dispuesto a 'castigar'. Elije uno");
        //TODO: Tabla pilotos
        Tablas.tablaPilotosDesfavorecidos(pilotosDesfavorecidos);
        n = validaciones(1, pilotosDesfavorecidos.size());
        Piloto pilotoMaldito = pilotosDesfavorecidos.get(n - 1);
        VehiculoCarrera vehiculoMaldito = pilotoMaldito.maldecirPiloto(plataGanada, piloto, maestroDeCarrera);
        //Iniciando minifuncionalidad 3: Negociar para Manipular la Carrera
        System.out.println("Decidiste maldecir a " + pilotoMaldito.getNombre());
        System.out.println("El Maestro de Carrera te informa que el vehiculo del piloto al que decidiste castigar tendra una penalizacion");
        //Buscar el vehiculo del usuario
        VehiculoCarrera vehiculoUsuario = null;
        for (VehiculoCarrera vehiculoCarrera : VehiculoCarrera.getListaVehiculosCarrera()) {
            if (vehiculoCarrera.getPiloto() == piloto) {
                vehiculoUsuario = vehiculoCarrera;
            }
        }
        maestroDeCarrera.setPosicionesCorruptas(VehiculoCarrera.maldecirVehiculos(vehiculoMaldito, vehiculoUsuario, pilotosDesfavorecidos, plataGanada, maestroDeCarrera));
    }

    private static void simulacionGranPrix() {
        System.out.println("Decidiste comenzar a correr las carreras. Alla vamos!");
        System.out.println("Primero, debes elegir que campeonato deseas");
        ArrayList<Campeonato> listaDesbloqueadosConCarreras = new ArrayList<Campeonato>();
        ArrayList<Piloto> pilotosDisponibles = new ArrayList<Piloto>();
        //Campeonatos desbloqueados y con carreras
        for (Campeonato campeonato : Campeonato.campeonatosDesbloqueados()) {
            if (campeonato.getListaCarreras().get(0) != null) {
                listaDesbloqueadosConCarreras.add(campeonato);
            }
        }
        tablaCampeonatos(listaDesbloqueadosConCarreras);
        System.out.println("Elije tu campeonato, campeon");
        n = validaciones(1, listaDesbloqueadosConCarreras.size());

        Campeonato campeonato = listaDesbloqueadosConCarreras.get(n - 1);

        System.out.println("Has elegido " + campeonato.getNombre());
        System.out.println("\n");

        //Pilotos elegidos del campeonato
        for (Piloto piloto : campeonato.getListaPilotos()) {
            if (piloto.isElegido()) {
                pilotosDisponibles.add(piloto);
            }
        }

        System.out.println("De acuerdo al campeonato que elejiste, estan disponibles los siguientes pilotos");
        // TODO pilotos tabla
        Tablas.tablaPilotosEquipo(pilotosDisponibles);
        System.out.println("Elige un piloto");
        n = validaciones(1, pilotosDisponibles.size());

        Piloto piloto = pilotosDisponibles.get(n - 1);

        System.out.println("Las carreras son las siguientes:");
        Tablas.tablaCarreras(campeonato);
        System.out.println("Ahora, comenzaremos a correr todas las carreras del campeonato");

        //Iniciando minifuncionalidad 1: Correr Carreras
        for (Carrera carrera : campeonato.getListaCarreras()) {
            DirectorCarrera directorCarrera = carrera.getDirectorCarrera();
            if (!directorCarrera.getPosicionesCorruptas().isEmpty()) {
                carrera.setPosiciones(directorCarrera.getPosicionesCorruptas());
            } else {
                for (VehiculoCarrera vehiculoCarrera : VehiculoCarrera.getListaVehiculosCarrera()) {
                    if (campeonato.getListaPilotos().contains(vehiculoCarrera.getPiloto())) {
                        carrera.getPosiciones().add(vehiculoCarrera);
                    }
                }
            }
            System.out.println("Comenzando la carrera: " + carrera.getNombreCircuito());
            System.out.println("En sus marcas, listos, fuera!");
            VehiculoCarrera carroElegido = null;
            for (VehiculoCarrera vehiculoCarrera : carrera.posiciones)
                if (vehiculoCarrera.getPiloto() == piloto) {
                    carroElegido = vehiculoCarrera;
                }
            double probOpciones = 0.0;
            while (!carrera.actualizarTerminado()) {
                carrera.actualizarPosiciones();
                carrera.actualizarGasolina(piloto);
                if (!carroElegido.isMorido()) {
                    System.out.println("La carrera transcurre...");
                    if (1 - probOpciones < rand.nextDouble()) {
                        System.out.println("Oh my god! Es tu momento de actuar!");
                        System.out.println("El nivel de la gasolina del vehiculo es " + carroElegido.getGasolina());
                        System.out.println("Hasta ahora, las posiciones en la carrera son las siguientes");
                        //TODO: Tabla de Posiciones
                        System.out.println("Los carros que han terminado son los siguientes");
                        //TODO: Tabla de Terminados
                        ArrayList<Boolean> listaOpciones = carrera.actualizarOpciones();
                        System.out.println("Tienes una oportunidad! Escoge una de las siguientes opciones");
                        for (int j = 0; j < 5; j++) {
                            if (listaOpciones.get(j)) {
                                switch (j) {
                                    case 0:
                                        System.out.println("1. Aprovechar DRS");
                                        break;
                                    case 1:
                                        System.out.println("2. PISA EL FRENO ESTOVAMUYRAPIDO (Debes frenar si quieres entrar a pits");
                                        break;
                                    case 2:
                                        System.out.println("3. Hacer maniobra");
                                        break;
                                    case 3:
                                        System.out.println("4. Defender Posicion");
                                        break;
                                    case 4:
                                        System.out.println("5. DERRAPAR RAAAAAAAAAAAAAAAAAAAAAAAAAAH");
                                        break;
                                }
                            }
                        }
                        if (carroElegido.getVelocidadActual() < 150) {
                            System.out.println("6. Entrar a la Pit Stop");
                        }
                        n = validaciones(1, 6);
                        switch (n) {
                            case 1:
                                System.out.println("El piloto comienza a acelerar!");
                                carroElegido.aprovecharDRS();
                                break;
                            case 2:
                                System.out.println("El carro desacelera y baja su velocidad");
                                carroElegido.frenar();
                                break;
                            case 3:
                                System.out.println("El piloto decide intentar una maniobra!");
                                carroElegido.hacerManiobra();
                                break;
                            case 4:
                                System.out.println("El piloto decide continuar como va");
                                carroElegido.defender();
                                break;
                            case 5:
                                System.out.println("El piloto intenta derrapar!");
                                carroElegido.derrapar();
                                break;
                            case 6:
                                System.out.println("Entras a la PitStop!");
                                AsciiArt.pitStop();
                                boolean estar = true;
                                while (estar) {
                                    System.out.println("Decide que hacer mientras estas en los Pits");
                                    System.out.println("1. Llenar gasolina");
                                    System.out.println("2. Reparar Auto");
                                    System.out.println("3. Ya quiero seguir manejando! (Salir)");
                                    n = validaciones(1, 3);
                                    switch (n) {
                                        case 1:
                                            carroElegido.llenarGasolina();
                                            break;
                                        case 2:
                                            if (carroElegido.repararVehiculo()) {

                                            } else {
                                                System.out.println("Tu equipo no tiene suficiente dinero! No se han podido reparar las piezas.");
                                            }
                                            break;
                                        case 3:
                                            estar = false;
                                            break;
                                    }
                                }
                                break;
                        }
                    } else {
                        probOpciones += 0.1;
                    }
                }
            }
            carrera.verificarPorChoques();
            System.out.println("La carrera ha terminado!");
            System.out.println("Los resultados de la carrera han sido los siguientes:");
            Tablas.tablaPosicionesTiempos(carrera.terminados);
            //Iniciando minifuncionalidad 2: Puntuaciones y Sanciones equipos
            System.out.println("Procederemos a puntuar a los equipos");
            if (piloto.getSanciones() != 0) {
                System.out.println("Oops, parece que el piloto " + piloto.getNombre() + " tiene sanciones.");
                System.out.println("Sin embargo, tienes la opcion de reducir el numero de las sanciones");
                System.out.println("Escribe Y o N segun lo que desees hacer");
                if (validacionesYN()) {
                    System.out.println("Esto es muy sencillo, solo escoge un numero del 1 al 5, y si es correcto, se le quitara una sancion al piloto");
                    n = validaciones(1, 5);
                    if (n == rand.nextInt(4) + 1) {
                        piloto.setSanciones(piloto.getSanciones() - 1);
                    }
                } else {
                    System.out.println("Bueno, parece que hay gente a la que que no le gusta tomar las oportunidades~");
                }
            }
            Equipo.puntuarEquipos(carrera.terminados, carrera.getPremioEfectivo(), campeonato);
            //TODO: Tabla de puntos: Tabla que muestre los equipos del campeonato con los puntos
        }
        System.out.println("Se han acabado todas las carreras!");
        System.out.println("Es momento del gran final...");
        System.out.println("La premiacion del campeonato!");
        System.out.println("Nos compleace presentarte, la puntacion final de los equipos del campeonato!");
        //TODO: Tabla de puntos: Tabla que muestre los equipos del campeonato con los puntos
        ArrayList<Equipo> equiposPuntuados = Equipo.organizarEquiposPuntos(campeonato);
        //Iniciando minifuncionalidad 3: Premiacion del Campeonato
        campeonato.premiarCampeones(equiposPuntuados); //TODO: FALTA COMPLEJIDAD
        //TODO: BORRAR INDICIOS DE CAMPEONATO
    }

    private static int validaciones(int min, int max) {
        boolean validaciones = false;
        while (!validaciones) {
            opcion = sc.nextInt();
            if (opcion < min || opcion > max) {
                // Imprimir mensaje de error
                System.out.println("Por favor, escribe un numero del " + min + " al " + max);
            } else {
                validaciones = true;
            }
        }
        return opcion;
    }

    private static int validaciones(int min, BigInteger max) {
        BigInteger op = BigInteger.valueOf(0);
        boolean validaciones = false;
        while (!validaciones) {
            op = sc.nextBigInteger();
            if (op.compareTo(BigInteger.valueOf(min)) < 0 || op.compareTo(max) > 0) {
                // Imprimir mensaje de error
                System.out.println("Por favor, escribe un numero del " + min + " al " + max);
            } else {
                validaciones = true;
            }
        }
        return opcion;
    }

    private static boolean validacionesYN() {
        boolean validaciones = false;
        boolean decision = false;
        while (!validaciones) {
            opcionYN = sc.nextLine().toUpperCase();
            if (opcionYN.equals("Y")) {
                decision = true;
                validaciones = true;
            } else if (opcionYN.equals("N")) {
                decision = false;
                validaciones = true;
            } else {
                System.out.println("Por favor, escribe Y o N");
            }
        }
        return decision;
    }

    private static void dineroSuficiente(Persona persona) {
        if (persona.getPlata() < 10000) {
            System.out.println("No habia dinero suficiente pero la abuela de " + persona.getNombre() + " ha muerto y le ha dejado una herencia");
            persona.sinPlata();
        }
    }

    private static void dineroSuficiente(Persona persona, double dinero) {
        if (persona.getPlata() < dinero) {
            System.out.println("No habia dinero suficiente pero la abuela de " + persona.getNombre() + " ha muerto y le ha dejado una herencia");
            persona.sinPlata();
        }
    }
}