import java.util.Scanner;

public class HelloWorld{
  
  public void hello(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter your name: ");
    String yourName = scan.nextLine();
    System.out.println("Hello World!");
    System.out.println("And hello " + yourName + "!");
  }
}