package baseDatos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;

public class Serializado {

	public static void serializarCampeonatos(ArrayList<Campeonato> campeonato) throws IOException {
		
		FileOutputStream fileOutputStream = new FileOutputStream("src\\baseDatos\\temp.txt");
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    	    
    	objectOutputStream.writeObject(campeonato);
    	    
    	objectOutputStream.close();
    	fileOutputStream.close();
	}
	
	public static void serializarCiudades(ArrayList<Ciudad> ciudad) throws IOException {
		
		FileOutputStream fileOutputStream = new FileOutputStream("src\\baseDatos\\temp.txt");
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    	    
    	objectOutputStream.writeObject(ciudad);
    	    
    	objectOutputStream.close();
    	fileOutputStream.close();
	}
	
	public static void serializarDirectores(ArrayList<DirectorCarrera> directorCarrera) throws IOException {
		
		FileOutputStream fileOutputStream = new FileOutputStream("src\\baseDatos\\temp.txt");
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    	    
    	objectOutputStream.writeObject(directorCarrera);
    	    
    	objectOutputStream.close();
    	fileOutputStream.close();
	}
	
	public static void serializarEquipos(ArrayList<Equipo> equipos) throws IOException {
		
		FileOutputStream fileOutputStream = new FileOutputStream("src\\baseDatos\\temp.txt");
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    	    
    	objectOutputStream.writeObject(equipos);
    	    
    	objectOutputStream.close();
    	fileOutputStream.close();
	}
	
	public static void serializarPatrocinadores(ArrayList<Patrocinador> patrocinadores) throws IOException {
		
		FileOutputStream fileOutputStream = new FileOutputStream("src\\baseDatos\\temp.txt");
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    	    
    	objectOutputStream.writeObject(patrocinadores);
    	    
    	objectOutputStream.close();
    	fileOutputStream.close();
	}
	
	public static void serializarPiezas(ArrayList<Pieza> piezas) throws IOException {
		
		FileOutputStream fileOutputStream = new FileOutputStream("src\\baseDatos\\temp.txt");
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    	    
    	objectOutputStream.writeObject(piezas);
    	    
    	objectOutputStream.close();
    	fileOutputStream.close();
	}
	
	public static void serializarPiezasContrabando(ArrayList<Pieza> piezasContrabando) throws IOException {
		
		FileOutputStream fileOutputStream = new FileOutputStream("src\\baseDatos\\temp.txt");
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    	    
    	objectOutputStream.writeObject(piezasContrabando);
    	    
    	objectOutputStream.close();
    	fileOutputStream.close();
	}
	
	public static void serializarPilotos(ArrayList<Piloto> pilotos) throws IOException {
		
		FileOutputStream fileOutputStream = new FileOutputStream("src\\baseDatos\\temp.txt");
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    	    
    	objectOutputStream.writeObject(pilotos);
    	    
    	objectOutputStream.close();
    	fileOutputStream.close();
	}
	
	public static void serializarVehiculos(ArrayList<Chasis> vehiculos) throws IOException {
		
		FileOutputStream fileOutputStream = new FileOutputStream("src\\baseDatos\\temp.txt");
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    	    
    	objectOutputStream.writeObject(vehiculos);
    	    
    	objectOutputStream.close();
    	fileOutputStream.close();
	}
}
