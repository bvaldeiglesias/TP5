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
    private String accion2;
    private EmpleadoEntrega empleado;
    private long rndTiempoEntrega;
    private String rndAndTimeNextEntrega;
    private String rndAndTiempoConsumicion;
    
    public FinEntregaPedido(Gestor g, Cliente cliente, EmpleadoEntrega emp) {
        super(g);
        this.cliente = cliente;
        this.empleado = emp;
        this.rndAccion2 = g.getGeneradorAccion2().nextDouble();
        this.rndTiempoEntrega = calcularTiempo();
        this.tiempo = rndTiempoEntrega + Parametro.getInstancia().getTiempoActual();
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
            rndAndTimeNextEntrega = this.servirCliente(clienteComprar, this.empleado);
        }
        
        if(rndAccion2 < g.getTasaOcupacionMesa()){
            rndAndTiempoConsumicion = this.consumirPedidoEnMesa(cliente);
            accion2 = "Utiliza Mesa";
        } else {
            g.agregarTiempoATiempoPermanencia(Parametro.getInstancia().getTiempoActual() - this.cliente.getTiempoLlegada());
            accion2 = "Se retira";
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

    String getRndAndTiempoEntregaPedido() {
        String r =String.valueOf(rndTiempoEntrega)+"-"+String.valueOf(this.tiempoString());
        return r;
    }

    public String getRndAndTimeNextEntrega() {
        return rndAndTimeNextEntrega;
    }

    public void setRndAndTimeNextEntrega(String rndAndTimeNextEntrega) {
        this.rndAndTimeNextEntrega = rndAndTimeNextEntrega;
    }

    public double getRndAccion2() {
        return rndAccion2;
    }

    public void setRndAccion2(double rndAccion2) {
        this.rndAccion2 = rndAccion2;
    }

    public String getAccion2() {
        return accion2;
    }

    public void setAccion2(String accion2) {
        this.accion2 = accion2;
    }

    public String getRndAndTiempoConsumicion() {
        return rndAndTiempoConsumicion;
    }

    public void setRndAndTiempoConsumicion(String rndAndTiempoConsumicion) {
        this.rndAndTiempoConsumicion = rndAndTiempoConsumicion;
    }

    
    
}
