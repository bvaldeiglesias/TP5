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
public class FinEstarDePaso extends Evento{
    private Cliente cliente;
    
    public FinEstarDePaso(Gestor g, Cliente cliente) {
        super(g);
        this.cliente = cliente;
        this.tiempo = calcularTiempo() + Parametro.getInstancia().getTiempoActual();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof FinEstarDePaso) {
            FinEstarDePaso l = (FinEstarDePaso) o;
            return (tiempo == l.tiempo);
        }
        return false;
    }

    @Override
    public void ejecutarEvento() {
        Parametro.getInstancia().setTiempoActual(tiempo);
        
        g.agregarTiempoATiempoPermanencia(Parametro.getInstancia().getTiempoActual() - this.cliente.getTiempoLlegada());
    }

    @Override
    public String toString() {
        
        return "Fin Estar de paso: " + "Tiempo=" + this.tiempoString();
   }

    @Override
    public String getNombre() {
        return "Fin estar de paso";
    }

    @Override
    public long calcularTiempo() {
        return (long) (g.getTiempoDePaso());
    }
    
}
