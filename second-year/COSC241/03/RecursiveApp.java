package week03;
/** Lab 3, March 19th.
 * @author Liam Flynn
 */
public class RecursiveApp{
    
    /**The main method.
     * @param args args*/
    public static void main(String[]args){}
    
    /**This method counts the number of digits in a number.
     * @param n is the number whos digits get counted
     * @return number of digits*/
    public static long digits(long n){
        if (n < 10){
            return 1;
        }else{
            return 1 + digits(n/10);
        }
    }
    
    /**This method finds the sum of the digits in a number.
     * @param n is the number whos digits get summed up
     * @return sum of digits*/
    public static long sumOfDigits(long n){
            if (n == 0){
                return 0;
            }else{
                return n % 10 + sumOfDigits(n/10);
            }
        return 0;
    }
}
