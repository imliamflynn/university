import java.text.DecimalFormat;
import java.util.Scanner;

/** Lab 9, CruiseApp.java
  * Liam Flynn, August 2020
  * Makes instances of Customer.java, checks if customer is a child, student or neither,
  * adjusts prices, confirms bookings, and displays those who are booked.
  */

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
    confirmBooking(customer8);//and so on
    showBooked(customer1);
    showBooked(customer2);
    showBooked(customer3);
    showBooked(customer4);
    showBooked(customer5);
    showBooked(customer6);
    showBooked(customer7);
    showBooked(customer8);
  }
  
  /** Checks if customer is a child, student, or neither, then adjusts prices accordingly. Also lets user confirm booking or not with each customer */
  public static void confirmBooking(Customer customer){
    Scanner scan = new Scanner(System.in);
    DecimalFormat fmt = new DecimalFormat("0.##");
    double ticket = 56.0;
    double meal = 30.0;
    if (customer.isChild()){
      ticket *= 0.5;
      meal *= 0.5;
    }
    else{
      if (customer.isStudent()){
        ticket *= 0.5;
        meal *= 0.9;
      }
      else{
        ticket *= 0.8;
        meal *= 0.9;
      }
    }
    System.out.println(customer.getName() + "\nTicket Price: $" + fmt.format(ticket) + "\nMeal Price: $" + fmt.format(meal) + "\nTotal Price: $" + fmt.format(ticket+meal));
    System.out.println("Confirm booking for " + customer.getName() + " (Y/N)");
    String booked = scan.nextLine();
    if (booked.equals("y") || booked.equals("Y")) customer.setBooked();
  }
  
  /** Prints out the names of those who are confirmed booked.*/
  public static void showBooked(Customer customer){
    if (customer.isBooked()) System.out.println(customer.getName() + " is booked.");
  }
}