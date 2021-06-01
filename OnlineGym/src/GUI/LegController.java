package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LegController implements Initializable {

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
        application.userUserInfo();
    }

    @FXML
    public void Login(ActionEvent event) {
        application.accountSelectLogin();
    }

    @FXML
    public void Search(ActionEvent event) {
        application.userSearch();
    }

    @FXML
    public void Back(ActionEvent event) {
        application.userFinding();
    }

    @FXML
    private ScrollPane scrollPane;

//    @FXML
//    private  void itemMembres(MouseEvent event) throws IOException{
//
//        Node node;
//        node = (Node)FXMLLoader.load(getClass().getResource("/view/MembresTableau.fxml"));
//        scrollPane.setContent();
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void showVideo1() throws Exception {
        Media media=new Media();
        media.SetVideo("video1");
        media.showWindow();
    }

    public void showVideo2() throws Exception {
        Media media=new Media();
        media.SetVideo("video3" );
        media.showWindow();
    }

    public void showVideo3() throws Exception {
        Media media=new Media();
        media.SetVideo("video3" );
        media.showWindow();
    }

    public void showVideo4() throws Exception {
        Media media=new Media();
        media.SetVideo("video3" );
        media.showWindow();
    }



}