import java.util.Scanner;

/** Lab 3 COMP160  
  * Liam Flynn July 2020
  */

public class Letter{
  private static int junior = 22000;    // standard pay rate for Junior employee
  private static int intermediate = 40000; // standard pay rate for Intermediate employee
  private static int senior = 75000;    // standard pay rate for Senior employee
  
  /**The main method, runs all the different jobOffer methods and gets user input using the Scanner class*/
  public static void main(String [] args){
    //user input section
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the successful applicants name: ");
    String name = scan.nextLine();
    
    //method calls
    jobOffer(); 
    jobOffer("Chief Cook");
    jobOffer("Sous Chef");
    jobOffer("Lecturer", 55000);
    jobOffer("Astronaut", 100000); 
    jobOffer("Mary", "Hotdog Maker", junior);
    jobOffer("John", "Hotdog Eater", intermediate);
    jobOffer(name, "Cleaner", senior);
  } // end method
  
  /** displays a job offer for Bottle Washer at $22K */
  public static void jobOffer(){
    System.out.println("Dear applicant\nI wish to offer you the position of Bottle Washer.\nThe pay rate will be $22000 per annum.");
    signature();
  } // end method
  
  /** displays a job offer for whichever job title replaces the parameter at $22K */
  public static void jobOffer(String jobTitle){
    System.out.println("Dear applicant\nI wish to offer you the position of " + jobTitle + ".\nThe pay rate will be $22000 per annum.");
    signature();
  } //end method
  
  /** displays a job offer for whichever job title and pay rate replace both parameters */
  public static void jobOffer(String jobTitle, int payRate){
    System.out.println("Dear applicant\nI wish to offer you the position of " + jobTitle + ".\nThe pay rate will be $" + payRate + " per annum.");
    signature();
  } //end method
  
  /** displays a job offer using the name, job title, and pay rate which replace the parameters */
  public static void jobOffer(String name, String jobTitle, int payRate){
    System.out.println("Dear " + name + "\nI wish to offer you the position of " + jobTitle + ".\nThe pay rate will be $" + payRate + " per annum.");
    signature();
  } //end method
  
  /** displays signature */
  public static void signature(){
    String yours = "Yours sincerely";
    String sign = "Mr Albert Agnew Esq.\nHuman Resources Manager\nButtery Baps Unlimited\nwww.bb.co.nz";
    System.out.println("\n" + yours + "\n" + sign + "\n");
  }//end method
  
} // end class