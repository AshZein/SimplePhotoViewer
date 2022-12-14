package Controller;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

public class ShownImage {

    String currImgPath;
    Image currImg;
    ImageView currImgView;
    Controller control;

    double sceneWidth;
    double sceneHeight;


    public ShownImage(String initialPath){
        this.currImgPath = initialPath;

        this.currImg = new Image(currImgPath);
        currImgView = new ImageView(currImg);

        currImgView.setPreserveRatio(true);
    }
    public ShownImage(){
        this.currImgPath = System.getProperty("user.dir") + "\\TestImages\\DSC_4236_01.jpg"; // gets the project directory then appends the test image location

        this.currImg = new Image(currImgPath);
        currImgView = new ImageView(currImg);

        currImgView.setPreserveRatio(true);
    }
    public void setController(Controller control){
        this.control = control;
    }

    public ImageView getImgView(){
        fitToScreen();
        return currImgView;
    }

    private void fitToScreen(){
        this.currImgView.setFitHeight(sceneHeight);
        this.currImgView.setFitWidth(sceneWidth);
    }


    public void updateWidth(double width){
        sceneWidth = width;
    }

    public void updateHeight(double height){
        sceneHeight = height;
    }
}
