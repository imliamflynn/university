/** Liam Flynn
  * Lab 18
  * Creates the components, events and listeners needed for the TrafficLight program
  */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrafficLightPanel extends JPanel{
  private JButton red;
  private JButton orange;
  private JButton green;
  private JLabel last;
  private JPanel buttonPanel;
  
  /** Instantiates the buttons, labels and panels needed for the program. Also uses listeners to make the buttons work*/
  TrafficLightPanel(){
    red = new JButton("Red");
    orange = new JButton("Orange");
    green = new JButton("Green");
    last = new JLabel("Last pressed");
    buttonPanel = new JPanel();
    
    setPreferredSize(new Dimension(200, 300));
    setBackground(Color.white);
    
    buttonPanel.setPreferredSize(new Dimension(80, 290));
    buttonPanel.setBackground(Color.white);
    buttonPanel.add(red);
    buttonPanel.add(orange);
    buttonPanel.add(green);
    //buttonPanel.add(last);
    add(buttonPanel);
    
    ButtonListener listener = new ButtonListener();
    red.addActionListener(listener);
    orange.addActionListener(listener);
    green.addActionListener(listener);
    
    LightPanel light = new LightPanel();
    add(light);
  }
  /** Changes the "last" data field depending on which button is pressed*/
  private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      if (event.getSource() == red){
        last.setText("Red");
        //buttonPanel.setBackground(Color.red);
      }
      if (event.getSource() == orange){
        last.setText("Orange");
        //buttonPanel.setBackground(Color.orange);
      }
      if (event.getSource() == green){
        last.setText("Green");
        //buttonPanel.setBackground(Color.green);
      }
      repaint();
    }
  }
  /** Creates the panel beside the main panel*/
  private class LightPanel extends JPanel{
    public LightPanel(){
      setPreferredSize(new Dimension(80,290));
      setBackground(Color.black);
    }
    /** Creates the lights and changes their colour if the event required happens*/
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.gray);
      g.fillOval(20,30,40,40);
      g.fillOval(20,80,40,40);
      g.fillOval(20,130,40,40);
      if (last.getText().equals("Red")){
        g.setColor(Color.red);
        g.fillOval(20,30,40,40);
      }
      if (last.getText().equals("Orange")){
        g.setColor(Color.orange);
        g.fillOval(20,80,40,40);
      }
      if (last.getText().equals("Green")){
        g.setColor(Color.green);
        g.fillOval(20,130,40,40);
      }
    }
  }
}
