public class NestedForLoop{
  public static void main(String[]args){
    for (int i = 1; i <= 7; i++){
      for (int x = 1; x <= i; x++){
        System.out.print(i);
      }
      System.out.println();
    }
  }
}