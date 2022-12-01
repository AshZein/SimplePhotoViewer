package Controller;

import Colours.ThemeControl;
import View.MainView;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Controller.ShownImage;

public class Controller {
    ThemeControl themeCont;
    Stage stage;
    Scene scene;
    ImageView imageV;
    ShownImage picture;

    MainView mView;
    public Controller(Stage stage){
        this.stage = stage;
        this.themeCont = new ThemeControl();
        this.mView = new MainView(this);

        this.picture = new ShownImage();
        imageV = picture.getImgView();
        mView.setCurrImage(imageV);

        mView.initUI();
        scene = new Scene(mView.getbPane(), 950, 650);


        this.stage.setScene(scene);
        this.stage.show();
    }

    public ThemeControl getThemeCont(){
        return this.themeCont;
    }
}
