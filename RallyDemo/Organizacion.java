import java.util.TreeSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Comparator;
/**
 * Write a description of class Organizacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Organizacion
{
    private static Organizacion instance; //Patrón Singleton

    private int limiteAbandonos;
    private int limitePilotos;
    private TreeSet<Circuito> circuitos;
    private ArrayList<Escuderia> escuderias;
    private HashMap<Piloto, Escuderia> pilotosCarrera;

    /**
     * Constructor for objects of class Organizacion
     */
    private Organizacion(Comparator<Circuito> criterio) //El treset pasado como parametro ya tendria el comparador
    {
        this.circuitos=new TreeSet<Circuito>(criterio);
        this.escuderias=new ArrayList<Escuderia>();
        this.pilotosCarrera=new HashMap<Piloto, Escuderia>();
    }

    public synchronized static Organizacion getInstance(Comparator<Circuito> criterio){
        if(instance== null) {
            instance = new Organizacion(criterio);
        }

        return instance;
    }

    public synchronized static Organizacion getInstance(){
        if(instance== null) {
            instance = new Organizacion(new ComparadorDistancia());
        }

        return instance;
    }

    public void setLimiteAbandonos(int limiteAbandonos){
        this.limiteAbandonos=limiteAbandonos;
    }

    public int getLimiteAbandonos(){
        return this.limiteAbandonos;
    }

    public void setLimitePilotos(int limitePilotos){
        this.limitePilotos=limitePilotos;
    }

    public int getLimitePilotos(){
        return this.limitePilotos;
    }

    public void anadirCircuito(Circuito circuito){
        circuitos.add(circuito);
    }

    public void inscribirEscuderia(Escuderia escuderia){
        escuderias.add(escuderia);
    }

    public void anadirPiloto(Piloto piloto, Escuderia escuderia){
        pilotosCarrera.put(piloto, escuderia);
    }

    public int numeroPilotosACompetir(){
        return pilotosCarrera.size();
    }

    public String mostrarCircuitosCampeonato(){
        StringBuilder str = new StringBuilder();

        str.append("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
        str.append("||||||||||||||||||| CIRCUITOS DEL CAMPEONATO |||||||||||||||||||\n");
        str.append("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");

        for (Circuito circuito : circuitos){
            str.append(circuito.toString() + "\n");
        }

        str.append("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");

        return str.toString();
    }

    public String mostrarEscuderiasCampeonato(){
        StringBuilder str = new StringBuilder();

        str.append("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        str.append("%%%%%%%% ESCUDERÍAS DEL CAMPEONATO %%%%%%%%\n");
        str.append("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");

        Collections.sort(escuderias, Collections.reverseOrder(new ComparadorTotalPuntosEscuderia()));

        for (Escuderia escuderia: escuderias){
            escuderia.ordenarPilotos();
            escuderia.ordenarCoches();
            str.append(escuderia.mostrarPilotosCochesEscuderia()); 
        }

        return str.toString();
    }

    //Muestra los datos de la carrera que sa va a realizar.  Estos datos son el circuito, y los pilotos participantes
    public String datosCarrera(Circuito circuito, int numeroCarrera){
        StringBuilder str = new StringBuilder();
        //MOSTRAMOS DATOS CARRERA
        str.append("\n********************************************************************************************************\n"); 
        str.append("*** CARRERA<" + numeroCarrera + "> EN " + circuito.toString() + " ***\n" );
        str.append("********************************************************************************************************\n");

        return str.toString();
    }

    //Muestra pilotos que participan en carrera
    public String participantesEnCarrera(Circuito circuito){
        StringBuilder str = new StringBuilder();

        str.append("********************************************************************************************************\n");
        str.append("**********************Pilotos que van a competir en " + circuito.getNombre() + "************************\n");
        str.append("**********************************************************************************************************\n");

        //creamos el iterador necesario para recorrer el HashMap
        Iterator it = pilotosCarrera.entrySet().iterator();

        //creamos una lista auxiliar para reordenar los pilotos
        ArrayList<Piloto> aux = new ArrayList<Piloto>();

        while(it.hasNext()){
            Map.Entry datos = (Map.Entry)it.next();  //datos contiene la entrada del HashMap. Tanto key (piloto) como valor(escuderia)
            Piloto piloto = (Piloto)datos.getKey(); //se pone datos.getKey() porque la entrada se ha declarado con este nombre  
            aux.add(piloto);
        }

        //ordenamos los pilotos para mostrar los datos de carrera en orden segun criterio
        Collections.sort(aux, new ComparadorTotalPuntos());

        for(Piloto piloto : aux){
            str.append(piloto.toString()+ "\n");
        }

        return str.toString();
    }

    //muestra mensaje de compienzo de la carrera
    public String mensajeInicioCarrera (Circuito circuito){
        StringBuilder str = new StringBuilder();
        str.append("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        str.append("+++++++++++++++++Comienza la carrera en " + circuito.getNombre() + "+++++++++++++++++++++++++++++++\n");
        str.append("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        return str.toString();
    }

    public String mensajeClasificacionFinalCarrera (Circuito circuito){
        StringBuilder str = new StringBuilder();
        str.append("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        str.append("+++++++++++++++++ Clasificación final de la carrera en " + circuito.getNombre() + "+++++++++++++++++++++++++++++++\n");
        str.append("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        return str.toString();
    }

    //muestra detalles de los pilotos en la ejecucion de la carrera
    public String realizaCarrera(Circuito circuito){
        StringBuilder str = new StringBuilder();

        str.append(mensajeInicioCarrera (circuito)+"\n");
        //creamos el iterador necesario para recorrer el HashMap
        Iterator it = pilotosCarrera.entrySet().iterator();
        //creamos una lista auxiliar para reordenar los pilotos
        ArrayList<Piloto> aux = new ArrayList<Piloto>();

        while(it.hasNext()){
            Map.Entry datos = (Map.Entry)it.next();  //datos contiene la entrada del HashMap. Tanto key (piloto) como valor(escuderia)
            Piloto piloto = (Piloto)datos.getKey(); //se pone datos.getKey() porque la entrada se ha declarado con este nombre  
            aux.add(piloto);
        }

        //ordenamos los pilotos para mostrar los datos de carrera en orden segun criterio
        //ordenamos por puntos totales, num carreras terminadas y nombre
        Collections.sort(aux, new ComparadorTotalPuntos());
        int numeroPiloto = 1;

        for(Piloto piloto : aux){
            str.append("@@@ Piloto " + numeroPiloto + " de " + aux.size() + "\n");
            str.append(piloto.toString() + " con\n");
            str.append(piloto.getCocheAsignado().toString() + "\n");

            //mostrar caracteristicas del coche
            str.append(piloto.conducirCoche(circuito, limiteAbandonos));

            //str.append("@@@\n");
            numeroPiloto++;
        }

        Collections.sort(aux, new ComparadorTiempoCarreraUltima());

        //asignar los puntos a los pilotos
        str.append(mensajeClasificacionFinalCarrera(circuito)+"\n");

        int puntos=10;
        int posicion=1;
        for(Piloto piloto : aux){
            if(piloto.getTiempoUltimaCarrera()>0){
                if(puntos<4){
                    piloto.obtenerResultado(circuito).setPuntos(2);
                }else{
                    piloto.obtenerResultado(circuito).setPuntos(puntos);  
                }
                str.append("@@@ Posición("+posicion+"): "+piloto.getNombre()+" - Tiempo: " +piloto.obtenerResultado(circuito).getTiempo() +" minutos - Puntos: "+piloto.obtenerResultado(circuito).getPuntos()+" @@@\n");
                puntos=puntos-2;
                posicion++;
            }
        }

        for(Piloto piloto : aux){
            if(piloto.getTiempoUltimaCarrera()<0){
                piloto.obtenerResultado(circuito).setPuntos(0);
                str.append("¡¡¡ Ha abandonado " +piloto.getNombre()+" - Tiempo: "+(double)Math.round(piloto.obtenerResultado(circuito).getTiempo()*100)/100+" - Puntos: "+piloto.obtenerResultado(circuito).getPuntos());
                if(piloto.getNumeroAbandonos()==limiteAbandonos){
                    piloto.ponerDescalificado();
                    str.append(" - Además ha sido descalificado para el resto del Campeonato");
                }
                str.append(" !!!\n");
            }
        }

        //Devolvemos los pilotos a sus escuderias
        Iterator ite = pilotosCarrera.entrySet().iterator(); 
        while(ite.hasNext()){
            Map.Entry datos = (Map.Entry)ite.next();  //datos contiene la entrada del HashMap. Tanto key (piloto) como valor(escuderia)
            Escuderia escuderia = (Escuderia)datos.getValue();
            Piloto piloto=(Piloto)datos.getKey();
            Coche coche=piloto.getCocheAsignado();

            piloto.desasignarCoche();
            escuderia.anadirPiloto(piloto);
            escuderia.anadirCoche(coche);

            escuderia.ordenarPilotos();
            escuderia.ordenarCoches();

        }

        pilotosCarrera.clear();
        
        return str.toString();
    }

    /*
     * Inscribe un piloto a una carrera
     */
    public String incribirPilotosCarrera(){
        StringBuilder str = new StringBuilder();
        int i=0;
        int j;
        boolean bandera = true;       //esta bandera me indicara si puedo continuar con la carrera
        boolean puedeSeguirAsignando;
        Piloto piloto = null;
        Coche coche = null;
        Escuderia escuderia = null;

        //metemos los pilotos que realizaran la carrera
        while(bandera && i<escuderias.size()){
            j=0;
            puedeSeguirAsignando=true;
            while(j<limitePilotos && puedeSeguirAsignando){
                escuderia=escuderias.get(i);
                if(escuderia.disponibilidadPiloto()){
                    piloto = escuderia.escogerPilotoSinDescalificar();
                    j++;
                    if(escuderia.disponibilidadCoche()){
                        coche = escuderia.escogerCocheConCombustible();
                        piloto.asignarCoche(coche);
                        anadirPiloto(piloto, escuderia);        //añadimos el piloto con su escuderia
                        //System.out.println("añadiendo piloto");
                        //System.out.println(piloto.toString());
                    }
                    else{
                        str.append("¡¡¡ " + piloto.getNombre() + " NO ES ENVIADO A LA CARREA porque la escuderia (" + escuderia.getNombre() + ") no tiene mas coches con combustible disponible !!!\n");
                        puedeSeguirAsignando=false;
                        escuderia.anadirPiloto(piloto);
                    }
                }else{
                    puedeSeguirAsignando=false;
                }
            }
            i++;
        }

        return str.toString();
    }

    public boolean premioDesierto(){
        boolean bandera=false;
        int i=0;
        for (Escuderia escuderia: escuderias){
            if(escuderia.todosLosPilotosDescalificado()){
                i++;
            }
        }

        if(i==escuderias.size()){
            bandera=true;
        }

        return bandera;
    }

    public String clasficacionFinalPilotos(){
        StringBuilder str = new StringBuilder();

        str.append("********** CLASIFICACIÓN FINAL DE PILOTOS **********\n");
        str.append("****************************************************\n");

        if(premioDesierto()){
            str.append("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡\n");
            str.append("¡¡¡ Campeonato de pilotos queda desierto por haber sido descalificados todos los pilotos !!!\n");
            str.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"); 
        }else{

            ArrayList<Piloto> pilotosClasificacion = new ArrayList<Piloto>();
            ArrayList<Piloto> auxiliar = new ArrayList<Piloto>();

            for(Escuderia escuderia: escuderias){
                auxiliar=escuderia.devolverPilotosNoDescalificados();
                for(Piloto piloto: auxiliar){
                    pilotosClasificacion.add(piloto);
                }    
            }

            Collections.sort(pilotosClasificacion, Collections.reverseOrder(new ComparadorTotalPuntos()));

            int i=1;
            for(Piloto piloto: pilotosClasificacion){
                str.append("@@@ Posición(" + i + "): " + piloto.getNombre() + " - Puntos Totales: " + piloto.totalPuntosAcumulado() + " @@@\n");
                str.append(piloto.mostrarResumenResultados()+"\n");
                i++;
            }

        }

        //parte de pilotos descalificacion

        ArrayList<Piloto> pilotosDescalificados = new ArrayList<Piloto>();
        ArrayList<Piloto> auxiliar = new ArrayList<Piloto>();

        for(Escuderia escuderia: escuderias){
            auxiliar=escuderia.devolverPilotosDescalificados();
            for(Piloto piloto: auxiliar){
                pilotosDescalificados.add(piloto);
            }    
        }

        if(pilotosDescalificados.size()>0){
            Collections.sort(pilotosDescalificados, Collections.reverseOrder(new ComparadorTotalPuntos()));

            str.append("****************************************************\n");
            str.append("************** PILOTOS DESCALIFICADOS **************\n");
            str.append("****************************************************\n");

            for(Piloto piloto: pilotosDescalificados){
                str.append("--- Piloto Descalificado: "+ piloto.getNombre() +" - Puntos Totales Anulados: "+ piloto.totalPuntosAcumulado() +" ---\n");
                str.append(piloto.mostrarResumenResultados()+"\n");
                
                piloto.anularPuntosPiloto();    //Anulamos al piloto los puntos en los distintos circuitos que ha corrido
            }

        }

        return str.toString();
    }

    public String clasificacionFinalEscuderias(){
        StringBuilder str = new StringBuilder();

        //parte de clasificacion de escuderias
        str.append("****************************************************\n");
        str.append("******** CLASIFICACIÓN FINAL DE ESCUDERÍAS *********\n");
        str.append("****************************************************\n");

        if(premioDesierto()){
            str.append("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡\n");
            str.append("¡¡¡ Campeonato de escuderías queda desierto por haber sido descalificados todos los pilotos !!!\n");
            str.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        }else{

            ArrayList<Escuderia> escuderiasClasificadas = new ArrayList<Escuderia>();
            for(Escuderia escuderia: escuderias){
                if(!escuderia.todosLosPilotosDescalificado()){
                    escuderiasClasificadas.add(escuderia);
                }
            }

            Collections.sort(escuderiasClasificadas, Collections.reverseOrder(new ComparadorTotalPuntosEscuderia()));
            
            int i=1;
            for(Escuderia escuderia: escuderiasClasificadas){
                str.append("@@@ Posición("+i+") " +escuderia.getNombre()+ " con "+ escuderia.totalPuntosPilotos() +" puntos @@@\n");
                str.append(escuderia.mostrarPilotosCochesEscuderia());
                i++;
            }
        }

        //parte escuderias descalificadas
        ArrayList<Escuderia> escuderiasDescalificadas = new ArrayList<Escuderia>();

        for(Escuderia escuderia: escuderias){
            if(escuderia.todosLosPilotosDescalificado()){
                escuderiasDescalificadas.add(escuderia);
            }
        }

        if(escuderiasDescalificadas.size()>0){
            str.append("****************************************************\n");
            str.append("************ ESCUDERIAS DESCALIFICADAS *************\n");
            str.append("****************************************************\n");

            Collections.sort(escuderiasDescalificadas, Collections.reverseOrder(new ComparadorTotalPuntosEscuderia()));
            for(Escuderia escuderia : escuderiasDescalificadas){
                str.append("¡¡¡ Escudería Descalificada: "+ escuderia.getNombre() + " con " + escuderia.totalPuntosPilotos() + " puntos !!!\n");
                str.append(escuderia.mostrarPilotosCochesEscuderia());
            }
        }

        return str.toString();
    }

    public String carreraCompleta(){
        StringBuilder str = new StringBuilder(); 

        str.append(mostrarCircuitosCampeonato()); 
        str.append("\n");
        str.append(mostrarEscuderiasCampeonato());

        Iterator<Circuito> it = circuitos.iterator();
        Circuito circuito;
        int contadorCircuito=1;
        boolean bandera=true;
        while(it.hasNext() && bandera){
            circuito=it.next();
            str.append(datosCarrera(circuito, contadorCircuito));

            str.append(incribirPilotosCarrera());
            if(pilotosCarrera.size()>1){
                str.append(participantesEnCarrera(circuito));
                str.append(realizaCarrera(circuito));   
                contadorCircuito++;
            }else{
                bandera=false;
                //Devolver los pilotos a su escuderia
                Iterator itee = pilotosCarrera.entrySet().iterator();

                while(itee.hasNext()){
                    Map.Entry datos = (Map.Entry)itee.next();  //datos contiene la entrada del HashMap. Tanto key (piloto) como valor(escuderia)
                    Piloto piloto = (Piloto)datos.getKey(); //se pone datos.getKey() porque la entrada se ha declarado con este nombre 
                    Escuderia escuderia = (Escuderia)datos.getValue();
                    escuderia.anadirPiloto(piloto);
                    escuderia.anadirCoche(piloto.getCocheAsignado());
                }
            }
        }

        if(!bandera){
            str.append("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡\n");
            str.append("¡¡¡ No se celebra esta carrera ni la(s) siguiente(s) por no haber pilotos para competir !!!!\n");
            str.append("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        }

        str.append("****************************************************\n");
        str.append("**************** FIN DEL CAMPEONATO ****************\n");
        str.append("****************************************************\n");

        //parte de clasificacion final de pilotos
        str.append(clasficacionFinalPilotos());
        
        //parte de clasificacion final de escuderias
        str.append(clasificacionFinalEscuderias());

        return str.toString();
    }
}

