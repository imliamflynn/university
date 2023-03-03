/** Lab 15, IntCounter.java
  * Liam Flynn, August 2020
  * Display the array position of every occurrence of a target integer stored in an array of type int
  */

public class IntCounter{
  private int[] numArray;
  
  /** Constructor, sets data field, prints array length */
  public IntCounter(int[] x){
    numArray = x;
    for(int i : numArray){
      System.out.print(i + " ");
    }
    System.out.println("Array is of length: " + numArray.length);
  }
  
  /** Checks each int in the array and if it is the target int it prints out so */
  public void showTarget(int target){
    for(int i = 0; i < numArray.length; i++){
      if (numArray[i] == target){
        System.out.println("There is a " + target + " in position " + i);
      }
    }
  }
}