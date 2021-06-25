/**
 * Application2.java
 * Sample code for Comp160
 * Raymond  August 2006
 * 
 * This is a simple application class that creates and prints some Rectangles
 */

public class Application2 {
 
  /** The main class -- creates and prints some Rectangles */
  public static void main(String [] args) {
    
    // make some Rectangles
    Rectangle2  rect1 = new Rectangle2();
    Rectangle2  rect2 = new Rectangle2(3);
    Rectangle2  rect3 = new Rectangle2(4,5);
    
    // Print out some details
    System.out.println("The area of " + rect1 + " is " + rect1.getArea());
    System.out.println("The area of " + rect2 + " is " + rect2.getArea());
    System.out.println("The area of " + rect3 + " is " + rect3.getArea());
    
    // Make some changes
    System.out.println();
    System.out.println(rect1 + " has width " + rect1.getWidth());
    rect1.setWidth(12);
    System.out.println(rect1 + " has had the width reset to "  + rect1.getWidth());
  }
  
}