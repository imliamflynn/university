/** Liam Flynn
  * Lab 12
  * Counts vowels and consonants from an input string
  */

import java.util.Scanner; //imports Scanner for input

public class EvenSum{ //class
  
  public static void main(String[] args){ //main method
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number above 1: ");
    String x = input.nextLine();
    int start = 2;
    int finish = Integer.parseInt(x);
    int sum = 0;
    if (finish < 1){  //makes sure input is above 1
      System.out.println("Error! You did not enter a number above 1.");
    }
    else{
      while (start <= finish){ //while loop for each even number
        if (start % 2 == 0){
          sum += start;
        }
        start++;
      }
      System.out.println("Sum of even numbers between 1 and " + finish + ": " + sum);
    }
  }
}
        
          