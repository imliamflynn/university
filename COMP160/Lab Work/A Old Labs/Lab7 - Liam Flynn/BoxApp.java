public class BoxApp{
  public static void main(String[] args){
    
    Box.setOwner("Anna Austin");
    
    Box box1 = new Box();
    box1.setHeight(4);
    box1.setLength(4);
    box1.setWidth(6);
    
    Box box2 = new Box(3,4,5);
    
    Box box3 = new Box(5);
    
    Box box4 = new Box(7);
    
    System.out.println(box1.toString());
    System.out.println(box2.toString());
    System.out.println(box3.toString());
    System.out.println(box4.toString());
    
    Box.setOwner("Bob Berry");
    
    System.out.println(box1.toString());
    System.out.println(box2.toString());
    System.out.println(box3.toString());
    System.out.println(box4.toString());
  }
}