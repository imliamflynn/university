/** Liam Flynn
  * Lab 16
  * Creates a 12 by 12 multiplication table which starts off at 1 * 1
  */

public class Table{
  public static void main(String[]args){
    int rows = 12;
    int cols = 12;
    int[][] table = new int[rows][cols];
    for (int row = 0; row < rows; row++){
      for (int col = 0; col < cols; col++){
        table[row][col] = (row+1) * (col+1);
      }
    }
    for (int[] x: table){
      for (int y: x){
        System.out.print(y + "\t");
      }
      System.out.println();
    }
  }
}