package Controller;

import Colours.ThemeControl;
import Model.ShownImage;
import javafx.scene.image.ImageView;

public class Controller {
    ThemeControl themeCont;

    ShownImage picture;
    String imgPath = System.getProperty("user.dir") + "\\TestImages\\DSC_4236_01.jpg";


    public Controller(){
        this.picture = new ShownImage(imgPath);
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
