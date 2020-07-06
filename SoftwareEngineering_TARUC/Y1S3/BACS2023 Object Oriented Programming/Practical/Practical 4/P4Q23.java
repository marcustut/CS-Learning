class Student {
  private String studentID;
  private String name;
  private int numQuiz;
  private double totalScore;

  private static double contribQuizScore;

  // Constructors
  public Student() {
    this("", "");
  }

  public Student(String studentID, String name) {
    this.studentID = studentID;
    this.name = name;
  }

  // Getter & Setter
  public String getStudentID() {
    return this.studentID;
  }

  public void setStudentID(String studentID) {
    this.studentID = studentID;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumQuiz() {
    return this.numQuiz;
  }

  public void setNumQuiz(int numQuiz) {
    this.numQuiz = numQuiz;
  }

  public double getTotalScore() {
    return this.totalScore;
  }

  public void setTotalScore(double quizScore) {
    this.totalScore = quizScore;
  }

  // Other methods
  public void addQuiz(int score) {
    this.totalScore += score;
    this.numQuiz++;
  }

  public double getAverageScore() {
    return this.totalScore / this.numQuiz;
  }

  public static void setContribQuiz(double newContribQuizScore) {
    contribQuizScore = newContribQuizScore;
  }

  public double getFinalMarks() {
    return this.totalScore * (Student.contribQuizScore / 100);
  }

}

public class P4Q23 {
  public static void main(String[] args) {
    Student marcus = new Student();
    Student dennis = new Student("19WMR11672", "Liana Ling");
    Student liana = new Student("19WMR11673", "Dennis Lau");

    Student[] students = {marcus, dennis, liana};

    marcus.setName("Marcus Lee");
    marcus.setStudentID("19WMR11671");
    marcus.setNumQuiz(3);
    marcus.setTotalScore(40.5);

    dennis.setNumQuiz(2);
    dennis.setTotalScore(30.7);

    liana.setNumQuiz(4);
    liana.setTotalScore(57.4);

    System.out.println("P4Q2");

    for (Student student : students)
      System.out.printf("\nStudent ID: %s\nStudent Name: %s\nNumber of Quiz Taken: %d\nTotal Score: %.2f\n", student.getStudentID(), student.getName(), student.getNumQuiz(), student.getTotalScore());

    // Doing add quiz
    System.out.println("\nAfter addQuiz()");

    for (Student student : students) {
      student.addQuiz(40);
      System.out.printf("\nStudent ID: %s\nStudent Name: %s\nNumber of Quiz Taken: %d\nTotal Score: %.2f\n", student.getStudentID(), student.getName(), student.getNumQuiz(), student.getTotalScore());
    }

    // Set value for contribQuizScore
    System.out.println("\nP4Q3");

    Student.setContribQuiz(20);

    System.out.println("\nFinal Marks for all Students: ");

    for (Student student : students) 
      System.out.printf("%s - %.2f\n", student.getName(), student.getFinalMarks());
  }
}