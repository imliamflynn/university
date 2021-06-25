import java.awt.*;

/** Liam Flynn
  * Lab 14
  * Diner class, stores all data fields and draws circles once given their position
  */

public class Diner{ 
  private int x;
  private int y;
  private String name;
  private int seatNum;
  private Color colour;
  final private int DIAMETER = 50;
  
  /**constructor sets data field values*/
  public Diner(int x, int y, String name, int seatNum){ 
    this.x = x;
    this.y = y;
    this.name = name;
    this.seatNum = seatNum;
    if (seatNum % 2 == 0){
      colour = Color.gray;
    }
    else{
      colour = Color.white;
    }
  }
  
  /**draws circles and adds the diners seat number and name*/
  public void draw(Graphics g){
    g.setColor(colour);
    g.fillOval(x,y,DIAMETER,DIAMETER);
    g.setColor(Color.black);
    g.setFont(new Font("Courier", Font.PLAIN, 15));
    g.drawString (name, x + 5, y + 30);
    g.setFont(new Font("Courier", Font.PLAIN, 10));
    g.drawString (Integer.toString(seatNum), x + 22, y + 15);
  }
}