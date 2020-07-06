import java.lang.Math;

public class P2Q3 {
  public static void main(String[] args) {
    System.out.println("Number   SquareRoot");
    for(int i=0; i<=20; i+=2) {
      System.out.printf("%-8d %-3.4f%n", i, Math.sqrt(i));
    }
  }
}