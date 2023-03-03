package TestStuff;

public class SelectionSort{

    int[] nums = {3,6,5,4,2,7,9,5,2,6,9,6,3,2,5,8,0,1,7};

    public static void main(String[]args){
        SelectionSort test = new SelectionSort();
        test.sortNums();
    }

    public void sortNums() {
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if (nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int i: nums) System.out.print(i + ", ");
    }
}