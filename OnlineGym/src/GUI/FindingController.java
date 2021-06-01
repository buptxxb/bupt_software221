package GUI;

import data_handle.GetJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import util.util;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class FindingController implements Initializable {

    private MainPage application;
    @FXML private TextField search;

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
        application.accountSelectLogin();
    }


    @FXML
    public void Chest(ActionEvent event) {
        application.userChest();
    }
    @FXML
    public void ShoulderArm(ActionEvent event) {
        application.userShoulderArm();
    }
    @FXML
    public void Back(ActionEvent event) {
        application.userBack();
    }
    @FXML
    public void Hip(ActionEvent event) {
        application.userHip();
    }
    @FXML
    public void Leg(ActionEvent event) {
        application.userLeg();
    }
    @FXML
    public void Other(ActionEvent event) {
        application.userOther();
    }

    @FXML
    public void Search (ActionEvent event) throws Exception {
        if (search.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("please input first!");
            alert.showAndWait();
            return;
        }
        util.GLOBALSEARCH = search.getText();
        Search search=new Search();
        search.showWindow();
    }

    @FXML
    private void CLEAR_M(ActionEvent event) {
        search.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
