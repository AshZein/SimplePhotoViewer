package View;

import Colours.ThemeControl;
import Controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;

public class MainView {
    BorderPane bPane;
    ThemeControl themeCont;
    Controller control;
    Stage stage;
    Scene scene;

    ImageView imgV;

    public MainView(Stage stage) {
        this.stage = stage;
        control = new Controller();

        imgV = control.getImage(950,650);

        themeCont = control.getThemeCont();



        initUI();

    }
    private void initUI(){ //maybe have starting image file path passed in here
        Button nextButton = new Button(">");
        nextButton.setId("Next");
        nextButton.setPrefSize(100,40);
        nextButton.setFont(new Font(22));
        nextButton.setStyle("-fx-background-color:#121212; -fx-text-fill: #ffffff;");
        nextButton.setAlignment(Pos.CENTER);

        Button prevButton = new Button("<");
        prevButton.setId("Previous");
        prevButton.setPrefSize(40,40);
        prevButton.setFont(new Font(18));
        prevButton.setStyle("-fx-background-color:#121212; -fx-text-fill: #ffffff;");
        prevButton.setAlignment(Pos.CENTER);


        VBox leftButtons = new VBox(prevButton);
        leftButtons.setAlignment(Pos.CENTER);

        VBox rightButtons = new VBox(nextButton);
        rightButtons.setAlignment(Pos.CENTER);


        bPane = new BorderPane();
        bPane.setStyle(themeCont.getBackColour());

        bPane.setCenter(imgV);
        bPane.setRight(rightButtons);
        bPane.setLeft(leftButtons);

        scene = new Scene(bPane, 950, 650);

        // got following listeners from: https://blog.idrsolutions.com/2012/11/adding-a-window-resize-listener-to-javafx-scene/
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                control.setSceneWidth(scene.getWidth());

                imgV = control.getImage();
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                control.setSceneHeight(scene.getHeight());

                imgV = control.getImage();
            }
        });

        stage.setScene(scene);
        stage.show();
    }
}
