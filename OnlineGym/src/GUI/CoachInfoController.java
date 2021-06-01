package GUI;

import data_handle.GetJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import people.Trainer;
import util.util;

import java.net.URL;
import java.util.ResourceBundle;

public class CoachInfoController implements Initializable {

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
        application.userCoachInfo();
    }

    @FXML
    public void InfoModi(ActionEvent event) {
        application.userInfoCoachModi();
    }

    @FXML
    public void List(ActionEvent event) {

    }

    @FXML
    public void PasswordModi(ActionEvent event) {
        application.userPasswordCoachModi();
    }

    @FXML
    public Label id;
    public Label name;
    public Label age;
    public Label gender;
    public Label birthday;
    public Label height;
    public Label weight;

    public Label coach;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO需要改用户对应的str
        String str = "src/data/trainer" + util.GLOBALID + ".json";
        Trainer trainer = new GetJSON().createTrainer(str);
        id.setText(String.valueOf(trainer.id));
        name.setText(String.valueOf(trainer.name));
        age.setText(String.valueOf(trainer.age));
        gender.setText(String.valueOf(trainer.gender));
        birthday.setText(String.valueOf(trainer.birthday));
        height.setText(String.valueOf(trainer.height));
        weight.setText(String.valueOf(trainer.weight));
        //TODO

    }

}
