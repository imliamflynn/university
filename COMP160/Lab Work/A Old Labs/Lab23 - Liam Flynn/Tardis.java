package shapes;

import java.awt.*;

/** Makes the Doctor's time machine 
 * Tardis.java extends Shape
 * Tegan Garland
 * COMP 160 October 2012
 */
public class Tardis extends Shape {
  
  /** Constructor */
  public Tardis(){
    width = 30;
    height = 50;
    x = super.randomRange(13, 400);
    y = super.randomRange(0,400-height);
  }
  
  /** draws the Tardis to the screen */
  public void display (Graphics g){
    g.setColor(Color.blue);
    g.fillRect(x,y,width,height); //main body
    g.setColor(Color.black);
    g.drawRect(x,y,width, height);
    g.setColor(Color.blue);
    
    g.fillArc(x-6, y-25, width+12,30,210,120);//roof
    g.fillRect(x-3, y-3, width+6, 3);//police box
    g.fillRect(x-3, y+50, width+6, 6); //lintel
    
    g.setColor(Color.white);
    g.fillRect(x+5, y+4, 7, 10); // left window
    g.fillRect(x+18, y+4, 7, 10); // right window
    g.fillRect(x+7, y+22, 3, 5); //sign
    
    g.setColor(Color.black);
    g.drawRect(x+4, y+19, 7, 10); //top left panel
    g.drawRect(x+17, y+19, 7, 10); //top right panel
    g.drawRect(x+4, y+34, 7, 10); //bottom left panel
    g.drawRect(x+17, y+34, 7, 10); //bottom right panel
    
    g.drawRect(x+5, y+4, 7, 10); // left window outline
    g.drawRect(x+18, y+4, 7, 10); // right window outline
    g.drawRect(x-3, y+50, width+6, 6); // lintel outline
    g.drawRect(x-3, y-3, width+6, 3); //police box outline
    g.drawLine(x-2, y-3, x+15, y-10); //roof outline
    g.drawLine(x+15, y-10, x+34, y-3); // roof outline
    
    g.setColor(Color.white);
    g.fillRect(x+12, y-15, 6, 8); //light
    g.setColor(Color.black);
    g.drawRect(x+12, y-15, 6, 8); //light outline
  }
  
  /** moves the shape by moveX and moveY. if it hits the edge of the JPanel, it reverses direction */
  public void move(){
    x += moveX;
    y += moveY;
    if (x <= 0 || x >= 400 - width){ 
      moveX = -moveX;
    }
    if (y <= 0 || y >= 400 - height){
      moveY = -moveY;
    }
  }
  
}
