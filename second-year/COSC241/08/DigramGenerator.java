package week08;
import java.util.*;
import java.io.*;

/**Lab 08, April 30th.
 * Creates a random word using first letter frequencies and continuations.
 * @author Liam Flynn*/
public class DigramGenerator implements WordGenerator {

    /**Random source used to generate words.*/
    private Random random;
    /**String which gets filled by a file with first letter frequencies.*/
    private String s;
    /**Array of Strings which gets filled by a file with continuations.*/
    private String[] ss;
    /**Alphabet length.*/
    private final int alph = 26;

    /**Fills data fields accordingly.
     * @param r Random instance*/
    public DigramGenerator(Random r) {
        random = r;
        s = firstLetters();
        ss = continuations();
    }

    /**Returns a string from a file.
     * @return a string from a file.*/
    public String firstLetters(){
        String x = "";
        File text = new File("first-letters.txt");
        try{
            Scanner scan = new Scanner(text);
            x = scan.nextLine();
        }catch(FileNotFoundException e){
            System.out.println("Error: File not found");
        }
        return x;
    }

    /**Returns an array of strings from a file.
     * @return an array of strings from a file.*/
    public String[] continuations(){
        int count = 0;
        String[] x = new String[alph];
        File text = new File("continuations.txt");
        try{
            Scanner scan = new Scanner(text);
            while (scan.hasNextLine()){
                x[count] = scan.nextLine();
                count++;
            }
        }catch(FileNotFoundException e){
            System.out.println("Error: File not found");
        }
        return x;
    }

    /**Generates a random letter from a string.
     * @return first letter*/
    public char chooseFirstLetter(){
        return s.charAt(random.nextInt(s.length()));
    }

    /**Generates the next letter given a char.
     * @param c the char representing the previous letter.
     * @return next letter*/
    public char chooseNextLetter(char c){
        int i = c - 'a';
        return ss[i].charAt(random.nextInt(ss[i].length()));
    }

    /**Makes a random word using the chooseFirst/chooseNextLetter methods.
     * @param n the required length of the word.
     * @return a random word of length n.*/
    public String nextWord(int n) {
        StringBuilder result = new StringBuilder();
        char c = chooseFirstLetter();
        result.append(c);
        for(int i = 1; i < n; i++) {
            c = chooseNextLetter(c);
            result.append(c);
        }
        return result.toString();
    }
}
