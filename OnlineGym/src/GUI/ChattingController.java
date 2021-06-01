package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import com.chat.ChatUI;
import javafx.scene.control.Alert;
import util.util;


public class ChattingController implements Initializable {

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
        application.userCourse_student();
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
    public void showChat1() throws Exception {
        if (util.GLOBALID == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("please login first");
            alert.showAndWait();
            return;
        }
        ChatUI chatUI=new ChatUI();
        chatUI.Show();
    }

    public void showChat2() throws Exception {
        if (util.GLOBALID == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("please login first");
            alert.showAndWait();
            return;
        }
        ChatUI chatUI2=new ChatUI();
        chatUI2.Show();
    }
    public void showChat3() throws Exception {
        if (util.GLOBALID == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("please login first");
            alert.showAndWait();
            return;
        }
        ChatUI chatUI3=new ChatUI();
        chatUI3.Show();
    }
    public void showChat4() throws Exception {
        if (util.GLOBALID == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("please login first");
            alert.showAndWait();
            return;
        }
        ChatUI chatUI4=new ChatUI();
        chatUI4.Show();
    }

}
