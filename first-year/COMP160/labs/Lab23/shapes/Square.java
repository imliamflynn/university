package shapes;
import java.awt.*;

/** Lab 23, Square.java
  * Liam Flynn, October 2020
  * Uses random number generators to draw different squares
  */

public class Square extends Shape{
  
  /** When called, draws a square */
  public void display(Graphics g){
    g.setColor(colour);
    g.fillRect(x, y, width, height);
  }
}