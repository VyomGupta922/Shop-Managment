/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fxml.Kids;
import fxml.Ladies;
import fxml.MENS;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class GarmentsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mens(MouseEvent event) throws IOException {
        new MENS().setVisible(true);
    }

    @FXML
    private void kids(MouseEvent event) throws IOException {
       new Kids().setVisible(true);
    }

    @FXML
    private void ladies(MouseEvent event) throws IOException {
      new Ladies().setVisible(true);
    }
    
}
