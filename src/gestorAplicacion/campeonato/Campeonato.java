package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Patrocinador;
import gestorAplicacion.paddock.Piloto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.DoubleUnaryOperator;

public class Campeonato implements Serializable, Decimales {

    /**
     * Esta clase representa un campeonato, el cual tiene una lista de carreras, una lista de equipos, una lista de pilotos, un id, un nombre, un a�o, un continente, una cantidad de carreras, un premio y un booleano que indica si el campeonato esta desbloqueado o no.
     **/

    private static final long serialVersionUID = -2490361864090903222L;
    public static ArrayList<Campeonato> campeonatos = new ArrayList<Campeonato>(); //Esta es la lista donde est�n todos los campeonatos disponibles
    private static int idActual = 1;

    // Atributos
    private static int ano = 2023;
    private ArrayList<Carrera> listaCarreras = new ArrayList<Carrera>(); //Cuando se escoja el campeonato, en esta lista se colocan las carreras

    private ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>(); //Lista de equipos que participan en el campeonato
    private ArrayList<Piloto> listaPilotos = new ArrayList<Piloto>(); //Lista de pilotos que participan en el campeonato
    private int id;
    private String nombre;
    private Continente continente; //Cada campeonato tiene un continente diferente
    private int cantCarreras;
    private double premio; //Premio total que se lleva el equipo cuando se gana el campeonato
    private boolean desbloqueado = false; //Si el campeonato esta desbloqueado, se puede jugar
    private boolean jugado = false;
    private Patrocinador patrocinadorCampeonato;
    private ArrayList<Integer> mesesCarreras = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));

    {
        this.redondear();
    }

    public Campeonato(ArrayList<Carrera> listaCarreras, ArrayList<Equipo> listaEquipos, ArrayList<Piloto> listaPilotos, int id, String nombre, int ano, Continente continente, int cantCarreras, double premio, boolean desbloqueado) {
        this.listaCarreras = listaCarreras;
        this.listaEquipos = listaEquipos;
        this.listaPilotos = listaPilotos;
        this.id = id;
        this.nombre = nombre;
        this.continente = continente;
        this.cantCarreras = cantCarreras;
        this.premio = premio;
        this.desbloqueado = desbloqueado;
        this.patrocinadorCampeonato = Patrocinador.listaPatrocinadores.get(new Random().nextInt(Patrocinador.listaPatrocinadores.size()));
        patrocinadorCampeonato.setPatrocinadorCampeonato();
        campeonatos.add(this);
    }

    public Campeonato(ArrayList<Carrera> listaCarreras, ArrayList<Equipo> listaEquipos, ArrayList<Piloto> listaPilotos, int id, String nombre, Continente continente, int cantCarreras, double premio, boolean desbloqueado, Patrocinador patrocinadorCampeonato) {
        this.listaCarreras = listaCarreras;
        this.listaEquipos = listaEquipos;
        this.listaPilotos = listaPilotos;
        this.id = id;
        this.nombre = nombre;
        this.continente = continente;
        this.cantCarreras = cantCarreras;
        this.premio = premio;
        this.desbloqueado = desbloqueado;
        this.patrocinadorCampeonato = patrocinadorCampeonato;
        campeonatos.add(this);
    }

    public Campeonato(String nombre, int cantCarrera, Continente continente) {
        Random rand = new Random();
        this.id = idActual++;
        this.nombre = nombre;
        this.cantCarreras = rand.nextInt(3) + 4;
        this.continente = continente;
        this.desbloqueado = false;
        campeonatos.add(this);
        this.patrocinadorCampeonato = Patrocinador.listaPatrocinadores.get(new Random().nextInt(Patrocinador.listaPatrocinadores.size()));
        patrocinadorCampeonato.setPatrocinadorCampeonato();
    }

    public Campeonato(String nombre, Continente continente) {
        Random rand = new Random();
        this.id = idActual++;
        this.nombre = nombre;
        this.cantCarreras = rand.nextInt(5) + 5;
        this.continente = continente;
        this.desbloqueado = false;
        campeonatos.add(this);
        this.patrocinadorCampeonato = Patrocinador.listaPatrocinadores.get(new Random().nextInt(Patrocinador.listaPatrocinadores.size()));
        patrocinadorCampeonato.setPatrocinadorCampeonato();
    }

    // Metodos de instancia

    public static int idActual() {
        return idActual++;
    }

    //Metodos de clase
    public static ArrayList<Campeonato> campeonatosContinente(Continente continente) {
        ArrayList<Campeonato> campeonatosContinente = new ArrayList<Campeonato>();
        for (Campeonato campeonato : campeonatos) {
            if (campeonato.getContinente() == continente) {
                campeonatosContinente.add(campeonato);
            }
        }
        return campeonatosContinente;
    }

    public static Campeonato buscarCampeonato(int id) {
        Campeonato campeonato = null;
        for (Campeonato campeonato1 : campeonatos) {
            if (campeonato1.getId() == id) {
                campeonato = campeonato1;
            }
        }
        return campeonato;
    }

    public static ArrayList<Campeonato> campeonatosDisponibles(ArrayList<Campeonato> campeonatos) {
        ArrayList<Campeonato> campeonatosDisponibles = new ArrayList<Campeonato>();
        for (Campeonato campeonato : campeonatos) {
            if (!campeonato.isDesbloqueado() && !campeonato.isJugado()) {
                campeonatosDisponibles.add(campeonato);
            }
        }
        return campeonatosDisponibles;
    }

    public static ArrayList<Campeonato> campeonatosDesbloqueados() {
        ArrayList<Campeonato> campeonatosDesbloqueados = new ArrayList<Campeonato>();
        for (Campeonato campeonato : campeonatos) {
            if (campeonato.isDesbloqueado() && !campeonato.isJugado()) {
                campeonatosDesbloqueados.add(campeonato);
            }
        }
        return campeonatosDesbloqueados;
    }

    public static Campeonato campeonatoPiloto(Piloto piloto) {
        Campeonato campeonatoElegido = null;
        for (Campeonato campeonato : Campeonato.campeonatosDesbloqueados()) {
            for (Piloto pilotico : campeonato.getListaPilotos()) {
                if (pilotico.isElegido() && pilotico.equals(piloto)) {
                    campeonatoElegido = campeonato;
                    break;
                }
            }
            if (campeonatoElegido != null) {
                break;
            }
        }
        return campeonatoElegido;
    }

    public static ArrayList<DirectorCarrera> directoresCarrera(Campeonato campeonatoElegido) {
        ArrayList<DirectorCarrera> maestrosDeCarrera = new ArrayList<DirectorCarrera>();
        for (Carrera carrera : campeonatoElegido.getListaCarreras()) {
            maestrosDeCarrera.add(carrera.getDirectorCarrera());
        }
        ArrayList<DirectorCarrera> maestrosDeCarreraDiferentes = new ArrayList<DirectorCarrera>();
        for (DirectorCarrera directorCarrera : maestrosDeCarrera) {
            if (!maestrosDeCarreraDiferentes.contains(directorCarrera)) {
                maestrosDeCarreraDiferentes.add(directorCarrera);
            }
        }
        return maestrosDeCarreraDiferentes;
    }

    public static int getIdActual() {
        return idActual;
    }

    public static void setIdActual(int idActual) {
        Campeonato.idActual = idActual;
    }

    public static ArrayList<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public static void setCampeonatos(ArrayList<Campeonato> campeonatos) {
        Campeonato.campeonatos = campeonatos;
    }

    public void premiarCampeones(ArrayList<Equipo> equiposPuntuados) {
        this.listaEquipos = equiposPuntuados;
        double multiplicadorDinero = 1.2;
        double contadorHabilidad = 0.08;
        for (Equipo equipo : equiposPuntuados) {
            equipo.setPlata(equipo.getPlata() + this.premio * multiplicadorDinero);
            if (!equipo.getPatrocinadoresEquipo().isEmpty()) {
                for (Patrocinador patrocinador : equipo.getPatrocinadoresEquipo()) {
                    patrocinador.recibirPlata(this.premio * multiplicadorDinero / 2);
                }
            }
            if (multiplicadorDinero > 0.2) {
                multiplicadorDinero -= 0.2;
            }
            for (Piloto piloto : this.getListaPilotos()) {
                if (piloto.getEquipo().equals(equipo) && piloto.getPuntos() != 0 && equiposPuntuados.get(0).equals(equipo)) {
                    piloto.setHabilidad(contadorHabilidad);
                    piloto.agregarVictoria(this);
                }else if (piloto.getEquipo().equals(equipo) && piloto.getPuntos() != 0) {
                    piloto.setHabilidad(contadorHabilidad);
                }
                if (contadorHabilidad>0.02){
                    contadorHabilidad-=0.01;
                }
            }
        }
    }

    public String toString() {
        return (this.nombre + " " + ano + " (" + this.continente.toString() + ")");
    }

    public void agregarCarrera(Carrera carrerita) {
        if (this.getNumCarreras() < this.cantCarreras) {
            this.listaCarreras.add(carrerita);
        }
    }

    public ArrayList<Carrera> carrerasPreferidas() {
        ArrayList<Carrera> carrerasPreferidas = new ArrayList<Carrera>();
        for (Carrera carrera : this.listaCarreras) {
            // Ciudad en las ciudades preferidas del patrocinador de campeonato
            if (this.patrocinadorCampeonato.getCiudadesPreferidas().contains(carrera.getCiudad())) {
                carrerasPreferidas.add(carrera);
            }
        }
        return carrerasPreferidas;
    }

    public void organizarCarreras() {
        // Organizar carreras de acuerdo a la fecha
        this.listaCarreras.sort(new Comparator<Carrera>() {
            @Override
            public int compare(Carrera carrera1, Carrera carrera2) {
                return carrera1.getFecha().compareTo(carrera2.getFecha());
            }
        });
        this.listaCarreras.sort(Comparator.comparing(Carrera::getMes));
    }

    public void actualizarMesCarreras(int mes) {
        this.mesesCarreras.removeIf(num -> num == mes);
    }

    public void logisticaPremios(double premio, double presupuesto, ArrayList<Carrera> carrerasPreferidas) {
        Patrocinador patrocinador = this.patrocinadorCampeonato;
        if (patrocinador.getPlata() / 2 > premio) {
            this.premio = patrocinador.getPlata() / 2;
            // cobrar
            patrocinador.setPlata(patrocinador.getPlata() - this.premio);
        } else {
            this.premio = premio;
            // cobrar
            patrocinador.setPlata(patrocinador.getPlata() - this.premio);
        }
        // presupuesto
        int pesoTotal = 0;
        for (Carrera carrera : this.listaCarreras) {
            if (!carrerasPreferidas.isEmpty()) {
                if (carrerasPreferidas.contains(carrera)) {
                    // si es preferida el peso es el doble
                    pesoTotal += carrera.getDificultad() * 2;
                }
            }
            pesoTotal += carrera.getDificultad();
        }
        int finalPesoTotal = pesoTotal;
        DoubleUnaryOperator calculatePercentage = (val) -> (val / finalPesoTotal);
        for (Carrera carrera : this.listaCarreras) {
            if (!carrerasPreferidas.isEmpty()) {
                if (carrerasPreferidas.contains(carrera)) {
                    // si es preferida el premio es el doble
                    carrera.setPremioEfectivo(calculatePercentage.applyAsDouble(carrera.getDificultad() * 2) * presupuesto);
                }
            }
            carrera.setPremioEfectivo(calculatePercentage.applyAsDouble(carrera.getDificultad()) * presupuesto);
        }
        // cobrar patrocinador
        patrocinador.setPlata(patrocinador.getPlata() - presupuesto);
        this.organizarCarreras();
    }

    public Piloto pilotoCampeonato() {
        Piloto piloto = null;
        for (Piloto pilotico : this.getListaPilotos()) {
            if (pilotico.isElegido()) {
                piloto = pilotico;
                break;
            }
        }
        return piloto;
    }

    public void redondear() {
        this.premio = dosDecimales(this.premio);
    }

    //Lista de metodos set y get
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        Campeonato.ano = ano;
    }

    public Continente getContinente() {
        return this.continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    public int getCantidadMaxCarreras() {
        return this.cantCarreras;
    }

    public void setCantidadMaxCarreras(int cantidadCarreras) {
        this.cantCarreras = cantidadCarreras;
    }

    public int getNumCarreras() {
        return this.listaCarreras.size();
    }

    public double getPremio() {
        return this.premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public ArrayList<Carrera> getListaCarreras() {
        return this.listaCarreras;
    }

    public void setListaCarreras(ArrayList<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    public boolean isDesbloqueado() {
        return desbloqueado;
    }

    public void setDesbloqueado(boolean desbloqueado) {
        this.desbloqueado = desbloqueado;
    }

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public ArrayList<Piloto> getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(ArrayList<Piloto> listaPilotos) {
        ArrayList<Piloto> listaPilotosElegidos = new ArrayList<Piloto>();
        // Revisar que los nombres de los pilotos sean diferentes
        for (Piloto piloto : listaPilotos) {
            if (!listaPilotosElegidos.contains(piloto)) {
                listaPilotosElegidos.add(piloto);
            }
        }
        this.listaPilotos = listaPilotos;
    }

    public int getCantCarreras() {
        return cantCarreras;
    }

    public void setCantCarreras(int cantCarreras) {
        this.cantCarreras = cantCarreras;
    }

    public Patrocinador getPatrocinadorCampeonato() {
        return patrocinadorCampeonato;
    }

    public void setPatrocinadorCampeonato(Patrocinador patrocinadorCampeonato) {
        this.patrocinadorCampeonato = patrocinadorCampeonato;
    }

    public ArrayList<Integer> getMesesCarreras() {
        return mesesCarreras;
    }

    public void setMesesCarreras(ArrayList<Integer> mesesCarreras) {
        this.mesesCarreras = mesesCarreras;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }
}
