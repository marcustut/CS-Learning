class Average {
  public static int calculateAverage(int x, int y) {
    return (x+y)/2;
  }

  public static int calculateAverage(int x, int y, int z) {
    return (x+y+z)/3;
  }

  public static double calculateAverage(double x, double y) {
    return (x+y)/2;
  }

  public static double calculateAverage(double x, double y, double z) {
    return (x+y+z)/3;
  }
}

public class P2Q2 {
  public static void main(String[] args) {
    System.out.printf("calculateAverage with 2 integer(x=1, y=2): %s%n", Average.calculateAverage(1, 2));
    System.out.printf("calculateAverage with 3 integer(x=1, y=2, z=3): %s%n", Average.calculateAverage(1, 2, 3));
    System.out.printf("calculateAverage with 2 double(x=1.0, y=2.0): %s%n", Average.calculateAverage(1.0, 2.0));
    System.out.printf("calculateAverage with 3 double(x=1.0, y=2.0, z=3.0): %s%n", Average.calculateAverage(1.0, 2.0, 3.0));
  }
}