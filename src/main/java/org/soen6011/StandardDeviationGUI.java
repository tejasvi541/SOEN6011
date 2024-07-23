package org.soen6011;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StandardDeviationGUI {
    private JFrame frame;
    private JTextField textField;
    private JTextArea textArea;
    private double[] numbers;
    private int index = 0;

    public StandardDeviationGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBackground(Color.lightGray);
        frame.setBounds(550, 400, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setTitle("Eternity – σ (Standard Deviation)");

        JLabel lblEnterNumbers = new JLabel("Enter Numbers (comma separated):");
        lblEnterNumbers.setBounds(10, 11, 414, 14);
        frame.getContentPane().add(lblEnterNumbers);

        textField = new JTextField();
        textField.setBounds(10, 36, 414, 25);
        frame.getContentPane().add(textField);
        textField.setColumns(15);
        JButton btnCalculate = new JButton("Calculate Standard Deviation");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String[] numberStrings = textField.getText().split(",");
                    numbers = new double[numberStrings.length];
                    for (String numberString : numberStrings) {
                        numbers[index++] = Double.parseDouble(numberString.trim());
                    }
                    double standardDeviation = StandardDeviation.calculateStandardDeviation(numbers);
                    textArea.setText("Numbers: " + Arrays.toString(numbers) + "\nStandard Deviation: " + standardDeviation);
                    textField.setText(""); // clear the input
                } catch (Exception e) {
                    textArea.setText("Invalid/Empty input. Please enter a list of real numbers separated by commas.");
                    textField.setText("");

                }
            }
        });
        btnCalculate.setBounds(10, 67, 414, 23);
        frame.getContentPane().add(btnCalculate);
        textArea = new JTextArea();
        textArea.setBounds(10, 101, 414, 149);
        frame.getContentPane().add(textArea);
    }

    public void show() {
        frame.setVisible(true);
    }
}
