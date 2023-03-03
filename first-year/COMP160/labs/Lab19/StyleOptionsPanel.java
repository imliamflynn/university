import javax.swing.*; import java.awt.*; import java.awt.event.*;

/** Lab 19, StyleOptionsPanel.java
  * Liam Flynn, September 2020
  * Demonstrates the use of check boxes
  */

public class StyleOptionsPanel extends JPanel{
   private JLabel saying;
   private JCheckBox bold, italic;
   private int style = Font.PLAIN;
   private String typeFace = "Helvetica";
   private JRadioButton cou, tnr, hel;
   private ButtonGroup fonts;
     

   //  Sets up a panel with a label and some check boxes that
   //  control the style of the label's font.

   public StyleOptionsPanel(){
      saying = new JLabel ("Say it with style!");
      saying.setFont (new Font (typeFace, style, 20));

      bold = new JCheckBox ("Bold");
      italic = new JCheckBox ("Italic");
      cou = new JRadioButton("Courier");
      tnr = new JRadioButton("Times New Roman");
      hel = new JRadioButton("Helvetica", true);

      StyleListener listener = new StyleListener();
      bold.addItemListener (listener);
      italic.addItemListener (listener);
      cou.addItemListener(listener);
      tnr.addItemListener(listener);
      hel.addItemListener(listener);

      add (saying);
      add (bold);
      add (italic);
      add(cou);
      add(tnr);
      add(hel);
      
      fonts = new ButtonGroup();
      fonts.add(cou);
      fonts.add(tnr);
      fonts.add(hel);

      setBackground (Color.cyan);
      setPreferredSize (new Dimension(300, 200));
      setLayout(new GridLayout(6,1));
   }

   //  Represents the listener for both check boxes
   
   private class StyleListener implements ItemListener{

      //  Updates the style of the label font style.

      public void itemStateChanged (ItemEvent event){
         style = Font.PLAIN;

         if (bold.isSelected())
            style = Font.BOLD;

         if (italic.isSelected())
            style += Font.ITALIC;
         
         if (cou.isSelected())
           saying.setFont(new Font("Courier",style, 20));
         
         else if (tnr.isSelected())
           saying.setFont(new Font("Times New Roman",style, 20));
         
         else if (hel.isSelected())
           saying.setFont(new Font(typeFace,style, 20));
      }
   }
}