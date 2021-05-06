package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;

public class MediaDemo extends Application{

    Stage stage=new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        File url = new File("src/video/test.mp4");
        Media media = new Media(url.getAbsoluteFile().toURI().toString());

        MediaPlayer mplayer = new MediaPlayer(media);
        MediaView mView = new MediaView(mplayer);
        System.out.println(media.getSource());

        Pane pane = new Pane();
        pane.getChildren().add(mView);
        mView.fitHeightProperty().bind(pane.heightProperty());
        mView.fitWidthProperty().bind(pane.widthProperty());

        Scene scene = new Scene(pane,640,360);
        primaryStage.setTitle("MediaDemo");
        primaryStage.setScene(scene);
        primaryStage.show();

        mplayer.play();
    }

    public void  showWindow() throws Exception {
        start(stage);
    }

}