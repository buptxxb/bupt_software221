package people;

import data_handle.GetJSON;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Account extends People{
    public String AccNo;
    public String Password;

    public Account(String AccNo, String Password) {

        this.AccNo = AccNo;
        this.Password = Password;
    }

    // update user's Information
    public void updateInfo(String filename, Account account) {
        String context = class2JSON(account);
        createJSON(filename, context);
    }

    // change class to .json file
    public String class2JSON(Account account) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AccNo",account.AccNo);
        jsonObject.put("Password",account.Password);
        return jsonObject.toString();
    }

    // create a new JSON file with a Class
        public void createJSON(String filename, String context) {
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(filename));// 输出新的json文件
                bw.write(context);
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
