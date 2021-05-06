package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainPage extends Application {
    private Stage stage;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=primaryStage;
        stage.setTitle("Online Gym");
        gotoFinding();
        stage.show();
    }

    public void gotoFinding(){
        try{
            FindingController finding=(FindingController) changeScene("Finding.fxml");
            finding.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoCourse(){
        try{
            CourseController course=(CourseController) changeScene("Course.fxml");
            course.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoChatting(){
        try{
            ChattingController chatting=(ChattingController) changeScene("Chatting.fxml");
            chatting.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoUserInfo(){
        try{
            UserInfoController userinfo=(UserInfoController) changeScene("UserInfo.fxml");
            userinfo.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoInfoModi(){
        try{
            InfoModiController infomodi=(InfoModiController) changeScene("InfoModi.fxml");
            infomodi.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoPasswordModi(){
        try{
            PasswordModiController passwordmodi=(PasswordModiController) changeScene("PasswordModi.fxml");
            passwordmodi.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void userFinding(){
        gotoFinding();
    }

    public void userCourse(){
        gotoCourse();
    }

    public void userChatting(){
        gotoChatting();
    }

    public void userUserInfo(){
        gotoUserInfo();
    }

    public void userInfoModi(){
        gotoInfoModi();
    }

    public void userPasswordModi(){
        gotoPasswordModi();
    }

    private Initializable changeScene(String fxml)throws Exception{
        FXMLLoader loader= new FXMLLoader();
        InputStream in= MainPage.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainPage.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
}