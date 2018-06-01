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

    
    //Completar!!!
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        gestor = new Gestor(this);
        
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
        int desde = Integer.parseInt(txtDesde.getText());
        int hasta = Integer.parseInt(txtHasta.getText());
        int cantidad = Integer.parseInt(txtCantIteraciones.getText());
        int acumuladorCompras = 0;

        if (desde == 0)
        {
            desde = 1;
        }
        
        
        //corregir!!//
        gestor.simular(cantidad, acumuladorCompras, desde, hasta, cantidad,
                acumuladorCompras, acumuladorCompras, cantidad, cantidad, 
                acumuladorCompras, cantidad, acumuladorCompras, acumuladorCompras, 
                acumuladorCompras, desde, hasta, hasta);
 
    }

    public void addRow(Evento eventoActual){
        //Implementar//
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
