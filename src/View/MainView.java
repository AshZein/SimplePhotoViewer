package View;

import Colours.ThemeControl;
import Controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;

public class MainView {
    BorderPane bPane;
    ThemeControl themeCont;
    Controller control;
    Stage stage;
    Scene scene;

    ImageView imgV;

    public MainView(Stage stage) {
        this.stage = stage;
        control = new Controller();

        imgV = control.getImage(950,650);

        themeCont = control.getThemeCont();



        initUI();

    }
    private void initUI(){ //maybe have starting image file path passed in here
        bPane = new BorderPane();
        bPane.setStyle(themeCont.getBackColour());

        bPane.setCenter(imgV);


        scene = new Scene(bPane, 950, 650);
        // got following listeners from: https://blog.idrsolutions.com/2012/11/adding-a-window-resize-listener-to-javafx-scene/
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                control.setSceneWidth(scene.getWidth());

                imgV = control.getImage();
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                control.setSceneHeight(scene.getHeight());

                imgV = control.getImage();
            }
        });

        stage.setScene(scene);
        stage.show();
    }
}
