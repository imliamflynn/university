package shapes;

import java.awt.*;

/** Lab 24, Swirl.java
  * Liam Flynn, October 2020
  * draws a swirl - a shape drawn of 4 coloured circles clustered around a small black circle, with arc highlights
  */

public class Swirl extends Shape{
  //Color shade;
  
  public Swirl(){
    height = 29; //overall height, for bouncing
    width = 29;  //for bouncing
    y = randomRange(0, 400 - height);
    x = randomRange(0, 400 - width);
    //shade = new Color(randomRange(0,255),randomRange(0,255),randomRange(0,255));
  }
  
  /** sets the colour and draws the shape*/
  public void display(Graphics g){
    int w = 20; //width of 4 small ovals
    int h = 20; //height of 4 small ovals
    int centreX = x+15;
    int centreY = y+15;
    g.setColor(Color.black);
    g.fillOval(centreX-4, centreY-4,8,8);
    //draw 4 ovals
    g.setColor(colour);
    g.fillOval(centreX-w/2, y,w,h); //top
    g.fillOval(centreX-w/2, centreY-(h-15),w,h);//bottom
    g.fillOval(x,centreY-w/2,h,w);//left
    g.fillOval(centreX-(w-15),centreY-w/2,h,w);//right
    //if oval is dark, set colour to yellow for highlights
    if (colour.getRed() < 80 ||  colour.getGreen() < 80 || colour.getBlue() < 80) g.setColor(Color.yellow);
    else g.setColor(Color.black);
    //draw highlights
    g.fillOval(centreX-4, centreY-4,8,8);
    g.drawArc(centreX-w/2, y,w,h,20,200);//top
    g.drawArc(centreX-w/2, centreY-(h-15),w,h,200,200);//bottom
    g.drawArc(x,centreY-w/2,h,w,110,200);//left
    g.drawArc(centreX-(w-15),centreY-w/2,h,w,290,200);//right
  }
}