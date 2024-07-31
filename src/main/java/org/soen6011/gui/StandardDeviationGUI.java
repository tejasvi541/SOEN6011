package org.soen6011.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.soen6011.backend.StandardDeviation;

public class StandardDeviationGUI {

  private JFrame frame;
  private JTextField textField;
  private JTextArea textArea;
  private double[] numbers;
  private int index = 0;
  private StringBuilder history = new StringBuilder();

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
    frame.getAccessibleContext().setAccessibleName("Standard Deviation Calculator");
    frame.getAccessibleContext().setAccessibleDescription("A calculator for computing the standard deviation of a series of numbers.");

    JLabel lblEnterNumbers = new JLabel("Enter Numbers (comma separated):");
    lblEnterNumbers.setBounds(10, 11, 414, 14);
    frame.getContentPane().add(lblEnterNumbers);
    lblEnterNumbers.getAccessibleContext().setAccessibleName("Enter Numbers Label");
    lblEnterNumbers.getAccessibleContext().setAccessibleDescription("Label indicating where to enter the numbers for calculation.");

    textField = new JTextField();
    textField.setBounds(10, 36, 414, 25);
    frame.getContentPane().add(textField);
    textField.setColumns(15);
    textField.getAccessibleContext().setAccessibleName("Number Input Field");
    textField.getAccessibleContext().setAccessibleDescription("Input field for entering numbers separated by commas.");

    JButton btnCalculate = new JButton("Calculate Standard Deviation");
    btnCalculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          String[] numberStrings = textField.getText().split(",");
          numbers = new double[numberStrings.length];
          index = 0; // reset the index
          for (String numberString : numberStrings) {
            numbers[index++] = Double.parseDouble(numberString.trim());
          }
          double standardDeviation = StandardDeviation.calculateStandardDeviation(numbers);
          String result =
              "Numbers: " + Arrays.toString(numbers) + "\nStandard Deviation: " + standardDeviation
                  + "\n\n";
          history.append(result); // append the result to the history
          textArea.setText(history.toString()); // display the history
          textField.setText(""); // clear the input
        } catch (Exception e) {
          textArea.setText(
              "Invalid/Empty input. Please enter a list of real numbers separated by commas.");
          textField.setText("");
        }
      }
    });
    btnCalculate.setBounds(10, 67, 414, 23);
    frame.getContentPane().add(btnCalculate);
    btnCalculate.getAccessibleContext().setAccessibleName("Calculate Button");
    btnCalculate.getAccessibleContext().setAccessibleDescription("Button to calculate the standard deviation of the entered numbers.");

    JButton btnClear = new JButton("Clear");
    btnClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        textArea.setText(""); // clear the text area
      }
    });
    btnClear.setBounds(10, 67, 414, 23);
    frame.getContentPane().add(btnClear);
    btnClear.getAccessibleContext().setAccessibleName("Clear Button");
    btnClear.getAccessibleContext().setAccessibleDescription("Button to clear the result display area.");

    textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea); // wrap the text area in a scroll pane
    scrollPane.setBounds(10, 101, 414, 149);
    frame.getContentPane().add(scrollPane); // add the scroll pane to the frame
    textArea.getAccessibleContext().setAccessibleName("Result Display Area");
    textArea.getAccessibleContext().setAccessibleDescription("Area to display the result of the standard deviation calculation.");
  }

  public void show() {
    frame.setVisible(true);
  }
}
