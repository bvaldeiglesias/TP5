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
public class Cafeteria {
    private Caja caja;
    private EmpleadoEntrega empleado1;
    private EmpleadoEntrega empleado2;

    public Cafeteria(Caja caja, EmpleadoEntrega empleado1, EmpleadoEntrega empleado2) {
        this.caja = caja;
        this.empleado1 = empleado1;
        this.empleado2 = empleado2;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public EmpleadoEntrega getEmpleado1() {
        return empleado1;
    }

    public void setEmpleado1(EmpleadoEntrega empleado1) {
        this.empleado1 = empleado1;
    }

    public EmpleadoEntrega getEmpleado2() {
        return empleado2;
    }

    public void setEmpleado2(EmpleadoEntrega empleado2) {
        this.empleado2 = empleado2;
    }
    
    
    
}
