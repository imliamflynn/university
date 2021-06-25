/** Liam Flynn
  * Lab 15
  * Checks whether or not a target number is in an array
  */

public class IntCounter{
  private int[] numArray;
  
  /**Constructor sets numArray data field and prints all values in array*/
  public IntCounter(int[] x){
    numArray = x;
    for (int i: numArray){
      System.out.print(i + " ");
    }
    System.out.println(" Array is of length " + numArray.length);
  }
  
  /**If target number is not in array, tells the user. Otherwise shows where in the array the target number(s) is.*/
  public void showTarget(int target){
    int count = 0;
    for (int i:numArray){
      if (i == target){
        count += 1;
      }
    }
    if (count != 0){
    for (int i = 0; i < numArray.length; i++){
      if (numArray[i] == target){
        System.out.println("\t There is a " + target + " in position " + i);
      }
    }
    }
    else{
      System.out.println("\t There are no " + target + "'s in this array.");
    }
    System.out.println("");
  }
}