package GUI;

import data_handle.GetJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import people.User;
import util.util;

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

    @FXML
    public void InfoModi(ActionEvent event) {
        application.userInfoModi();
    }

    @FXML
    public void PasswordModi(ActionEvent event) {
        application.userPasswordModi();
    }

    @FXML
    public void Favorite(ActionEvent event) throws Exception {
        Favorite favorite=new Favorite();
        favorite.showWindow();
    }

    public void Choose(ActionEvent event) {
        application.userChoose();
    }


    @FXML
    public void ChargeM(ActionEvent event) {
        application.userChargeM();
    }

    public void Pay(ActionEvent event){

        if(Double.parseDouble(money.getText())<500.00){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText(null);
            alert.setContentText("You don't have enough deposit to pay, please prepay first");
            alert.showAndWait();
        }else {
            String str = "src/data/user" + util.GLOBALID + ".json";
            User user = new GetJSON().createUser(str);
            user.money = Double.parseDouble(money.getText())-500.00;
            user.updateInfo(str);

            application.userUserInfo();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Congratulations! You have become our valued member");
            alert.showAndWait();

            application.userUserInfo();
        }
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
    public Label money;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String str = "src/data/user" + util.GLOBALID + ".json";
        User user = new GetJSON().createUser(str);
        id.setText(String.valueOf(user.id));
        name.setText(String.valueOf(user.name));
        age.setText(String.valueOf(user.age));
        gender.setText(String.valueOf(user.gender));
        birthday.setText(String.valueOf(user.birthday));
        height.setText(String.valueOf(user.height));
        weight.setText(String.valueOf(user.weight));
        money.setText((String.valueOf(user.money)));
    }

}
