import java.util.Comparator;
/**
 * Write a description of class ComparadorTotalCarrerasTerminadas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorTotalCarrerasTerminadas implements Comparator<Piloto>
{
    public int compare(Piloto p1, Piloto p2){
        if(p1.totalCarrerasTerminadas()==p2.totalCarrerasTerminadas()){
            return new ComparadorNombre().compare(p1, p2);
        }
        
        else{
            if (p1.totalCarrerasTerminadas()>p2.totalCarrerasTerminadas()){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}
