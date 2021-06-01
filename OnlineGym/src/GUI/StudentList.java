package GUI;

import data_handle.GetJSON;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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

public class StudentList extends Application{
    Stage stage=new Stage();
    public static void main(String[] args) throws Exception{
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fileName = "src/data/trainer" + util.GLOBALID + ".json";
        String jsonStr = new GetJSON().gotStr(fileName);
        JSONObject json = new JSONObject(jsonStr);
        int len = json.getJSONArray("student").length();
        String[] student = new String[len];
        for (int i = 0; i < len; i++) {
            student[i] =  json.getJSONArray("student").getString(i);
        }
//        String[] student=new String[]{"lwd", "txy","wzl"};
//        for( int i=0;i<student.length;i++){
//            System.out.println(student[i]);
//        }


        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane, 400, 400);
        scene.getStylesheets().add(getClass().getResource("MainStyle3.css").toExternalForm());

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


        Label[] lb=new Label[student.length];
        AtomicInteger check= new AtomicInteger();
        for( int j=0;j<student.length;j++)
        {
            if(student.length!=0) {
            lb[j] = new Label(student[j]);
            lb[j].setStyle("-fx-font-size: 25;");
            vb.getChildren().add(lb[j]);
        }else{
                Label lbel=new Label("No Student!");
                lbel.setFont(Font.font(40));
                vb.getChildren().add(lbel);
            }
        }


        sp.setContent(vb);

        pane.getChildren().add(btnBack);
        pane.getChildren().add(sp);



        primaryStage.setTitle("Student List");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void  showWindow() throws Exception {
        start(stage);
    }
    private void closerFunction(){
        stage.close();
    }


}
