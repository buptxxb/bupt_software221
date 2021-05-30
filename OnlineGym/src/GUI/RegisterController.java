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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    private MainPage application;

    @FXML private TextField AccNo;
    @FXML private PasswordField Password;
    @FXML private TextField ID;

    public void Return(ActionEvent event){application.accountLogin();}

    public void Finding(ActionEvent event){application.userFinding();}

    public void Register(ActionEvent event) {
        if (AccNo.getText().isEmpty()&&Password.getText().isEmpty()&&ID.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("AccNo, password and ID is empty, please enter them");
            alert.showAndWait();
        }
        else if (AccNo.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("AccNo is empty, please enter it");
            alert.showAndWait();
        }
        else if (Password.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("Password is empty, please enter it");
            alert.showAndWait();
        }
        else if (ID.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("ID is empty, please enter it");
            alert.showAndWait();
        }
        // TODO
        String str = "src/data/user"+ ID.getText() +".json";
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("ID", ID.getText());
        jsonObject.put("AccNo", AccNo.getText());
        jsonObject.put("Password", Password.getText());



        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(str));// 输出新的json文件
            bw.write(jsonObject.toString());
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


        Account account = new GetJSON().createAccount(str);
        account.AccNo = AccNo.getText().isEmpty() ? account.AccNo : AccNo.getText();
        account.Password = Password.getText().isEmpty() ? account.Password : Password.getText();

        account.updateInfo(str, account);

        application.userUserInfo();
    }

    public void setApp(MainPage application){
        this.application = application;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
