package Model;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

public class ShownImage {

    String currImgPath;
    Image currImg;

    double sceneWidth;
    double sceneHeight;


    public ShownImage(String initialPath){
        this.currImgPath = initialPath;

        this.currImg = new Image(currImgPath);
        //currImgView = new ImageView(currImg);

        //currImgView.setPreserveRatio(true);
    }
    public ShownImage(){
        this.currImgPath = System.getProperty("user.dir") + "\\TestImages\\DSC_4236_01.jpg"; // gets the project directory then appends the test image location

        this.currImg = new Image(currImgPath);
    }

    public ImageView getImgView(){
        ImageView imgView = new ImageView(currImg);

        return fitToScreen(imgView);
    }

    private ImageView fitToScreen(ImageView imgView){
        imgView.setPreserveRatio(true);
        imgView.setFitHeight(sceneHeight);
        imgView.setFitWidth(sceneWidth);
        return imgView;
    }


    public void updateWidth(double width){
        sceneWidth = width;
    }

    public void updateHeight(double height){
        sceneHeight = height;
    }
}
