package GUI;

import data_handle.GetJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class CourseController_student implements Initializable {
    private MainPage application;
    @FXML private TextField Sun1;
    @FXML private TextField Sun2;
    @FXML private TextField Sun3;
    @FXML private TextField Sun4;
    @FXML private TextField Sun5;
    @FXML private TextField Sun6;

    @FXML private TextField Mon1;
    @FXML private TextField Mon2;
    @FXML private TextField Mon3;
    @FXML private TextField Mon4;
    @FXML private TextField Mon5;
    @FXML private TextField Mon6;

    @FXML private TextField Tue1;
    @FXML private TextField Tue2;
    @FXML private TextField Tue3;
    @FXML private TextField Tue4;
    @FXML private TextField Tue5;
    @FXML private TextField Tue6;

    @FXML private TextField Wed1;
    @FXML private TextField Wed2;
    @FXML private TextField Wed3;
    @FXML private TextField Wed4;
    @FXML private TextField Wed5;
    @FXML private TextField Wed6;

    @FXML private TextField Thu1;
    @FXML private TextField Thu2;
    @FXML private TextField Thu3;
    @FXML private TextField Thu4;
    @FXML private TextField Thu5;
    @FXML private TextField Thu6;

    @FXML private TextField Fri1;
    @FXML private TextField Fri2;
    @FXML private TextField Fri3;
    @FXML private TextField Fri4;
    @FXML private TextField Fri5;
    @FXML private TextField Fri6;

    @FXML private TextField Sat1;
    @FXML private TextField Sat2;
    @FXML private TextField Sat3;
    @FXML private TextField Sat4;
    @FXML private TextField Sat5;
    @FXML private TextField Sat6;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String str = "src/data/course"+".json";
        String text = new GetJSON().gotStr(str);
        //1.构造一个json对象
        JSONObject obj = new JSONObject(text);
        Sun1.setText(String.valueOf(obj.getString("Sun1")));
        Sun2.setText(String.valueOf(obj.getString("Sun2")));
        Sun3.setText(String.valueOf(obj.getString("Sun3")));
        Sun4.setText(String.valueOf(obj.getString("Sun4")));
        Sun5.setText(String.valueOf(obj.getString("Sun5")));
        Sun6.setText(String.valueOf(obj.getString("Sun6")));

        Mon1.setText(String.valueOf(obj.getString("Mon1")));
        Mon2.setText(String.valueOf(obj.getString("Mon2")));
        Mon3.setText(String.valueOf(obj.getString("Mon3")));
        Mon4.setText(String.valueOf(obj.getString("Mon4")));
        Mon5.setText(String.valueOf(obj.getString("Mon5")));
        Mon6.setText(String.valueOf(obj.getString("Mon6")));

        Tue1.setText(String.valueOf(obj.getString("Tue1")));
        Tue2.setText(String.valueOf(obj.getString("Tue2")));
        Tue3.setText(String.valueOf(obj.getString("Tue3")));
        Tue4.setText(String.valueOf(obj.getString("Tue4")));
        Tue5.setText(String.valueOf(obj.getString("Tue5")));
        Tue6.setText(String.valueOf(obj.getString("Tue6")));

        Wed1.setText(String.valueOf(obj.getString("Wed1")));
        Wed2.setText(String.valueOf(obj.getString("Wed2")));
        Wed3.setText(String.valueOf(obj.getString("Wed3")));
        Wed4.setText(String.valueOf(obj.getString("Wed4")));
        Wed5.setText(String.valueOf(obj.getString("Wed5")));
        Wed6.setText(String.valueOf(obj.getString("Wed6")));

        Thu1.setText(String.valueOf(obj.getString("Thu1")));
        Thu2.setText(String.valueOf(obj.getString("Thu2")));
        Thu3.setText(String.valueOf(obj.getString("Thu3")));
        Thu4.setText(String.valueOf(obj.getString("Thu4")));
        Thu5.setText(String.valueOf(obj.getString("Thu5")));
        Thu6.setText(String.valueOf(obj.getString("Thu6")));

        Fri1.setText(String.valueOf(obj.getString("Fri1")));
        Fri2.setText(String.valueOf(obj.getString("Fri2")));
        Fri3.setText(String.valueOf(obj.getString("Fri3")));
        Fri4.setText(String.valueOf(obj.getString("Fri4")));
        Fri5.setText(String.valueOf(obj.getString("Fri5")));
        Fri6.setText(String.valueOf(obj.getString("Fri6")));

        Sat1.setText(String.valueOf(obj.getString("Sat1")));
        Sat2.setText(String.valueOf(obj.getString("Sat2")));
        Sat3.setText(String.valueOf(obj.getString("Sat3")));
        Sat4.setText(String.valueOf(obj.getString("Sat4")));
        Sat5.setText(String.valueOf(obj.getString("Sat5")));
        Sat6.setText(String.valueOf(obj.getString("Sat6")));
    }
}

