package people;

import org.json.JSONObject;

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

}
