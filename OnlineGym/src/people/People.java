package people;

import data_handle.GetJSON;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class People {
    public int id;
    public String name;
    public int age;
    public String gender;
    public String birthday;
    public int height;
    public int weight;

    public People(){}
    public People(int id, String name, int age, String gender, String birthday, int height, int weight) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
    }

    // update user's Information
    public void updateInfo(People people) {
        String filename = "src/data/user1.json";
        createJSON(filename, people);
    }

    // change class to .json file
    public String class2JSON(People people) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",people.id);
        jsonObject.put("name",people.name);
        jsonObject.put("age",people.age);
        jsonObject.put("gender",people.gender);
        jsonObject.put("birthday",people.birthday);
        jsonObject.put("height",people.height);
        jsonObject.put("weight",people.weight);
        return jsonObject.toString();
    }

    // create a new JSON file with a Class
    public void createJSON(String filename,People people) {
        GetJSON getJSON = new GetJSON();
        BufferedWriter bw = null;
        try {
            String ans = getJSON.gotStr(filename);
            bw = new BufferedWriter(new FileWriter("src/data/user2.json"));// 输出新的json文件
            bw.write(class2JSON(people));
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