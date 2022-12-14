import java.util.Comparator;
/**
 * Write a description of class comparadorDestreza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorDestreza implements Comparator<Piloto>
{
    public int compare (Piloto p1, Piloto p2){
       if(p1.getDestreza()==p2.getDestreza()) {
           return new ComparadorNombre().compare(p1, p2);
       }
       else{
           if (p1.getDestreza()>p2.getDestreza()){
               return 1;
           }
           else{
               return -1;
           }
       }
    }

}

