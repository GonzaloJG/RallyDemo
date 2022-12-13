import java.util.Comparator;
import java.util.Collections;
/**
 * Write a description of class DatosCampeonatoFinPrematuro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DatosCampeonatoFinPrematuro
{
    public DatosCampeonatoFinPrematuro(){        
        System.out.println("*********************************************************************************************************");
        System.out.println("****ESTA SIMULACIÓN CONCLUYE ANTES DE FINALIZAR EL CAMPEONATO CON UN ÚNICO PILOTO SIN DESCALIFICAR****");        
        System.out.println("*********************************************************************************************************\n");

        initData();
    }

    private void initData()
    {
        //organizador debe ser una instancia única con la siguiente configuración:
        //LimiteAbandonos=1, LimitePilotos=3, 
        // Circuitos ordenados de forma descendente de acuerdo a su complejidad
        Organizacion org = Organizacion.getInstance(Collections.reverseOrder(new ComparadorComplejidad()));
        org.setLimiteAbandonos(1);
        org.setLimitePilotos(3);
        
        //creamos y añadimos los circuitos del campeonato:
        //Crear circuito portugal con nombre:”Portugal" - complejidad:MEDIA - distancia:INTERMEDIA);
        //además, acciones necesarias para que portugal sea un circuito con:
        //Gravilla y Nocturno
        //añadir circuito portugal a circuitos de la organización

        Complejidad MEDIA = Complejidad.MEDIA;
        Distancia INTERMEDIA = Distancia.INTERMEDIA;
        Circuito Portugal = new CircuitoReal("Portugal", MEDIA, INTERMEDIA);
        Portugal = new Gravilla(Portugal);
        Portugal = new Nocturno(Portugal);
        org.anadirCircuito(Portugal);

        //Crear circuito cerdena con nombre:”Cerdeña" - complejidad:ALTA - distancia:CORTA);
        //además, acciones necesarias para que cerdena sea un circuito con:
        //Gravilla y Mojado
        //añadir circuito cerdena a circuitos de la organización

        Complejidad CALTA = Complejidad.ALTA;
        Distancia CORTA = Distancia.CORTA;
        Circuito Cerdena = new CircuitoReal("Cerdeña", CALTA, CORTA);
        Cerdena = new Gravilla(Cerdena);
        Cerdena = new Mojado(Cerdena);
        org.anadirCircuito(Cerdena);

        //Crear circuito australia con nombre:”Australia" - complejidad:BAJA - distancia:LARGA);
        //además, acciones necesarias para que australia sea un circuito con:
        //Gravilla 
        //añadir circuito australia a circuitos de la organización

        Complejidad CBAJA = Complejidad.BAJA;
        Distancia LARGA = Distancia.LARGA;
        Circuito Australia = new CircuitoReal("Australia", CBAJA, LARGA);
        Australia = new Gravilla(Australia);
        org.anadirCircuito(Australia);

        //Crear circuito corcega con nombre:”Córcega" - complejidad:MEDIA - distancia:INTERMEDIA);
        //además, acciones necesarias para que corcega sea un circuito con:
        //Nocturno y Gravilla
        //añadir circuito corcega a circuitos de la organización

        Circuito Corcega = new CircuitoReal("Córcega", MEDIA, INTERMEDIA);
        Corcega = new Nocturno(Corcega);
        Corcega = new Gravilla(Corcega);
        org.anadirCircuito(Corcega);

        //Crear circuito finlandia con nombre:”Finlandia" - complejidad:ALTA - distancia:CORTA);
        //además, acciones necesarias para que finlandia sea un circuito con:
        //Nocturno, Frío y Mojado
        //añadir circuito finlandia a circuitos de la organización

        Circuito Finlandia = new CircuitoReal("Finlandia", CALTA, CORTA);
        Finlandia = new Nocturno(Finlandia);
        Finlandia = new Frio(Finlandia);
        Finlandia = new Mojado(Finlandia);
        org.anadirCircuito(Finlandia);

        //Crear circuito alemania con nombre:”Alemania" - complejidad:MEDIA - distancia:INTERMEDIA);
        //además, acciones necesarias para que alemania sea un circuito con:
        //Mojado
        //añadir circuito alemania a circuitos de la organización
        Circuito Alemania = new CircuitoReal("Alemania", MEDIA, INTERMEDIA);
        Alemania = new Mojado(Alemania);
        org.anadirCircuito(Alemania);

        //Crear circuito chile con nombre:”Chile" - complejidad:ALTA - distancia:CORTA);
        //además, acciones necesarias para que chile sea un circuito con:
        //Gravilla
        //añadir circuito chile a circuitos de la organización
        Circuito Chile = new CircuitoReal("Chile", CALTA, CORTA);
        Chile = new Gravilla(Chile);
        org.anadirCircuito(Chile);

        //creamos e inscribimos a las escuderías que participarán en el campeonato:    
        //Crear escuderia peugeot con nombre:"Peugeot"
        //ordenaciónPilotos: descendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
        //ordenaciónCoches: descendente por Combustible restante del Coche , en caso de empate por nombre);
        //peugeot se inscribe en campeonato

        Escuderia peugeot = new Escuderia(" PEUGEOT ");
        peugeot.setComparadorPilotos(Collections.reverseOrder(new ComparadorTotalPuntosDos()));
        peugeot.setComparadorCoches(Collections.reverseOrder(new ComparadorCocheCombustible()));
        peugeot.inscribirme();

        //escudería citroen 
        //Crear escuderia citroen con nombre:"Citroen"		
        //ordenaciónPilotos: ascendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
        //ordenaciónCoches: ascendente por Combustible restante del Coche , en caso de empate por nombre);
        //citroen se inscribe en campeonato

        Escuderia citroen = new Escuderia(" CITROEN ");
        citroen.setComparadorPilotos(new ComparadorTotalPuntosDos());
        citroen.setComparadorCoches(new ComparadorCocheCombustible());
        citroen.inscribirme();

        //escudería seat       
        //Crear escuderia seat con nombre:"Seat"
        //ordenaciónPilotos: descendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
        //ordenaciónCoches: descendente por Combustible restante del Coche , en caso de empate por nombre);
        //seat se inscribe en campeonato

        Escuderia seat  = new Escuderia(" SEAT ");
        seat.setComparadorPilotos(Collections.reverseOrder(new ComparadorTotalPuntosDos()));
        seat.setComparadorCoches(Collections.reverseOrder(new ComparadorCocheCombustible()));
        seat.inscribirme();

        //creamos los pilotos y los coches de cada escudería 
        //coches y pilotos de citroen
        //añadir a citroen un CocheResistente(nombre:"Citröen C5" - velocidad:RAPIDA - combustible:ELEFANTE);
        Velocidad RAPIDA = Velocidad.RAPIDA;
        Combustible ELEFANTE= Combustible.ELEFANTE;
        Coche CitroenC5 = new CocheResistente ("Citröen C5", RAPIDA, ELEFANTE);
        citroen.anadirCoche(CitroenC5);

        //añadir a citroen un CocheRapido(nombre:"Citröen C4" - velocidad:RAPIDA - combustible:ESCASO);
        Combustible ESCASO = Combustible.ESCASO;
        Coche CitroenC4 = new CocheRapido ("Citröen C4", RAPIDA, ESCASO );
        citroen.anadirCoche(CitroenC4);

        //añadir a citroen un Coche(nombre:"Citröen C3" - velocidad:RAPIDA - combustible:ESCASO);
        Coche CitroenC3 = new CocheNormal ("Citröen C3", RAPIDA, ESCASO );
        citroen.anadirCoche(CitroenC3);

        //añadir a citroen un PilotoExperimentado(nombre:"Loeb" - concentración: NORMAL));
        Concentracion CNORMAL = Concentracion.NORMAL;
        Piloto Loeb = new PilotoExperimentado("Loeb", CNORMAL);
        citroen.anadirPiloto(Loeb);

        //añadir a citroen un PilotoEstrella(nombre:"Makinen" - concentración: ZEN));
        Concentracion ZEN = Concentracion.ZEN;
        Piloto Makinen = new PilotoEstrella("Makinen", ZEN);
        citroen.anadirPiloto(Makinen);
        //añadir a citroen un PilotoNovato(nombre:"Auriol" - concentración: NORMAL));
        Piloto Auriol = new PilotoNovato ("Auriol",CNORMAL);
        citroen.anadirPiloto(Auriol);

        //coches y pilotos de seat
        //añadir a seat un CocheResistente(nombre:"Seat Tarraco" - velocidad:TORTUGA - combustible:GENEROSO);
        Velocidad VTORTUGA = Velocidad.TORTUGA;
        Combustible GENEROSO = Combustible.GENEROSO;
        Coche SeatTarraco = new CocheResistente ("Seat Tarraco", VTORTUGA, GENEROSO );
        seat.anadirCoche(SeatTarraco);
        //añadir a seat un CocheRapido(nombre:"Seat Ateca" - velocidad:GUEPARDO - combustible:GENEROSO);
        Velocidad GUEPARDO = Velocidad.GUEPARDO;
        Coche SeatAteca = new CocheRapido ("Seat Ateca", GUEPARDO, GENEROSO );
        seat.anadirCoche(SeatAteca);
        //añadir a seat un Coche(nombre:"Seat Arona" - velocidad:RAPIDA - combustible:ESCASO);
        Coche SeatArona = new CocheNormal ("Seat Arona", RAPIDA, ESCASO);
        seat.anadirCoche(SeatArona);
        //añadir a seat un PilotoExperimentado(nombre:"Ogier" - concentración: NORMAL));
        Piloto Ogier = new PilotoExperimentado("Ogier", CNORMAL);
        seat.anadirPiloto(Ogier);
        //añadir a seat un PilotoEstrella(nombre:"McRae" - concentración: CONCENTRADO));
        Concentracion CONCENTRADO = Concentracion.CONCENTRADO;
        Piloto McRae = new PilotoEstrella ("McRae",CONCENTRADO);
        seat.anadirPiloto(McRae);
        //añadir a seat un PilotoNovato(nombre:"Blomquist" - concentración: DESPISTADO));
        Concentracion DESPISTADO = Concentracion.DESPISTADO;
        Piloto Blomquist = new PilotoNovato("Blomquist", DESPISTADO);
        seat.anadirPiloto(Blomquist);

        //coches y pilotos de peugeot
        //añadir a peugeot un CocheResistente(nombre:"Peugeot 5008" - velocidad:LENTA - combustible:GENEROSO);
        Velocidad LENTA = Velocidad.LENTA;
        Coche Peugeot5008 = new CocheResistente ("Peugeot 5008", LENTA, GENEROSO );
        peugeot.anadirCoche(Peugeot5008);
        //añadir a peugeot un CocheRapido(nombre:"Peugeot 3008" - velocidad:GUEPARDO - combustible:NORMAL);
        Combustible NORMAL = Combustible.NORMAL;
        Coche Peugeot3008 = new CocheRapido ("Peugeot 3008", GUEPARDO, NORMAL );
        peugeot.anadirCoche(Peugeot3008);
        //añadir a peugeot un Coche(nombre:"Peugeot 2008" - velocidad:NORMAL - combustible:ESCASO);
        Velocidad VNORMAL = Velocidad.NORMAL;
        Coche Peugeot2008 = new CocheNormal ("Peugeot 2008", VNORMAL, ESCASO );
        peugeot.anadirCoche(Peugeot2008);
        //añadir a peugeot un PilotoExperimentado(nombre:"Kankunnen" - concentración: CONCENTRADO));
        Piloto Kankunnen = new PilotoExperimentado("Kankunnen", CONCENTRADO);
        peugeot.anadirPiloto(Kankunnen);
        //añadir a peugeot un PilotoEstrella(nombre:"Sainz" - concentración: ZEN ));
        Piloto Sainz = new PilotoEstrella ("Sainz",ZEN);
        peugeot.anadirPiloto(Sainz);
        //añadir a peugeot un PilotoNovato(nombre:"Sordo" - concentración: DESPISTADO));
        Piloto Sordo = new PilotoNovato("Sordo", DESPISTADO);
        peugeot.anadirPiloto(Sordo);

        System.out.println(org.carreraCompleta());

    }
}