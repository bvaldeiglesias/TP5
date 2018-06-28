/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dominio.*;
import dominio.Gestor;
import dominio.LlegadaCliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Bruno
 */
public class MainFXMLController implements Initializable
{
    @FXML
    private Button btnSimular;
    @FXML
    private TextField txtDesde;
    @FXML
    private TextField txtHasta;
    @FXML
    private TextField txtPromedio;
    @FXML
    private TableView<Row> tblColas;
    @FXML
    private TextField txtCantIteraciones;
    
    private Gestor gestor;
    @FXML
    private TextField lblMediaLlegada;
    @FXML
    private TextField lblDesvEstLlegada;
    @FXML
    private TextField lblTasaCompra;
    @FXML
    private TextField LblTasaUtilizaMesa;
    @FXML
    private TextField lblTiempoCompraTicket;
    @FXML
    private TextField lblTasaOcupacionMesa;
    @FXML
    private TextField lblLambdaEntregaPedido;
    @FXML
    private TextField lblMediaUtilizacionMesa;
    @FXML
    private TextField lblDesvEstUtilizacionMesa;
    @FXML
    private TextField lblMediaConsumicionPedido;
    @FXML
    private TextField lblDesvEstConsumicionPedido;
    @FXML
    private TextField lblTiempoDePaso;
    @FXML
    private CheckBox chkEditar;

    private int contador;   
    @FXML
    private TextArea txtDatosSistema;
    
    //Completar!!!
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
        
        tblColas.setEditable(true);
        
        TableColumn iteracion = new TableColumn("N");
        TableColumn evento = new TableColumn("Evento");
        TableColumn reloj = new TableColumn("Reloj");
        TableColumn rndLlegada1 = new TableColumn("RND Llegada 1");
        TableColumn tiempoEntreLlegada = new TableColumn("Tiempo Entre Llegada");
        TableColumn proximaLlegada = new TableColumn("Proxima Llegada");
        TableColumn rndAccion = new TableColumn("RND Accion");
        TableColumn accion = new TableColumn("Accion");
        TableColumn sumMinutosEstadia = new TableColumn("SUM Minutos Estadia");
        TableColumn rndEntrega = new TableColumn("RND Entrega");
        TableColumn entrega = new TableColumn("Entrega");
        TableColumn rndAccion2 = new TableColumn("RND Accion 2");
        TableColumn accion2 = new TableColumn("Accion 2");
        TableColumn rndTConsumicion = new TableColumn("RND Tiempo fin Consumicion");
        TableColumn tiempConsumicion = new TableColumn("Tiempo Fin Consumicion");
        TableColumn rndTMesas = new TableColumn("RND T en Mesas");
        TableColumn tiempMesas = new TableColumn("T hasta fin en Mesas");
        TableColumn colaCaja = new TableColumn("Cola caja");
        TableColumn estadoCaja = new TableColumn("Estado Caja");
        TableColumn colaEntrega = new TableColumn("Cola Entrega");
        TableColumn estadoEmp1 = new TableColumn("Estado Empleado 1");
        TableColumn estadoEmp2 = new TableColumn("Estado Empleado 2");
        
        iteracion.setCellValueFactory(new PropertyValueFactory<>("iteracion"));
        evento.setCellValueFactory(new PropertyValueFactory<>("evento"));
        reloj.setCellValueFactory(new PropertyValueFactory<>("reloj"));
        rndLlegada1.setCellValueFactory(new PropertyValueFactory<>("rndLlegada"));
        tiempoEntreLlegada.setCellValueFactory(new PropertyValueFactory<>("tiempoEntreLlegada"));
        proximaLlegada.setCellValueFactory(new PropertyValueFactory<>("proximaLlegada"));
        rndAccion.setCellValueFactory(new PropertyValueFactory<>("rndAccion"));
        accion.setCellValueFactory(new PropertyValueFactory<>("accion"));
        sumMinutosEstadia.setCellValueFactory(new PropertyValueFactory<>("sumMinutosEstadia"));
        rndEntrega.setCellValueFactory(new PropertyValueFactory<>("rndEntrega"));
        entrega.setCellValueFactory(new PropertyValueFactory<>("entrega"));
        rndAccion2.setCellValueFactory(new PropertyValueFactory<>("rndAccion2"));
        accion2.setCellValueFactory(new PropertyValueFactory<>("accion2"));
        rndTConsumicion.setCellValueFactory(new PropertyValueFactory<>("rndTConsumicion"));
        tiempConsumicion.setCellValueFactory(new PropertyValueFactory<>("tiempConsumicion"));
        rndTMesas.setCellValueFactory(new PropertyValueFactory<>("rndTMesas"));
        tiempMesas.setCellValueFactory(new PropertyValueFactory<>("tiempMesas"));
         colaCaja.setCellValueFactory(new PropertyValueFactory<>("colaCaja"));
         estadoCaja.setCellValueFactory(new PropertyValueFactory<>("estadoCaja"));
         colaEntrega.setCellValueFactory(new PropertyValueFactory<>("colaEntrega"));
         estadoEmp1.setCellValueFactory(new PropertyValueFactory<>("estadoEmp1"));
         estadoEmp2.setCellValueFactory(new PropertyValueFactory<>("estadoEmp2"));
        
        
        tblColas.getColumns().addAll(iteracion, evento,reloj,rndLlegada1,tiempoEntreLlegada,proximaLlegada,
                                    rndAccion, accion, sumMinutosEstadia,rndEntrega, entrega, rndAccion2,
                                    accion2,rndTConsumicion,tiempConsumicion,rndTMesas,tiempMesas, colaCaja,
                                    estadoCaja, colaEntrega, estadoEmp1,estadoEmp2);
        
        tblColas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void handleBtnSimular(ActionEvent event)
    {
        gestor = new Gestor(this);
        tblColas.getItems().clear();
        txtPromedio.setText("-");
        txtDatosSistema.clear();
        contador = 0;
        int desde = Integer.parseInt(txtDesde.getText());
        int hasta = Integer.parseInt(txtHasta.getText());
        int cantidad = Integer.parseInt(txtCantIteraciones.getText());
        
        double mediaLlegada = Double.parseDouble(lblMediaLlegada.getText());
        double desvEstLlegada  = Double.parseDouble(lblDesvEstLlegada.getText());
        double tasaCompra = Double.parseDouble(lblTasaCompra.getText())/100;
        double tasaUtilizaMesa = Double.parseDouble(LblTasaUtilizaMesa.getText())/100;
        double tiempoCompraTicket = Double.parseDouble(lblTiempoCompraTicket.getText());
        double tasaOcupacionMesa = Double.parseDouble(lblTasaOcupacionMesa.getText())/100;
        double lambdaEntregaPedido = 1 / Double.parseDouble(lblLambdaEntregaPedido.getText());
        double mediaUtilizacionMesa = Double.parseDouble(lblMediaUtilizacionMesa.getText())*60;
        double desvEstUtilizacionMesa = Double.parseDouble(lblDesvEstUtilizacionMesa.getText())*60;
        double mediaConsumicionPedido = Double.parseDouble(lblMediaConsumicionPedido.getText())*60;
        double desvEstConsumicionPedido = Double.parseDouble(lblDesvEstConsumicionPedido.getText())*60;
        double tiempoDePaso = Double.parseDouble(lblTiempoDePaso.getText());
        
        if (desde == 0)
        {
            desde = 1;
        }
        
        gestor.simular(cantidad, mediaLlegada, desvEstLlegada, tasaCompra, tasaUtilizaMesa, tasaOcupacionMesa, 
                tiempoCompraTicket, lambdaEntregaPedido, 
                mediaConsumicionPedido, desvEstConsumicionPedido, mediaUtilizacionMesa, desvEstUtilizacionMesa, 
                tiempoDePaso, desde, hasta);
        
        
        txtPromedio.setText(this.tiempoString(gestor.getPromedio()));
        txtDatosSistema.setText(gestor.toString());
    }

    public void addRow(Evento eventoActual, Long tiempoPermanencia){
        contador++;
        String evento = "-";
        String reloj = Parametro.getInstancia().tiempoString();
        String rndLlegada = "-";
        String tiempoEntreLlegada = "-";
        String proximaLlegada = "-";
        String rndAccion = "-";
        String accion = "-";
        String sumMinutosEstadia = this.tiempoString(gestor.getTiempoPermanencia());
        String rndEntrega = "-";
        String entrega = "-";
        String rndAccion2 = "-";
        String accion2 = "-";
        String rndTConsumicion = "-";
        String tiempConsumicion = "-";
        String rndTMesas = "-";
        String tiempMesas = "-";
        String colaCaja = String.valueOf(gestor.getColaClientesCaja().clientesEnCola());
        String estadoCaja = gestor.getCaja().getEstado().getName();
        String colaEntrega = String.valueOf(gestor.getColaClientesEntregaPedido().clientesEnCola());
        String estadoEmp1 = gestor.getEmpleadosEntrega().getEmpleado1().getEstado().getName();
        String estadoEmp2 = gestor.getEmpleadosEntrega().getEmpleado2().getEstado().getName();

        if(eventoActual instanceof LlegadaCliente){
            evento = "Llegada Cliente";
            LlegadaCliente eventoAux = (LlegadaCliente)eventoActual;
            
            rndLlegada = String.valueOf(eventoAux.getRndLlegadaCliente());
            tiempoEntreLlegada=this.tiempoString((long)eventoAux.getRndLlegadaCliente());
            proximaLlegada =this.tiempoString(eventoAux.getLlegadaSiguienteCliente());
            rndAccion = String.valueOf(eventoAux.getRndAccion1());
            accion = eventoAux.getAccion1();
            
            if(eventoAux.getAccion1().equals("Ocupa Mesa")){
                String[] aux = eventoAux.getRndAndTiempoUtilizaMesa().split("-");
                rndTMesas = aux[0];
                tiempMesas = aux[1];
            }
            
        } else if (eventoActual instanceof FinCompra) {
            evento = "Fin Compra";
            FinCompra eventoAux = (FinCompra) eventoActual;

            String[] aux = eventoAux.getRndAndTiempoEntregaPedido().split("-");
            rndEntrega = aux[0];
            entrega = aux[1];

        }else if (eventoActual instanceof FinConsumicionPedido){
            evento = "Fin Consumicion Pedido";
            FinConsumicionPedido eventoAux = (FinConsumicionPedido)eventoActual;
            
        }else if (eventoActual instanceof FinUtilizacionMesa){
            evento = "Fin Utilizacion Mesa";
            FinUtilizacionMesa eventoAux = (FinUtilizacionMesa)eventoActual;
            
        }else if (eventoActual instanceof FinEntregaPedido){
            evento = "Fin Entrega Pedido";
            FinEntregaPedido eventoAux = (FinEntregaPedido) eventoActual;

            if (eventoAux.getRndAndTimeNextEntrega() != null) {
                String[] aux = eventoAux.getRndAndTimeNextEntrega().split("-");
                rndEntrega = aux[0];
                entrega = aux[1];
            }
            
            
            rndAccion2 = String.valueOf(eventoAux.getRndAccion2());
            accion2 = eventoAux.getAccion2();
            
            if(accion2.equals("Utiliza Mesa")){
                String[] aux = eventoAux.getRndAndTiempoConsumicion().split("-");
                rndTConsumicion = aux[0];
                tiempConsumicion = aux[1];
            }
            
        }else if (eventoActual instanceof FinEstarDePaso){
            evento = "Fin Estar De Paso";
            FinEstarDePaso eventoAux = (FinEstarDePaso)eventoActual;
            
        }
        
        Row r = new Row(String.valueOf(contador), evento, reloj, rndLlegada, tiempoEntreLlegada, proximaLlegada, rndAccion, accion, sumMinutosEstadia, rndEntrega, entrega, rndAccion2, accion2, rndTConsumicion, tiempConsumicion, rndTMesas, tiempMesas, colaCaja,
                                    estadoCaja, colaEntrega, estadoEmp1,estadoEmp2);
        tblColas.getItems().add(r);
    }

    @FXML
    private void handleChkEditar(ActionEvent event) {
        lblMediaLlegada.setDisable(!chkEditar.isSelected());
        lblDesvEstLlegada.setDisable(!chkEditar.isSelected());
        lblTasaCompra.setDisable(!chkEditar.isSelected());
        LblTasaUtilizaMesa.setDisable(!chkEditar.isSelected());
        lblTiempoCompraTicket.setDisable(!chkEditar.isSelected());
        lblTasaOcupacionMesa.setDisable(!chkEditar.isSelected());
        lblLambdaEntregaPedido.setDisable(!chkEditar.isSelected());
        lblMediaUtilizacionMesa.setDisable(!chkEditar.isSelected());
        lblDesvEstUtilizacionMesa.setDisable(!chkEditar.isSelected());
        lblMediaConsumicionPedido.setDisable(!chkEditar.isSelected());
        lblDesvEstConsumicionPedido.setDisable(!chkEditar.isSelected());
        lblTiempoDePaso.setDisable(!chkEditar.isSelected());
        
        lblMediaLlegada.setText("10");
        lblDesvEstLlegada.setText("2");
        lblTasaCompra.setText("30");
        LblTasaUtilizaMesa.setText("20");
        lblTiempoCompraTicket.setText("20");
        lblTasaOcupacionMesa.setText("50");
        lblLambdaEntregaPedido.setText("50");
        lblMediaUtilizacionMesa.setText("5");
        lblDesvEstUtilizacionMesa.setText("1");
        lblMediaConsumicionPedido.setText("15");
        lblDesvEstConsumicionPedido.setText("5");
        lblTiempoDePaso.setText("1");
    }

    public final String tiempoString(long tiempo){
        
        long horas = tiempo / 3600;
        long minutos = (tiempo - horas*3600) / 60;
        long segundos2 =  tiempo - (horas*3600 + minutos*60);
        String ceroH = "", ceroM = "", ceroS = "";
        if( horas < 10 ) ceroH = "0";
        if( minutos < 10 ) ceroM = "0";
        if( segundos2 < 10 ) ceroS = "0";
        
        return ceroH + horas + ":"  + ceroM + minutos + ":" + ceroS + segundos2;
    }
    
    public static class Row
    {
        private final SimpleStringProperty iteracion;
        private final SimpleStringProperty evento;
        private final SimpleStringProperty reloj;
        private final SimpleStringProperty rndLlegada;
        private final SimpleStringProperty tiempoEntreLlegada;
        private final SimpleStringProperty proximaLlegada;
        private final SimpleStringProperty rndAccion;
        private final SimpleStringProperty accion;
        private final SimpleStringProperty sumMinutosEstadia;
        private final SimpleStringProperty rndEntrega;
        private final SimpleStringProperty entrega;
        private final SimpleStringProperty rndAccion2;
        private final SimpleStringProperty accion2;
        private final SimpleStringProperty rndTConsumicion;
        private final SimpleStringProperty tiempConsumicion;
        private final SimpleStringProperty rndTMesas;
        private final SimpleStringProperty tiempMesas;
        private final SimpleStringProperty colaCaja;
        private final SimpleStringProperty estadoCaja;
        private final SimpleStringProperty colaEntrega; 
        private final SimpleStringProperty estadoEmp1;
        private final SimpleStringProperty estadoEmp2;


        private Row(String iteracion, String evento, String reloj, String rndLlegada, String tiempoEntreLlegada, String proximaLlegada, String rndAccion,
                     String accion, String sumMinutosEstadia, String rndEntrega, String entrega, String rndAccion2, String accion2,
                     String rndTConsumicion, String tiempConsumicion, String rndTMesas,String tiempMesas,String colaCaja,
                                    String estadoCaja, String colaEntrega, String estadoEmp1,String estadoEmp2)
        {
            this.iteracion = new SimpleStringProperty(iteracion);
            this.evento = new SimpleStringProperty(evento);
            this.reloj = new SimpleStringProperty(reloj);
            this.rndLlegada = new SimpleStringProperty(rndLlegada);
            this.tiempoEntreLlegada = new SimpleStringProperty(tiempoEntreLlegada);
            this.proximaLlegada = new SimpleStringProperty(proximaLlegada);
            this.rndAccion = new SimpleStringProperty(rndAccion);
            this.accion = new SimpleStringProperty(accion);
            this.sumMinutosEstadia = new SimpleStringProperty(sumMinutosEstadia);
            this.rndEntrega = new SimpleStringProperty(rndEntrega);
            this.entrega = new SimpleStringProperty(entrega);
            this.rndAccion2 = new SimpleStringProperty(rndAccion2);
            this.accion2 = new SimpleStringProperty(accion2);
            this.rndTConsumicion = new SimpleStringProperty(rndTConsumicion);
            this.tiempConsumicion = new SimpleStringProperty(tiempConsumicion);
            this.rndTMesas = new SimpleStringProperty(rndTMesas);
            this.tiempMesas = new SimpleStringProperty(tiempMesas);
            this.colaCaja = new SimpleStringProperty(colaCaja);
            this.estadoCaja = new SimpleStringProperty(estadoCaja);
            this.colaEntrega = new SimpleStringProperty(colaEntrega);
            this.estadoEmp1 = new SimpleStringProperty(estadoEmp1);
            this.estadoEmp2 = new SimpleStringProperty(estadoEmp2);

        }

        public String getIteracion() {
            return iteracion.get();
        }
        
        public String getEvento() {
            return evento.get();
        }

        public String getReloj() {
            return reloj.get();
        }

        public String getRndLlegada() {
            return rndLlegada.get();
        }

        public String getTiempoEntreLlegada() {
            return tiempoEntreLlegada.get();
        }

        public String getProximaLlegada() {
            return proximaLlegada.get();
        }

        public String getRndAccion() {
            return rndAccion.get();
        }

        public String getAccion() {
            return accion.get();
        }

        public String getSumMinutosEstadia() {
            return sumMinutosEstadia.get();
        }

        public String getRndEntrega() {
            return rndEntrega.get();
        }

        public String getEntrega() {
            return entrega.get();
        }

        public String getRndAccion2() {
            return rndAccion2.get();
        }

        public String getAccion2() {
            return accion2.get();
        }

        public String getRndTConsumicion() {
            return rndTConsumicion.get();
        }

        public String getTiempConsumicion() {
            return tiempConsumicion.get();
        }

        public String getRndTMesas() {
            return rndTMesas.get();
        }

        public String getTiempMesas() {
            return tiempMesas.get();
        }
        
        public String getColaCaja() {
            return colaCaja.get();
        }
        public String getEstadoCaja() {
            return estadoCaja.get();
        }
        public String getColaEntrega() {
            return colaEntrega.get();
        }
        public String getEstadoEmp1() {
            return estadoEmp1.get();
        }
        public String getEstadoEmp2() {
            return estadoEmp2.get();
        }
    }

}
