import java.util.Scanner;

public class P1Q2 {
  final static Integer DAYS_PER_YEAR = 365;
  final static Integer HOUR_PER_DAY = 24;
  final static Integer MIN_PER_HOUR = 60;
  final static Integer SEC_PER_HOUR = 60;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter your age (years): ");
    Integer age = sc.nextInt();

    sc.close();

    System.out.printf("Age in years: %d years\nAge in days: %d days\nAge in seconds: %d seconds", age, age*DAYS_PER_YEAR, age*DAYS_PER_YEAR*HOUR_PER_DAY*MIN_PER_HOUR*SEC_PER_HOUR);
  }
}