package org.soen6011;

import java.awt.EventQueue;
import org.soen6011.gui.StandardDeviationGUI;

/**
 * Main Class of the Eternity
 *
 * @author Tejasvi
 * @version 2.2.1
 */
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