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
    
    public FinConsumicionPedido(Gestor g, Cliente cliente) {
        super(g);
        this.cliente = cliente;
        this.tiempo = calcularTiempo() + Parametro.getInstancia().getTiempoActual();
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
        
        return "Fin Consumicion Pedido: " + "Tiempo=" + this.tiempoString();
        
    }

    @Override
    public String getNombre() {
        return "Fin consumicion Pedido";
    }

    @Override
    public long calcularTiempo() {
        return (long) (g.getGeneradorConsumicionPedido().rnd());
    }
    
}
