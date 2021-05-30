package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class HipController implements Initializable {

    private MainPage application;

    public void setApp(MainPage application){
        this.application = application;
    }


    @FXML
    public void Finding(ActionEvent event) {
        application.userFinding();
    }

    @FXML
    public void Course(ActionEvent event) {
        application.userCourse();
    }

    @FXML
    public void Chatting(ActionEvent event) {
        application.userChatting();
    }

    @FXML
    public void UserInfo(ActionEvent event) {
        application.userUserInfo();
    }

    @FXML
    public void Login(ActionEvent event) {
        application.accountLogin();
    }

    @FXML
    public void Search(ActionEvent event) {
        application.userSearch();
    }

    @FXML
    public void Back(ActionEvent event) {
        application.userFinding();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void showVideo1() throws Exception {
        Media1 media=new Media1();
        media.showWindow();
    }

    public void showVideo2() throws Exception {
        Media2 media=new Media2();
        media.showWindow();
    }

    public void showVideo3() throws Exception {
        Media3 media=new Media3();
        media.showWindow();
    }

    public void showVideo4() throws Exception {
        Media4 media=new Media4();
        media.showWindow();
    }



}