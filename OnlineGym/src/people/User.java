package people;

import data_handle.CreateJSON;
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
    public User(int id, String name) {
        this(id, name, 0, "Unknown", "0000-00-00", 0, 0, new int[0], "none");
    }

    public void like(int videoID) {
        String fileName = "src/data/like_data/like" + id + ".json";
        List<Integer> list = new GetJSON().createLike(fileName, id);
        if (list.contains(videoID)) return;

        list.add(videoID);
        Collections.sort(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("video", list.toArray());
        new CreateJSON().createJSON(fileName, jsonObject.toString());
    }


    public void removeLike(int videoID) {
        String fileName = "src/data/like_data/like" + id + ".json";
        List<Integer> list = new GetJSON().createLike(fileName, id);

        list.remove((Object)videoID);
        Collections.sort(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("video", list.toArray());
        new CreateJSON().createJSON(fileName, jsonObject.toString());
    }

    public int[] showLike() {
        String filename = "src/data/like_data/like" + id + ".json";
        String jsonStr = new GetJSON().gotStr(filename);
        JSONObject json = new JSONObject(jsonStr);
        int len = json.getJSONArray("video").length();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = json.getJSONArray("video").getInt(i);
        }
        return res;

    }

    public void history(int videoID) {
        String fileName = "src/data/history_data/history" + id + ".json";
        List<Integer> list = new GetJSON().createLike(fileName, id);
        if (list.contains(videoID)) return;

        list.add(videoID);
        Collections.sort(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("video", list.toArray());
        new CreateJSON().createJSON(fileName, jsonObject.toString());
    }

    public int[] showHistory() {
        String filename = "src/data/history_data/history" + id + ".json";
        String jsonStr = new GetJSON().gotStr(filename);
        JSONObject json = new JSONObject(jsonStr);
        int len = json.getJSONArray("video").length();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = json.getJSONArray("video").getInt(i);
        }
        return res;
    }

    public void updateInfo(String filename) {
        String context = class2JSON(this);
        new CreateJSON().createJSON(filename, context);
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
