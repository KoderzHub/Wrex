/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whotui.imageHandler.chooser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;

/**
 *
 * @author kooldeji
 */
public class MultipleViewController implements Initializable {
    @FXML
    private Chooser view;
    private ArrayList<File> list;  
//    @FXML
//    private AnchorPane anchorPane;
    
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private FlowPane flowPane;

    @FXML
    private Button uploadBtn;
    
    @FXML
    void upload(ActionEvent event) {
            list.addAll(new FileChooser().showOpenMultipleDialog(view.getStage()));
            System.out.println(list);
            for (int i=0; i<flowPane.getChildren().size()&&i<list.size(); i++){
                ImageViewer child = (ImageViewer) flowPane.getChildren().get(i);
                System.out.println(child);
                child.setImage(list.get(i));
           }
    }   
    
    public void setView(Chooser view){
        this.view = view;
        for (String item:view.getItems()){
            System.out.println(view.getItems());
            ImageViewer imageViewer = new ImageViewer(view.getStage(), view.getItems());
            imageViewer.addItemListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    System.out.println(observable);
                    System.out.println(flowPane.getChildren());
                    for (Node child:flowPane.getChildren()){
                        if (child instanceof ImageViewer && child != imageViewer){
                            System.out.println(((ImageViewer) child).getItems());
                            ((ImageViewer) child).removeItem(newValue);
                            System.out.println(((ImageViewer) child).getItems());
                            if (oldValue != null){
                                ((ImageViewer) child).addItem(oldValue);
                            }
                        }
                    }
                }
            });
            flowPane.getChildren().add(imageViewer);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list = new ArrayList<>();
        flowPane.prefWidthProperty().bind(scrollPane.widthProperty());
    } 
    
    
    
}
