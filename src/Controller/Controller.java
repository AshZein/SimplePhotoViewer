package Controller;

import Colours.ThemeControl;
import Model.ImgDeck;
import Model.ShownImage;
import javafx.scene.image.ImageView;

public class Controller {
    ThemeControl themeCont;
    String imgFPath = System.getProperty("user.dir") + "\\TestImages";
    ImgDeck imgD;

    public Controller(){
        imgD = new ImgDeck(imgFPath);

        themeCont = new ThemeControl();
    }

    public ThemeControl getThemeCont(){
        return this.themeCont;
    }

    public void setSceneWidth(double width){
        imgD.updateWidth(width);
    }
    public void setSceneHeight(double height){
        imgD.updateHeight(height);
    }

    public ImageView getImage(double width, double height){
        imgD.updateHeight(height);
        imgD.updateWidth(width);

        return imgD.getImage();
    }

    public ImageView getImage(){
        return imgD.getImage();
    }
}
