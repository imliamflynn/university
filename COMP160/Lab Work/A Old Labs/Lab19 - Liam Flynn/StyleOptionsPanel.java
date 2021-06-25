/**
 StyleOptionsPanel.java      
 adapted from Java Foundations
 Demonstrates the use of check boxes.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StyleOptionsPanel extends JPanel
{
   private JLabel saying;
   private JCheckBox bold, italic;
   private JRadioButton courier, tnr, helvetica;
   private int style = Font.PLAIN;
   private String typeFace = "Helvetica";

   //-----------------------------------------------------------------
   //  Sets up a panel with a label and some check boxes that
   //  control the style of the label's font.
   //-----------------------------------------------------------------
   public StyleOptionsPanel()
   {
      saying = new JLabel ("Say it with style!");
      saying.setFont (new Font (typeFace, style, 20));

      bold = new JCheckBox ("Bold");
      bold.setBackground (Color.cyan);
      italic = new JCheckBox ("Italic");
      italic.setBackground (Color.cyan);
      
      courier = new JRadioButton("Courier");
      tnr = new JRadioButton("TNR");
      helvetica = new JRadioButton("Helvetica");

      StyleListener listener = new StyleListener();
      bold.addItemListener (listener);
      italic.addItemListener (listener);
      courier.addItemListener (listener);
      tnr.addItemListener (listener);
      helvetica.addItemListener (listener);
      
      add (saying);
      add (bold);
      add (italic);
      add (courier);
      add (tnr);
      add (helvetica);

      setBackground (Color.cyan);
      setPreferredSize (new Dimension(300, 100));
   }

   //*****************************************************************
   //  Represents the listener for both check boxes.
   //*****************************************************************
   private class StyleListener implements ItemListener
   {
      //--------------------------------------------------------------
      //  Updates the style of the label font style.
      //--------------------------------------------------------------
      public void itemStateChanged (ItemEvent event)
      {
         style = Font.PLAIN;

         if (bold.isSelected())
            style = Font.BOLD;

         if (italic.isSelected())
            style += Font.ITALIC;
         
         if (courier.isSelected())
           saying.setFont(new Font("Courier", Font.PLAIN, 8));


         saying.setFont (new Font (typeFace, style, 20));
      }
   }
}
