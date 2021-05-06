package people;

import data_handle.GetJSON;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class User extends People {
    public int[] classID;
    public String coach;
    public User(int id, String name, int age, String gender, String birthday, int height, int weight, int[] classID, String coach) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.classID = classID;
        this.coach = coach;
    }

    public void updateInfo(User user) {
        String filename = "src/data/user1.json";
        createJSON(filename, user);
    }

    // change class to .json file
    public String class2JSON(User user) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",user.id);
        jsonObject.put("name",user.name);
        jsonObject.put("age",user.age);
        jsonObject.put("gender",user.gender);
        jsonObject.put("birthday",user.birthday);
        jsonObject.put("height",user.height);
        jsonObject.put("weight",user.weight);
        jsonObject.put("classID",user.classID);
        jsonObject.put("coach",user.coach);
        return jsonObject.toString();
    }

    // create a new JSON file with a Class
    public void createJSON(String filename, User user) {
        GetJSON getJSON = new GetJSON();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filename));// 输出新的json文件
            bw.write(class2JSON(user));
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


}
