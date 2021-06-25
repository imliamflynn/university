import java.util.Scanner;

/** Lab 16, GuessAnimal.java
  * Liam Flynn, September 2020
  * Guessing game using arrays to store names of animals and which ones the user selects
  */

public class GuessAnimal{
  static String[] animalGuessList = new String[3];
  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    String[] animalLongList = {"Aadvark", "Ant", "Beaver", "Cheetah",
      "Dingo", "Elephant", "Giraffe", "Hippopotamus", "Iguana",
      "Jaguar", "Lion","Monkey"};
    
    /** Fills the animalGuessList with animal names from the animalLongList selected by the users input */
    for (int i = 0; i < animalGuessList.length; i++){
      System.out.println("Please enter a number between 0 and 11");
      int choice =  scan.nextInt();
      animalGuessList[i] = animalLongList[choice];
    }
    
    /** Shows the first 2 letters of each animals name in animalGuessList. Shows how many letters are missing with underscores.
      * Prints correct if correct answer is guessed, makes user keep trying if they get the answer wrong until they get it right*/
    for (String i: animalGuessList){  
      int procceed = 0;
      do{
        System.out.print("Guess which animal I am? " + i.substring(0,2));
        for (int x = 0; x < (i.length() - 2); x++){
          System.out.print(" _");
        }
        System.out.println();
        String guess = scan.next();
        if (guess.toLowerCase().equals(i.toLowerCase())){
          System.out.println("Correct");
          procceed = 1;
        }
        else{
          System.out.println("Incorrect");
        }
      }
      while (procceed != 1);
    }
  }
}
