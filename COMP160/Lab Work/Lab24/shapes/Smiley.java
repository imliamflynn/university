package shapes;
import java.awt.*;

/** Lab 24, Smiley.java
  * Liam Flynn, October 2020
  * Uses random number generators to draw different smiley
  */

public class Smiley extends Shape{
  public Smiley(){
    width = 30;
    height = 30;
    x = randomRange(0, max - width);
    y = randomRange(0, max - height);
  }
  
  /** When called, draws a smiley */
  public void display(Graphics g){
    g.setColor(colour);
    g.fillOval(x, y, width, height);
    g.setColor(Color.black);
    g.drawOval(x, y, width, height);
    g.fillOval(x + 7, y + 8, 4, 4);
    g.fillOval(x + 20, y + 8, 4, 4);
    g.drawArc(x + 8, y + 10, 15, 13, 190, 160);
  }
}