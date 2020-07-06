import java.util.*;

public class P3Q1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    List<Integer> scores = new ArrayList<Integer>();

    // Taking Inputs
    System.out.print("Enter number of quiz scores to process: ");
    int numQuiz = in.nextInt();

    System.out.print("\n");

    for(int i=0; i<numQuiz; i++) {
      System.out.printf("Score %d: ", i+1);
      scores.add(in.nextInt());
    }

    in.close();

    // Logic
    double sum = 0;

    for(double d : scores) {
      sum += d;
    }

    double average = sum/numQuiz;
    int aboveAvg = 0;
    int belowAvg = 0;

    for (double d : scores) {
      if (d >= (sum/numQuiz))
        aboveAvg += 1;
      else 
        belowAvg += 1;
    }

    // Outputing the answer
    System.out.printf("%nResults%n=======%nAverage is %.1f", average);
    System.out.printf("%nNumber of scores above or equal to the average is %d", aboveAvg);
    System.out.printf("%nNumber of scores below the average is %d", belowAvg);
  }
}