import java.util.regex.*;
import java.util.Scanner;

public class P5Q3 {
  private static boolean verifyPassword(String password) {
    if (Pattern.matches("[a-zA-Z0-9]{7,}", password)) return true;

    return false;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Type your password: ");

    String userInput = scanner.nextLine();

    if (verifyPassword(userInput)) System.out.println("Valid Password");
    else System.out.println("Invalid password");

    scanner.close();
  }
}