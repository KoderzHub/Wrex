/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whotui.imageHandler.chooser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author kooldeji
 */
public class Chooser {
    private Parent root;
    private final MultipleViewController controller;
    private final List<String> items;
    private final String title;
    private final Point2D dim;
    
    public Chooser(Stage stage, List<String> items, String title, Point2D dim){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("multipleViewFXML.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(Chooser.class.getName()).log(Level.SEVERE, null, ex);
        }
        controller = loader.getController();
        this.items = items;
        this.title = title;
        this.dim = dim;
        controller.setView(this);
    }

    public Parent getRoot() {
        return root;
    }

    public List<String> getItems() {
        return items;
    }

    public Point2D getDim() {
        return dim;
    }

    public String getTitle() {
        return title;
    }
    
    
    Window getStage() {
        return new Stage();
    }
 
}

