/**
 * Lab 9 COMP160
 * 22/8/2019
 */

public class Customer{
  private String name;
  private boolean child; // data fields
  private boolean student;
  private boolean booked;
  
  public Customer(String nameIn, int age, boolean studentIn){
    this.name = nameIn;
    if (age >= 5 && age <= 16){
      this.child = true;
    }
    else{
      this.child = false;
    }
    this.student = studentIn;
  }
  
  public String getName(){
    //String n = name;
    return name;
  }
  public boolean isChild(){ //accessor
    boolean c = child;
    return c;
  }
  public boolean isStudent(){ //accessor
    boolean s = student;
    return s;
  }
  public boolean setBooked(boolean x){ //mutator
    booked = x;
    return booked;
  }
  public boolean getBooked(){ //accessor
    boolean b = booked;
    return b;
  }
}