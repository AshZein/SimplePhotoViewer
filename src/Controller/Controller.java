package Controller;

import Colours.ThemeControl;
import Model.ImgDeck;
import Model.ShownImage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Controller {
    ThemeControl themeCont;
    //String imgFPath = System.getProperty("user.dir") + "\\TestImages";
    //String imgFPath = System.getProperty("user.dir") + "\\TestImagesSmall";
    String imgFPath = System.getProperty("user.dir") + "\\TestImagesSingle";
    ImgDeck imgD;

    public Controller(){
        imgD = new ImgDeck(imgFPath);

        themeCont = new ThemeControl();
    }

    public ThemeControl getThemeCont(){
        return this.themeCont;
    }

    /*
     * Updates the width of the current ImageView
     */
    public void setSceneWidth(double width){
        imgD.updateWidth(width);
    }
    /*
     * Updates the height of the current ImageView
     */
    public void setSceneHeight(double height){
        imgD.updateHeight(height);
    }

    /*
     * Gets an imageView with the given width and height from an ImageDeck object
     */
    public ImageView getImage(double width, double height){
        imgD.updateHeight(height);
        imgD.updateWidth(width);

        return imgD.getImage();
    }

    /*
     * Gets an imageView from an ImageDeck object
     */
    public ImageView getImage(){
        return imgD.getImage();
    }

    /*
     * Gets the next imageView from an ImageDeck object
     */
    public ImageView nextImage(){
        return imgD.getNext();
    }

    /*
     * Gets the previous imageView from an ImageDeck object
     */
    public ImageView previousImage(){
        return imgD.getPrevious();
    }

    public HBox getImageDeck(){ return imgD.getImageDeck(); }
}
