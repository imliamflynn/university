import java.util.Scanner;

/** Lab 12, Vowels.java
  * Liam Flynn, August 2020
  * Reads a String and prints the number of vowels and consonants which appear in the String
  */

public class Vowels{
  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a  sentence: ");
    String s = scan.nextLine(), sUpper = s.toUpperCase();
    int i = 0, vowels = 0, consonants = 0;
    while (i < s.length()){
      char ch = sUpper.charAt(i);
      if (ch >= 'A' && ch <= 'Z'){
        switch(ch){
          case 'A':
          case 'E':
          case 'I':
          case 'O':
          case 'U':
            vowels += 1;
            break;
          default:
            consonants += 1;
        }
      }
      i ++;
    }
    
    System.out.println("Sentence is: " + s);
    System.out.println("Vowel Count: " + vowels);
    System.out.println("Consonant Count: " + consonants);
  }
}