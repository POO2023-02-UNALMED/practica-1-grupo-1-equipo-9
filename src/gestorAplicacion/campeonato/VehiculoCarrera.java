package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Pieza;
import gestorAplicacion.paddock.Piloto;
import gestorAplicacion.paddock.Chasis;

import java.util.ArrayList;
import java.util.Random;


public class VehiculoCarrera extends Chasis implements Decimales {
    public static ArrayList<VehiculoCarrera> listaVehiculos = new ArrayList<VehiculoCarrera>();

    //Atributos
    private Piloto piloto; //Conductor
    private double tiempo; //Cuanto se demora en terminar la carrera, solo se calcula al final para obtener la posición final
    private double distanciaRecorrida; //Se usa sólo dentro del ciclo, se calcula en cada iteración para obtener la posición actual
    private boolean terminado; // Mira si terminó la carrera. Si se choca, esto pasa a true.
    private boolean morido; // Si está morido, lo manda al final de la lista de posiciones.
    private double velocidadTuneao; //Velocidad del vehículo + velocidad de las piezas
    private double velocidadCircumstancias; // velocidad de las circunstancias
    private double velocidadActual; //Velocidad actual del vehículo, velocidad tuneada +- situaciones
    private double probabilidadChoque;
    private Pieza motor;
    private Pieza neumaticos;
    private Pieza aleron;
    private int gasolina;
    private ArrayList<Pieza> piezasComprar = new ArrayList<Pieza>();

    public VehiculoCarrera(String marca, String modelo, double velocidad, double maniobrabilidad, double precio, Piloto piloto, Pieza motor, Pieza neumaticos, Pieza aleron) {
        super(marca, modelo, velocidad, maniobrabilidad, precio);
        this.piloto = piloto;
        this.motor = motor;
        this.neumaticos = neumaticos;
        this.aleron = aleron;
        VehiculoCarrera.listaVehiculos.add(this);
    }

    public VehiculoCarrera(String marca, String modelo, double velocidad, double maniobrabilidad, double precioUtilizar, Piloto piloto, double tiempo, double distanciaRecorrida, boolean terminado, boolean morido, double velocidadTuneao, double velocidadCircumstancias, double velocidadActual, double probabilidadChoque, Pieza motor, Pieza neumaticos, Pieza aleron, int gasolina) {
        super(marca, modelo, velocidad, maniobrabilidad, precioUtilizar);
        this.piloto = piloto;
        this.tiempo = tiempo;
        this.distanciaRecorrida = distanciaRecorrida;
        this.terminado = terminado;
        this.morido = morido;
        this.velocidadTuneao = velocidadTuneao;
        this.velocidadCircumstancias = velocidadCircumstancias;
        this.velocidadActual = velocidadActual;
        this.probabilidadChoque = probabilidadChoque;
        this.motor = motor;
        this.neumaticos = neumaticos;
        this.aleron = aleron;
        this.gasolina = gasolina;
        VehiculoCarrera.listaVehiculos.add(this);
    }

    public VehiculoCarrera(Chasis chasis, Piloto piloto) {
        super(chasis.getMarca(), chasis.getModelo(), chasis.getVelocidad(), chasis.getManiobrabilidad(), chasis.getPrecio());
        this.piloto = piloto;
        this.tiempo = 0;
        this.distanciaRecorrida = 0;
        this.terminado = false;
        this.morido = false;
        this.velocidadTuneao = 0;
        this.probabilidadChoque = Math.max( 1 - piloto.getHabilidad() - chasis.getManiobrabilidad(), 0.3);
        this.gasolina = 100;
        this.velocidadCircumstancias = 0;
        this.velocidadActual = velocidadTuneao + velocidadCircumstancias;
        VehiculoCarrera.listaVehiculos.add(this);
    }

    public VehiculoCarrera(Chasis chasis) {
        super(chasis.getMarca(), chasis.getModelo(), chasis.getVelocidad(), chasis.getManiobrabilidad(), chasis.getPrecio());
        this.tiempo = 0;
        this.distanciaRecorrida = 0;
        this.terminado = false;
        this.morido = false;
        this.velocidadTuneao = 0;
        this.probabilidadChoque = Math.max( 1 - piloto.getHabilidad() - chasis.getManiobrabilidad(), 0.3);
        this.gasolina = 100;
        this.velocidadCircumstancias = 0;
        this.velocidadActual = velocidadTuneao + velocidadCircumstancias;
        VehiculoCarrera.listaVehiculos.add(this);
    }


    /*public VehiculoCarrera(String marca, String modelo, double velocidad, double maniobrabilidad, double precioUtilizar, Piloto piloto, Pieza neumaticos, Pieza aleron, Pieza motor) {
        super(marca, modelo, velocidad, maniobrabilidad, precioUtilizar);
        this.piloto = piloto;
        this.tiempo = 0;
        this.distanciaRecorrida = 0;
        this.terminado = false;
        this.morido = false;
        this.velocidadTuneao = 0;
        this.probabilidadChoque = Math.max( 1 - piloto.getHabilidad() - maniobrabilidad - neumaticos.getManiobrabilidadAnadida() - aleron.getManiobrabilidadAnadida(), 0.3);
        this.gasolina = 100;
        this.actualizarVelocidadT();
        this.velocidadCircumstancias = 0;
        this.velocidadActual = velocidadTuneao + velocidadCircumstancias;
    }*/


    public static ArrayList<VehiculoCarrera> vehiculosPiloto(Piloto piloto) {
        ArrayList<VehiculoCarrera> vehiculosPiloto = new ArrayList<VehiculoCarrera>();
        for (VehiculoCarrera vehiculo : VehiculoCarrera.listaVehiculos) {
            if (vehiculo.getPiloto() == piloto) {
                vehiculosPiloto.add(vehiculo);
            }
        }
        return vehiculosPiloto;
    }

    public static void crearVehiculoPilotosNoElegidos(Piloto piloto){
        Random rand = new Random();
        String modelo = String.valueOf(cantidadVehiculosDefault() + 1);
        int velocidad = rand.nextInt(50) + 200;
        double precio = ((Math.random() * 4001) + 1000) * 3;
        double maniobrabilidad = rand.nextDouble() * 0.3;
        Chasis chasis = new Chasis("Default", modelo, velocidad, velocidad, precio);
        VehiculoCarrera vehiculo = new VehiculoCarrera(chasis, piloto);
        Pieza aleron = Pieza.piezaNoElegida("A");
        Pieza neumaticos = Pieza.piezaNoElegida("N");
        Pieza motor = Pieza.piezaNoElegida("M");
        vehiculo.setAleron(aleron);
        vehiculo.setNeumaticos(neumaticos);
        vehiculo.setMotor(motor);
    }

    public static int cantidadVehiculosDefault(){
        int cantidad = 0;
        for (VehiculoCarrera vehiculo : VehiculoCarrera.listaVehiculos){
            if (vehiculo.getMarca().equals("Default")){
                cantidad++;
            }
        }
        return cantidad;
    }



    //Métodos
    public void chocar() { //Coloca tiempo en 0, velocidad en 0, terminado en true y morido en true
        this.tiempo = 0;
        this.setVelocidadActual(0);
        this.terminado = true;
        this.morido = true;
    }

/*    public void cambiarMotor(Pieza pieza) {
        Equipo equipo =  this.getPiloto().getEquipo();
        if (equipo.getPlata() >= pieza.getPrecio()) {
            equipo.setPlata(equipo.getPlata() - pieza.getPrecio()); // Cobrar
            this.setMotor(pieza); //Cambiar motor
            this.actualizarVelocidadT(); //Actualizar velocidad tuneada
        }
    }

    public void cambiarNeumaticos(Pieza pieza, double dinero) {
        Equipo equipo =  this.getPiloto().getEquipo();
        if (equipo.getPlata() >= pieza.getPrecio()) {
            equipo.setPlata(equipo.getPlata() - pieza.getPrecio()); // Cobrar
            this.setNeumaticos(pieza); //Cambiar neumáticos
            this.actualizarVelocidadT(); //Actualizar velocidad tuneada
        }
    }

    public void cambiarAleron(Pieza pieza) {
        Equipo equipo =  this.getPiloto().getEquipo();
        if (equipo.getPlata() >= pieza.getPrecio()) {
            equipo.setPlata(equipo.getPlata() - pieza.getPrecio()); // Cobrar
            this.setAleron(pieza); //Cambiar alerón
            this.actualizarVelocidadT(); //Actualizar velocidad tuneada
        }
    }*/

    public void cambiarPieza(Pieza pieza) {
        Equipo equipo =  this.getPiloto().getEquipo();
        String tipoPieza = pieza.getTipo();
        switch (tipoPieza){
            case "A":
                this.setAleron(pieza); //Cambiar alerón
                this.actualizarVelocidadT(); //Actualizar velocidad tuneada
                break;
            case "N":
                this.setNeumaticos(pieza); //Cambiar neumáticos
                this.actualizarVelocidadT(); //Actualizar velocidad tuneada
                break;
            case "M":
                this.setMotor(pieza); //Cambiar motor
                this.actualizarVelocidadT(); //Actualizar velocidad tuneada
                break;
        }
    }

    public void configurarVehiculo(ArrayList<Pieza> piezas) {
        for (Pieza pieza : piezas) {
            this.cambiarPieza(pieza);
        }
        this.llenarGasolina();
    }

    public boolean repararVehiculo() {
        double precio = (this.motor.getPrecio()+this.aleron.getPrecio()+this.neumaticos.getPrecio())/2;
        Equipo equipo =  this.getPiloto().getEquipo();
        if (equipo.getPlata() >= precio) {
            equipo.setPlata(this.piloto.getEquipo().getPlata() - precio); // Cobrar
            //Arreglar piezas
            this.getAleron().arreglar();
            this.getMotor().arreglar();
            this.getNeumaticos().arreglar();
            return true;
        } else {return false;}
    }

    public void llenarGasolina() {
        this.gasolina = 100; //Llenar gasolina al 100%
    }

    public void actualizarVelocidadT() { //Actualiza la velocidad tuneada para cuando se cambie una pieza
        if (this.getAleron() != null) {
            if (!this.getAleron().isDanado()) {
                this.velocidadTuneao = this.getVelocidad() + this.getAleron().getVelocidadAnadida();
            }
        }
        if (this.getNeumaticos() != null) {
            if (!this.getNeumaticos().isDanado()) {
                this.velocidadTuneao = this.getVelocidad() + this.getNeumaticos().getVelocidadAnadida();
            }
        }
        if (this.getMotor() != null) {
            if (!this.getMotor().isDanado()) {
                this.velocidadTuneao = this.getVelocidad() + this.getMotor().getVelocidadAnadida();
            }
        }
        //this.actualizarVelicidadActual(); // Actualizar velocidad actual
    }

    public void actualizarVelicidadActual() {
        //Actualiza la velocidad actual para cuando se cambie una pieza
        // O si cambia la velocidad de circumstancias
        this.actualizarVelocidadT(); // Actualizar velocidad tuneada
        this.velocidadActual = this.velocidadTuneao + this.velocidadCircumstancias; // Actualizar velocidad actual
        revisarMaxVelocidad(); // Revisar que no se pase de la velocidad máxima
    }

    public void revisarMaxVelocidad() {
        if (this.velocidadActual > 375) {
            this.setVelocidadActual(375);
        }
    }

    // Aprovechar DRS (Adelantar) - Aumenta velocidad
    // 1. Daña el alerón
    // 2. Aumenta la velocidad
    // 3. Usa la probabilidad de chocar
    public void aprovecharDRS() {
        Random rand = new Random(); // Generador de números aleatorios
        int randomNumber = rand.nextInt(10) + 1; // Número aleatorio entre 1 y 3
        if (randomNumber == 1) { // Daña el alerón
            this.getAleron().setDanado(true);
            this.actualizarVelicidadActual(); // Actualizar velocidad actual
        } else if (randomNumber <= 9) {
            this.setVelocidadCircumstancias(50); // Aumenta la velocidad en 10
            this.actualizarVelicidadActual(); // Actualizar velocidad actual
        } else { // Usa la probabilidad de chocar
            double numeroAleatorio = rand.nextDouble();
            // Número aleatorio entre 0 y 1
            if (numeroAleatorio <= this.getProbabilidadChoque()) { // Si el número aleatorio es menor o igual a la probabilidad de chocar, choca
                this.chocar();
            } else { // Si no, aumenta la velocidad
                this.setVelocidadCircumstancias(10); // Aumenta la velocidad en 10
                this.actualizarVelicidadActual(); // Actualizar velocidad actual
            }
        }
    }

    // Frenar (Debe frenar para entrar a pits) - Disminuye la velocidad
    // 1. Daña las llantas
    // 2. Disminuye 1 posición
    // 3. Puede entrar a Pits
    public void frenar() {
        Random rand = new Random(); // Generador de números aleatorios
        int randomNumber = rand.nextInt(10) + 1; // Número aleatorio entre 1 y 3
        if (randomNumber == 1) { // Daña las llantas
            this.getNeumaticos().setDanado(true);
            this.actualizarVelicidadActual();
        } else if (randomNumber <= 9) { // Disminuye 1 posición
            this.setVelocidadCircumstancias(- 100); // Aumenta la velocidad en 10
            this.actualizarVelicidadActual(); // Actualizar velocidad actual
        }
    }

//    Hacer Maniobra (RE BONUS) -
//    1. Chocar
//    2. Aumentar velocidad 100

    public void hacerManiobra() {
        Random rand = new Random(); // Generador de números aleatorios
        int randomNumber = rand.nextInt(10) + 1; // Número aleatorio
        if (randomNumber <= 5) { // Choca
            this.chocar();
        } else { // Aumenta la velocidad en 100
            this.setVelocidadCircumstancias(100); // Aumenta la velocidad en 10
            this.actualizarVelicidadActual(); // Actualizar velocidad actual
        }
    }

//  Defender Posición (Pussy) - Mantiene la velocidad actual
//  1. Aumentar o disminuir velocidad en 20
    public void defender() {
        Random rand = new Random(); // Generador de números aleatorios
        int randomNumber = rand.nextInt(10) + 1; // Número aleatorio
        if (randomNumber <= 5) { // Aumenta la velocidad en 20
            this.setVelocidadCircumstancias(20); // Aumenta la velocidad en 10
            this.actualizarVelicidadActual(); // Actualizar velocidad actual
        } else { // Disminuye la velocidad en 20
            this.setVelocidadCircumstancias(- 20); // Aumenta la velocidad en 10
            this.actualizarVelicidadActual(); // Actualizar velocidad actual
        }
    }

//  Derrapar RAAAAAAAAAAAAAAAA - Mantiene la velocidad
//  1. Dañar las llantas
//  2. Aumentar 30 velocidad
//  3. Usa la probabilidad de choque

    public void derrapar() {
        Random rand = new Random(); // Generador de números aleatorios
        int randomNumber = rand.nextInt(10) + 1; // Número aleatorio
        if (randomNumber == 1) {
            this.getNeumaticos().setDanado(true); // Dañar las llantas
            this.actualizarVelicidadActual(); // Actualizar velocidad actual
        } else if (randomNumber <= 9) {
            this.setVelocidadCircumstancias(30); // Aumenta la velocidad en 10
            this.actualizarVelicidadActual(); // Actualizar velocidad actual
        } else { // Usa la probabilidad de chocar
            double numeroAleatorio = rand.nextDouble();
            // Número aleatorio entre 0 y 1
            if (numeroAleatorio <= this.getProbabilidadChoque()) {
                // Si el número aleatorio es menor o igual a la probabilidad de chocar, choca
                this.chocar();
            } else { // Si no, aumenta la velocidad
                this.setVelocidadCircumstancias(10); // Aumenta la velocidad en 10
                this.actualizarVelicidadActual(); // Actualizar velocidad actual
            }
        }
    }

    public static ArrayList<VehiculoCarrera> maldecirVehiculos(VehiculoCarrera vehiculoMaldito, VehiculoCarrera vehiculoUsuario, ArrayList<Piloto> pilotosDesfavorecidos, double plata, DirectorCarrera directorCarrera){
        Random rand = new Random();
        ArrayList<VehiculoCarrera> posicionesCorruptas = new ArrayList<VehiculoCarrera>();
        vehiculoUsuario.setDistanciaRecorrida(50 + (double) ((100) * (1 + rand.nextInt(10))) /10);
        posicionesCorruptas.add(vehiculoUsuario);
        vehiculoMaldito.setDistanciaRecorrida(-50 - (double) ((200) * (1 + rand.nextInt(10))) /10);
        posicionesCorruptas.add(vehiculoMaldito);
        for (VehiculoCarrera vehiculoCarrera : VehiculoCarrera.getListaVehiculosCarrera()){
            if (pilotosDesfavorecidos.contains(vehiculoCarrera.getPiloto())){
                vehiculoCarrera.setDistanciaRecorrida(-10 - (double) ((50) * (1 + rand.nextInt(10))) /10);
            }
                posicionesCorruptas.add(vehiculoCarrera);
        }
        return posicionesCorruptas;
    }


    // Ligadura Dinamica
    public void morir() {
        Chasis chasis = this;
    }

    // Getters y setters

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    public boolean isMorido() {
        return morido;
    }

    public void setMorido(boolean morido) {
        this.morido = morido;
    }

    public double getVelocidadTuneao() {
        return velocidadTuneao;
    }

    public void setVelocidadTuneao(double velocidadTuneao) {
        this.velocidadTuneao = velocidadTuneao;
    }

    public double getProbabilidadChoque() {
        return probabilidadChoque;
    }

    public void setProbabilidadChoque(double probabilidadChoque) {
        this.probabilidadChoque = probabilidadChoque;
    }

    public int getGasolina() {
        return gasolina;
    }

    public void setGasolina(int gasolina) {
        this.gasolina = gasolina;
    }

    public Piloto getPiloto() {
        return this.piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public double getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public double getVelocidadCircumstancias() {
        return velocidadCircumstancias;
    }

    public void setVelocidadCircumstancias(double velocidadCircumstancias) {
        this.velocidadCircumstancias = velocidadCircumstancias;
    }

    public Pieza getMotor() {
        return motor;
    }

    public void setMotor(Pieza motor) {
        this.motor = motor;
    }

    public Pieza getNeumaticos() {
        return neumaticos;
    }

    public void setNeumaticos(Pieza neumaticos) {
        this.neumaticos = neumaticos;
    }

    public Pieza getAleron() {
        return aleron;
    }

    public void setAleron(Pieza aleron) {
        this.aleron = aleron;
    }

    public static ArrayList<VehiculoCarrera> getListaVehiculosCarrera() {
        return listaVehiculos;
    }

    public static void setListaVehiculosCarrera(ArrayList<VehiculoCarrera> listaVehiculos) {
        VehiculoCarrera.listaVehiculos = listaVehiculos;
    }

    public ArrayList<Pieza> getPiezasComprar() {
        return piezasComprar;
    }

    public void setPiezasComprar(ArrayList<Pieza> piezasComprar) {
        this.piezasComprar = piezasComprar;
    }

    @Override
    public void redondear() {
        this.probabilidadChoque = dosDecimales(this.probabilidadChoque);
    }
    {
        this.redondear();
    }
}
