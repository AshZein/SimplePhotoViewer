package Model;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ImagePreview {
    Image image;
    double dimension;
    public ImagePreview(Image image, double dimension){
        this.image = image;
        this.dimension = dimension;
    }

    public void updateDimension(double size){
        dimension = size;
    }

    public Canvas getCanvas(){
        Canvas canvas = new Canvas(dimension, dimension); //creating a square canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();
    }

}
