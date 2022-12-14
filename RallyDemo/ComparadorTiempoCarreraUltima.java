import java.util.Comparator;
/**
 * Write a description of class comparadorTiempoCarreraUltima here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorTiempoCarreraUltima implements Comparator<Piloto>
{
    public int compare(Piloto p1, Piloto p2){
       if(p1.getTiempoUltimaCarrera()==p2.getTiempoUltimaCarrera()) {
           return 0;
       }
       else{
           if (p1.getTiempoUltimaCarrera()>p2.getTiempoUltimaCarrera()){
               return 1;
           }
           else{
               return -1;
           }
       } 
    }
}
