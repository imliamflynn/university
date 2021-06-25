import java.util.Random;

/** Lab 2, RandomRange.java
  * Liam Flynn, August 2020
  * Contains a single method which returns random integer between high and low parameters.
  */

public class RandomRange{
  
  /** Returns random integer between high and low parameters.
    @param low lowest value of range required
    @param high highest value of range required
    @return a random integer between low and high values */
  public int randomRange(int low, int high){
    Random generator = new Random();
    return generator.nextInt(high-low+1) + low;
  }
}