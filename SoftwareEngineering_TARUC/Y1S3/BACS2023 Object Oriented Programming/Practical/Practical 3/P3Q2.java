public class P3Q2 {
  private static int getIndex(int[] list) {
    int min = list[0];
    int pos = 0;

    for (int i=0; i<list.length; i++) {
      if (list[i] < min) {
        min = list[i];
        pos = i;
      }
    }

    return pos;
  }
  public static void main(String[] args) {
    int[] list = new int[]{1, 2, 4, 5, 10, 100, 2, -22};

    System.out.println(getIndex(list));
  }
}