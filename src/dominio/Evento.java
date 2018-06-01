/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

public abstract class Evento implements Comparable<Evento> {

    protected long tiempo;
    protected Gestor g;

    protected Evento(Gestor g) {
        this.g = g;
    }

    public long getTiempo() {
        return tiempo;
    }

    protected void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public int compareTo(Evento e) {
        return (int) (this.getTiempo() - e.getTiempo());
    }

    @Override
    public abstract boolean equals(Object o);

    public abstract long calcularTiempo();
    
    public abstract void ejecutarEvento();

    protected void atenderCliente(Cliente cliente, Caja caja){
        cliente.setEstado(EstadoCliente.COMPRANDO);
        caja.setEstado(EstadoCaja.ATENDIENDO);
        
        FinCompra evento = new FinCompra(g, cliente);
        this.g.getConjuntoEventos().add(evento);
        
    }
    protected void servirCliente(Cliente cliente, EmpleadoEntrega empleado){
        cliente.setEstado(EstadoCliente.RECIBIENDO_ENTREGA);
        empleado.setEstado(EstadoEmpleadoEntrega.ATENDIENDO);
        
        FinEntregaPedido evento = new FinEntregaPedido(g, cliente, empleado);
        this.g.getConjuntoEventos().add(evento);
        
        
    }
    protected void ocuparMesa(Cliente cliente){
        cliente.setEstado(EstadoCliente.OCUPANDO_MESA);
        
        FinUtilizacionMesa evento = new FinUtilizacionMesa(g, cliente);
        this.g.getConjuntoEventos().add(evento);
    }
    
    protected void consumirPedidoEnMesa(Cliente cliente){
        cliente.setEstado(EstadoCliente.CONSUMIENDO_PEDIDO_EN_MESA);
        
        FinConsumicionPedido evento = new FinConsumicionPedido(g, cliente);
        this.g.getConjuntoEventos().add(evento);
    }
    
    protected void estarDePaso(Cliente cliente){
        cliente.setEstado(EstadoCliente.DE_PASO);
        
        FinEstarDePaso evento = new FinEstarDePaso(g,cliente);
        this.g.getConjuntoEventos().add(evento);
    }
    

    @Override
    public abstract String toString();

    public final String tiempoString(){
        
        long horas = tiempo / 3600;
        long minutos = (tiempo - horas*3600) / 60;
        long segundos2 =  tiempo - (horas*3600 + minutos*60);
        String ceroH = "", ceroM = "", ceroS = "";
        if( horas < 10 ) ceroH = "0";
        if( minutos < 10 ) ceroM = "0";
        if( segundos2 < 10 ) ceroS = "0";
        
        return ceroH + horas + ":"  + ceroM + minutos + ":" + ceroS + segundos2;
    }

    public abstract String getNombre();
}
