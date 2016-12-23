/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.controller;

import com.chortitzer.lab.semillasjfx.DaoBase;
import com.chortitzer.lab.semillasjfx.domain.LabSemillasResultados;
import com.panemu.tiwulfx.form.Form;
import com.panemu.tiwulfx.form.LocalDateControl;
import com.panemu.tiwulfx.form.NumberControl;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author adriang
 */
public class ResultadosEditController implements Initializable {

    private DaoBase<LabSemillasResultados> daoLabSemillasResultados = new DaoBase<>(LabSemillasResultados.class);

    @FXML
    private Form<LabSemillasResultados> labSemillasResultadosForm;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnSave;
    @FXML
    private NumberControl<Integer> idMuestra;
    @FXML
    private LocalDateControl fechaAnalisis;
    @FXML
    private NumberControl<BigDecimal> semillasPuras;
    @FXML
    private NumberControl<BigDecimal> materiaInerteValor1;

    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSave.setOnAction(eventHandler);
        btnEdit.setOnAction(eventHandler);

        btnSave.disableProperty()
                .bind(labSemillasResultadosForm.modeProperty().isEqualTo(Form.Mode.READ));
        btnEdit.disableProperty()
                .bind(labSemillasResultadosForm.modeProperty().isNotEqualTo(Form.Mode.READ));

        labSemillasResultadosForm.bindChildren();
    }

    private EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
            if (t.getSource() == btnSave && labSemillasResultadosForm.validate()) {
                LabSemillasResultados p = labSemillasResultadosForm.getRecord();
                if (p.getIdMuestra() != null) {
                    p = daoLabSemillasResultados.update(p);
                }
                labSemillasResultadosForm.setRecord(p);
                labSemillasResultadosForm.setMode(Form.Mode.READ);
            } else if (t.getSource() == btnEdit) {
                labSemillasResultadosForm.setMode(Form.Mode.EDIT);
            }
        }
    };

    public void setLabSemillasResultados(LabSemillasResultados resultado) {
        labSemillasResultadosForm.setRecord(resultado);
    }

    public void setMode(Form.Mode mode) {
        labSemillasResultadosForm.setMode(mode);
    }

}
