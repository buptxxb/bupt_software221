package GUI;

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

//        AtomicReference<String> searchContent= new AtomicReference<>(new String());
//        searchContent.set(util.GLOBALSEARCH);

//        String[] student= new String[];
        String favoriteName="bicep";

        String path="src/video";
        String[] namelist1=new String[50];
        namelist1=getNames(path);
        List<String> list1= Arrays.asList(namelist1);
        List<String> arrList = new ArrayList<String>(list1);
        List<String> nulllist = new ArrayList<String>();
        nulllist.add(null);
        arrList.remove("");
        arrList.remove("init");
        arrList.removeAll(nulllist);
//        System.out.println(arrList);
        String[] namelist2 = new String[arrList.size()];
        namelist2 = (String[]) arrList.toArray(namelist2);

//        String[] namelist3 = new String[namelist2.length];
//        for (int i = 0; i < namelist3.length; i++) {
//            namelist3[i]=namelist2[i].substring(0,namelist2[i].append("."));
//            System.out.println(files[i].getName());
//        }



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

//        for( int j=0;j<namelist2.length;j++){
//            System.out.println(namelist2[j]);
//        }

        Label[] lb=new Label[namelist2.length];
        AtomicInteger check= new AtomicInteger();
        for( int j=0;j<namelist2.length;j++)
        {
            if(namelist2[j].contains(favoriteName)) {
            lb[j] = new Label();
//            lb[j].setMinSize(150, 90);

            Image image= new Image("images/cover/"+namelist2[j]+".jpg");
            BackgroundImage backgroundImage = new BackgroundImage( image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(150,90,true,true,true,true));
            Background background = new Background(backgroundImage);

            lb[j].setBackground(background);

            String[] finalNamelist = namelist2;
            int finalJ = j;
            vb.getChildren().add(lb[j]);
        }else{
            check.set(check.get() + 1);
        }
            System.out.println(check.get());
            if(check.get() ==namelist2.length){
                Label lbel=new Label("No Student!");
                lbel.setFont(Font.font(40));
                vb.getChildren().add(lbel);
            }
        }


        String[] finalNamelist1 = namelist2;

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
