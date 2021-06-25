/** BookShopApp.java
  * Liam Flynn, Lab 6, COMP160  2020
  * Application class for Book.java
  */

public class BookShopApp{
  
  public static void main(String[]args){
    Book b = new Book();
    b.setTitle("Life of Pi");
    b.setPages(348);
    b.setPrice(28.90);
    b.displayBook();
    
    Book y = new Book();
    y.setTitle("Mister Pip");
    y.setPages(240);
    y.setPrice(22.70);
    y.displayBook();
    
    Book z = new Book();
    z.setTitle("Hunger Games");
    z.setPages(400);
    z.setPrice(30.00);
    z.displayBook(); 
  }
  
}