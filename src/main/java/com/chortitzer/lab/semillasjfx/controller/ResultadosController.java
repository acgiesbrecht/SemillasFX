/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.controller;

import com.chortitzer.lab.semillasjfx.App;
import com.chortitzer.lab.semillasjfx.DaoBase;
import com.chortitzer.lab.semillasjfx.domain.LabSemillasResultados;
import com.chortitzer.lab.semillasjfx.utils.Utils;
import com.panemu.tiwulfx.common.TableCriteria;
import com.panemu.tiwulfx.common.TableData;
import com.panemu.tiwulfx.dialog.MessageDialogBuilder;
import com.panemu.tiwulfx.form.Form;
import com.panemu.tiwulfx.table.LocalDateColumn;
import com.panemu.tiwulfx.table.NumberColumn;
import com.panemu.tiwulfx.table.TableControl;
import com.panemu.tiwulfx.table.TableController;
import com.panemu.tiwulfx.table.TextColumn;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
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
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author adriang
 */
public class ResultadosController implements Initializable {

    private DaoBase<LabSemillasResultados> daoLabSemillasResultados = new DaoBase<>(LabSemillasResultados.class);
    private static final Logger LOGGER = LogManager.getLogger(LabSemillasResultados.class);

    @FXML
    private TableControl<LabSemillasResultados> masterTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            masterTable.setController(cntlLabSemillasResultados);
            masterTable.setRecordClass(LabSemillasResultados.class);

            Button btnPrint = new Button("Imprimir");
            btnPrint.setGraphic(new ImageView(new Image(TableControl.class.getResourceAsStream("/images/print.png"))));
            btnPrint.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    print();
                }
            });
            masterTable.addButton(btnPrint);
            Button btnPdf = new Button("Ver como PDF");
            btnPdf.setGraphic(new ImageView(new Image(TableControl.class.getResourceAsStream("/images/pdf.png"))));
            btnPdf.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    showPdf();
                }
            });
            masterTable.addButton(btnPdf);

            NumberColumn<LabSemillasResultados, Integer> cId = new NumberColumn<>("idMuestra", Integer.class);
            cId.setText("ID");
            cId.setEditable(false);

            LocalDateColumn<LabSemillasResultados> cFechaAnalisis = new LocalDateColumn<>("fechaAnalisis");
            cFechaAnalisis.setText("fecha de Analsis");

            NumberColumn<LabSemillasResultados, BigDecimal> cSemillasPuras = new NumberColumn<>("semillasPuras", BigDecimal.class);
            cSemillasPuras.setText("Semillas Puras");

            TextColumn<LabSemillasResultados> cMateriaInerteDescripcion1 = new TextColumn<>("materiaInerteDescripcion1");
            cMateriaInerteDescripcion1.setText("Materia Inerte Descripcion 1");
            cMateriaInerteDescripcion1.setMinWidth(150);

            NumberColumn<LabSemillasResultados, BigDecimal> cMateriaInerteValor1 = new NumberColumn<>("materiaInerteValor1", BigDecimal.class);
            cMateriaInerteValor1.setText("Materia Inerte Valor 1");
            cMateriaInerteValor1.setMinWidth(150);

            TextColumn<LabSemillasResultados> cMateriaInerteDescripcion2 = new TextColumn<>("materiaInerteDescripcion2");
            cMateriaInerteDescripcion2.setText("Materia Inerte Descripcion 2");
            cMateriaInerteDescripcion2.setMinWidth(150);

            NumberColumn<LabSemillasResultados, BigDecimal> cMateriaInerteValor2 = new NumberColumn<>("materiaInerteValor2", BigDecimal.class);
            cMateriaInerteValor2.setText("Materia Inerte Valor 2");
            cMateriaInerteValor2.setMinWidth(150);

            TextColumn<LabSemillasResultados> cMateriaInerteDescripcion3 = new TextColumn<>("materiaInerteDescripcion3");
            cMateriaInerteDescripcion3.setText("Materia Inerte Descripcion 3");
            cMateriaInerteDescripcion3.setMinWidth(150);

            NumberColumn<LabSemillasResultados, BigDecimal> cMateriaInerteValor3 = new NumberColumn<>("materiaInerteValor3", BigDecimal.class);
            cMateriaInerteValor3.setText("Materia Inerte Valor 3");
            cMateriaInerteValor3.setMinWidth(150);

            TextColumn<LabSemillasResultados> cMateriaInerteDescripcion4 = new TextColumn<>("materiaInerteDescripcion4");
            cMateriaInerteDescripcion4.setText("Materia Inerte Descripcion 4");
            cMateriaInerteDescripcion4.setMinWidth(150);

            NumberColumn<LabSemillasResultados, BigDecimal> cMateriaInerteValor4 = new NumberColumn<>("materiaInerteValor4", BigDecimal.class);
            cMateriaInerteValor4.setText("Materia Inerte Valor 4");
            cMateriaInerteValor4.setMinWidth(150);

            masterTable.addColumn(cId, cFechaAnalisis, cSemillasPuras,
                    cMateriaInerteDescripcion1, cMateriaInerteValor1,
                    cMateriaInerteDescripcion2, cMateriaInerteValor2,
                    cMateriaInerteDescripcion3, cMateriaInerteValor3,
                    cMateriaInerteDescripcion4, cMateriaInerteValor4);

            masterTable.setVisibleComponents(false, TableControl.Component.BUTTON_DELETE);
            masterTable.setVisibleComponents(false, TableControl.Component.BUTTON_INSERT);
            masterTable.setVisibleComponents(false, TableControl.Component.BUTTON_EXPORT);

            masterTable.reload();
        } catch (Exception ex) {
            Utils.showException(ex.toString(), ex.getMessage(), ex);
        }
    }

    private final TableController<LabSemillasResultados> cntlLabSemillasResultados = new TableController<LabSemillasResultados>() {

        private Stage dialogStage;// = new Stage();
        private ResultadosEditController resultadosEditController;

        @Override
        public TableData loadData(int startIndex, List<TableCriteria> filteredColumns, List<String> sortedColumns, List<TableColumn.SortType> sortingOrders, int maxResult) {
            try {
                return daoLabSemillasResultados.fetch(startIndex, filteredColumns, sortedColumns, sortingOrders, maxResult);
            } catch (Exception ex) {
                Utils.showException(ex.toString(), ex.getMessage(), ex);
                return null;
            }
        }

        @Override
        public LabSemillasResultados preInsert(LabSemillasResultados newRecord) {
            try {
                MessageDialogBuilder.info().message("No se pueden agregar resultados. Se asignan automaticamente a la muestra.").show(null);
            } catch (Exception ex) {
                Utils.showException(ex.toString(), ex.getMessage(), ex);
                return null;
            }
            return null;
        }

        @Override
        public boolean canEdit(LabSemillasResultados selectedRecord) {
            try {
                if (selectedRecord == null) {
                    MessageDialogBuilder.error().message("Debe seleccionar un registro para editrlo.").show(null);
                    return false;
                }
                showLabSemillasResultados(selectedRecord, Form.Mode.EDIT);
            } catch (Exception ex) {
                Utils.showException(ex.toString(), ex.getMessage(), ex);
            }
            return false;
        }

        @Override
        public void doubleClick(LabSemillasResultados record) {
            try {
                showLabSemillasResultados(record, Form.Mode.READ);
            } catch (Exception ex) {
                Utils.showException(ex.toString(), ex.getMessage(), ex);
            }
        }

        @Override
        public void delete(List<LabSemillasResultados> records) {
            //MessageDialogBuilder.info().message("No se pueden eliminar resultados. Se eliminan automaticamente al eliminar la muestra.").show(null);
        }

        private void showLabSemillasResultados(LabSemillasResultados factura, Form.Mode mode) {
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
                Utils.showException(ex.toString(), ex.getMessage(), ex);
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
                    Utils.showException(ex.toString(), ex.getMessage(), ex);
                }
            }
        } catch (Exception ex) {
            Utils.showException(ex.toString(), ex.getMessage(), ex);
        }
    }

    private void print() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.3.121:5432/industria_lab", "postgres", "123456");
            Map parameters = new HashMap();
            parameters.put("pID", Integer.parseInt(masterTable.getSelectedItem().getIdMuestra().toString()));
            parameters.put("logo_lab", getClass().getResourceAsStream("/reports/chortilab_logo.png"));
            parameters.put("logo_cch", getClass().getResourceAsStream("/reports/logo_cch.png"));

            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/CertificadoSemillas.jrxml"));

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, conn);
            //JasperViewer jReportsViewer = new JasperViewer(jasperPrint, false);
            //jReportsViewer.setVisible(true);
            JasperPrintManager.printReport(jasperPrint, false);

        } catch (Exception ex) {
            Utils.showException(ex.toString(), ex.getMessage(), ex);
        }
    }

}
