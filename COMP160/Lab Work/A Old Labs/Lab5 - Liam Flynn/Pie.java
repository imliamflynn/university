import javax.swing.*;
import java.awt.*;
/**
 Pie.java
 Support class provided for Part 2, Lab5, COMP160 2019 
 */
public class Pie extends JPanel{
    /** constructor method, sets up the Pie panel */
  public Pie(){
    setPreferredSize(new Dimension(500,500));
    setBackground(Color.white);
  }
 
    
    /** all drawing code goes in the paint method, which is called automatically*/
    public void paintComponent (Graphics page){
      super.paintComponent(page);
      int x = 50;
      int y = 50;
      int size = 400;
      
      page.setColor(Color.red);
      page.fillArc(x+25,y-10,size,size,0,45);
      
      page.setColor(Color.orange);
      page.fillArc(x,y,size,size,45,45);
      
      page.setColor(Color.yellow);
      page.fillArc(x,y,size,size,90,45);
      
      page.setColor(Color.green);
      page.fillArc(x,y,size,size,135,45);
      
      page.setColor(Color.cyan);
      page.fillArc(x,y,size,size,180,45);
      
      page.setColor(Color.blue);
      page.fillArc(x,y,size,size,225,45);
      
      page.setColor(Color.pink);
      page.fillArc(x,y,size,size,270,45);
      
      page.setColor(Color.magenta);
      page.fillArc(x,y,size,size,315,45);
      
      //your pie chart code goes here - you MUST use local variables as described in the lab book
    }
}
