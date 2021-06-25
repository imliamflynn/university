import java.util.Scanner;

/** Lab 12, SumOfInputs.java
  * Liam Flynn, August 2020
  * Reads an integer value and prints the sum of all even integers between 2 and the input value inclusive
  */

public class SumOfInputs{
  
  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter an integer greater than 1: ");
    int i = 2, sum = 0, input = scan.nextInt();
    if (input < 2)
      System.out.println("Input value must not be less than 2");
    else{
      while (i <= input){
        sum += i;
        i += 2;
      }
      System.out.println("Sum of even integers between 2 and " + input + " inclusive is: " + sum);
    }
  }  
}