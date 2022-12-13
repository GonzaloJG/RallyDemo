import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Piloto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class TipoPiloto implements Piloto
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Coche coche;
    private Concentracion concentracion;    //tiempo medido en minutos
    private boolean descalificado;
    private List <Resultado> resultados;
    private int numeroAbandonos;

    /**
     * Constructor for objects of class Piloto
     */
    public TipoPiloto(String nombre, Concentracion concentracion)
    {
        this.nombre=nombre;
        this.coche=null;
        this.concentracion=concentracion;
        this.descalificado=false;
        resultados=new ArrayList<Resultado>();
        numeroAbandonos=0;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void asignarCoche(Coche coche){
        this.coche=coche;
    }
    
    public void desasignarCoche(){
        this.coche=null;
    }
    
    public Coche getCocheAsignado(){
        return coche;
    }
    
    public int getNumeroAbandonos(){
        return numeroAbandonos;
    }

    //devuelve true si el piloto esta descalificado
    public boolean getDescalificado(){
        return descalificado;
    }

    public void ponerDescalificado(){
        descalificado=true;
    }

    public double getValorConcentracion(){
        return concentracion.getValor();
    }

    public String getNombreConcentracion(){
        return concentracion.getNombre();
    }

    /*
     * Devuelve el resultado obtenido en el circuito pasado como parametro por dicho piloto
     */
    public Resultado obtenerResultado(Circuito circuito){
        boolean enc=false;
        Resultado aux = null;
        int i=0;

        while (!enc && i<resultados.size()){
            aux=resultados.get(i);
            if (aux.getCircuito().equals(circuito)){
                enc=true;  
            }
            i++;
        }

        return aux;
    }

    public void incrementarAbandonos(){
        numeroAbandonos++;
    }

    public int totalCarrerasAbandonadas(){
        int carrerasAbandonadas=0;
        for (Resultado aux: resultados){
            if (aux.getPuntos()<0){  //Si el resultado de la carrera es 0, quiere decir que el piloto no puntuo debido a que esa carrera no la pudo terminar.
                carrerasAbandonadas++;
            }
        }
        return carrerasAbandonadas;
    }

    /*
     * Devuelve el total de puntos acumulados por el piloto
     */
    public int totalPuntosAcumulado(){
        int puntosTotales=0;
        for (Resultado aux: resultados){
            puntosTotales=aux.getPuntos()+puntosTotales;
        }
        return puntosTotales;
    }

    /*
     * Devuelve el numero total de carreras en las que el piloto a participado.
     */
    public int totalCarrerasParticipadas(){
        return resultados.size();
    }

    /*
     * Devuelve el total de carreras terminadas
     */
    public int totalCarrerasTerminadas(){
        int carrerasTerminadas=0;
        for (Resultado aux: resultados){
            if (aux.getPuntos()>0){  //Si en el resultado la puntuacion es distinta 0 en ese circuito, quiere decir que el piloto puntuo, lo cual esa carrera la pudo terminar
                carrerasTerminadas++;
            }
        }
        return carrerasTerminadas;
    }

    /*
     * Este metodo simula la conduccion del piloto en un circuito concreto, siendo capaz de guardar los resultados 
     * en funcion de si es capaz de terminar o no la carrera
     */
    public String conducirCoche(Circuito circuito, int limiteAbandonos){
        StringBuilder str = new StringBuilder();
        double tiempoRecorreCircuito=coche.getTiempoRecorreCircuito(circuito, getDestreza());
        str.append(coche.getVelocidadReal(this, circuito)); //Con estas condiciones......
        str.append("");

        if (comprobarExitoCarrera(circuito, tiempoRecorreCircuito)){
            str.append(coche.reducirCombustible(tiempoRecorreCircuito));
            str.append("+++ "+getNombre()+" termina la carrera en "+ tiempoRecorreCircuito +" minutos +++\n");
            asignarTiempoEnCircuito(circuito, tiempoRecorreCircuito); //creamos un resultado con el tiempo y el circuito. Los puntos los

            str.append("+++ El combustible del "+getCocheAsignado().getNombre() +" tras la carrera es "+ (double)Math.round(getCocheAsignado().getCombustibleReal()*100)/100 +" +++\n");
            str.append("@@@\n");
        }
        else{   
            if(getValorConcentracion() < tiempoRecorreCircuito){
                double comprobacionCombustible=coche.comprobacionCombustible(getValorConcentracion());
                if(comprobacionCombustible<=0){
                    double numeroNegativo= coche.getCombustibleReal() - tiempoRecorreCircuito;
                    double cAntesReducir=coche.getCombustibleReal();
                    str.append(coche.reducirCombustible(tiempoRecorreCircuito));

                    str.append("¡¡¡ El "+coche.getNombre()+" se quedó sin combustible a falta de "+(double)Math.round((Math.abs(numeroNegativo))*100)/100+" minutos para terminar !!!\n");
                    str.append("¡¡¡ En el momento de quedarse sin combustible llevaba en carrera "+ cAntesReducir +" minutos !!!\n");

                    asignarTiempoEnCircuito(circuito, numeroNegativo);

                    str.append("+++ El combustible del "+getCocheAsignado().getNombre() +" tras la carrera es "+ (double)Math.round(getCocheAsignado().getCombustibleReal()*100)/100 +" +++\n");
                    str.append("@@@\n"); 
                }else{
                    double numeroNegativo=getValorConcentracion()-tiempoRecorreCircuito;
                    str.append(coche.reducirCombustible(getValorConcentracion()));
                    str.append("¡¡¡ "+getNombre()+ " perdió la concentración a falta de " +(double)Math.round((Math.abs(numeroNegativo))*100)/100+" minutos para terminar !!!\n");
                    str.append("¡¡¡ En el momento del despiste llevaba en carrera "+ getValorConcentracion() +" minutos !!!\n");

                    asignarTiempoEnCircuito(circuito, numeroNegativo);

                    str.append("+++ El combustible del "+getCocheAsignado().getNombre() +" tras la carrera es "+ (double)Math.round(getCocheAsignado().getCombustibleReal()*100)/100 +" +++\n");
                    str.append("@@@\n");
                }
            }  
            else{
                double numeroNegativo= coche.getCombustibleReal() - tiempoRecorreCircuito;
                double cAntesReducir=coche.getCombustibleReal();
                str.append(coche.reducirCombustible(tiempoRecorreCircuito));
                str.append("¡¡¡ El "+coche.getNombre()+" se quedó sin combustible a falta de "+(double)Math.round((Math.abs(numeroNegativo))*100)/100+" minutos para terminar !!!\n");
                str.append("¡¡¡ En el momento de quedarse sin combustible llevaba en carrera "+ cAntesReducir +" minutos !!!\n");

                asignarTiempoEnCircuito(circuito, numeroNegativo);

                str.append("+++ El combustible del "+getCocheAsignado().getNombre() +" tras la carrera es "+ (double)Math.round(getCocheAsignado().getCombustibleReal()*100)/100 +" +++\n");
                str.append("@@@\n");
            }

            //En cualquiera de los casos el piloto debe ser descalificado
            incrementarAbandonos();
            if(limiteAbandonos==getNumeroAbandonos()){
                str.append("@@@\n");
                str.append("¡¡¡ "+ getNombre() +" es DESCALIFICADO del campeonato por alcanzar el límite de abandonos("+getNumeroAbandonos()+") !!!\n");
                str.append("@@@\n");
                str.append("\n");
            }
        }

        return str.toString();
    }   

    /*
     * Devuelve true si la carrera finalizo, false si tuvo que abandonar
     * Borrar este modulo
     */
    public boolean comprobarExitoCarrera(Circuito circuito, double tiempo){
        boolean termina = false;
        if ((concentracion.getValor() >= tiempo) && (coche.getCombustibleReal() >= tiempo)){ 
            termina=true;
        }
        return termina;
    }

    /*
     * Asigna el tiempo obtenidos en el circuito
     */
    public void asignarTiempoEnCircuito(Circuito circuito, double tiempo){
        Resultado aux= new Resultado(tiempo, circuito);
        resultados.add(aux);
    }

    public double getTiempoUltimaCarrera(){
        return resultados.get(resultados.size()-1).getTiempo();
    }

    public String mostrarResumenResultados(){
        StringBuilder str = new StringBuilder();
        for(Resultado resultado: resultados){
            str.append(resultado.toString());
        }
        return str.toString();
    }

    public void anularPuntosPiloto(){
        for(Resultado resultado: resultados){
            resultado.setPuntos(0);
        }
    }
    
    @Override
    public String toString(){
        return "<piloto: " + getNombre() + ">" + " <tipo: " + this.getClass().getSimpleName() + ">" + " <dest: " + (double)Math.round(getDestreza() * 100) / 100 + ">" + " <conc: " 
        + getNombreConcentracion() +  "(" + getValorConcentracion() + ")>" + "<descalificado: " + getDescalificado() + ">" ;
    }
}
