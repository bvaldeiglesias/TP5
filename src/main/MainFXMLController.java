/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dominio.Evento;
import dominio.Gestor;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    
    //Completar!!!
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
        
        tblColas.setEditable(true);

        TableColumn evento = new TableColumn("Evento");
        TableColumn reloj = new TableColumn("Reloj");
        TableColumn rndLlegada1 = new TableColumn("RND Llegada 1");
        //TableColumn rndLlegada2 = new TableColumn("RND Llegada 2");
        TableColumn tiempoEntreLlegada = new TableColumn("Tiempo Entre Llegada");
        TableColumn proximaLlegada = new TableColumn("Proxima Llegada");
        TableColumn rndAccion = new TableColumn("RND Accion");
        TableColumn accion = new TableColumn("Accion");
        TableColumn sumMinutosEstadia = new TableColumn("SUM Minutos Estadia");
        //TableColumn ticket = new TableColumn("Ticket");
        TableColumn rndEntrega = new TableColumn("RND Entrega");
        TableColumn entrega = new TableColumn("Entrega");
        TableColumn rndAccion2 = new TableColumn("RND Accion 2");
        TableColumn accion2 = new TableColumn("Accion 2");
        TableColumn rndTConsumicion = new TableColumn("RND Tiempo Consumicion");
        TableColumn tConsumicion = new TableColumn("Tiempo Consumicion");
        TableColumn consumicion = new TableColumn("Consumicion");
        TableColumn rndTMesas = new TableColumn("RND T de Mesas");
        TableColumn tMesas = new TableColumn("T de Mesas");
        TableColumn utilizacionMesas = new TableColumn("Utilizacion Mesas");
        
        evento.setCellValueFactory(new PropertyValueFactory<>("evento"));
        reloj.setCellValueFactory(new PropertyValueFactory<>("reloj"));
        rndLlegada1.setCellValueFactory(new PropertyValueFactory<>("rndLlegada1"));
        //rndLlegada2.setCellValueFactory(new PropertyValueFactory<>("rndLlegada2"));
        tiempoEntreLlegada.setCellValueFactory(new PropertyValueFactory<>("tiempoEntreLlegada"));
        proximaLlegada.setCellValueFactory(new PropertyValueFactory<>("proximaLlegada"));
        rndAccion.setCellValueFactory(new PropertyValueFactory<>("rndAccion"));
        accion.setCellValueFactory(new PropertyValueFactory<>("accion"));
        sumMinutosEstadia.setCellValueFactory(new PropertyValueFactory<>("sumMinutosEstadia"));
        //ticket.setCellValueFactory(new PropertyValueFactory<>("ticket"));
        rndEntrega.setCellValueFactory(new PropertyValueFactory<>("rndEntrega"));
        entrega.setCellValueFactory(new PropertyValueFactory<>("entrega"));
        rndAccion2.setCellValueFactory(new PropertyValueFactory<>("rndAccion2"));
        accion2.setCellValueFactory(new PropertyValueFactory<>("accion2"));
        rndTConsumicion.setCellValueFactory(new PropertyValueFactory<>("rndTConsumicion"));
        tConsumicion.setCellValueFactory(new PropertyValueFactory<>("tConsumicion"));
        consumicion.setCellValueFactory(new PropertyValueFactory<>("consumicion"));
        rndTMesas.setCellValueFactory(new PropertyValueFactory<>("rndTMesas"));
        tMesas.setCellValueFactory(new PropertyValueFactory<>("tMesas"));
        utilizacionMesas.setCellValueFactory(new PropertyValueFactory<>("utilizacionMesas"));
        
        tblColas.getColumns().addAll(evento,reloj,rndLlegada1,tiempoEntreLlegada,proximaLlegada,
                                    rndAccion, accion, sumMinutosEstadia,rndEntrega, entrega, rndAccion2,
                                    accion2,rndTConsumicion,tConsumicion,consumicion,rndTMesas,tMesas,utilizacionMesas);
        
        tblColas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void handleBtnSimular(ActionEvent event)
    {
        gestor = new Gestor(this);
        
        int desde = Integer.parseInt(txtDesde.getText());
        int hasta = Integer.parseInt(txtHasta.getText());
        int cantidad = Integer.parseInt(txtCantIteraciones.getText());
        
        double mediaLlegada = Double.parseDouble(lblMediaLlegada.getText())*60;
        double desvEstLlegada  = Double.parseDouble(lblDesvEstLlegada.getText())*60;
        double tasaCompra = Double.parseDouble(lblTasaCompra.getText())/100;
        double tasaUtilizaMesa = Double.parseDouble(LblTasaUtilizaMesa.getText())/100;
        double tiempoCompraTicket = Double.parseDouble(lblTiempoCompraTicket.getText());
        double tasaOcupacionMesa = Double.parseDouble(lblTasaOcupacionMesa.getText())/100;
        double lambdaEntregaPedido = Double.parseDouble(lblLambdaEntregaPedido.getText());
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
                tiempoCompraTicket, lambdaEntregaPedido, 1, 1, 
                mediaConsumicionPedido, desvEstConsumicionPedido, mediaUtilizacionMesa, desvEstUtilizacionMesa, 
                tiempoDePaso, desde, hasta);
        
        
        txtPromedio.setText(String.valueOf(gestor.getPromedio()));
    }

    public void addRow(Evento eventoActual){
        //Implementar//
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

    
    //poner las columnas necesarias!!!
    public static class Row
    {

        private final SimpleStringProperty evento;
        private final SimpleStringProperty reloj;
        private final SimpleStringProperty rndLlegada;
        private final SimpleStringProperty tiempoEntreLlegada;
        private final SimpleStringProperty proximaLlegada;
        private final SimpleStringProperty rndAccion;
        private final SimpleStringProperty accion;
        private final SimpleStringProperty SumMinutosEstadia;
        private final SimpleStringProperty rndEntrega;
        private final SimpleStringProperty entrega;
        private final SimpleStringProperty rndAccion2;
        private final SimpleStringProperty accion2;
        private final SimpleStringProperty rndTConsumicion;
        private final SimpleStringProperty tConsumicion;
        private final SimpleStringProperty consumicion;
        private final SimpleStringProperty rndTMesas;
        private final SimpleStringProperty tMesas;
        private final SimpleStringProperty utilizacionMesas;

        private Row(String evento, String reloj, String rndLlegada, String tiempoEntreLlegada, String proximaLlegada, String rndAccion,
                     String accion, String SumMinutosEstadia, String rndEntrega, String entrega, String rndAccion2, String accion2,
                     String rndTConsumicion, String tConsumicion, String consumicion, String rndTMesas,String tMesas,String utilizacionMesas)
        {
            this.evento = new SimpleStringProperty(evento);
            this.reloj = new SimpleStringProperty(reloj);
            this.rndLlegada = new SimpleStringProperty(rndLlegada);
            this.tiempoEntreLlegada = new SimpleStringProperty(tiempoEntreLlegada);
            this.proximaLlegada = new SimpleStringProperty(proximaLlegada);
            this.rndAccion = new SimpleStringProperty(rndAccion);
            this.accion = new SimpleStringProperty(accion);
            this.SumMinutosEstadia = new SimpleStringProperty(SumMinutosEstadia);
            this.rndEntrega = new SimpleStringProperty(rndEntrega);
            this.entrega = new SimpleStringProperty(entrega);
            this.rndAccion2 = new SimpleStringProperty(rndAccion2);
            this.accion2 = new SimpleStringProperty(accion2);
            this.rndTConsumicion = new SimpleStringProperty(rndTConsumicion);
            this.tConsumicion = new SimpleStringProperty(tConsumicion);
            this.consumicion = new SimpleStringProperty(consumicion);
            this.rndTMesas = new SimpleStringProperty(rndTMesas);
            this.tMesas = new SimpleStringProperty(tMesas);
            this.utilizacionMesas = new SimpleStringProperty(utilizacionMesas);
        }

//        public void setNroExperimento(String asd)
//        {
//            nroExperimento.set(asd);
//        }

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
            return SumMinutosEstadia.get();
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

        public String gettConsumicion() {
            return tConsumicion.get();
        }

        public String getConsumicion() {
            return consumicion.get();
        }

        public String getRndTMesas() {
            return rndTMesas.get();
        }

        public String gettMesas() {
            return tMesas.get();
        }

        public String getUtilizacionMesas() {
            return utilizacionMesas.get();
        }

    }

}
