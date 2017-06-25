/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whotui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

/**
 *
 * @author kooldeji
 */
public class FXMLDocumentController implements Initializable {
    private WhotUI view;
    
    public void setView(WhotUI view){
        this.view = view;
    }
    @FXML
    void upload(ActionEvent event) {
           List<File> list = new FileChooser().showOpenMultipleDialog(view.getStage());
           System.out.println(list);
        try {
            Desktop.getDesktop().open(list.get(0));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
