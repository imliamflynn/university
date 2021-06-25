/** Liam Flynn
  * Lab 12
  * Finds sum of all even numbers between 1 and input
  */

import java.util.Scanner; //imports Scanner for input

public class Vowels{
  
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int numVowels = 0;
    int numCons = 0;
    System.out.println("Enter a sentence: ");
    String sentence = input.nextLine();
    String newSentence = sentence.toUpperCase();
    int sentenceLength = sentence.length();
    for (int i = 0; i < sentenceLength; i++){
      if (newSentence.charAt(i) >= 'A' && newSentence.charAt(i) <= 'Z'){ //makes sure the character is a letter
        switch(newSentence.charAt(i)){ //switch method to find vowels and consonants
          case 'A':
          case 'E':
          case 'I':
          case 'O':
          case 'U':
            numVowels += 1;
            break;
          default:
            numCons += 1;
        }
      }
    }
    System.out.println("Sentence is: " + sentence);
    System.out.println("Vowel Count: " + numVowels);
    System.out.println("Consonant Count: " + numCons);
  }
}