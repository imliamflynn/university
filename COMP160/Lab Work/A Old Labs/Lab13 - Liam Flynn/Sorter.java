/** Liam Flynn
  * Lab 13
  * This program takes two phrases through input and finds whether they are anagrams or not.
  */

import java.util.Scanner;

public class Sorter{
  
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter first phrase: "); 
    String sentence = input.nextLine();
    String s = sentence.toLowerCase();
    String sorted = "";
    int length = s.length();
    for (int x = 'a'; x <= 'z'; x++){
      for (int y = 0; y < length; y++){
        if (s.charAt(y) == x){
          sorted += s.charAt(y);          //gets sorted phrase
        }
      }
    }
    
    System.out.println("Enter second phrase: ");
    String sentence2 = input.nextLine();
    String s2 = sentence2.toLowerCase();
    String sorted2 = "";
    int length2 = s2.length();
    for (int x = 'a'; x <= 'z'; x++){
      for (int y = 0; y < length2; y++){
        if (s2.charAt(y) == x){
          sorted2 += s2.charAt(y);         //gets sorted phrase
        }
      }
    }
    
    System.out.println(sorted + " are the letters of " + s + " in order.");
    System.out.println(sorted2 + " are the letters of " + s2 + " in order.");
    
    if (sorted.equals(sorted2)){
      System.out.println(s + " is an anagram of " + s2);
    }
    else{
      System.out.println(s + " is not an anagram of " + s2);
      
    }
  }
}
