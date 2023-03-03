package shapes;
import java.awt.*; import java.util.*;

/** Lab 24, Shape.java
  * Liam Flynn, October 2020
  * Uses random number generators to draw different shapes
  */

public abstract class Shape{
  protected int x, y, width, height, moveX = 1, moveY = 1, max = 401;
  protected Color colour;
  
  /** Constructor sets the datafields using random number generators */
  public Shape(){
    Random generator = new Random();
    width = randomRange(0, 20) + 10;
    height = width;
    x = randomRange(0, max - width);
    y = randomRange(0, max - height);
    colour = new Color(randomRange(0, 255), randomRange(0, 255), randomRange(0, 255));
    if (y > 200){
      moveY = -1;
    }
  }
  
  /** Random range method from lab8 */
  public int randomRange(int low, int high){
    Random generator = new Random();
    return generator.nextInt(high-low+1) + low;
  }
  
  /** When called, draws a circle using the data fields */
  public abstract void display(Graphics g);
  
  public void move(){
    x += moveX;
    y += moveY;
    if (x >= max - width){
      moveX = -1;
    }
    else if (x <= 0){
      moveX = 1;
    }
    
    if (y >= max - height){
      moveY = -1;
    }
    else if (y <= 0){
      moveY = 1;
    }
    colour = new Color(randomRange(0, 255), randomRange(0, 255), randomRange(0, 255));
  }
  
  /** Draws a string just above each shaoe displaying what index that shape has in the arraylist */
  public void showIndex(Graphics g, int i){
    g.setColor(Color.black);
    g.drawString(Integer.toString(i), x, y);
  }
}