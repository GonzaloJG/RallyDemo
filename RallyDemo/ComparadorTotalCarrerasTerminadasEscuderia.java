import java.util.Comparator;
/**
 * Write a description of class ComparadorTotalCarrerasTerminadasEscuderia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorTotalCarrerasTerminadasEscuderia implements Comparator<Escuderia>
{
   public int compare(Escuderia e1, Escuderia e2){
        if(e1.totalCarrerasTodosPilotos()==e2.totalCarrerasTodosPilotos()){
            return new ComparadorNombreEscuderia().compare(e1, e2);
        }
        
        else{
            if (e1.totalCarrerasTodosPilotos()>e2.totalCarrerasTodosPilotos()){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}
