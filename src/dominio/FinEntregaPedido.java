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
public class FinEntregaPedido extends Evento{
    private Cliente cliente;
    private double rndAccion2;
    private EmpleadoEntrega empleado;
    
    public FinEntregaPedido(Gestor g, Cliente cliente, EmpleadoEntrega emp) {
        super(g);
        this.cliente = cliente;
        this.empleado = emp;
        this.rndAccion2 = g.getGeneradorAccion2().nextDouble();
        this.tiempo = calcularTiempo() + Parametro.getInstancia().getTiempoActual();
    }
    
    @Override
    public long calcularTiempo() {
        return (long) (g.getGeneradorEntregaPedido().rnd());
    }
    
    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ejecutarEvento() {
        Parametro.getInstancia().setTiempoActual(tiempo);
        
        this.empleado.setEstado(EstadoEmpleadoEntrega.LIBRE);
        
        if(!g.getColaClientesEntregaPedido().estaVacia()){
            Cliente clienteComprar = g.getColaClientesEntregaPedido().avanzar();
            this.servirCliente(clienteComprar, this.empleado);
        }
        
        if(rndAccion2 < g.getTasaUtilizacionMesa()){
            this.consumirPedidoEnMesa(cliente);
        } else {
            g.agregarTiempoATiempoPermanencia(Parametro.getInstancia().getTiempoActual() - this.cliente.getTiempoLlegada());
        }
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
