package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class FindingController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void showVideo1() throws Exception {
        GUI.Media1 media=new Media1();
        media.showWindow();
    }

    public void showVideo2() throws Exception {
        GUI.Media2 media=new Media2();
        media.showWindow();
    }

    public void showVideo3() throws Exception {
        GUI.Media3 media=new Media3();
        media.showWindow();
    }

    public void showVideo4() throws Exception {
        GUI.Media4 media=new Media4();
        media.showWindow();
    }
}
