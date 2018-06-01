/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import generadoresPseudoAleatorios.*;
import java.util.Random;
import java.util.TreeSet;

/**
 *
 * @author Bruno
 */
public class Gestor {
    private int contadorGente;
    private long tiempoPermanencia;
    private Cola<Cliente> colaClientesCaja;
    private Cola<Cliente> colaClientesEntregaPedido;
    private int cantIteraciones;
    private Evento eventoActual;
    private TreeSet<Evento> conjuntoEventos;
    private GeneradorBoxMuller generadorLlegadaClientes;
    private GeneradorBoxMuller generadorConsumicionPedido;
    private GeneradorBoxMuller generadorUtilizacionMesa;
    private GeneradorExponencial generadorEntregaPedido;
    private Caja caja;
    private ConjuntoEmpleados empleadosEntrega; 
    private Random generadorAccion1; //Compra? utiliza mesa? esta de paso?
    private Random generadorAccion2; //(despues de comprar) se retira? ocupa mesa?
    
    private double tasaCompra;
    private double tasaUtilizacionMesa;
    private double tasaOcupacionMesa;
    private double tiempoCompraTicket;
    private double tiempoConsumicion;
    private double tiempoUtilizacionMesa;

    public Gestor() {
        this.contadorGente = 0;
        this.cantIteraciones = 0;

        this.conjuntoEventos = new TreeSet<>();
        this.eventoActual = null;
        this.generadorAccion1 = new Random(673);
        this.generadorAccion2 = new Random(960); 
    }
    
    public void simular(int cantIteraciones, double mediaLlegadaClientes, double desvStanLlegadaClientes, 
                        double tasaCompra, double tasaUtilizaMesas, double tasaOcupacionMesa, double tiempoCompraTicket,
                        double lambdaEntregaPedido, double tiempoConsumicion, double tiempoUtilizacionMesa,
                        double mediaConsumicionPedido, double desvStanConsumicionPedido,
                        double mediaUtilizacionMesa, double desvStanUtilizacionMesa,
                        int desde, int hasta){
        
        this.cantIteraciones = cantIteraciones;
        
        this.tasaCompra = tasaCompra;
        this.tasaUtilizacionMesa = tasaUtilizacionMesa;
        this.tasaOcupacionMesa = tasaOcupacionMesa;
        this.tiempoCompraTicket = tiempoCompraTicket;
        this.tiempoConsumicion = tiempoConsumicion;
        this.tiempoUtilizacionMesa = tiempoUtilizacionMesa;
        
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
        
        this.colaClientesCaja = new Cola<>();
        
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

    public double getTasaCompra() {
        return tasaCompra;
    }

    public void setTasaCompra(double tasaCompra) {
        this.tasaCompra = tasaCompra;
    }

    public double getTasaUtilizacionMesa() {
        return tasaUtilizacionMesa;
    }

    public void setTasaUtilizacionMesa(double tasaUtilizacionMesa) {
        this.tasaUtilizacionMesa = tasaUtilizacionMesa;
    }

    public double getTasaOcupacionMesa() {
        return tasaOcupacionMesa;
    }

    public void setTasaOcupacionMesa(double tasaOcupacionMesa) {
        this.tasaOcupacionMesa = tasaOcupacionMesa;
    }

    public double getTiempoCompraTicket() {
        return tiempoCompraTicket;
    }

    public void setTiempoCompraTicket(double tiempoCompraTicket) {
        this.tiempoCompraTicket = tiempoCompraTicket;
    }

    public double getTiempoConsumicion() {
        return tiempoConsumicion;
    }

    public void setTiempoConsumicion(double tiempoConsumicion) {
        this.tiempoConsumicion = tiempoConsumicion;
    }

    public double getTiempoUtilizacionMesa() {
        return tiempoUtilizacionMesa;
    }

    public void setTiempoUtilizacionMesa(double tiempoUtilizacionMesa) {
        this.tiempoUtilizacionMesa = tiempoUtilizacionMesa;
    }
    
    
    
    public void iniciarSimulacion(){
        Parametro.getInstancia().setTiempoActual(0);
        LlegadaCliente evento = new LlegadaCliente(this);        
        this.conjuntoEventos.add(evento);
    }

    public int getContadorGente() {
        return contadorGente;
    }

    public void setContadorGente(int contadorGente) {
        this.contadorGente = contadorGente;
    }

    public long getTiempoPermanencia() {
        return tiempoPermanencia;
    }

    public void setTiempoPermanencia(long tiempoPermanencia) {
        this.tiempoPermanencia = tiempoPermanencia;
    }

    public Cola<Cliente> getColaClientesCaja() {
        return colaClientesCaja;
    }

    public void setColaClientesCaja(Cola<Cliente> colaClientesCaja) {
        this.colaClientesCaja = colaClientesCaja;
    }

    public Cola<Cliente> getColaClientesEntregaPedido() {
        return colaClientesEntregaPedido;
    }

    public void setColaClientesEntregaPedido(Cola<Cliente> colaClientesEntregaPedido) {
        this.colaClientesEntregaPedido = colaClientesEntregaPedido;
    }

    public int getCantIteraciones() {
        return cantIteraciones;
    }

    public void setCantIteraciones(int cantIteraciones) {
        this.cantIteraciones = cantIteraciones;
    }

    public Evento getEventoActual() {
        return eventoActual;
    }

    public void setEventoActual(Evento eventoActual) {
        this.eventoActual = eventoActual;
    }

    public TreeSet<Evento> getConjuntoEventos() {
        return conjuntoEventos;
    }

    public void setConjuntoEventos(TreeSet<Evento> conjuntoEventos) {
        this.conjuntoEventos = conjuntoEventos;
    }

    public GeneradorBoxMuller getGeneradorLlegadaClientes() {
        return generadorLlegadaClientes;
    }

    public void setGeneradorLlegadaClientes(GeneradorBoxMuller generadorLlegadaClientes) {
        this.generadorLlegadaClientes = generadorLlegadaClientes;
    }

    public GeneradorBoxMuller getGeneradorConsumicionPedido() {
        return generadorConsumicionPedido;
    }

    public void setGeneradorConsumicionPedido(GeneradorBoxMuller generadorConsumicionPedido) {
        this.generadorConsumicionPedido = generadorConsumicionPedido;
    }

    public GeneradorBoxMuller getGeneradorUtilizacionMesa() {
        return generadorUtilizacionMesa;
    }

    public void setGeneradorUtilizacionMesa(GeneradorBoxMuller generadorUtilizacionMesa) {
        this.generadorUtilizacionMesa = generadorUtilizacionMesa;
    }

    public GeneradorExponencial getGeneradorEntregaPedido() {
        return generadorEntregaPedido;
    }

    public void setGeneradorEntregaPedido(GeneradorExponencial generadorEntregaPedido) {
        this.generadorEntregaPedido = generadorEntregaPedido;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public ConjuntoEmpleados getEmpleadosEntrega() {
        return empleadosEntrega;
    }

    public void setEmpleadosEntrega(ConjuntoEmpleados empleadosEntrega) {
        this.empleadosEntrega = empleadosEntrega;
    }

    public Random getGeneradorAccion1() {
        return generadorAccion1;
    }

    public void setGeneradorAccion1(Random generadorAccion1) {
        this.generadorAccion1 = generadorAccion1;
    }

    public Random getGeneradorAccion2() {
        return generadorAccion2;
    }

    public void setGeneradorAccion2(Random generadorAccion2) {
        this.generadorAccion2 = generadorAccion2;
    }
    
    
}
