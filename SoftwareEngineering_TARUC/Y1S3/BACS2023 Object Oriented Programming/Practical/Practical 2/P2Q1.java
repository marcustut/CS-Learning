class UnitConverter {
  public static final double IN_CM_CONVERSION = 2.54;

  public static double inchToCentimeter(double in) {
    return in*IN_CM_CONVERSION;
  }

  public static double centimeterToInch(double cm) {
    return cm/IN_CM_CONVERSION;
  }
}

public class P2Q1 {
  public static void main(String[] args) {
    // Printing the table headers
    System.out.println("Inches    Centimeters    Centimeters    Inches");

    double x = 5;

    for (double i = 1; i <= 10; i++) {
      System.out.printf("%-9.1f %-14.2f %-14.1f %-2.2f%n", i, UnitConverter.inchToCentimeter(i), x, UnitConverter.centimeterToInch(x));
      x += 5;
    }
  }
}