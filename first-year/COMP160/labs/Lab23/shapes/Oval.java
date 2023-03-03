package shapes;
import java.awt.*;

/** Lab 23, Oval.java
  * Liam Flynn, October 2020
  * Uses random number generators to draw different ovals
  */

public class Oval extends Shape{
  public Oval(){
    height = width * 4;
    y = randomRange(0, max - height);
  }
  
  /** When called, draws a oval */
  public void display(Graphics g){
    g.setColor(colour);
    g.fillOval(x, y, width, height);
  }
}