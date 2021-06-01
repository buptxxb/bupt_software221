package data_handle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateJSON {
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
