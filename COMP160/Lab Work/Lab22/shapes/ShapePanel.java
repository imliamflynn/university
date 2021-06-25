package shapes;
import javax.swing.*; import java.awt.*; import java.awt.event.*;

/** Lab 21, ShapePanel.java
  * Liam Flynn, September 2020
  * Gui which draws a new circle when you click a button
  */

public class ShapePanel extends JPanel{
  private JPanel controlPanel;
  private JButton addShape = new JButton("Add Shape"), start = new JButton("Start"), stop = new JButton("Stop");
  private JLabel countLabel = new JLabel("Count");
  private JTextField showNum;
  private DrawingPanel drawPanel = new DrawingPanel();
  private Shape[] shapes = new Shape[20];
  private int count = 0;
  private Timer timer;
  private final int DELAY = 10;
  
  /** Constructor sets up the panels, textfield, label and button listener */
  public ShapePanel(){
    controlPanel = new JPanel();
    controlPanel.setPreferredSize(new Dimension(100, 400));
    
    showNum = new JTextField(2);
    ButtonListener listener = new ButtonListener();
    addShape.addActionListener(listener);
    start.addActionListener(listener);
    stop.addActionListener(listener);
    
    timer = new Timer(DELAY, listener);
    
    controlPanel.add(addShape);
    controlPanel.add(countLabel);
    controlPanel.add(showNum);
    controlPanel.add(start);
    controlPanel.add(stop);
    
    setBackground(Color.gray);
    add(controlPanel);
    add(drawPanel);
  }
  
  /** Panel which is where the circles are drawn */
  private class DrawingPanel extends JPanel{
    public DrawingPanel(){
      setPreferredSize(new Dimension(400, 400));
      setBackground(Color.white);
    }
    
    /** Uses a for loop to iterate through the array of Shape objects and draw the circles */
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      for (int i = 0; i < count; i++){
        shapes[i].display(g);
      }
    }
  }
  
  /** Checks if the array is full and if not changes the textfield, adds current Shape object to array,
    * creates a new Shape object, repaints and increases the count */
  private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      if (event.getSource() == timer){
        for (int i = 0; i < count; i ++){
          shapes[i].move();
        }
      }
      else if (event.getSource() == addShape){
        if (count < 20){
          int realCount = count + 1;
          showNum.setText(Integer.toString(realCount));
          shapes[count] = new Shape();
          count++;
        }
      }
      else if (event.getSource() == stop){
        timer.stop();
      }
      else if (event.getSource() == start){
        timer.start();
      }
      repaint();
    }
  }
}