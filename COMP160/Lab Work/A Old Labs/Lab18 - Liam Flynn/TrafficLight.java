/** Liam Flynn
  * Lab 18
  * Creates the frame for the TrafficLight program
  */

import javax.swing.JFrame;

public class TrafficLight{
  
  public static void main(String[]args){
    JFrame frame = new JFrame("Traffic Light");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    TrafficLightPanel panel = new TrafficLightPanel();
    frame.getContentPane().add(panel);
    
    frame.pack();
    frame.setVisible(true);
  }
}