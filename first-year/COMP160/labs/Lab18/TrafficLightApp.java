import javax.swing.JFrame;

/** Lab 18, TrafficLightApp.java
  * Liam Flynn, September 2020
  * Application class for TrafficLightPanel, creates JFrame instance and calls it Traffic Light
  */

public class TrafficLightApp{
  public static void main(String[]args){
    JFrame frame = new JFrame("Traffic Light");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.getContentPane().add(new TrafficLightPanel());
    
    frame.pack();
    frame.setVisible(true);
  }
}