/******************************************************************************
 * COSC326, Etude 02 Syllable Slam                                            *
 *                                                                            *
 * Takes input from stdin (via scanner), verifies that input is of letters    *
 * only. Counts the sylables and returns the amount of sylables found.        *
 *                                                                            *
 *                                                                            *
 * References:                                                                *
 *  - Collins English Dictionary                                              *
 *  - https://syllablecounter.net/  for test purposes                         *
 *  - https://www.readingrockets.org/article/                                 *
 *                            two-four-syllable-words-short-vowels-and-schwa  *
 *  - https://www.howmanysyllables.com/                                       *
 * (these sites have contradicting syllable results)                          *
 *                                                                            *
 * dictionary list: https://github.com/neuromancer/libmind                    *
 * merged into 4 files for easier handling                                    *
 *                                                                            *
 * v1 manual version : everything manually via counter & loops                *
 * v2 regex version : everything done via regex matcher                       *
 *                                                                            *
 *  compile & execute: javac Etude02.java && java Etude02                     *
 *  or execute on the fly: java Etude02.java                                  *
 *  { mass validation test: java Etude02.java < test_data.txt }               *
 *                                                                            *
 * @author CGi, StudentId: 9355607                                            *
 * @author Harry Pusey, StudentId: 5738464                                    *
 * @author Ben Stacey, StudentId: 2157359                                     *
 * @author Liam Flynn, StudentId: 4239344                                     *
 *                                                                            *
 ******************************************************************************/
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EtudeCopy{
    public static int debug = 1; // if debug = 1 then give a few more details

    /**
     * Main method starts the non-static method start()
     *
     * @param args.
     */
    public static void main(String[] args){
        new EtudeCopy().start();
    }

    /**
     * Main method takes input from stdin via scanner, matches input and
     * sends it, case depending, to processData or if debug line, print it
     */
    public void start() {
        if(debug > 1) {
            System.out.println("< < < < < < < < <\n\n\n\n\n< < < < < < < < <\n");
        }

        Scanner input = new Scanner(System.in);
        while ( input.hasNextLine() ) {
            String str = input.nextLine();
            /* only allow letters */
            if(str.startsWith("------")) {
                System.out.println(str);
            }else {
                if(str.matches("[\\sa-zA-Z]+")) {
                    processData(str);
                }else if (str.equals("")) { System.out.println(); // if empty dont do anything
                }else { // else present new line or error
                    //System.out.println("Input contains invalid input (valid: letters a-z)");
                    System.out.println();
                }
            }
        }
    }

    /**
     * First does a dictionary check and if not found, trys via regex
     * (dictionary from: https://github.com/neuromancer/libmind and merged)
     *
     * regex help
     * www.ic.unicamp.br/~celio/inf533/docs/Regular_%2520Expressions.doc
     */
    public void processData(String eachWord){
        int occurenceCounter = 0;

        /* test dictionary int dictResult0 = dictionaryMatcher(eachWord, 0); */
        int dictResult0 = 0;
        int dictResult1 = dictionaryMatcher(eachWord, 1);
        int dictResult2 = dictionaryMatcher(eachWord, 2);
        int dictResult3 = dictionaryMatcher(eachWord, 3);
        int dictResult4 = dictionaryMatcher(eachWord, 4);
        int dictResult5 = dictionaryMatcher(eachWord, 5);
        int dictResult6 = dictionaryMatcher(eachWord, 6);
        int dictResult7 = dictionaryMatcher(eachWord, 7);

        String w; // for debug
        if (dictResult0 == 0 && dictResult1 == 0 &&
                dictResult2 == 0 && dictResult3 == 0 &&
                dictResult4 == 0 && dictResult5 == 0 &&
                dictResult6 == 0 && dictResult7 == 0) {

            w = "pattern"; // debug info
            String patternString = "(?i)[aeiouy][aeiouy]*";
            occurenceCounter = patternMatcher(eachWord, patternString);
        } else {
            w = "dictionary"; // debug info

            /* for reading purpose in a different syle: block */
            if (dictResult0 > 0)  { occurenceCounter = 0;  }
            if (dictResult1 == 1) { occurenceCounter = 1; }
            if (dictResult2 == 2) { occurenceCounter = 2; }
            if (dictResult3 == 3) { occurenceCounter = 3; }
            if (dictResult4 == 4) { occurenceCounter = 4; }
            if (dictResult5 == 5) { occurenceCounter = 5; }
            if (dictResult6 == 6) { occurenceCounter = 6; }
            if (dictResult7 == 7) { occurenceCounter = 7; }
        }

        /* if debug give more details */
        if(debug > 0) {
            String format = "%-20s";
            System.out.format(format, eachWord);
            System.out.println(eachWord + ": " + occurenceCounter + " syllables" + " | " +w);
        }else {
            System.out.println(occurenceCounter);
        }
    }

    /**
     * patternMatcher is used to count the occurances of the match
     */
    public int patternMatcher(String eachWord, String patternString){
        int counter = 0;
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(eachWord);

        while (matcher.find()){
            counter++;
        }
        return counter;
    }

    /**
     * dictonaryMatcher gets the inputed word (eachWord) then checks it through the dictionary of syllables looking for matches
     *
     */
    public int dictionaryMatcher(String eachWord, int dictionaryNumber){
        String line = "";

        try {
            Scanner input = new Scanner(System.in);
            File file = new File("dictionary/" + dictionaryNumber + "Syllable.txt");
            input = new Scanner(file);

            while (input.hasNextLine() && line != null) {
                line = input.nextLine();
                if (line.matches(eachWord)) {
                    return dictionaryNumber;
                }

                String shortWord;
                /* check if word exists without last 1 letters at the end */
                shortWord = eachWord.substring(0, eachWord.length() - 1);
                if (line.matches(shortWord) ) {
                    return dictionaryNumber;
                }
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }
}