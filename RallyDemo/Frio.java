
/**
 * Write a description of class Frio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frio extends ComplejidadExtra
{
    /**
     * Constructor for objects of class Frio
     */
    public Frio(Circuito circuito)
    {
        super(circuito);
    }
    
    @Override
    public double getValorComplejidad(){
        return (double)Math.round(decoratorCircuito.getValorComplejidad()*1.1*100)/100;
    }
    
    @Override
    public double getValorDistancia(){
        return (double)Math.round(decoratorCircuito.getValorDistancia()*0.9*100)/100;
    }

    @Override
    public String mostrarComplejidad(){
        return decoratorCircuito.mostrarComplejidad() + " Frio";
        
    }
}
