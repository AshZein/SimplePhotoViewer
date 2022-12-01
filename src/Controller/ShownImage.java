package Controller;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

public class ShownImage {

    String currImgPath;
    Image currImg;
    javafx.scene.image.ImageView currImgView;

    public ShownImage(String initialPath){
        this.currImgPath = initialPath;
    }
    public ShownImage(){
        this.currImgPath = "C:\\Users\\ashka\\Desktop\\Projects\\SimplePhotoViewer\\TestImages\\DSC_4236_01.jpg";
        this.currImg = new Image(currImgPath);
        currImgView = new ImageView(currImg);
    }

    public ImageView getImgView(){
        return currImgView;
    }
}
