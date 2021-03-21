
package main;

import fxml.MENS;
import fxml.newdetail;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class maaController implements Initializable {

    @FXML
    private AnchorPane loginpane;
 @FXML
    private TextField username;
  @FXML
    private TextField password;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submit(MouseEvent event) throws IOException {
         try {
             Connection con = connection.ConnectDB();
             Statement stmt = con.createStatement();
             ResultSet rts = stmt.executeQuery("select * from bhai where name='"+username.getText()+"' and password='"+password.getText()+"'");
           if(rts.next())
           {
            JOptionPane.showMessageDialog(null, "Welcome to my Project");
            Stage mainframe;
        mainframe = new Stage();
      
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
         Scene scene = new Scene(root);
      mainframe.setResizable(false);
       mainframe.setScene(scene);
       
         mainframe.show();
            con.close();
            }
            else
            {
            JOptionPane.showMessageDialog(null, "Please check your password and use name");
            }
            }
        catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e);
        }                        
    }
                   
    @FXML
    void sign(MouseEvent event) throws IOException {
   Stage signin ;
        signin = new Stage();
      
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/signin.fxml"));
         Scene scene = new Scene(root);
       signin.setResizable(false);
       signin.setScene(scene);
         signin.show();
    }
    @FXML
    private void handleButtonAction(MouseEvent event) {
    }
    
}
