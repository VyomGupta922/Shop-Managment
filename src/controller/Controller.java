
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Controller implements Initializable {

    @FXML
    private AnchorPane mainpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void garments(MouseEvent event) throws IOException {
          Stage garments;
        garments = new Stage();
      
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/Garments.fxml"));
         Scene scene = new Scene(root);
      garments.setResizable(false);
       garments.setScene(scene);
         garments.show();
    }
      @FXML
    private void footwear(MouseEvent event) throws IOException {
        Stage footwear;
        footwear = new Stage();
      
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/Footwear.fxml"));
         Scene scene = new Scene(root);
      footwear.setResizable(false);
       footwear.setScene(scene);
         footwear.show();
    }
}
