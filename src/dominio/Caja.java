/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import generadoresPseudoAleatorios.GeneradorBoxMuller;

/**
 *
 * @author Bruno
 */
public class Caja {
    private EstadoCaja estado;

    public Caja(EstadoCaja estado) {
        this.estado = estado;
    }

    public EstadoCaja getEstado() {
        return estado;
    }

    public void setEstado(EstadoCaja estado) {
        this.estado = estado;
    }
    
    public boolean estaLibre(){
        return (estado == EstadoCaja.LIBRE);
    }

    @Override
    public String toString() {
        return "Caja{" + "estado=" + estado + '}';
    }
    
     
}
