package org.soen6011;
import java.util.*;
import java.util.regex.Pattern;

class StandardDeviation {
    // FR2: The function validates the input to ensure it is a list of real numbers.
    // FR3: The function calculates the mean of the input numbers.
    private static double calculateMean(List<Double> numbers) {
        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        return sum / numbers.size();
    }

    // FR4: The function calculates the variance of the input numbers.
    private static double calculateVariance(List<Double> numbers, double mean) {
        double varianceSum = 0.0;
        for (double x : numbers) {
            double diff = x - mean;
            double squaredDiff = diff * diff;
            varianceSum += squaredDiff;
        }
        return varianceSum / numbers.size();
    }

    // Custom square root function according to the heron's squareroot algorithm to avoid using Math.sqrt()
    private static double findSqrt(double x) {
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

    // FR1: The function accepts a list of real numbers as input.
    // FR5: The function calculates the standard deviation by taking the square root of the variance.
    // FR6: The function returns the standard deviation as a real number.
    public static double calculateStandardDeviation(List<Double> numbers) {
        double mean = calculateMean(numbers);
        double variance = calculateVariance(numbers, mean);
        return findSqrt(variance);
    }
}

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<>();
        System.out.println("\nWelcome to the σ Calculator : Eternity Functions");
        System.out.println("________________________________________________");
        while(true){
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
                        // This line adds the elements to numbers array ensuring they are doubles
                        numbers.add(Double.parseDouble(num));
                    }
                    System.out.println("\n" + "Entered Array : " + numbers);
                    System.out.println("\n σ for the elements " + numbers);
                    System.out.print(": " + StandardDeviation.calculateStandardDeviation(numbers));
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