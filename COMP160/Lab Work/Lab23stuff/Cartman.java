package shapes;

import java.awt.*;
/** Cartman.java created by Charlie Leeming
  */
public class Cartman extends Shape{
 
  /**Cartman constructor*/
  public Cartman(){
    width = 50;
    height = 40;
    x = randomRange(0, 400 - width);
    y = randomRange(0, 400 - height);
  }//Cartman
 
  /**Draws Cartman and changes his expression depending on his Y axis movement*/
  public void display (Graphics g){
    //head base
    g.setColor(new Color(255, 209, 204));
    g.fillOval(x, y, width, height);
    g.setColor(Color.black);
    g.drawOval(x, y, width, height);
    //eyes
    if(moveY<0){
      g.setColor(Color.white);
      g.fillOval(x+13, y+11, 12, 16);//left
      g.fillOval(x+25, y+11, 12, 16);//right
      g.setColor(Color.black);
      g.drawOval(x+13, y+11, 12, 16);//left outline
      g.drawOval(x+25, y+11, 12, 16);//right outline
      g.fillOval(x+18, y+17, 3, 3);//left pupil
      g.fillOval(x+29, y+17, 3, 3);//right pupil
    } else{
      g.setColor(Color.black);
      g.drawLine(x+13, y+16, x+24, y+19);
      g.drawLine(x+13, y+22, x+24, y+19);
      g.drawLine(x+37, y+16, x+26, y+19);
      g.drawLine(x+37, y+22, x+26, y+19);
    }
    //mouth
    if(moveY<0){
      g.drawArc(x+20, y+26, 10, 6, 190, 160);
    } else{
      g.fillOval(x+20, y+26, 10, 8);
    }
    //chin
    g.drawArc(x+10, y+27, 30, 10, 190, 160);
    //hat
    g.setColor(Color.yellow);
    g.fillArc(x+5, y+6, 40, 8, 200, -220);//lining
    g.fillOval(x+20, y-8, 10, 10);//puff
    g.setColor(Color.black);
    g.drawOval(x+20, y-8, 10, 10);//outline puff
    g.setColor(Color.cyan);
    g.fillArc(x+3, y-1, 44, 20, 190, -200);//main hat
    g.setColor(Color.black);
    g.drawArc(x+3, y-1, 44, 20, 190, -200);//outline hat
  }//display
 
  /**Moves X and Y position of Cartman*/
  public void move(){
    if(x >= 400-width || x <= 0){
      moveX = -moveX;
    }
    if(y >= 400-height || y-8 <= 0){
      moveY = -moveY;
    }//bounce
    x += moveX;
    y += moveY;
  }//move
}