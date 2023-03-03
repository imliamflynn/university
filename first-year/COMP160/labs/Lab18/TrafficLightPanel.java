import java.awt.*; import java.awt.event.*; import javax.swing.*;

/** Lab 18, TrafficLightPanel.java
  * Liam Flynn, September 2020
  * Creates a Panel with 3 buttons, and a panel with 3 lights, once one of the buttons is pressed
  * it changes the corresponding light.
  */

public class TrafficLightPanel extends JPanel{
  private JButton redB, orangeB, greenB;
  private JLabel lastPressedLabel;
  private JPanel buttonPanel;
  
  /** Constructor creates the buttons and panels and adds them, also links the button events to the listeners */
  public TrafficLightPanel(){
    redB = new JButton("Red");
    orangeB = new JButton("Orange");
    greenB = new JButton("Green");
    LightPanel light = new LightPanel();
    
    ButtonListener listener = new ButtonListener();
    redB.addActionListener(listener);
    orangeB.addActionListener(listener);
    greenB.addActionListener(listener);
    
    lastPressedLabel = new JLabel("Last pressed");
    
    buttonPanel = new JPanel();
    buttonPanel.setPreferredSize(new Dimension(80,220));
    buttonPanel.setBackground(Color.white);
    buttonPanel.add(redB);
    buttonPanel.add(orangeB);
    buttonPanel.add(greenB);
    //buttonPanel.add(lastPressedLabel);
    
    setPreferredSize(new Dimension(200,230));
    setBackground(Color.gray);
    add(buttonPanel);
    add(light);
  }
  
  /** Listener changes the hidden lastPressedLabel to the corresponding color and refreshes the panel */
  private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      if (event.getSource() == redB){
        lastPressedLabel.setText("Red");
      }
      else if (event.getSource() == orangeB){
        lastPressedLabel.setText("Orange");
      }
      else{
        lastPressedLabel.setText("Green");
      }
      repaint();
    }
  }
  
  /** Draws the off traffic lights and once the panel is refreshed checks what the lastPressedLabel is
    * and redraws the traffic lights accordingly */
  private class LightPanel extends JPanel{
    public LightPanel(){
      setPreferredSize(new Dimension(80,220));
      setBackground(Color.black);
    }
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.darkGray);
      g.fillOval(10,10,60,60);
      g.fillOval(10,80,60,60);
      g.fillOval(10,150,60,60);
      
      if (lastPressedLabel.getText().equals("Red")){
        g.setColor(Color.red);
        g.fillOval(10,10,60,60);
      }
      else if (lastPressedLabel.getText().equals("Orange")){
        g.setColor(Color.orange);
        g.fillOval(10,80,60,60);
      }
      else if (lastPressedLabel.getText().equals("Green")){
        g.setColor(Color.green);
        g.fillOval(10,150,60,60);
      }
    }
  }
}