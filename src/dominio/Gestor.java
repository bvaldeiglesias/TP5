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
    private long tiempoPermanencia;
    private Cola<Cliente> colaClientes;
    private int cantIteraciones;
    private Evento eventoActual;
    private TreeSet<Evento> conjuntoEventos;
    private GeneradorBoxMuller generadorLlegadaClientes;
    private GeneradorBoxMuller generadorConsumicionPedido;
    private GeneradorBoxMuller generadorUtilizacionMesa;
    private GeneradorExponencial generadorEntregaPedido;
    private Caja caja;
    private ConjuntoEmpleados empleadosEntrega; 

    public Gestor() {
        this.contadorGente = 0;
        this.cantIteraciones = 0;
        
        this.conjuntoEventos = new TreeSet<>();
        this.eventoActual = null;
    }
    
    public void simular(int cantIteraciones, double mediaLlegadaClientes, double desvStanLlegadaClientes, 
                        double tasaCompra, double tasaUtilizaMesas, double tasaOcupacionMesa, double tiempoCompraTicket,
                        double lambdaEntregaPedido, double tiempoConsumicion, double tiempoUtilizacionMesa,
                        double mediaConsumicionPedido, double desvStanConsumicionPedido,
                        double mediaUtilizacionMesa, double desvStanUtilizacionMesa,
                        int desde, int hasta){
        
        this.cantIteraciones = cantIteraciones;
        this.generadorLlegadaClientes = new GeneradorBoxMuller(desvStanLlegadaClientes, mediaLlegadaClientes);
        this.generadorConsumicionPedido = new GeneradorBoxMuller(desvStanConsumicionPedido, mediaConsumicionPedido);
        this.generadorUtilizacionMesa = new GeneradorBoxMuller(desvStanUtilizacionMesa, mediaUtilizacionMesa);
        this.generadorEntregaPedido = new GeneradorExponencial(lambdaEntregaPedido);
        
        this.empleadosEntrega = new ConjuntoEmpleados();
        EmpleadoEntrega empleado1 = new EmpleadoEntrega(1, EstadoEmpleadoEntrega.LIBRE);
        EmpleadoEntrega empleado2 = new EmpleadoEntrega(2, EstadoEmpleadoEntrega.LIBRE);
        this.empleadosEntrega.addEmpleado(empleado1);
        this.empleadosEntrega.addEmpleado(empleado2);
        
        this.caja = new Caja(EstadoCaja.LIBRE);
        
        this.colaClientes = new Cola<>();
        
        this.iniciarSimulacion();
        
        for (int i = 1; i <= this.cantIteraciones; i++) {
            this.eventoActual = this.conjuntoEventos.pollFirst();
            
            this.eventoActual.ejecutarEvento();
            if (desde <= i && i <= hasta) {
                //Mostrar en Tabla//
            }
            
            if (eventoActual instanceof LlegadaCliente){
                contadorGente++;           
            }
            

        }
        
    }
    
    public void iniciarSimulacion(){
        Parametro.getInstancia().setTiempoActual(0);
        LlegadaCliente evento = new LlegadaCliente(this);        
        this.conjuntoEventos.add(evento);
    }
}
