import javax.swing.*;
import java.awt.*;

/** Lab 14, Diner.java
  * Liam Flynn, August 2020
  * Draws circle using the data fields set and labels the circle accordignly, representing a diner.
  */

public class Diner{
  private int x;
  private int y;
  private String name;
  private int seatNum;
  private Color colour;
  private final int DIAMETER = 50;
  
  /** Constructor sets data fields accordingly */
  public Diner(int xIn, int yIn, String nameIn, int seatNumIn){
    x = xIn;
    y = yIn;
    name = nameIn;
    seatNum = seatNumIn;
    if(seatNum % 2 == 0) colour = Color.cyan;
    else colour = Color.magenta;
  }
  
  /** Draws the circle/diner and labels the cirlce accordingly */
  public void draw(Graphics g){
    Font big = new Font("Helvetica", Font.PLAIN, 12);
    Font small = new Font("Helvetica", Font.BOLD, 10);
    g.setColor(colour);
    g.fillOval(x, y, DIAMETER, DIAMETER);
    g.setColor(Color.black);
    g.setFont(big);
    g.drawString(name,x+10,y+35);
    g.setFont(small);
    g.drawString(Integer.toString(seatNum),x+22,y+20);
  }
}