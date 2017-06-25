/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whotui;

import whotui.imageHandler.chooser.MultipleViewController;
import com.jfoenix.controls.JFXDecorator;
import whotui.imageHandler.chooser.Chooser;
import whotui.imageHandler.imagetransformer.Transformer;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javax.management.Query;

/**
 *
 * @author kooldeji
 */
public class WhotUI extends Application {
    Stage stage;
    private JFXDecorator whotStage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        
//        Transformer imageTransformer = new Transformer(new Image(getClass().getResourceAsStream("images/udo.jpg")), new Circle(200));
//        whotStage = new JFXDecorator(stage, imageTransformer.getRoot(),false,false,true);
//        Scene scene = new Scene(imageTransformer.getRoot(),875, 664);
//        stage.initStyle(StageStyle.UNDECORATED);
        String[] array = {"1", "2", "3", "4", "5", "8", "11", "12", "13", "14"};
        Chooser chooser = new Chooser(stage, new ArrayList(Arrays.asList(array)), "Carpet", new Point2D(330, 583));
        
  
        Scene scene = new Scene(chooser.getRoot());
        stage.setScene(scene);
        stage.show();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    Window getStage() {
        return stage;
    }
    
}
