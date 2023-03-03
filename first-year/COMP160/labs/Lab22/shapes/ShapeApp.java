package shapes;
import javax.swing.JFrame;

/** Lab 21, ShapeApp.java
  * Liam Flynn, September 2020
  * Application class for ShapePanel, adds ShapePanel to the content pane
  */

public class ShapeApp{
  public static void main(String[]args){
    JFrame frame = new JFrame("Shape");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.getContentPane().add(new ShapePanel());
    
    frame.pack();
    frame.setVisible(true);
  }
}