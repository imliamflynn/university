/** BoxApp.java
  * Liam Flynn, Lab 7, COMP160 July 2020
  * Application class for Box.java
  */

public class BoxApp{
  
  public static void main(String[]args){
    Box.setOwner("Anna Austin");
    Box box1 = new Box(); //contructor calls
    Box box2 = new Box(3, 5, 4);
    Box box3 = new Box(5);
    Box box4 = new Box(7);

    box1.setHeight(4);
    box1.setWidth(6);
    box1.setLength(4);
    
    //print statements
    System.out.println(box1.toString());
    System.out.println(box2.toString());
    System.out.println(box3.toString());
    System.out.println(box4.toString());
    System.out.println(" ");
    //owner name change
    Box.setOwner("Bob Berry");
    System.out.println(box1.toString());
    System.out.println(box2.toString());
    System.out.println(box3);
    System.out.println(box4);
  }
}