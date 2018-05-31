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
    private Time ticket;
    private double rndEntrega;
    private Time entrega;
    private double rndEstadia;
    private boolean seQueda;
    private double rndTiempoConsumicion;
    private Time tiempoConsumicion;
    private double rndTiempoMesa;
    private Time tiempoMesa;

    public Cliente() {
    }

    public Time getTicket() {
        return ticket;
    }

    public void setTicket(Time ticket) {
        this.ticket = ticket;
    }

    public double getRndEntrega() {
        return rndEntrega;
    }

    public void setRndEntrega(double rndEntrega) {
        this.rndEntrega = rndEntrega;
    }

    public Time getEntrega() {
        return entrega;
    }

    public void setEntrega(Time entrega) {
        this.entrega = entrega;
    }

    public double getRndEstadia() {
        return rndEstadia;
    }

    public void setRndEstadia(double rndEstadia) {
        this.rndEstadia = rndEstadia;
    }

    public boolean isSeQueda() {
        return seQueda;
    }

    public void setSeQueda(boolean seQueda) {
        this.seQueda = seQueda;
    }

    public double getRndTiempoConsumicion() {
        return rndTiempoConsumicion;
    }

    public void setRndTiempoConsumicion(double rndTiempoConsumicion) {
        this.rndTiempoConsumicion = rndTiempoConsumicion;
    }

    public Time getTiempoConsumicion() {
        return tiempoConsumicion;
    }

    public void setTiempoConsumicion(Time tiempoConsumicion) {
        this.tiempoConsumicion = tiempoConsumicion;
    }

    public double getRndTiempoMesa() {
        return rndTiempoMesa;
    }

    public void setRndTiempoMesa(double rndTiempoMesa) {
        this.rndTiempoMesa = rndTiempoMesa;
    }

    public Time getTiempoMesa() {
        return tiempoMesa;
    }

    public void setTiempoMesa(Time tiempoMesa) {
        this.tiempoMesa = tiempoMesa;
    }
    
    
    
}
