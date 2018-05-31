/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import generadoresPseudoAleatorios.*;
import java.util.TreeSet;

/**
 *
 * @author Bruno
 */
public class Gestor {
    private int contadorGente;
    private Cola<Cliente> clientes;
    private int cantIteraciones;
    private Evento eventoActual;
    private TreeSet<Evento> conjuntoEventos;
    private GeneradorBoxMuller generadorDistNormal;
    private GeneradorExponencial generadorExponencial;

    public Gestor() {
        this.contadorGente = 0;
        this.cantIteraciones = 0;
        
        this.conjuntoEventos = new TreeSet<>();
        this.eventoActual = null;
    }
    
    public void simular(int cantIteraciones, double mediaDistNorm, double desvStanDistNormal, 
                        double tasaCompra, double tasaUtilizaMesas, double tasaOcupacionMesa, double tiempoCompraTicket,
                        double lambdaExponencialNegativa, double tiempoConsumicion, double tiempoUtilizacionMesa,
                        int desde, int hasta){
        
        this.cantIteraciones = cantIteraciones;
        this.generadorDistNormal = new GeneradorBoxMuller(desvStanDistNormal, mediaDistNorm);
        this.generadorExponencial = new GeneradorExponencial(lambdaExponencialNegativa);
        
        
    }
}
