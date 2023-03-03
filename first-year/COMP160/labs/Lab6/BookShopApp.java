/** BookShopApp.java
  * Liam Flynn, Lab 6, COMP160 July 2020
  * Application class for Book.java
  */

public class BookShopApp{
  
  public static void main(String[] args){
    Book b1 = new Book();
    //b1.displayBook();
    b1.setTitle("Good Omens");
    b1.setPages(230);
    b1.setPrice(28.99);
    
    Book b2 = new Book();
    b2.setTitle("The Whale Rider");
    b2.setPages(120);
    b2.setPrice(19.99);
    
    Book b3 = new Book();
    b3.setTitle("The Bible");
    b3.setPages(1000);
    b3.setPrice(49.99);
    
    b1.displayBook();
    b2.displayBook();
    b3.displayBook();
  }
}