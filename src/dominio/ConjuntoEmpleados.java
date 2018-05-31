/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.LinkedList;

/**
 *
 * @author Bruno
 */
public class ConjuntoEmpleados {
    private LinkedList<EmpleadoEntrega> list;

    public ConjuntoEmpleados() {
        this.list = new LinkedList<>();
    }
    
    public ConjuntoEmpleados(LinkedList<EmpleadoEntrega> list) {
        this.list = list;
    }

    public LinkedList<EmpleadoEntrega> getList() {
        return list;
    }

    public void setList(LinkedList<EmpleadoEntrega> list) {
        this.list = list;
    }
    
    public void addEmpleado(EmpleadoEntrega e){
        this.list.add(e);
    }
    
    public void removeEmpleado(EmpleadoEntrega e){
        this.list.remove(e);
    }
    
    public boolean hayEmpleadoLibre(){
        for(EmpleadoEntrega e : list){
            if(e.estaLibre()){
                return true;
            }
        }
        return false;
    }
    
    public EmpleadoEntrega getEmpleadoLibre(){
        if (this.hayEmpleadoLibre()) {
            for (EmpleadoEntrega e : list) {
                if (e.estaLibre()) {
                    return e;
                }
            }
        }
        return null;
    }
    
}