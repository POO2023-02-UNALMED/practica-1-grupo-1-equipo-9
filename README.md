# 🏁 Proyecto de la Fédération Internationale de l'Automobile 🏎️💨

## Clases

### 1. Campeonato 🏆
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

Métodos:
- `void agregarCarrera(Carrera carrera)`: Agrega una carrera al ArrayList de carreras.
- `ArrayList<Equipo> premiacionEquipos()`: Distribuye el premio a los equipos ganadores y ordena los equipos por puntos descendentes.
- `ArrayList<Piloto> premiacionPiloto()`: Asigna puntos a cada piloto y los organiza por puntos descendentes.
- `void elegirEquipo(int id)`: Permite al usuario elegir un equipo.

### 2. Ciudad 🌆
Atributos:
- `String nombre`
- `String continente`

Notas:
- `continente` es un enum.

### 3. Carrera 🏁
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

Métodos:
- `VehiculoCarrera posicionFinal(ArrayList<VehiculoCarrera> posiciones)`: Ordena aleatoriamente las posiciones finales.
- `ArrayList<Piloto> sancionesPilotos()`: Organiza a los pilotos por número de sanciones.
- `ArrayList<VehiculoCarrera> simularCarrera()`: Simula la carrera y devuelve las posiciones.
- `void opcionesDecision(int)`: Realiza decisiones durante la carrera.
- `int aprovecharDRS()`: Devuelve un valor positivo y aplica una probabilidad de choque.
- `int frenar()`: Devuelve un valor negativo.
- `int hacerManiobra()`: Devuelve 0 y aplica una probabilidad de choque.
- `int defenderPosicion()`: Devuelve 0 y no realiza ninguna acción.
- `int derrapar()`: Devuelve un valor positivo y aplica una probabilidad de choque.
- `ArrayList<int> pitStop()`: Devuelve las opciones disponibles para la parada en boxes.
- `void asignarPuntos(ArrayList<VehiculoCarrera> posiciones)`: Asigna puntos según las posiciones.
- `String verificarCorrupcion(DirectorCarrera directorCarrera)`: Verifica si hay casos de corrupción en el director de carrera y descalifica al equipo del piloto si hay más de 5 casos.


### 4. Persona 👤
Atributos:
- `int id`
- `String nombre`
- `String pais`

### 5. Piloto 🏎️
Atributos:
- `Equipo equipo`
- `int puntos`
- `int sanciones`
- `ArrayList<String> victorias`
- `double habilidad`
- `boolean disponible`

Métodos:
- `void agregarVictorias(String victoria)`: Agrega una victoria al ArrayList.
- `void escogerCarro(double precio)`: Crea un VehiculoCarrera.
- `String toString()`: Imprime información del piloto.
- `void agregarSanciones()`: Aumenta en 1 las sanciones.
- `void hacerTriquiñuelas()`: Inicia la corrupción.


### 6. Patrocinador 💰
Atributos:
- `double dinero`
- `double dineroOfrecer`
- `double probAceptar`
- `Equipo equipoPatrocinado`

Métodos:
- `double patrocinar()`: Si es verdadero, devuelve dinero. Si es falso, devuelve 0.

### 7. Vehiculo 🚗
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

Métodos:
- `String toString()`: Devuelve las estadísticas del vehículo.
- `void comprar()`: Compra el vehículo, lo vuelve vehículo de carrera.
- 
### 8. VehiculoCarrera 🏎️
Atributos:
- `Piloto piloto`
- `double tiempo`
- `double distanciaRecorrida`
- `boolean terminado`
- `boolean morido`
- `double velocidadTuneao`
- `double probabilidadChoque`
- `int gasolina`

Métodos:
- `void chocar()`
- `void cambiarMotor(Pieza motor, double dinero)`
- `void cambiarLlantas(Pieza llantas, double dinero)`
- `void cambiarAleron(Pieza aleron, double dinero)`
- `void repararVehiculo(double dinero)`
- `void llenarGasolina()`


### 9. Pieza 🔧
Atributos:
- `boolean danado`
- `double velocidadAnadida`
- `double maniobrabilidadAnadida`
- `String nombre`
- `double precio`

Métodos:
- `void arreglar()`: Marca la pieza como reparada.
- `void comprar(VehiculoCarrera veh)`: Compra la pieza para el vehículo.

### 10. DirectorCarrera 🏁
Atributos:
- `double plata`
- `boolean licencia`
- `Carrera carrera`
- `int corrupcion`

Métodos:
- `void ponerSancion(Piloto piloto)`
- `ArrayList<String> favoresEspeciales(double plata)`
- `int verStatsCompetidores(double platametida)`
- `int cambiarPosIniciales(double platametida, int posicion)`
- `int tunearShaddy(double platametida, VehiculoCarrera veh)`
- `int hacerChocar(double platametida, VehiculoCarrera vehChocar)`
- `int apuestasSubterraneas(double plata, VehiculoCarrera veh)`

### 11. Equipo 🏎️
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

Métodos:
- `boolean negociar()`: Para aceptar las probabilidades de aceptación.
- `double bajarPatrocinio()`: Reduce el dinero ofrecido para aumentar las posibilidades de aceptación.
- `double subirPatrocinio()`: Aumenta el dinero ofrecido a cambio de reducir las posibilidades de aceptación.
- `Piloto elegirPiloto(int id)`: Elige al piloto1 por ID.
- `Piloto elegirPiloto2(int id)`: Elige al piloto2 por ID.


#

# 📝 Linea de Funcionalidades

## Preparar Campeonato 🏆

Usuario (POV) 👤

**1. Escoger entre 5 campeonatos predefinidos:**
- Mostrar Campeonatos predefinidos. 🏆
- Seleccionar un campeonato de una lista de 5 campeonatos preconfigurados. 🏁

**2. Elegir el año del campeonato:**
- Indicar el año en el que se llevará a cabo el campeonato. 📅

**3. Seleccionar SU Equipo:**
- Elegir un equipo para competir en el campeonato. Los demás equipos ya están predefinidos. 🚗
- 
**4. Mostrar pilotos del Equipo:**
- Visualizar la lista de pilotos disponibles en el equipo seleccionado. 👀

**5. Elegir 2 pilotos:**
- El primero que elija va a sel EL USUARIO (piloto1)
- Otro es el compañero de equipo (piloto2) 
- Seleccionar dos pilotos del equipo para representarlo en las carreras. 👥👥

**6. Negociaciones con Patrocinadores (opcional):**
- Realizar negociaciones con patrocinadores para obtener financiamiento adicional. (Opcional) 🤝💰
  1. Mostrar lista de patrocinadores:
     - Visualizar la lista de patrocinadores disponibles para las negociaciones. 👀📊
  2. Poner dinero a pedir:
     - Indicar la cantidad de dinero que se solicita a los patrocinadores en las negociaciones. 💵
  3. Según el resultado aleatorio, recibir el patrocinio:**
     - Basado en un resultado aleatorio, recibir el patrocinio de uno o más patrocinadores. 🎲💼
  
**. Mostrar el dinero recibido:**
- Verificar la cantidad de dinero que se ha recibido de los patrocinadores. 💰💸

## 📅 Planificar Calendario de Carreras 🏁

**1. De acuerdo con el campeonato (cantidad de carreras), prepara todas:**
- Genera el calendario de carreras de acuerdo al número de carreras en el campeonato. 🗓️

**2. Mostrar opciones de Ciudad:**
- Metodo en ciudad
- Se crea la carrera
- "Grand Prix de Ciudad"

1. Elegir el director de carrera:
    - Seleccionar un director de carrera que supervisará las carreras del campeonato. 👨‍🏫

**3. Elegir mes:**
- Para cada carrera, selecciona el mes en el que se llevará a cabo la carrera. 🗓️

**4. Elegir condiciones climáticas:**
- Para cada carrera, elige las condiciones climáticas que afectarán las probabilidades de los pilotos. 🌦️❄️🌪️

**5. Reservar Circuito (Opcional):**
- Para cada carrera, se puede optar por reservar un circuito. Esta opción puede estar disponible o no.
  1. Elegir patrocinador: Selecciona un patrocinador para la carrera.
  2. Valor aleatorio: El patrocinador pagará un monto aleatorio basado en su valor.

**6. Elegir dificultad de Carrera:**
- Para cada carrera, define la dificultad de la carrera. Puedes elegir entre diferentes niveles que afectarán aspectos como la probabilidad de choques y adelantamientos.
  1. Niveles de dificultad disponibles: Fácil, Intermedio, Difícil. 🌟🌟🌟

## 🛠️ Tunear el Carro 🚗

**1. Para la primera carrera:**

1. Mostrar carros disponibles para el equipo:
- Visualiza la lista de carros disponibles para tu equipo. 🚗👀

2. Seleccionar el carro según el presupuesto:
- Selecciona un carro de la lista de acuerdo a tu presupuesto. 💰🚗

c. Mejoras o cambios al carro:
1. Hay diferentes partes disponibles:
    1. Llantas
    2. Alerón
    3. Motor
2. Algunas partes aumentan la velocidad y otras la maniobrabilidad del vehículo. 🏁🔧
3. Velocidad: Cuánto recorre en cuanto tiempo. 🏎️🕒
4. Maniobrabilidad: Probabilidad de chocarse. 🚧🤞

**2. Para carreras subsecuentes:**

a. Negociar:
- Realiza negociaciones para obtener beneficios adicionales. 💬🤝

b. Opción de reparar el carro:
- Puedes elegir reparar el carro si ha sufrido daños durante carreras anteriores. 🛠️🚗

c. Opción de cambiar las partes:
- Cambia las partes del carro para mejorar su rendimiento. 🔧🔄

**3. Abrir un regalo (opcional):**
- Si está disponible, tienes la opción de abrir un regalo que podría contener mejoras o sorpresas para tu carro. 🎁🚗

## 🕵️ Corrupción en Carreras 🃏

**1. Antes de cada carrera:**
- Antes de cada carrera, se pregunta al usuario si desea obtener "favores especiales" del director de carrera. 🤫

**2. Si dice que sí, tiene que proponer una cantidad de dinero:**
- Si decides aceptar, debes ofrecer una cantidad de dinero como soborno. 💰💼

**3. Se muestran luego las siguientes opciones con la cantidad de dinero que ofreció:**
- Una vez que hayas ofrecido el soborno, se presentan las siguientes opciones disponibles según la cantidad de dinero que hayas ofrecido:

**Acá se puede:**

**4. Ver las estadísticas de los otros competidores:**
- Visualiza las estadísticas de los otros competidores para obtener información adicional. 📊🏎️

**5. Cambiar las posiciones iniciales (solo la del jugador):**
- Modifica la posición inicial del jugador antes de la carrera. 🏁🏎️

**6. Cambiar las partes por unas de contrabando con mejores estadísticas:**
- Realiza cambios en las partes del carro por piezas de contrabando con estadísticas mejoradas. 🔧🚗

**7. Puedes hacer chocar a los otros competidores:**
- Decide causar accidentes a otros competidores durante la carrera. 💥🚗

**8. Apuestas ilegales:**
- Participa en apuestas ilegales donde apuestas todo y puedes ganar el doble de lo apostado. 💸💼

**a. Juego de escoger el vaso:**
- Juega al juego de escoger el vaso en un tablero de 5x5. Elige una casilla y descubre si hay una bolita dentro de esa casilla. Si la casilla que eliges contiene una bolita, ganas la apuesta. 🎲🍀

**9. Validaciones:**

a. Si cambias tu posición más de 2 veces, sanción ⏳

b. Si compras piezas y la velocidad de tu carro por más de un umbral, sanción 🚗💨

c. Si ganas 2 veces seguidas la apuesta, sanción por dinero solo la mitad de lo que tienes 💰👀

d. Si pierdes al apostar, sanción por dinero solo un cuarto de lo que tienes 💸😞


## 🏁 Simulación de Grand Prix 🏎️

**1. Dar al usuario la opción de elegir el piloto:**
- Inicia la simulación ofreciendo al usuario la oportunidad de seleccionar su piloto para la competencia. 👤🏁

**2. Mostrar si quiere tunear el carro o hacer corrupción:**
- Luego de elegir el piloto, el usuario decide si desea tunear el carro o involucrarse en actividades de corrupción. 🚗💼

**3. Muestran sanciones que tienen los pilotos:**
Se muestran las sanciones que afectan a los pilotos, incluyendo penalizaciones en forma de pérdida de dinero o tiempo. ⚖️💰⏱️
* a. Jugadores sancionados pierden plata.
* b. Jugadores sancionados les agregan tiempo.
* c. Se asignan las posiciones al inicio de la carrera.

**4. Ciclos - idea de simular el tiempo (un ciclo que se acaba cuando todos los carros pasen la meta):**
- Se simulan los ciclos de tiempo, y cada iteración presenta la oportunidad de tomar decisiones diferentes. 🔄🏁
    * Cada iteración tiene la posibilidad de mostrar decisiones diversas.
    * Se actualiza el nivel de gasolina en cada iteración.
- Si se agota la gasolina, se produce un choque y una sanción.

**4. Decisiones de carrera:**

a. Aprovechar DRS (Adelantar):
- Aumenta la velocidad, pero daña el alerón y aumenta la probabilidad de choque.

b. Frenar (Debe frenar para entrar a pits):
- Disminuye la velocidad, puede dañar las llantas y disminuye la posición. Permite ingresar a los pits.

c. Hacer Maniobra (BONUS):
- Puede resultar en un choque o adelantar 5 posiciones.

d. Defender Posición:
- Mantiene la velocidad actual y puede aumentar o disminuir 1 posición.

e. Derrapar:
- Mantiene la velocidad actual, puede dañar las llantas y aumenta la probabilidad de choque.

f. Parada de Pits (Pit Stop) (si la velocidad es baja):
- Llena el tanque de gasolina y cambia partes dañadas, lo cual cuesta dinero del patrocinio.

**5. Asignar puntos a los jugadores:**
- Se otorgan puntos a los jugadores según su posición al final de la carrera.

a. Según la posición, se asignan puntos:
- 1º - 8 puntos
- 2º - 7 puntos
- 3º - 6 puntos
- 4º - 5 puntos
- 5º - 4 puntos
- 6º - 3 puntos
- 7º - 2 puntos
- 8º - 1 punto

**6. Mostrar resultados:**
- Se muestran los resultados de la carrera, incluyendo la verificación de sanciones por corrupción, la tabla de posiciones y el tiempo.
    1. Verificar por sanciones - Corrupción.
    2. Visualizar la tabla de posiciones y tiempo.
    3. Realizar la ceremonia de premiación.

**7. Opción: ¿Repetir el programa?**
- El usuario tiene la opción de repetir el programa para participar en una nueva carrera o competición. ♻🔄

##

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/Q_uKBniY)

:D