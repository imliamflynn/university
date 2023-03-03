package shapes;
import java.awt.*; import java.util.*;

/** Lab 21, Shape.java
  * Liam Flynn, September 2020
  * Uses random number generators to draw different circles
  */

public class Shape{
  private int x, y, width, height, moveX = 1, moveY = 1;
  private Color colour;
  
  /** Constructor sets the datafields using random number generators */
  public Shape(){
    Random generator = new Random();
    width = generator.nextInt(21) + 10;
    height = width;
    x = generator.nextInt(401 - width);
    y = generator.nextInt(401 - height);
    colour = new Color(generator.nextInt(256) ,generator.nextInt(256) ,generator.nextInt(256));
    if (y > 200){
      moveY = -1;
    }
  }
  
  /** When called, draws a circle using the data fields */
  public void display(Graphics g){
    g.setColor(colour);
    g.fillOval(x, y, width, height);
  }
  
  public void move(){
    x += moveX;
    y += moveY;
    //if (width > 15){
    //  y += moveY;
    //}
    //else if (width <= 15){
    //  x += moveX;
    //}
    if (x >= 400 - width){
      moveX = -1;
    }
    else if (x <= 0){
      moveX = 1;
    }
    
    if (y >= 400 - height){
      moveY = -1;
    }
    else if (y <= 0){
      moveY = 1;
    }
    Random generator = new Random();
    colour = new Color(generator.nextInt(256) ,generator.nextInt(256) ,generator.nextInt(256));
    width = generator.nextInt(21) + 10;
    height = width;
  }
}