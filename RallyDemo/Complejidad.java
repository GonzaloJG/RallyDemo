
/**
 * Enumeration class complejidad - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Complejidad
{
    BAJA ("BAJA", 1.0), MEDIA("MEDIA", 1.25), ALTA("ALTA", 1.5);  //Estos son los posibles valores de compleijidad que puede tener un circuito
    
    private final String nombre;
    private final double valor;
    
    Complejidad(String nombre, double valor) {
        this.nombre=nombre;
        this.valor=valor;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getValor() {
        return valor;
    }
    
    @Override
    public String toString(){
        return getNombre() + "(original: " + getValor() + " )";
    }
}
