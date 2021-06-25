package week11;

/**Lab 9, May 4th.
 * Selection sort.
 * @author Liam Flynn.*/
public class SelectionSort extends Sorter{
    
    /**Constructor fills array in super class.
     * @param nums Array of numbers.*/
    public SelectionSort(Integer[]nums){
        super(nums);
    }

    /**Does selection sort.*/
    public void sortNums(){
        for (i = 0; i < (nums.length); i++){
            for (j = i; j < (nums.length); j++){
                if (nums[j] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                comparisons++;
                update();
            }
        }
    }
}
