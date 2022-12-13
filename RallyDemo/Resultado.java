
/**
 * Write a description of class Resultados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Resultado
{
    // instance variables - replace the example below with your own
    private double tiempo;
    private int puntos;
    private Circuito circuito;

    /**
     * Constructor for objects of class Resultados
     */
    public Resultado(double tiempo, Circuito circuito)
    {
        this.tiempo=tiempo;
        this.circuito=circuito;
    }

    public double getTiempo(){
        return tiempo;
    }

        public void setPuntos(int puntos){
        this.puntos=puntos;
    }
    
    public int getPuntos(){
        return puntos;
    }

    public Circuito getCircuito(){
        return circuito;
    }

    @Override
    public String toString(){
        return "Carrera(" + getCircuito().getNombre() + ") - Puntos:" + getPuntos() + " - Tiempo:" + (double)Math.round(getTiempo()*100)/100 + " minutos\n";
    }
}
