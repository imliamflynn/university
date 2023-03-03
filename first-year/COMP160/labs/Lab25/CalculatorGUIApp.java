import javax.swing.JFrame;

/** Lab 25, CalculatorGUIApp.java
  * Liam Flynn, October 2020
  * Application class for CalculatorGUIPanel.java
  */

public class CalculatorGUIApp{

/**main method - sets up JFrame*/
  public static void main(String [] args){
    JFrame frame = new JFrame("Calculator");
    frame.setContentPane(new CalculatorGUIPanel());
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

}