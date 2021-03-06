import java.util.Scanner;
/**Lab 4 COMP160 2019
  * Starting code*/

public class FahrenheitToCelsius{
  public static void main(String[]args){
    convertFToC();
    convertFToC();
    convertFToC();
    //Step 5;
  }
  
  /**gets input from user representing fahrenheit and displays celsius equivalent*/
  public static void convertFToC(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter Fahrenheit temperature");
    double fahrenheit = scan.nextDouble(); //Step 2 - assign next double input from Scanner object
    System.out.println(fahrenheit + " degrees Fahrenheit is " + toCelsius(fahrenheit) + " degrees celsius."); //Step 4
  }
  
  
  /**calculates and returns the celsius equivalent of a double input parameter, which it calls fahr*/
  public static double toCelsius(double fahr){
    int BASE = 32;
    double CONVERSION_FACTOR = 9.0/ 5.0;
    double celsius; 
    celsius =  (fahr - BASE) / CONVERSION_FACTOR; //Step 3   This is where the conversion happens.
    return celsius;
  }
}
