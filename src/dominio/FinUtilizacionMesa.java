/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Bruno
 */
public class FinUtilizacionMesa extends Evento{
    private Cliente cliente;
    private long rndTiempo;
    
    public FinUtilizacionMesa(Gestor g, Cliente cliente) {
        super(g);
        this.cliente = cliente;
        this.rndTiempo = calcularTiempo();
        this.tiempo = rndTiempo + Parametro.getInstancia().getTiempoActual();
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (o != null && o instanceof FinUtilizacionMesa) {
            FinUtilizacionMesa l = (FinUtilizacionMesa) o;
            return (tiempo == l.tiempo);
        }
        return false;
        
   }

    @Override
    public void ejecutarEvento() {
        Parametro.getInstancia().setTiempoActual(tiempo);
        
        g.agregarTiempoATiempoPermanencia(Parametro.getInstancia().getTiempoActual() - this.cliente.getTiempoLlegada());
    }

    @Override
    public String toString() {
        return "\n          Fin Utilizacion Mesa = {" + "Tiempo=" + this.tiempoString()+", "+cliente.toString() + "}";
    }

    @Override
    public String getNombre() {
        return "Fin Utilizacion Mesa";
    }

    @Override
    public long calcularTiempo() {
        return (long) (g.getGeneradorUtilizacionMesa().rnd());
    }
    
    public String getRNDandTiempo(){
        String r =String.valueOf(rndTiempo)+"-"+String.valueOf(this.tiempoString());
        return r;
    }
    
}
