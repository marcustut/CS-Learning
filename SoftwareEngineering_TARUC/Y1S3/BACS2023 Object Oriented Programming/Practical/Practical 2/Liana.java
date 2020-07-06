public class Liana {
    public static double sqrt(double number){
        if (number == 0 || number == 1){
            return number;
        }
        
        else {
            double upperLimit = 0, lowerLimit = 0;
            if (number>1){
                upperLimit = number;
                lowerLimit = 1;
            }
           else{
                upperLimit = 1;
                lowerLimit = number;
            }
            
            double midpoint = (upperLimit+lowerLimit)/2.0, sMidpoint = Math.pow(midpoint,2);
            double currentPrecision = (upperLimit-lowerLimit)/lowerLimit;
            final double precisionPass = 1.0e-8;

            while (currentPrecision > 1.0/108){
                if (sMidpoint > number){
                    upperLimit = midpoint;
                }
                else{
                    lowerLimit = midpoint;
                }
                midpoint = (upperLimit+lowerLimit)/2.0;
                sMidpoint = Math.pow(midpoint,2);
                currentPrecision = (upperLimit-lowerLimit)/lowerLimit;
            }
            return midpoint;
        }
        
    }
    
    public static void main(String args[]){
        // double number = 0;
        // double squareRoot = 0;
        
        // while(number < 20){
        //     squareRoot = sqrt(number);
        //     System.out.printf("%-10s", "x = " + number);
        //     System.out.println(squareRoot);
        //     number++;
        // }
    System.out.println(Liana.sqrt(16));

//        squareRoot = sqrt(number);
//        System.out.printf("%-10s", "x = " + number);
//        System.out.printf("%-5.16f %n", squareRoot);
        
    }
}