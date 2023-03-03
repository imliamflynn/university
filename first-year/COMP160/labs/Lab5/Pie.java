import javax.swing.*;
import java.awt.*;
/**
 Pie.java
 Support class provided for Part 2, Lab5, COMP160 2020 
 */
public class Pie extends JPanel{
  /** constructor method, sets up the Pie panel */
  public Pie(){
    setPreferredSize(new Dimension(300,300));
    setBackground(Color.white);
  }
  
  
  /** all drawing code goes in the paint method, which is called automatically*/
  public void paintComponent (Graphics page){
    super.paintComponent(page);
    final int startx = 50;
    final int starty = 50;
    final int width = 200;
    final int height = width;
    final int angle = 45;
    
    page.setColor(Color.red);
    page.fillArc(startx - 10, starty - 5, width, height, 135, angle);
    
    page.setColor(Color.orange);
    page.fillArc(startx, starty, width, height, 90, angle);
    
    page.setColor(Color.yellow);
    page.fillArc(startx, starty, width, height, 45, angle);
    
    page.setColor(Color.green);
    page.fillArc(startx, starty, width, height, 0, angle);
    
    page.setColor(Color.cyan);
    page.fillArc(startx, starty, width, height, 315, angle);
    
    page.setColor(Color.blue);
    page.fillArc(startx, starty, width, height, 270, angle);
    
    page.setColor(Color.magenta);
    page.fillArc(startx, starty, width, height, 225, angle);
    
    page.setColor(Color.pink);
    page.fillArc(startx, starty, width, height, 180, angle);
    //your pie chart code goes here - you MUST use local variables as described in the lab book
  }
}
