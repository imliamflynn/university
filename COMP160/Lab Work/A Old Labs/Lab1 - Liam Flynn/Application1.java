/**
 * Application1.java
 * Example code for Early classes in Comp160
 * Raymond  August 2006
 * 
 * This is a simple application class that creates and prints some Rectangles
 */

public class Application1 {
 
  /** The main class -- creates and prints some Rectangles */
  public static void main(String [] args) {
    
    // make some Rectangles
    Rectangle1  rect1 = new Rectangle1();
    Rectangle1  rect2 = new Rectangle1();
    Rectangle1  rect3 = new Rectangle1();
    
    // Set some values
    rect1.setWidth(1);
    rect1.setHeight(1);
    rect2.setWidth(3);
    rect2.setHeight(3);
    rect3.setWidth(4);
    rect3.setHeight(5);
    
    // Print out some details
    System.out.println("The area of Rectangle [" + rect1.getWidth() + " x "
                         + rect1.getHeight() + "]  is " + rect1.getArea());
    System.out.println("The area of Rectangle [" + rect2.getWidth() + " x "
                         + rect2.getHeight() + "]  is " + rect2.getArea());
    System.out.println("The area of Rectangle [" + rect3.getWidth() + " x "
                         + rect3.getHeight() + "]  is " + rect3.getArea());
    
  }
  
}