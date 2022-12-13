
/**
 * Write a description of class PilotoExperimentado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PilotoExperimentado extends TipoPiloto
{
    // instance variables - replace the example below with your own
    private double destreza;

    /**
     * Constructor for objects of class PilotoExperimentado
     */
    public PilotoExperimentado(String nombre, Concentracion concentracion)
    {
       super(nombre, concentracion);
       this.destreza=((concentracion.getValor()+3)/130)*1.03;
    }
    
    public double getDestreza(){
       return (double)Math.round(destreza * 100)/100; 
    }
}
