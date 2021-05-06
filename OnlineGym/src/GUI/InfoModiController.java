package GUI;

import data_handle.GetJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import people.User;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoModiController implements Initializable {

    private MainPage application;

    @FXML private TextField id;
    @FXML private TextField name;
    @FXML private TextField age;
    @FXML private TextField gender;
    @FXML private TextField birthday;
    @FXML private TextField height;
    @FXML private TextField weight;

    public void setApp(MainPage application){
        this.application = application;
    }

    @FXML
    public void Confirm(ActionEvent event) {
        String str = "src/data/user1.json";
        User user = new GetJSON().createUser(str);
        user.id = id.getText().isEmpty() ? user.id : Integer.parseInt(id.getText());
        user.name = name.getText().isEmpty() ? user.name : name.getText();
        user.age = age.getText().isEmpty() ? user.age : Integer.parseInt(age.getText());
        user.gender = gender.getText().isEmpty() ? user.gender : gender.getText();
        user.birthday = birthday.getText().isEmpty() ? user.birthday : birthday.getText();
        user.height = height.getText().isEmpty() ? user.height : Integer.parseInt(height.getText());
        user.weight = weight.getText().isEmpty() ? user.weight : Integer.parseInt(weight.getText());
        user.createJSON(str, user);

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