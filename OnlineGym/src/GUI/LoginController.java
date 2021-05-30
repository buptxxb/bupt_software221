package GUI;

import data_handle.GetJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.json.JSONObject;
import people.Account;
import people.User;
import util.util;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML private TextField AccNo;
    @FXML private PasswordField Password;
    @FXML private TextField ID;
    private MainPage application;

    public void setApp(MainPage application){
        this.application = application;
    }

    public void Register(ActionEvent event) { application.accountRegister(); }

    public void Finding(ActionEvent event) { application.userFinding(); }

    public void Login(ActionEvent event) throws IOException {
        if (AccNo.getText().isEmpty() || Password.getText().isEmpty() || ID.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("please check your input");
            alert.showAndWait();
            return;
        }
        String str = "src/data/account" + ID.getText() + ".json";

        if (!new File(str).exists()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("This account does not exist, please register");
            alert.showAndWait();
        }
        String text = new GetJSON().gotStr(str);
        //1.构造一个json对象
        JSONObject obj = new JSONObject(text);
        // TODO
        String password = obj.getString("Password");
        String accNo = obj.getString("AccNo");
        util.GLOBALID = obj.getInt("ID");
        util.GLOBALNAME = obj.getString("AccNo");


        if ((accNo).equals(AccNo.getText()) && ((password).equals(Password.getText()))) {
            application.userFinding();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误提示");
            alert.setHeaderText(null);
            alert.setContentText("AccNo or password error, please re-enter!");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
