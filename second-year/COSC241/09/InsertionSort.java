package week09;

/**Lab 9, May 4th.
 * Insertion sort.
 * @author Liam Flynn.*/
public class InsertionSort extends Sorter{
    
    /**Constructor fills array in super class.
     * @param nums Array of numbers.*/
    public InsertionSort(Integer[]nums){
        super(nums);
    }

    /**Does insertion sort.*/
    public void sortNums(){
        Integer key = 0;
        for (i = 1; i < nums.length; i++){
            key = nums[i];
            for (j = i - 1; j >= 0; j--){
                if (nums[j] > key){
                    nums[j+1] = nums[j];
                    nums[j] = key;
                }
                comparisons++;
                update();
            }
        }
    }
}
