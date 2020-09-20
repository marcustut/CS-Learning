abstract class AbstractClass {
  int b = 6;

  abstract int getNumber(int x, int y);
}

public class test extends AbstractClass {
  int b = 2;

  test() {
    b = super.b;
  }

  int getNumber(int x, int y) {
    int z = x - y + b;
    System.out.println(z);
    return z;
  }
  public static void main(String[] args) {
    test sub = new test();
    sub.getNumber(7, 3);
  }
}