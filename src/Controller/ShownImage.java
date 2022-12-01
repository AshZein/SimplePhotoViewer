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
        this.currImgPath = System.getProperty("user.dir") + "\\TestImages\\DSC_4236_01.jpg"; // gets the project directory then appends the test image location

        this.currImg = new Image(currImgPath);
        currImgView = new ImageView(currImg);
    }

    public ImageView getImgView(){
        return currImgView;
    }
}
