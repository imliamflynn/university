/**
 * Rectangle1.java
 * Example code for Early classes in Comp160
 * Raymond:  August 2006
 * 
 * This class stores simple information about Rectangles
 */

public class Rectangle1 {
  
  //datafields
  private int width;       // stores the width of this Rectangle
  private int height;      // stores the height of this Rectangle


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

}