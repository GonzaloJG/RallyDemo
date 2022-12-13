
/**
 * Write a description of class Mojado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mojado extends ComplejidadExtra
{
    /**
     * Constructor for objects of class Mojado
     */
    public Mojado(Circuito circuito)
    {
        super(circuito);
    }
    
    @Override
    public double getValorComplejidad(){
        return (double)Math.round(decoratorCircuito.getValorComplejidad()*1.15*100)/100;
    }
    
    @Override
    public double getValorDistancia(){
        return (double)Math.round(decoratorCircuito.getValorDistancia()*0.85*100)/100;
    }

    @Override
    public String mostrarComplejidad(){
        return decoratorCircuito.mostrarComplejidad() + " Mojado";
    }
}
