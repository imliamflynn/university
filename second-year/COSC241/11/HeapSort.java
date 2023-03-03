package week11;

/**Lab 11, May 18th.
 * Heap sort.
 * @author Liam Flynn.*/
public class HeapSort extends Sorter{

    /**Constructor fills array in super class.
     * @param nums Array of numbers.*/
    public HeapSort(Integer[]nums){
        super(nums);
    }

    /**Calls heap sort.*/
    public void sortNums(){
        heapSort(nums);
    }

    /**
     * Does heap sort.
     * @param nums is the array to be sorted.
     */
    public void heapSort(Integer[] nums){
        int n = nums.length;
        for (int i = n/2 - 1; i >= 0; i--){
            comparisons++;
            update();
            heapify(nums, n, i);
        }
        for (i = n - 1; i >= 0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            comparisons++;
            update();
            heapify(nums, i, 0);
        }
    }
    
    /**
     * Does the heapify part of heap sort.
     * @param nums is the array to be sorted.
     * @param n is array length.
     * @param i is max.
     */
    public void heapify(Integer[] nums, int n, int i){
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && nums[left] > nums[max]){
            max = left;
            comparisons++;
            update();
        }
        if (right < n && nums[right] > nums[max]){
            max = right;
            comparisons++;
            update();
        }
        if (max != i){
            int temp = nums[i];
            nums[i] = nums[max];
            nums[max] = temp;
            comparisons++;
            update();
            heapify(nums, n, max);
        }
    }
}
