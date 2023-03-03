package TestStuff;

public class InsertionSort{

    int[] nums = {3,6,5,4,2,7,9,5,2,6,9,6,3,2,5,8,0,1,7};

    public static void main(String[]args){
        InsertionSort test = new InsertionSort();
        test.sortNums();
    }

    public void sortNums() {
        for(int i = 0; i < nums.length; i++){
            Integer key = nums[i];
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] > key){
                    nums[j+1] = nums[j];
                    nums[j] = key;
                }
            }
        }
        for (int i: nums) System.out.print(i + ", ");
    }
}