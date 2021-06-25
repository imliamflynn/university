/**
 * RandomApp.java
 * Lab 8, Part 2, COMP160  2019
 * Displays a random integer between high and low limits
 * High and low values are typed in by the user.
 */

public class RandomApp{
  public static void main(String[]args){ 
    RandomRange r = new RandomRange();
    int lo = r.readInt("Enter lowest value");
    int hi = r.readInt("Enter highest value");
    System.out.println("Random integer between " + lo + " and " + hi + " : " + r.randomRange(lo, hi)); 
  }
}