package org.soen6011.backend;

/**
 * A class that provides methods to calculate the mean, variance, and standard deviation of a list of numbers.
 * @author Tejasvi
 */
public class StandardDeviation {

  /**
   * Calculates the mean of the input numbers.
   * FR3: The function calculates the mean of the input numbers.
   *
   * @param numbers an array of double values representing the input numbers.
   * @return the mean of the input numbers.
   */
  public static double calculateMean(double[] numbers) {
    double sum = 0.0;
    for (double x : numbers) {
      sum += x;
    }
    return sum / numbers.length;
  }

  /**
   * Calculates the variance of the input numbers.
   * FR4: The function calculates the variance of the input numbers.
   *
   * @param numbers an array of double values representing the input numbers.
   * @param mean the mean of the input numbers.
   * @return the variance of the input numbers.
   */
  public static double calculateVariance(double[] numbers, double mean) {
    double varianceSum = 0.0;
    for (double x : numbers) {
      double diff = x - mean;
      double squaredDiff = diff * diff;
      varianceSum += squaredDiff;
    }
    return varianceSum / numbers.length;
  }

  /**
   * Custom square root function using Heron's algorithm to avoid using Math.sqrt().
   *
   * @param x the number to find the square root of.
   * @return the square root of the input number.
   */
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

  /**
   * Calculates the standard deviation of the input numbers.
   * FR1: The function accepts a list of real numbers as input.
   * FR5: The function calculates the standard deviation by taking the square root of the variance.
   * FR6: The function returns the standard deviation as a real number.
   *
   * @param numbers an array of double values representing the input numbers.
   * @return the standard deviation of the input numbers.
   */
  public static double calculateStandardDeviation(double[] numbers) {
    double mean = calculateMean(numbers);
    double variance = calculateVariance(numbers, mean);
    return findSqrt(variance);
  }
}
