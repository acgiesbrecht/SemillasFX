/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.controller;

import com.chortitzer.lab.semillasjfx.domain.LabSemillasResultados;
import com.panemu.tiwulfx.form.Form;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author adriang
 */
public class ResultadosEditController implements Initializable {

    @FXML
    private Form<LabSemillasResultados> labSemillasResultadosForm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setLabSemillasResultados(LabSemillasResultados resultado) {
        labSemillasResultadosForm.setRecord(resultado);
    }

    public void setMode(Form.Mode mode) {
        labSemillasResultadosForm.setMode(mode);
    }

}
