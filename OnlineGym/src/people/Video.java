package people;

import data_handle.GetJSON;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Video {
    public int id;
    public String name;
    public String category;
    public int like;

    public Video(){}
    public Video(int id, String name, String category, int like) {
        this.id = id;
        this.name = name;
        this.category= category;
        this.like = like;
    }

    // update user's Information
    public void updateInfo(String filename, Video video) {
        createJSON(filename, video);
    }

    // change class to .json file
    public String class2JSON(Video video) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",video.id);
        jsonObject.put("name",video.name);
        jsonObject.put("category",video.category);
        jsonObject.put("like",video.like);
        return jsonObject.toString();
    }

    // create a new JSON file with a Class
    public void createJSON(String filename,Video video) {
        GetJSON getJSON = new GetJSON();
        BufferedWriter bw = null;
        try {
            String ans = getJSON.gotStr(filename);
            bw = new BufferedWriter(new FileWriter("src/data/video.json"));// 输出新的json文件
            bw.write(class2JSON(video));
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
