import java.text.DecimalFormat;

public class TriangleApp{
  //main class
  public static void main(String[]args){
    DecimalFormat fmt = new DecimalFormat("0.##"); //makes instance of Decimal Format
    
    Triangle tri1 = new Triangle(); //default constructor method
    System.out.println("Name: " + tri1.getName() + ", Perimeter: " + fmt.format(tri1.getPerimeter()));
    
    Triangle tri2 = new Triangle(0,3,3,4,1,9,"A"); //using method that takes perameters
    System.out.println("Name: " + tri2.getName() + ", Perimeter: " + fmt.format(tri2.getPerimeter()));
    
    Triangle tri3 = new Triangle(1,2,3,4,5,6,"B");
    System.out.println("Name: " + tri3.getName() + ", Perimeter: " + fmt.format(tri3.getPerimeter()));
    
  }
}
