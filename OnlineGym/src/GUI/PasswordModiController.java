package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PasswordModiController implements Initializable {

    private MainPage application;

    public void setApp(MainPage application){
        this.application = application;
    }

    @FXML
    public void Confirm(ActionEvent event) {
        application.userUserInfo();
    }

    @FXML
    public void Cancel(ActionEvent event) {
        application.userUserInfo();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

}