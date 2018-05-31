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
public class LlegadaCliente extends Evento {
    private Cliente cliente;
    
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof LlegadaCliente) {
            LlegadaCliente l = (LlegadaCliente) o;
            return (tiempo == l.tiempo && cliente == l.getCliente());
        }
        return false;
    }

    public LlegadaCliente(Gestor g) {
        super(g);
        cliente = new Cliente();
        this.cliente.setNumero(Parametro.getInstancia().generarNumeroCliente());
        
        
    }
    
    

    @Override
    public void ejecutarEvento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
