import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public abstract class User {
    static List<User> users = new LinkedList<>();
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        addUser(this);
    }

    static void addUser(User user) {
        for (User u : users) {
            if (u.username.equals(user.username)) {
                return;
            }
        }
        users.add(user);
    }

    static User getUserByUsername(String username) {
        for (User u : users) {
            if (u.username.equals(username)) {
                return u;
            }
        }
        return null;
    }

    static boolean checkUsername(String username) {
        for (User u : users) {
            if (u.username.equals(username)) {
                return false;
            }
        }
        return true;
    }

    abstract void menu(Scanner scanner);
}
