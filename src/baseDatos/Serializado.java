package baseDatos;

import gestorAplicacion.campeonato.*;
import gestorAplicacion.paddock.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializado {
    public static void main(String[] args) throws IOException {
        crearObjetos();
        ////////////////////////// CAMPEONATOS  //////////////////////////

        FileOutputStream fileOutputStream1 = new FileOutputStream("src\\baseDatos\\temp\\datosCampeonatos.txt");
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);

        objectOutputStream1.writeObject(Campeonato.campeonatos);

        objectOutputStream1.close();
        fileOutputStream1.close();

        ////////////////////////// CIUDADES  //////////////////////////

        FileOutputStream fileOutputStream2 = new FileOutputStream("src\\baseDatos\\temp\\datosCiudades.txt");
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);

        objectOutputStream2.writeObject(Ciudad.listaCiudades);

        objectOutputStream2.close();
        fileOutputStream2.close();


        ////////////////////////// DIRECTORES  //////////////////////////

        FileOutputStream fileOutputStream3 = new FileOutputStream("src\\baseDatos\\temp\\datosDirectores.txt");
        ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(fileOutputStream3);

        objectOutputStream3.writeObject(DirectorCarrera.listaDirectores);

        objectOutputStream3.close();
        fileOutputStream3.close();


        ////////////////////////// EQUIPOS  //////////////////////////


        FileOutputStream fileOutputStream4 = new FileOutputStream("src\\baseDatos\\temp\\datosEquipos.txt");
        ObjectOutputStream objectOutputStream4 = new ObjectOutputStream(fileOutputStream4);

        objectOutputStream4.writeObject(Equipo.equipos);

        objectOutputStream4.close();
        fileOutputStream4.close();

        ////////////////////////// PATROCINADORES  //////////////////////////

        FileOutputStream fileOutputStream5 = new FileOutputStream("src\\baseDatos\\temp\\datosPatrocinadores.txt");
        ObjectOutputStream objectOutputStream5 = new ObjectOutputStream(fileOutputStream5);

        objectOutputStream5.writeObject(Patrocinador.listaPatrocinadores);

        objectOutputStream5.close();
        fileOutputStream5.close();


        ////////////////////////// PIEZAS  //////////////////////////


        FileOutputStream fileOutputStream6 = new FileOutputStream("src\\baseDatos\\temp\\datosPiezas.txt");
        ObjectOutputStream objectOutputStream6 = new ObjectOutputStream(fileOutputStream6);

        objectOutputStream6.writeObject(Pieza.getPiezas());


        objectOutputStream6.close();
        fileOutputStream6.close();


        ////////////////////////// PILOTOS  //////////////////////////


        FileOutputStream fileOutputStream8 = new FileOutputStream("src\\baseDatos\\temp\\datosPilotos.txt");
        ObjectOutputStream objectOutputStream8 = new ObjectOutputStream(fileOutputStream8);

        objectOutputStream8.writeObject(Piloto.listaPilotos);

        objectOutputStream8.close();
        fileOutputStream8.close();


        ////////////////////////// CHASIS  //////////////////////////

        FileOutputStream fileOutputStream9 = new FileOutputStream("src\\baseDatos\\temp\\datosChasis.txt");
        ObjectOutputStream objectOutputStream9 = new ObjectOutputStream(fileOutputStream9);

        objectOutputStream9.writeObject(Chasis.listaChasis);

        objectOutputStream9.close();
        fileOutputStream9.close();

        ////////////////////////// VEHICULO CARRERA  //////////////////////////

        FileOutputStream fileOutputStream10 = new FileOutputStream("src\\baseDatos\\temp\\datosVehiculos.txt");
        ObjectOutputStream objectOutputStream10 = new ObjectOutputStream(fileOutputStream10);

        objectOutputStream10.writeObject(VehiculoCarrera.getListaVehiculosCarrera());

        objectOutputStream10.close();
        fileOutputStream10.close();

        ////////////////////////// CIRCUITOS  //////////////////////////

        FileOutputStream fileOutputStream11 = new FileOutputStream("src\\baseDatos\\temp\\datosCircuitos.txt");
        ObjectOutputStream objectOutputStream11 = new ObjectOutputStream(fileOutputStream11);

        objectOutputStream11.writeObject(Circuito.getCircuitos());

        objectOutputStream11.close();
        fileOutputStream11.close();


    }

    private static void crearObjetos() {

        // patrocinadores
        new Patrocinador("Rolex");
        new Patrocinador("Heineken");
        new Patrocinador("Emirates");
        new Patrocinador("Pirelli");
        new Patrocinador("DHL");
        new Patrocinador("Petronas");
        new Patrocinador("Santander");
        new Patrocinador("Red Bull");
        new Patrocinador("Shell");
        new Patrocinador("Honda");
        new Patrocinador("Aston Martin");
        new Patrocinador("Lenovo");
        new Patrocinador("Acer");
        new Patrocinador("UPS");
        new Patrocinador("Oracle");
        new Patrocinador("Cisco");
        new Patrocinador("TotalEnergies");
        new Patrocinador("AWS (Amazon Web Services)");
        new Patrocinador("Cognizant");
        new Patrocinador("BWT (Best Water Technology)");
        new Patrocinador("Rich Energy");
        new Patrocinador("INEOS");
        new Patrocinador("Infiniti");
        new Patrocinador("ROKiT");
        new Patrocinador("Mouser Electronics");
        new Patrocinador("Epson");
        new Patrocinador("Claro");
        new Patrocinador("Martini");
        new Patrocinador("Ray-Ban");
        new Patrocinador("Hugo Boss");
        new Patrocinador("Philips");
        new Patrocinador("Rolex");
        new Patrocinador("IWC Schaffhausen");
        new Patrocinador("Rolex");
        new Patrocinador("Weichai");
        new Patrocinador("AirAsia");
        new Patrocinador("Viessmann");
        new Patrocinador("Giti Tire");
        new Patrocinador("188BET");
        new Patrocinador("Brembo");
        new Patrocinador("UBS");
        new Patrocinador("Santander");
        new Patrocinador("Aldo");
        new Patrocinador("UST Global");
        new Patrocinador("Tommy Hilfiger");
        new Patrocinador("PerkinElmer");

        // Ciudades
        // Ciudades en Africa
        Ciudad ciudadDelSahara = new Ciudad("Ciudad del Sahara", Continente.Africa);
        Ciudad casablanca = new Ciudad("Casablanca", Continente.Africa);
        Ciudad elCairo = new Ciudad("El Cairo", Continente.Africa);
        Ciudad johannesburgo = new Ciudad("Johannesburgo", Continente.Africa);
        Ciudad marrakech = new Ciudad("Marrakech", Continente.Africa);
        Ciudad ciudadDelCabo = new Ciudad("Ciudad del Cabo", Continente.Africa);
        Ciudad tunez = new Ciudad("Tunez", Continente.Africa);
        Ciudad argel = new Ciudad("Argel", Continente.Africa);
        Ciudad dakar = new Ciudad("Dakar", Continente.Africa);
        Ciudad nairobi = new Ciudad("Nairobi", Continente.Africa);
        Ciudad lusaka = new Ciudad("Lusaka", Continente.Africa);
        Ciudad khartoum = new Ciudad("Khartoum", Continente.Africa);
        Ciudad kigali = new Ciudad("Kigali", Continente.Africa);
        Ciudad luanda = new Ciudad("Luanda", Continente.Africa);
        Ciudad windhoek = new Ciudad("Windhoek", Continente.Africa);
        Ciudad gaborone = new Ciudad("Gaborone", Continente.Africa);
        Ciudad antananarivo = new Ciudad("Antananarivo", Continente.Africa);
        Ciudad abuja = new Ciudad("Abuja", Continente.Africa);
        Ciudad kinshasa = new Ciudad("Kinshasa", Continente.Africa);
        Ciudad bamako = new Ciudad("Bamako", Continente.Africa);

        // Ciudades en America
        Ciudad ciudadDeMexico = new Ciudad("Ciudad de Mexico", Continente.America);
        Ciudad saoPaulo = new Ciudad("Sao Paulo", Continente.America);
        Ciudad buenosAires = new Ciudad("Buenos Aires", Continente.America);
        Ciudad montreal = new Ciudad("Montreal", Continente.America);
        Ciudad indianapolis = new Ciudad("Indianapolis", Continente.America);
        Ciudad austin = new Ciudad("Austin", Continente.America);
        Ciudad miami = new Ciudad("Miami", Continente.America);
        Ciudad lasVegas = new Ciudad("Las Vegas", Continente.America);
        Ciudad nuevaYork = new Ciudad("Nueva York", Continente.America);
        Ciudad losAngeles = new Ciudad("Los Angeles", Continente.America);
        Ciudad chicago = new Ciudad("Chicago", Continente.America);
        Ciudad toronto = new Ciudad("Toronto", Continente.America);
        Ciudad bogota = new Ciudad("Bogota", Continente.America);
        Ciudad lima = new Ciudad("Lima", Continente.America);
        Ciudad caracas = new Ciudad("Caracas", Continente.America);
        Ciudad santiago = new Ciudad("Santiago", Continente.America);
        Ciudad quito = new Ciudad("Quito", Continente.America);
        Ciudad sanJuan = new Ciudad("San Juan", Continente.America);
        Ciudad laHabana = new Ciudad("La Habana", Continente.America);
        Ciudad rioDeJaneiro = new Ciudad("Rio de Janeiro", Continente.America);

        // Ciudades en Asia
        Ciudad shanghai = new Ciudad("Shanghai", Continente.Asia);
        Ciudad singapur = new Ciudad("Singapur", Continente.Asia);
        Ciudad tokio = new Ciudad("Tokio", Continente.Asia);
        Ciudad shenzhen = new Ciudad("Shenzhen", Continente.Asia);
        Ciudad abuDabi = new Ciudad("Abu Dabi", Continente.Asia);
        Ciudad bahrain = new Ciudad("Bahrain", Continente.Asia);
        Ciudad kualaLumpur = new Ciudad("Kuala Lumpur", Continente.Asia);
        Ciudad mumbai = new Ciudad("Mumbai", Continente.Asia);
        Ciudad delhi = new Ciudad("Delhi", Continente.Asia);
        Ciudad doha = new Ciudad("Doha", Continente.Asia);
        Ciudad estambul = new Ciudad("Estambul", Continente.Asia);
        Ciudad baku = new Ciudad("Baku", Continente.Asia);
        Ciudad jeddah = new Ciudad("Jeddah", Continente.Asia);
        Ciudad hanoi = new Ciudad("Hanoi", Continente.Asia);
        Ciudad manila = new Ciudad("Manila", Continente.Asia);
        Ciudad seoul = new Ciudad("Seoul", Continente.Asia);
        Ciudad sriJayawardenepuraKotte = new Ciudad("Sri Jayawardenepura Kotte", Continente.Asia);
        Ciudad kuwait = new Ciudad("Kuwait", Continente.Asia);
        Ciudad yeda = new Ciudad("Yeda", Continente.Asia);
        Ciudad dubai = new Ciudad("Dubai", Continente.Asia);

        // Ciudades en Europa
        Ciudad monaco = new Ciudad("Monaco", Continente.Europa);
        Ciudad barcelona = new Ciudad("Barcelona", Continente.Europa);
        Ciudad milan = new Ciudad("Milan", Continente.Europa);
        Ciudad hockenheim = new Ciudad("Hockenheim", Continente.Europa);
        Ciudad budapest = new Ciudad("Budapest", Continente.Europa);
        Ciudad spaFrancorchamps = new Ciudad("Spa-Francorchamps", Continente.Europa);
        Ciudad monza = new Ciudad("Monza", Continente.Europa);
        Ciudad suzuka = new Ciudad("Suzuka", Continente.Europa);
        Ciudad nurburgring = new Ciudad("Nurburgring", Continente.Europa);
        Ciudad montecarlo = new Ciudad("Montecarlo", Continente.Europa);
        Ciudad londres = new Ciudad("Londres", Continente.Europa);
        Ciudad paris = new Ciudad("Paris", Continente.Europa);
        Ciudad berlin = new Ciudad("Berlin", Continente.Europa);
        Ciudad amsterdam = new Ciudad("Amsterdam", Continente.Europa);
        Ciudad viena = new Ciudad("Viena", Continente.Europa);
        Ciudad varsovia = new Ciudad("Varsovia", Continente.Europa);
        Ciudad roma = new Ciudad("Roma", Continente.Europa);
        Ciudad lisboa = new Ciudad("Lisboa", Continente.Europa);
        Ciudad estocolmo = new Ciudad("Estocolmo", Continente.Europa);
        Ciudad oslo = new Ciudad("Oslo", Continente.Europa);

        // Ciudades en Oceania
        Ciudad melbourne = new Ciudad("Melbourne", Continente.Oceania);
        Ciudad sydney = new Ciudad("Sydney", Continente.Oceania);
        Ciudad adelaida = new Ciudad("Adelaida", Continente.Oceania);
        Ciudad auckland = new Ciudad("Auckland", Continente.Oceania);
        Ciudad perth = new Ciudad("Perth", Continente.Oceania);
        Ciudad brisbane = new Ciudad("Brisbane", Continente.Oceania);
        Ciudad wellington = new Ciudad("Wellington", Continente.Oceania);
        Ciudad suva = new Ciudad("Suva", Continente.Oceania);
        Ciudad honolulu = new Ciudad("Honolulu", Continente.Oceania);
        Ciudad papeete = new Ciudad("Papeete", Continente.Oceania);
        Ciudad nadi = new Ciudad("Nadi", Continente.Oceania);
        Ciudad palmira = new Ciudad("Palmira", Continente.Oceania);
        Ciudad darwin = new Ciudad("Darwin", Continente.Oceania);
        Ciudad fiyi = new Ciudad("Fiyi", Continente.Oceania);
        Ciudad boraBora = new Ciudad("Bora Bora", Continente.Oceania);
        Ciudad noumea = new Ciudad("Noumea", Continente.Oceania);
        Ciudad hobart = new Ciudad("Hobart", Continente.Oceania);
        Ciudad goldCoast = new Ciudad("Gold Coast", Continente.Oceania);
        Ciudad canberra = new Ciudad("Canberra", Continente.Oceania);
        Ciudad queenstown = new Ciudad("Queenstown", Continente.Oceania);

        // Equipos
        new Equipo("Mercedes-AMG Petronas Formula One Team");
        new Equipo("Red Bull Racing");
        new Equipo("Scuderia Ferrari");
        new Equipo("McLaren F1 Team");
        new Equipo("Aston Martin Cognizant Formula One Team");
        new Equipo("Alpine F1 Team");
        new Equipo("Scuderia AlphaTauri");
        new Equipo("Alfa Romeo Racing");
        new Equipo("Williams Racing");
        new Equipo("Haas F1 Team");
        new Equipo("Racing Point F1 Team");
        new Equipo("Lotus F1 Team");
        new Equipo("Renault F1 Team");
        new Equipo("BMW Sauber F1 Team");
        new Equipo("Brawn GP Formula One Team");
        new Equipo("Caterham F1 Team");
        new Equipo("Marussia F1 Team");
        new Equipo("Virgin Racing");
        new Equipo("HRT Formula 1 Team");
        new Equipo("Minardi F1 Team");
        new Equipo("Arrows Grand Prix International");
        new Equipo("Sauber");
        new Equipo("Ligier");
        new Equipo("Jordan Grand Prix");
        new Equipo("Prost Grand Prix");
       /* new Equipo("Stewart Grand Prix");
        new Equipo("Tyrrell Racing");
        new Equipo("Benetton Formula");
        new Equipo("Brabham");
        new Equipo("Lotus");
        new Equipo("Matra");
        new Equipo("March Engineering");
        new Equipo("Shadow Racing Cars");*/


        // campenatos
        new Campeonato("Desafio del Lejano Oriente", 3, Continente.Asia);
        new Campeonato("Ruta Europea de la Velocidad", 12, Continente.Europa);
        new Campeonato("Aventura en Tierras Australes", 9, Continente.Oceania);
        new Campeonato("Carrera de las Dunas", 6, Continente.Africa);
        new Campeonato("Gran Carrera Panamericana", 11, Continente.America);
        new Campeonato("Tour Asiatico de la Formula 1", 8, Continente.Asia);
        new Campeonato("Rally Europeo de Velocidad", 10, Continente.Europa);
        new Campeonato("Gran Desafio del Pacifico", 7, Continente.Oceania);
        new Campeonato("Campeonato de las Arenas Rojas", 8, Continente.Africa);
        new Campeonato("Carrera por America del Norte", 10, Continente.America);
        new Campeonato("Recorrido por Asia Oriental", 7, Continente.Asia);
        new Campeonato("Gran Tour Europeo", 12, Continente.Europa);
        new Campeonato("Expedicion Oceanica", 9, Continente.Oceania);
        new Campeonato("Carrera en el Sahara", 6, Continente.Africa);
        new Campeonato("Carrera de las Americas", 11, Continente.America);
        new Campeonato("Aventura en Asia Central", 8, Continente.Asia);
        new Campeonato("Campeonato Europeo de la Velocidad", 10, Continente.Europa);
        new Campeonato("Carrera austral", 7, Continente.Oceania);
        new Campeonato("Rally del Desierto", 8, Continente.Africa);
        new Campeonato("Gran Desafio Americano", 10, Continente.America);
        new Campeonato("Carrera en la Muralla China", 8, Continente.Asia);
        new Campeonato("Ruta Europea de la Formula 1", 12, Continente.Europa);
        new Campeonato("Gran Gira Oceanica", 9, Continente.Oceania);
        new Campeonato("Carrera de las Arenas Blancas", 8, Continente.Africa);
        new Campeonato("Campeonato de las Americas", 10, Continente.America);
        new Campeonato("Gran Carrera Asiatica", 7, Continente.Asia);
        new Campeonato("Circuito Europeo de Velocidad", 10, Continente.Europa);
        new Campeonato("Carrera en la Tierra de los Canguros", 9, Continente.Oceania);
        new Campeonato("Carrera Saharaui", 6, Continente.Africa);
        new Campeonato("Gran Ruta Panamericana", 11, Continente.America);
        new Campeonato("Desafio de Asia Central", 8, Continente.Asia);
        new Campeonato("Rally Europeo Continental", 10, Continente.Europa);
        new Campeonato("Gran Desafio del Sur del Pacifico", 7, Continente.Oceania);
        new Campeonato("Carrera de las Dunas Doradas", 8, Continente.Africa);
        new Campeonato("Campeonato de las Americas del Sur", 10, Continente.America);
        new Campeonato("Carrera en la Ruta de la Seda", 7, Continente.Asia);
        new Campeonato("Tour Europeo de la Velocidad", 12, Continente.Europa);
        new Campeonato("Carrera en la Tierra de los Kiwis", 9, Continente.Oceania);
        new Campeonato("Gran Rally del Sahara", 6, Continente.Africa);
        new Campeonato("Ruta Panamericana Extrema", 11, Continente.America);
        new Campeonato("Carreras por el Oriente", 8, Continente.Asia);
        new Campeonato("Campeonato Europeo de la Velocidad Extrema", 10, Continente.Europa);
        new Campeonato("Carrera en la Costa Australiana", 9, Continente.Oceania);
        new Campeonato("Carrera en el Desierto de los Faraones", 6, Continente.Africa);
        new Campeonato("Gran Carrera de las Americas", 11, Continente.America);
        new Campeonato("Carrera en el Lejano Oriente", 8, Continente.Asia);
        new Campeonato("Campeonato Europa a toda Velocidad", 10, Continente.Europa);
        new Campeonato("Carrera en Australiana Veloz", 9, Continente.Oceania);
        new Campeonato("Campeonato de las Arenas", 8, Continente.Africa);


        // Pilotos
        new Piloto("Jack Brabham");
        new Piloto("Graham Hill");
        new Piloto("Alberto Ascari");
        new Piloto("Sir Frank Williams");
        new Piloto("Sir Jackie Stewart");
        new Piloto("A.J. Foyt");
        new Piloto("Ronnie Peterson");
        new Piloto("Nico Rosberg");
        new Piloto("Alan Jones");
        new Piloto("Carlos Sainz");
        new Piloto("Max Verstappen");
        new Piloto("Jules Bianchi");
        new Piloto("Jean Alesi");
        new Piloto("Gerhard Berger");
        new Piloto("Eddie Irvine");
        new Piloto("Mark Webber");
        new Piloto("Robert Kubica");
        new Piloto("Juan Pablo Montoya");
        new Piloto("David Coulthard");
        new Piloto("Carlos Reutemann");
        new Piloto("Clay Regazzoni");
        new Piloto("Felipe Massa");
        new Piloto("Valtteri Bottas");
        new Piloto("Heikki Kovalainen");
        new Piloto("Denny Hulme");
        new Piloto("Jody Scheckter");
        new Piloto("Jacques Laffite");
        new Piloto("Olivier Panis");
        new Piloto("Pastor Maldonado");
        new Piloto("James Hunt");
        new Piloto("Jochen Rindt");
        new Piloto("Chris Amon");
        new Piloto("John Surtees");
        new Piloto("Patrick Depailler");
        new Piloto("Peter Revson");
        new Piloto("Ludovico Scarfiotti");
        new Piloto("Tony Brooks");
        new Piloto("Luigi Musso");
        new Piloto("John Watson");
        new Piloto("Michele Alboreto");
        new Piloto("Vittorio Brambilla");
        new Piloto("Jo Siffert");
        new Piloto("Francois Cevert");
        new Piloto("Dan Gurney");
        new Piloto("Jo Bonnier");
        new Piloto("Giancarlo Baghetti");
        new Piloto("Troy Ruttman");
        new Piloto("Alex Caffi");
        new Piloto("Roberto Guerrero");
        new Piloto("Brian Redman");
        new Piloto("Giancarlo Fisichella");
        new Piloto("Gerhard Mitter");
        new Piloto("Jo Ramirez");
        new Piloto("Jo Vonlanthen");
        new Piloto("Marco Apicella");
        new Piloto("Brian Naylor");
        new Piloto("Ignazio Giunti");
        new Piloto("Mike Beuttler");
        new Piloto("Pierluigi Martini");
        new Piloto("Michael Andretti");
        new Piloto("Stefan Bellof");
        new Piloto("Piero Taruffi");
        new Piloto("David Kennedy");
        new Piloto("Nino Farina");
        new Piloto("Alberto Uria");
        new Piloto("Luigi Villoresi");
        new Piloto("Wolfgang von Trips");
        new Piloto("Richie Ginther");
        new Piloto("Wolfgang Seidel");
        new Piloto("Sergio Mantovani");
        new Piloto("Peter Gethin");
        new Piloto("Luigi Fagioli");
        new Piloto("Jose Froilan Gonzalez");
        new Piloto("Harry Schell");
        new Piloto("Robert Manzon");
        new Piloto("Hans Herrmann");
        new Piloto("Piero Carini");
        new Piloto("Jacky Ickx");
        new Piloto("Elio de Angelis");
        new Piloto("Franco Rol");
        new Piloto("Clemar Bucci");
        new Piloto("Lucien Bianchi");
        new Piloto("Eugenio Castellotti");
        new Piloto("Cesar Baldaccini");
        new Piloto("Andre Pilette");
        new Piloto("Peter Whitehead");
        new Piloto("Antonio Branca");
        new Piloto("Philippe Etancelin");
        new Piloto("Cesare Perdisa");
        new Piloto("Jean Behra");
        new Piloto("Mike Hawthorn");
        new Piloto("Ettore Chimeri");
        new Piloto("Johnny Claes");
        new Piloto("Paul Frere");
        new Piloto("Andre Simon");
        new Piloto("Ken Wharton");
        new Piloto("George Amick");
        new Piloto("Paul Russo");
        new Piloto("Masten Gregory");
        new Piloto("Giorgio Scarlatti");
        new Piloto("Paco Godia");
        new Piloto("Elie Bayol");
        new Piloto("Umberto Maglioli");
        new Piloto("Ron Flockhart");
        new Piloto("Luigi Piotti");
        new Piloto("Bob Sweikert");
        new Piloto("Johnny Boyd");
        new Piloto("Larry Crockett");
        new Piloto("Jerry Hoyt");
        new Piloto("Henry Banks");
        new Piloto("Jimmy Daywalt");
        new Piloto("Ray Crawford");
        new Piloto("Jimmy Bryan");
        new Piloto("Pat Flaherty");
        new Piloto("Larry Jackson");
        new Piloto("Dick Rathmann");
        new Piloto("Ed Elisian");
        new Piloto("Johnnie Parsons");
        new Piloto("Jud Larson");
        new Piloto("Billy Garrett");
        new Piloto("Ed Fitz-Gerald");
        new Piloto("Jimmy Reece");
        new Piloto("Eddie Russo");
        new Piloto("Rodger Ward");
        new Piloto("Johnny Thomson");
        new Piloto("Mike Nazaruk");
        new Piloto("Sam Hanks");
        new Piloto("Eddie Johnson");
        new Piloto("Bill Schindler");
        new Piloto("Chuck Stevenson");
        new Piloto("Duane Carter");
        new Piloto("Bill Vukovich");
        new Piloto("Johnny McDowell");
        new Piloto("Tony Bettenhausen");
        new Piloto("Pat O'Connor");
        new Piloto("Jim Rathmann");
        new Piloto("Tony Bonadies");
        new Piloto("Dave Macdonald");
        new Piloto("Gary Congdon");
        new Piloto("Joe Sostilio");
        new Piloto("Jack Turner");
        new Piloto("Johnny White");
        new Piloto("Bud Tingelstad");
        new Piloto("Cliff Griffith");
        new Piloto("Chuck Arnold");
        new Piloto("Gene Hartley");
        new Piloto("Mike Magill");
        new Piloto("Al Herman");
        new Piloto("Bobby Marshman");
        new Piloto("Jim McWithey");
        new Piloto("Bob Mathouser");
        new Piloto("Dempsey Wilson");
        new Piloto("Al Miller");
        new Piloto("Eddie Sachs");
        new Piloto("Charles Leclerc");
        new Piloto("Chuck Rodee");
        new Piloto("Don Freeland");
        new Piloto("Buddy Lazier");
        new Piloto("Joe Leonard");
        new Piloto("Greg Weld");
        new Piloto("Art Pollard");
        new Piloto("Don Branson");
        new Piloto("Rubens Barrichello");
        new Piloto("Ricardo Zonta");
        new Piloto("Nico Hulkenberg");
        new Piloto("Alexander Albon");
        new Piloto("Antonio Giovinazzi");
        new Piloto("Takuma Sato");
        new Piloto("Alexander Rossi");
        new Piloto("Roland Ratzenberger");
        new Piloto("Tomas Scheckter");
        new Piloto("Max Chilton");
        new Piloto("Reno Arnoux");
        new Piloto("Henri Pescarolo");
        new Piloto("Johnny Servoz-Gavin");
        new Piloto("Maurice Trintignant");
        new Piloto("Peter Collins");
        new Piloto("Carlos Pace");
        new Piloto("Hector Rebaque");
        new Piloto("Ricardo Rodriguez");
        new Piloto("Oscar Gonzalez");
        new Piloto("Mario Andretti");

        // Directores de carrera
        DirectorCarrera dc1 = new DirectorCarrera("Charlie Whiting");
        DirectorCarrera dc2 = new DirectorCarrera("Michael Masi");
        DirectorCarrera dc3 = new DirectorCarrera("Herbie Blash");
        DirectorCarrera dc4 = new DirectorCarrera("Jacky Ickx");
        DirectorCarrera dc5 = new DirectorCarrera("Derek Ongaro");
        DirectorCarrera dc6 = new DirectorCarrera("Philippe Gachet");
        DirectorCarrera dc7 = new DirectorCarrera("Roland Bruynseraede");
        DirectorCarrera dc8 = new DirectorCarrera("Alain De Cadenet");
        DirectorCarrera dc9 = new DirectorCarrera("Roger Lane-Nott");
        DirectorCarrera dc10 = new DirectorCarrera("Bobby Rahal");
        DirectorCarrera dc11 = new DirectorCarrera("Jo Bauer");
        DirectorCarrera dc12 = new DirectorCarrera("Eduardo Freitas");
        DirectorCarrera dc13 = new DirectorCarrera("Paul Gutjahr");
        DirectorCarrera dc14 = new DirectorCarrera("Yves Bacquelaine");
        DirectorCarrera dc15 = new DirectorCarrera("Nick Craw");
        DirectorCarrera dc16 = new DirectorCarrera("Bjorn Nilsson");
        DirectorCarrera dc17 = new DirectorCarrera("Roger Peart");
        DirectorCarrera dc18 = new DirectorCarrera("Jean-Claude Lefebvre");
        DirectorCarrera dc19 = new DirectorCarrera("Tony Scott-Andrews");
        DirectorCarrera dc20 = new DirectorCarrera("Emanuele Pirro");
        DirectorCarrera dc21 = new DirectorCarrera("Gerd Ennser");
        DirectorCarrera dc22 = new DirectorCarrera("Joann Villeneuve");
        DirectorCarrera dc23 = new DirectorCarrera("Trevor Foster");
        DirectorCarrera dc24 = new DirectorCarrera("Erich Beck");
        DirectorCarrera dc25 = new DirectorCarrera("Richard Divila");
        DirectorCarrera dc26 = new DirectorCarrera("Dennis Carter");
        DirectorCarrera dc27 = new DirectorCarrera("Alan Donnelly");
        DirectorCarrera dc28 = new DirectorCarrera("Philip Gauthier");
        DirectorCarrera dc29 = new DirectorCarrera("Bruno Michel");
        DirectorCarrera dc30 = new DirectorCarrera("Garry Connelly");
        DirectorCarrera dc31 = new DirectorCarrera("Ian Reed");
        DirectorCarrera dc32 = new DirectorCarrera("Jose Abed");
        DirectorCarrera dc33 = new DirectorCarrera("Manfred Scheuer");
        DirectorCarrera dc34 = new DirectorCarrera("Steve Stringwell");
        DirectorCarrera dc35 = new DirectorCarrera("Yasumasa Arai");
        DirectorCarrera dc36 = new DirectorCarrera("Jorge H. Barados");
        DirectorCarrera dc37 = new DirectorCarrera("Walter Aeschlimann");
        DirectorCarrera dc38 = new DirectorCarrera("Eugenio Farcas");
        DirectorCarrera dc39 = new DirectorCarrera("Enzo Spano");
        DirectorCarrera dc40 = new DirectorCarrera("Joaquin Verdegay");
        DirectorCarrera dc41 = new DirectorCarrera("Niels Wittich");
        DirectorCarrera dc42 = new DirectorCarrera("Michel Boeri");
        DirectorCarrera dc43 = new DirectorCarrera("Hassan Al-Thawadi");
        DirectorCarrera dc44 = new DirectorCarrera("Jean-Pierre Nicolas");
        DirectorCarrera dc45 = new DirectorCarrera("Jean-Claude Basso");
        DirectorCarrera dc46 = new DirectorCarrera("Oscar Stafanini");


        new Circuito("Circuito del Dragon");
        new Circuito("Circuito Estelar");
        new Circuito("Circuito del Horizonte");
        new Circuito("Circuito de la Velocidad Suprema");
        new Circuito("Circuito de las Sombras");
        new Circuito("Circuito del Cielo Azul");
        new Circuito("Circuito de la Luna Roja");
        new Circuito("Circuito del Sol Eterno");
        new Circuito("Circuito de las Estrellas Doradas");
        new Circuito("Circuito de la Victoria Infinita");
        new Circuito("Circuito del Viento Rapido");
        new Circuito("Circuito del Rayo Veloz");
        new Circuito("Circuito de la Maravilla Mecanica");
        new Circuito("Circuito del Rugido del Motor");
        new Circuito("Circuito de la Curva del Dragon");
        new Circuito("Circuito de la Recta Sin Fin");
        new Circuito("Circuito de la Sombra Luminosa");
        new Circuito("Circuito del Desafio Supremo");
        new Circuito("Circuito de la Pasion Veloz");
        new Circuito("Circuito de la Aventura Extrema");
        new Circuito("Circuito de la Noche Estrellada");
        new Circuito("Circuito del Laberinto");
        new Circuito("Circuito de las Dunas Ardientes");
        new Circuito("Circuito del Oasis Veloz");
        new Circuito("Circuito del Vortice");
        new Circuito("Circuito de la Selva Secreta");
        new Circuito("Circuito de la Magia Mecanica");
        new Circuito("Circuito de la Euforia Veloz");
        new Circuito("Circuito de la Lluvia de Estrellas");
        new Circuito("Circuito de la Perfeccion Veloz");

        Piloto.asignarEquipo();


        // Chasis

        Chasis chasisF1_1 = new Chasis("Mercedes", "W12");
        Chasis chasisF1_2 = new Chasis("Red Bull Racing", "RB16B");
        Chasis chasisF1_3 = new Chasis("Ferrari", "SF21");
        Chasis chasisF1_4 = new Chasis("McLaren", "MCL35M");
        Chasis chasisF1_5 = new Chasis("Aston Martin", "AMR21");
        Chasis chasisF1_6 = new Chasis("Alpine", "A521");
        Chasis chasisF1_7 = new Chasis("AlphaTauri", "AT02");
        Chasis chasisF1_8 = new Chasis("Williams", "FW43B");
        Chasis chasisF1_9 = new Chasis("Alfa Romeo", "C41");
        Chasis chasisF1_10 = new Chasis("Haas", "VF-21");
        Chasis chasisF1_11 = new Chasis("Mercedes", "W12");
        Chasis chasisF1_12 = new Chasis("Red Bull Racing", "RB16B");
        Chasis chasisF1_13 = new Chasis("Ferrari", "SF21");
        Chasis chasisF1_14 = new Chasis("McLaren", "MCL35M");
        Chasis chasisF1_15 = new Chasis("Aston Martin", "AMR21");
        Chasis chasisF1_16 = new Chasis("Alpine", "A521");
        Chasis chasisF1_17 = new Chasis("AlphaTauri", "AT02");
        Chasis chasisF1_18 = new Chasis("Williams", "FW43B");
        Chasis chasisF1_19 = new Chasis("Alfa Romeo", "C41");
        Chasis chasisF1_20 = new Chasis("Haas", "VF-21");
        Chasis chasisF1_21 = new Chasis("Mercedes", "W12");
        Chasis chasisF1_22 = new Chasis("Red Bull Racing", "RB16B");
        Chasis chasisF1_23 = new Chasis("Ferrari", "SF21");
        Chasis chasisF1_24 = new Chasis("McLaren", "MCL35M");
        Chasis chasisF1_25 = new Chasis("Aston Martin", "AMR21");
        Chasis chasisF1_26 = new Chasis("Alpine", "A521");
        Chasis chasisF1_27 = new Chasis("AlphaTauri", "AT02");
        Chasis chasisF1_28 = new Chasis("Williams", "FW43B");
        Chasis chasisF1_29 = new Chasis("Alfa Romeo", "C41");
        Chasis chasisF1_30 = new Chasis("Haas", "VF-21");
        Chasis chasisF1_31 = new Chasis("Mercedes", "W12");
        Chasis chasisF1_32 = new Chasis("Red Bull Racing", "RB16B");
        Chasis chasisF1_33 = new Chasis("Ferrari", "SF21");
        Chasis chasisF1_34 = new Chasis("McLaren", "MCL35M");
        Chasis chasisF1_35 = new Chasis("Aston Martin", "AMR21");
        Chasis chasisF1_36 = new Chasis("Alpine", "A521");
        Chasis chasisF1_37 = new Chasis("AlphaTauri", "AT02");
        Chasis chasisF1_38 = new Chasis("Williams", "FW43B");
        Chasis chasisF1_39 = new Chasis("Alfa Romeo", "C41");
        Chasis chasisF1_40 = new Chasis("Haas", "VF-21");

        // vehiculosCarrera
    /*
        VehiculoCarrera vehiculoCarrera1 = new VehiculoCarrera(chasisF1_1);
        VehiculoCarrera vehiculoCarrera2 = new VehiculoCarrera(chasisF1_2);
        VehiculoCarrera vehiculoCarrera3 = new VehiculoCarrera(chasisF1_3);
        VehiculoCarrera vehiculoCarrera4 = new VehiculoCarrera(chasisF1_4);
        VehiculoCarrera vehiculoCarrera5 = new VehiculoCarrera(chasisF1_5);
        VehiculoCarrera vehiculoCarrera6 = new VehiculoCarrera(chasisF1_6);
        VehiculoCarrera vehiculoCarrera7 = new VehiculoCarrera(chasisF1_7);
        VehiculoCarrera vehiculoCarrera8 = new VehiculoCarrera(chasisF1_8);
        VehiculoCarrera vehiculoCarrera9 = new VehiculoCarrera(chasisF1_9);
        VehiculoCarrera vehiculoCarrera10 = new VehiculoCarrera(chasisF1_10);
        VehiculoCarrera vehiculoCarrera11 = new VehiculoCarrera(chasisF1_11);
        VehiculoCarrera vehiculoCarrera12 = new VehiculoCarrera(chasisF1_12);
        VehiculoCarrera vehiculoCarrera13 = new VehiculoCarrera(chasisF1_13);
        VehiculoCarrera vehiculoCarrera14 = new VehiculoCarrera(chasisF1_14);
        VehiculoCarrera vehiculoCarrera15 = new VehiculoCarrera(chasisF1_15);
        VehiculoCarrera vehiculoCarrera16 = new VehiculoCarrera(chasisF1_16);
        VehiculoCarrera vehiculoCarrera17 = new VehiculoCarrera(chasisF1_17);
        VehiculoCarrera vehiculoCarrera18 = new VehiculoCarrera(chasisF1_18);
        VehiculoCarrera vehiculoCarrera19 = new VehiculoCarrera(chasisF1_19);
        VehiculoCarrera vehiculoCarrera20 = new VehiculoCarrera(chasisF1_20);
        VehiculoCarrera vehiculoCarrera21 = new VehiculoCarrera(chasisF1_21);
        VehiculoCarrera vehiculoCarrera22 = new VehiculoCarrera(chasisF1_22);
        VehiculoCarrera vehiculoCarrera23 = new VehiculoCarrera(chasisF1_23);
        VehiculoCarrera vehiculoCarrera24 = new VehiculoCarrera(chasisF1_24);
        VehiculoCarrera vehiculoCarrera25 = new VehiculoCarrera(chasisF1_25);
        VehiculoCarrera vehiculoCarrera26 = new VehiculoCarrera(chasisF1_26);
        VehiculoCarrera vehiculoCarrera27 = new VehiculoCarrera(chasisF1_27);
        VehiculoCarrera vehiculoCarrera28 = new VehiculoCarrera(chasisF1_28);
        VehiculoCarrera vehiculoCarrera29 = new VehiculoCarrera(chasisF1_29);
        VehiculoCarrera vehiculoCarrera30 = new VehiculoCarrera(chasisF1_30);
        VehiculoCarrera vehiculoCarrera31 = new VehiculoCarrera(chasisF1_31);
        VehiculoCarrera vehiculoCarrera32 = new VehiculoCarrera(chasisF1_32);
        VehiculoCarrera vehiculoCarrera33 = new VehiculoCarrera(chasisF1_33);
        VehiculoCarrera vehiculoCarrera34 = new VehiculoCarrera(chasisF1_34);
        VehiculoCarrera vehiculoCarrera35 = new VehiculoCarrera(chasisF1_35);
        VehiculoCarrera vehiculoCarrera36 = new VehiculoCarrera(chasisF1_36);
        VehiculoCarrera vehiculoCarrera37 = new VehiculoCarrera(chasisF1_37);
        VehiculoCarrera vehiculoCarrera38 = new VehiculoCarrera(chasisF1_38);
        VehiculoCarrera vehiculoCarrera39 = new VehiculoCarrera(chasisF1_39);
        VehiculoCarrera vehiculoCarrera40 = new VehiculoCarrera(chasisF1_40);
        */
        //Piezas Mercedes

        Pieza aleron1 = new Pieza("WingMaster 9000", "A", "Mercedes");
        Pieza aleron2 = new Pieza("Aeroflare X1", "A", "Mercedes");
        Pieza aleron3 = new Pieza("TurboWing Zephyr", "A", "Mercedes");
        Pieza aleron4 = new Pieza("EcoWing Blade", "A", "Mercedes");
        Pieza aleron5 = new Pieza("HyperWing Fury", "A", "Mercedes");
        Pieza aleron6 = new Pieza("MegaFlow Glide", "A", "Mercedes");
        Pieza aleron7 = new Pieza("AeroDynamics X", "A", "Mercedes");
        Pieza aleron8 = new Pieza("TurboJetstream 500", "A", "Mercedes");
        Pieza aleron9 = new Pieza("SkySlicer Aero", "A", "Mercedes");
        Pieza aleron10 = new Pieza("AeroWing Infinity", "A", "Mercedes");

        Pieza motor1 = new Pieza("TurboThunder V8", "M", "Mercedes");
        Pieza motor2 = new Pieza("PowerBeast Pro", "M", "Mercedes");
        Pieza motor3 = new Pieza("NitroCharger Elite", "M", "Mercedes");
        Pieza motor4 = new Pieza("TurboBoost X12", "M", "Mercedes");
        Pieza motor5 = new Pieza("ThunderDrive 2000", "M", "Mercedes");
        Pieza motor6 = new Pieza("HyperVelocity Engine", "M", "Mercedes");
        Pieza motor7 = new Pieza("TurboJet 9000X", "M", "Mercedes");
        Pieza motor8 = new Pieza("PowerPulse Pro", "M", "Mercedes");
        Pieza motor9 = new Pieza("TurboDrive XL", "M", "Mercedes");
        Pieza motor10 = new Pieza("RocketForce 3000", "M", "Mercedes");

        Pieza llantas1 = new Pieza("AeroGlide Thunder", "N", "Mercedes");
        Pieza llantas2 = new Pieza("GripMaster Ultra", "N", "Mercedes");
        Pieza llantas3 = new Pieza("TurboTread Exceed", "N", "Mercedes");
        Pieza llantas4 = new Pieza("TrackThriller Max", "N", "Mercedes");
        Pieza llantas5 = new Pieza("SpeedDive Storm", "N", "Mercedes");
        Pieza llantas6 = new Pieza("AeroWheel X1", "N", "Mercedes");
        Pieza llantas7 = new Pieza("SuperGrip Elite", "N", "Mercedes");
        Pieza llantas8 = new Pieza("TurboGlide Pro", "N", "Mercedes");
        Pieza llantas9 = new Pieza("MegaTraction Grip", "N", "Mercedes");
        Pieza llantas10 = new Pieza("SpeedBlitz Thunder", "N", "Mercedes");

        // Piezas Red Bull Racing
        Pieza aleron11 = new Pieza("AirMax Raptor", "A", "Red Bull Racing");
        Pieza aleron12 = new Pieza("AeroFlex Thunder", "A", "Red Bull Racing");
        Pieza aleron13 = new Pieza("SkyWing Storm", "A", "Red Bull Racing");
        Pieza aleron14 = new Pieza("TurboFlow Wingmaster", "A", "Red Bull Racing");
        Pieza aleron15 = new Pieza("AeroJet Thrust", "A", "Red Bull Racing");
        Pieza aleron16 = new Pieza("HyperGlide Speedster", "A", "Red Bull Racing");
        Pieza aleron17 = new Pieza("AirSlicer BladeX", "A", "Red Bull Racing");
        Pieza aleron18 = new Pieza("AeroFury Maxima", "A", "Red Bull Racing");
        Pieza aleron19 = new Pieza("SkyForce AeroTech", "A", "Red Bull Racing");
        Pieza aleron110 = new Pieza("TurboWing X7", "A", "Red Bull Racing");

        Pieza motor11 = new Pieza("NitroBeast X3", "M", "Red Bull Racing");
        Pieza motor12 = new Pieza("TurboCharger Storm", "M", "Red Bull Racing");
        Pieza motor13 = new Pieza("PowerGlide ProX", "M", "Red Bull Racing");
        Pieza motor14 = new Pieza("ThunderDrive X4", "M", "Red Bull Racing");
        Pieza motor15 = new Pieza("SpeedPulse Elite", "M", "Red Bull Racing");
        Pieza motor16 = new Pieza("TurboForce ThunderX", "M", "Red Bull Racing");
        Pieza motor17 = new Pieza("NitroJet Mach 7", "M", "Red Bull Racing");
        Pieza motor18 = new Pieza("PowerThriller X1", "M", "Red Bull Racing");
        Pieza motor19 = new Pieza("HyperBoost Maxima", "M", "Red Bull Racing");
        Pieza motor110 = new Pieza("TurboDrive Thunderstorm", "M", "Red Bull Racing");

        Pieza llantas11 = new Pieza("GripMaster Thunderbolt", "N", "Red Bull Racing");
        Pieza llantas12 = new Pieza("TurboGlide Blaze", "N", "Red Bull Racing");
        Pieza llantas13 = new Pieza("AeroWheel Thunderstrike", "N", "Red Bull Racing");
        Pieza llantas14 = new Pieza("SpeedBlitz StormRider", "N", "Red Bull Racing");
        Pieza llantas15 = new Pieza("SkyGrip EliteX", "N", "Red Bull Racing");
        Pieza llantas16 = new Pieza("TurboTread Thrustmaster", "N", "Red Bull Racing");
        Pieza llantas17 = new Pieza("AeroGlide Thunderstrike", "N", "Red Bull Racing");
        Pieza llantas18 = new Pieza("SpeedForce BlazeX", "N", "Red Bull Racing");
        Pieza llantas19 = new Pieza("SkyBlitz StormRider", "N", "Red Bull Racing");
        Pieza llantas110 = new Pieza("TurboSpeed EliteX", "N", "Red Bull Racing");

        // Piezas Ferrari

        Pieza aleron21 = new Pieza("Scuderia AeroMaster", "A", "Ferrari");
        Pieza aleron22 = new Pieza("TurboWing RedFire", "A", "Ferrari");
        Pieza aleron23 = new Pieza("AeroFlow Thunderbolt", "A", "Ferrari");
        Pieza aleron24 = new Pieza("Fireblade AeroX", "A", "Ferrari");
        Pieza aleron25 = new Pieza("HyperAero Flame", "A", "Ferrari");
        Pieza aleron26 = new Pieza("ThunderWing Inferno", "A", "Ferrari");
        Pieza aleron27 = new Pieza("Firestorm AeroTech", "A", "Ferrari");
        Pieza aleron28 = new Pieza("TurboFlare Maxima", "A", "Ferrari");
        Pieza aleron29 = new Pieza("FireRider AeroBlitz", "A", "Ferrari");
        Pieza aleron210 = new Pieza("AeroFury RedFusion", "A", "Ferrari");

        Pieza motor21 = new Pieza("FireBoost ThunderMax", "M", "Ferrari");
        Pieza motor22 = new Pieza("TurboFlame InfernoX", "M", "Ferrari");
        Pieza motor23 = new Pieza("AeroPower BlazeForce", "M", "Ferrari");
        Pieza motor24 = new Pieza("ThunderDrive FireStorm", "M", "Ferrari");
        Pieza motor25 = new Pieza("FirePulse FlameX", "M", "Ferrari");
        Pieza motor26 = new Pieza("HyperFlame InfernoStorm", "M", "Ferrari");
        Pieza motor27 = new Pieza("FireJet ThunderX", "M", "Ferrari");
        Pieza motor28 = new Pieza("TurboInferno BlazeRider", "M", "Ferrari");
        Pieza motor29 = new Pieza("FireTech ThunderBlitz", "M", "Ferrari");
        Pieza motor210 = new Pieza("TurboFusion BlazeMaster", "M", "Ferrari");

        Pieza llantas21 = new Pieza("GripBlaze Thunderstrike", "N", "Ferrari");
        Pieza llantas22 = new Pieza("TurboRider FireGlide", "N", "Ferrari");
        Pieza llantas23 = new Pieza("AeroBlaze InfernoWheel", "N", "Ferrari");
        Pieza llantas24 = new Pieza("SpeedInferno ThunderRider", "N", "Ferrari");
        Pieza llantas25 = new Pieza("FireGlide BlazeX", "N", "Ferrari");
        Pieza llantas26 = new Pieza("TurboThunder FlameSpeed", "N", "Ferrari");
        Pieza llantas27 = new Pieza("AeroFlame InfernoStorm", "N", "Ferrari");
        Pieza llantas28 = new Pieza("SpeedBlitz BlazeTech", "N", "Ferrari");
        Pieza llantas29 = new Pieza("FireSpeed ThunderBlitz", "N", "Ferrari");
        Pieza llantas210 = new Pieza("TurboStorm InfernoX", "N", "Ferrari");

        // Piezas McLaren

        Pieza aleron31 = new Pieza("MegaFlow Airexcel", "A", "McLaren");
        Pieza aleron32 = new Pieza("TurboJet Wingblaze", "A", "McLaren");
        Pieza aleron33 = new Pieza("SkyRider AeroJet", "A", "McLaren");
        Pieza aleron34 = new Pieza("AeroDynamics ProWing", "A", "McLaren");
        Pieza aleron35 = new Pieza("HyperWing ThunderGlide", "A", "McLaren");
        Pieza aleron36 = new Pieza("AeroMaster JetStorm", "A", "McLaren");
        Pieza aleron37 = new Pieza("TurboFlare AeroFlow", "A", "McLaren");
        Pieza aleron38 = new Pieza("AeroX ThunderBlitz", "A", "McLaren");
        Pieza aleron39 = new Pieza("SkyForce AeroFury", "A", "McLaren");
        Pieza aleron310 = new Pieza("TurboWing Infinity", "A", "McLaren");

        Pieza motor31 = new Pieza("TurboThunder EngineX", "M", "McLaren");
        Pieza motor32 = new Pieza("PowerBeast ThunderFire", "M", "McLaren");
        Pieza motor33 = new Pieza("NitroCharger StormBlade", "M", "McLaren");
        Pieza motor34 = new Pieza("TurboBoost FireX", "M", "McLaren");
        Pieza motor35 = new Pieza("ThunderDrive VelocityX", "M", "McLaren");
        Pieza motor36 = new Pieza("HyperVelocity TurboJet", "M", "McLaren");
        Pieza motor37 = new Pieza("TurboJet FlameThunder", "M", "McLaren");
        Pieza motor38 = new Pieza("PowerPulse ThunderForce", "M", "McLaren");
        Pieza motor39 = new Pieza("TurboDrive BlazeSpeed", "M", "McLaren");
        Pieza motor310 = new Pieza("RocketForce VelocityStorm", "M", "McLaren");

        Pieza llantas31 = new Pieza("AeroGlide BlazeSpeed", "N", "McLaren");
        Pieza llantas32 = new Pieza("GripMaster ThunderJet", "N", "McLaren");
        Pieza llantas33 = new Pieza("TurboTread VelocityTech", "N", "McLaren");
        Pieza llantas34 = new Pieza("TrackThriller ThunderX", "N", "McLaren");
        Pieza llantas35 = new Pieza("SpeedDive BlazeGlide", "N", "McLaren");
        Pieza llantas36 = new Pieza("AeroWheel ThunderRider", "N", "McLaren");
        Pieza llantas37 = new Pieza("SuperGrip VelocityMax", "N", "McLaren");
        Pieza llantas38 = new Pieza("TurboGlide BlazeStorm", "N", "McLaren");
        Pieza llantas39 = new Pieza("MegaTraction ThunderBlitz", "N", "McLaren");
        Pieza llantas310 = new Pieza("SpeedBlitz BlazeTech", "N", "McLaren");

        // Piezas Aston Martin

        Pieza aleron41 = new Pieza("AeroMaster VantageX", "A", "Aston Martin");
        Pieza aleron42 = new Pieza("TurboWing RapidStorm", "A", "Aston Martin");
        Pieza aleron43 = new Pieza("SkyRider AeroVantage", "A", "Aston Martin");
        Pieza aleron44 = new Pieza("AeroDynamics StormVantage", "A", "Aston Martin");
        Pieza aleron45 = new Pieza("HyperWing ThunderVantage", "A", "Aston Martin");
        Pieza aleron46 = new Pieza("AeroJet StormMaster", "A", "Aston Martin");
        Pieza aleron47 = new Pieza("TurboFlare AeroBolt", "A", "Aston Martin");
        Pieza aleron48 = new Pieza("AeroX ThunderWave", "A", "Aston Martin");
        Pieza aleron49 = new Pieza("SkyForce AeroVortex", "A", "Aston Martin");
        Pieza aleron410 = new Pieza("TurboWing VantageBlitz", "A", "Aston Martin");

        Pieza motor41 = new Pieza("TurboThunder VantagePro", "M", "Aston Martin");
        Pieza motor42 = new Pieza("PowerBeast RapidFire", "M", "Aston Martin");
        Pieza motor43 = new Pieza("NitroCharger StormBolt", "M", "Aston Martin");
        Pieza motor44 = new Pieza("TurboBoost VantageX", "M", "Aston Martin");
        Pieza motor45 = new Pieza("ThunderDrive Thunderbolt", "M", "Aston Martin");
        Pieza motor46 = new Pieza("HyperVelocity TurboWave", "M", "Aston Martin");
        Pieza motor47 = new Pieza("TurboJet StormVortex", "M", "Aston Martin");
        Pieza motor48 = new Pieza("PowerPulse ThunderBolt", "M", "Aston Martin");
        Pieza motor49 = new Pieza("TurboDrive VantageMax", "M", "Aston Martin");
        Pieza motor410 = new Pieza("RocketForce StormBlitz", "M", "Aston Martin");

        Pieza llantas41 = new Pieza("AeroGlide RapidSpeed", "N", "Aston Martin");
        Pieza llantas42 = new Pieza("GripMaster ThunderVortex", "N", "Aston Martin");
        Pieza llantas43 = new Pieza("TurboTread VantageTech", "N", "Aston Martin");
        Pieza llantas44 = new Pieza("TrackThriller ThunderBlitz", "N", "Aston Martin");
        Pieza llantas45 = new Pieza("SpeedDive RapidGlide", "N", "Aston Martin");
        Pieza llantas46 = new Pieza("AeroWheel ThunderMaster", "N", "Aston Martin");
        Pieza llantas47 = new Pieza("SuperGrip VantageMaxima", "N", "Aston Martin");
        Pieza llantas48 = new Pieza("TurboGlide StormRider", "N", "Aston Martin");
        Pieza llantas49 = new Pieza("MegaTraction ThunderTech", "N", "Aston Martin");
        Pieza llantas410 = new Pieza("SpeedBlitz VantageTechX", "N", "Aston Martin");

        // Piezas Alpine

        Pieza aleron51 = new Pieza("AeroMaster AlpineX", "A", "Alpine");
        Pieza aleron52 = new Pieza("TurboWing GlacierStorm", "A", "Alpine");
        Pieza aleron53 = new Pieza("SkyRider AeroFrost", "A", "Alpine");
        Pieza aleron54 = new Pieza("AeroDynamics IceGlide", "A", "Alpine");
        Pieza aleron55 = new Pieza("HyperWing FrostBolt", "A", "Alpine");
        Pieza aleron56 = new Pieza("AeroJet SnowRider", "A", "Alpine");
        Pieza aleron57 = new Pieza("TurboFlare IcyWave", "A", "Alpine");
        Pieza aleron58 = new Pieza("AeroX AlpineBlitz", "A", "Alpine");
        Pieza aleron59 = new Pieza("SkyForce FrostVortex", "A", "Alpine");
        Pieza aleron510 = new Pieza("TurboWing GlacierBlade", "A", "Alpine");

        Pieza motor51 = new Pieza("TurboThunder FrostMaster", "M", "Alpine");
        Pieza motor52 = new Pieza("PowerBeast IceStorm", "M", "Alpine");
        Pieza motor53 = new Pieza("NitroCharger SnowBolt", "M", "Alpine");
        Pieza motor54 = new Pieza("TurboBoost AlpineX", "M", "Alpine");
        Pieza motor55 = new Pieza("ThunderDrive Frostbolt", "M", "Alpine");
        Pieza motor56 = new Pieza("HyperVelocity SnowJet", "M", "Alpine");
        Pieza motor57 = new Pieza("TurboJet IceVortex", "M", "Alpine");
        Pieza motor58 = new Pieza("PowerPulse FrostBlitz", "M", "Alpine");
        Pieza motor59 = new Pieza("TurboDrive AlpineTech", "M", "Alpine");
        Pieza motor510 = new Pieza("RocketForce SnowRider", "M", "Alpine");

        Pieza llantas51 = new Pieza("AeroGlide FrostSpeed", "N", "Alpine");
        Pieza llantas52 = new Pieza("GripMaster SnowVortex", "N", "Alpine");
        Pieza llantas53 = new Pieza("TurboTread AlpineTech", "N", "Alpine");
        Pieza llantas54 = new Pieza("TrackThriller SnowBlitz", "N", "Alpine");
        Pieza llantas55 = new Pieza("SpeedDive FrostGlide", "N", "Alpine");
        Pieza llantas56 = new Pieza("AeroWheel IceMaster", "N", "Alpine");
        Pieza llantas57 = new Pieza("SuperGrip AlpineMaxima", "N", "Alpine");
        Pieza llantas58 = new Pieza("TurboGlide SnowTech", "N", "Alpine");
        Pieza llantas59 = new Pieza("MegaTraction FrostBlade", "N", "Alpine");
        Pieza llantas510 = new Pieza("SpeedBlitz AlpineStorm", "N", "Alpine");

        // Piezas AlphaTauri

        Pieza aleron61 = new Pieza("AeroMaster AlphaFlow", "A", "AlphaTauri");
        Pieza aleron62 = new Pieza("TurboWing TauriStorm", "A", "AlphaTauri");
        Pieza aleron63 = new Pieza("SkyRider AeroBolt", "A", "AlphaTauri");
        Pieza aleron64 = new Pieza("AeroDynamics StormFlow", "A", "AlphaTauri");
        Pieza aleron65 = new Pieza("HyperWing TauriBlade", "A", "AlphaTauri");
        Pieza aleron66 = new Pieza("AeroJet BoltMaster", "A", "AlphaTauri");
        Pieza aleron67 = new Pieza("TurboFlare AlphaX", "A", "AlphaTauri");
        Pieza aleron68 = new Pieza("AeroX TauriBlitz", "A", "AlphaTauri");
        Pieza aleron69 = new Pieza("SkyForce AeroFury", "A", "AlphaTauri");
        Pieza aleron610 = new Pieza("TurboWing StormWave", "A", "AlphaTauri");

        Pieza motor61 = new Pieza("TurboThunder TauriMaster", "M", "AlphaTauri");
        Pieza motor62 = new Pieza("PowerBeast StormJet", "M", "AlphaTauri");
        Pieza motor63 = new Pieza("NitroCharger AlphaBolt", "M", "AlphaTauri");
        Pieza motor64 = new Pieza("TurboBoost TauriBlitz", "M", "AlphaTauri");
        Pieza motor65 = new Pieza("ThunderDrive StormFlow", "M", "AlphaTauri");
        Pieza motor66 = new Pieza("HyperVelocity AlphaJet", "M", "AlphaTauri");
        Pieza motor67 = new Pieza("TurboJet BoltX", "M", "AlphaTauri");
        Pieza motor68 = new Pieza("PowerPulse TauriTech", "M", "AlphaTauri");
        Pieza motor69 = new Pieza("TurboDrive StormBlitz", "M", "AlphaTauri");
        Pieza motor610 = new Pieza("RocketForce AlphaRider", "M", "AlphaTauri");

        Pieza llantas61 = new Pieza("AeroGlide TauriSpeed", "N", "AlphaTauri");
        Pieza llantas62 = new Pieza("GripMaster StormVortex", "N", "AlphaTauri");
        Pieza llantas63 = new Pieza("TurboTread AlphaTech", "N", "AlphaTauri");
        Pieza llantas64 = new Pieza("TrackThriller TauriBlitz", "N", "AlphaTauri");
        Pieza llantas65 = new Pieza("SpeedDive StormGlide", "N", "AlphaTauri");
        Pieza llantas66 = new Pieza("AeroWheel BoltMaster", "N", "AlphaTauri");
        Pieza llantas67 = new Pieza("SuperGrip TauriMaxima", "N", "AlphaTauri");
        Pieza llantas68 = new Pieza("TurboGlide StormTech", "N", "AlphaTauri");
        Pieza llantas69 = new Pieza("MegaTraction AlphaBlade", "N", "AlphaTauri");
        Pieza llantas610 = new Pieza("SpeedBlitz TauriStormX", "N", "AlphaTauri");

        // Piezas Williams

        Pieza aleron71 = new Pieza("AeroMaster SpeedWing", "A", "Williams");
        Pieza aleron72 = new Pieza("TurboWing VelocityStorm", "A", "Williams");
        Pieza aleron73 = new Pieza("SkyRider AeroBolt", "A", "Williams");
        Pieza aleron74 = new Pieza("AeroDynamics StormFlow", "A", "Williams");
        Pieza aleron75 = new Pieza("HyperWing ThunderBolt", "A", "Williams");
        Pieza aleron76 = new Pieza("AeroJet BoltMaster", "A", "Williams");
        Pieza aleron77 = new Pieza("TurboFlare SpeedX", "A", "Williams");
        Pieza aleron78 = new Pieza("AeroX WilliamsBlitz", "A", "Williams");
        Pieza aleron79 = new Pieza("SkyForce AeroFury", "A", "Williams");
        Pieza aleron710 = new Pieza("TurboWing VelocityWave", "A", "Williams");

        Pieza motor71 = new Pieza("TurboThunder WilliamsMaster", "M", "Williams");
        Pieza motor72 = new Pieza("PowerBeast VelocityJet", "M", "Williams");
        Pieza motor73 = new Pieza("NitroCharger AeroBolt", "M", "Williams");
        Pieza motor74 = new Pieza("TurboBoost WilliamsBlitz", "M", "Williams");
        Pieza motor75 = new Pieza("ThunderDrive VelocityFlow", "M", "Williams");
        Pieza motor76 = new Pieza("HyperVelocity AeroJet", "M", "Williams");
        Pieza motor77 = new Pieza("TurboJet BoltX", "M", "Williams");
        Pieza motor78 = new Pieza("PowerPulse WilliamsTech", "M", "Williams");
        Pieza motor79 = new Pieza("TurboDrive VelocityBlitz", "M", "Williams");
        Pieza motor710 = new Pieza("RocketForce AeroRider", "M", "Williams");

        Pieza llantas71 = new Pieza("AeroGlide WilliamsSpeed", "N", "Williams");
        Pieza llantas72 = new Pieza("GripMaster VelocityVortex", "N", "Williams");
        Pieza llantas73 = new Pieza("TurboTread AeroTech", "N", "Williams");
        Pieza llantas74 = new Pieza("TrackThriller WilliamsBlitz", "N", "Williams");
        Pieza llantas75 = new Pieza("SpeedDive VelocityGlide", "N", "Williams");
        Pieza llantas76 = new Pieza("AeroWheel BoltMaster", "N", "Williams");
        Pieza llantas77 = new Pieza("SuperGrip WilliamsMaxima", "N", "Williams");
        Pieza llantas78 = new Pieza("TurboGlide VelocityTech", "N", "Williams");
        Pieza llantas79 = new Pieza("MegaTraction AeroBlade", "N", "Williams");
        Pieza llantas710 = new Pieza("SpeedBlitz WilliamsStorm", "N", "Williams");

        // Piezas Alfa Romeo

        Pieza aleron81 = new Pieza("AeroMaster AlfaFlow", "A", "Alfa Romeo");
        Pieza aleron82 = new Pieza("TurboWing RomeoStorm", "A", "Alfa Romeo");
        Pieza aleron83 = new Pieza("SkyRider AeroBolt", "A", "Alfa Romeo");
        Pieza aleron84 = new Pieza("AeroDynamics StormFlow", "A", "Alfa Romeo");
        Pieza aleron85 = new Pieza("HyperWing ThunderBolt", "A", "Alfa Romeo");
        Pieza aleron86 = new Pieza("AeroJet BoltMaster", "A", "Alfa Romeo");
        Pieza aleron87 = new Pieza("TurboFlare AlfaX", "A", "Alfa Romeo");
        Pieza aleron88 = new Pieza("AeroX RomeoBlitz", "A", "Alfa Romeo");
        Pieza aleron89 = new Pieza("SkyForce AeroFury", "A", "Alfa Romeo");
        Pieza aleron810 = new Pieza("TurboWing RomeoWave", "A", "Alfa Romeo");

        Pieza motor81 = new Pieza("TurboThunder RomeoMaster", "M", "Alfa Romeo");
        Pieza motor82 = new Pieza("PowerBeast RomeoJet", "M", "Alfa Romeo");
        Pieza motor83 = new Pieza("NitroCharger AeroBolt", "M", "Alfa Romeo");
        Pieza motor84 = new Pieza("TurboBoost RomeoBlitz", "M", "Alfa Romeo");
        Pieza motor85 = new Pieza("ThunderDrive StormFlow", "M", "Alfa Romeo");
        Pieza motor86 = new Pieza("HyperVelocity AlfaJet", "M", "Alfa Romeo");
        Pieza motor87 = new Pieza("TurboJet BoltX", "M", "Alfa Romeo");
        Pieza motor88 = new Pieza("PowerPulse RomeoTech", "M", "Alfa Romeo");
        Pieza motor89 = new Pieza("TurboDrive StormBlitz", "M", "Alfa Romeo");
        Pieza motor810 = new Pieza("RocketForce AlfaRider", "M", "Alfa Romeo");

        Pieza llantas81 = new Pieza("AeroGlide RomeoSpeed", "N", "Alfa Romeo");
        Pieza llantas82 = new Pieza("GripMaster StormVortex", "N", "Alfa Romeo");
        Pieza llantas83 = new Pieza("TurboTread AlfaTech", "N", "Alfa Romeo");
        Pieza llantas84 = new Pieza("TrackThriller RomeoBlitz", "N", "Alfa Romeo");
        Pieza llantas85 = new Pieza("SpeedDive StormGlide", "N", "Alfa Romeo");
        Pieza llantas86 = new Pieza("AeroWheel BoltMaster", "N", "Alfa Romeo");
        Pieza llantas87 = new Pieza("SuperGrip RomeoMaxima", "N", "Alfa Romeo");
        Pieza llantas88 = new Pieza("TurboGlide StormTech", "N", "Alfa Romeo");
        Pieza llantas89 = new Pieza("MegaTraction AlfaBlade", "N", "Alfa Romeo");
        Pieza llantas810 = new Pieza("SpeedBlitz RomeoStormX", "N", "Alfa Romeo");

        // Piezas Haas

        Pieza aleron91 = new Pieza("AeroMaster HaasFlow", "A", "Haas");
        Pieza aleron92 = new Pieza("TurboWing VelocityStorm", "A", "Haas");
        Pieza aleron93 = new Pieza("SkyRider AeroBolt", "A", "Haas");
        Pieza aleron94 = new Pieza("AeroDynamics StormFlow", "A", "Haas");
        Pieza aleron95 = new Pieza("HyperWing ThunderBolt", "A", "Haas");
        Pieza aleron96 = new Pieza("AeroJet BoltMaster", "A", "Haas");
        Pieza aleron97 = new Pieza("TurboFlare HaasX", "A", "Haas");
        Pieza aleron98 = new Pieza("AeroX HaasBlitz", "A", "Haas");
        Pieza aleron99 = new Pieza("SkyForce AeroFury", "A", "Haas");
        Pieza aleron910 = new Pieza("TurboWing VelocityWave", "A", "Haas");

        Pieza motor91 = new Pieza("TurboThunder HaasMaster", "M", "Haas");
        Pieza motor92 = new Pieza("PowerBeast VelocityJet", "M", "Haas");
        Pieza motor93 = new Pieza("NitroCharger AeroBolt", "M", "Haas");
        Pieza motor94 = new Pieza("TurboBoost HaasBlitz", "M", "Haas");
        Pieza motor95 = new Pieza("ThunderDrive StormFlow", "M", "Haas");
        Pieza motor96 = new Pieza("HyperVelocity HaasJet", "M", "Haas");
        Pieza motor97 = new Pieza("TurboJet BoltX", "M", "Haas");
        Pieza motor98 = new Pieza("PowerPulse HaasTech", "M", "Haas");
        Pieza motor99 = new Pieza("TurboDrive StormBlitz", "M", "Haas");
        Pieza motor910 = new Pieza("RocketForce HaasRider", "M", "Haas");

        Pieza llantas91 = new Pieza("AeroGlide HaasSpeed", "N", "Haas");
        Pieza llantas92 = new Pieza("GripMaster StormVortex", "N", "Haas");
        Pieza llantas93 = new Pieza("TurboTread HaasTech", "N", "Haas");
        Pieza llantas94 = new Pieza("TrackThriller HaasBlitz", "N", "Haas");
        Pieza llantas95 = new Pieza("SpeedDive StormGlide", "N", "Haas");
        Pieza llantas96 = new Pieza("AeroWheel BoltMaster", "N", "Haas");
        Pieza llantas97 = new Pieza("SuperGrip HaasMaxima", "N", "Haas");
        Pieza llantas98 = new Pieza("TurboGlide StormTech", "N", "Haas");
        Pieza llantas99 = new Pieza("MegaTraction HaasBlade", "N", "Haas");
        Pieza llantas910 = new Pieza("SpeedBlitz HaasStormX", "N", "Haas");




/*        ArrayList<Carrera> listaCarrerasC1 = new ArrayList<>();
        ArrayList<Carrera> listaCarrerasC2 = new ArrayList<>();

        // Carreras

        Carrera carrera1 = new Carrera("Gran Premio de las Estrellas", 4, 305.5, 1000000.0, perth, dc1, 0.8);
        Carrera carrera2 = new Carrera("Desaf�o del Desierto", 7, 450.2, 1200000.0, brisbane, dc2, 0.9);
        Carrera carrera3 = new Carrera("Carrera de Monta�a Extrema", 5, 550.8, 1500000.0, papeete, dc3, 0.85);
        Carrera carrera4 = new Carrera("Circuito de la Jungla", 2, 390.7, 900000.0, nurburgring, dc4, 0.7);
        Carrera carrera5 = new Carrera("Desaf�o en la Nieve Eterna", 12, 280.3, 1100000.0, paris, dc5, 0.75);
        Carrera carrera6 = new Carrera("Gran Premio del Desierto", 8, 500.6, 1300000.0, viena, dc6, 0.88);
        Carrera carrera7 = new Carrera("Carrera de Velocidad en la Playa", 6, 350.4, 950000.0, estocolmo, dc7, 0.78);
        Carrera carrera8 = new Carrera("Desaf�o de la Selva Profunda", 3, 410.9, 1100000.0, nairobi, dc8, 0.82);
        Carrera carrera9 = new Carrera("Carrera Nocturna en la Ciudad", 10, 270.5, 800000.0, argel, dc9, 0.68);
        Carrera carrera10 = new Carrera("Gran Premio de las Monta�as", 9, 620.2, 1600000.0, ciudadDelCabo, dc10, 0.92);
        Carrera carrera11 = new Carrera("Carrera en el Bosque Encantado", 11, 330.1, 850000.0, mumbai, dc11, 0.72);
        Carrera carrera12 = new Carrera("Desaf�o en la Ciudad Perdida", 1, 480.6, 1400000.0, sriJayawardenepuraKotte, dc12, 0.86);

        Carrera carrera13 = new Carrera("Gran Premio de Ciudad de M�xico", 4, 320.5, 1100000.0, ciudadDeMexico, dc13, 0.78);
        Carrera carrera14 = new Carrera("Carrera en Sao Paulo", 7, 400.2, 1300000.0, saoPaulo, dc14, 0.85);
        Carrera carrera15 = new Carrera("Desaf�o en Buenos Aires", 6, 420.8, 1400000.0, buenosAires, dc15, 0.82);
        Carrera carrera16 = new Carrera("Gran Premio de Montreal", 8, 290.7, 1000000.0, montreal, dc16, 0.75);
        Carrera carrera17 = new Carrera("Carrera en Indian�polis", 5, 380.3, 1200000.0, indianapolis, dc17, 0.8);
        Carrera carrera18 = new Carrera("Carrera en Austin", 3, 360.6, 1100000.0, austin, dc18, 0.76);
        Carrera carrera19 = new Carrera("Gran Desaf�o en Miami", 10, 440.4, 1500000.0, miami, dc19, 0.88);
        Carrera carrera20 = new Carrera("Carrera en Las Vegas", 11, 480.9, 1600000.0, lasVegas, dc20, 0.92);
        Carrera carrera21 = new Carrera("Gran Premio de Nueva York", 2, 350.5, 900000.0, nuevaYork, dc21, 0.7);
        Carrera carrera22 = new Carrera("Carrera en Los �ngeles", 12, 410.2, 1300000.0, losAngeles, dc22, 0.86);

        listaCarrerasC1.add(carrera1);
        listaCarrerasC1.add(carrera2);
        listaCarrerasC1.add(carrera3);
        listaCarrerasC1.add(carrera4);
        listaCarrerasC1.add(carrera5);
        listaCarrerasC1.add(carrera6);
        listaCarrerasC1.add(carrera7);
        listaCarrerasC1.add(carrera8);
        listaCarrerasC1.add(carrera9);
        listaCarrerasC1.add(carrera11);
        listaCarrerasC1.add(carrera11);
        listaCarrerasC1.add(carrera12);

        listaCarrerasC2.add(carrera13);
        listaCarrerasC2.add(carrera14);
        listaCarrerasC2.add(carrera15);
        listaCarrerasC2.add(carrera16);
        listaCarrerasC2.add(carrera17);
        listaCarrerasC2.add(carrera18);
        listaCarrerasC2.add(carrera19);
        listaCarrerasC2.add(carrera20);
        listaCarrerasC2.add(carrera21);
        listaCarrerasC2.add(carrera22);

        ArrayList<Equipo> listaEquiposC1 = new ArrayList<>();
        ArrayList<Equipo> listaEquiposC2 = new ArrayList<>();

        // Patrocinadores para los equipos

        Patrocinador patrocinador1 = new Patrocinador("Rolex", 2000000.0, 1000000.0, 0.9, true, true, new ArrayList<>(Arrays.asList(ciudadDeMexico, saoPaulo)));
        Patrocinador patrocinador2 = new Patrocinador("Heineken", 1500000.0, 750000.0, 0.8, false, false, new ArrayList<>(Arrays.asList(elCairo, buenosAires)));
        Patrocinador patrocinador3 = new Patrocinador("Emirates", 1800000.0, 900000.0, 0.9, true, true, new ArrayList<>(Arrays.asList(tunez, montreal)));
        Patrocinador patrocinador4 = new Patrocinador("Pirelli", 1300000.0, 650000.0, 0.8, true, false, new ArrayList<>(Arrays.asList(johannesburgo, indianapolis)));
        Patrocinador patrocinador5 = new Patrocinador("DHL", 1600000.0, 800000.0, 0.8, true, false, new ArrayList<>(Arrays.asList(marrakech, austin)));
        Patrocinador patrocinador6 = new Patrocinador("Petronas", 1400000.0, 700000.0, 0.8, true, true, new ArrayList<>(Arrays.asList(ciudadDelCabo, miami)));
        Patrocinador patrocinador7 = new Patrocinador("Santander", 1250000.0, 600000.0, 0.7, false, true, new ArrayList<>(Arrays.asList(dakar, lasVegas)));
        Patrocinador patrocinador8 = new Patrocinador("Red Bull", 1700000.0, 850000.0, 0.9, true, true, new ArrayList<>(Arrays.asList(nairobi, nuevaYork)));
        Patrocinador patrocinador9 = new Patrocinador("Shell", 1350000.0, 675000.0, 0.8, true, false, new ArrayList<>(Arrays.asList(lusaka, losAngeles)));
        Patrocinador patrocinador10 = new Patrocinador("Honda", 1500000.0, 750000.0, 0.8, true, false, new ArrayList<>(Arrays.asList(khartoum, chicago)));
        Patrocinador patrocinador11 = new Patrocinador("Aston Martin", 1800000.0, 900000.0, 0.9, true, true, new ArrayList<>(Arrays.asList(roma, lisboa)));
        Patrocinador patrocinador12 = new Patrocinador("Lenovo", 1300000.0, 650000.0, 0.8, true, false, new ArrayList<>(Arrays.asList(paris, berlin)));
        Patrocinador patrocinador13 = new Patrocinador("Acer", 1600000.0, 800000.0, 0.8, true, false, new ArrayList<>(Arrays.asList(viena, varsovia)));
        Patrocinador patrocinador14 = new Patrocinador("UPS", 1400000.0, 700000.0, 0.8, true, true, new ArrayList<>(Arrays.asList(sydney, melbourne)));
        Patrocinador patrocinador15 = new Patrocinador("Oracle", 1250000.0, 600000.0, 0.7, false, true, new ArrayList<>(Arrays.asList(auckland, perth)));
        Patrocinador patrocinador16 = new Patrocinador("Cisco", 1700000.0, 850000.0, 0.9, true, true, new ArrayList<>(Arrays.asList(suva, honolulu)));
        Patrocinador patrocinador17 = new Patrocinador("TotalEnergies", 1350000.0, 675000.0, 0.8, true, false, new ArrayList<>(Arrays.asList(papeete, nadi)));
        Patrocinador patrocinador18 = new Patrocinador("AWS (Amazon Web Services)", 1500000.0, 750000.0, 0.8, true, false, new ArrayList<>(Arrays.asList(palmira, darwin)));
        Patrocinador patrocinador19 = new Patrocinador("Cognizant", 1800000.0, 900000.0, 0.9, true, true, new ArrayList<>(Arrays.asList(fiyi, boraBora)));
        Patrocinador patrocinador20 = new Patrocinador("BWT (Best Water Technology)", 1300000.0, 650000.0, 0.8, true, false, new ArrayList<>(Arrays.asList(honolulu2, goldCoast)));

        // Equipos

        Equipo equipo1 = new Equipo(1, "Escuder�a Velocidad Extrema", 5000000.0, 100, false, new ArrayList<>(Arrays.asList(ciudadDeMexico, saoPaulo)), new ArrayList<>(Arrays.asList(patrocinador1 , patrocinador2 )), true, 50, 5);
        Equipo equipo2 = new Equipo(2, "Equipo Rel�mpago Rojo", 4500000.0, 80, false, new ArrayList<>(Arrays.asList(elCairo, buenosAires)), new ArrayList<>(Arrays.asList(patrocinador3, patrocinador4)), false, 40, 4);
        Equipo equipo3 = new Equipo(3, "Escuder�a Titanes del Asfalto", 5500000.0, 120, false, new ArrayList<>(Arrays.asList(tunez, montreal)), new ArrayList<>(Arrays.asList(patrocinador5, patrocinador6)), false, 55, 6);
        Equipo equipo4 = new Equipo(4, "Equipo Tormenta Veloz", 4800000.0, 90, false, new ArrayList<>(Arrays.asList(johannesburgo, indianapolis)), new ArrayList<>(Arrays.asList(patrocinador7, patrocinador8)), true, 45, 5);
        Equipo equipo5 = new Equipo(5, "Escuder�a Fuego y Hielo", 5200000.0, 110, false, new ArrayList<>(Arrays.asList(marrakech, austin)), new ArrayList<>(Arrays.asList(patrocinador9, patrocinador10)), false, 48, 5);

        Equipo equipo6 = new Equipo(6, "Equipo Viento en Popa", 4700000.0, 75, false, new ArrayList<>(Arrays.asList(ciudadDelCabo, miami)), new ArrayList<>(Arrays.asList(patrocinador11, patrocinador12)), true, 42, 4);
        Equipo equipo7 = new Equipo(7, "Escuder�a Rayo de Sol", 5100000.0, 95, false, new ArrayList<>(Arrays.asList(dakar, lasVegas)), new ArrayList<>(Arrays.asList(patrocinador13, patrocinador14)), false, 47, 5);
        Equipo equipo8 = new Equipo(8, "Equipo Aurora Veloz", 4900000.0, 85, false, new ArrayList<>(Arrays.asList(nairobi, nuevaYork)), new ArrayList<>(Arrays.asList(patrocinador15, patrocinador16)), true, 43, 4);
        Equipo equipo9 = new Equipo(9, "Escuder�a Trueno M�gico", 5300000.0, 115, false, new ArrayList<>(Arrays.asList(lusaka, losAngeles)), new ArrayList<>(Arrays.asList(patrocinador17, patrocinador18)), true, 50, 6);
        Equipo equipo10 = new Equipo(10, "Equipo Estrella Veloz", 4600000.0, 70, false, new ArrayList<>(Arrays.asList(khartoum, chicago)), new ArrayList<>(Arrays.asList(patrocinador19, patrocinador20)), false, 38, 4);

        listaEquiposC1.add(equipo1);
        listaEquiposC1.add(equipo2);
        listaEquiposC1.add(equipo3);
        listaEquiposC1.add(equipo4);
        listaEquiposC1.add(equipo5);

        listaEquiposC2.add(equipo6);
        listaEquiposC2.add(equipo7);
        listaEquiposC2.add(equipo8);
        listaEquiposC2.add(equipo9);
        listaEquiposC2.add(equipo10);

        ArrayList<Piloto> listaPilotosC1 = new ArrayList<>();
        ArrayList<Piloto> listaPilotosC2 = new ArrayList<>();

        // Pilotos

        Piloto piloto1Equipo1 = new Piloto("Michael Schumacher", equipo1, 65, 3, 0.92, false, true, true, 3000000.0, 2000000.0, patrocinador1);
        Piloto piloto2Equipo1 = new Piloto("Lewis Hamilton", equipo1, 45, 2, 0.88, false, true, false, 2500000.0, 1500000.0 ,patrocinador2);
        Piloto piloto1Equipo2 = new Piloto("Juan Manuel Fangio", equipo2, 35, 4, 0.85, false, false, false, 2000000.0, 2000000.0, patrocinador3);
        Piloto piloto2Equipo2 = new Piloto("Ayrton Senna", equipo2, 55, 1, 0.90, false, false, false, 2500000.0, 1500000.0, patrocinador4);
        Piloto piloto1Equipo3 = new Piloto("Alain Prost", equipo3, 75, 2, 0.94, false, false, false, 3500000.0, 2000000.0, patrocinador5);
        Piloto piloto2Equipo3 = new Piloto("Niki Lauda", equipo3, 65, 3, 0.92, false, false, false, 3000000.0, 1500000.0, patrocinador6);
        Piloto piloto1Equipo4 = new Piloto("Jackie Stewart", equipo4, 45, 2, 0.88, false, true, false, 2500000.0, 1500000.0, patrocinador7);
        Piloto piloto2Equipo4 = new Piloto("Jim Clark", equipo4, 55, 1, 0.90, false, true, false, 3000000.0, 2000000.0, patrocinador8);
        Piloto piloto1Equipo5 = new Piloto("Sebastian Vettel", equipo5, 40, 4, 0.85, false, false, false, 2000000.0, 1500000.0, patrocinador9);
        Piloto piloto2Equipo5 = new Piloto("Fernando Alonso", equipo5, 50, 3, 0.92, false, true, false, 3000000.0, 2000000.0, patrocinador10);

        Piloto piloto1Equipo6 = new Piloto("Nelson Piquet", equipo6, 35, 3, 0.86, false, true, true, 2500000.0, 1500000.0, patrocinador11);
        Piloto piloto2Equipo6 = new Piloto("Mika Hakkinen", equipo6, 55, 2, 0.90, false, true, false, 3000000.0, 2000000.0, patrocinador12);
        Piloto piloto1Equipo7 = new Piloto("Stirling Moss", equipo7, 65, 3, 0.92, false, false, false, 2500000.0, 1500000.0, patrocinador13);
        Piloto piloto2Equipo7 = new Piloto("Emerson Fittipaldi", equipo7, 45, 4, 0.88, false, false, false, 2000000.0, 2000000.0, patrocinador14);
        Piloto piloto1Equipo8 = new Piloto("Gilles Villeneuve", equipo8, 55, 1, 0.90, false, true, false, 3000000.0, 2000000.0, patrocinador15);
        Piloto piloto2Equipo8 = new Piloto("Kimi Raikkonen", equipo8, 35, 2, 0.85, false, true, false, 2500000.0, 1500000.0, patrocinador16);
        Piloto piloto1Equipo9 = new Piloto("Damon Hill", equipo9, 50, 3, 0.92, false, true, false, 3000000.0, 2000000.0, patrocinador17);
        Piloto piloto2Equipo9 = new Piloto("Keke Rosberg", equipo9, 70, 2, 0.94, false, true, false, 3500000.0, 1500000.0, patrocinador18);
        Piloto piloto1Equipo10 = new Piloto("Nigel Mansell", equipo10, 45, 4, 0.88, false, false, false, 2000000.0, 2000000.0, patrocinador19);
        Piloto piloto2Equipo10 = new Piloto("Jenson Button", equipo10, 60, 3, 0.91, false, false, false, 2500000.0, 1500000.0, patrocinador20);

        listaPilotosC1.add(piloto1Equipo1);
        listaPilotosC1.add(piloto2Equipo1);
        listaPilotosC1.add(piloto1Equipo2);
        listaPilotosC1.add(piloto2Equipo2);
        listaPilotosC1.add(piloto1Equipo3);
        listaPilotosC1.add(piloto2Equipo3);
        listaPilotosC1.add(piloto1Equipo4);
        listaPilotosC1.add(piloto2Equipo4);
        listaPilotosC1.add(piloto1Equipo5);
        listaPilotosC1.add(piloto2Equipo5);

        listaPilotosC2.add(piloto1Equipo6);
        listaPilotosC2.add(piloto2Equipo6);
        listaPilotosC2.add(piloto1Equipo7);
        listaPilotosC2.add(piloto2Equipo7);
        listaPilotosC2.add(piloto1Equipo8);
        listaPilotosC2.add(piloto2Equipo8);
        listaPilotosC2.add(piloto1Equipo9);
        listaPilotosC2.add(piloto2Equipo9);
        listaPilotosC2.add(piloto1Equipo10);
        listaPilotosC2.add(piloto2Equipo10);

        // Campeonato 01

        Campeonato campeonato1 = new Campeonato(
            listaCarrerasC1,
            listaEquiposC1,
            listaPilotosC1,
            1,
            "Gran Campeonato de Chigorodo",
            2023,
            Continente.America,
            12,
            2000000.0,
            true
        );

        // Campeonato 02

        Campeonato campeonato2 = new Campeonato(
        	    listaCarrerasC2,
        	    listaEquiposC2,
        	    listaPilotosC2,
        	    2,
        	    "Campeonato Internacional Pangasio",
        	    2023,
        	    Continente.Europa,
        	    10,
        	    1000000.0,
        	    true
        	);
    */
    }

    public static void resetear() throws IOException {
        crearObjetos();
        ////////////////////////// CAMPEONATOS  //////////////////////////

        FileOutputStream fileOutputStream1 = new FileOutputStream("src\\baseDatos\\temp\\datosCampeonatos.txt");
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);

        objectOutputStream1.writeObject(Campeonato.campeonatos);

        objectOutputStream1.close();
        fileOutputStream1.close();

        ////////////////////////// CIUDADES  //////////////////////////

        FileOutputStream fileOutputStream2 = new FileOutputStream("src\\baseDatos\\temp\\datosCiudades.txt");
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);

        objectOutputStream2.writeObject(Ciudad.listaCiudades);

        objectOutputStream2.close();
        fileOutputStream2.close();


        ////////////////////////// DIRECTORES  //////////////////////////

        FileOutputStream fileOutputStream3 = new FileOutputStream("src\\baseDatos\\temp\\datosDirectores.txt");
        ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(fileOutputStream3);

        objectOutputStream3.writeObject(DirectorCarrera.listaDirectores);

        objectOutputStream3.close();
        fileOutputStream3.close();


        ////////////////////////// EQUIPOS  //////////////////////////


        FileOutputStream fileOutputStream4 = new FileOutputStream("src\\baseDatos\\temp\\datosEquipos.txt");
        ObjectOutputStream objectOutputStream4 = new ObjectOutputStream(fileOutputStream4);

        objectOutputStream4.writeObject(Equipo.equipos);

        objectOutputStream4.close();
        fileOutputStream4.close();

        ////////////////////////// PATROCINADORES  //////////////////////////

        FileOutputStream fileOutputStream5 = new FileOutputStream("src\\baseDatos\\temp\\datosPatrocinadores.txt");
        ObjectOutputStream objectOutputStream5 = new ObjectOutputStream(fileOutputStream5);

        objectOutputStream5.writeObject(Patrocinador.listaPatrocinadores);

        objectOutputStream5.close();
        fileOutputStream5.close();


        ////////////////////////// PIEZAS  //////////////////////////


        FileOutputStream fileOutputStream6 = new FileOutputStream("src\\baseDatos\\temp\\datosPiezas.txt");
        ObjectOutputStream objectOutputStream6 = new ObjectOutputStream(fileOutputStream6);

        objectOutputStream6.writeObject(Pieza.getPiezas());


        objectOutputStream6.close();
        fileOutputStream6.close();


        ////////////////////////// PILOTOS  //////////////////////////


        FileOutputStream fileOutputStream8 = new FileOutputStream("src\\baseDatos\\temp\\datosPilotos.txt");
        ObjectOutputStream objectOutputStream8 = new ObjectOutputStream(fileOutputStream8);

        objectOutputStream8.writeObject(Piloto.listaPilotos);

        objectOutputStream8.close();
        fileOutputStream8.close();


        ////////////////////////// CHASIS  //////////////////////////

        FileOutputStream fileOutputStream9 = new FileOutputStream("src\\baseDatos\\temp\\datosChasis.txt");
        ObjectOutputStream objectOutputStream9 = new ObjectOutputStream(fileOutputStream9);

        objectOutputStream9.writeObject(Chasis.listaChasis);

        objectOutputStream9.close();
        fileOutputStream9.close();

        ////////////////////////// VEHICULO CARRERA  //////////////////////////

        FileOutputStream fileOutputStream10 = new FileOutputStream("src\\baseDatos\\temp\\datosVehiculos.txt");
        ObjectOutputStream objectOutputStream10 = new ObjectOutputStream(fileOutputStream10);

        objectOutputStream10.writeObject(VehiculoCarrera.getListaVehiculosCarrera());

        objectOutputStream10.close();
        fileOutputStream10.close();

        ////////////////////////// CIRCUITOS  //////////////////////////

        FileOutputStream fileOutputStream11 = new FileOutputStream("src\\baseDatos\\temp\\datosCircuitos.txt");
        ObjectOutputStream objectOutputStream11 = new ObjectOutputStream(fileOutputStream11);

        objectOutputStream11.writeObject(Circuito.getCircuitos());

        objectOutputStream11.close();
        fileOutputStream11.close();


    }


}

