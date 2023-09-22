#
# LÍNEA DE FUNCIONALIDAD PROYECTO POO


# Preparar Campeonato

Usuario (POV)

1. Escoger entre 5 campeonatos (pre hechos)
1. núm determinado de carreras
2. 5 continentes: América, Europa, Asia, África, Oceanía
2. Elegir año
3. Elegir detalles además del campeonato (A pensar)
1. Elegir director de carrera
4. Seleccionar SU Equipo (los demás son ahi x)
1. Elija nombre del equipo: ENUM
2. Mostrar pilotos del Equipo
3. Elegir 2 pilotos
5. Negociaciones (Patrocinadores - opcional)
1. Mostrar lista patrocinadores
2. Poner dinero a pedir
3. Segun Random - le da el patrocinio
4. Mostrar Dinero recibido


# Planificar Calendario de Carreras

1. De acuerdo a el campeonato (cant), prepara todas

Para cada una

1. Mostrar opciones de Carreras
1. Nombre
2. Ciudad - Continente
3. Premio
4. Distancia
2. Elegir mes
1. Elegir condiciones climáticas
2. afecta las probabilidades
3. Elegir circuito
4. (Reservar Circuito) ESTO PUEDE
1. Elegir patrocinador
2. Random - pagan lo que vale
5. Elegir dificultad de Carrera
1. Niveles: chocarse, probabilidades de adelantar



# Tunear el Carro
Para primera carrera:

1. Mostrar carros disponibles para el equipo
2. Seleccionar el carro según el presupuesto
3. Mejoras o cambios al carro:
   1. Hay diferentes partes disponibles
    1. Llantas
    2. Alerón
    3. Motor
       2. Algunas partes aumentan la velocidad y otras la maniobrabilidad del vehículo
       3. Velocidad -\> Cuánto recorre en cuanto tiempo
       4. Maniobrabilidad -\> Chance de chocarse
2. Para carreras subsecuentes:
1. Negociar
2. Opción de reparar el carro.
3. Opción de cambiar las partes.
3. Abrir un regalo (opción)


# Corrupción

1. Antes de cada carrera, se pregunta al usuario si quiere obtener "favores especiales" del director de carrera.
1. Sike, es la mafia.
2. Si dice que sí, tiene que proponer una cantidad de dinero.
3. Se muestran luego las siguientes opciones con la cantidad de dinero que ofreció.

Acá se puede:

1. Se pueden ver las stats de los otros competidores
2. Se pueden cambiar las posiciones iniciales (solo la del jugador)
3. Se pueden cambiar las partes por unas de contrabando con mejores stats
4. Puedes hacer chocar a los otros competidores
5. Apuestas ilegales: Para las siguientes, se apuesta todo y se devuelve el doble de lo apostado
1. Juego de escoger el vaso: Se da un tablero 5 x 5. Que elija una casilla y mire si hay una bolita dentro de esa casilla. Si escogió una casilla con bolita, gana.
6. Validaciones:
1. Si cambia su posición más de 2 veces, trikiti (sanción por tiempo)
2. Si cambia la velocidad de su carro por más de un umbral, trikiti (sanción por tiempo)
3. Si gana 2 veces seguidas la apuesta, trikiti (sanción por dinero solo la mitad que tiene)
4. Si pierde el juego, trikiti (sanción por dinero solo un cuarto de lo que tiene)
5. Que si hace chocar a dos competidores, trikiti (sanción por posición)


# Simulación de Grand Prix

1. Dar al usuario la opción de elegir el piloto
2. Mostrar si quiere tunear el carro o hacer corrupcion
3. Muestran sanciones que tienen los pilotos
1. Jugadores sancionados pierden plata
2. Jugadores sancionados les agregan tiempo
3. Asignan las posiciones al inicio carrera
4. Ciclos - idea de simular el tiempo (un ciclo que se acaba cuando todos los carros pasen la meta):
1. Cada iteración tiene **chance** de mostrar decisiones diferentes
2. Se actualice gasolina en cada iteración
   1. Si se acaba la gasolina, se choca y sanción.
3. Decisiones:
   1. Aprovechar DRS (Adelantar) - Aumenta velocidad
    1. Daña el alerón
    2. Aumenta 2 posiciones
    3. Usa la probabilidad de chocar
       2. Frenar (Debe frenar para entrar a pits) - Disminuye la velocidad
    1. Daña las llantas
    2. Disminuye 1 posición
    3. Puede entrar a Pits
       3. Hacer Maniobra (RE BONUS) -
    1. Chocar
    2. Adelantar 5 Posiciones
       4. Defender Posición (Pussy) - Mantiene la velocidad actual
    1. Aumentar o disminuir 1 posición
       5. Derrapar RAAAAAAAAAAAAAAAA - Mantiene la velocidad
    1. Dañar las llantas
    2. Aumentar 1 posición
    3. Usa la probabilidad de choque
       6. (Si velocidad baja) Parada de Pits (Pit Stop)
    1. Llename todo (de **gasolina** ) (a ella le gusta la gasolina (dale mas gasolina) a ella le encanta la gasolina (dale mas gasolina))
    2. Cambiar partes dañadas:
    1. Cuesta plata del patrocinio
    2. Aumenta la velocidad (si estaba dañado)
5. Asignar puntos a los jugadores:
1. Según la posición, puntos.
   1. 1º - 8 puntos
   2. 2º - 7 puntos
   3. 3º - 6 puntos
   4. 4º - 5 puntos
   5. 5º - 4 puntos
   6. 6º - 3 puntos
   7. 7º - 2 puntos
   8. 8º - 1 punto
6. Mostrar resultados:
1. Verificar por sanciones - Corrupción
2. Ver la tabla de posiciones y tiempo
3. Premiación
7. Opción: ¿Repetir el programa?




# Notas

- Segun el tiempo -\> agregar opcion de crear ademas de elegir
- Velocidad en el vehículo -\> dependieno de las partes del carro
- Capa de Persistencia: Se van a guardar
    - Pilotos:
        - Puntos
        - Sanciones
            - Tres sanciones -\> Bloqueao
        - Equipo
    - Equipos:
        - Trofeos
            - Dinero inicial


# CLASES

ESTRUCTURA:

* gestorAplicación
  * paddock
    * Patrocinador
    * Persona
    * Pieza
    * Piloto
    * Vehiculo
  * campeonato
    * Campeonato
    * Carrera
    * Ciudad
    * DirectorCarrera
    * Equipo
    * VehiculoDeCarrera

## Campeonato

### Atributos

- int id
- String nombre
- int ano
- int numCarreras
- ArrayList\<Carrera\> listaCarreras
- ArrayList\<Equipo\> listaEquipos
- String continente
- int premio
- static ArrayList\<Campeonato\> campeonatos

### _Métodos_

- get and set for all attributes
- void agregarCarrera(Carrera carrera) //Agrega una carrera al ArrayList carrera
- ArrayList\<Equipo\> premiacionEquipos() // Le da la plata al equipo que ganó y organiza los equipos por puntos de manera descendente
- ArrayList\<Piloto\> premiacionPiloto() // Le da los puntos a cada piloto y los organiza por puntos de manera descendente
- void elegirEquipo(int id) // Le dice al programa qué equipo eligió el usuario

### Notas

- ENUM: Ciudades (Objetos tipo ciudad, con atributo String continente)

## Ciudad

### Atributos

- String nombre
- String continente

### Notas

- Continente -\> enum

## Carrera

### Atributos

- int id
- int mes
- String nombreCircuito
- double distancia
- double premioEfectivo
- Ciudad ciudad
- DirectorCarrera directorCarrera
- Campeonato campeonato
- ArrayList\<VehiculoDeCarrera\> posiciones
- double clima //.05 soleado, .10 lluvia, .15 tormenta (esto es muerte)
- double dificultad
-

### Métodos

- get and set for all attributes
- VehiculoCarrera posicionFinal(ArrayList\<VehiculosCarrera\> posiciones) // Sortear random 😛
- ArrayList\<Piloto\> sancionesPilotos() // Va a la clase VehiculoCarrera, coje el piloto, y lo guarda en una lista. Organiza la lista de acuerdo al número de sanciones
- ArrayList\<VehiculoCarrera\> simularCarrera() //Retorna posiciones
    - void opcionesDecision(int) //
    - int aprovecharDRS() // Devuelve positivo y aplica prob. chocarse
    - int frenar() // Devuelve negativo
    - int hacerManiobra() // Devuelva 0 y aplica prob. chocarse
    - int defenderPosicion() //Devuelve 0 y no hace nada
    - int derrapar() // Devuelve positivo y aplica prob. chocarse
    - ArrayList\<int\> pitStop() // Devuelve las opciones que hay para la Pit Stop.
- void asignarPuntos(ArrayList\<VehiculoCarrera\> posiciones) // Le asigna los puntos según las posiciones
- string verificarCorrupcion(DirectorCarrera directorCarrera) //mira si hay mas de 3 casos de corrupcion, si si, se descalifica al equipo del piloto

### Notas

- Todo es mental

## Persona

### Atributos

- int id
- String nombreCompleto
- String pais

### Métodos

-

### Notas

-

## Piloto

### Atributos

- Equipo equipo
- int puntos
- int sanciones
- ArrayList\<String\> victorias
- double habilidad //Probabilidad de chocarse
- boolean disponible

### Métodos

- void agregarVictorias(string victoria) //Agrega una victoria al arraylist
- void escogerCarro(double precio) //Crea VehiculoCarrera
- string toString() //Imprime "Hola soy Homero Simpson y tengo len.victorias victorias. Sigueme en twitter, instagram, youtube, facebook, telegram, whatsapp, tiktok, wordpress, linkedin, pinterest,
- void agregarSanciones() //Aumenta en 1 las sanciones
- void hacerTriquiñuelas() //Comienza la corrupción

### Notas

- Todo es (casi) mental

## Patrocinador

### Atributos

- double dinero
- double dineroOfrecer
- double probAceptar
- Equipo equipoPatrocinado

### Métodos

- double patrocinar() // Si es true, devuelve plata. Si es false, te devuelve 0.

### Notas

-

## Vehiculo

### Atributos

- String marca
- String modelo //Nombre es marca + modelo
- int ano
- Pieza aleron
- Pieza neumaticos
- Pieza motor
- double Velocidad
- double Maniobrabilidad
- double precioUtilizar

### Métodos

- String toString() // Devuelve los stats

### Notas

- Esto no sabemos para qué es

## VehiculoCarrera

### Atributos

- Piloto piloto //Conductor
- double tiempo //Cuanto se demora en terminar la carrera, solo se calcula al final para obtener la posición final
- double distanciaRecorrida //Se usa sólo dentro del ciclo, se calcula en cada iteración para obtener la posición actual
- boolean terminado // Mira si terminó la carrera. Si se choca, esto pasa a true.
- boolean morido // Si está morido, lo manda al final de la lista de posiciones.
- double velocidadTuneao
- double probabilidadChoque
- int gasolina

### Métodos

- void chocar() //Coloca tiempo en 0, velocidad en 0, terminado en true y morido en true
- void cambiarMotor(Pieza motor, double dinero)
- void cambiarLlantas(Pieza llantas, double dinero)
- void cambiarAleron(Pieza aleron, double dinero)
- void repararVehiculo(double dinero)
- void llenarGasolina()

### Notas

-

## Pieza

### Atributos

- boolean danado //Mira si está danado o no
- double velocidadAnadida
- double maniobrabilidadAnadida
- String nombre
- double precio

### Métodos

- void arreglar() //Cambia danado a true
- void comprar(VehiculoCarrera veh) //

### Notas

-

## DirectorCarrera

### Atributos

- double plata
- boolean licencia
- Carrera carrera
- int corrupcion

### Métodos

- void ponerSancion(Piloto piloto) //le coloca una sanción
- ArrayList\<String\> favoresEspeciales(double plata) //Recibe el dinero y devuelve las acciones
- int verStatsCompetidores(double platametida) //Devuelve lo de las sanciones
- int cambiarPosIniciales(double platametida,int posicion) //Devuelve sanciones
- int tunearShaddy(double platametida, VehiculoCarrera veh)
- int hacerChocar(double platametida, VehiculoCarrera vehChocar) //Update chocado to true.
- int apuestasSubterraneas(double plata, VehiculoCarrera veh) // Triki

### Notas

-

## Equipo

### Atributos

- int id
- String nombre
- String pais
- double plata
- int puntos
- ArrayList\<Vehiculo\> vehiculosDisponibles
- ArrayList\<Piloto\> pilotosDisponibles
- Piloto piloto1
- Piloto piloto2

### Métodos

- boolean negociar() //Esto es para aceptar las probabilidades de aceptar.
    - double bajarPatrocinio() // Bajar el dinero ofrecido para subir las posibilidades de aceptar
    - double subirPatrocinio() //Subir el dinero ofrecido a cambio de bajar las posibilidades de aceptar
- Piloto elegirPiloto1(int id) //elige al piloto1 por el id
- Piloto elegirPiloto2(int id) //elige al piloto2 por el id

### Notas

-






[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/Q_uKBniY)




