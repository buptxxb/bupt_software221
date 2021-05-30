package people;

import data_handle.CreateJSON;
import data_handle.GetJSON;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Account{
    public String AccNo;
    public String Password;

    public Account(String AccNo, String Password) {
        this.AccNo = AccNo;
        this.Password = Password;
    }

    // update user's Information
    public void updateInfo(String filename, Account account) {
        String context = class2JSON(account);
        new CreateJSON().createJSON(filename, context);
    }

    // change class to .json file
    public String class2JSON(Account account) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AccNo",account.AccNo);
        jsonObject.put("Password",account.Password);
        return jsonObject.toString();
    }

    // create a new JSON file with a Class

}
