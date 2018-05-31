/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.sql.Time;

/**
 *
 * @author Bruno
 */
class Cliente {
    private EstadoCliente estado;
    private int numero;
    private long tiempoLlegada;
    

    public Cliente() {
    }

    public Cliente(EstadoCliente estado, int numero, long tiempoLlegada) {
        this.estado = estado;
        this.numero = numero;
        this.tiempoLlegada = tiempoLlegada;
    }

    public EstadoCliente getEstado() {
        return estado;
    }

    public void setEstado(EstadoCliente estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(long tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }
    
    
}
