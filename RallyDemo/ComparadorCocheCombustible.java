import java.util.Comparator;
/**
 * Write a description of class ComparadorCocheCombustible here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorCocheCombustible implements Comparator<Coche>
{
    public int compare(Coche c1, Coche c2){
        if(c1.getCombustibleReal()==c2.getCombustibleReal()){
           return new ComparadorCocheNombre().compare(c1, c2);
       }
       else{
          if(c1.getCombustibleReal()>c2.getCombustibleReal()){ 
              return 1;
          }
          else{
              return -1;
          }
       }
   }
}

