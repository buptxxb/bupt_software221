import data_handle.GetJSON;
import people.User;

public class test {
    public static void main(String[] args) {

        //test for like

        GetJSON getJSON = new GetJSON();
        User user = getJSON.createUser("src/data/user1.json");
        int[] videos = user.showLike();
        for (int i : videos) {
//            System.out.println(i);
        }
        user.like(1);
        user.removeLike(10);

    }
}
