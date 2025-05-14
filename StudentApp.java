import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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

public class StudentApp {
    public static void main(String[] args) {
        Student student = new Student("Alice", "15-08-2003");
        student.displayInfo();
    }
}
