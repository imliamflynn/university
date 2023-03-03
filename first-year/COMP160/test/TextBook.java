public class TextBook extends Book{
  protected double cost;
  
  public TextBook(){}
  
  public TextBook(double d, int i, String s){
    super(i,s);
    cost = d;
    System.out.println(title + pages + cost);
  }
}