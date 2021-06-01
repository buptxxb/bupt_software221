package GUI;

import data_handle.GetJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.json.JSONObject;
import util.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PasswordModiCoachController implements Initializable {

    private MainPage application;

    @FXML private TextField oldPassword;
    @FXML private TextField newPassword;
    @FXML private TextField newPassword2;

    public void setApp(MainPage application){
        this.application = application;
    }

    @FXML
    public void Confirm(ActionEvent event) {
        if (oldPassword.getText().isEmpty() || newPassword.getText().isEmpty() || newPassword2.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("please check your input");
            alert.showAndWait();
            return;
        }

        String str = "src/data/accountCoach" + util.GLOBALID + ".json";
        String text = new GetJSON().gotStr(str);
        //1.构造一个json对象
        JSONObject obj = new JSONObject(text);
        String password = obj.getString("Password");

        if (!password.equals(oldPassword.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("Old Password Wrong!");
            alert.showAndWait();
            return;
        }
        if(!newPassword.getText().equals(newPassword2.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("Two new password entered are different!");
            alert.showAndWait();
            return;
        }

        obj.put("Password", newPassword.getText());
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(str));// 输出新的json文件
            bw.write(obj.toString());
            bw.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        application.userCoachInfo();
    }

    @FXML
    public void Cancel(ActionEvent event) {
        application.userCoachInfo();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

}