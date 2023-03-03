import java.awt.Color;

/**  
 * Lab 6 MyPanelApp.java
 * COMP160 July 2020
 * Application class for MyPanel
 */

public class MyPanelApp{
  
  public static void main(String[] args){
    MyPanel mp1 = new MyPanel();
    mp1.decorate(Color.blue, 180);
    MyPanel mp2 = new MyPanel();
    mp2.decorate(Color.red, 360);
  }
}