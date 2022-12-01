package Controller;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

public class ShownImage {

    String currImgPath;
    Image currImg;
    ImageView currImgView;
    Controller control;

    double[] aspectRatio = new double[2]; //aspectRatio of the shown image

    public ShownImage(String initialPath){
        this.currImgPath = initialPath;

        this.currImg = new Image(currImgPath);
        aspectRatio[0] = currImg.getWidth() / currImg.getHeight();
        aspectRatio[1] = 1;
        currImgView = new ImageView(currImg);
    }
    public ShownImage(){
        this.currImgPath = System.getProperty("user.dir") + "\\TestImages\\DSC_4236_01.jpg"; // gets the project directory then appends the test image location

        this.currImg = new Image(currImgPath);
        aspectRatio[0] = currImg.getWidth() / currImg.getHeight();
        aspectRatio[1] = 1;
        currImgView = new ImageView(currImg);
    }
    public void setController(Controller control){
        this.control = control;
    }

    public ImageView getImgView(){
        fitToScreen();
        return currImgView;
    }

    private void fitToScreen(){
        currImgView.setFitHeight(control.getSceneHeight());
        currImgView.setFitWidth(control.getSceneWidth());
    }
}
