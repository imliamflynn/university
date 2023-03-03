import javax.swing.*;

/** Lab 14, Diner.java
  * Liam Flynn, August 2020
  * Application class for Diner
  */

public class DinerApp{
  public static void main(String[]args){
    JFrame frame = new JFrame("Diner");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new TablePanel());
    frame.pack();
    frame.setVisible(true);
    
  }
}