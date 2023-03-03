package TestStuff;

public class Doodle {

    //Insertion sort
    public void sortNums(){
        for (i = 0; i < nums.length; i++){
            Integer key = nums[i];
            for (j = i - 1; j >= 0; j--){
                if (nums[j] > key){
                    nums[j+1] = nums[j];
                    nums[j] = key;
                }
            }
        }
    }

    //Selection sort
    public void sortNums(){
        for(i = 0; i < nums.length; i++){
            for (j = i; j < nums.length; j++){
                if (nums[i] > nums[j]){
                    Integer temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        })
    }

    //isSetOf1toN
    public static boolean isSetOf1toN(int[][] t){
        boolean b = true;
        int size = 0;
        for (int[] row: t){
            for(int i: row){
                size++;
            }
        }
        boolean[] boolArr = new boolean[size];
        for (int[] row2 : t){
            for(int value: row2){
                if(value <= size) boolArr[value-1] = true;
            }
        }
        for(boolean bool: boolArr){
            if(!bool) b = false;
        }
        return b;
    }

    //addToRow
    protected Integer addtoRow(Cell curr, int value){
        while (curr != null){
            if (curr.value > value){
                int temp = curr.value;
                curr.value = value;
                return temp;
            }
            if (curr.right == null){
                curr.right = new Cell(value);
                curr.right.left = curr;
                if (curr.above != null){
                    curr.right.above = curr.above.right;
                    curr.right.above.below = curr.right;
                }
                return null;
            }
            curr = curr.right;
        }
        return null;
    }

    //addValue
    public void addValue(Intger value){
        if (smallest == null){
            smallest = new Cell(value);
            return;
        }
        Cell c = smallest;
        while(c != null){
            value = addToRow(c,value);
            if (value == null) return;
            if(c.below == null){
                c.below = new Cell(value);
                c.below.above = c;
                return;
            }
            c = c.below;
        }
    }
}
