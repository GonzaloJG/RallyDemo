
/**
 * Enumeration class Concentracion - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Concentracion
{
    DESPISTADO ("DESPISTADO", 90.0), NORMAL ("NORMAL", 100.0), CONCENTRADO ("CONCENTRADO", 110.0), ZEN ("ZEN", 120.0); //Posibles valores de concentracion
    
    private final String nombre;
    private final double valor;
    
    Concentracion (String nombre, double valor){
        this.nombre=nombre;
        this.valor=valor;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getValor() {
        return valor;
    }
}
