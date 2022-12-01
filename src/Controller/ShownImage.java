package Controller;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

public class ShownImage {

    String currImgPath;
    Image currImg;
    ImageView currImgView;
    Controller control;

    public ShownImage(String initialPath){
        this.currImgPath = initialPath;
    }
    public ShownImage(){
        this.currImgPath = System.getProperty("user.dir") + "\\TestImages\\DSC_4236_01.jpg"; // gets the project directory then appends the test image location

        this.currImg = new Image(currImgPath);
        currImgView = new ImageView(currImg);
    }
    public void setController(Controller control){
        this.control = control;
    }

    public ImageView getImgView(){
        return currImgView;
    }
}
