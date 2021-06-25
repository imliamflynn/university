import javax.swing.*;

/** Liam Flynn
  * Lab 14
  * Application class for Diner class
  */

public class DinerApp{
  public static void main(String[] args){
    JFrame frame = new JFrame ("Seating Plan");
    frame.getContentPane().add(new TablePanel());
    frame.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}