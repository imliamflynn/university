/**
 * Rectangle3.java
 * Example code for Complex Comp160
 * Raymond:  August 2006
 * 
 * This class creates and stores information about Rectangles
 */

public class Rectangle3 {
  
  //datafields
  private int width;       // stores the width of this Rectangle
  private int height;      // stores the height of this Rectangle
  
  
  /* ---- CONSTRUCTORS ---- */
  
  /** Make a default rectangle:
   * -- ask to make a 'Square' Rectangle with width and height to 1 */
  public Rectangle3() {
    this(1);
  }
  
  /** Make a 'Square':
   * -- ask to make a Rectangle where width == height */
  public Rectangle3(int size) {
    this(size, size);
  }
  
  /** Make a Rectangle of the required size */
  public Rectangle3(int w, int h) {
    setWidth(w);
    setHeight(h);
  }
  
  
  /* ---- SETTERS (mutators, modifiers) ---- */
  
  /** Set the width of the Rectangle to a new value
   * -- make sure that the Rectangle has non-negative width
   */
  public void setWidth(int newWidth) {
    if (newWidth >= 0) {
      // set the legal value
      width = newWidth;
    } else {
      // illegal value!  -- set to "0"
      width = 0;
    }
  }
  
  /** Set the height of the Rectangle to a new value
   * -- make sure that the Rectangle has non-negative height
   */
  public void setHeight(int newHeight) {
    if (newHeight < 0) {
      // illegal value!  -- set to "0"
      height = 0;
      return; // nothing more to do...
    }
    
    // set the legal value
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