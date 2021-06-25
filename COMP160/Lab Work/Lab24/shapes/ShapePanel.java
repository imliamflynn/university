package shapes;
import javax.swing.*; import java.awt.*; import java.awt.event.*; import java.util.ArrayList;

/** Lab 24, ShapePanel.java
  * Liam Flynn, October 2020
  * Gui which draws a new shape when you click buttons
  */

public class ShapePanel extends JPanel{
  private JPanel controlPanel;
  private JButton[] buttons = {new JButton("Circle"), new JButton("Square"), new JButton("Smiley"),
    new JButton("Oval"), new JButton("Swirl"), new JButton("Start"), new JButton("Stop"), new JButton("Remove")};
  private JLabel countLabel = new JLabel("Remove Which?");
  private JTextField showNum;
  private DrawingPanel drawPanel = new DrawingPanel();
  private ArrayList<Shape> shapes = new ArrayList<Shape>();
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
    
    /** Uses a for loop to iterate through the arraylist of Shape objects and draws the shapes */
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      for (int i = 0; i < shapes.size(); i++){
        shapes.get(i).display(g);
        shapes.get(i).showIndex(g,i);
      }
    }
  }
  
  /** Checks if the array is full and if not changes the textfield, adds current Shape object to array,
    * creates a new Shape object, repaints and increases the count */
  private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (e.getSource() == timer){
        for (int i = 0; i < shapes.size(); i ++){
          shapes.get(i).move();
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
          shapes.add(new Circle());
        }
        else if (button.getText().equals("Square")){
          shapes.add(new Square());
        }
        else if (button.getText().equals("Smiley")){
          shapes.add(new Smiley());
        }
        else if (button.getText().equals("Oval")){
          shapes.add(new Oval());
        }
        else if (button.getText().equals("Swirl")){
          shapes.add(new Swirl());
        }
        
        /** Remove button with try and catch statements to prevent the program from crashing */
        else if (button.getText().equals("Remove")){
          try{
            int x = Integer.parseInt(showNum.getText());
            shapes.remove(x);
          }
          catch (NumberFormatException exception){
            System.out.println("That is not do-able");
          }
          catch (IndexOutOfBoundsException exception){
            System.out.println("Out of index range");
          }
        }
      }
      if (shapes.size() == 0){
        showNum.setText(""); //Sets text field to blank if arraylist has nothing in it
      }
      else{
        showNum.setText(Integer.toString(shapes.size()-1)); //Sets text field to highest index of arraylist
      }
      repaint();
    }
  }
}