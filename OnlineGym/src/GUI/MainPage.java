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

    public void gotoRegister(){
        try{
             RegisterController Register= (RegisterController) changeScene("Register.fxml");
            Register.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoLogin(){
        try{
            LoginController Login= (LoginController) changeScene("Login.fxml");
            Login.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoFavorite(){
        try{
            FavoriteController Favorite= (FavoriteController) changeScene("Favorite.fxml");
            Favorite.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoHistory(){
        try{
            HistoryController History= (HistoryController) changeScene("History.fxml");
            History.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoSearch(){
        try{
            SearchController Search= (SearchController) changeScene("Search.fxml");
            Search.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void gotoChest(){
        try{
            ChestController Chest= (ChestController) changeScene("Chest.fxml");
            Chest.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void gotoShoulderArm(){
        try{
            ShoulderArmController ShoulderArm= (ShoulderArmController) changeScene("ShoulderArm.fxml");
            ShoulderArm.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void gotoBack(){
        try{
            BackController Back= (BackController) changeScene("Back.fxml");
            Back.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void gotoHip(){
        try{
            HipController Hip= (HipController) changeScene("Hip.fxml");
            Hip.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void gotoLeg(){
        try{
            LegController Leg= (LegController) changeScene("Leg.fxml");
            Leg.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void gotoOther(){
        try{
            OtherController Other= (OtherController) changeScene("Other.fxml");
            Other.setApp(this);
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

    public void accountLogin(){gotoLogin();}

    public void accountRegister(){gotoRegister();}

    public void userFavorite(){  gotoFavorite(); }

    public void userHistory(){ gotoHistory(); }

    public void userSearch(){
        gotoSearch();
    }

    public void userChest(){
        gotoChest();
    }

    public void userShoulderArm(){
        gotoShoulderArm();
    }

    public void userBack(){
        gotoBack();
    }

    public void userHip(){
        gotoHip();
    }

    public void userLeg(){
        gotoLeg();
    }

    public void userOther(){
        gotoOther();
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