package week11;

/**Lab 11, May 11th.
 * Quick sort.
 * @author Liam Flynn.*/
public class QuickSort extends Sorter{
    
    /**Constructor fills array in super class.
     * @param nums Array of numbers.*/
    public QuickSort(Integer[]nums){
        super(nums);
    }

    /**Calls quick sort.*/
    public void sortNums(){
        quickSort(0, nums.length-1);
    }

    /**
     * Does quick sort.
     * @param left left of array.
     * @param right right of array.
     */
    public void quickSort(int left, int right){
        if (left < right){
            int p = partition(left, right);
            comparisons++;
            update();
            quickSort(left, p);
            comparisons++;
            update();
            quickSort(p + 1, right);
        }
    }

    /**
     * Does the partitioning for quick sort.
     * @param left left of array.
     * @param right right of array.
     * @return hole
     */
    public int partition(int left, int right){
        int pivot = nums[left];
        int hole = left;
        i = left + 1;
        j = right;
        while(0 == 0){
            while (j > hole && nums[j] >= pivot){
                j--;
                comparisons++;
                update();
            }
            if (j == hole){
                comparisons++;
                update();
                break;
            }
            nums[hole] = nums[j];
            hole = j;
            while (i < hole && nums[i] < pivot){
                i++;
                comparisons++;
                update();
            }
            if (i == hole){
                comparisons++;
                update();
                break;
            }
            nums[hole] = nums[i];
            hole = i;
            comparisons++;
            update();
        }
        nums[hole] = pivot;
        return hole;
    }
}
