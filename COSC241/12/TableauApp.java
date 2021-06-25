package week12;

public class TableauApp {

    // admin
    public static void main(String[] args) {
        final int[][] valid = { { 1, 4, 5, 10, 11 }, { 2, 6, 8 }, { 3, 9, 12 }, { 7 } };
        System.out.println(TableauApp.toString(valid));
    }

    // admin
    public static boolean isTableau(int[][] t) {
        return rowLengthsDecrease(t) && rowValuesIncrease(t) && columnValuesIncrease(t) && isSetOf1toN(t);
    }

    // admin
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static boolean rowLengthsDecrease(int[][] t) {
        boolean b = true;
        for (int i = 0; i < t.length - 1; i++) {
            if (t[i].length < t[i + 1].length) b = false;
        }
        return b;
    }

    public static boolean rowValuesIncrease(int[][] t) {
        boolean b = true;
        for (int[] row : t) {
            for (int i = 1; i < row.length; i++) {
                if (row[i] < row[i - 1]) b = false;
            }
        }
        return b;
    }

    public static boolean columnValuesIncrease(int[][] t) {
        boolean b = true;
        for (int i = t.length - 1; i > 0; i--) {
            for (int j = 0; j < t[i].length; j++) {
                if (t[i][j] < t[i - 1][j]) b = false;
            }
        }
        return b;
    }

    public static boolean isSetOf1toN(int[][] t) {
        boolean b = true;
        int size = 0;
        for (int[] row : t) {
            for (int value : row)
                size++;
        }
        boolean[] boolArr = new boolean[size];
        for (int[] row : t) {
            for (int value : row) {
                if (value <= size) boolArr[value - 1] = true;
            }
        }
        for (boolean bool : boolArr) {
            if (!bool) b = false;
        }
        return b;
    }
}
