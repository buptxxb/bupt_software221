package people;

import data_handle.CreateJSON;
import data_handle.GetJSON;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Video {
    public String name;
    public String category;
    public int likeCount;

    public Video(){}
    public Video(String name, String category, int likeCount) {
        this.name = name;
        this.category= category;
        this.likeCount = likeCount;
    }

    // update Information
    public void updateInfo(String filename) {
        String context = class2JSON();
        new CreateJSON().createJSON(filename, context);
    }

    // change class to .json file
    public String class2JSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",this.name);
        jsonObject.put("category",this.category);
        jsonObject.put("likeCount",this.likeCount);
        return jsonObject.toString();
    }
}
