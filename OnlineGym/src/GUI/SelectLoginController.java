package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectLoginController implements Initializable {

    private MainPage application;

    public void setApp(MainPage application){
        this.application = application;
    }

    public void Finding(ActionEvent event) { application.userFinding(); }

    public void UserLogin(ActionEvent event) { application.accountLoginStudent(); }

    public void CoachLogin(ActionEvent event) { application.accountLoginCoach(); }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
