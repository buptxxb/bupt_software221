package people;

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

}
