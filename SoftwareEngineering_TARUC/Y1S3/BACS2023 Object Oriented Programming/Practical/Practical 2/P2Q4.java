class ans {
  public static double sqrt(double x) {
    if (x < 0)
      throw new IllegalArgumentException("Negative values can't be square rooted.");
    else if (x > 1) {
      double lowerLimit = 1;
      double upperLimit = x;
      double midpoint = (lowerLimit + upperLimit)/2;

      // Logic to estimate the square root
      while ((upperLimit - lowerLimit)/lowerLimit > 1.0/108) {
        if ((midpoint*midpoint) > x)
          upperLimit = midpoint;
        else
          lowerLimit = midpoint;

        midpoint = (lowerLimit + upperLimit)/2;
      }

      return midpoint;
    }
    else
      return x;
  }
}

public class P2Q4 {
  public static void main(String[] args) {
    System.out.println(ans.sqrt(16));
  }
}