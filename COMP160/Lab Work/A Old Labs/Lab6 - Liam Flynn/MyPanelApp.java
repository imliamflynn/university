import java.awt.Color;

public class MyPanelApp{
  
  public static void main(String[]args){
    MyPanel mp1 = new MyPanel();
    mp1.decorate(Color.blue, 180);
    MyPanel mp2 = new MyPanel();
    mp2.decorate(Color.red, 500);
  }
}