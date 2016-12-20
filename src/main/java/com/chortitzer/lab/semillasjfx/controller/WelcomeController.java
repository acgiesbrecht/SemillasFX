/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.SVGPath;
import javafx.scene.web.WebView;
import org.apache.poi.util.IOUtils;

/**
 * FXML Controller class
 *
 * @author adriang
 */
public class WelcomeController implements Initializable {

    @FXML
    private WebView svgView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            svgView.getEngine().load(getClass().getResource("/images/letreros.svg").toExternalForm());

        } catch (Exception ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
