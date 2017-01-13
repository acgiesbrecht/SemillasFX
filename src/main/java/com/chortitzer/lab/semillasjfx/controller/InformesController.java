/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.controller;

import com.chortitzer.lab.semillasjfx.utils.Utils;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author adriang
 */
public class InformesController implements Initializable {

    @FXML
    private RadioButton rbMensual;
    @FXML
    private ToggleGroup informes;
    @FXML
    private RadioButton rbAnual;
    @FXML
    private ComboBox<Integer> cboMes;
    @FXML
    private Spinner<Integer> spAno;
    @FXML
    private Button cmdView;
    @FXML
    private Label lblMes;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboMes.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        cboMes.getSelectionModel().select(LocalDate.now().getMonthValue() - 1);
        spAno.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(2010, LocalDate.now().getYear(), LocalDate.now().getYear()));
        cboMes.visibleProperty().bind(rbMensual.selectedProperty());
        lblMes.visibleProperty().bind(rbMensual.selectedProperty());
    }

    @FXML
    private void cmdView(ActionEvent event) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.3.121:5432/industria_lab", "postgres", "123456");
            Map parameters = new HashMap();
            parameters.put("pAno", spAno.getValue());
            parameters.put("pMes", cboMes.getValue());
            parameters.put("gobierno_nacional", getClass().getResourceAsStream("/reports/gobierno_nacional.jpg"));
            parameters.put("senave_logo", getClass().getResourceAsStream("/reports/senave_logo.jpg"));

            JasperReport report;
            if (rbMensual.isSelected()) {
                report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/InformeMensualSemillas.jrxml"));
            } else {
                report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/InformeAnualSemillas.jrxml"));
            }

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, conn);
            JasperViewer jReportsViewer = new JasperViewer(jasperPrint, false);
            jReportsViewer.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            Utils.showException("Error", ex.getMessage(), ex);
        }
    }

}
