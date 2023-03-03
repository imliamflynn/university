package TestStuff;
public class TestStudy{

    //Part A

    public static boolean rowLengthsDecrease(int[][] t){
        boolean b = true;
        for (int i = 0; i < t.length - 1; i++){
            if (t[i].length < t[i+1].length){
                b = false;
            }
        }
        return b;
    }

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

    public static boolean isSetOf1toN(int[][] t){
        boolean b = true;
        int count = 0;
        for (int i = 0; i < t.length; i++){
            for (int x = 0; x < t[i].length; x++){
                count ++;
            }
        }
        boolean[] boolArr = new boolean[count];
        for (int i = 0; i < t.length; i++){
            for (int x = 0; x < t[i].length; x++){
                if (t[i][x] <= count){
                    boolArr[t[i][x]-1] = true;
                }
            }
        }
        for (boolean bool: boolArr){
            if (!bool){
                b = false;
            }
        }
        return b;
    }

    //Part B

    public Integer addToRow(Cell curr, int value){
        Cell c = curr;
        while (c != null){
            if (c.value > value){
                int x = c.value;
                c.value = value;
                return x;
            }
            if (c.right == null){
                Cell end = new Cell(value);
                c.right = end;
                end.left = c;
                if (c.above != null){
                    end.above = c.above.right;
                    end.above.below = end;
                }
                return null;
            }
            c = c.right;
        }
        return null;
    }

    public void addValue(Integer value){
        if (smallest == null){
            smallest = new Cell(value);
            return;
        }
        Integer x = value;
        Cell c = smallest;
        while (c != null){
            x = addToRow(c, x);
            if (x == null){
                return;
            }
            if (c.below == null){
                c.below = new Cell(x);
                c.below.above = c;
                return;
            }
            c = c.below;
        }
    }

    //Part C

    //Selection sort
    public void sortNums(){
        for (i = 0; i < nums.length; i++){
            for (j = i; j < nums.length; j++){
                if (nums[j] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    //Insertion sort
    public void sortNumbers(){
        for (i = 1; i < nums.length; i++){
            Integer key = nums[i];
            for (j = i - 1; j >= 0; j--){
                if (nums[j] > key){
                    nums[j+1] = nums[j];
                    nums[j] = key;                
                }
            }
        }
    }
}