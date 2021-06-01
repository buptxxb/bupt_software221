package GUI;

import data_handle.GetJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.json.JSONObject;
import people.User;
import util.util;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChargeController implements Initializable {
    private MainPage application;

    String str = "src/data/user" + util.GLOBALID + ".json";

    Double Money;

    @FXML
    private TextField Amount;

    @FXML
    public void setApp(MainPage application){
        this.application = application;
    }

    @FXML
    public void Hundred1(ActionEvent event){
       Money = 100.00;
    }

    @FXML
    public void Hundred2(ActionEvent event){
       Money = 200+200*0.1;
    }

    @FXML
    public void Hundred5(ActionEvent event){
       Money = 500+500*0.2;
    }

    @FXML
    public void Custom(ActionEvent event){
        if (Amount.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText(null);
            alert.setContentText("You have to input the amount first! Then click this button.");
            alert.showAndWait();
        }
        Money = Double.parseDouble(Amount.getText());
        if (Money >= 500.00) {
            Money = Money + Money * 0.2;
            BigDecimal b = new BigDecimal(Money);
//            Money = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
            Money = b.doubleValue();
            return;
        }
        if (Money >= 200.00) {
            Money = Money + Money * 0.1;
            BigDecimal b = new BigDecimal(Money);
//            Money = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            Money = b.doubleValue();
        }
    }

    @FXML
    public void ChargeM(ActionEvent event){
        if (ifmoneyright()){
            if (Money == 0.0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Prompt");
                alert.setHeaderText(null);
                alert.setContentText("You should choose how much to charge!");
                alert.showAndWait();
                return;
            }
            User user = new GetJSON().createUser(str);
            user.money += Money;
            user.updateInfo(str);

            application.userUserInfo();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("You have enter the amount in format (such as 500.00) or click the button, please re-enter!");
            alert.showAndWait();
        }

    }

    @FXML
    public void Back(ActionEvent event){ application.userUserInfo(); }

    public boolean ifmoneyright(){
        String str = String.valueOf(Money);
        Pattern pattern=Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
        Matcher match=pattern.matcher(str);
        return match.matches();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        User user = new GetJSON().createUser(str);
        // TODO
        Money = 0.0;

    }
}
