public class Box{
  private int height;
  private int width;
  private int length;    
  private static String owner;
  
  /** Sets name of owner to o*/
  public static void setOwner(String o){
    owner = o;
  }
  /** Create a box using h,l and w*/
  public Box(int h, int l, int w){
    height = h;
    length = l;
    width = w;
  }
  
  public Box(){}
  
  /** Creates a box using all the same length sides*/
  public Box(int side){
    height = side;
    length = side;
    width = side;
  }
  /** Sets the value of height to h*/
  public void setHeight(int h){
    height = h;
  }
  /** Sets the value of width to w*/
  public void setWidth(int w){
    width = w;
  }
  /** Sets the value of length to l*/
  public void setLength(int l){
    length = l;
  }
  /** Finds the surface area of box and returns it*/
  public int getSurfaceArea(){
    return (((length * height) + (length * width) + (width * height)) * 2);
  }
  /** Finds the volume of the box and returns it*/
  public int getVolume(){
    return (length * width * height);
  }
  /** Accessor method to return the owner name*/
  public static String getOwner(){
    return owner;
  }
  /** Creates a string which turns all the data into readable information*/
  public String toString(){
    return ("The height is " + height + ". The width is " + width + ". The length is " + length + ". The volume is " + getVolume() + ". The surface area is " + getSurfaceArea() + ". Owned by: " + getOwner());
  }
}