# ? Proyecto de la F�d�ration Internationale de l'Automobile ???

## Clases

### 1. Campeonato ?
Atributos:
- `int id`
- `String nombre`
- `int ano`
- `int numCarreras`
- `ArrayList<Carrera> listaCarreras`
- `ArrayList<Equipo> listaEquipos`
- `String continente`
- `int premio`
- `static ArrayList<Campeonato> campeonatos`

M�todos:
- `void agregarCarrera(Carrera carrera)`: Agrega una carrera al ArrayList de carreras.
- `ArrayList<Equipo> premiacionEquipos()`: Distribuye el premio a los equipos ganadores y ordena los equipos por puntos descendentes.
- `ArrayList<Piloto> premiacionPiloto()`: Asigna puntos a cada piloto y los organiza por puntos descendentes.
- `void elegirEquipo(int id)`: Permite al usuario elegir un equipo.

### 2. Ciudad ?
Atributos:
- `String nombre`
- `String continente`

Notas:
- `continente` es un enum.

### 3. Carrera ?
Atributos:
- `int id`
- `int mes`
- `String nombreCircuito`
- `double distancia`
- `double premioEfectivo`
- `Ciudad ciudad`
- `DirectorCarrera directorCarrera`
- `Campeonato campeonato`
- `ArrayList<VehiculoDeCarrera> posiciones`
- `double clima` (probablidades: 0.05 soleado, 0.10 lluvia, 0.15 tormenta)
- `double dificultad`

M�todos:
- `VehiculoCarrera posicionFinal(ArrayList<VehiculoCarrera> posiciones)`: Ordena aleatoriamente las posiciones finales.
- `ArrayList<Piloto> sancionesPilotos()`: Organiza a los pilotos por n�mero de sanciones.
- `ArrayList<VehiculoCarrera> simularCarrera()`: Simula la carrera y devuelve las posiciones.
- `void opcionesDecision(int)`: Realiza decisiones durante la carrera.
- `int aprovecharDRS()`: Devuelve un valor positivo y aplica una probabilidad de choque.
- `int frenar()`: Devuelve un valor negativo.
- `int hacerManiobra()`: Devuelve 0 y aplica una probabilidad de choque.
- `int defenderPosicion()`: Devuelve 0 y no realiza ninguna acci�n.
- `int derrapar()`: Devuelve un valor positivo y aplica una probabilidad de choque.
- `ArrayList<int> pitStop()`: Devuelve las opciones disponibles para la parada en boxes.
- `void asignarPuntos(ArrayList<VehiculoCarrera> posiciones)`: Asigna puntos seg�n las posiciones.
- `String verificarCorrupcion(DirectorCarrera directorCarrera)`: Verifica si hay casos de corrupci�n en el director de carrera y descalifica al equipo del piloto si hay m�s de 5 casos.


### 4. Persona ?
Atributos:
- `int id`
- `String nombre`
- `String pais`

### 5. Piloto ??
Atributos:
- `Equipo equipo`
- `int puntos`
- `int sanciones`
- `ArrayList<String> victorias`
- `double habilidad`
- `boolean disponible`

M�todos:
- `void agregarVictorias(String victoria)`: Agrega una victoria al ArrayList.
- `void escogerCarro(double precio)`: Crea un VehiculoCarrera.
- `String toString()`: Imprime informaci�n del piloto.
- `void agregarSanciones()`: Aumenta en 1 las sanciones.
- `void hacerTriqui�uelas()`: Inicia la corrupci�n.


### 6. Patrocinador ?
Atributos:
- `double dinero`
- `double dineroOfrecer`
- `double probAceptar`
- `Equipo equipoPatrocinado`

M�todos:
- `double patrocinar()`: Si es verdadero, devuelve dinero. Si es falso, devuelve 0.

### 7. Vehiculo ?
Atributos:
- `String marca`
- `String modelo`
- `int ano`
- `Pieza aleron`
- `Pieza neumaticos`
- `Pieza motor`
- `double Velocidad`
- `double Maniobrabilidad`
- `double precioUtilizar`

M�todos:
- `String toString()`: Devuelve las estad�sticas del veh�culo.
- `void comprar()`: Compra el veh�culo, lo vuelve veh�culo de carrera.
- 
### 8. VehiculoCarrera ??
Atributos:
- `Piloto piloto`
- `double tiempo`
- `double distanciaRecorrida`
- `boolean terminado`
- `boolean morido`
- `double velocidadTuneao`
- `double probabilidadChoque`
- `int gasolina`

M�todos:
- `void chocar()`
- `void cambiarMotor(Pieza motor, double dinero)`
- `void cambiarLlantas(Pieza llantas, double dinero)`
- `void cambiarAleron(Pieza aleron, double dinero)`
- `void repararVehiculo(double dinero)`
- `void llenarGasolina()`


### 9. Pieza ?
Atributos:
- `boolean danado`
- `double velocidadAnadida`
- `double maniobrabilidadAnadida`
- `String nombre`
- `double precio`

M�todos:
- `void arreglar()`: Marca la pieza como reparada.
- `void comprar(VehiculoCarrera veh)`: Compra la pieza para el veh�culo.

### 10. DirectorCarrera ?
Atributos:
- `double plata`
- `boolean licencia`
- `Carrera carrera`
- `int corrupcion`

M�todos:
- `void ponerSancion(Piloto piloto)`
- `ArrayList<String> favoresEspeciales(double plata)`
- `int verStatsCompetidores(double platametida)`
- `int cambiarPosIniciales(double platametida, int posicion)`
- `int tunearShaddy(double platametida, VehiculoCarrera veh)`
- `int hacerChocar(double platametida, VehiculoCarrera vehChocar)`
- `int apuestasSubterraneas(double plata, VehiculoCarrera veh)`

### 11. Equipo ??
Atributos:
- `int id`
- `String nombre`
- `String pais`
- `double plata`
- `int puntos`
- `ArrayList<Vehiculo> vehiculosDisponibles`
- `ArrayList<Piloto> pilotosDisponibles`
- `Piloto piloto1`
- `Piloto piloto2`

M�todos:
- `boolean negociar()`: Para aceptar las probabilidades de aceptaci�n.
- `double bajarPatrocinio()`: Reduce el dinero ofrecido para aumentar las posibilidades de aceptaci�n.
- `double subirPatrocinio()`: Aumenta el dinero ofrecido a cambio de reducir las posibilidades de aceptaci�n.
- `Piloto elegirPiloto(int id)`: Elige al piloto1 por ID.
- `Piloto elegirPiloto2(int id)`: Elige al piloto2 por ID.

