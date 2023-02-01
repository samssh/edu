import java.util.Scanner;

public class Teacher extends User{
    public Teacher(String username, String password) {
        super(username, password);
    }

    @Override
    void menu(Scanner scanner) {
        Main.teacherMenu(scanner,this);
    }
}
