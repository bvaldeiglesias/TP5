/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Bruno
 */
public class EmpleadoEntrega {
    private int numero;
    private EstadoEmpleadoEntrega estado;

    public EmpleadoEntrega(int numero, EstadoEmpleadoEntrega estado) {
        this.numero = numero;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EstadoEmpleadoEntrega getEstado() {
        return estado;
    }

    public void setEstado(EstadoEmpleadoEntrega estado) {
        this.estado = estado;
    }
    
    public boolean estaLibre(){
        return (estado == EstadoEmpleadoEntrega.LIBRE);
    }
    
}
