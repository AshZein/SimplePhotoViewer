package Model;

import Model.ShownImage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.File;

public class ImgDeck {
    String fPath; // the path to a folder, not a file
    double imgHeight;
    double imgWidth;

    double imageDeckHeight = 50;
    double imageDeckEmphasis = 30;
    String[] imagePaths;
    ShownImage shwnImg;
    ShownImage nextImg;
    ShownImage prevImg;
    HBox imageDeck;
    int index;

    public ImgDeck(String folderPath){
        fPath = folderPath;

        File f = new File(fPath);

        imagePaths = f.list(); // listing all the files in the folder
        index = 0;

        assert imagePaths != null;
        if(imagePaths.length > 2){
            nextImg = new ShownImage(fPath + "\\" + imagePaths[index + 1]);
            prevImg = new ShownImage(fPath + "\\" + imagePaths[imagePaths.length - 1]);
        }
        createImageDeck();
        shwnImg = new ShownImage(fPath + "\\" + imagePaths[index]);
    }

    private void createImageDeck(){
        imageDeck = new HBox();
        for (int i = 0; i < imagePaths.length; i++){
            ShownImage curr = new ShownImage(fPath + "\\" + imagePaths[i]);
            if (i == index){
                // The currently shown image should be emphasized in the bottom preview
                curr.updateHeight(imageDeckHeight+imageDeckEmphasis);
                curr.updateWidth(imageDeckHeight+imageDeckEmphasis);
            }
            else {
                curr.updateHeight(imageDeckHeight);
                curr.updateWidth(imageDeckHeight);
            }
            ImageView toSet = curr.getImgView();
            toSet.setSmooth(false);
            toSet.setCache(true);
            toSet.setId(imagePaths[i]);
            imageDeck.getChildren().add(toSet);
        }
        imageDeck.setAlignment(Pos.CENTER);
        imageDeck.setPadding(new Insets(5,5,5,5));
    }

    public HBox getImageDeck(){
        return this.imageDeck;
    }
    /*
     * returns an ImageView by getting it from a ShownImage object.
     */
    public ImageView getImage(){
        shwnImg.updateWidth(imgWidth);
        shwnImg.updateHeight(imgHeight);

        nextImg.updateHeight(imgHeight);
        nextImg.updateHeight(imgWidth);
        return shwnImg.getImgView();
    }

    /*
     * gets the next image in the array of file paths, circles back to the beginning once at the end of array
     */
    public ImageView getNext(){
        if(index + 1 == imagePaths.length){
            index = 0;
        }
        else{
            index++;
        }
        // emphasizing new image
        ShownImage out = nextImg;
        out.updateHeight(imgHeight);
        out.updateWidth(imgWidth);

        prevImg = shwnImg;

        nextImg = new ShownImage(fPath + "\\" + imagePaths[index]);
        nextImg.updateHeight(imgHeight);
        nextImg.updateWidth(imgWidth);

        shwnImg = out;
        createImageDeck();
        return out.getImgView();
    }

    /*
     * gets the previous image in the array of file paths, circles back to the end once at the start of the array
     */
    public ImageView getPrevious(){
        if (index - 1 < 0){
            index = imagePaths.length - 1;
        }
        else{
            index--;
        }

        ShownImage out = prevImg;
        out.updateHeight(imgHeight);
        out.updateWidth(imgWidth);

        nextImg = shwnImg;

        prevImg = new ShownImage(fPath + "\\" + imagePaths[index]);
        prevImg.updateWidth(imgWidth);
        prevImg.updateHeight(imgHeight);
        shwnImg = out;
        createImageDeck();
        return out.getImgView();
    }

    /*
     * updates the shown image's width
     */
    public void updateWidth(double width){ this.imgWidth = width; }

    /*
     * updates the shown image's height
     */
    public void updateHeight(double height){ this.imgHeight = height - imageDeckHeight - imageDeckEmphasis; }


}
