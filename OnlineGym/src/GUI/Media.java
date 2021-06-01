package GUI;

import data_handle.CreateJSON;
import data_handle.GetJSON;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.json.JSONObject;
import people.User;
import util.util;

public class Media extends Application{

    Stage stage=new Stage();
    private Double endTime = 0.0;
    private Double currentTime = (double) 0;
    String videoName=new String("init");
    String path="src/video/"+videoName+".mp4";
    private java.io.File file = new java.io.File(path);
    private javafx.scene.media.Media media = new javafx.scene.media.Media(file.toURI().toString());
    private MediaPlayer mplayer = new MediaPlayer(media);
    int temp = 0;

    public void SetVideo(String name){
        videoName=name;
        path="src/video/"+videoName+".mp4";
        file = new java.io.File(path);
        media = new javafx.scene.media.Media(file.toURI().toString());
        mplayer = new MediaPlayer(media);
    }

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

        // TODO
        String jsonStr = new GetJSON().gotStr("src/data/video_data/" + videoName + ".json");
        JSONObject json = new JSONObject(jsonStr);
        int likeCount = json.getInt("likeCount");
        final int[] like = {likeCount};

//        String jsonStr1 = new GetJSON().gotStr("src/data/user" + util.GLOBALID + ".json");
        User user = new GetJSON().createUser("src/data/user" + util.GLOBALID + ".json");

        Button btnLike = new Button("Like "+ like[0]);
        btnLike.setOnAction(e->{
            if (btnLike.getText().equals("Like "+ like[0])){
                like[0] += 1;
                btnLike.setText("Liked "+ like[0]);
                temp = like[0];
                user.like(videoName);
            }
            else{
                like[0] -= 1;
                btnLike.setText("Like "+ like[0]);
                temp = like[0];
                user.removeLike(videoName);
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
        media = new javafx.scene.media.Media(file.toURI().toString());
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
        paneCtl.getChildren().addAll(lbCurrentTime,slTime,btnReplay,btnPlay,btnLike,new Label("Volume"),slVolume);

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
        String fileName = "src/data/video_data/" + videoName + ".json";
        String jsonStr = new GetJSON().gotStr(fileName);
        JSONObject json = new JSONObject(jsonStr);
        json.put("likeCount", temp);
        String context = json.toString();
        new CreateJSON().createJSON(fileName, context);
        mplayer.stop();
        stage.close();
    }

    private String Seconds2Str(Double seconds){
        int count = seconds.intValue();
        int Hours = count / 3600;
        count = count % 3600;
        int Minutes = count /60;
        count = count % 60;
        String str = Integer.toString(Hours) +":"+ Integer.toString(Minutes) +":"+ Integer.toString(count);
        return str;
    }

    public void  showWindow() throws Exception {
        start(stage);
    }
}