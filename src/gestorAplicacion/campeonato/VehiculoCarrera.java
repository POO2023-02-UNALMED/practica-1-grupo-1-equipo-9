package gestorAplicacion.campeonato;

import gestorAplicacion.paddock.Pieza;
import gestorAplicacion.paddock.Piloto;
import gestorAplicacion.paddock.Vehiculo;

import java.util.Random;


public class VehiculoCarrera extends Vehiculo {
    public static VehiculoCarrera vehiculoElegido; //Vehículo que elije el usuario
    //Atributos
    private Piloto piloto; //Conductor
    private double tiempo; //Cuanto se demora en terminar la carrera, solo se calcula al final para obtener la posición final
    private double distanciaRecorrida; //Se usa sólo dentro del ciclo, se calcula en cada iteración para obtener la posición actual
    private boolean terminado; // Mira si terminó la carrera. Si se choca, esto pasa a true.
    private boolean morido; // Si está morido, lo manda al final de la lista de posiciones.
    private double velocidadTuneao; //Velocidad del vehículo + velocidad de las piezas
    private double velocidadCircumstancias; // velocidad de las circunstancias
    private double velocidadActual; //Velocidad actual del vehículo, velocidad tuneada +- situaciones //TODO: IMPORTANTE: La velocidad en que unidades (o numeros) deberiamos trabajarla (no pueden ser horas).
    private double probabilidadChoque;
    private int gasolina;

    public VehiculoCarrera(String marca, String modelo, int ano, Pieza aleron, Pieza neumaticos, Pieza motor, double velocidad, double maniobrabilidad, double precioUtilizar, Piloto piloto) {
        super(marca, modelo, ano, aleron, neumaticos, motor, velocidad, maniobrabilidad, precioUtilizar);
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
    }

    public static VehiculoCarrera getVehiculoElegido() {
        return vehiculoElegido;
    }

    public static void setVehiculoElegido(VehiculoCarrera vehiculoElegido) {
        VehiculoCarrera.vehiculoElegido = vehiculoElegido;
    }

    //Métodos
    public void chocar() { //Coloca tiempo en 0, velocidad en 0, terminado en true y morido en true
        this.tiempo = 0;
        this.terminado = true;
        this.morido = true;
    }

    public void cambiarMotor(Pieza pieza) {
        if (Equipo.equipoElegido.getPlata() >= pieza.getPrecio()) {
            Equipo.equipoElegido.setPlata(Equipo.equipoElegido.getPlata() - pieza.getPrecio()); // Cobrar
            this.setMotor(pieza); //Cambiar motor
            this.actualizarVelocidadT(); //Actualizar velocidad tuneada
        }
    }

    public void cambiarNeumaticos(Pieza pieza, double dinero) {
        if (Equipo.equipoElegido.getPlata() >= pieza.getPrecio()) {
            Equipo.equipoElegido.setPlata(Equipo.equipoElegido.getPlata() - pieza.getPrecio()); // Cobrar
            this.setNeumaticos(pieza); //Cambiar neumáticos
            this.actualizarVelocidadT(); //Actualizar velocidad tuneada
        }
    }

    public void cambiarAleron(Pieza pieza) {
        if (Equipo.equipoElegido.getPlata() >= pieza.getPrecio()) {
            Equipo.equipoElegido.setPlata(Equipo.equipoElegido.getPlata() - pieza.getPrecio()); // Cobrar
            this.setAleron(pieza); //Cambiar alerón
            this.actualizarVelocidadT(); //Actualizar velocidad tuneada
        }
    }

    public void repararVehiculo() {
        double precio = 100; //preguntar precio
        if (Equipo.equipoElegido.getPlata() >= precio) {
            Equipo.equipoElegido.setPlata(this.piloto.getEquipo().getPlata() - precio); // Cobrar
            //Arreglar piezas
            this.getAleron().arreglar();
            this.getMotor().arreglar();
            this.getNeumaticos().arreglar();
        }
    }

    public void llenarGasolina() {
        this.gasolina = 100; //Llenar gasolina al 100%
    }

    public void actualizarVelocidadT() { //Actualiza la velocidad tuneada para cuando se cambie una pieza
        if (!this.getAleron().isDanado()) {
            this.velocidadTuneao = this.getVelocidad() + this.getAleron().getVelocidadAnadida();
        }
        if (!this.getNeumaticos().isDanado()) {
            this.velocidadTuneao = this.getVelocidad() + this.getNeumaticos().getVelocidadAnadida();
        }
        if (!this.getMotor().isDanado()) {
            this.velocidadTuneao = this.getVelocidad() + this.getMotor().getVelocidadAnadida();
        }
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



    // Ligadura Dinamica
    public void morir() {
        Vehiculo vehiculo = this;
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
}
