package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.util;

import java.net.URL;
import java.util.ResourceBundle;

public class ShoulderArmController implements Initializable {

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
    public void Back(ActionEvent event) {
        application.userFinding();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void showVideo1() throws Exception {
        Media media=new Media();
        media.SetVideo("20_Days_Arm_Training" );
        media.showWindow();
    }

    public void showVideo2() throws Exception {
        Media media=new Media();
        media.SetVideo("Forearm_Training" );
        media.showWindow();
    }

    public void showVideo3() throws Exception {
        Media media=new Media();
        media.SetVideo("How_to_Train_Upper_Arm" );
        media.showWindow();
    }

    public void showVideo4() throws Exception {
        Media media=new Media();
        media.SetVideo("Biceps_Bending_Training" );
        media.showWindow();
    }



}