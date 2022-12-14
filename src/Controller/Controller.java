package Controller;

import Colours.ThemeControl;
import View.MainView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Controller.ShownImage;

public class Controller {
    ThemeControl themeCont;
    Stage stage;

    double sceneWidth = 950;
    double sceneHeight = 650;
    Scene scene;
    ImageView imageV;
    ShownImage picture;

    MainView mView;
    public Controller(Stage stage){
        this.stage = stage;
        this.themeCont = new ThemeControl();

        this.picture = new ShownImage();
        this.picture.setController(this);
        this.picture.updateHeight(sceneHeight);
        this.picture.updateWidth(sceneWidth);

        imageV = picture.getImgView();

        mView = new MainView(this);
        mView.setCurrImage(imageV);
        mView.initUI();

        scene = new Scene(mView.getbPane(), sceneWidth, sceneHeight);

        // got following listeners from: https://blog.idrsolutions.com/2012/11/adding-a-window-resize-listener-to-javafx-scene/
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                setSceneWidth();

                imageV = picture.getImgView();
                mView.setCurrImage(imageV);
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                setSceneHeight();

                imageV = picture.getImgView();
                mView.setCurrImage(imageV);
            }
        });

        this.stage.setScene(scene);
        this.stage.show();
    }

    public ThemeControl getThemeCont(){
        return this.themeCont;
    }

    public void setSceneWidth(){
        sceneWidth = scene.getWidth();

        this.picture.updateWidth(sceneWidth);
    }
    public void setSceneHeight(){
        sceneHeight = scene.getHeight();

        this.picture.updateHeight(sceneHeight);
    }
}
