/** Lab 10, LeapYearApp.java
  * Liam Flynn, August 2020
  * Processes a series of integer values represemting years and determines if they are leap years or not
  */

public class LeapYearApp{
  
  public static void main(String[]args){
    leapYear(2019);
    leapYear(2020);
    leapYear(1900);
    leapYear(2000);
    leapYear(1565);
  }
  
  /** Takes an integer representing a year as a paremeter. Then checks whether or 
    * not the parameter is a leap year and prints the result. */
  public static void leapYear(int year){
    if (year < 1582){
      System.out.println(year + " predates the Gregorian calendar.");
    }
    else if ((year % 400) == 0){
      System.out.println(year + " is a leap year.");
    }
    else if ((year % 100) == 0){
      System.out.println(year + " is not a leap year.");
    }
    else if ((year % 4) == 0){
      System.out.println(year + " is a leap year.");
    }
    else{
      System.out.println(year + " is not a leap year.");
    }
  }
}