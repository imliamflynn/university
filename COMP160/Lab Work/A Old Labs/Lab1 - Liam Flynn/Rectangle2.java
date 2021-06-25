/**
 * Rectangle2.java
 * Example code for Comp160
 * Raymond:  August 2006
 * 
 * This class creates and stores information about Rectangles
 */

public class Rectangle2 {
  
  //datafields
  private int width;       // stores the width of this Rectangle
  private int height;      // stores the height of this Rectangle
  
  
  /* ---- CONSTRUCTORS ---- */

  /** Make a default rectangle: set width and height to 1 */
  public Rectangle2() {
    width = height = 1;
  }
  
  /** Make a 'Square' -- a Rectangle where width == height */
  public Rectangle2(int size) {
    width = height = size;
  }
  
  /** Make a Rectangle of the required size */
  public Rectangle2(int w, int h) {
    width = w;
    height = h;
  }
  
  
  /* ---- SETTERS (mutators, modifiers) ---- */

  /** Set the width of the Rectangle to a new value */
  public void setWidth(int newWidth) {
    width = newWidth;
  }

  /** Set the height of the Rectangle to a new value */
  public void setHeight(int newHeight) {
    height = newHeight;
  }
  
  
  /* ---- GETTERS (accessors) ---- */
  
  /** Get the width of this Rectangle */
  public int getWidth() {
    return width;
  }
  
  /** Get the height of this Rectangle */
  public int getHeight() {
    return height;
  }
  
  /** Calculate and return the area of this Rectangle */
  public int getArea() {
    return width * height;
  }
  
  
  /* ---- UTILITY ---- */
  
  /** Return a String representation of this Rectangle */
  public String toString() {
    return "Rectangle [" + width + " x " + height + "]";
  }
}