import java.util.Comparator;
/**
 * Write a description of class ComparadorTotalPuntosEscuderia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorTotalPuntosEscuderia implements Comparator<Escuderia>
{
   public int compare(Escuderia e1, Escuderia e2){
       if(e1.totalPuntosPilotos()==e2.totalPuntosPilotos()) {
           return new ComparadorTotalCarrerasTerminadasEscuderia().compare(e1, e2);
       }
       else{
           if (e1.totalPuntosPilotos()>e2.totalPuntosPilotos()){
               return 1;
           }
           else{
               return -1;
           }
       } 
    }
}
