import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("type 1 to create account and type 2 to login. 3 to exit.");
            int option = scanner.nextInt();
            if (option == 1) {
                createUser(scanner);
            }
            if (option == 2) {
                login(scanner);
            }
            if (option == 3) {
                break;
            }
        }
    }

    static void login(Scanner scanner) {
        User user = getUser(scanner);
        if (user == null) {
            return;
        }
        getAndCheckPassword(scanner, user);
        userMenu(scanner, user);
    }

    static User getUser(Scanner scanner) {
        User user = null;
        while (user == null) {
            System.out.println("type your username");
            String username = scanner.next();
            if ("0".equals(username)) {
                return null;
            }
            user = User.getUserByUsername(username);
            if (user == null) {
                System.out.println("username not found. please try again. type 0 to back.");
            }
        }
        return user;
    }

    static String getValidUsername(Scanner scanner) {
        String username = null;
        while (username == null) {
            System.out.println("type your username");
            username = scanner.next();
            if (!User.checkUsername(username)) {
                System.out.println("username already exists. try again");
            }
        }
        return username;
    }

    static void getAndCheckPassword(Scanner scanner, User user) {
        boolean success = false;
        while (!success) {
            System.out.println("type your password");
            String password = scanner.next();
            if (user.password.equals(password)) {
                System.out.println("login success");
                success = true;
            } else {
                System.out.println("password is wrong");
            }
        }
    }

    static void createUser(Scanner scanner) {
        String username = getValidUsername(scanner);
        System.out.println("type your password");
        String password = scanner.next();
        System.out.println("1: teacher\n2: normal student\n3: pardis");
        int type = scanner.nextInt();
        if (type == 1) {
            new Teacher(username, password);
        }
        if (type == 2) {
            new NormalStudent(username, password);
        }
        if (type == 3) {
            new PardisStudent(username, password);
        }
        System.out.println("created successfully");
    }

    static void userMenu(Scanner scanner, User user) {
        user.menu(scanner);
    }

    static void teacherMenu(Scanner scanner, Teacher teacher) {
        while (true) {
            System.out.println("type 3 exit");
            int option = scanner.nextInt();
            if (option == 3) {
                break;
            }
        }
    }

    static void studentMenu(Scanner scanner, Student student) {
        while (true) {
            System.out.println("type 1 to get a course and 2 to change max unit. 3 to exit");
            int option = scanner.nextInt();
            if (option == 1) {

            }
            if (option == 2) {
                System.out.println("type new unit ");
                int newUnits = scanner.nextInt();
                student.setMaxUnits(newUnits);
            }
            if (option == 3){
                break;
            }
        }
    }
}