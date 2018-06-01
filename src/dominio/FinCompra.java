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
public class FinCompra extends Evento{
    
    private Cliente cliente;
    
    public FinCompra(Gestor g, Cliente cliente) {
        super(g);
        
        this.cliente = cliente;
        this.tiempo = calcularTiempo() + Parametro.getInstancia().getTiempoActual();
    }
    
    @Override
    public long calcularTiempo() {
        return (long) (g.getTiempoCompraTicket());
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ejecutarEvento() {
        Parametro.getInstancia().setTiempoActual(tiempo);
        
        g.getCaja().setEstado(EstadoCaja.LIBRE);
        
        if(!g.getColaClientesCaja().estaVacia()){
            Cliente clienteComprar = g.getColaClientesCaja().avanzar();
            this.atenderCliente(clienteComprar, g.getCaja());
        }
        
        if(g.getEmpleadosEntrega().hayEmpleadoLibre()){
            this.servirCliente(cliente,g.getEmpleadosEntrega().getEmpleadoLibre());
        }else{
            this.cliente.setEstado(EstadoCliente.EN_COLA);
            g.getColaClientesEntregaPedido().agregarItem(this.cliente);
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
