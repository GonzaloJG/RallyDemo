
/**
 * Write a description of interface Piloto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface Piloto
{
    public String getNombre();
    
    public Coche getCocheAsignado();
    
    public boolean getDescalificado();
    
    public int getNumeroAbandonos();
    
    public void ponerDescalificado();
    
    public void asignarCoche(Coche coche);
    
    public void desasignarCoche();
    
    public double getValorConcentracion();
    
    public Resultado obtenerResultado(Circuito circuito);
    
    public int totalCarrerasAbandonadas();
    
    public void incrementarAbandonos();
    
    public int totalPuntosAcumulado();
    
    public int totalCarrerasParticipadas();
    
    public int totalCarrerasTerminadas();
    
    public String conducirCoche(Circuito circuito, int limiteAbandonos);
    
    public double getDestreza();
    
    public boolean comprobarExitoCarrera(Circuito circuito, double tiempo);
    
    public void asignarTiempoEnCircuito(Circuito circuito, double tiempo);
    
    public double getTiempoUltimaCarrera();
    
    public String mostrarResumenResultados();
    
    public void anularPuntosPiloto();
}
