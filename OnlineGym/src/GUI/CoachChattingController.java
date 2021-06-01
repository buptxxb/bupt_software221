package GUI;

import com.chat.ChatUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import util.util;

import java.net.URL;
import java.util.ResourceBundle;


public class CoachChattingController implements Initializable {

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
        application.coachChatting();
    }

    @FXML
    public void UserInfo(ActionEvent event) {
        application.userCoachInfo();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void showChat() throws Exception {
        ChatUI chatUI=new ChatUI();
        chatUI.Show();
    }


}
