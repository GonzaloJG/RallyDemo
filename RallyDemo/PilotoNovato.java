
/**
 * Write a description of class PilotoNovato here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PilotoNovato extends TipoPiloto
{
    // instance variables - replace the example below with your own
    private double destreza;

    /**
     * Constructor for objects of class PilotoNovato
     */
    public PilotoNovato(String nombre, Concentracion concentracion)
    {
        super(nombre, concentracion);
        this.destreza=(concentracion.getValor()*0.97/120)-0.03;
    }
    
    public double getDestreza(){
       return (double)Math.round(destreza * 100)/100; 
    }
}
