package shapes;
import java.awt.*;

/** Lab 23, Circle.java
  * Liam Flynn, October 2020
  * Uses random number generators to draw different circles
  */

public class Circle extends Shape{
  
  /** When called, draws a circle */
  public void display(Graphics g){
    g.setColor(colour);
    g.fillOval(x, y, width, height);
  }
}