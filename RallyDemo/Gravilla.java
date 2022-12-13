
/**
 * Write a description of class Gravilla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gravilla extends ComplejidadExtra
{
    /**
     * Constructor for objects of class Gravilla
     */
    public Gravilla(Circuito circuito)
    {
        super(circuito);
    }

    @Override
    public double getValorComplejidad(){
        return (double)Math.round(decoratorCircuito.getValorComplejidad()*1.05*100)/100;
    }
    
    @Override
    public double getValorDistancia(){
        return (double)Math.round(decoratorCircuito.getValorDistancia()*0.95*100)/100;
    }
   
    @Override
    public String mostrarComplejidad(){
        return decoratorCircuito.mostrarComplejidad() + " Gravilla";
    }
}
