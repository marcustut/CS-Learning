import java.util.Scanner;

public class P1Q3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter your credit card number(8-digit): ");
    String number = sc.nextLine();

    sc.close();

    // Strip all whitespaces
    number = number.replaceAll("\\s", "");

    // Check if length of input is 8
    if (number.length() != 8) {
      System.out.println("Your credit card number should have 8 digits.");
      return;
    }

    // Checking the first sum
    Integer sum1 = 0, sum2 = 0;

    for (Integer i=number.length()-1; i >= 0; i--) {
      if (i % 2 != 0)
        sum1 += Integer.parseInt(String.valueOf(number.charAt(i)));
      else
        sum2 += Integer.parseInt(String.valueOf(number.charAt(i)));
    }

    // Checking if it's valid
    if ((sum1 + sum2) % 10 == 0)
      System.out.println("valid");
    else {
      System.out.printf("invalid\nThe check digit should be %s", (Integer.parseInt(number.substring(6))) - (sum1+sum2)%10);
    }
  }
}