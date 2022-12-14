import java.util.Comparator;
/**
 * Write a description of class comparadorNombre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorNombre implements Comparator<Piloto>
{
    public int compare(Piloto p1, Piloto p2){
        return (p1.getNombre().compareTo(p2.getNombre()));
    }
}
