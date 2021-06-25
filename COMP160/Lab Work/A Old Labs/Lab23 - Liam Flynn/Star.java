/* Star.java
 * Lab 23, COMP160
 * draws a star
 */
package shapes;

import java.awt.*;

public class Star extends Shape{
  Color shade;
  
  public Star(){
    width = 30;
    height = 30;
    y = randomRange(0, 400 - height);
    x = randomRange(0, 400 - width);
    shade = new Color(randomRange(0,255),randomRange(0,255),randomRange(0,255));
  }

  /*sets the colour and draws the shape*/
  public void display(Graphics g){
    
    int countX = 0;
    int countY = 0;
    int [] xPoints = {x+width/2,x+width,x+width/2,x};
    int [] yPoints ={y,y+height/2,y+height,y+height/2};
    //left triangle
    int [] xPLT = {x+11,x+24,x+11};
    int [] yPLT ={y+6,y+15,y+24};
    //righttriangle
    int [] xPRT = {x+6,x+19,x+19};
    int [] yPRT ={y+15,y+6,y+24};
    
    g.setColor(shade);
    g.fillPolygon(xPoints, yPoints,4);
    
    g.setColor(Color.white);
    g.fillPolygon(xPLT, yPLT,3);
    g.fillPolygon(xPRT, yPRT,3);
    g.setColor(Color.black);
    g.fillOval(x+11,y+11,8,8);
  }
}