package baseDatos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;
import uiMain.CrearObjetos;

public class Serializado {

	
        static {
        CrearObjetos.crearObjetos();
    }

    public static void main(String[] args) throws IOException{

	////////////////////////// CAMPEONATOS  //////////////////////////
		
    FileOutputStream fileOutputStream1 = new FileOutputStream("src\\baseDatos\\temp\\datosCampeonatos.txt");
    ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
        
    objectOutputStream1.writeObject(Campeonato.campeonatos);
        
    objectOutputStream1.close();
    fileOutputStream1.close();

    ////////////////////////// CIUDADES  //////////////////////////
    
    FileOutputStream fileOutputStream2 = new FileOutputStream("src\\baseDatos\\temp\\datosCiudades.txt");
    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
        
    objectOutputStream2.writeObject(Ciudad.listaCiudades);
        
    objectOutputStream2.close();
    fileOutputStream2.close();


    ////////////////////////// DIRECTORES  //////////////////////////
    
    FileOutputStream fileOutputStream3 = new FileOutputStream("src\\baseDatos\\temp\\datosDirectores.txt");
    ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(fileOutputStream3);
        
    objectOutputStream3.writeObject(DirectorCarrera.listaDirectores);
        
    objectOutputStream3.close();
    fileOutputStream3.close();


    ////////////////////////// EQUIPOS  //////////////////////////

    
    FileOutputStream fileOutputStream4 = new FileOutputStream("src\\baseDatos\\temp\\datosEquipos.txt");
    ObjectOutputStream objectOutputStream4 = new ObjectOutputStream(fileOutputStream4);
        
    objectOutputStream4.writeObject(Equipo.equipos);
        
    objectOutputStream4.close();
    fileOutputStream4.close();

    ////////////////////////// PATROCINADORES  //////////////////////////

    FileOutputStream fileOutputStream5 = new FileOutputStream("src\\baseDatos\\temp\\datosPatrocinadores.txt");
    ObjectOutputStream objectOutputStream5 = new ObjectOutputStream(fileOutputStream5);
        
    objectOutputStream5.writeObject(Patrocinador.listaPatrocinadores);
        
    objectOutputStream5.close();
    fileOutputStream5.close();


    ////////////////////////// PIEZAS  //////////////////////////

    
    FileOutputStream fileOutputStream6 = new FileOutputStream("src\\baseDatos\\temp\\datosPiezas.txt");
    ObjectOutputStream objectOutputStream6 = new ObjectOutputStream(fileOutputStream6);
        
    objectOutputStream6.writeObject(Pieza.getPiezas());
    
        
    objectOutputStream6.close();
    fileOutputStream6.close();

    ////////////////////////// PIEZAS CONTRABANDO  //////////////////////////

    FileOutputStream fileOutputStream7 = new FileOutputStream("src\\baseDatos\\temp\\datosPiezasContrabando.txt");
    ObjectOutputStream objectOutputStream7 = new ObjectOutputStream(fileOutputStream7);
        
    objectOutputStream7.writeObject(Pieza.getPiezasContrabando());
        
    objectOutputStream7.close();
    fileOutputStream7.close();

    ////////////////////////// PILOTOS  //////////////////////////
    
    
    FileOutputStream fileOutputStream8 = new FileOutputStream("src\\baseDatos\\temp\\datosPilotos.txt");
    ObjectOutputStream objectOutputStream8 = new ObjectOutputStream(fileOutputStream8);
        
    objectOutputStream8.writeObject(Piloto.listaPilotos);
        
    objectOutputStream8.close();
    fileOutputStream8.close();


    ////////////////////////// VEHICULOS  //////////////////////////
    
    FileOutputStream fileOutputStream9 = new FileOutputStream("src\\baseDatos\\temp\\datosVehiculos.txt");
    ObjectOutputStream objectOutputStream9 = new ObjectOutputStream(fileOutputStream9);
        
    objectOutputStream9.writeObject(VehiculoCarrera.listaVehiculos);
        
    objectOutputStream9.close();
    fileOutputStream9.close();

    }

}

