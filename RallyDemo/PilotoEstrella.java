
/**
 * Write a description of class PilotoEstrella here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PilotoEstrella extends TipoPiloto
{
    // instance variables - replace the example below with your own
    private double destreza;

    /**
     * Constructor for objects of class PilotoEstrella
     */
    public PilotoEstrella(String nombre, Concentracion concentracion)
    {
         super(nombre, concentracion); 
         this.destreza=(((concentracion.getValor()+6)/140)*1.06)+0.05;
    }
    
    public double getDestreza(){
       return (double)Math.round(destreza * 100)/100; 
    }
}
