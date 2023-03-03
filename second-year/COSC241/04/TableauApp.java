package week04;
/**Lab 4, March 26th.
 * @author Liam Flynn
 */
public class TableauApp {

    /**The main method is just used for testing.
     * @param args command line arguments are not used.*/
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
    }

    /**Determines whether the array passed to it is a valid tableau or not.
     * @param t a two-dimensional array to test for tableau-ness.
     * @return true if the parameter is a valid tableau, otherwise false*/
    public static boolean isTableau(int[][] t){
        return (rowLengthsDecrease(t) && rowValuesIncrease(t) &&
                columnValuesIncrease(t) && isSetOf1toN(t));
    }

    /**Returns a string representation of an array based tableau.
     * @param t a two-dimensional array which represents a tableau.
     * @return a string representation of an array based tableau.*/
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**Returns true if row lengths decrease.
     * @param t a two-dimensional array which represents a tableau.
     * @return true if row lengths decrease.*/
    public static boolean rowLengthsDecrease(int[][] t){
        boolean b = true;
        for (int i = 0; i < t.length - 1; i++){
            if (t[i].length < t[i+1].length){
                b = false;
            }
        }
        return b;
    }

    /**Returns true if row values increase.
     * @param t a two-dimensional array which represents a tableau.
     * @return true if row values increase.*/
    public static boolean rowValuesIncrease(int[][] t){
        boolean b = true;
        for (int i = 0; i < t.length; i++){
            for (int x = 0; x < t[i].length - 1; x++){
                if (t[i][x] > t[i][x+1]){
                    b = false;
                }
            }
        }
        return b;
    }

    /**Returns true if column values increase.
     * @param t a two-dimensional array which represents a tableau.
     * @return true if column values increase.*/
    public static boolean columnValuesIncrease(int[][] t){
        boolean b = true;
        for (int i = t.length - 1; i > 0; i--){
            for (int x = 0; x < t[i].length; x++){
                if (t[i][x] < t[i-1][x]){
                    b = false;
                }
            }
        }
        return b;
    }

    /**Returns true if all digits in 2D array go from 1 to N.
     * @param t a two-dimensional array which represents a tableau.
     * @return true if all digits in 2D array go from 1 to N.*/
    public static boolean isSetOf1toN(int[][] t){
        int count = 0;
        boolean bool = true;
        for (int i = 0; i < t.length; i++){
            for (int x = 0; x < t[i].length; x++){
                count ++;
            }
        }
        boolean[] boolArr = new boolean[count];
        for (int i = 0; i < t.length; i++){
            for (int x = 0; x < t[i].length; x++){
                //   for (int y = 1; y <= count; y++){
                if (t[i][x] <= count){
                    boolArr[t[i][x]-1] = true;
                }
                //   }
            }
        }
        for (boolean b: boolArr){
            if (!b){
                bool = false;
            }
        }
        return bool;
    }
}
