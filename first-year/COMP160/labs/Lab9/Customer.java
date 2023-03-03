/** Lab 9, Customer.java
  * Liam Flynn, August 2020
  * Checks if customer is a child or not using their age, and also accessor and mutator methods for the data fields
  */

public class Customer{
  private String name;
  private boolean child;
  private boolean student;
  private boolean booked;
  
  /** Checks if customer is a child based off of their age*/
  public Customer(String nameIn, int age, boolean studentIn){
    name = nameIn;
    if ((age >= 5) && (age <= 16)) child = true; else child = false;
    student = studentIn;
  }
  
  /** Accessor for name*/
  public String getName(){
    return name;
  }
  
  /** Accessor for child*/
  public boolean isChild(){
    return child;
  }
  
  /** Accessor for student*/
  public boolean isStudent(){
    return student;
  }
  
  /** Accessor for booked*/
  public boolean isBooked(){
    return booked;
  }
  
  /** Sets booked to true*/
  public void setBooked(){
    booked = true;
  }
}