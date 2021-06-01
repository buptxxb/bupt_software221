package GUI;

import data_handle.GetJSON;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import org.json.JSONObject;
import people.User;
import scheduletable.scheduletable;
import javafx.scene.control.TableColumn.CellEditEvent;
import util.util;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class CourseController implements Initializable {

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

    @FXML private TextField studentID;

    public void setApp(MainPage application){
        this.application = application;
    }

    @FXML
    public void Live(ActionEvent event) {
        try {
            String url = "https://www.dingtalk.com/";
             //创建一个URI实例
             URI uri = URI.create(url);
             // getDesktop()返回当前浏览器上下文的 Desktop 实例。
             //Desktop 类允许 Java 应用程序启动已在本机桌面上注册的关联应用程序，以处理 URI 或文件。
             Desktop dp = Desktop.getDesktop();
             //判断系统桌面是否支持要执行的功能
             if(dp.isSupported(Desktop.Action.BROWSE)){
             //启动默认浏览器来显示 URI
             dp.browse(uri);
       }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Check(ActionEvent event){
        String str = "src/data/course"+studentID.getText()+".json";
        String text = new GetJSON().gotStr(str);
        //1.构造一个json对象
        JSONObject obj = new JSONObject(text);
        // TODO
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

    @FXML
    public void Update(ActionEvent event) {
        String str = "src/data/course"+studentID.getText()+".json";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Sun1", Sun1.getText());
        jsonObject.put("Sun2", Sun2.getText());
        jsonObject.put("Sun3", Sun3.getText());
        jsonObject.put("Sun4", Sun4.getText());
        jsonObject.put("Sun5", Sun5.getText());
        jsonObject.put("Sun6", Sun6.getText());

        jsonObject.put("Mon1", Mon1.getText());
        jsonObject.put("Mon2", Mon2.getText());
        jsonObject.put("Mon3", Mon3.getText());
        jsonObject.put("Mon4", Mon4.getText());
        jsonObject.put("Mon5", Mon5.getText());
        jsonObject.put("Mon6", Mon6.getText());

        jsonObject.put("Tue1", Tue1.getText());
        jsonObject.put("Tue2", Tue2.getText());
        jsonObject.put("Tue3", Tue3.getText());
        jsonObject.put("Tue4", Tue4.getText());
        jsonObject.put("Tue5", Tue5.getText());
        jsonObject.put("Tue6", Tue6.getText());

        jsonObject.put("Wed1", Wed1.getText());
        jsonObject.put("Wed2", Wed2.getText());
        jsonObject.put("Wed3", Wed3.getText());
        jsonObject.put("Wed4", Wed4.getText());
        jsonObject.put("Wed5", Wed5.getText());
        jsonObject.put("Wed6", Wed6.getText());

        jsonObject.put("Thu1", Thu1.getText());
        jsonObject.put("Thu2", Thu2.getText());
        jsonObject.put("Thu3", Thu3.getText());
        jsonObject.put("Thu4", Thu4.getText());
        jsonObject.put("Thu5", Thu5.getText());
        jsonObject.put("Thu6", Thu6.getText());

        jsonObject.put("Fri1", Fri1.getText());
        jsonObject.put("Fri2", Fri2.getText());
        jsonObject.put("Fri3", Fri3.getText());
        jsonObject.put("Fri4", Fri4.getText());
        jsonObject.put("Fri5", Fri5.getText());
        jsonObject.put("Fri6", Fri6.getText());

        jsonObject.put("Sat1", Sat1.getText());
        jsonObject.put("Sat2", Sat2.getText());
        jsonObject.put("Sat3", Sat3.getText());
        jsonObject.put("Sat4", Sat4.getText());
        jsonObject.put("Sat5", Sat5.getText());
        jsonObject.put("Sat6", Sat6.getText());

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
        application.coachChatting();
    }

    @FXML
    public void UserInfo(ActionEvent event) {
        application.userCoachInfo();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String str = "src/data/course"+studentID.getText()+".json";
        String text = new GetJSON().gotStr(str);
        //1.构造一个json对象
        JSONObject obj = new JSONObject(text);
        // TODO
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
