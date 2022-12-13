
/**
 * Enumeration class distancia - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Distancia
{
    CORTA("CORTA",250.0), INTERMEDIA("INTERMEDIA",275.0), LARGA("LARGA",300.0);
    
    private final String nombre;
    private final double valor;
    
    Distancia (String nombre, double valor){
        this.nombre=nombre;
        this.valor=valor;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getValor(){
        return valor;
    }
    
    @Override
    public String toString(){
        return getNombre() + "(original: " + getValor() + " )";
    }
}
