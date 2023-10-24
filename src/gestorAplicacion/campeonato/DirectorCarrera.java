package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Persona;
import gestorAplicacion.paddock.Piloto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DirectorCarrera extends Persona implements Decimales, Serializable {
    /**
     * Autores: David Toro Arboleda, Santiago Lopez Ayala, Juan Andres Jimenez Velez, Mariana Valencia Cubillos, Samuel Mira Alvarez
     * Finalidad: Descripcion de la clase: Esta clase representa al director de carrera, el cual tiene una licencia, una carrera la cual dirige y un atributo de corripción, los directores de carreras 
     * se encargan de gestionar los fraudes que pueden ser implementados en las carreras. 
     **/
    private static final long serialVersionUID = -2602637847133906292L;
    //Lista directores de carrera
    public static ArrayList<DirectorCarrera> listaDirectores = new ArrayList<DirectorCarrera>();
    static Random random = new Random();
    private boolean licencia;
    private Carrera carrera;
    private int corrupcion;

    private ArrayList<VehiculoCarrera> posicionesCorruptas = new ArrayList<VehiculoCarrera>();

    // Constructores
    public DirectorCarrera() {
        super();
    }

    public DirectorCarrera(String nombre, double plata, boolean licencia, Carrera carrera) {
        super(nombre, plata);
        this.licencia = licencia;
        this.carrera = carrera;
        DirectorCarrera.listaDirectores.add(this);
    }

    public DirectorCarrera(String nombre, String pais, double plata, boolean licencia) {
        super(nombre, pais, plata);
        this.licencia = licencia;
        this.corrupcion = 0;
        DirectorCarrera.listaDirectores.add(this);
    }

    public DirectorCarrera(String nombre) {
        super(nombre, random.nextDouble(40001) + 10000);
        this.licencia = true;
        this.corrupcion = 0;
        DirectorCarrera.listaDirectores.add(this);
    }

    public DirectorCarrera(String nombre, String pais, double plata, boolean licencia, Carrera carrera, int corrupcion) {
        super(nombre, pais);
        this.licencia = licencia;
        this.carrera = carrera;
        this.corrupcion = corrupcion;
        DirectorCarrera.listaDirectores.add(this);
    }
    //Metodo abstracto heredado

    public static ArrayList<DirectorCarrera> dcDisponibles() {
	/*
     * Descripcion del metodo: Este metodo filtra los directores de carrera con licencia de la lista de directores de carrera creados y crea una lista con los filtrados.
     * Parametros de entrada: null
     * Parametros de salida: ArrayList<DirectorCarrera>
     */
        ArrayList<DirectorCarrera> disponibles = new ArrayList<DirectorCarrera>();
        for (DirectorCarrera dc : DirectorCarrera.listaDirectores) {
            if (dc.isLicencia()) {
                disponibles.add(dc);
            }
        }
        return disponibles;
    }

    {
        List<String> paises = new ArrayList<>();
        paises.add("Estados Unidos");
        paises.add("Canada");
        paises.add("Reino Unido");
        paises.add("Francia");
        paises.add("Alemania");
        paises.add("Japon");
        paises.add("China");
        paises.add("Brasil");
        paises.add("Australia");
        paises.add("India");
        this.setPais(paises.get(random.nextInt(10)));
        super.redondear();
    }

    public static ArrayList<DirectorCarrera> getListaDirectores() {
        return DirectorCarrera.listaDirectores;
    }

    public void recibirPlata(double plata, Piloto piloto) {
    	/*
         * Descripcion del metodo: Este método agrega y resta la plata que determinado piloto le da al director de carrera con el fin de cometer un fraude
         * Parametros de entrada: double plata, Piloto piloto
         * Parametros de salida: Actialización de parametros
         */
        this.setPlata(this.getPlata() + plata);
        piloto.getEquipo().setPlata(piloto.getEquipo().getPlata() - plata);
    }

    public void recibirPlata(double plata) {    	
    	/*
         * Descripcion del metodo: Este método agrega determinada cantidad de plata al director de carrera 
         * Parametros de entrada: double plata
         * Parametros de salida: Actialización de parametros
         */
        this.setPlata(this.getPlata() + plata);
    }

    public void sinPlata() {
    	/*
         * Descripcion del metodo: Este método agrega plata al director de carrera 
         * Parametros de entrada: null
         * Parametros de salida: Actialización de parametros
         */
        this.setPlata(random.nextDouble(40001) + 10000);
    }

    // Metodos de instancia
    public void ponerSancion(Piloto piloto) {
    	/*
         * Descripcion del metodo: Este método se encarga de imponer una sanción a determinado piloto
         * Parametros de entrada: piloto del tipo Piloto
         * Parametros de salida: Actialización de parametros
         */
        piloto.setSanciones(piloto.getSanciones() + 1);
    }

    public void redondear() {
        this.setPlata(dosDecimales(this.getPlata()));
    }

    /*public ArrayList<ArrayList<String>> verStatsCompetidores() {
        double precio = 1000000;
        ArrayList<ArrayList<String>> listaStats = new ArrayList<>();
        if (Equipo.equipoElegido.getPlata() >= precio) {
            this.corrupcion += 1;
            Equipo equipo = Equipo.equipoElegido;
            equipo.setPlata(equipo.getPlata() - plata); // Se le quita la plata al equipo
            ArrayList<VehiculoCarrera> listaCompetidores = this.carrera.getPosiciones();
            for (VehiculoCarrera vc : listaCompetidores) {
                ArrayList<String> stats = new ArrayList<>();
                Piloto piloto = vc.getPiloto();
                stats.add(piloto.getNombre());
                stats.add(String.valueOf(piloto.getSanciones()));
                stats.add(String.valueOf(piloto.getHabilidad()));
                listaStats.add(stats);
            }
        }
        return listaStats;
    }*/

    /*public ArrayList<VehiculoCarrera> cambiarPosIniciales(int posicion) {
        double precio = 1000000;
        Equipo equipo = Equipo.equipoElegido;
        if (Equipo.equipoElegido.getPlata() >= precio) {
            this.corrupcion += 1;
            equipo.setPlata(equipo.getPlata() - plata); // Se le quita la plata al equipo
            // Cambiar posiciones metodo carrera
            // TODO
        }
        return this.carrera.getPosiciones();
    }*/

    // Para tunear Shaddy primero hay que comprar la pieza de contrabando
    // El proceso es el mismo que comprar una pieza normal
    /*public void tunearShaddy(Pieza pieza, int parte) {
        double precio = 1000000;
        Equipo equipo = Equipo.equipoElegido;
        if (Equipo.equipoElegido.getPlata() >= precio) {
            this.corrupcion += 1;
            equipo.setPlata(equipo.getPlata() - precio); // Se le quita la plata al equipo
            switch (parte) {
                case 1: // Neuamaticos
                    VehiculoCarrera.vehiculoElegido.setNeumaticos(pieza);
                    break;
                case 2: // Motor
                    VehiculoCarrera.vehiculoElegido.setMotor(pieza);
                    break;
                case 3: // Aleron
                    VehiculoCarrera.vehiculoElegido.setAleron(pieza);
                    break;
            }
        }
    }*/

    //Para hacer chocar primero hay que elegir a quien se va a chocar de la lista de puestos
/*    public void hacerChocar(VehiculoCarrera vehiculo) {
        double precio = 1000000;
        if (Equipo.equipoElegido.getPlata() >= precio) {
            this.corrupcion += 1;
            Equipo.equipoElegido.setPlata(Equipo.equipoElegido.getPlata() - precio); // Cobrar
            vehiculo.chocar();
        }
    }*/

/*    public boolean apuestasSub(double plataMetida, int numero) {
        this.corrupcion += 1;
        Equipo equipo = Equipo.equipoElegido;
        equipo.setPlata(equipo.getPlata() - plataMetida); // Se le quita la plata al equipo
        Random random = new Random(); // Generador de n�meros aleatorios
        int randomNumber = random.nextInt(15) + 1; // N�mero aleatorio entre 1 y 15
        if (numero == randomNumber) {
            equipo.setPlata(equipo.getPlata() + plataMetida * 2); // Se le da el doble de plata al equipo
            return true;
        } else {
            return false;
        }
    }*/

    public ArrayList<Piloto> pilotosDesfavorecidos(double plata, Piloto piloto, Campeonato campeonato) {
    	/*
         * Descripcion del metodo: Este método se encarga de filtrar los pilotos desfavorecidos de la lista de pilotos de determinado campeonato donde está el piloto elegido y agregarlos a una lista
         * Parametros de entrada: double plata, piloto de tipo Piloto, campeonato de tipo Campeonato
         * Parametros de salida: ArrayList<Piloto>
         */
        Carrera carreraDirector = carreraCampeonato(campeonato);
        ArrayList<Piloto> pilotosDesfavorecidos = new ArrayList<Piloto>();
                for (Piloto piloto1 : campeonato.getListaPilotos()) {
                    if (piloto.getEquipo() != piloto1.getEquipo() && !carreraDirector.getEquiposBeneficiados().contains(piloto1.getEquipo()) && plata>piloto1.getValorContrato() * 0.05) {
                        pilotosDesfavorecidos.add(piloto1);
                    }
                }
        return pilotosDesfavorecidos;
    }

    public ArrayList<Piloto> pilotosDesfavorecidos(Piloto piloto, Campeonato campeonato) {
    	/*
         * Descripcion del metodo: Este método se encarga de filtrar los pilotos desfavorecidos de la lista de pilotos de determinado campeonato donde está el piloto elegido y agregarlos a una lista
         * Parametros de entrada: piloto de tipo Piloto, campeonato de tipo Campeonato
         * Parametros de salida: ArrayList<Piloto>
         */
        Carrera carreraDirector = carreraCampeonato(campeonato);
        ArrayList<Piloto> pilotosDesfavorecidos = new ArrayList<Piloto>();
        for (Piloto piloto1 : campeonato.getListaPilotos()) {
            if (piloto.getEquipo() != piloto1.getEquipo() && !carreraDirector.getEquiposBeneficiados().contains(piloto1.getEquipo())) {
                pilotosDesfavorecidos.add(piloto1);
            }
        }
        return pilotosDesfavorecidos;
    }

    public Carrera carreraCampeonato(Campeonato campeonato){ 
    	/*
         * Descripcion del metodo: Este método se encarga de Retornar alguna de las carreras que tiene como director de carrera el objeto que lo llama
         * Parametros de entrada: campeonato de tipo Campeonato
         * Parametros de salida: ArrayList<Carrera>
         */
    	Random rand = new Random();
        ArrayList<Carrera> listaCarrerasDirector = new ArrayList<Carrera>();
        for (Carrera carrera : campeonato.getListaCarreras()){
            if (carrera.getDirectorCarrera().equals(this)){
                listaCarrerasDirector.add(carrera);
            }
        }
        return listaCarrerasDirector.get(rand.nextInt(listaCarrerasDirector.size()));
    }

    public boolean isLicencia() {
        return licencia;
    }

    public void setLicencia(boolean licencia) {
        this.licencia = licencia;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getCorrupcion() {
        return corrupcion;
    }

    public void setCorrupcion(int corrupcion) {
        this.corrupcion = corrupcion;
    }

    public ArrayList<VehiculoCarrera> getPosicionesCorruptas() {
        return posicionesCorruptas;
    }

    public void setPosicionesCorruptas(ArrayList<VehiculoCarrera> posicionesCorruptas) {
        this.posicionesCorruptas = posicionesCorruptas;
    }

    public static void setListaDirectores(ArrayList<DirectorCarrera> directoresCarrera) {

        DirectorCarrera.listaDirectores = directoresCarrera;
        
    }
}
