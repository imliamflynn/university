/** COMP160 Lab2 FlatBudget.java
  * Liam Flynn July 2020
  * This class calculates the weekly donation to the flat account required from each person
 */

public class FlatBudget{
    public static void main(String[]args){
        int numberInFlat = 4;    // number of people sharing the total cost
        String MONTH = "July 2020";  // String description of this month
        int numDays = 31; // number of days in this month
        double numWeeksInMonth = numDays/7.0; // number of weeks in this month
        double groceriesWeekly = 210.0;       // grocery expenses
        double servicesMonthly = 279.0;  // power internet expenses
        double rentFortnightly = 824.0;       // rent expenses
        double servicesWeekly =  servicesMonthly / numWeeksInMonth;
        double rentWeekly = rentFortnightly/2;
            
        double expensesTotalPerWeek = groceriesWeekly + servicesWeekly + rentWeekly;
        double eachPersonPerWeek =  expensesTotalPerWeek/numberInFlat;
     
        System.out.println("Each person pays $" + eachPersonPerWeek);
    }
}