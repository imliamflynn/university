import java.util.Scanner;

/** Lab 13, Anagrams.java
  * Liam Flynn, August 2020
  * Takes two string inputs and figures out whether they are anagrams of eachother
  */

public class Anagrams{
  
  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter first phrase: ");
    String phrase1 = scan.nextLine();
    System.out.println("Enter second phrase: ");
    String phrase2 = scan.nextLine();
    
    String phrase1Sorted = sort(phrase1), phrase2Sorted = sort(phrase2);
    
    System.out.println(phrase1Sorted + " are the letters of " + phrase1 + " in alphabetical order");
    System.out.println(phrase2Sorted + " are the letters of " + phrase2 + " in alphabetical order");
    
    if (phrase1Sorted.equals(phrase2Sorted))
      System.out.println(phrase1 + " is an anagram of " + phrase2);
    else
      System.out.println(phrase1 + " is not an anagram of " + phrase2);
  }
  
  public static String sort(String phrase){
    String phraseLow = phrase.toLowerCase(), phraseSorted = "";
    for (int alph = 'a'; alph <= 'z'; alph ++){
      for (int i = 0; i < phraseLow.length(); i ++){
        if (phraseLow.charAt(i) == alph)
          phraseSorted += phraseLow.charAt(i);
      }
    }
    return phraseSorted;
  }
}