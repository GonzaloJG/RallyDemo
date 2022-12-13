
/**
 * Write a description of class CircuitoReal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircuitoReal implements Circuito
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Complejidad complejidad;
    private Distancia distancia;

    /**
     * Constructor for objects of class CircuitoReal
     */
    protected CircuitoReal(String nombre, Complejidad complejidad, Distancia distancia)
    {
       setNombre(nombre);
       setComplejidad(complejidad);
       setDistancia(distancia);
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Complejidad getComplejidad(){
        return complejidad;
    }
    
    public double getValorComplejidad(){
        return complejidad.getValor();
    }
    
    public String getNombreComplejidad(){
        return complejidad.getNombre();
    }
    
    public Distancia getDistancia(){
        return distancia;
    }
    
    public String getNombreDistancia(){
        return distancia.getNombre();
    }
    
    public double getValorDistancia(){
        return distancia.getValor();
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setComplejidad(Complejidad complejidad){
        this.complejidad=complejidad;
    }
    
    public void setDistancia(Distancia distancia){
        this.distancia=distancia;
    }
    
    public String mostrarComplejidad(){         //En un principio el circuito no tiene ninguna complejidad entonces el string devuelve vacio
        return "";
    }
    
    /*
     * quita la ultima capa que se le ha añadido al circuito en lo que respecta a complejidades.
     */
    @Override
    public Circuito getDecorator(){     //quitar capas
        return this;
    } 
    
    @Override
    public String toString(){
        return "<circuito: " + getNombre() + ">" + " <cond: " + mostrarComplejidad() + ">" + " <comp: "  + getComplejidad()  + " (actual: " +
        getValorComplejidad() +  ")>" + " <dist: " + getDistancia()  + " (actual: " + getValorDistancia() + ")>" ;
    }
}
