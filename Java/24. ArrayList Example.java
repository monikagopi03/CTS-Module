
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        System.out.println("Enter student names (type 'done' to finish):");
        while (true) {
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("done")) break;
            students.add(name);
        }
        System.out.println("Student List:");
        for (String name : students) {
            System.out.println(name);
        }
    }
}
