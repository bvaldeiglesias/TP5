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
public enum EstadoCliente {
    EN_COLA("En Cola"),
    COMPRANDO("Comprando"),
    RECIBIENDO_ENTREGA ("Recibiendo Entrega"),
    OCUPANDO_MESA("Ocupando Mesa"),
    CONSUMIENDO_PEDIDO_EN_MESA("Consumiendo Pedido en Mesa"),
    DE_PASO("De Paso");
    
    private final String name;

    private EstadoCliente(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
