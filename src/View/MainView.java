package View;

import Colours.ThemeControl;
import Controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;

import javafx.scene.input.KeyEvent;

public class MainView {
    BorderPane bPane;
    ThemeControl themeCont;
    Controller control;
    Stage stage;
    Scene scene;

    ImageView imgV;
    ImageView[] bottomPreviews;

    public MainView(Stage stage) {
        this.stage = stage;
        control = new Controller();
        bottomPreviews = control.getImageDeck();

        themeCont = control.getThemeCont();

        initUI();
    }
    private void initUI(){
        // Next image button and its event handler
        Button nextButton = new Button(">");
        nextButton.setId("Next");
        nextButton.setPrefSize(40,40);
        nextButton.setFont(new Font(18));
        nextButton.setStyle("-fx-background-color:#121212; -fx-text-fill: #ffffff;"); // TODO Need to update this so it gets the colour from theme control
        nextButton.setAlignment(Pos.CENTER);

        nextButton.setOnAction(e -> {
            // need to adjust width of the next image so it fits in the scene
            double newWidth = scene.getWidth() - bPane.getRight().getLayoutBounds().getWidth() - bPane.getLeft().getLayoutBounds().getWidth();
            control.setSceneWidth(newWidth);

            imgV = control.nextImage();
            bPane.setCenter(imgV);
            stage.setTitle(imgV.getId());
            bPane.requestFocus();
        });

        // Previous button and its event handler
        Button prevButton = new Button("<");
        prevButton.setId("Previous");
        prevButton.setPrefSize(40,40);
        prevButton.setFont(new Font(18));
        prevButton.setStyle("-fx-background-color:#121212; -fx-text-fill: #ffffff;"); // TODO Need to update this so it gets the colour from theme control
        prevButton.setAlignment(Pos.CENTER);

        prevButton.setOnAction(e-> {
            // need to adjust width of the next image so it fits in the scene
            double newWidth = scene.getWidth() - bPane.getRight().getLayoutBounds().getWidth() - bPane.getLeft().getLayoutBounds().getWidth();
            control.setSceneWidth(newWidth);

            imgV = control.previousImage();
            bPane.setCenter(imgV);
            stage.setTitle(imgV.getId());
            bPane.requestFocus();
        });

        VBox leftButtons = new VBox(prevButton);
        leftButtons.setAlignment(Pos.CENTER);

        VBox rightButtons = new VBox(nextButton);
        rightButtons.setAlignment(Pos.CENTER);

        bPane = new BorderPane();
        bPane.setStyle(themeCont.getBackColour());


        bPane.setRight(rightButtons);
        bPane.setLeft(leftButtons);
        bPane.setBottom(createBottomPreview());

        control.setSceneWidth(bPane.getBottom().getLayoutBounds().getWidth());
        control.setSceneHeight(650-bPane.getBottom().getLayoutBounds().getHeight());
        imgV = control.getImage();
        bPane.setCenter(imgV);

        scene = new Scene(bPane, 1200, 650);

        // got following listeners from: https://blog.idrsolutions.com/2012/11/adding-a-window-resize-listener-to-javafx-scene/
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                control.setSceneWidth(scene.getWidth() - bPane.getRight().getLayoutBounds().getWidth() - bPane.getLeft().getLayoutBounds().getWidth());

                imgV = control.getImage();
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                control.setSceneHeight(scene.getHeight());

                imgV = control.getImage();
            }
        });
        bPane.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent keyEvent){
                String code = keyEvent.getCode().getName();
                System.out.println(code);
                if (code.equals("Left")){
                    double newWidth = scene.getWidth() - bPane.getRight().getLayoutBounds().getWidth() - bPane.getLeft().getLayoutBounds().getWidth();
                    control.setSceneWidth(newWidth);

                    imgV = control.previousImage();
                    bPane.setCenter(imgV);
                }
                else if(code.equals("Right")){
                    double newWidth = scene.getWidth() - bPane.getRight().getLayoutBounds().getWidth() - bPane.getLeft().getLayoutBounds().getWidth();
                    control.setSceneWidth(newWidth);

                    imgV = control.nextImage();
                    bPane.setCenter(imgV);
                }
                stage.setTitle(imgV.getId());
                bPane.requestFocus();
            }
        });
        stage.setTitle(imgV.getId());
        stage.setScene(scene);
        stage.show();
    }

    private HBox createBottomPreview(){
        HBox out = new HBox(2);
        //out.setSpacing(10);
        for (ImageView bottomPreview : bottomPreviews) {
            if (bottomPreview != null) {
                out.getChildren().add(bottomPreview);
            }
        }
        out.setAlignment(Pos.CENTER);
        out.setPadding(new Insets(5,5,5,5));
        return out;
    }
}
