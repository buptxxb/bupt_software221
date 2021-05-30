package GUI;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.util;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends Application {
    private Stage stage;
    public static List<Socket> clients = new ArrayList<>();//Store all client channels

    public static void main(String[] args) throws Exception{
        MyThread mt1 = new MyThread() ;
        Thread t1 = new Thread(mt1);
        t1.start() ;    // 启动多线程
        launch(args);

    }


    static class MyThread implements Runnable { // 实现Runnable接口，作为线程的实现类
        public void run(){  // 覆写run()方法，作为线程 的操作主体
            //Open a server-side object（开启一个服务器端对象）
            ServerSocket server = null;
            try {
                server = new ServerSocket(8000);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //OPen the server开启服务器
            while(true){
                if (util.GLOBALID != 0) {
                    Socket client= null;	//Accept the client and wait for the client to arrive(接受客户端，等待客户端到来)
                    try {
                        client = server.accept();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("The number of online member：" + clients.size());
                    //Get what the client said and distribute a thread(获取客户端说的话,派发一个线程)
                    ChatServerThread c = new ChatServerThread(client);
                    clients.add(client);
                    c.start();
                }
            }
        }
    }




    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=primaryStage;
        stage.setTitle("Online Gym");
        gotoFinding();
        stage.show();
    }

    public void gotoFinding(){
        try{
            FindingController finding=(FindingController) changeScene("Finding.fxml");
            finding.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoCourse(){
        try{
            CourseController course=(CourseController) changeScene("Course.fxml");
            course.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoChatting(){
        try{
            ChattingController chatting=(ChattingController) changeScene("Chatting.fxml");
            chatting.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoUserInfo(){
        if (util.GLOBALID == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Prompt");
            alert.setHeaderText(null);
            alert.setContentText("please login first");
            alert.showAndWait();
            return;
        }
        try{
            UserInfoController userinfo=(UserInfoController) changeScene("UserInfo.fxml");
            userinfo.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoInfoModi(){
        try{
            InfoModiController infomodi=(InfoModiController) changeScene("InfoModi.fxml");
            infomodi.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoPasswordModi(){
        try{
            PasswordModiController passwordmodi=(PasswordModiController) changeScene("PasswordModi.fxml");
            passwordmodi.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoRegister(){
        try{
            RegisterController Register= (RegisterController) changeScene("Register.fxml");
            Register.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoLogin(){
        try{
            LoginController Login= (LoginController) changeScene("Login.fxml");
            Login.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoFavorite(){
        try{
            FavoriteController Favorite= (FavoriteController) changeScene("Favorite.fxml");
            Favorite.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoHistory(){
        try{
            HistoryController History= (HistoryController) changeScene("History.fxml");
            History.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void gotoSearch(){
        try{
            SearchController Search= (SearchController) changeScene("Search.fxml");
            Search.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void gotoChest(){
        try{
            ChestController Chest= (ChestController) changeScene("Chest.fxml");
            Chest.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void gotoShoulderArm(){
        try{
            ShoulderArmController ShoulderArm= (ShoulderArmController) changeScene("ShoulderArm.fxml");
            ShoulderArm.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void gotoBack(){
        try{
            BackController Back= (BackController) changeScene("Back.fxml");
            Back.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void gotoHip(){
        try{
            HipController Hip= (HipController) changeScene("Hip.fxml");
            Hip.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void gotoLeg(){
        try{
            LegController Leg= (LegController) changeScene("Leg.fxml");
            Leg.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void gotoOther(){
        try{
            OtherController Other= (OtherController) changeScene("Other.fxml");
            Other.setApp(this);
        } catch (Exception ex){
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void userFinding(){
        gotoFinding();
    }

    public void userCourse(){
        gotoCourse();
    }

    public void userChatting(){
        gotoChatting();
    }

    public void userUserInfo(){
        gotoUserInfo();
    }

    public void userInfoModi(){
        gotoInfoModi();
    }

    public void userPasswordModi(){
        gotoPasswordModi();
    }

    public void accountLogin(){gotoLogin();}

    public void accountRegister(){gotoRegister();}

    public void userFavorite(){  gotoFavorite(); }

    public void userHistory(){ gotoHistory(); }

    public void userSearch(){
        gotoSearch();
    }

    public void userChest(){
        gotoChest();
    }

    public void userShoulderArm(){
        gotoShoulderArm();
    }

    public void userBack(){
        gotoBack();
    }

    public void userHip(){
        gotoHip();
    }

    public void userLeg(){
        gotoLeg();
    }

    public void userOther(){
        gotoOther();
    }

    private Initializable changeScene(String fxml)throws Exception{
        FXMLLoader loader= new FXMLLoader();
        InputStream in= MainPage.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainPage.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
}

/**
 * Define a thread class to deal with the communication of a client
 * */
class ChatServerThread extends Thread{
    public Socket socket;
    private String ip;

    public ChatServerThread(Socket socket) {
//        ip = socket.getInetAddress().getHostAddress();
        ip = "user" + util.GLOBALID;
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //Extract information from client(从client里面提取信息)
            InputStream in = socket.getInputStream();
            byte[] b = new byte[1024];
            sendtextAll(ip+ " Landing into the chat room");
            while(true){
                int len = in.read(b);
                int zhuangtai = jiexi(new String(b,0,len));
                if(zhuangtai == 0) {
                    break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public int jiexi(String text) throws IOException {
        if(text.equals("#exit"))
        {
            while(!MainPage.clients.remove(socket));

//            System.out.println("The number of online member：" + MainPage.clients.size());
            sendtextAll(this.ip + " leave the chat room");
            return 0;
        }
        else if(text.charAt(0)=='@') {
            text = text.substring(1);
            int len = text.indexOf("@");
            if(len != -1) {
                sendtext_one(text.substring(len + 1),text.substring(0, len));
            }
        }
        else if(text.charAt(0)!='#')
            sendtextAll(ip +" send: " + text);


        return 1;
    }
    /**
     * make sure IP
     * @param text
     * @param ip
     * @throws IOException
     */
    public void sendtext_one(String text,String ip) throws IOException {
        if(text.length()>0) {
            text = "From " + ip + "：" + text;
            for(int i = 0;i<MainPage.clients.size();i++) {
//                if(MainPage.clients.get(i).getInetAddress().getHostAddress().equals(ip)) {
                    try {
                        MainPage.clients.get(i).getOutputStream().write(text.getBytes());
                        MainPage.clients.get(i).getOutputStream().flush();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    socket.getOutputStream().write("".getBytes());
                    return;
//                }
            }
            //IP not found, message returned, failed to send(没有找到IP，返回消息，发送失败)
            socket.getOutputStream().write("Fail to send. IP cannot find.".getBytes());
        }
    }
    /**
     * Send to all
     * @param text
     */
    public void sendtextAll(String text) {
        System.out.println(text);
        //The server needs to push the word word to each client(服务器需要将word这句话推送给每一个客户端)
        if(text.length()>0)
            for (int i =0;i< MainPage.clients.size();i++) {
                try {
                    MainPage.clients.get(i).getOutputStream().write(text.getBytes());
                    MainPage.clients.get(i).getOutputStream().flush();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
    }
}