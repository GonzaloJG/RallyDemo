import java.util.Comparator;
/**
 * Write a description of class comparadorNombreCoche here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorNombreCircuito implements Comparator<Circuito>
{
    public int compare(Circuito c1, Circuito c2){
        return (c1.getNombre().compareTo(c2.getNombre()));
    }
}
