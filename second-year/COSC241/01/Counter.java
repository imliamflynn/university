package week01; import java.util.Scanner;
/** Lab 1, March 5.
 * @author Liam Flynn
 */
public class Counter{
    /** Main method, counts number of words and lines in input.
     * @param args */
    public static void main(String[]args){
        int lines = 0, words = 0;
        Scanner scan = new Scanner(System.in);
    
        while (scan.hasNextLine()){
            lines ++;
            String s = scan.nextLine();
            Scanner scan2 = new Scanner(s);
            while (scan2.hasNext()){
                words++;
                scan2.next();
            }
        }
        System.out.println("lines: " + lines);
        System.out.println("words: " + words);
    }
}
