
/**
 * Write a description of class Coche here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CocheNormal implements Coche
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Velocidad velocidad; //Es la velocidad teorica del coche
    private Combustible combustible;
    private double combustibleReal;

    /**
     * Constructor for objects of class Coche
     */
    public CocheNormal(String nombre, Velocidad velocidad, Combustible combustible)
    {
        this.nombre=nombre;
        this.velocidad=velocidad;
        this.combustible=combustible;
        this.combustibleReal=combustible.getValor();
    }

    public String getNombre(){
        return nombre;
    }

    public Velocidad getVelocidad(){
        return velocidad;
    }

    public String getNombreTeorica(){
        return velocidad.getNombre();
    }

    public double getVelocidadTeorica(){
        return velocidad.getValor();
    }

    public String getNombreCombustible(){
        return combustible.getNombre();
    }

    public double getCombustibleTeorico(){
        return combustible.getValor();
    }

    public void setCombustibleReal(double valor){
        this.combustibleReal=valor;
    }

    public double getCombustibleReal(){
        return (double)Math.round(combustibleReal*100)/100;
    }

    public String getVelocidadReal(Piloto piloto, Circuito circuito){
        StringBuilder str = new StringBuilder();
        str.append("+++ Con estas condiciones es capaz de correr a " + (double)Math.round(((getVelocidadTeorica()*piloto.getDestreza())/circuito.getValorComplejidad())*100)/100 + " km/hora +++\n");
        return str.toString();
    }

    /*
     * Tiempo en min que tarda el coche en un circuito concreto con un piloto concreto en recorrer el circuito
     */
    public double getTiempoRecorreCircuito(Circuito circuito, double destreza){
        return (double)Math.round(((circuito.getValorDistancia()/((getVelocidadTeorica()*destreza)/circuito.getValorComplejidad()))*60)*100)/100;
    }

    /*
     * Reduce el combustible del coche segun el parametro indicado.
     */
    public String reducirCombustible(double valor){
        StringBuilder str = new StringBuilder();
        setCombustibleReal(getCombustibleReal()-valor);
        str.append("");
        return str.toString();
    }

    public double comprobacionCombustible(double valorConcentracion){
        return getCombustibleReal()-valorConcentracion;
    }

    @Override
    public String toString(){
        return "<coche: "+getNombre()+">"+" <tipo: "+this.getClass().getSimpleName()+">"+" <vel_teó: "+getNombreTeorica()+"("+getVelocidadTeorica()+")>"
        +" <comb: "+getNombreCombustible()+"("+getCombustibleTeorico()+")"+"(actual: "+getCombustibleReal()+")>";
    }
}
