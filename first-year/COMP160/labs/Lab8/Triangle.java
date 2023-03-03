/** Lab 8, Triangle.java
  * Liam Flynn, August 2020
  * Calculates the perimeter of 3 triangles, given the coordinates for the 3 corners of each.
  */

public class Triangle{
  private int p1x;
  private int p1y;
  private int p2x;
  private int p2y;
  private int p3x;
  private int p3y;
  private String name;
  
  /** Default constructor, makes test triangle*/
  public Triangle(){
    p1x = 0;
    p1y = 0;
    p2x = 3;
    p2y = 0;
    p3x = 3;
    p3y = 4;
    name = "Test";
  }
  
  /** This constructor takes 7 parameters and replaces the data fields with them*/
  public Triangle(int pt1x, int pt1y, int pt2x, int pt2y, int pt3x, int pt3y, String nameIn){
    p1x = pt1x;
    p1y = pt1y;
    p2x = pt2x;
    p2y = pt2y;
    p3x = pt3x;
    p3y = pt3y;
    name = nameIn;
  }
  
  /** Gets the distance between 2 points*/
  private double calcSide(int x1, int y1, int x2, int y2){
    return Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2)); //formula to get the distance between 2 points
  }
  
  /** Uses the calcSide method with 3 different sets of points to get the distance of each side, adds them together and returns the result*/
  public double getPerimeter(){
    return (calcSide(p1x,p1y,p2x,p2y) + calcSide(p1x,p1y,p3x,p3y) + calcSide(p2x,p2y,p3x,p3y));
  }
  
  /** Returns the name*/
  public String getName(){
    return name;
  }
}