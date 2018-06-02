/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.LinkedList;

public class Cola<T> {
    private LinkedList<T> cola; 

    public Cola() {
        cola = new LinkedList<>();
    }
    
    public LinkedList<T> getColaActual() {
        return (LinkedList<T>) cola.clone();
    }

    public boolean estaVacia(){
        return cola.isEmpty();
    }
    
    public void agregarItem(T item){
        cola.addLast(item);
    }
    
    public T avanzar(){
        return cola.removeFirst();
    }
    
    public int clientesEnCola(){
        return cola.size();
    }

    @Override
    public String toString() {
        if (cola.isEmpty()) {
            return "Cola{ -empty- }";
        }
        StringBuilder r = new StringBuilder("Cola{" + "\n          ");
        cola.forEach((t) -> {
            r.append(t.toString()).append("\n          ");
        });
        r.append("}");
        return r.toString();
    }
    
    
    
}