
/**
 * Write a description of class CocheRapido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CocheRapido extends CocheNormal
{
    // instance variables - replace the example below with your own
    private double depositoNitro;

    /**
     * Constructor for objects of class CocheRapido
     */
    public CocheRapido(String nombre, Velocidad velocidad, Combustible combustible)
    {
        super(nombre, velocidad, combustible);
        this.depositoNitro=80;
    }

    public void setDepositoNitro(double valor){
        depositoNitro=valor;
    }

    public double getDepositoNitro(){
        return depositoNitro;
    }

    @Override
    public String getVelocidadReal(Piloto piloto, Circuito circuito){
        StringBuilder str = new StringBuilder();
        double velocidad;
        double aux=0; //me servira para calcular el 20% de la velocidad
        velocidad = getVelocidadSinNitro(piloto.getDestreza(), circuito);

        str.append(super.getVelocidadReal(piloto, circuito));    

        //if(piloto.comprobarExitoCarrera(circuito)){   
        if (depositoNitro>0){
            aux = velocidad * 0.2;

            if (aux > depositoNitro){
                aux=depositoNitro;
            }
            velocidad = velocidad + aux;
            //msg de nitro
            str.append("+++ El " + super.getNombre() + " usa " + (double)Math.round((aux)*100)/100 + " de nitro para alcanzar " + (double)Math.round((velocidad)*100)/100 + " km/hora ");
            reducirNitro(aux);
            str.append("y el nitro restante es "+(double)Math.round((getDepositoNitro())*100)/100+ " +++\n"); 
        }
        //}
        return str.toString();
    }

    //Este modulo sirve para mostrar a cuanto puede correr el piloto con las condiciones
    public double getVelocidadSinNitro(double destreza, Circuito circuito){ 
        double velocidad;
        velocidad = (getVelocidadTeorica()*destreza)/circuito.getValorComplejidad();

        return (double)Math.round(velocidad*100) / 100;
    }

    public void reducirNitro(double valor){
        setDepositoNitro(depositoNitro-valor);
    }

    @Override
    public double getTiempoRecorreCircuito(Circuito circuito, double destreza){
        double velocidad;
        double aux=0;
        velocidad = getVelocidadSinNitro(destreza, circuito);
        if (depositoNitro>0){
            aux = velocidad * 0.2;

            if (aux > depositoNitro){
                aux=depositoNitro;
            }
            velocidad = velocidad + aux;
        }
        return (double)Math.round(((circuito.getValorDistancia()/velocidad)*60)*100)/100;
    }

    @Override
    public String toString(){
        return super.toString() + ">" + " <nitroPendiente: " + (double)Math.round(getDepositoNitro()*100)/100 + ">";
    }

}
