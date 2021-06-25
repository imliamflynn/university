import java.util.Scanner;
/**
 * Lab 3, COMP160, 2019
 */

public class Letter{
  private static String yours = "Yours sincerely";
  private static String sign = "Mr Albert Agnew Esq.\nHuman Resources Manager\nButtery Baps Unlimited\nwww.bb.co.nz";
  
  public static void main(String [] args){
    String name;
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the successful applicant's name: ");
    name = scan.nextLine();
    
    int junior = 25000;     // standard pay rate for Junior employee
    int intermediate = 35000;  // standard pay rate for Intermediate employee
    int senior = 50000;    // standard pay rate for Senior employee
    jobOffer();
    jobOffer("Chief Cook");
    jobOffer("Janitor", 10000);
    jobOffer(name, "Manager", senior);
    
  } // end method
  
  /** displays the signing that has to be done at the end of each job offer*/
  public static void signature(){
    System.out.println(yours + "\n" + sign + "\n");
  }
  
  /** displays a job offer for Bottle Washer at $25K */
  public static void jobOffer(){
    System.out.println("Dear applicant\nI wish to offer you the position of Bottle Washer.\nThe pay rate will be $25000 per annum.");
    signature();
  } // end method
  
  /** displays a job offer for whatever job title is used as a parameter when called */
  public static void jobOffer (String jobTitle){
    System.out.println("Dear applicant\nI wish to offer you the position of " + jobTitle + ".\nThe pay rate will be $25000 per annum.");
    signature();
  } // end method
  
  /** displays a job offer for whatever job title and pay rate is used as parameters when called */
  public static void jobOffer (String jobTitle, int payRate){
    System.out.println("Dear applicant\nI wish to offer you the position of " + jobTitle + ".\nThe pay rate will be $" + payRate + " per annum.");
    signature();
  } // end method
  
  /** displays a job offer for the name entered through user input, showing the job title and the pay rate that are used as parameters when called */
  public static void jobOffer (String name, String jobTitle, int payRate){
    System.out.println("Dear " + name + "\nI wish to offer you the position of " + jobTitle + ".\nThe pay rate will be $" + payRate + " per annum.");
    signature();
  } // end method
  
} // end class
