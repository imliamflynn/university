import java.util.ArrayList;
import java.util.Scanner;
/**
 * Liam Flynn - Mar 2022
 * This program takes input from the user and determines whether or
 * not the date is a valid date between 1753 and 3000.
 */
public class Dates {
    static boolean valid = true;
    static String input;
    static String working;

    static String day;
    static String month;
    static String year;
    static String ogMonth;
    static int dayInt;
    static int monthInt;
    static int yearInt;

    static int maxDate;
    static int monthNum;
    static int section;
    static int seperatorCount;
    static char seperator;
    static boolean seperatorMismatch = false;
    static boolean monthValid = true;
    static boolean sepValid = true;

    static int inputCount = 0;
    static int lineCount = 0;
    static ArrayList<String> lines;
    
    public static void main(String[] args){ start();}

    public static void start(){
        inputCount = 0;
        lineCount = 0;
        lines = null;
        lines = new ArrayList<String>();
        System.out.println("Enter a date in the format - day month year:");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String temp = scanner.nextLine();
            lines.add(temp);
            lineCount++;
        }

        //for (String s: lines) System.out.println(s); //debugging

        for (int x = 0; x < lineCount; x++) {
            valid = true;
            input = null;
            working = null;

            day = null;
            month = null;
            year = null;
            dayInt = 0;
            monthInt = 0;
            yearInt = 0;

            maxDate = 0;
            monthNum = 0;
            section = 0;
            seperatorCount = 0;
            seperator = 0;
            seperatorMismatch = false;
            monthValid = true;
            sepValid = true;

            input = lines.get(x); //Stores user input

            working = "";
            //Seperates input into sections day, month, and year
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c != '-' && c != '/' && c != ' ') {
                    working += c;
                }

                if (c == '-' || c == '/' || c == ' ') {
                    if (working.length() == 0 || seperatorCount > 2) {
                        System.out.println(input + " - INVALID: Either too many seperators or there are seperators leading or trailing the date. E.g. -1-1-11-. Must be 1-1-11");
                        sepValid = false;
                        break;
                    }

                    if (seperator == 0) seperator = c;
                    if (c != seperator) {
                        seperatorMismatch = true;
                    }
                    seperatorCount++;

                    if (section == 0) {
                        day = working;
                    } else if (section == 1) {
                        month = working;
                        ogMonth = month;
                    }

                    section++;
                    working = "";
                }

                if (i == (input.length() - 1)) year = working;
            }

            if (!sepValid) continue;

            if (seperatorCount < 2) {
                System.out.println(input + " - INVALID: Date must have 2 seperators. E.g. 1-1-11");
                continue;
            }

            dayCheck();
            monthCheck();
            yearCheck();

            validate();
        }
    }

    /**
     * Format's the day to dd or 0d.
     */
    public static void dayCheck(){
        try{
            dayInt = Integer.parseInt(day);
        }catch(Exception e){
            //System.err.println(e);
        }

        if (day.length() == 1){ //Turns day from d to dd
            day = "0" + day;
        }
    }

    /**
     * Format's the month to Jan/Feb/Mar etc. and sets the max number of days accordingly.
     */
    public static void monthCheck(){
        try{
            monthInt = Integer.parseInt(month);
        }catch(Exception e){
            //System.err.println(e);
        }

        if(month.equals("Jan") || month.equals("JAN") || month.equals("jan") || monthInt == 1){
            month = "Jan";
            maxDate = 31;
            monthNum = 1;
        }else if (month.equals("Feb") || month.equals("FEB") || month.equals("feb") || monthInt == 2){
            month = "Feb";
            maxDate = 28;
            monthNum = 2;
        }else if (month.equals("Mar") || month.equals("MAR") || month.equals("mar") || monthInt == 3){
            month = "Mar";
            maxDate = 31;
            monthNum = 3;
        }else if (month.equals("Apr") || month.equals("APR") || month.equals("apr") || monthInt == 4){
            month = "Apr";
            maxDate = 30;
            monthNum = 4;
        }else if (month.equals("May") || month.equals("MAY") || month.equals("may") || monthInt == 5){
            month = "May";
            maxDate = 31;
            monthNum = 5;
        }else if (month.equals("Jun") || month.equals("JUN") || month.equals("jun") || monthInt == 6){
            month = "Jun";
            maxDate = 30;
            monthNum = 6;
        }else if (month.equals("Jul") || month.equals("JUL") || month.equals("jul") || monthInt == 7){
            month = "Jul";
            maxDate = 31;
            monthNum = 7;
        }else if (month.equals("Aug") || month.equals("AUG") || month.equals("aug") || monthInt == 8){
            month = "Aug";
            maxDate = 31;
            monthNum = 8;
        }else if (month.equals("Sep") || month.equals("SEP") || month.equals("sep") || monthInt == 9){
            month = "Sep";
            maxDate = 30;
            monthNum = 9;
        }else if (month.equals("Oct") || month.equals("OCT") || month.equals("oct") || monthInt == 10){
            month = "Oct";
            maxDate = 31;
            monthNum = 10;
        }else if (month.equals("Nov") || month.equals("NOV") || month.equals("nov") || monthInt == 11){
            month = "Nov";
            maxDate = 30;
            monthNum = 11;
        }else if (month.equals("Dec") || month.equals("DEC") || month.equals("dec") || monthInt == 12){
            month = "Dec";
            maxDate = 31;
            monthNum = 12;
        }else{
            maxDate = 31;
            monthNum = 1;
            monthValid = false;
        }
    }

    /**
     * Format's the year to yyyy and makes a call to leapYear(int y).
     */
    public static void yearCheck(){
        try{
            yearInt = Integer.parseInt(year);
        }catch(Exception e){
            //System.err.println(e);
        }

        if (year.length() == 2){
            if (yearInt > 49){
                year = "19" + year;
                yearInt = Integer.parseInt(year);
            }
            else{
                year = "20" + year;
                yearInt = Integer.parseInt(year);
            }
        }

        if (leapYear(yearInt) && month == "Feb"){ //Sets maxDate to 29 if input is Feb in a leap year
            maxDate = 29;
        }
    }

    /**
     * Returns true if passed an int that is a leap year
     */
    public static boolean leapYear(int y){
        if (y % 100 == 0){
            if (y % 400 == 0) return true;
        }else{
            if (y % 4 == 0) return true;
        }
        return false;
    }

    /**
     * Performs a number of checks to see if the date is valid or not.
     */
    public static void validate(){
        if (inputCount == 0) {
            System.out.println();
            System.out.println();
            inputCount++;
        }

        //VALIDATION
        if (seperatorCount > 2){
            System.out.println(input + " - INVALID: Too many segments. There must be 3 arguments, split up by 2 seperators. Seperators can be '-', '/', or ' '.");
            valid = false;
        }else if (seperatorCount != 2){
            System.out.println(input + " - INVALID: Incorrect number of seperators. There must be 2. Seperators can be '-', '/', or ' '.");
            valid = false;
        }else if (seperatorMismatch){
            System.out.println(input + " - INVALID: Seperators don't match. Both seperators must be the same. Seperators can be '-', '/', or ' '.");
            valid = false;
        }else if (day.length() != 2){
            System.out.println(input + " - INVALID: Day length invalid. Day input must be d, dd, or 0d.");
            valid = false;
        }else if (dayInt < 1 || dayInt > maxDate){
            System.out.println(input + " - INVALID: Day out of range. Must be between 1 and " + maxDate + ".");
            valid = false;
        }else if (month.length() != 3){
            System.out.println(input + " - INVALID: Month invalid. Month input must be m, mm, 0m, JAN, Jan, or jan.");
            valid = false;
        }else if (monthNum < 1 || monthNum > 12){
            System.out.println(input + " - INVALID: Month out of range. Month input must be m, mm, 0m, JAN, Jan, or jan, and must be between 1 and 12.");
            valid = false;
        }else if (year.length() != 4){
            System.out.println(input + " - INVALID: Year length invalid. Year input must be yy or yyyy.");
            valid = false;
        }else if (yearInt < 1753 || yearInt > 3000){
            System.out.println(input + " - INVALID: Year out of range. Must be between 1753 and 3000.");
            valid = false;
        }else if (!monthValid){
            System.out.println(input + " - INVALID: Month invalid. Month input must be m, mm, 0m, JAN, Jan, or jan.");
            valid = false;
        }else if (ogMonth.length() == 3){
            String temp = "";
            temp += ogMonth.charAt(0);
            try {
                int x = Integer.parseInt(temp);
                if (x == 0) {
                    System.out.println(input + " - INVALID: Month invalid. Month input must be m, mm, 0m, JAN, Jan, or jan.");
                    valid = false;
                }
            }catch(Exception e){
                //System.out.println(e);
            }
        }

        //VALID DATE
        if (valid){
            System.out.println(day + " " + month + " " + year);
        }
    }
}
