package week11;

/**Lab 11, May 11th.
 * Merge sort.
 * @author Liam Flynn.*/
public class MergeSort extends Sorter{
    
    /**Constructor fills array in super class.
     * @param nums Array of numbers.*/
    public MergeSort(Integer[]nums){
        super(nums);
    }

    /**Calls merge sort.*/
    public void sortNums(){
        mergeSort(0, nums.length-1);
    }

    /**
     * Does merge sort.
     * @param left left of array.
     * @param right right of array.
     */
    public void mergeSort(int left, int right){
        if (left < right){
            int mid = (left + right) / 2;
            comparisons++;
            update();
            mergeSort(left, mid);
            comparisons++;
            update();
            mergeSort(mid + 1, right);
            comparisons++;
            update();
            merge(left, mid + 1, right);
        }
    }

    /**
     * Does merge sort.
     * @param left left of array.
     * @param mid middle of array.
     * @param right right of array.
     */
    public void merge(int left, int mid, int right){
        Integer[] temp = nums.clone();
        i = left;
        j = left;
        int k = mid;
        while (i < mid && k <= right){
            if (temp[i] <= temp[k]){
                nums[j++] = temp[i++];
                comparisons++;
                update();
            }else{
                nums[j++] = temp[k++];
                comparisons++;
                update();
            }
            comparisons++;
            update();
        }
        while (i < mid){
            nums[j++] = temp[i++];
            comparisons++;
            update();
        }
        while (j <= right){
            nums[j++] = temp[k++];
            comparisons++;
            update();
        }
    }
}
