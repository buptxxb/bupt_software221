package people;

import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trainer extends People{
    public String[] student;
    public Trainer(int id, String name, int age, String gender, String birthday, int height, int weight, String[] student) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.student = student;
    }

    public String class2JSON(Trainer trainer) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",trainer.id);
        jsonObject.put("name",trainer.name);
        jsonObject.put("age",trainer.age);
        jsonObject.put("gender",trainer.gender);
        jsonObject.put("birthday",trainer.birthday);
        jsonObject.put("height",trainer.height);
        jsonObject.put("weight",trainer.weight);
        jsonObject.put("student",trainer.student);
        return jsonObject.toString();
    }

    public void addVideo(String videoName, String category, String ResourcePath) {
        String fileName = "src/video/" + videoName + ".mp4";
        Video video = new Video(videoName, category, 0);
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(ResourcePath);
            output = new FileOutputStream(fileName);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, bytesRead);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
                if (output != null) {
                    input.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        String jsonFileName = "src/data/video_data/" + videoName + ".json";
        video.updateInfo(jsonFileName);

    }

    public void setClass() {

    }

}
