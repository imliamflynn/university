import java.util.Scanner;
import java.util.Random;

/** Liam Flynn
  * Lab 15
  * App program for IntCounter, gets number from user
  */

public class IntCounterApp{
  
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    for (int i = 0;i < 3; i++){
      System.out.println("Which number do you wish to find? ");
      String target = input.nextLine();
      IntCounter intCow = new IntCounter(makeArray());
      intCow.showTarget(Integer.parseInt(target));
    }
  }
  
  /** Creates array of random length between 5-10 and fills each slot with a random number between 0-4*/
  public static int[] makeArray(){
    Random generator = new Random();
    int num = generator.nextInt(5) + 6;
    int[] aye = new int[num];
    for (int i = 0; i < num; i++){
      aye[i] = generator.nextInt(5);
    }
    return aye;
  }
}