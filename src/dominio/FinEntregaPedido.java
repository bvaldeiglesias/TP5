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

    public Cliente getCliente() {
        return cliente;
    }
    
    
    
    @Override
    public boolean equals(Object o) {
        
         if (o != null && o instanceof FinEntregaPedido) {
            FinEntregaPedido f = (FinEntregaPedido) o;
            return (tiempo == f.tiempo && cliente == f.getCliente());
        }
        return false;
    }

    @Override
    public void ejecutarEvento() {
        Parametro.getInstancia().setTiempoActual(tiempo);
        
        this.empleado.setEstado(EstadoEmpleadoEntrega.LIBRE);
        
        if(!g.getColaClientesEntregaPedido().estaVacia()){
            Cliente clienteComprar = g.getColaClientesEntregaPedido().avanzar();
            this.servirCliente(clienteComprar, this.empleado);
        }
        
        if(rndAccion2 < g.getTasaOcupacionMesa()){
            this.consumirPedidoEnMesa(cliente);
        } else {
            g.agregarTiempoATiempoPermanencia(Parametro.getInstancia().getTiempoActual() - this.cliente.getTiempoLlegada());
        }
    }

    @Override
    public String toString() {
        
        return "\n          Fin Entrega Pedido = {" + "Tiempo = " + this.tiempoString()+", " + cliente.toString()+"}";
        
  }

    @Override
    public String getNombre() {
        return "Fin entrega Pedido " +this.cliente.getNumero();
    }

    
    
}
