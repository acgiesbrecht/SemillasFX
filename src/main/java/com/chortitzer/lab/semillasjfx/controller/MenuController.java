/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.controller;

import com.chortitzer.lab.semillasjfx.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author adriang
 */
public class MenuController implements Initializable {

    @FXML
    private MenuItem mnuMuestras;
    @FXML
    private MenuItem mnuResultados;
    @FXML
    private MenuItem mnuClientes;
    @FXML
    private MenuItem mnuCategorias;
    @FXML
    private MenuItem mnuEspecies;
    @FXML
    private MenuItem mnuInformes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void mnuMuestras(ActionEvent event) {
        setPane("/fxml/Muestras.fxml");
    }

    @FXML
    private void mnuResultados(ActionEvent event) {
        setPane("/fxml/Resultados.fxml");
    }

    @FXML
    private void mnuClientes(ActionEvent event) {
        setPane("/fxml/Clientes.fxml");
    }

    @FXML
    private void mnuCategorias(ActionEvent event) {
        setPane("/fxml/Categorias.fxml");
    }

    @FXML
    private void mnuEspecies(ActionEvent event) {
        setPane("/fxml/Especies.fxml");
    }

    @FXML
    private void mnuInformes(ActionEvent event) {
        setPane("/fxml/Informes.fxml");
    }

    private void setPane(String paneUrl) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(paneUrl));
            App.getRoot().setCenter(pane);
        } catch (Exception ex) {
            App.showException(Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage(), ex);
        }
    }

}
