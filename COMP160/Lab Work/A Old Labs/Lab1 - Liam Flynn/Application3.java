/**
 * Application3.java
 * Example code for Complex Comp160
 * Raymond  August 2006
 * 
 * This is a simple application class that creates and prints some Rectangles
 */

public class Application3 {
  
  /** The main class -- creates and prints some Rectangles */
  public static void main(String [] args) {
    
    // make an array to store 4 Rectangles
    Rectangle3 [] rect = new Rectangle3[4];
    rect[0] = new Rectangle3();
    rect[1] = new Rectangle3(3);
    rect[2] = new Rectangle3(4, 5);
    rect[3] = new Rectangle3(-2); // illegal value! -- sets it to "0"
    
    // Print out some details
    for (int i = 0; i < rect.length; i++) {
      System.out.println("The area of " + rect[i] + " is " + rect[i].getArea());
    }
    
  }
  
}