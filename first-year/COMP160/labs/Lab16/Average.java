/** Lab 16, Average.java
  * Liam Flynn, September 2020
  * Prints out each array inside a multidimensional array and the average for each of the arrays
  */

public class Average{
  public static void main(String[]args){
    int[][] table = {{1,2,3},{4,5,6},{7,8}};
    for (int[] row: table){
      double total = 0, average = 0;
      for (int num: row){
        System.out.print(num + " ");
        total += num;
      }
      System.out.println("\t Average: " + total/row.length);
    }
  }
}