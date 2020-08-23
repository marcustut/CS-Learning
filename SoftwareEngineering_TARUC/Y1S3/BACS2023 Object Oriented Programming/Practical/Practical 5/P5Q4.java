import java.util.regex.*;

class Student {
  private String studentID, name, school;

  public Student() {
    this("", "", "");
  }

  public Student(String studentID, String name, String school) {
    this.studentID = studentID;
    this.name = name;
    this.school = school;
  }

  public static boolean validateStudentID(Student stud) {
    if (Pattern.matches("[a-zA-Z]{1}\\d{4}", stud.studentID) && stud.studentID.substring(1).equals(stud.school)) return true;

    return false;
  }
}

public class P5Q4 {
  public static void main(String[] args) {
    Student stud1 = new Student("A1234", "Lee Kai Yang", "1234");

    System.out.println(Student.validateStudentID(stud1));
  }
}