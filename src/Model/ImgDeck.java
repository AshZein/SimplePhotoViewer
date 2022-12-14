package Model;

import Model.ShownImage;
import javafx.scene.image.ImageView;

import java.io.File;

public class ImgDeck {
    String fPath;
    double imgHeight;
    double imgWidth;
    String[] imagePaths;
    ShownImage shwnImg;
    int index;

    public ImgDeck(String folderPath){
        fPath = folderPath;

        File f = new File(fPath);

        imagePaths = f.list();
        index = 0;

        assert imagePaths != null;
        shwnImg = new ShownImage(fPath + "\\" + imagePaths[index]);
    }

    public ImageView getImage(){
        return shwnImg.getImgView();
    }
    public ImageView getNext(){
        if(index + 1 == imagePaths.length){
            index = 0;
        }
        else{
            index++;
        }
        shwnImg = new ShownImage(imagePaths[index]);

        shwnImg.updateHeight(this.imgHeight);
        shwnImg.updateWidth(this.imgWidth);

        return shwnImg.getImgView();
    }
    public ImageView getPrevious(){
        if (index - 1 < 0){
            index = imagePaths.length - 1;
        }
        else{
            index--;
        }

        shwnImg = new ShownImage(imagePaths[index]);

        shwnImg.updateHeight(this.imgHeight);
        shwnImg.updateWidth(this.imgWidth);

        return shwnImg.getImgView();
    }

    public void updateWidth(double width){
        this.imgWidth = width;
        shwnImg.updateWidth(width);
    }

    public void updateHeight(double height){
        this.imgHeight = height;
        shwnImg.updateHeight(height);
    }


}
