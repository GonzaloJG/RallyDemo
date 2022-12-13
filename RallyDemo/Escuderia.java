import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;
/**
 * Write a description of class Escuderia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escuderia
{
    // instance variables - replace the example below with your own
    private String nombre;
    private ArrayList<Piloto> pilotos; //Estructura que mantiene ordenado sus elementos (arbol de busqueda)
    private ArrayList<Coche> coches;
    private Comparator<Piloto> criterioPilotos;
    private Comparator<Coche> criterioCoches;

    /**
     * Constructor for objects of class Escuderia
     */
    public Escuderia(String nombre)
    {
        this.nombre=nombre;
        pilotos = new ArrayList<Piloto>();
        coches = new ArrayList<Coche>();
    }

    public void anadirPiloto(Piloto piloto){
        pilotos.add(piloto);
    }

    public void borrarPiloto(Piloto piloto){
        pilotos.remove(piloto);
    }

    public void anadirCoche(Coche coche){
        coches.add(coche);
    }

    public void borrarCoche(Coche coche){
        coches.remove(coche);
    }

    public String getNombre(){
        return nombre;
    }

    public void setComparadorPilotos(Comparator<Piloto> criterio){
        criterioPilotos=criterio;
    }

    public void setComparadorCoches(Comparator<Coche> criterio){
        criterioCoches=criterio;
    }

    public void ordenarPilotos(){
        Collections.sort(pilotos, criterioPilotos);
    }

    public void ordenarCoches(){
        Collections.sort(coches, criterioCoches);
    }

    public void inscribirme(){
        Organizacion.getInstance().inscribirEscuderia(this);
    }
    //devuelve true si hay piloto disponible para asignar (el piloto no está descalificado)
    public boolean disponibilidadPiloto(){
        boolean bandera = false;
        int i=0;

        while(i<pilotos.size() && !bandera){
            if (pilotos.get(i).getDescalificado()==false){
                bandera=true;
            }
            else{
                i++;
            }
        }

        return bandera;
    }

    public boolean hayPilotosDescalificados(){
        int i=0;
        boolean bandera=false;
        Piloto piloto=null;
        while(i<pilotos.size() && !bandera){
            piloto=pilotos.get(i);
            if(piloto.getDescalificado()){
                bandera=true;
            }else{
                i++;
            }
        }
        return bandera;
    }

    //devuelve true si hay coche para asignar (hay coche con combustible)
    public boolean disponibilidadCoche(){
        boolean bandera = false;
        int i=0;

        while(i<coches.size() && !bandera){
            if (coches.get(i).getCombustibleReal()>0){
                bandera=true;
            }
            else{
                i++;
            }
        }

        return bandera;
    }

    public boolean hayCochesSinCombustible(){
        int i=0;
        boolean bandera=false;
        Coche coche=null;
        while(i<coches.size() && !bandera){
            coche=coches.get(i);
            if(coche.getCombustibleReal()<=0){
                bandera=true;
            }else{
                i++;
            }
        }
        return bandera;
    }

    public String mostrarPilotosEscuderia(){
        StringBuilder str = new StringBuilder();

        if(disponibilidadPiloto()){
            ArrayList<Piloto> pilotosClasificados = new ArrayList<Piloto>();

            //mostramos pilotos de la escuderia
            for (Piloto piloto : pilotos){
                if(!piloto.getDescalificado()){
                    pilotosClasificados.add(piloto);
                }
            }

            Collections.sort(pilotosClasificados, criterioPilotos);

            for (Piloto piloto : pilotosClasificados){
                str.append(piloto.toString()+"\n");
            }
        }

        if(hayPilotosDescalificados()){
            ArrayList<Piloto> pilotosDescalificados = new ArrayList<Piloto>();

            for (Piloto piloto : pilotos){
                if(piloto.getDescalificado()){
                    pilotosDescalificados.add(piloto);
                }
            }

            Collections.sort(pilotosDescalificados, criterioPilotos);

            for (Piloto piloto : pilotosDescalificados){
                str.append(piloto.toString()+"\n");
            }
        }

        return str.toString();
    }

    public String mostrarCochesEscuderia(){
        StringBuilder str = new StringBuilder();

        if(disponibilidadCoche()){
            ArrayList<Coche> cochesConCombustible = new ArrayList<Coche>();
            for(Coche coche: coches){
                if(coche.getCombustibleReal()>0){
                    cochesConCombustible.add(coche);
                }
            }

            Collections.sort(cochesConCombustible, criterioCoches);

            for(Coche coche: cochesConCombustible){
                str.append(coche.toString()+"\n");
            }
        }

        if(hayCochesSinCombustible()){
            ArrayList<Coche> cochesSinCombustible = new ArrayList<Coche>();

            for(Coche coche: coches){
                if(coche.getCombustibleReal()<=0){
                    cochesSinCombustible.add(coche);
                }
            }

            Collections.sort(cochesSinCombustible, criterioCoches);

            for(Coche coche: cochesSinCombustible){
                str.append(coche.toString()+"\n");
            }
        }

        return str.toString();
    }

    public String mostrarPilotosCochesEscuderia(){
        StringBuilder str = new StringBuilder();

        str.append("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        str.append("%%% " + getNombre() + " %%%\n");

        str.append(mostrarPilotosEscuderia());
        str.append(mostrarCochesEscuderia());

        str.append("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        return str.toString();
    }

    public double totalPuntosPilotos(){
        double puntuacion=0;

        for(Piloto piloto: pilotos){
            if(!piloto.getDescalificado()){
                puntuacion=puntuacion+piloto.totalPuntosAcumulado();
            }
        }
        return puntuacion;
    }
    
    
    public double totalCarrerasTodosPilotos(){
        double carreras=0;

        for(Piloto piloto: pilotos){
            carreras=carreras+piloto.totalCarrerasTerminadas();
        }
        return carreras;
    }

    /*
     * Escoje el primer piloto sin descalificar de la escuderia 
     */
    public Piloto escogerPilotoSinDescalificar(){
        Piloto piloto=null;
        boolean bandera=false;
        Iterator<Piloto> itr=pilotos.iterator();

        //busca el primer piloto sin descalificar ordenado segun un criterio
        while(itr.hasNext() && !bandera){
            piloto=itr.next();
            if (piloto.getDescalificado()==false){
                bandera=true;
            }
        }

        borrarPiloto(piloto);

        return piloto;
    }

    /*
     * Escoje el primer coche con combustible
     */
    public Coche escogerCocheConCombustible(){
        Coche coche=null;
        boolean bandera=false;
        Iterator<Coche> it=coches.iterator();

        //busca el primer coche con combustible para asignarlo al piloto
        while(it.hasNext() && !bandera){
            coche=it.next();
            if (coche.getCombustibleReal()>0){
                bandera=true;
            }
        }

        borrarCoche(coche);

        return coche;
    }

    public boolean todosLosPilotosDescalificado(){
        boolean bandera = false;
        int contador=0;
        for(int i=0; i<pilotos.size(); i++){
            if(pilotos.get(i).getDescalificado()){
                contador+=1;
            }
        }
        if(contador==pilotos.size()){
            bandera=true; 
        }
        return bandera;
    }

    public ArrayList<Piloto> devolverPilotosNoDescalificados(){
        ArrayList<Piloto> aux = new ArrayList<Piloto>();
        for(Piloto piloto : pilotos){
            if (!piloto.getDescalificado()){
                aux.add(piloto);
            }
        }
        return aux;
    }

    public ArrayList<Piloto> devolverPilotosDescalificados(){
        ArrayList<Piloto> aux = new ArrayList<Piloto>();
        for(Piloto piloto : pilotos){
            if (piloto.getDescalificado()){
                aux.add(piloto);
            }
        }
        return aux;
    }

}
