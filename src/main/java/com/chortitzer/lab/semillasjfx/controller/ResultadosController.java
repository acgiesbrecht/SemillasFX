/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.controller;

import com.chortitzer.lab.semillasjfx.App;
import com.chortitzer.lab.semillasjfx.DaoBase;
import com.chortitzer.lab.semillasjfx.domain.LabMuestrasSemillas;
import com.chortitzer.lab.semillasjfx.domain.LabSemillasResultados;
import com.panemu.tiwulfx.common.TableCriteria;
import com.panemu.tiwulfx.common.TableData;
import com.panemu.tiwulfx.dialog.MessageDialogBuilder;
import com.panemu.tiwulfx.form.Form;
import com.panemu.tiwulfx.table.TableControl;
import com.panemu.tiwulfx.table.TableController;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * FXML Controller class
 *
 * @author adriang
 */
public class ResultadosController implements Initializable {

    private DaoBase<LabSemillasResultados> daoLabSemillasResultados = new DaoBase<>(LabSemillasResultados.class);

    @FXML
    private TableControl<LabSemillasResultados> masterTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Button btnPrint = new Button("Imprimir");
        btnPrint.setGraphic(new ImageView(new Image(TableControl.class.getResourceAsStream("/images/print.png"))));
        btnPrint.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        masterTable.addButton(btnPrint);
        Button btnPdf = new Button("Ver como PDF");
        btnPdf.setGraphic(new ImageView(new Image(TableControl.class.getResourceAsStream("/images/pdf.png"))));
        btnPdf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        masterTable.addButton(btnPdf);

        masterTable.setController(cntlLabSemillasResultados);
        masterTable.setRecordClass(LabSemillasResultados.class);
    }

    private final TableController<LabSemillasResultados> cntlLabSemillasResultados = new TableController<LabSemillasResultados>() {

        private Stage dialogStage;// = new Stage();
        private ResultadosEditController resultadosEditController;

        @Override
        public TableData loadData(int startIndex, List<TableCriteria> filteredColumns, List<String> sortedColumns, List<TableColumn.SortType> sortingOrders, int maxResult) {
            return daoLabSemillasResultados.fetch(startIndex, filteredColumns, sortedColumns, sortingOrders, maxResult);
        }

        /*@Override
        public LabSemillasResultados preInsert(LabSemillasResultados newRecord) {
            showFacturasCompraEdit(newRecord, Form.Mode.INSERT);
            return null;
        }*/
        @Override
        public boolean canEdit(LabSemillasResultados selectedRecord) {
            if (selectedRecord == null) {
                MessageDialogBuilder.error().message("Please select a record to edit.").show(null);
                return false;
            }
            showFacturasCompraEdit(selectedRecord, Form.Mode.EDIT);
            return false;
        }

        @Override
        public void doubleClick(LabSemillasResultados record) {
            showFacturasCompraEdit(record, Form.Mode.READ);
        }

        @Override
        public void delete(List<LabSemillasResultados> records) {
            daoLabSemillasResultados.delete(records);
        }

        private void showFacturasCompraEdit(LabSemillasResultados factura, Form.Mode mode) {
            try {
                if (dialogStage == null) {

                    /**
                     * cannot instantiate dialogStage when instantiating this
                     * class because it's done in non-FX thread. It turns that
                     * instantiating stage should be in FX thread..
                     */
                    dialogStage = new Stage();
                    dialogStage.initOwner(App.mainStage);
                    dialogStage.initModality(Modality.WINDOW_MODAL);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ResultadosEdit.fxml"));

                    dialogStage.setScene(new Scene((AnchorPane) loader.load()));
                    //TiwulFXUtil.setTiwulFXStyleSheet(dialogStage.getScene());
                    resultadosEditController = loader.<ResultadosEditController>getController();
                }
                resultadosEditController.setLabSemillasResultados(factura);
                resultadosEditController.setMode(mode);
                dialogStage.show();
            } catch (Exception ex) {
                App.showException(Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage(), ex);
            }
        }
    };

    private void showPdf() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.3.121:5432/industria_lab", "postgres", "123456");
            Map parameters = new HashMap();
            parameters.put("pID", Integer.parseInt(masterTable.getSelectedItem().getIdMuestra().toString()));
            parameters.put("logo_lab", getClass().getResourceAsStream("/reports/chortilab_logo.png"));
            parameters.put("logo_cch", getClass().getResourceAsStream("/reports/logo_cch.png"));

            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/CertificadoSemillas.jrxml"));

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, conn);

            String file = System.getProperty("java.io.tmpdir") + "\\CAS-" + masterTable.getSelectedItem().getIdMuestra().toString() + ".pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, file);

            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(file);
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
