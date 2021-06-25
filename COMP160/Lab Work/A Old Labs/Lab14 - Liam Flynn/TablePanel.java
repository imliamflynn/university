import javax.swing.*;
import java.awt.*;

/** Liam Flynn
  * Lab 14
  * Gives the Diner class the values it needs to make the table plan, also draws background and table
  */

public class TablePanel extends JPanel{
  private Diner diner1, diner2, diner3, diner4, diner5, diner6;
  
  /**creates instances of Diner with values*/
  public TablePanel(){
    diner1 = new Diner(125,10,"Yoda",1);
    diner2 = new Diner(205,90,"Luke",2);
    diner3 = new Diner(205,160,"Han",3);
    diner4 = new Diner(125,240,"Darth",4);
    diner5 = new Diner(45,160,"Leia",5);
    diner6 = new Diner(45,90,"Chewy",6);
    setPreferredSize(new Dimension(300,300));
    setBackground(Color.cyan);
  }
  
  /**instructions to draw the circles from the Diner class, also draws table*/
  public void paintComponent(Graphics g){ 
    super.paintComponent(g);
    diner1.draw(g);
    diner2.draw(g);
    diner3.draw(g);
    diner4.draw(g);
    diner5.draw(g);
    diner6.draw(g);
    g.setColor(Color.black);
    g.fillRect(115,80,70,140);
  }
}