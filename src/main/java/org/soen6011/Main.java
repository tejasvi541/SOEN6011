package org.soen6011;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class StandardDeviation {
//    // FR2: The function validates the input to ensure it is a list of real numbers.
//    // FR3: The function calculates the mean of the input numbers.
//    // Changed the inbuilt list implementation to imperative types
//    public static double calculateMean(double[] numbers) {
//        double sum = 0.0;
//        for (double x : numbers) {
//            sum += x;
//        }
//        return sum / numbers.length;
//    }
//
//    // FR4: The function calculates the variance of the input numbers.
//    public static double calculateVariance(double[] numbers, double mean) {
//        double varianceSum = 0.0;
//        for (double x : numbers) {
//            double diff = x - mean;
//            double squaredDiff = diff * diff;
//            varianceSum += squaredDiff;
//        }
//        return varianceSum / numbers.length;
//    }
//
//    // Custom square root function according to the heron's squareroot algorithm to avoid using Math.sqrt()
//    private static double findSqrt(double x) {
//        if (x < 2)
//            return x;
//        double y = x;
//        double z = (y + (x / y)) / 2;
//        while (Math.abs(y - z) >= 0.00001) {
//            y = z;
//            z = (y + (x / y)) / 2;
//        }
//        return z;
//    }
//
//    // FR1: The function accepts a list of real numbers as input.
//    // FR5: The function calculates the standard deviation by taking the square root of the variance.
//    // FR6: The function returns the standard deviation as a real number.
//    public static double calculateStandardDeviation(double[] numbers) {
//        double mean = calculateMean(numbers);
//        double variance = calculateVariance(numbers, mean);
//        return findSqrt(variance);
//    }
//}
//
//class StandardDeviationGUI {
//    private JFrame frame;
//    private JTextField textField;
//    private JTextArea textArea;
//    private double[] numbers;
//    private int index = 0;
//
//    public StandardDeviationGUI() {
//        initialize();
//    }
//
//    private void initialize() {
//        frame = new JFrame();
//        frame.setBackground(Color.getHSBColor(194, 30, 100));
//        frame.setBounds(550, 400, 450, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().setLayout(null);
//        frame.setTitle("Eternity – σ (Standard Deviation)");
//
//        JLabel lblEnterNumbers = new JLabel("Enter Numbers (comma separated):");
//        lblEnterNumbers.setBounds(10, 11, 414, 14);
//        frame.getContentPane().add(lblEnterNumbers);
//
//        textField = new JTextField();
//        textField.setBounds(10, 36, 414, 25);
//        frame.getContentPane().add(textField);
//        textField.setColumns(15);
//
//        JButton btnCalculate = new JButton("Calculate Standard Deviation");
//        btnCalculate.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                try {
//                    String[] numberStrings = textField.getText().split(",");
//                    numbers = new double[numberStrings.length];
//                    for (String numberString : numberStrings) {
//                        numbers[index++] = Double.parseDouble(numberString.trim());
//                    }
//                    double standardDeviation = StandardDeviation.calculateStandardDeviation(numbers);
//                    textArea.setText("Numbers: " + Arrays.toString(numbers) + "\nStandard Deviation: " + standardDeviation);
//                    textField.setText(""); // clear the input
//                } catch (Exception e) {
//                    textArea.setText("Invalid input. Please enter a list of real numbers separated by commas.");
//                    textField.setText("");
//
//                }
//            }
//        });
//        btnCalculate.setBounds(10, 67, 414, 23);
//        frame.getContentPane().add(btnCalculate);
//
//        textArea = new JTextArea();
//        textArea.setBounds(10, 101, 414, 149);
//        frame.getContentPane().add(textArea);
//    }
//
//    public void show() {
//        frame.setVisible(true);
//    }
//}

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StandardDeviationGUI window = new StandardDeviationGUI();
                    window.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}