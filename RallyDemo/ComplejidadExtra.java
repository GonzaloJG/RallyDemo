/**
 * Abstract class ComplejidadExtra - write a description of the class here
 * 
 * @author: 
 * Date: 
 */

/*
 * Patron Decorator
 */
public abstract class ComplejidadExtra extends CircuitoReal
{
    protected Circuito decoratorCircuito;                   //Debemos de tener un campo que referencia al objeto que se va a decorar. Patron Decorator.

    public ComplejidadExtra (Circuito circuito) {
        super(circuito.getNombre(), circuito.getComplejidad(), circuito.getDistancia());
        decoratorCircuito = circuito;                                                     
    }

    public Circuito getDecorator(){     //Este modulo quita la capa ultima que se le puso al circuito
        return decoratorCircuito;
    } 
    
    public String mostrarComplejidad(){
        return decoratorCircuito.mostrarComplejidad();
    }
}
