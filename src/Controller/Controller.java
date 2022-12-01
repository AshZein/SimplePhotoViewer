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
        this.mView = new MainView(this);

        this.picture = new ShownImage();
        this.picture.setController(this);
        imageV = picture.getImgView();
        mView.setCurrImage(imageV);

        mView.initUI();
        scene = new Scene(mView.getbPane(), sceneWidth, sceneHeight);
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                imageV = picture.getImgView();
                mView.setCurrImage(imageV);
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
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

    public double getSceneWidth(){
        if (!(scene == null)) {
            sceneWidth = scene.getWidth();
        }
        return sceneWidth;

    }
    public double getSceneHeight(){
        if(!(scene == null)){
            sceneHeight =scene.getHeight();
        }
        return sceneHeight;
    }
}
