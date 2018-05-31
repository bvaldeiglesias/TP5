/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Fer
 */
public class Parametro {
    private static Parametro instancia; 
    private int ultimoNumeroCliente;
    private long tiempoActual;

    private Parametro() {
        this.ultimoNumeroCliente = 0; 
        this.tiempoActual = 0;
    }

    public static Parametro getInstancia() {
        if (instancia == null){
            instancia = new Parametro();
        }
        return instancia;
    }

    public long getTiempoActual() {
        return tiempoActual;
    }

    public void setTiempoActual(long tiempoActual) {
        this.tiempoActual = tiempoActual;
    }
    
    public int generarNumeroCliente(){
        this.ultimoNumeroCliente += 1; 
        return ultimoNumeroCliente;
    }
    
    public String tiempoString(){
        
        long horas = tiempoActual / 3600;
        long minutos = (tiempoActual - horas*3600) / 60;
        long segundos2 =  tiempoActual - (horas*3600 + minutos*60);
        String ceroH = "", ceroM = "", ceroS = "";
        if( horas < 10 ) ceroH = "0";
        if( minutos < 10 ) ceroM = "0";
        if( segundos2 < 10 ) ceroS = "0";
        
        return ceroH + horas + ":"  + ceroM + minutos + ":" + ceroS + segundos2;
    }
    
    public static String tiempoString(long tiempo){
        
        long horas = tiempo / 3600;
        long minutos = (tiempo - horas*3600) / 60;
        long segundos2 =  tiempo - (horas*3600 + minutos*60);
        String ceroH = "", ceroM = "", ceroS = "";
        if( horas < 10 ) ceroH = "0";
        if( minutos < 10 ) ceroM = "0";
        if( segundos2 < 10 ) ceroS = "0";
        
        return ceroH + horas + ":"  + ceroM + minutos + ":" + ceroS + segundos2;
    }
}
