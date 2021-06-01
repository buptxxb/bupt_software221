package GUI;

import data_handle.GetJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import org.json.JSONObject;
import people.Trainer;
import people.User;
import util.util;

import java.net.URL;
import java.util.ResourceBundle;


public class ChooseController implements Initializable {

    private MainPage application;
    private String Coach = "";
    private String CoachID = "";

    public void setApp(MainPage application){
        this.application = application;
    }

    @FXML
    public void Choose(ActionEvent event) {
        String str = "src/data/user" + util.GLOBALID + ".json";
        User user = new GetJSON().createUser(str);
        user.coach = Coach;
        user.updateInfo(str);

        String text = new GetJSON().gotStr(str);
        //1.构造一个json对象
        JSONObject obj = new JSONObject(text);
        // TODO
        String studentname = obj.getString("name");

        String str2 = "src/data/trainer" +CoachID+ ".json";
        Trainer trainer = new GetJSON().createTrainer(str2);
        String[] strs = new String[trainer.student.length + 1];
        strs[trainer.student.length] = studentname;
        trainer.updateInfo(str2);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("You have select your coach!");
        alert.showAndWait();
    }

    @FXML
    public void UserInfo(ActionEvent event) {
        application.userUserInfo();
    }
         @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void showChoose1() throws Exception {
        Coach = "Johnson";
        CoachID = "1";
    }

    public void showChoose2() throws Exception {
        Coach = "Paul";
        CoachID = "2";
    }
    public void showChoose3() throws Exception {
        Coach = "Yujiro";
        CoachID = "3";
    }
    public void showChoose4() throws Exception {
        Coach = "Queen";
        CoachID = "4";
    }

}
