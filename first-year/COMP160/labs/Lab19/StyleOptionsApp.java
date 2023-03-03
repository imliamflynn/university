import javax.swing.JFrame;

/** Lab 19, StyleOptionsApp.java
  * Liam Flynn, September 2020
  * Demonstrates the use of check boxes
  */

public class StyleOptionsApp{   

//  Creates and presents the program frame.   

public static void main (String[] args)   {     

JFrame frame = new JFrame ("Style Options");     

frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
StyleOptionsPanel panel = new StyleOptionsPanel();     

frame.getContentPane().add (panel);
frame.pack();     

frame.setVisible(true);   

}

}