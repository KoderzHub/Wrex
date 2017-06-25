/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whotui.imageHandler.chooser;

import whotui.imageHandler.imagetransformer.Transformer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Window;

/**
 *
 * @author kooldeji
 */
class ImageViewer extends VBox{
    private ArrayList<String> items;
    private boolean editable = false;
    private final Window ownerWindow;
    private SingleViewController controller;
    private String selected;
    private Point2D dim = new Point2D(330, 540);
    
    public ImageViewer(Window ownerWindow, List<String> items){
        this.ownerWindow = ownerWindow;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("singleViewFXML.fxml"));
        try {
            VBox root = loader.load();
            this.getChildren().addAll(root.getChildren());
            
        } catch (IOException ex) {
            Logger.getLogger(Transformer.class.getName()).log(Level.SEVERE, null, ex);
        }
        controller = loader.getController();
        controller.setView(this);
        this.items = new ArrayList<>();
        for (String itm: new ArrayList<>(items)){
            addItem(itm);
        }
        if (items.isEmpty()){
            controller.noItems();
        }
    }
    
    public ImageViewer(Window ownerWindow, List<String> items, Point2D dim){
        this(ownerWindow, items);
        this.dim = dim;
    }    
    public ImageViewer(Window ownerWindow, List<String> items, boolean isEditable){
        this(ownerWindow, items);
        this.editable = isEditable;
    }

    public ArrayList<String> getItems() {
        return new ArrayList(items);
    }
    
    public String getSelected(){
        return selected;
    }

    public Point2D getDim() {
        return dim;
    }

    public boolean select(String item) {
        if (getItems().contains(item)){
            selected = item;    
            controller.setSelected(item);
            return  true;
        }
        return false;
    }
    
    public boolean removeItem(String item){
        controller.removeItem(item);
        return items.remove(item);
    }
    
    public boolean addItem(String item){
        controller.addItem(item);
        return items.add(item);
    }

    public boolean isEditable() {
        return editable;
    }

    public Window getOwnerWindow() {
        return ownerWindow;
    }
    
    public void setImage(File file){
        String fileName = file.getName();
        Image image = new Image(file.toURI().toString());
        controller.setImage(image);
        int end = fileName.indexOf('.');
        if (end < 1){
            fileName = fileName.substring(0);                   
        }else{                    
            fileName = fileName.substring(0, end);
        }
        if (getItems().contains(fileName)){
            select(fileName);
        }
    }
    
    public Image getImage(){
        return controller.getImage();
    }
    
    public void addItemListener(ChangeListener<String> changeListener){
        controller.getListener().addListener(changeListener);
    }
    
}

