package baseDatos;

import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;

import java.util.ArrayList;

public class Deserializado {

    public static void deserializacion() {


        //////////////////////////CAMPEONATOS  //////////////////////////

        ArrayList<Campeonato> campeonatos = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosCampeonatos.txt");

        Campeonato.setCampeonatos(campeonatos);


        ////////////////////////// CIUDADES  //////////////////////////

        ArrayList<Ciudad> ciudades = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosCiudades.txt");

        Ciudad.setListaCiudades(ciudades);


        ////////////////////////// DIRECTORES  //////////////////////////

        ArrayList<DirectorCarrera> directoresCarrera = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosDirectores.txt");


        DirectorCarrera.setListaDirectores(directoresCarrera);


        ////////////////////////// EQUIPOS  //////////////////////////

        ArrayList<Equipo> equipos = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosEquipos.txt");

        Equipo.setEquipos(equipos);


        ////////////////////////// PATROCINADORES  //////////////////////////

        ArrayList<Patrocinador> patrocinadores = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosPatrocinadores.txt");

        Patrocinador.setListaPatrocinadores(patrocinadores);


        ////////////////////////// PIEZAS  //////////////////////////

        ArrayList<Pieza> piezas = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosPiezas.txt");

        Pieza.setPiezas(piezas);


        ////////////////////////// VEHICULO CARRERA  //////////////////////////

        ArrayList<VehiculoCarrera> vehiculosCarrera = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosVehiculos.txt");

        VehiculoCarrera.setListaVehiculosCarrera(vehiculosCarrera);


        ////////////////////////// PILOTOS  //////////////////////////

        ArrayList<Piloto> pilotos = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosPilotos.txt");

        Piloto.setListaPilotos(pilotos);


        ////////////////////////// CHASIS  //////////////////////////

        ArrayList<Chasis> chasis = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosChasis.txt");

        Chasis.setListaChasis(chasis);

        ////////////////////////// CIRCUITOS  //////////////////////////

        ArrayList<Circuito> circuitos = DeserializadoGenerico.deserializarObjetos("src\\baseDatos\\temp\\datosCircuitos.txt");

        Circuito.setCircuitos(circuitos);


    }
}