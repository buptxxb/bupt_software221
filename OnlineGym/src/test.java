import data_handle.GetJSON;
import people.Trainer;
import people.User;

public class test {
    public static void main(String[] args) {
        //int id, String name, int age, String gender, String birthday, int height, int weight, String[] student
        Trainer trainer = new Trainer(1,"a",1,"","",1,1,new String[0]);
        trainer.addVideo("video1", "arm", "/Users/myh/Desktop/video1.mp4");
    }
}
