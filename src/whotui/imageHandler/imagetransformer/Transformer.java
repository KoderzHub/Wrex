/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whotui.imageHandler.imagetransformer;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author kooldeji
 */
public class Transformer {
    private final Image image;
    private final Theme theme;
    private static final int defaultSize = 10;
    private ImageView view;
    private FXMLDocumentController controller;
    private Shape shape;
    private Parent root;
    /**
     *
     * @param image
     * @param theme
     */
    public Transformer(Image image, Shape shape, Theme theme){
        this.image = image;
        this.theme = theme;
        if (!(shape instanceof Circle) && !(shape instanceof Rectangle)){
            throw new IllegalArgumentException("Unsopported Shape");
        }
        this.shape = shape;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(Transformer.class.getName()).log(Level.SEVERE, null, ex);
        }
        controller = loader.getController();
        controller.setView(this);
    }
    public Transformer(Image image, Shape shape){
        this(image, shape, new Theme());
    }
    
    public Transformer(Image image){
        this(image, new Circle(defaultSize), new Theme());
    }
    public Parent getRoot(){
        return root;
    }
    public ImageView getView(){
        return view;
    }
    
    public Image getImage(){
        return this.image;
    }

    public Shape getClip() {
        return shape;
    }
    
}

class CroppableImageView extends ImageView{
    boolean bounds = true;
    public CroppableImageView(Image img, Shape shp, boolean bounds){
        super(img);
        setClip(shp);
        this.bounds = bounds;
    }
    
    public CroppableImageView(Image img, boolean bounds){
        super(img);        
        this.bounds = bounds;

    }
    
    public CroppableImageView(boolean bounds){
        this.bounds = bounds;
    }
    public void setClipX(double x) {
        if (getClip() instanceof Circle){
            Circle clip = (Circle) getClip();
            clip.setCenterX(x+clip.getRadius()/2);
        }else{
            Rectangle clip = (Rectangle) getClip();
            clip.setX(x);
        }
    }

    public void setClipY(double y) {
        if (getClip() instanceof Circle){
            Circle clip = (Circle) getClip();
            clip.setCenterY(y+clip.getRadius()/2);
        }else{
            Rectangle clip = (Rectangle) getClip();
            clip.setY(y);
        }
    }

    public void setClipCenterX(double x) {
        if (getClip() instanceof Circle){
            Circle clip = (Circle) getClip();
            clip.setCenterX(x);
        }else{
            Rectangle clip = (Rectangle) getClip();
            clip.setX(x-clip.getWidth()/2);
        }
    }

    public void setClipCenterY(double y) {
        if (getClip() instanceof Circle){
            Circle clip = (Circle) getClip();
            clip.setCenterY(y);
        }else{
            Rectangle clip = (Rectangle) getClip();
            clip.setX(y-clip.getHeight()/2);
        }
    }

    public double getClipCenterX() {
        if (getClip() instanceof Circle){
            Circle clip = (Circle) getClip();
            return clip.getCenterX();
        }else{
            Rectangle clip = (Rectangle) getClip();
            return clip.getX()+clip.getWidth()/2;
        }
    }

    public double getClipCenterY() {
        if (getClip() instanceof Circle){
            Circle clip = (Circle) getClip();
            return clip.getCenterY();
        }else{
            Rectangle clip = (Rectangle) getClip();
            return clip.getY()+clip.getHeight()/2;
        }
    }
    
    
    public void setImageX(double x){
        double bounceLoc = getLayoutX();
        double clipBounceLoc = (x-getLayoutX());
        this.layoutXProperty().unbind();
        setLayoutX(x);
        setClipCenterX(getClipCenterX()-clipBounceLoc);
        Image img = getImage();
        if (img != null && bounds){
            //Circle
            if (getClip() instanceof Circle){
                Circle clip = (Circle) getClip();
                if (getClipCenterX() <= clip.getRadius() || (getFitWidth()-getClipCenterX())<=clip.getRadius()){
                    setLayoutX(bounceLoc);
                    setClipCenterX(getClipCenterX()+clipBounceLoc);
                } 
            //Rectangle
            }else{
                Rectangle clip = (Rectangle) getClip();
                if (getClipCenterX() <= clip.getWidth() || (getFitWidth()-getClipCenterX())<=clip.getWidth()){
                    setLayoutX(bounceLoc);
                    setClipCenterX(getClipCenterX()+clipBounceLoc);
                } 
                
            }
        }
        
    }
    
    public void setImageY(double y){
        double bounceLoc = getLayoutY();
        double clipBounceLoc = (y-getLayoutY());
        this.layoutYProperty().unbind();
        setLayoutY(y);
        setClipCenterY(getClipCenterY()-clipBounceLoc);
        Image img = getImage();
        if (img != null && bounds){
            //Circle
            if (getClip() instanceof Circle){
                Circle clip = (Circle) getClip();
                if (getClipCenterY() <= clip.getRadius() || (getFitHeight()-getClipCenterY())<=clip.getRadius()){
                    setLayoutY(bounceLoc);
                    setClipCenterY(getClipCenterY()+clipBounceLoc);
                } 
            //Rectangle
            }else{
                Rectangle clip = (Rectangle) getClip();
                if (getClipCenterX() <= clip.getHeight()|| (getFitHeight()-getClipCenterY())<=clip.getHeight()){
                    setLayoutY(bounceLoc);
                    setClipCenterY(getClipCenterY()+clipBounceLoc);
                } 
                
            }
        }
    }
    
     public boolean isBounds(){
        return bounds;
    }
    
    
    public void setClip(Shape shp){        
        setClip((Node) shp);
        setClipCenterX(getFitWidth()/2.0);
        setClipCenterY(getFitHeight()/2.0);
    }
}
