package data_handle;

import org.json.JSONArray;
import org.json.JSONObject;
import people.Account;
import people.Trainer;
import people.User;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

import java.util.List;

public class GetJSON {

    // get String from .json file
    public String gotStr(String fileName) {
        String jsonStr = "";
        FileReader fileReader = null;
        Reader reader = null;
        try {
            File jsonFile = new File(fileName);
            fileReader = new FileReader(jsonFile);
            reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }

            fileReader.close();

            jsonStr = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Here is a error in getJSON");
        } finally {
            try {
                reader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return jsonStr;
    }

    public List<Integer> createLike(String fileName, int id) {
        File file = new File(fileName);
        String context;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            context = "{\"id\":"+ id +",\"video\":[]}";
        } else {
            context = new GetJSON().gotStr(fileName);
        }
        JSONObject json = new JSONObject(context);
        List<Integer> list = (List<Integer>)(List)json.getJSONArray("video").toList();

        return list;
    }


    // Create Trainer Object
    public Trainer createTrainer(String fileName) {
        String jsonStr = gotStr(fileName);
        JSONObject json = new JSONObject(jsonStr);
        int len = json.getJSONArray("classID").length();
        // TODO 删掉？
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[i] =  json.getJSONArray("classID").getInt(i);
        }
        int len2 = json.getJSONArray("student").length();
        String[] tmp2 = new String[len];
        for (int i = 0; i < len; i++) {
            tmp2[i] =  json.getJSONArray("student").getString(i);
        }
        Trainer trainer = new Trainer(
                json.getInt("id"),
                json.getString("name"),
                json.getInt("age"),
                json.getString("gender"),
                json.getString("birthday"),
                json.getInt("height"),
                json.getInt("weight"),
                tmp2
        );
        return trainer;
    }

    // Create User Object
    public User createUser(String fileName) {
        String jsonStr = gotStr(fileName);
        JSONObject json = new JSONObject(jsonStr);
        JSONArray jsonArray = new JSONArray();
        int len = json.getJSONArray("classID").length();
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[i] =  json.getJSONArray("classID").getInt(i);
        }
        User user = new User(
                json.getInt("id"),
                json.getString("name"),
                json.getInt("age"),
                json.getString("gender"),
                json.getString("birthday"),
                json.getInt("height"),
                json.getInt("weight"),
                tmp,
                json.getString("coach")
        );
        return user;
    }

    public Account createAccount(String fileName) {
        String jsonStr = gotStr(fileName);
        JSONObject json = new JSONObject(jsonStr);
        JSONArray jsonArray = new JSONArray();
        Account account = new Account(
                json.getString("AccNo"),
                json.getString("Password")
        );
        return account;
    }

}
