/** Liam Flynn
  * Lab 16
  * Prints out average of arrays inside multidimensional array
  */
 
public class Average{
  public static void main(String [] args){
    int[][] table = {{1,2,3},{4,5,6},{7,8}};
    for (int x = 0; x < table.length; x++){
      double sum = 0;
      double average = 0;
      for (int y = 0; y < table[x].length; y++){
        sum += table[x][y];
        System.out.print(table[x][y] + " ");
      }
      average = sum / table[x].length;
      System.out.println("\t Average: " + average);
    }
  }
}