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

    public FinEstarDePaso(Gestor g) {
        super(g);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
