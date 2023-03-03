package shapes;

import java.awt.*;
/** Pikachu.java
  * COMP160 October 2013
  * Jelena Rakonjac
  * An attempt at making a disembodied Pikachu head shape
  */
public class Pikachu extends Shape{
  
  public Pikachu () {
    width = 30;
    height = width;
    x = randomRange(0, 400 - width);
    y = randomRange(15, 400 - height);
  }
  
  public void display (Graphics g){
    //head base
    g.setColor(Color.yellow);
    g.fillOval(x, y, width, height);
    //left ear base
    int [] xLeft = {x + 1, x + 5, x - 5};
    int [] yLeft = {y + 10, y + 5, y - 10};
    g.fillPolygon(xLeft, yLeft, 3);
    //right ear base
    int [] xRight = {x + 29, x + 25, x + 35};
    int [] yRight = {y + 10, y + 5, y - 10};
    g.fillPolygon(xRight, yRight, 3);
    //left ear tip
    int [] xLeftTip = {x - 3, x - 1, x - 5};
    int [] yLeftTip = {y - 2, y - 4, y - 10};
    g.setColor(Color.black);
    g.fillPolygon(xLeftTip, yLeftTip, 3);
    //right ear tip
    int [] xRightTip = {x + 33, x + 31, x + 35};
    int [] yRightTip = {y - 2, y - 4, y - 10};
    g.fillPolygon(xRightTip, yRightTip, 3);
    //nose
    int [] xNose = {x + 13, x + 17, x + 15};
    int [] yNose = {y + 16, y + 16, y + 18};
    g.fillPolygon(xNose, yNose, 3);
    //mouth
    g.drawArc(x + 11, y + 18, 4, 4, 180, 180);
    g.drawArc(x + 15, y + 18, 4, 4, 180, 180);
    //eyes
    g.fillOval(x + 5, y + 7, 7, 7); //left
    g.fillOval(x + 17, y + 7, 7, 7); //right
    g.setColor(Color.white);
    g.fillOval(x + 6, y + 8, 3, 3); //left
    g.fillOval(x + 18, y + 8, 3, 3); //right
    //cheeks
    g.setColor(Color.red);
    g.fillOval(x + 1, y + 15, 8, 8); //left cheek
    g.fillOval(x + 21, y + 15, 8, 8); //right cheek
    //outline
    g.setColor(Color.black);
    g.drawLine(x + 1, y + 10, x - 5, y - 10); //left ear left side
    g.drawLine(x + 4, y + 4, x - 5, y - 10); //left ear right side
    g.drawLine(x + 29, y + 10, x + 35, y - 10); //right ear right side
    g.drawLine(x + 25, y + 4, x + 35, y - 10); //right ear left side
    g.drawArc(x, y, width, height, 160, 220); //bottom face outline
    g.drawArc(x, y, width, height, 45, 90); //top face outline
  }
    /**changes the location at which the shape would be drawn every time it is called and its color if it touches the edge of the panel*/
  public void move (){ 
    final int EARWIDTH = 5;
    final int EARHEIGHT = 10;
    y += moveY;
    x += moveX;
    if (x < EARWIDTH || x + width > 400 - EARWIDTH) {
      moveX = -moveX;
    }
    if (y < EARHEIGHT || y + height > 400) {
      moveY = -moveY;
    }
  }
  
}