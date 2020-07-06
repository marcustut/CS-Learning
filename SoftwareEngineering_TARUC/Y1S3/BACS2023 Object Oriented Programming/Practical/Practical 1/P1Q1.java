import java.util.Scanner;

class P1Q1 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter name: ");
      String name = sc.nextLine();

      System.out.print("\nEnter your year of study: ");
      Integer year = Integer.parseInt(sc.nextLine());

      System.out.print("\nWhat is your target GPA for this semester? ");
      Float target = Float.parseFloat(sc.nextLine());

      sc.close();

      System.out.printf("\nWelcome %s!\nWork hard to achieve your target GPA of %.2f this semester of your Year %d ya.", name, target, year);
    }
}