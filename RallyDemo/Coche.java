/**
 * Write a description of interface Coche here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface Coche
{
    public String getNombre();
    
    public Velocidad getVelocidad();
    
    public String getNombreTeorica();
    
    public double getVelocidadTeorica();
    
    public String getVelocidadReal(Piloto piloto, Circuito circuito);
    
    public double getTiempoRecorreCircuito(Circuito circuito, double destreza);
    
    public String reducirCombustible(double valor);
    
    public double getCombustibleReal();
    
    public void setCombustibleReal(double valor);
    
    public String getNombreCombustible();
    
    public double getCombustibleTeorico();
    
    public double comprobacionCombustible(double valorConcentracion);
    
}
