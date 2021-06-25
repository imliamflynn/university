/*This pig was drawn by Thomas Verbeek, COMP103 student 2006
 * Pig.java
 * Lab 23, COMP160
 * draws a gorgeous pink pig
 */
package shapes;

import java.awt.*;

public class Pig extends Shape{
  Color shade = new Color(255, 197, 138);
  
  public Pig(){
    height = 29;
    width = 29;
    y = randomRange(0, 400 - height);
    x = randomRange(0, 400 - width);
    
  }
  
  /*sets the colour and draws the shape*/
  public void display(Graphics g){ 
    g.setColor(shade); 
    g.fillRect(x + 5, y + 25, 20, 7);//hind legs
    g.setColor(Color.black);
    g.drawRect(x + 5, y + 25, 20, 7);//hind legs outline
    g.drawLine(x + 5, y + 31, x + 25, y + 31);//hind legs hooves
    
    g.setColor(shade); 
    g.fillRect(x + 8, y + 28, 14, 7);//front legs foreground
    g.setColor(Color.black);
    g.drawRect(x + 8, y + 28, 14, 7);//front legs outline
    g.drawLine(x + 15, y + 28, x + 15, y + 35);//front legs divider
    g.drawLine(x + 8, y + 34, x + 22, y + 34);//front legs hooves
    
    //face---------
    g.setColor(shade); 
    g.fillOval(x, y, 30, 30);//face background color
    g.setColor(Color.black);
    g.drawOval(x, y, 30, 30);//face outline
    
    //ears---------
    //left ear
    g.setColor(shade); 
    g.fillArc(x - 1, y - 3, 15, 15, 150, 90);//left ear
    g.setColor(Color.black);
    g.drawArc(x - 1, y - 3, 15, 15, 150, 90);//left ear outline arc
    g.drawLine(x + 1, y, x + 6, y + 3);//left ear outline line
    //right ear
    g.setColor(shade); 
    g.fillArc(x + 17, y - 4, 15, 15, -60, 90);//right ear
    g.setColor(Color.black);
    g.drawArc(x + 17, y - 4, 15, 15, -60, 90);//right ear outline arc
    g.drawLine(x + 24, y + 4, x + 30, y - 1);//right ear outline line
    
    //eyes---------
    g.fillOval(x + 10, y + 9, 4, 4);//left eye
    g.fillOval(x + 17, y + 9, 4, 4);//right eye
    g.setColor(Color.white);
    g.fillOval(x + 10, y + 9, 1, 1);//left eye twinkle
    g.fillOval(x + 17, y + 9, 1, 1);//right eye twinkle
    
    //snout--------
    g.setColor(Color.black);
    g.drawOval(x + 7, y + 13, 16, 10);//snout outline
    g.fillOval(x + 12, y + 16, 2, 3);//left nostril
    g.fillOval(x + 16, y + 16, 2, 3);//right nostril
  }
}