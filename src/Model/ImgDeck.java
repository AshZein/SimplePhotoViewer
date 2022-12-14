package Model;

import Model.ShownImage;
import javafx.scene.image.ImageView;

import java.io.File;

public class ImgDeck {
    String fPath; // the path to a folder, not a file
    double imgHeight;
    double imgWidth;

    double imageDeckHeight = 50;
    double imageDeckEmphasis = 30;
    String[] imagePaths;
    ImageView shwnImg;
    ImageView[] imageDeck;
    int index;

    public ImgDeck(String folderPath){
        fPath = folderPath;

        File f = new File(fPath);

        imagePaths = f.list(); // listing all the files in the folder
        index = 0;

        this.imageDeck = new ImageView[20];
        createImageDeck();
        shwnImg = getImage();
    }

    private void createImageDeck(){
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
            imageDeck[i] = curr.getImgView();
        }
    }

    public ImageView[] getImageDeck(){
        return this.imageDeck;
    }
    /*
     * returns an ImageView by getting it from a ShownImage object.
     */
    public ImageView getImage(){
        shwnImg = new ImageView(imageDeck[index].getImage());
        shwnImg.setPreserveRatio(true);
        shwnImg.setFitHeight(this.imgHeight);
        shwnImg.setFitWidth(this.imgWidth);

        return shwnImg;
    }

    /*
     * gets the next image in the array of file paths, circles back to the beginning once at the end of array
     */
    public ImageView getNext(){
        //reverting to a preview without emphasis
        imageDeck[index].setFitWidth(imageDeckHeight);
        imageDeck[index].setFitHeight(imageDeckHeight);

        if(index + 1 == imagePaths.length){
            index = 0;
        }
        else{
            index++;
        }
        // emphasizing new image
        imageDeck[index].setFitWidth(imageDeckHeight + imageDeckEmphasis);
        imageDeck[index].setFitHeight(imageDeckHeight + imageDeckEmphasis);

        return getImage();
    }

    /*
     * gets the previous image in the array of file paths, circles back to the end once at the start of the array
     */
    public ImageView getPrevious(){
        //reverting to a preview without emphasis
        imageDeck[index].setFitWidth(imageDeckHeight);
        imageDeck[index].setFitHeight(imageDeckHeight);
        if (index - 1 < 0){
            index = imagePaths.length - 1;
        }
        else{
            index--;
        }
        // emphasizing new image
        imageDeck[index].setFitWidth(imageDeckHeight + imageDeckEmphasis);
        imageDeck[index].setFitHeight(imageDeckHeight + imageDeckEmphasis);

        return getImage();
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
