package GUI;

import data_handle.GetJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import people.User;

import java.net.URL;
import java.util.ResourceBundle;

public class UserInfoController implements Initializable {

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
    public void InfoModi(ActionEvent event) {
        application.userInfoModi();
    }

    @FXML
    public void PasswordModi(ActionEvent event) {
        application.userPasswordModi();
    }

    @FXML
    public Label id;
    public Label name;
    public Label age;
    public Label gender;
    public Label birthday;
    public Label height;
    public Label weight;
    public Label classID;
    public Label coach;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO需要改用户对应的str
        String str = "src/data/user1.json";
        User user = new GetJSON().createUser(str);
        id.setText(String.valueOf(user.id));
        name.setText(String.valueOf(user.name));
        age.setText(String.valueOf(user.age));
        gender.setText(String.valueOf(user.gender));
        birthday.setText(String.valueOf(user.birthday));
        height.setText(String.valueOf(user.height));
        weight.setText(String.valueOf(user.weight));
    }

}
