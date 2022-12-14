import java.util.Comparator;
/**
 * Write a description of class ComparadorDistancia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorDistancia implements Comparator<Circuito>
{
       public int compare(Circuito c1, Circuito c2){
       if(c1.getValorDistancia()==c2.getValorDistancia()) {
           return new ComparadorNombreCircuito().compare(c1, c2);
       }
       else{
           if (c1.getValorDistancia()>c2.getValorDistancia()){
               return 1;
           }
           else{
               return -1;
           }
       } 
    } 
}
