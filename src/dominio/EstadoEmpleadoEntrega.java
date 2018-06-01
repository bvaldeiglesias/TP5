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
public enum EstadoEmpleadoEntrega {
    LIBRE("Libre"),
    ATENDIENDO("Atendiendo");

    private final String name;

    private EstadoEmpleadoEntrega(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
