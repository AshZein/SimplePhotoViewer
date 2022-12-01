package View;

import Colours.ThemeControl;
import Controller.Controller;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

public class MainView {
    ImageView currImage;
    BorderPane bPane;
    ThemeControl themeCont;
    Controller control;

    public MainView(Controller control) {
        this.control = control;

        themeCont = control.getThemeCont();
    }
    public void initUI(){ //maybe have starting image file path passed in here
        bPane = new BorderPane();
        bPane.setStyle(themeCont.getBackColour());
    }

    public BorderPane getbPane(){
        return this.bPane;
    }
}
