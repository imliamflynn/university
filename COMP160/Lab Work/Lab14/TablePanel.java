import javax.swing.*;
import java.awt.*;

/** Lab 14, Diner.java
  * Liam Flynn, August 2020
  * Calls the draw method on each Diner object, passing it a reference to its Graphics
  * objects so that Diner can draw itself in the JPanel graphics context
  */

public class TablePanel extends JPanel{
  private Diner diner1, diner2, diner3, diner4, diner5, diner6;
  
  /** Creates instances of Diner and sets the data fields */
  public TablePanel(){
    diner1 = new Diner(125,35,"Yoda",1);
    diner2 = new Diner(180,95,"Luke",2);
    diner3 = new Diner(180,155,"Han",3);
    diner4 = new Diner(125,215,"Darth",4);
    diner5 = new Diner(70,155,"Leia",5);
    diner6 = new Diner(70,95,"Chewy",6);
    setPreferredSize(new Dimension(300,300));
    setBackground(Color.white);
  }
  
  /** Draws circles/diners using each instance of Diner and also draws table */
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    diner1.draw(g);
    diner2.draw(g);
    diner3.draw(g);
    diner4.draw(g);
    diner5.draw(g);
    diner6.draw(g);
    g.setColor(Color.black);
    g.fillRect(125, 90, 50, 120);
  }
}