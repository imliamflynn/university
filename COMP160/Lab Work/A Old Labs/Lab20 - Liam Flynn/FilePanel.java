/** FilePanel.java
 * Lab 20, COMP160,  2019
 *
 * a JPanel which creates 2 instances of Rectangle objects,
 * stores them in an array, and draws them
 */

import java.awt.*;
import javax.swing.*;

public class FilePanel extends JPanel{
  private Rectangle[] drawObjects = new Rectangle [10];
  private int count;
 
 
  /**constructor instantiates 6 Rectangle objects*/
  public FilePanel(){ 
    drawObjects[count] = new Rectangle(true,Color.red, 0, 0,30,30);
    count++;
    drawObjects[count] = new Rectangle(false,Color.blue, 50, 50,30,30);
    count++;
    setPreferredSize(new Dimension(300,300));
    setBackground(Color.yellow);
  }
 
  /**each Rectangle will draw itself*/
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    for(int i = 0; i < count; i++){
      drawObjects[i].draw(g);
    }
  }
}