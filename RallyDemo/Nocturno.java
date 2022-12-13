
/**
 * Write a description of class Nocturno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nocturno extends ComplejidadExtra
{
    /**
     * Constructor for objects of class Nocturno
     */
    public Nocturno(Circuito circuito){
        super(circuito);
    }

    @Override
    public double getValorComplejidad (){
        return (double)Math.round(decoratorCircuito.getValorComplejidad()*1.2*100)/100;
    }

    @Override
    public double getValorDistancia (){
        return (double)Math.round(decoratorCircuito.getValorDistancia()*0.8*100)/100;
    }

    @Override
    public String mostrarComplejidad(){
        return decoratorCircuito.mostrarComplejidad() + " Nocturno";
    }
}
