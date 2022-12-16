package View;

import Colours.ThemeControl;
import Controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;

import javafx.scene.input.KeyEvent;


public class MainView {
    BorderPane bPane;
    ThemeControl themeCont;
    Controller control;
    Stage stage;
    Scene scene;

    ImageView imgV;
    HBox bottomPreview;

    double bPaneRWidth;
    double bPaneLWidth;
    double bPaneBottomHeight;

    double sceneWidth = 1200;
    double sceneHeight = 650;

    public MainView(Stage stage) {
        this.stage = stage;
        control = new Controller();
        bottomPreview = control.getImageDeck();

        themeCont = control.getThemeCont();

        initUI();
    }
    private void initUI(){
        // Next image button and its event handler
        Button nextButton = new Button(">");
        nextButton.setId("Next");
        nextButton.setPrefSize(40,40);
        nextButton.setFont(new Font(18));
        nextButton.setStyle("-fx-background-color:#121212; -fx-text-fill: #ffffff;"); // TODO Need to update this so it gets the colour from theme control
        nextButton.setAlignment(Pos.CENTER);

        nextButton.setOnAction(e -> {
            imgV = control.nextImage();
            bPane.setCenter(imgV);
            bPane.requestFocus();
        });

        // Previous button and its event handler
        Button prevButton = new Button("<");
        prevButton.setId("Previous");
        prevButton.setPrefSize(40,40);
        prevButton.setFont(new Font(18));
        prevButton.setStyle("-fx-background-color:#121212; -fx-text-fill: #ffffff;"); // TODO Need to update this so it gets the colour from theme control
        prevButton.setAlignment(Pos.CENTER);

        prevButton.setOnAction(e-> {
            imgV = control.previousImage();
            bPane.setCenter(imgV);
            stage.setTitle(imgV.getId());
            bPane.requestFocus();
        });

        VBox leftButtons = new VBox(prevButton);
        leftButtons.setAlignment(Pos.CENTER);

        VBox rightButtons = new VBox(nextButton);
        rightButtons.setAlignment(Pos.CENTER);

        bPane = new BorderPane();

        bPane.setStyle(themeCont.getBackColour());


        bPane.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent keyEvent){
                String code = keyEvent.getCode().getName();
                System.out.println(code);
                boolean changed = false;
                if (code.equals("Left")){
                    imgV = control.previousImage();
                    bPane.setCenter(imgV);
                    changed = true;
                }
                else if(code.equals("Right")){
                    imgV = control.nextImage();
                    bPane.setCenter(imgV);
                    changed = true;
                }
                if(changed) {
                    stage.setTitle(imgV.getId());
                    bPane.requestFocus();
                }
            }
        });

        bPane.setRight(rightButtons);
        bPane.setLeft(leftButtons);
        bPane.setBottom(bottomPreview);
        bPane.requestFocus();

        bPaneRWidth = bPane.getRight().getLayoutBounds().getWidth();
        bPaneLWidth = bPane.getLeft().getLayoutBounds().getWidth();
        bPaneBottomHeight = bPane.getBottom().getLayoutBounds().getHeight();

        control.setSceneWidth(bPane.getBottom().getLayoutBounds().getWidth());
        control.setSceneHeight(650-bPaneBottomHeight);
        imgV = control.getImage();
        bPane.setCenter(imgV);

        scene = new Scene(bPane, sceneWidth, sceneHeight);

        // got following listeners from: https://blog.idrsolutions.com/2012/11/adding-a-window-resize-listener-to-javafx-scene/
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                double adjustment = scene.getWidth() - bPaneRWidth - bPaneLWidth;
                control.setSceneWidth(adjustment);

                imgV.setFitWidth(adjustment);
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                double adjustment = scene.getHeight() - bPaneBottomHeight;
                control.setSceneHeight(adjustment);

                imgV.setFitHeight(adjustment);
            }
        });

        stage.setTitle(imgV.getId());
        stage.setScene(scene);
        stage.show();
    }

}
