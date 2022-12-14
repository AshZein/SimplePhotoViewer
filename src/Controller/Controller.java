package Controller;

import Colours.ThemeControl;
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
        this.picture.updateWidth(width);
    }
    public void setSceneHeight(double height){
        this.picture.updateHeight(height);
    }

    public ImageView getImage(double width, double height){
        this.picture.updateHeight(height);
        this.picture.updateWidth(width);

        return picture.getImgView();
    }

    public ImageView getImage(){
        return picture.getImgView();
    }
}
