import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Student {
    private String name;
    private LocalDate dob;

    public Student(String name, String dobStr) {
        if (dobStr.indexOf('-') == 4) {
            this.dob = LocalDate.parse(dobStr);
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            this.dob = LocalDate.parse(dobStr, formatter);
        }
        this.name = name;
    }

    public void displayInfo() {
        Period age = Period.between(dob, LocalDate.now());
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age.getYears() + " years");
    }
}

class StudentCourses {
    private Map<String, Map<String, Integer>> semesterCourses = new HashMap<>();

    public void addCourse(String semester, String course, int marks) {
        semesterCourses.putIfAbsent(semester, new HashMap<>());
        semesterCourses.get(semester).put(course, marks);
    }

    public void displayCourses() {
        for (String semester : semesterCourses.keySet()) {
            System.out.println("Semester: " + semester);
            Map<String, Integer> courses = semesterCourses.get(semester);
            for (String course : courses.keySet()) {
                System.out.println("Course: " + course + ", Marks: " + courses.get(course));
            }
        }
    }
}

public class StudentApp {
    public static void main(String[] args) {
        Student student = new Student("Alice", "15-08-2003");
        student.displayInfo();

        StudentCourses sc = new StudentCourses();
        sc.addCourse("Semester 1", "Math", 88);
        sc.addCourse("Semester 1", "Physics", 75);
        sc.addCourse("Semester 2", "Chemistry", 90);
        sc.displayCourses();
    }
}
