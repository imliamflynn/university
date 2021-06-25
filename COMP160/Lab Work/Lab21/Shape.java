import java.awt.*; import java.util.*;

/** Lab 21, Shape.java
  * Liam Flynn, September 2020
  * Uses random number generators to draw different circles
  */

public class Shape{
  private int x;
  private int y;
  private int width;
  private int height;
  private Color colour;
  
  /** Constructor sets the datafields using random number generators */
  public Shape(){
    Random generator = new Random();
    width = generator.nextInt(21) + 10;
    height = width;
    x = generator.nextInt(401);
    y = generator.nextInt(401);
    colour = new Color(generator.nextInt(256) ,generator.nextInt(256) ,generator.nextInt(256));
  }
  
  /** When called, draws a circle using the data fields */
  public void display(Graphics g){
    g.setColor(colour);
    g.fillOval(x, y, width, height);
  }
  
}