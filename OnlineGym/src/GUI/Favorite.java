package GUI;

import data_handle.CreateJSON;
import data_handle.GetJSON;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.json.JSONObject;
import util.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Favorite extends Application{
    Stage stage=new Stage();
    public static void main(String[] args) throws Exception{
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fileName = "src/data/like_data/like" + util.GLOBALID + ".json";
        String jsonStr = new GetJSON().gotStr(fileName);
        JSONObject json = new JSONObject(jsonStr);
        int len = json.getJSONArray("video").length();
        String[] videos = new String[len];
        for (int i = 0; i < len; i++) {
            videos[i] =  json.getJSONArray("video").getString(i);
        }

        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane, 400, 400);
        scene.getStylesheets().add(getClass().getResource("MainStyle2.css").toExternalForm());

        Button btnBack = new Button("Back");
        btnBack.setMinSize(80, 40);
        btnBack.setLayoutX(16);
        btnBack.setLayoutY(23);
        btnBack.setOnAction(e->{
            primaryStage.close();
        });

        ScrollPane sp =new ScrollPane();
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setPrefWidth(300);
        sp.setPrefHeight(300);
        sp.setLayoutX(50);
        sp.setLayoutY(70);

        VBox vb =new VBox();
        vb.setPrefWidth(300);
        vb.setAlignment(Pos.CENTER);

        Button[] bt=new Button[videos.length];
        AtomicInteger check= new AtomicInteger();
        for(int j=0;j<videos.length;j++) {
            bt[j] = new Button();
            bt[j].setMinSize(150, 90);

            Image image= new Image("images/cover/"+videos[j]+".jpg");
            BackgroundImage backgroundImage = new BackgroundImage( image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(150,90,true,true,true,true));
            Background background = new Background(backgroundImage);

            bt[j].setBackground(background);

            String[] finalNamelist = videos;
            int finalJ = j;
            bt[j].setOnAction(e->{
                Media media=new Media();
                media.SetVideo(finalNamelist[finalJ]);
                try {
                    media.showWindow();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });
            vb.getChildren().add(bt[j]);
            if(check.get() ==videos.length){
                Label lb=new Label("No result found!");
                lb.setFont(Font.font(40));
                vb.getChildren().add(lb);
            }
        }

        String[] finalNamelist1 = videos;

        sp.setContent(vb);
        pane.getChildren().add(btnBack);
        pane.getChildren().add(sp);
        primaryStage.setTitle("Favorite");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public String[] getNames(String path) {
        String[] namelist1=new String[50];
        String[] namelist2=new String[50];
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
                namelist1[i]=files[i].getName();
                namelist2[i]=namelist1[i].substring(0,namelist1[i].lastIndexOf("."));
        }
            return namelist2;
    }
    public void  showWindow() throws Exception {
        start(stage);
    }
    private void closerFunction(){
        stage.close();
    }


}
