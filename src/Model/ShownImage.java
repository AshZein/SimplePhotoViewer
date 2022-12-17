package Model;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

public class ShownImage {

    String currImgPath;
    Image currImg;

    double sceneWidth;
    double sceneHeight;
    String id;


    public ShownImage(String initialPath){
        this.currImgPath = initialPath;

        this.currImg = new Image(currImgPath);

        this.id = initialPath;
    }
    public ShownImage(){
        this.currImgPath = System.getProperty("user.dir") + "\\TestImages\\DSC_4236_01.jpg"; // gets the project directory then appends the test image location

        this.currImg = new Image(currImgPath);
    }

    /*
     * returns an image view of the stored image
     */
    public ImageView getImgView(){
        ImageView imgView = new ImageView(currImg);
        imgView.setId(id);
        return fitToScreen(imgView);
    }

    /*
     * adjusts imageView to fit the desired boundaries
     */
    private ImageView fitToScreen(ImageView imgView){
        imgView.setPreserveRatio(true);
        imgView.setFitHeight(sceneHeight);
        imgView.setFitWidth(sceneWidth);
        return imgView;
    }

    /*
     * returns an Image object of the stored image
     */
    public Image getImage(){
        return currImg;
    }


    public void updateWidth(double width){
        sceneWidth = width;
    }

    public void updateHeight(double height){
        sceneHeight = height;
    }
}
