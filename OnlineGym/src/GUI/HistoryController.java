package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {

    private MainPage application;

    public void setApp(MainPage application){
        this.application = application;
    }

    @FXML
    public void Back(ActionEvent event) {
        application.userUserInfo();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
