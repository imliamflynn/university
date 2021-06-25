import java.util.Scanner;

/** Liam Flynn
  * Lab 16
  * Gets 3 fruits from user input, then asks the user to guess the fruit based off of the first 2 characters.
  * Cannot move onto next fruit until you have got the current one correct
  */

public class Fruity{
  
  public static void main(String[]args){
    Scanner input = new Scanner(System.in);
    String[] fruits = new String[3];
    for (int i = 0; i < fruits.length; i++){
      System.out.println("Enter a fruit: ");
      fruits[i] = input.nextLine();
    }  
    int i = 0;
    while(i < fruits.length){
      System.out.println("Guess what fruit I am? " + fruits[i].substring(0,2) + "\t" + fruits[i].length() + " letters");
      String answer = input.nextLine();
      
      if (answer.equals(fruits[i])){
        System.out.println("Correct!");
        i += 1;
      }
      else{
        System.out.println("Try again.");
      }
    }
  }
}