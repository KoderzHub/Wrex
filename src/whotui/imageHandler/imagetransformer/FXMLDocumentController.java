/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whotui.imageHandler.imagetransformer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 *
 * @author kooldeji
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Transformer view;
    @FXML
    private JFXNodesList toolsList;
    @FXML
    private Pane mainPane;
    @FXML
    private JFXToggleButton gridToggleBtn;
    
    private JFXButton toolsBtn, adjustBtn, resizeBtn, rotateBtn, viewBtn;
    
    private ImageView backImage, gridImage;
    private CroppableImageView editImage;
    private ObjectProperty<Point2D> mouseAnchor;
    private Circle circle = new Circle();
    
    private int state;

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mouseAnchor = new SimpleObjectProperty<>();
        circle.setStroke(Color.RED);
        circle.setStrokeWidth(3);
        
        backImage = new ImageView();
        editImage = new CroppableImageView(true);
        gridImage = new ImageView();
        gridImage.visibleProperty().bind(gridToggleBtn.selectedProperty());
        
        backImage.layoutXProperty().bind(editImage.layoutXProperty());
        backImage.layoutYProperty().bind(editImage.layoutYProperty());
        backImage.fitWidthProperty().bind(editImage.fitWidthProperty());
        backImage.fitHeightProperty().bind(editImage.fitHeightProperty());
        backImage.rotateProperty().bind(editImage.rotateProperty());
        backImage.setVisible(false);
        
        gridImage.setOnMousePressed((MouseEvent event) -> {
            onClick(event);
        });
        editImage.setOnMousePressed((MouseEvent event) -> {
            onClick(event);
        });
        backImage.setOnMousePressed((MouseEvent event) -> {
            onClick(event);
        });
        
        
        gridImage.setOnMouseDragged((MouseEvent event) -> {
            onDrag(event);
        });
        
        editImage.setOnMouseDragged((MouseEvent event) -> {
            onDrag(event);
        });
        
        backImage.setOnMouseDragged((MouseEvent event) -> {
            onDrag(event);
        });
        
        toolsBtn = new JFXButton("Tools");
        adjustBtn = new JFXButton("Adjust");
        adjustBtn.setOnAction(e -> {
            state =1;
            backImage.setVisible(true);
        });
        resizeBtn = new JFXButton("Resize");
        resizeBtn.setOnAction(e -> {
            state =2;
            backImage.setVisible(true);
        });
        rotateBtn = new JFXButton("Rotate");
        rotateBtn.setOnAction(e -> {
            state =3;
            backImage.setVisible(true);
            gridToggleBtn.setSelected(true);
        });
        viewBtn = new JFXButton("view");
        viewBtn.setOnAction(e -> {
            state =0;
            backImage.setVisible(false);
            gridToggleBtn.setSelected(false);
        });
        toolsList.addAnimatedNode(toolsBtn);
        toolsList.addAnimatedNode(adjustBtn);
        toolsList.addAnimatedNode(resizeBtn);
        toolsList.addAnimatedNode(rotateBtn);
        toolsList.addAnimatedNode(viewBtn);
        
        mainPane.getChildren().addAll(backImage, circle, editImage, gridImage);
    }    

    void setView(Transformer view) {
        this.view = view;
        double ratio = view.getImage().getHeight()/view.getImage().getWidth();
        circle .setRadius(((Circle) view.getClip()).getRadius()+2);
        circle.centerXProperty().bind(((Circle) view.getClip()).centerXProperty().add(editImage.layoutXProperty()));
        circle.centerYProperty().bind(((Circle) view.getClip()).centerYProperty().add(editImage.layoutYProperty()));
        
        backImage.setImage(view.getImage());
        backImage.setOpacity(0.3);
        backImage.setPreserveRatio(true);
        
        editImage.setImage(view.getImage());
        editImage.setPreserveRatio(true);
        editImage.layoutXProperty().bind(mainPane.widthProperty().divide(2).subtract(editImage.fitWidthProperty().divide(2)));
        editImage.layoutYProperty().bind(mainPane.heightProperty().divide(2).subtract(editImage.fitHeightProperty().divide(2)));
        editImage.setFitWidth(1000);
        editImage.setFitHeight(editImage.getFitWidth()*(ratio));
        
        gridImage.setImage(new Image(getClass().getResourceAsStream("images/grid.png")));
        gridImage.setLayoutX(0);
        gridImage.setLayoutY(0);
        gridImage.fitHeightProperty().bind(mainPane.heightProperty());
        gridImage.fitWidthProperty().bind(mainPane.widthProperty());
        
        editImage.setClip(view.getClip());
        
    }
    public void onClick(MouseEvent event){
        mouseAnchor.set(new Point2D(event.getSceneX(), event.getSceneY()));
        System.out.println(event);
    }
    public void onDrag(MouseEvent event){
        if (state==1){
            move(event);
        }else if(state==2){            
            resize(event);
        }else{
            rotate(event);
        }
        mouseAnchor.set(new Point2D(event.getSceneX(), event.getSceneY()));
    }
    
    public void move(MouseEvent event){
        double deltaX = event.getSceneX() - mouseAnchor.get().getX();
        double deltaY = event.getSceneY() - mouseAnchor.get().getY();

        double imageX = editImage.getLayoutX() + deltaX;
        double imageY = editImage.getLayoutY() + deltaY;

        editImage.setImageX(imageX);
        editImage.setImageY(imageY);        
    }
    
    public void resize(MouseEvent event){
        editImage.layoutXProperty().unbind();
        editImage.layoutYProperty().unbind();
        double deltaX = event.getSceneX() - mouseAnchor.get().getX();
        
        editImage.setFitWidth(editImage.getFitWidth()+deltaX);
        Image img = editImage.getImage();
        Circle clip = (Circle) editImage.getClip();
        if (editImage.isBounds() && (clip.getCenterX() <= clip.getRadius() || (editImage.getFitWidth()-clip.getCenterX())<=clip.getRadius())){
            System.out.println("out");
            editImage.setFitWidth(editImage.getFitWidth()-deltaX);
        }
        
        
    }

    private void rotate(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

       
     

    

