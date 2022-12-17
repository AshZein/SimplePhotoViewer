package Model;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ImagePreview {
    Image image;
    double dimension;
    Canvas canvas;
    public ImagePreview(Image image, double dimension){
        this.image = image;
        this.dimension = dimension;
        canvas = new Canvas(dimension, dimension);
    }

    /*
     * updates the canvas dimensions
     */
    public void updateDimension(double size){
        dimension = size;
        canvas.setWidth(dimension);
        canvas.setHeight(dimension);
    }

    /*
     * draws the image on the canvas and returns the canvas
     */
    public Canvas getCanvas(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        canvas.setWidth(image.getWidth());
        canvas.setId(image.getUrl()+"_CANVAS");
        return canvas;
    }

}
