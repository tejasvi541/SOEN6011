package org.soen6011.gui;
import static org.junit.Assert.*;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.junit.Before;
import org.junit.Test;

public class StandardDeviationGUITest {

  private StandardDeviationGUI gui;
  private JTextField textField;
  private JTextArea textArea;
  private JButton btnCalculate;
  private JButton btnClear;

  @Before
  public void setUp() {
    gui = new StandardDeviationGUI();
    gui.show();
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
  public void testCalculateStandardDeviationValidInput() {
    textField.setText("1, 2, 3, 4, 5");
    btnCalculate.doClick();

    String expectedOutput = "Numbers: [1.0, 2.0, 3.0, 4.0, 5.0]\nStandard Deviation: 1.4142135623730951\n\n";
    assertTrue("TextArea should contain calculated result", textArea.getText().contains(expectedOutput));
  }

  @Test
  public void testCalculateStandardDeviationInvalidInput() {
    textField.setText("a, b, c");
    btnCalculate.doClick();

    String expectedOutput = "Invalid/Empty input. Please enter a list of real numbers separated by commas.";
    assertEquals("TextArea should contain error message", expectedOutput, textArea.getText().trim());
  }

  @Test
  public void testClearButton() {
    textField.setText("1, 2, 3, 4, 5");
    btnCalculate.doClick();

    btnClear.doClick();
    assertEquals("TextArea should be cleared", "", textArea.getText());
  }
}
