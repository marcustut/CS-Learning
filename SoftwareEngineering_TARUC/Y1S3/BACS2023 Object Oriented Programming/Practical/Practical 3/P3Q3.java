import java.util.*;

public class P3Q3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Initializing Variables
    int[] denomination = new int[] {100, 50, 20, 10, 5, 1};
    List<Integer> values = new ArrayList<Integer>();

    // Taking Inputs
    System.out.println("Denomination (RM)\tQuantity");

    for (int i : denomination) {
      System.out.printf("%16d %7s", i, ' ');
      values.add(sc.nextInt());
    }

    sc.close();

    // Printing Results
    System.out.println("\nDenomination (RM)\tQuantity\tValue (RM)");

    int total = 0;

    for (int i=0; i<denomination.length; i++) {
      if (values.get(i) != 0) {
        System.out.printf("%16d\t%7d\t%17d%n", denomination[i], values.get(i), denomination[i]*values.get(i));
        total += denomination[i]*values.get(i);
      }
    }

    System.out.printf("Total = RM%d", total);
  }
}