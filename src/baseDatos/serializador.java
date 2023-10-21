package baseDatos;

import java.io.*;
import java.util.ArrayList;

import gestorAplicacion.campeonato.Campeonato;
import gestorAplicacion.campeonato.Ciudad;
import gestorAplicacion.campeonato.DirectorCarrera;
import gestorAplicacion.campeonato.Equipo;
import gestorAplicacion.campeonato.VehiculoCarrera;
import gestorAplicacion.paddock.Chasis;
import gestorAplicacion.paddock.Circuito;
import gestorAplicacion.paddock.Patrocinador;
import gestorAplicacion.paddock.Pieza;
import gestorAplicacion.paddock.Piloto;

public class serializador {

    static PrintWriter pw;

    public static void serializar(){

        		
        //////////////////////////CAMPEONATOS  //////////////////////////

        try {

        pw = new PrintWriter("src\\baseDatos\\temp\\datosCampeonatos.txt");

        FileOutputStream fileOutputStream1 = new FileOutputStream("src\\baseDatos\\temp\\datosCampeonatos.txt");
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);

        objectOutputStream1.writeObject(Campeonato.campeonatos);

        objectOutputStream1.close();
        fileOutputStream1.close();

        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException e1) {
        e1.printStackTrace();
        }


        ////////////////////////// CIUDADES  //////////////////////////

        try {

        pw = new PrintWriter("src\\baseDatos\\temp\\datosCiudades.txt");

        FileOutputStream fileOutputStream2 = new FileOutputStream("src\\baseDatos\\temp\\datosCiudades.txt");
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);

        objectOutputStream2.writeObject(Ciudad.listaCiudades);

        objectOutputStream2.close();
        fileOutputStream2.close();

        } catch (FileNotFoundException e2) {
        e2.printStackTrace();
        } catch (IOException e3) {
        e3.printStackTrace();
        }

        ////////////////////////// DIRECTORES  //////////////////////////

        try {

        pw = new PrintWriter("src\\baseDatos\\temp\\datosDirectores.txt");

        FileOutputStream fileOutputStream3 = new FileOutputStream("src\\baseDatos\\temp\\datosDirectores.txt");
        ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(fileOutputStream3);


        objectOutputStream3.writeObject(DirectorCarrera.listaDirectores);

        objectOutputStream3.close();
        fileOutputStream3.close();

        } catch (FileNotFoundException e4) {
        e4.printStackTrace();
        } catch (IOException e5) {
        e5.printStackTrace();
        }

	    
	    ////////////////////////// EQUIPOS  //////////////////////////
	    
	    try {

        pw = new PrintWriter("src\\baseDatos\\temp\\datosEquipos.txt");

        FileOutputStream fileOutputStream4 = new FileOutputStream("src\\baseDatos\\temp\\datosEquipos.txt");
        ObjectOutputStream objectOutputStream4 = new ObjectOutputStream(fileOutputStream4);

        objectOutputStream4.writeObject(Equipo.equipos);

        objectOutputStream4.close();
        fileOutputStream4.close();

        } catch (FileNotFoundException e6) {
        e6.printStackTrace();
        } catch (IOException e7) {
        e7.printStackTrace();
        }
	    

	    ////////////////////////// PATROCINADORES  //////////////////////////

        try {

        pw = new PrintWriter("src\\baseDatos\\temp\\datosPatrocinadores.txt");

        FileOutputStream fileOutputStream5 = new FileOutputStream("src\\baseDatos\\temp\\datosPatrocinadores.txt");
        ObjectOutputStream objectOutputStream5 = new ObjectOutputStream(fileOutputStream5);

        objectOutputStream5.writeObject(Patrocinador.listaPatrocinadores);

        objectOutputStream5.close();
        fileOutputStream5.close();

        } catch (FileNotFoundException e8) {
        e8.printStackTrace();
        } catch (IOException e9) {
        e9.printStackTrace();
        }

	    
	    ////////////////////////// PIEZAS  //////////////////////////

        try {

        pw = new PrintWriter("src\\baseDatos\\temp\\datosPiezas.txt");

        FileOutputStream fileOutputStream6 = new FileOutputStream("src\\baseDatos\\temp\\datosPiezas.txt");
        ObjectOutputStream objectOutputStream6 = new ObjectOutputStream(fileOutputStream6);

        objectOutputStream6.writeObject(Pieza.getPiezas());

        objectOutputStream6.close();
        fileOutputStream6.close();

        } catch (FileNotFoundException e10) {
        e10.printStackTrace();
        } catch (IOException e11) {
        e11.printStackTrace();
        }

	    
	   ////////////////////////// VEHICULO CARRERA  /////////////////////////

        try {

        pw = new PrintWriter("src\\baseDatos\\temp\\datosVehiculos.txt");

        FileOutputStream fileOutputStream7 = new FileOutputStream("src\\baseDatos\\temp\\datosVehiculos.txt");
        ObjectOutputStream objectOutputStream7 = new ObjectOutputStream(fileOutputStream7);

        objectOutputStream7.writeObject(VehiculoCarrera.listaVehiculos);

        objectOutputStream7.close();
        fileOutputStream7.close();

        } catch (FileNotFoundException e12) {
        e12.printStackTrace();
        } catch (IOException e13) {
        e13.printStackTrace();
        }
       

	    
	    ////////////////////////// PILOTOS  //////////////////////////

        try {

        pw = new PrintWriter("src\\baseDatos\\temp\\datosPilotos.txt");

        FileOutputStream fileOutputStream8 = new FileOutputStream("src\\baseDatos\\temp\\datosPilotos.txt");
        ObjectOutputStream objectOutputStream8 = new ObjectOutputStream(fileOutputStream8);

        objectOutputStream8.writeObject(Piloto.listaPilotos);

        objectOutputStream8.close();
        fileOutputStream8.close();

        } catch (FileNotFoundException e12) {
        e12.printStackTrace();
        } catch (IOException e13) {
        e13.printStackTrace();
        }
	    

	    ////////////////////////// CHASIS  //////////////////////////

        try {

        pw = new PrintWriter("src\\baseDatos\\temp\\datosChasis.txt");

        FileOutputStream fileOutputStream9 = new FileOutputStream("src\\baseDatos\\temp\\datosChasis.txt");
        ObjectOutputStream objectOutputStream9 = new ObjectOutputStream(fileOutputStream9);

        objectOutputStream9.writeObject(Chasis.listaChasis);

        objectOutputStream9.close();
        fileOutputStream9.close();

        } catch (FileNotFoundException e14) {
        e14.printStackTrace();
        } catch (IOException e15) {
        e15.printStackTrace();
        }

    

		////////////////////////// CIRCUITOS  //////////////////////////

        try {

        pw = new PrintWriter("src\\baseDatos\\temp\\datosCircuitos.txt");

        FileOutputStream fileOutputStream11 = new FileOutputStream("src\\baseDatos\\temp\\datosCircuitos.txt");
        ObjectOutputStream objectOutputStream11 = new ObjectOutputStream(fileOutputStream11);

        objectOutputStream11.writeObject(Circuito.getCircuitos());

        objectOutputStream11.close();
        fileOutputStream11.close();

        } catch (FileNotFoundException a16) {
        a16.printStackTrace();
        } catch (IOException a17) {
        a17.printStackTrace();

        }
    }
    
}

