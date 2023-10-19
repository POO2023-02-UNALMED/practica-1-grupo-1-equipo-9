package baseDatos;

import java.util.ArrayList;
import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;

public class Deserializado {

	public static void main(String[] args) {
		
		
		//////////////////////////CAMPEONATOS  //////////////////////////
		
	    ArrayList<Campeonato> campeonatos = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosCampeonatos.txt");

	    if (campeonatos != null) {
	        for (Campeonato campeonato : campeonatos) {
	        	System.out.println(campeonato);
	        }
	    }
	    
	    ////////////////////////// CIUDADES  //////////////////////////
	    
	    ArrayList<Ciudad> ciudades = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosCiudades.txt");

	    if (ciudades != null) {
	        for (Ciudad ciudad : ciudades) {
	        	System.out.println(ciudad);	        }
	    }
	    
	    ////////////////////////// DIRECTORES  //////////////////////////
	    
	    ArrayList<DirectorCarrera> directoresCarrera = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosDirectores.txt");

	    if (directoresCarrera != null) {
	        for (DirectorCarrera directorCarrera : directoresCarrera) {
	        	System.out.println(directorCarrera);	        }
	    }
	    
	    ////////////////////////// EQUIPOS  //////////////////////////
	    
	    ArrayList<Equipo> equipos = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosEquipos.txt");

	    if (equipos != null) {
	        for (Equipo equipo : equipos) {
	        	System.out.println(equipo);	        }
	    }
	    
	    ////////////////////////// PATROCINADORES  //////////////////////////

	    ArrayList<Patrocinador> patrocinadores = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosPatrocinadores.txt");

	    if (patrocinadores != null) {
	        for (Patrocinador patrocinador : patrocinadores) {
	        	System.out.println(patrocinador);	        }
	    }  
	    
	    ////////////////////////// PIEZAS  //////////////////////////
	    
	    ArrayList<Pieza> piezas = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosPiezas.txt");

	    if (piezas != null) {
	        for (Pieza pieza : piezas) {
	        	System.out.println(pieza);	        }
	    }
	    
	    ////////////////////////// PIEZAS CONTRABANDO  //////////////////////////
	    
	    ArrayList<Pieza> piezasContrabando = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosPiezasContrabando.txt");

	    if (piezasContrabando != null) {
	    	for (Pieza piezaContrabando : piezasContrabando) {
	    		System.out.println(piezaContrabando);	    	}
	    }	    
	    
	    ////////////////////////// PILOTOS  //////////////////////////
	    
	    ArrayList<Piloto> pilotos = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosPilotos.txt");

	    if (pilotos != null) {
	        for (Piloto piloto : pilotos) {
	        	System.out.println(piloto);	        }
	    }

	    ////////////////////////// VEHICULOS  //////////////////////////

	    ArrayList<VehiculoCarrera> vehiculosCarrera = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosVehiculos.txt");

	    if (vehiculosCarrera != null) {
	        for (VehiculoCarrera vehiculoCarrera : vehiculosCarrera) {
	        	System.out.println(vehiculoCarrera);
	        }
	    }
	    
	    
	    
	}
}