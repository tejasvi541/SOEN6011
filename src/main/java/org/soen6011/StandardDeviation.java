package org.soen6011;

// StandardDeviation.java
public class StandardDeviation {

  // FR3: The function calculates the mean of the input numbers.
  public static double calculateMean(double[] numbers) {
    double sum = 0.0;
    for (double x : numbers) {
      sum += x;
    }
    return sum / numbers.length;
  }

  // FR4: The function calculates the variance of the input numbers.
  public static double calculateVariance(double[] numbers, double mean) {
    double varianceSum = 0.0;
    for (double x : numbers) {
      double diff = x - mean;
      double squaredDiff = diff * diff;
      varianceSum += squaredDiff;
    }
    return varianceSum / numbers.length;
  }

  // Custom square root function according to the heron's squareroot algorithm to avoid using Math.sqrt()
  public static double findSqrt(double x) {
      if (x < 2) {
          return x;
      }
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
  public static double calculateStandardDeviation(double[] numbers) {
    double mean = calculateMean(numbers);
    double variance = calculateVariance(numbers, mean);
    return findSqrt(variance);
  }
}
