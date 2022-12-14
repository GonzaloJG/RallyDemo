import java.util.Comparator;
/**
 * Write a description of class comparadorCocheNombre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorCocheNombre implements Comparator<Coche>
{
        public int compare(Coche c1, Coche c2){
            return (c1.getNombre().compareTo(c2.getNombre()));
    }
}
