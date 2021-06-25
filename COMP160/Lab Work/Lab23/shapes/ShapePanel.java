package shapes;
import javax.swing.*; import java.awt.*; import java.awt.event.*;

/** Lab 23, ShapePanel.java
  * Liam Flynn, October 2020
  * Gui which draws a new shape when you click buttons
  */

public class ShapePanel extends JPanel{
  private JPanel controlPanel;
  private JButton[] buttons = {new JButton("Circle"), new JButton("Square"), new JButton("Smiley"),
    new JButton("Oval"), new JButton("Swirl"), new JButton("Start"), new JButton("Stop")};
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
    for (JButton butt: buttons){
      butt.addActionListener(listener);
      controlPanel.add(butt);
    }
    
    timer = new Timer(DELAY, listener);
    
    controlPanel.add(countLabel);
    controlPanel.add(showNum);
    
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
    public void actionPerformed(ActionEvent e){
      if (e.getSource() == timer){
        for (int i = 0; i < count; i ++){
          shapes[i].move();
        }
      }
      else{
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("Stop")){
          timer.stop();
        }
        else if (button.getText().equals("Start")){
          timer.start();
        }
        else if (button.getText().equals("Circle")){
          if (count < 20){
            int realCount = count + 1;
            showNum.setText(Integer.toString(realCount));
            shapes[count] = new Circle();
            count++;
          }
        }
        else if (button.getText().equals("Square")){
          if (count < 20){
            int realCount = count + 1;
            showNum.setText(Integer.toString(realCount));
            shapes[count] = new Square();
            count++;
          }
        }
        else if (button.getText().equals("Smiley")){
          if (count < 20){
            int realCount = count + 1;
            showNum.setText(Integer.toString(realCount));
            shapes[count] = new Smiley();
            count++;
          }
        }
        else if (button.getText().equals("Oval")){
          if (count < 20){
            int realCount = count + 1;
            showNum.setText(Integer.toString(realCount));
            shapes[count] = new Oval();
            count++;
          }
        }
        else if (button.getText().equals("Swirl")){
          if (count < 20){
            int realCount = count + 1;
            showNum.setText(Integer.toString(realCount));
            shapes[count] = new Swirl();
            count++;
          }
        }
      }
      repaint();
    }
  }
}