/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whotui.imageHandler.chooser;

import com.jfoenix.controls.JFXComboBox;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 *
 * @author kooldeji
 */
public class SingleViewController implements Initializable {
    @FXML
    private whotui.imageHandler.chooser.ImageViewer view;
    @FXML
    private ImageView imageView;
    @FXML
    private JFXComboBox<String> itemsCBox;;
    @FXML
    private VBox rootVBox;
    
    void setView(ImageViewer view){
        this.view = view;
        System.out.println(imageView);
        imageView.setFitWidth(view.getDim().getX());
        imageView.setFitHeight(view.getDim().getY());
    }
    
    void setImage(Image img){
        imageView.setImage(img);
    }
  
    void updateItems(List<String> items){
        itemsCBox.getItems().clear();
        itemsCBox.getItems().addAll(items);
    }
    
    void removeItem(String item){
        itemsCBox.getItems().remove(item);
    }
    
    void addItem(String item){
        itemsCBox.getItems().add(item);
    }
    
    void setSelected(String item){
        itemsCBox.setValue(item);
    }
    
    ObjectProperty<String> getListener(){
        return itemsCBox.valueProperty();
    }
    
    void noItems(){
        rootVBox.getChildren().remove(itemsCBox);
    }
    @FXML
    void upload(ActionEvent event) {
           File file = new FileChooser().showOpenDialog(view.getOwnerWindow());
           view.setImage(file);
    }

    @FXML
    void edit(ActionEvent event) {

    } 

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    protected Image getImage() {
        return imageView.getImage();
    }
    
    
}
