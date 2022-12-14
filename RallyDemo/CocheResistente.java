
/**
 * Write a description of class CocheResistente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CocheResistente extends CocheNormal
{
    // instance variables - replace the example below with your own
    private int depositoExtra;

    /**
     * Constructor for objects of class CocheResistente
     */
    public CocheResistente(String nombre, Velocidad velocidad, Combustible combustible)
    {
        super(nombre, velocidad, combustible);
        this.depositoExtra=100;
    }
    
    public double getDepositoExtra(){
        return depositoExtra;
    }

    /*
     * Reduce el combustible en funcion del valor pasado como parametro
     */
    @Override
    public String reducirCombustible(double valor){ //valor es las unidades que se van a reducir en el combustible
        StringBuilder str = new StringBuilder();
        if(valor>super.getCombustibleReal() && depositoExtra>0){
            // setCombustibleReal(combustibleReal+depositoExtra);
            valor=valor-depositoExtra;
            depositoExtra=0;
            //msg de combustible
            str.append("+++ El "+getNombre()+" tiene que recurrir al depósito de reserva para poder correr +++\n");
        }
        setCombustibleReal(getCombustibleReal()-valor);
        return str.toString();
    }

    @Override
    public double comprobacionCombustible(double valorConcentracion){
        return getCombustibleReal()+depositoExtra-valorConcentracion;
    }

    @Override
    public String toString(){
        return super.toString() + ">" +" <reserva: " + getDepositoExtra() + ">";
    }
}
