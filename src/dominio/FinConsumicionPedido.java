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
public class FinConsumicionPedido extends Evento{
    private Cliente cliente;
    private long rndTiempo;
    
    public FinConsumicionPedido(Gestor g, Cliente cliente) {
        super(g);
        this.cliente = cliente;
        this.rndTiempo = calcularTiempo();
        this.tiempo = rndTiempo + Parametro.getInstancia().getTiempoActual();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof FinConsumicionPedido) {
            FinConsumicionPedido f = (FinConsumicionPedido) o;
            return (tiempo == f.tiempo);
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
        
        return "\n          Fin Consumicion Pedido = {" + "Tiempo = " + this.tiempoString()+", " + cliente.toString()+"}";
        
    }

    @Override
    public String getNombre() {
        return "Fin consumicion Pedido";
    }

    @Override
    public long calcularTiempo() {
        return (long) (g.getGeneradorConsumicionPedido().rnd());
    }

    String getRNDandTiempo() {
        String r =String.valueOf(rndTiempo)+"-"+String.valueOf(this.tiempoString());
        return r;
    }
    
}
