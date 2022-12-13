import java.util.Comparator;
/**
 * Write a description of class comparadorVelocidadTeorica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorVelocidadTeorica implements Comparator<Coche>
{
   public int compare (Coche c1, Coche c2){
       if(c1.getVelocidadTeorica()==c2.getVelocidadTeorica()){
           return new ComparadorCocheNombre().compare(c1, c2);
       }
       else{
          if(c1.getVelocidadTeorica()>c2.getVelocidadTeorica()){ 
              return 1;
          }
          else{
              return -1;
          }
       }
   }
}
