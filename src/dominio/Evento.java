/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

public abstract class Evento implements Comparable<Evento> {

    protected long tiempo;
//    protected Gestor g;

    protected Evento() {
        
    }

    public long getTiempo() {
        return tiempo;
    }

    protected void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public int compareTo(Evento e) {
        return (int) (this.getTiempo() - e.getTiempo());
    }

    @Override
    public abstract boolean equals(Object o);

    public abstract void ejecutarEvento();

//    protected void descargarCamionEnSilo(Camion camionDescargar, Silo siloCargar) {
//        int faltanteSilo = siloCargar.getFaltante();
//        int cargaCamion = camionDescargar.getCargaActual();
//        siloCargar.setEstado(EstadoSilo.CARGANDO);
//        camionDescargar.setEstado(EstadoCamion.DESCARGANDO);
//        
//        this.g.getTuboAspirador().setCamion(camionDescargar);
//        //LINEA NUEVA
//        this.g.getTuboAspirador().setEstado(EstadoTuboAspirador.OCUPADO);
//        
//        if (faltanteSilo < cargaCamion) {
//            FinLlenadoSilo evento = new FinLlenadoSilo(this.g, siloCargar, camionDescargar);
//            this.g.getConjuntoEventos().add(evento);
//        } else if (faltanteSilo == cargaCamion) {
//            FinLlenadoSilo evento1 = new FinLlenadoSilo(this.g, siloCargar, camionDescargar);
//            FinDescargaCamion evento2 = new FinDescargaCamion(this.g, siloCargar, camionDescargar);
//            this.g.getConjuntoEventos().add(evento1);
//            this.g.getConjuntoEventos().add(evento2);
//        } else {
//            FinDescargaCamion evento = new FinDescargaCamion(this.g, siloCargar, camionDescargar);
//            this.g.getConjuntoEventos().add(evento);
//        }
//    }

    @Override
    public abstract String toString();

    public final String tiempoString(){
        
        long horas = tiempo / 3600;
        long minutos = (tiempo - horas*3600) / 60;
        long segundos2 =  tiempo - (horas*3600 + minutos*60);
        String ceroH = "", ceroM = "", ceroS = "";
        if( horas < 10 ) ceroH = "0";
        if( minutos < 10 ) ceroM = "0";
        if( segundos2 < 10 ) ceroS = "0";
        
        return ceroH + horas + ":"  + ceroM + minutos + ":" + ceroS + segundos2;
    }

    public abstract String getNombre();
}
