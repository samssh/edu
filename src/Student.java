import java.util.List;
import java.util.Scanner;

public abstract class Student extends User {
    List<Course> courses;

    int maxUnits;

    public Student(String username, String password) {
        super(username, password);
        this.maxUnits = 20;
    }

    public void setMaxUnits(int maxUnits) {
        this.maxUnits = maxUnits;
    }

    @Override
    void menu(Scanner scanner) {
        Main.studentMenu(scanner, this);
    }
}
