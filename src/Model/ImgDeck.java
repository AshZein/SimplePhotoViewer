package Model;

import Model.ShownImage;
import javafx.scene.image.ImageView;

import java.io.File;

public class ImgDeck {
    String fPath; // the path to a folder, not a file
    double imgHeight;
    double imgWidth;
    String[] imagePaths;
    ShownImage shwnImg;
    int index;

    public ImgDeck(String folderPath){
        fPath = folderPath;

        File f = new File(fPath);

        imagePaths = f.list(); // listing all the files in the folder
        index = 0;

        assert imagePaths != null;
        shwnImg = new ShownImage(fPath + "\\" + imagePaths[index]); //first image in the folder
    }

    /*
     * returns an ImageView by getting it from a ShownImage object.
     */
    public ImageView getImage(){
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
        shwnImg = new ShownImage(fPath + "\\" + imagePaths[index]);

        shwnImg.updateHeight(this.imgHeight);
        shwnImg.updateWidth(this.imgWidth);

        return shwnImg.getImgView();
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

        shwnImg = new ShownImage(fPath + "\\" + imagePaths[index]);

        shwnImg.updateHeight(this.imgHeight);
        shwnImg.updateWidth(this.imgWidth);

        return shwnImg.getImgView();
    }

    /*
     * updates the shown image's width
     */
    public void updateWidth(double width){
        this.imgWidth = width;
        shwnImg.updateWidth(width);
    }

    /*
     * updates the shown image's height
     */
    public void updateHeight(double height){
        this.imgHeight = height;
        shwnImg.updateHeight(height);
    }


}
