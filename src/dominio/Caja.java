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
    private GeneradorBoxMuller rndTiempoAtender;

    public Caja(EstadoCaja estado, GeneradorBoxMuller rndTiempoAtender) {
        this.estado = estado;
        this.rndTiempoAtender = rndTiempoAtender;
    }
    
    
}
