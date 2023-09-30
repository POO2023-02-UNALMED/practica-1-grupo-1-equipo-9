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


***

? Linea de Funcionalidades

## Preparar Campeonato ?

Usuario (POV) ?

**1. Escoger entre 5 campeonatos predefinidos:**
- Seleccionar un campeonato de una lista de 5 campeonatos preconfigurados. ?

**2. Seleccionar un n�mero determinado de carreras:**
- Elegir la cantidad de carreras que compondr�n el campeonato. ??

**3. Elegir el continente del campeonato:**
- Seleccionar uno de los 5 continentes disponibles: Am�rica, Europa, Asia, �frica, Ocean�a. ?

**4. Elegir el a�o del campeonato:**
- Indicar el a�o en el que se llevar� a cabo el campeonato. ?

**5. Elegir detalles adicionales del campeonato:**
- Definir cualquier detalle adicional del campeonato, como las reglas espec�ficas o caracter�sticas especiales. ?

**6. Elegir el director de carrera:**
- Seleccionar un director de carrera que supervisar� las carreras del campeonato. ???

**7. Seleccionar SU Equipo:**
- Elegir un equipo para competir en el campeonato. Los dem�s equipos ya est�n predefinidos. ?

**8. Elija el nombre del equipo (utilizando un ENUM):**
- Seleccionar un nombre para el equipo de una lista predefinida de nombres utilizando ENUM. ?

**9. Mostrar pilotos del Equipo:**
- Visualizar la lista de pilotos disponibles en el equipo seleccionado. ?

**10. Elegir 2 pilotos:**
- Seleccionar dos pilotos del equipo para representarlo en las carreras. ??

**11. Negociaciones con Patrocinadores (opcional):**
- Realizar negociaciones con patrocinadores para obtener financiamiento adicional. (Opcional) ??

**12. Mostrar lista de patrocinadores:**
- Visualizar la lista de patrocinadores disponibles para las negociaciones. ??

**13. Poner dinero a pedir:**
- Indicar la cantidad de dinero que se solicita a los patrocinadores en las negociaciones. ?

**14. Seg�n el resultado aleatorio, recibir el patrocinio:**
- Basado en un resultado aleatorio, recibir el patrocinio de uno o m�s patrocinadores. ??

**15. Mostrar el dinero recibido:**
- Verificar la cantidad de dinero que se ha recibido de los patrocinadores. ??

## ? Planificar Calendario de Carreras ?

**1. De acuerdo con el campeonato (cantidad de carreras), prepara todas:**
- Genera el calendario de carreras de acuerdo al n�mero de carreras en el campeonato. ??

**2. Mostrar opciones de Carreras:**
- Para cada carrera, muestra las siguientes opciones:
  a. Nombre de la carrera ?
  b. Ciudad - Continente ?
  c. Premio ?
  d. Distancia ?

**3. Elegir mes:**
- Para cada carrera, selecciona el mes en el que se llevar� a cabo la carrera. ??

**4. Elegir condiciones clim�ticas:**
- Para cada carrera, elige las condiciones clim�ticas que afectar�n las probabilidades de los pilotos. ??????

**5. Reservar Circuito (Opcional):**
- Para cada carrera, se puede optar por reservar un circuito. Esta opci�n puede estar disponible o no.
  a. Elegir patrocinador: Selecciona un patrocinador para la carrera.
  b. Valor aleatorio: El patrocinador pagar� un monto aleatorio basado en su valor.

**6. Elegir dificultad de Carrera:**
- Para cada carrera, define la dificultad de la carrera. Puedes elegir entre diferentes niveles que afectar�n aspectos como la probabilidad de choques y adelantamientos.
  a. Niveles de dificultad disponibles: F�cil, Intermedio, Dif�cil. ???

## ?? Tunear el Carro ?

**1. Para la primera carrera:**

a. Mostrar carros disponibles para el equipo:
- Visualiza la lista de carros disponibles para tu equipo. ??

b. Seleccionar el carro seg�n el presupuesto:
- Selecciona un carro de la lista de acuerdo a tu presupuesto. ??

c. Mejoras o cambios al carro:
1. Hay diferentes partes disponibles:
    1. Llantas
    2. Aler�n
    3. Motor
2. Algunas partes aumentan la velocidad y otras la maniobrabilidad del veh�culo. ??
3. Velocidad: Cu�nto recorre en cuanto tiempo. ???
4. Maniobrabilidad: Probabilidad de chocarse. ??

**2. Para carreras subsecuentes:**

a. Negociar:
- Realiza negociaciones para obtener beneficios adicionales. ??

b. Opci�n de reparar el carro:
- Puedes elegir reparar el carro si ha sufrido da�os durante carreras anteriores. ???

c. Opci�n de cambiar las partes:
- Cambia las partes del carro para mejorar su rendimiento. ??

**3. Abrir un regalo (opcional):**
- Si est� disponible, tienes la opci�n de abrir un regalo que podr�a contener mejoras o sorpresas para tu carro. ??

## ?? Corrupci�n en Carreras ?

**1. Antes de cada carrera:**
- Antes de cada carrera, se pregunta al usuario si desea obtener "favores especiales" del director de carrera. ?

**2. Si dice que s�, tiene que proponer una cantidad de dinero:**
- Si decides aceptar, debes ofrecer una cantidad de dinero como soborno. ??

**3. Se muestran luego las siguientes opciones con la cantidad de dinero que ofreci�:**
- Una vez que hayas ofrecido el soborno, se presentan las siguientes opciones disponibles seg�n la cantidad de dinero que hayas ofrecido:

**Ac� se puede:**

**4. Ver las estad�sticas de los otros competidores:**
- Visualiza las estad�sticas de los otros competidores para obtener informaci�n adicional. ???

**5. Cambiar las posiciones iniciales (solo la del jugador):**
- Modifica la posici�n inicial del jugador antes de la carrera. ???

**6. Cambiar las partes por unas de contrabando con mejores estad�sticas:**
- Realiza cambios en las partes del carro por piezas de contrabando con estad�sticas mejoradas. ??

**7. Puedes hacer chocar a los otros competidores:**
- Decide causar accidentes a otros competidores durante la carrera. ??

**8. Apuestas ilegales:**
- Participa en apuestas ilegales donde apuestas todo y puedes ganar el doble de lo apostado. ??

**a. Juego de escoger el vaso:**
- Juega al juego de escoger el vaso en un tablero de 5x5. Elige una casilla y descubre si hay una bolita dentro de esa casilla. Si la casilla que eliges contiene una bolita, ganas la apuesta. ??

**9. Validaciones:**

a. Si cambias tu posici�n m�s de 2 veces, sanci�n ?

b. Si compras piezas y la velocidad de tu carro por m�s de un umbral, sanci�n ??

c. Si ganas 2 veces seguidas la apuesta, trikiti (sanci�n por dinero solo la mitad de lo que tienes) ??

d. Si pierdes al apostar, trikiti (sanci�n por dinero solo un cuarto de lo que tienes) ??


## ? Simulaci�n de Grand Prix ??

**1. Dar al usuario la opci�n de elegir el piloto:**
- Inicia la simulaci�n ofreciendo al usuario la oportunidad de seleccionar su piloto para la competencia. ??

**2. Mostrar si quiere tunear el carro o hacer corrupci�n:**
- Luego de elegir el piloto, el usuario decide si desea tunear el carro o involucrarse en actividades de corrupci�n. ??

**3. Muestran sanciones que tienen los pilotos:**
Se muestran las sanciones que afectan a los pilotos, incluyendo penalizaciones en forma de p�rdida de dinero o tiempo. ?????
* a. Jugadores sancionados pierden plata.
* b. Jugadores sancionados les agregan tiempo.
* c. Se asignan las posiciones al inicio de la carrera.

**4. Ciclos - idea de simular el tiempo (un ciclo que se acaba cuando todos los carros pasen la meta):**
- Se simulan los ciclos de tiempo, y cada iteraci�n presenta la oportunidad de tomar decisiones diferentes. ??
    * Cada iteraci�n tiene la posibilidad de mostrar decisiones diversas.
    * Se actualiza el nivel de gasolina en cada iteraci�n.
- Si se agota la gasolina, se produce un choque y una sanci�n.

**4. Decisiones de carrera:**

a. Aprovechar DRS (Adelantar):
- Aumenta la velocidad, pero da�a el aler�n y aumenta la probabilidad de choque.

b. Frenar (Debe frenar para entrar a pits):
- Disminuye la velocidad, puede da�ar las llantas y disminuye la posici�n. Permite ingresar a los pits.

c. Hacer Maniobra (BONUS):
- Puede resultar en un choque o adelantar 5 posiciones.

d. Defender Posici�n:
- Mantiene la velocidad actual y puede aumentar o disminuir 1 posici�n.

e. Derrapar:
- Mantiene la velocidad actual, puede da�ar las llantas y aumenta la probabilidad de choque.

f. Parada de Pits (Pit Stop) (si la velocidad es baja):
- Llena el tanque de gasolina y cambia partes da�adas, lo cual cuesta dinero del patrocinio.

**5. Asignar puntos a los jugadores:**
- Se otorgan puntos a los jugadores seg�n su posici�n al final de la carrera.

a. Seg�n la posici�n, se asignan puntos:
- 1� - 8 puntos
- 2� - 7 puntos
- 3� - 6 puntos
- 4� - 5 puntos
- 5� - 4 puntos
- 6� - 3 puntos
- 7� - 2 puntos
- 8� - 1 punto

**6. Mostrar resultados:**
- Se muestran los resultados de la carrera, incluyendo la verificaci�n de sanciones por corrupci�n, la tabla de posiciones y el tiempo.

a. Verificar por sanciones - Corrupci�n.
b. Visualizar la tabla de posiciones y tiempo.
c. Realizar la ceremonia de premiaci�n.

**7. Opci�n: �Repetir el programa?**
- El usuario tiene la opci�n de repetir el programa para participar en una nueva carrera o competici�n. ??

##

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/Q_uKBniY)

:D