import java.util.Scanner;

public class HelloWorld{
  
  public void hello(){
    Scanner skuxx = new Scanner(System.in);
    System.out.println("Enter your name: ");
    String yourName = skuxx.nextLine();
    System.out.println("Hello World!");
    System.out.println("And hello " + yourName + "!");
  }
}