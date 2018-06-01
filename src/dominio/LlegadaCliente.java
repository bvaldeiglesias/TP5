/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.text.NumberFormat;

/**
 *
 * @author Bruno
 */
public class LlegadaCliente extends Evento {
    private Cliente cliente;
    private double rndAccion1;
    
    private double rndLlegadaCliente;
    
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof LlegadaCliente) {
            LlegadaCliente l = (LlegadaCliente) o;
            return (this.tiempo == l.tiempo && this.cliente == l.getCliente());
        }
        return false;
    }

    public LlegadaCliente(Gestor g) {
        super(g);
        cliente = new Cliente();
        this.cliente.setNumero(Parametro.getInstancia().generarNumeroCliente());
        
        this.rndAccion1 = g.getGeneradorAccion1().nextDouble();
        this.rndLlegadaCliente = g.getGeneradorLlegadaClientes().rnd();
        
        this.tiempo = calcularTiempo() + Parametro.getInstancia().getTiempoActual();
        this.cliente.setTiempoLlegada(this.tiempo);
    }
    
    @Override
    public long calcularTiempo() {
        return (long) (rndLlegadaCliente);
    }

    @Override
    public void ejecutarEvento() {
        Parametro.getInstancia().setTiempoActual(tiempo);

        LlegadaCliente proximaLlegada = new LlegadaCliente(this.g);
        this.g.getConjuntoEventos().add(proximaLlegada);
        
        if (rndAccion1 < g.getTasaCompra()){
            if(!g.getCaja().estaLibre()){
                this.cliente.setEstado(EstadoCliente.EN_COLA);
                g.getColaClientesCaja().agregarItem(this.cliente);
            } else {
                this.atenderCliente(this.cliente, g.getCaja());
            }
            
        } else if ( rndAccion1 < g.getTasaOcupacionMesa()){
            this.ocuparMesa(this.cliente);
        } else {
            this.estarDePaso(this.cliente);
        }
        
        
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        return "LlegadaCliente{" + "tiempo=" + this.tiempoString() + cliente + ", rndLlegada=" + nf.format(rndLlegadaCliente) + '}';
    }

    @Override
    public String getNombre() {
        return "LleCli_" + this.cliente.getNumero();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
