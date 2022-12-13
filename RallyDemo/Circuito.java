
/**
 * Write a description of interface Circuito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface Circuito
{
    public String getNombre();
    
    public Complejidad getComplejidad();
    
    public double getValorComplejidad();
    
    public String getNombreComplejidad();
    
    public Distancia getDistancia();
    
    public String getNombreDistancia();
    
    public double getValorDistancia();
    
    public void setNombre(String nombre);
    
    public void setComplejidad(Complejidad complejidad);
    
    public void setDistancia(Distancia distancia);

    public String mostrarComplejidad();
    
    public Circuito getDecorator();
}
