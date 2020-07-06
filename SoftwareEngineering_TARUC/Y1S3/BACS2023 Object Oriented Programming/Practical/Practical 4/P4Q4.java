class Course {
  private String courseTitle;
  private double feesPerStudent;
  private int noOfStudents;
  public String[] studentNames = new String[100];

  public static int courseCount;

  // Constructors
  public Course() {
    this("", 0.0);
  }

  public Course(String courseTitle, double feesPerStudent) {
    this.courseTitle = courseTitle;
    this.feesPerStudent = feesPerStudent;
  }

  // Getters and Setters
  public String getCourseTitle() {
    return this.courseTitle;
  }

  public void setCourseTitle(String courseTitle) {
    this.courseTitle = courseTitle;
  }

  public double getFeesPerStudent() {
    return this.feesPerStudent;
  }

  public void setFeesPerStudent(double feesPerStudent) {
    this.feesPerStudent = feesPerStudent;
  }

  public double getNoOfStudents() {
    return this.noOfStudents;
  }

  public void setNoOfStudents(int noOfStudents) {
    this.noOfStudents = noOfStudents;
  }

  public String[] getStudentNames() {
    return this.studentNames;
  }

  public void setStudentNames(String[] studentNames) {
    this.studentNames = studentNames;
  }

  // Other methods
  public double calcFeesCollected() {
    return this.feesPerStudent * this.noOfStudents;
  }

  public void addStudent(String studName) {
    this.studentNames[this.noOfStudents] = studName;
    this.noOfStudents++;
  }

  public String toString() {
    String courseDetails = String.format("Course Title: %s\nCourse Fees(per student): %.2f\nNumber of Students: %d", this.courseTitle, this.feesPerStudent, this.noOfStudents);
    return courseDetails;
  }
}

public class P4Q4 {
  public static void main(String[] args) {
    Course IntroToComputers = new Course("Introduction to Computers", 250.0);

    IntroToComputers.addStudent("Ali Said");
    IntroToComputers.addStudent("Wong Ken");
    IntroToComputers.addStudent("Peter Lim");

    System.out.println(IntroToComputers.toString());
    
    System.out.println("Students Enrolled: ");
    for (int i=0; i < IntroToComputers.getNoOfStudents(); i++) {
      System.out.printf("%d. %s\n", (i+1), IntroToComputers.getStudentNames()[i]);
    }
  }
}