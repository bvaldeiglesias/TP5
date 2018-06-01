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
        TableColumn rndLlegada2 = new TableColumn("RND Llegada 2");
        TableColumn tiempoEntreLlegada = new TableColumn("Tiempo Entre Llegada");
        TableColumn proximaLlegada = new TableColumn("Proxima Llegada");
        TableColumn rndAccion = new TableColumn("RND Accion");
        TableColumn Accion = new TableColumn("Accion");
        TableColumn SumMinutosEstadia = new TableColumn("SUM Minutos Estadia");

//        nroExperimento.setCellValueFactory(new PropertyValueFactory<>("nroExperimento"));
//        rndRecuerdaMensaje.setCellValueFactory(new PropertyValueFactory<>("rndRecuerdaMensaje"));
//        recuerdaMensaje.setCellValueFactory(new PropertyValueFactory<>("recuerdaMensaje"));
//        rndComprarProducto.setCellValueFactory(new PropertyValueFactory<>("rndComprarProducto"));
//        comprarProducto.setCellValueFactory(new PropertyValueFactory<>("comprarProducto"));
//        acumuladorCompras.setCellValueFactory(new PropertyValueFactory<>("sumatoriaCompras"));

        //tblMontecarlo.getColumns().addAll(nroExperimento, rndRecuerdaMensaje, recuerdaMensaje, rndComprarProducto, comprarProducto, acumuladorCompras);

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

        private final SimpleStringProperty nroExperimento;
        private final SimpleStringProperty rndRecuerdaMensaje;
        private final SimpleStringProperty recuerdaMensaje;
        private final SimpleStringProperty rndComprarProducto;
        private final SimpleStringProperty comprarProducto;
        private final SimpleStringProperty sumatoriaCompras;

        private Row(String nroExperimento, String rndRecuerda, String recuerda, String rndComprar, String comprar, String sumComprar)
        {
            this.nroExperimento = new SimpleStringProperty(nroExperimento);
            this.rndRecuerdaMensaje = new SimpleStringProperty(rndRecuerda);
            this.rndComprarProducto = new SimpleStringProperty(rndComprar);
            this.recuerdaMensaje = new SimpleStringProperty(recuerda);
            this.comprarProducto = new SimpleStringProperty(comprar);
            this.sumatoriaCompras = new SimpleStringProperty(sumComprar);
        }

        public void setNroExperimento(String asd)
        {
            nroExperimento.set(asd);
        }

        public void setRndRecuerda(String asd)
        {
            rndRecuerdaMensaje.set(asd);
        }

        public void setRndComprarProducto(String asd)
        {
            rndComprarProducto.set(asd);
        }

        public void setRecuerdaMensaje(String asd)
        {
            recuerdaMensaje.set(asd);
        }

        public void setComprarProducto(String asd)
        {
            comprarProducto.set(asd);
        }

        public void setsumatoriaCompras(String asd)
        {
            sumatoriaCompras.set(asd);
        }

        public String getNroExperimento()
        {
            return nroExperimento.get();
        }

        public String getRndRecuerdaMensaje()
        {
            return rndRecuerdaMensaje.get();
        }

        public String getRecuerdaMensaje()
        {
            return recuerdaMensaje.get();
        }

        public String getRndComprarProducto()
        {
            return rndComprarProducto.get();
        }

        public String getComprarProducto()
        {
            return comprarProducto.get();
        }

        public String getSumatoriaCompras()
        {
            return sumatoriaCompras.get();
        }

    }

}
