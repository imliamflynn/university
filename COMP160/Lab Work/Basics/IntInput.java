import java.util.Scanner;

public class IntInput{
  
  public static void main(String[]args){
    int x = readInt("Please enter an integer: ");
    System.out.println("You entered: " + x);
  }
  
  public static int readInt(String message){
    Scanner scan = new Scanner(System.in);
    System.out.println(message);
    return scan.nextInt();
  }
}
  