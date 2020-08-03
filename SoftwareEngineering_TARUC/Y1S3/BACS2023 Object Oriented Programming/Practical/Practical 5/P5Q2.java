import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P5Q2 {
  private static final List<Character> vowels = new ArrayList<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

  public static String processStr(String str) {
    String ret = "";

    for (int i=0; i<str.length(); i++) {
      if (vowels.contains(str.charAt(i))) ret += "x";
      else ret += Character.toUpperCase(str.charAt(i));
    }

    return ret;
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String str = scanner.nextLine();

    scanner.close();

    System.out.printf("Modfied string: %s", processStr(str));
  }
}