public class MultiDiArrays{
  public static void main(String[]args){
    int rows = 4, cols = 5;
    int[][] table = new int[rows][cols];
    for (int row = 0; row < rows; row++){
      for (int col = 0; col < cols; col++){
        table[row][col] = row * col;
      }
    }
    
    for (int[] r: table){
      for (int c: r){
        System.out.print(c + "\t");
      }
      System.out.println();
    }
  }
}