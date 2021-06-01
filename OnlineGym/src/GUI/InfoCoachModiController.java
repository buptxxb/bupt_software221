package GUI;

import data_handle.GetJSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import people.Trainer;
import util.util;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoCoachModiController implements Initializable {

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
        String str = "src/data/trainer" + util.GLOBALID + ".json";
        Trainer trainer = new GetJSON().createTrainer(str);
        trainer.id = id.getText().isEmpty() ? trainer.id : Integer.parseInt(id.getText());
        trainer.name = name.getText().isEmpty() ? trainer.name : name.getText();
        trainer.age = age.getText().isEmpty() ? trainer.age : Integer.parseInt(age.getText());
        trainer.gender = gender.getText().isEmpty() ? trainer.gender : gender.getText();
        trainer.birthday = birthday.getText().isEmpty() ? trainer.birthday : birthday.getText();
        trainer.height = height.getText().isEmpty() ? trainer.height : Integer.parseInt(height.getText());
        trainer.weight = weight.getText().isEmpty() ? trainer.weight : Integer.parseInt(weight.getText());
//        trainer.student =[];
        util.GLOBALNAME = trainer.name;
        trainer.updateInfo(str);
        // {"birthday":"20000605","gender":"M","student":["myh","txl"],"name":"dj","weight":90,"id":1,"age":20,"height":192,"classID":[1,2,3]}

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