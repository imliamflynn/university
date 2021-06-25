import java.util.Scanner;

/** Liam Flynn
  * Lab ___
  * Blurb about program...
  */

public class MyClass{
  
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a sentence: ");
    String sentence = input.nextLine();
    System.out.println("You typed: " + sentence);
    
    aMethod();
    
    String[] family = {"Liam","Katie","Greg","Rebekah","Sophie"};
    for (String i: family){
      System.out.println(i);
    }
  }
  
  /**Comment about method, must go above method in this type of comment to make the lab people happy*/
  public static void aMethod(){
    System.out.println("Hello World!");
  }
}