package GUI;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Media2 extends Application{

    Stage stage=new Stage();
    private Double endTime = new Double(0);
    private Double currentTime = new Double(0);
    private java.io.File file = new java.io.File("src/video/video2.mp4");
    private Media media = new Media(file.toURI().toString());
    private MediaPlayer mplayer = new MediaPlayer(media);

    @Override
    public void start(Stage primaryStage)
    {
        MediaView mView = new MediaView(mplayer);
        Label lbCurrentTime = new Label();
        Slider slTime = new Slider(); // 时间轴
        slTime.setPrefWidth(200);
        BorderPane pane = new BorderPane();

        mView.fitWidthProperty().bind(pane.widthProperty());
        mView.fitHeightProperty().bind(pane.heightProperty().subtract(30));
        Button btnPlay = new Button("Play");
        btnPlay.setOnAction(e->{
            if (btnPlay.getText().equals("Play")){
                btnPlay.setText("Pause");
                mplayer.play();
            }
            else{
                btnPlay.setText("Play");
                mplayer.pause();
            }
        });
        mplayer.setOnEndOfMedia(() -> { // 为初始存在
            mplayer.stop();
            btnPlay.setText("Play");
        });
        Button btnReplay = new Button("Stop");
        btnReplay.setOnAction(e->{
            mplayer.stop();
            btnPlay.setText("Play");
        });

        Slider slVolume = new Slider(); // 音量
        slVolume.setPrefWidth(150);
        slVolume.setValue(50);
        slVolume.setShowTickLabels(true);
        slVolume.setShowTickMarks(true);


        btnPlay.setText("Pause");
        media = new Media(file.toURI().toString());
        mplayer = new MediaPlayer(media);
        mView.setMediaPlayer(mplayer);
        mplayer.setOnReady(() -> {
            endTime = mplayer.getStopTime().toSeconds();
        }); // 媒体准备好时获得信息
        mplayer.setOnEndOfMedia(() -> {
            mplayer.stop();
            mplayer.seek(Duration.ZERO);
            btnPlay.setText("Play");
        });
        mplayer.currentTimeProperty().addListener(ov->{
            currentTime = mplayer.getCurrentTime().toSeconds();
            lbCurrentTime.setText(Seconds2Str(currentTime)+"/"+Seconds2Str(endTime));
            slTime.setValue(currentTime/endTime*100);
        });
        slTime.valueProperty().addListener(ov->{
            if (slTime.isValueChanging()){
                mplayer.seek(mplayer.getTotalDuration().multiply(slTime.getValue()/100));
            }
        });
        mplayer.volumeProperty().bind(slVolume.valueProperty().divide(100)); // 音量调节
        mplayer.play();


        HBox paneCtl = new HBox(15);
        paneCtl.setAlignment(Pos.CENTER);
        paneCtl.getChildren().addAll(lbCurrentTime,slTime,btnReplay,btnPlay,new Label("Volume"),slVolume);

        pane.setCenter(mView);
        pane.setBottom(paneCtl);

        Scene scene = new Scene(pane,800,480);
        primaryStage.setTitle("Video2");
        primaryStage.setScene(scene);
        primaryStage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            closerFunction();
        });
    }
    public static void main(String[] args) {
        launch(args);
    }

    private void closerFunction(){
        mplayer.stop();
        stage.close();
    }

    private String Seconds2Str(Double seconds){
        Integer count = seconds.intValue();
        Integer Hours = count / 3600;
        count = count % 3600;
        Integer Minutes = count /60;
        count = count % 60;
        String str = Hours.toString()+":"+Minutes.toString()+":"+count.toString();
        return str;
    }

    public void  showWindow() throws Exception {
        start(stage);
    }
}