public class P5Q5 {
  public static void main(String[] args) {
    String name, surname, gender;
    name = gender = surname = "";

    for (String arg : args) {
      String x = "";

      if (!arg.startsWith("[")) {
        for (int i=0; i<arg.length(); i++) {
          x += (i == 0) ? Character.toUpperCase(arg.charAt(i)) : Character.toLowerCase(arg.charAt(i));
        }
      }
      else {
        for (int i=1; i<arg.length()-1; i++) {
          x += (i == 1) ? Character.toUpperCase(arg.charAt(i)) : Character.toLowerCase(arg.charAt(i));
        }
        surname += x;
      }
      
      if (x.equalsIgnoreCase("mr") || x.equalsIgnoreCase("ms")) gender += x;
      else name += x + " ";
    }

    System.out.printf("\nTo: %s\nWishing you a Merry Christmas, %s %s.\n\n", name, gender, surname);
  }
}