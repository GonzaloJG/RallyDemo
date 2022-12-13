import java.util.Comparator;
/**
 * Write a description of class comparadorTotalPuntos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorTotalPuntos implements Comparator<Piloto>
{
    public int compare(Piloto p1, Piloto p2){
       if(p1.totalPuntosAcumulado()==p2.totalPuntosAcumulado()) {
           return new ComparadorTotalCarrerasTerminadas().compare(p1, p2);
       }
       else{
           if (p1.totalPuntosAcumulado()>p2.totalPuntosAcumulado()){
               return 1;
           }
           else{
               return -1;
           }
       } 
    }
}
