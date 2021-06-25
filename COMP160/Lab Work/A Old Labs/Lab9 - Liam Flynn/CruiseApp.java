/** application class for Customer.java
  * Lab 9 COMP160
  */
import java.text.DecimalFormat;
import java.util.Scanner;

public class CruiseApp{
  
  public static void main(String[]args){
    //each Customer created with name, age, showed student ID card
    Customer customer1 = new Customer("Aaron Stott",17, true);
    Customer customer2 = new Customer("Betty Adams",17, false);
    Customer customer3 = new Customer("Corin Child",16, true);
    Customer customer4 = new Customer("Doris Stewart",25, true);
    Customer customer5 = new Customer("Edmond Cheyne",12, false);
    Customer customer6 = new Customer("Fiona Chaney",7, false);
    Customer customer7 = new Customer("Ged Still-Child",16, true);
    Customer customer8 = new Customer("Harry Adamson",20, false);
    confirmBooking(customer1);
    confirmBooking(customer2);
    confirmBooking(customer3);
    confirmBooking(customer4);
    confirmBooking(customer5);
    confirmBooking(customer6);
    confirmBooking(customer7);
    confirmBooking(customer8);
    bookings(customer1);
    bookings(customer2);
    bookings(customer3);
    bookings(customer4);
    bookings(customer5);
    bookings(customer6);
    bookings(customer7);
    bookings(customer8);
  }
  
  public static void confirmBooking(Customer c){
    DecimalFormat fmt = new DecimalFormat("0.##"); //creates instance of Decimal Format
    Scanner input = new Scanner(System.in);
    
    String name = c.getName();
    double ticket = 56.0;
    double meal = 30.0;
    double total = 0.0;
    if ((c.isChild() == true) || (c.isStudent() == true)){
      ticket = ticket/2;
    }
    else{
      ticket = ticket*0.8;
    }
    if (c.isChild() == true){
      meal = meal/2;
    }
    else{
      meal = meal*0.9;
    }
    total = meal + ticket;
    System.out.println(name + "\nTicket price: $" + fmt.format(ticket) + "\nMeal price: $" + fmt.format(meal) + "\nTotal price: $" + fmt.format(total)); //prints name and prices
    System.out.println("Confirm booking for " + name + " (Y/N)"); //gets input
    String yorn = input.nextLine();
    if (yorn.equals("Y") || yorn.equals("y")){
      c.setBooked(true);
    }
    else{
      c.setBooked(false);
    }
    if (c.getBooked() == true){
      System.out.println("Booked\n");
    }
    else{
      System.out.println("Not Booked\n");
    }
  }
  
  public static void bookings(Customer c){ //prints names of booked customers
    String name = c.getName();
    if (c.getBooked() == true){
      System.out.println(name + " is booked.");
    }
  }
}