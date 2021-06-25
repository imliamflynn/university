package week08;
import java.util.*;
import java.io.*;

/**Lab 08, April 30th.
 * Uses an array of letter frequencies to make a random word.
 * @author Liam Flynn*/
public class FrequencyGenerator implements WordGenerator{
    
    /**Random source used to generate words.*/
    private Random random;
    /**Array which will be filled with the letter frequencies.*/
    private double[] w;
    /**Alphabet length.*/
    private final int alph = 26;

    /**Fills data fields.
     * @param r a Random instance*/
    public FrequencyGenerator(Random r) {
        random = r;
        w = weights();
    }

    /**Returns an array filled with letter frequencies.
     * @return an array filled with letter frquencies.*/
    public double[] weights(){
        int count = 0;
        double[] x = new double[alph];
        File text = new File("letter-frequencies.txt");
        try{
            Scanner scan = new Scanner(text);
            while (scan.hasNextDouble()){
                x[count] = scan.nextDouble();
                count++;
            }
        }catch(FileNotFoundException e){
            System.out.println("Error: File not found");
        }
        return x;
    }

    /**Chooses index to use for the array.
     * @param w an array filled with letter frequencies.
     * @return an int representing an index.*/
    public int chooseIndex(double[] w){
        int i = 0;
        //Random rand = new Random();
        double r = random.nextDouble();
        while (r > w[i]){
            r = r - w[i];
            i++;
        }
        return i;
    }

    /**Makes a random word using the chooseIndex method.
     * @param n the required length of the word.
     * @return a random word of length n.*/
    public String nextWord(int n) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char c = (char) ('a' + chooseIndex(w));
            result.append(c);
        }
        return result.toString();
    }
}
