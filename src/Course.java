import java.util.LinkedList;
import java.util.List;

public class Course {
    String name;
    int unit;
    int capacity;
    List<Student> registeredStudents;

    public Course(String name, int unit, int capacity) {
        this.name = name;
        this.unit = unit;
        this.capacity = capacity;
        this.registeredStudents = new LinkedList<>();
    }

    void addStudent(Student student) {
        for (Student s : registeredStudents) {
            if(s.username.equals(student.username)){
                return;
            }
        }
        registeredStudents.add(student);
    }
}
