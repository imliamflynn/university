import java.text.DecimalFormat;

/** Lab 8, TriangleApp.java
  * Liam Flynn, August 2020
  * Application class for Triangle.java
  */

public class TriangleApp{
  
  public static void main(String[]args){
    DecimalFormat fmt = new DecimalFormat("0.##"); //Creates instance of DecimalFormat
    
    Triangle test = new Triangle();
    Triangle a = new Triangle(0,3,3,4,1,9,"A"); //Instances of Triangle
    Triangle b = new Triangle(4,2,9,4,6,7,"B");
    
    System.out.println("Triangle " + test.getName() + " perimeter is " + fmt.format(test.getPerimeter()) + " units.");
    System.out.println("Triangle " + a.getName() + " perimeter is " + fmt.format(a.getPerimeter()) + " units.");
    System.out.println("Triangle " + b.getName() + " perimeter is " + fmt.format(b.getPerimeter()) + " units.");
  }
}