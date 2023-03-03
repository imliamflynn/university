/** Box.java
  * Liam Flynn, Lab 7, COMP160 July 2020
  * Calculates the volume and surface area of a box given its height, length and width.
  */

public class Box{
  private int height; //height of box
  private int width; //width of box
  private int length; //length of box
  private static String owner; //owner name
  
  /** Default Constructor */
  public Box(){}
  /** Constructor that takes 3 parameters (h, w, l) and changes the data fields */
  public Box(int h, int w, int l){
    height = h;
    width = w;
    length = l;
  }
  /** Constructor that takes 1 parameter (side) and changes the data fields */
  public Box(int side){
    height = side;
    width = side;
    length = side;
  }
  
  /** Mutator which changes height data field */
  public void setHeight(int h){
    height = h;
  }
  /** Mutator which changes width data field */
  public void setWidth(int w){
    width = w;
  }
  /** Mutator which changes length data field */
  public void setLength(int l){
    length = l;
  }
  
  /** Accessor which calculates the surface area of the box */
  public int getSurfaceArea(){
    int side1 = height * width;
    int side2 = height * length;
    int side3 = width * length;
    return (side1 + side2 + side3) * 2;
  }
  /** Accessor which calculates the volume of the box */
  public int getVolume(){
    return height * width * length;
  }
  
  /** Method returns a String which describes the dimensions of the box and who owns it */
  public String toString(){
    return "Height is: " + height + ", Width is: " + width + ", Length is: " + length +
      ", Surface Area is: "+ getSurfaceArea() + ", Volume is: " + getVolume() + ", Owned by: " + owner;
  }
  
  /** Mutator which changes the owner data field */
  public static void setOwner(String nameIn){
    owner = nameIn;
  }

  public static String getOwner(){
    return owner;
  }
}