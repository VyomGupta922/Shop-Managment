/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import main.connection;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class SigninController implements Initializable {

    @FXML
    private TextField USERNAME;
    @FXML
    private TextField PASSWORD;
    @FXML
    private TextField CONFIRM;
    @FXML
    private Button submit;
public Connection con=null;
public Statement stmt=null;
public ResultSet rts;
public ResultSetMetaData setmet;
public void clearcontent()
{
    USERNAME.setText("");
   PASSWORD.setText("");
    CONFIRM.setText("");
    
}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submit(MouseEvent event) {
   try {
            con=connection.ConnectDB();
            DatabaseMetaData metdata = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet resultset = metdata.getTables(null, null, "BHAI", types);
            if(resultset.next())
            {
                stmt = con.createStatement();
                rts = stmt.executeQuery("select name from bhai where name='"+USERNAME.getText()+"'");
                if(rts.next())
                {
                    JOptionPane.showMessageDialog(null, "User Name already Exists");
                    con.close();
                }
             else
                {
                    if((PASSWORD.getText()).equals(CONFIRM.getText()))
                        {
                            stmt.executeQuery("insert into bhai values ('"+USERNAME.getText()+"','"+PASSWORD.getText()+"')");
                            JOptionPane.showMessageDialog(null, "Data Stored");
                            clearcontent();
                            
                            
                            con.close();
                        }
                        else
                            {
                                JOptionPane.showMessageDialog(null, "Please check your password that is not match with confirm password");
                                con.close();
                            }
            }
            }
            else
            {
                stmt = con.createStatement();
                if((PASSWORD.getText()).equals(CONFIRM.getText()))
                {
                stmt.execute("create table bhai (name varchar(100) Not Null Primary key, password varchar(50) Not Null)");
                stmt.executeQuery("insert into bhai values ('"+USERNAME.getText()+"','"+PASSWORD.getText()+"')");
                JOptionPane.showMessageDialog(null, "Data Stored");
                clearcontent();
               
             
                con.close();
                 }
                 else
                 {
                    JOptionPane.showMessageDialog(null, "Please check your password that is not match with confirm password");
                    con.close();
                  }
            }
            }
       catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
