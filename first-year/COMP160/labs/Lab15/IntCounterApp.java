import java.util.Random;
import java.util.Scanner;

/** Lab 15, IntCounterApp.java
  * Liam Flynn, August 2020
  * Application class for IntCounter
  */

public class IntCounterApp{
  
  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    for(int i = 0; i < 3; i++){
      System.out.println("Which number do you wish to find? ");
      int target = scan.nextInt();
      IntCounter intCo = new IntCounter(makeArray());
      intCo.showTarget(target);
    }
  }
  
  /** Creates an array of random length between 5-10, then fills each of the array slots with a random int between 0-4 */
  public static int[] makeArray(){
    Random rand = new Random();
    int arrayLength = rand.nextInt(6) + 5;
    int[] myArray = new int[arrayLength];
    for(int i = 0; i < myArray.length; i++){
      myArray[i] = rand.nextInt(5);
    }
    return myArray;
  }
}