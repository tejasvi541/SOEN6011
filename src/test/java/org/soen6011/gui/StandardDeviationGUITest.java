package org.soen6011.gui;

import static org.junit.Assert.*;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import org.junit.Before;
import org.junit.Test;

public class StandardDeviationGUITest {

  private StandardDeviationGUI gui;
  private JTextField textField;
  private JTextArea textArea;
  private JButton btnCalculate;
  private JButton btnClear;

  @Before
  public void setUp() throws Exception {
    gui = new StandardDeviationGUI();
    SwingUtilities.invokeAndWait(new Runnable() {
      public void run() {
        gui.show();
      }
    });
    textField = (JTextField) TestUtils.getChildNamed(gui.frame, "Number Input Field");
    textArea = (JTextArea) TestUtils.getChildNamed(gui.frame, "Result Display Area");
    btnCalculate = (JButton) TestUtils.getChildNamed(gui.frame, "Calculate Button");
    btnClear = (JButton) TestUtils.getChildNamed(gui.frame, "Clear Button");
  }

  @Test
  public void testInitialize() {
    assertNotNull("TextField should be initialized", textField);
    assertNotNull("TextArea should be initialized", textArea);
    assertNotNull("Calculate button should be initialized", btnCalculate);
    assertNotNull("Clear button should be initialized", btnClear);
  }

  @Test
  public void testCalculateStandardDeviationValidInput() throws Exception {
    SwingUtilities.invokeAndWait(new Runnable() {
      public void run() {
        textField.setText("1, 2, 3, 4, 5");
        btnCalculate.doClick();
      }
    });

    SwingUtilities.invokeAndWait(new Runnable() {
      public void run() {
        String expectedOutput = "Numbers: [1.0, 2.0, 3.0, 4.0, 5.0]\nStandard Deviation: 1.4142135623746899\n\n";
        assertTrue("TextArea should contain calculated result", textArea.getText().contains(expectedOutput));
      }
    });
  }

  @Test
  public void testCalculateStandardDeviationInvalidInput() throws Exception {
    SwingUtilities.invokeAndWait(new Runnable() {
      public void run() {
        textField.setText("a, b, c");
        btnCalculate.doClick();
      }
    });

    SwingUtilities.invokeAndWait(new Runnable() {
      public void run() {
        String expectedOutput = "Invalid/Empty input. Please enter a list of real numbers separated by commas.";
        assertEquals("TextArea should contain error message", expectedOutput, textArea.getText().trim());
      }
    });
  }

  @Test
  public void testClearButton() throws Exception {
    SwingUtilities.invokeAndWait(new Runnable() {
      public void run() {
        textField.setText("1, 2, 3, 4, 5");
        btnCalculate.doClick();
      }
    });

    SwingUtilities.invokeAndWait(new Runnable() {
      public void run() {
        btnClear.doClick();
        assertEquals("TextArea should be cleared", "", textArea.getText());
      }
    });
  }
}
