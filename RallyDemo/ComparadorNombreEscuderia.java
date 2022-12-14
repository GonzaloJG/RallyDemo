import java.util.Comparator;
/**
 * Write a description of class comparadorNombreEscuderia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorNombreEscuderia implements Comparator<Escuderia>
{
    public int compare(Escuderia e1, Escuderia e2){
        return (e1.getNombre().compareTo(e2.getNombre()));
    }
}
