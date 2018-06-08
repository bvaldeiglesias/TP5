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
    private long llegadaSiguienteCliente;
    private String accion1;
    private String rndAndTiempoUtilizaMesa;
    
    private double rndLlegadaProximoCliente;
    
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof LlegadaCliente) {
            LlegadaCliente l = (LlegadaCliente) o;
            return (this.tiempo == l.tiempo && this.cliente == l.getCliente());
        }
        return false;
    }

    public LlegadaCliente(Gestor g, long tiempoLlegada) {
        super(g);
        cliente = new Cliente();
        this.cliente.setNumero(Parametro.getInstancia().generarNumeroCliente());
        
        this.rndAccion1 = g.getGeneradorAccion1().nextDouble();
        this.rndLlegadaProximoCliente = g.getGeneradorLlegadaClientes().rnd();
        
        this.tiempo = this.calcularTiempo() + Parametro.getInstancia().getTiempoActual();
        this.cliente.setTiempoLlegada(tiempoLlegada);
    }
    
    @Override
    public long calcularTiempo() {
        return (long) (rndLlegadaProximoCliente);
    }

    @Override
    public void ejecutarEvento() {
        Parametro.getInstancia().setTiempoActual(cliente.getTiempoLlegada());
        llegadaSiguienteCliente = Parametro.getInstancia().getTiempoActual() + (long) rndLlegadaProximoCliente;
        LlegadaCliente proximaLlegada = new LlegadaCliente(this.g, this.llegadaSiguienteCliente);
        while(!this.g.getConjuntoEventos().add(proximaLlegada)){
            proximaLlegada.corregir();
        }
        
        if (rndAccion1 < g.getTasaCompra()){
            accion1 = "Compra";
            if(!g.getCaja().estaLibre()){
                this.cliente.setEstado(EstadoCliente.EN_COLA);
                g.getColaClientesCaja().agregarItem(this.cliente);
            } else {
                this.atenderCliente(this.cliente, g.getCaja());
            }
            
        } else if ( rndAccion1 < (g.getTasaCompra()+g.getTasaUtilizacionMesa())){
            accion1 = "Ocupa Mesa";
            rndAndTiempoUtilizaMesa = this.ocuparMesa(this.cliente);
        } else {
            accion1 = "Esta de Paso";
            this.estarDePaso(this.cliente);
        }
        
        
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        return "\n          LlegadaCliente = {" + " Tiempo = " + this.tiempoString() +", "+ cliente.toString() + ", rndLlegada=" + nf.format(rndLlegadaProximoCliente) + "}";
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

    public double getRndAccion1() {
        return rndAccion1;
    }

    public void setRndAccion1(double rndAccion1) {
        this.rndAccion1 = rndAccion1;
    }

    public double getRndLlegadaCliente() {
        return this.rndLlegadaProximoCliente;
    }

    public void setRndLlegadaCliente(double rndLlegadaCliente) {
        this.rndLlegadaProximoCliente = rndLlegadaCliente;
    }

    public String getAccion1() {
        return accion1;
    }

    public void setAccion1(String accion1) {
        this.accion1 = accion1;
    }

    public long getLlegadaSiguienteCliente() {
        return llegadaSiguienteCliente;
    }

    public void setLlegadaSiguienteCliente(long llegadaSiguienteCliente) {
        this.llegadaSiguienteCliente = llegadaSiguienteCliente;
    }

    public double getRndLlegadaProximoCliente() {
        return rndLlegadaProximoCliente;
    }

    public void setRndLlegadaProximoCliente(double rndLlegadaProximoCliente) {
        this.rndLlegadaProximoCliente = rndLlegadaProximoCliente;
    }

    public String getRndAndTiempoUtilizaMesa() {
        return rndAndTiempoUtilizaMesa;
    }

    public void setRndAndTiempoUtilizaMesa(String rndAndTiempoUtilizaMesa) {
        this.rndAndTiempoUtilizaMesa = rndAndTiempoUtilizaMesa;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
    
}
