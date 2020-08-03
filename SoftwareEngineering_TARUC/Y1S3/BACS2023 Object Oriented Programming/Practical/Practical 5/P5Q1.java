import java.util.Scanner;

public class P5Q1 {
  public static int countLetter(String str, char ch) {
    int count = 0;

    for (int i=0; i<str.length(); i++) {
      if (str.charAt(i) == ch) count++;
    }

    return count;
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a word: ");
    String word = scanner.nextLine();

    System.out.print("Enter the letter you want to count: ");
    char letter = scanner.next().charAt(0);

    scanner.close();

    System.out.printf("%s contains %d%s", word, countLetter(word, letter), letter);
  }
}