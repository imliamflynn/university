package week12;

public class InsertionSort extends Sorter {

    public InsertionSort(Integer[] nums) {
        super(nums);
    }

    public void sortNums() {
        for(i = 1; i < nums.length; i++){
            Integer key = nums[i];
            for(j = i - 1; j > 0; j--){
                if(nums[j] > key){
                    nums[j+1] = nums[j];
                    nums[j] = key;
                }
            }
        }
    }
}
