package people;

import data_handle.GetJSON;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

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

    public void like(String fileName, int videoID) {
        List<Integer> list = new GetJSON().createLike(fileName, id);
        if (list.contains(videoID)) return;

        list.add(videoID);
        Collections.sort(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("video", list.toArray());
        createJSON(fileName, jsonObject.toString());
    }

    public void showLike() {

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



}
