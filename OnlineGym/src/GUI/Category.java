package GUI;

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

public class Category extends Application{
    String wantCatogry;
    public Category() {}
    public Category(String wantCatogry) {
        this.wantCatogry = wantCatogry;
    }
    Stage stage=new Stage();
    public static void main(String[] args) throws Exception{
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        AtomicReference<String> searchContent= new AtomicReference<>(new String());
//        searchContent.set(util.GLOBALSEARCH);



        String path="src/data/video_data";
        String[] namelist1=new String[50];
        namelist1 = getNames(path);
        List<String> list1= Arrays.asList(namelist1);
        List<String> arrList = new ArrayList<String>(list1);
        List<String> nulllist = new ArrayList<String>();
        nulllist.add(null);
        arrList.remove("");
        arrList.remove("init");
        arrList.removeAll(nulllist);
//        System.out.println(arrList);
        String[] namelist2 = new String[arrList.size()];
        namelist2 = arrList.toArray(namelist2);

        ArrayList<String> list = new ArrayList<>();
        for (String videoName : namelist2) {
            String fileName = "src/data/video_data/" + videoName + ".json";
            String jsonStr = new GetJSON().gotStr(fileName);
            JSONObject json = new JSONObject(jsonStr);
            String category = json.getString("category");

            if (category.equals(wantCatogry)) {
                list.add(videoName);
            }

        }



//        String[] namelist3 = new String[namelist2.length];
//        for (int i = 0; i < namelist3.length; i++) {
//            namelist3[i]=namelist2[i].substring(0,namelist2[i].append("."));
//            System.out.println(files[i].getName());
//        }


        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane, 600, 400);
        scene.getStylesheets().add(getClass().getResource("MainStyle2.css").toExternalForm());

        Button btnBack = new Button("Back");
        btnBack.setMinSize(80, 40);
        btnBack.setLayoutX(16);
        btnBack.setLayoutY(23);
        btnBack.setOnAction(e->{
            primaryStage.close();
                });

        Label label = new Label("Video List");
        label.setLayoutX(195);
        label.setLayoutY(15);
        label.setFont(Font.font(40));




        ScrollPane sp =new ScrollPane();
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setPrefWidth(500);
        sp.setPrefHeight(300);
        sp.setLayoutX(50);
        sp.setLayoutY(70);


        HBox hb =new HBox();
        hb.setPrefHeight(280);
        hb.setAlignment(Pos.CENTER);

//        for( int j=0;j<namelist2.length;j++){
//            System.out.println(namelist2[j]);
//        }

        Button[] bt=new Button[namelist2.length];
        AtomicInteger check= new AtomicInteger();
        for( int j=0;j<list.size();j++)
        {
            bt[j] = new Button();
            bt[j].setMinSize(300, 200);

            Image image= new Image("images/cover/"+list.get(j)+".jpg");
            BackgroundImage backgroundImage = new BackgroundImage( image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(300,200,true,true,true,true));
            Background background = new Background(backgroundImage);

            bt[j].setBackground(background);

            String[] finalNamelist = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                finalNamelist[i] = list.get(i);
            }
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
            hb.getChildren().add(bt[j]);


            if(check.get() ==list.size()){
                Label lb=new Label("No Related Videos Yet!");
                lb.setFont(Font.font(40));
                hb.getChildren().add(lb);
            }
        }



        sp.setContent(hb);

        pane.getChildren().add(btnBack);
        pane.getChildren().add(label);
        pane.getChildren().add(sp);

        primaryStage.setTitle("Search Result");
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
//                System.out.println(files[i].getName());
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
