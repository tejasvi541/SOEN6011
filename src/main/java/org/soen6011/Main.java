package org.soen6011;
import java.util.*;
import java.util.regex.Pattern;

class StandardDeviation {
    public static double findSqrt(double x)
    {
        if (x < 2)
            return x;
        double y = x;
        double z = (y + (x / y)) / 2;
        while (Math.abs(y - z) >= 0.00001) {
            y = z;
            z = (y + (x / y)) / 2;
        }
        return z;
    }
    public static double calculateStandardDeviation(List<Double> numbers) {
        double sum = 0.0;
        int N = numbers.size();
        for (double x : numbers) {
            sum += x;
        }
        double mu = sum / N;
        double varianceSum = 0.0;
        for (double x : numbers) {
            double diff = x - mu;
            double squaredDiff = diff * diff;
            varianceSum += squaredDiff;
        }
        double variance = varianceSum / N;

        // Calculate standard deviation by taking square root of variance
        double sigma = findSqrt(variance);

        return sigma;
    }
}

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<>();
        while(true){
            System.out.println("\nWelcome to the σ Calculator : Eternity Functions");
            System.out.println("""
                    Enter the number to select following options
                    1. Enter the elements to get their Standard Deviation.
                    2. Exit the program.
                    """);
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("""
                            Enter the elements ("," Seperated)""");
                    String elements = sc.nextLine();
                    for(String num:elements.split(",")){
                        numbers.add(Double.parseDouble(num));
                    }
                    System.out.println(numbers);
                    System.out.println("\n σ for the elements " + numbers + "\n");
                    System.out.println(": " + StandardDeviation.calculateStandardDeviation(numbers));
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please try again with valid inputs");
            }
        }

    }
}