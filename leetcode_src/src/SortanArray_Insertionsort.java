import java.util.*;

public class SortanArray_Insertionsort {
    public int[] sortArray(int[] nums) {
        for(int j = 1; j < nums.length; j++) {
            int v = nums[j];
            int i = j-1;
            while (i >= 0 && nums[i] > v) {
                nums[i+1] = nums[i];
                i--;
            }
            nums[i+1] = v;
        }

        return nums;
    }

    public static void main(String[] args) {

        SortanArray_Insertionsort sol = new SortanArray_Insertionsort();
        int[] arr = new int[] {9, 1, 3, 544, 2, 4, 5, 32};
        // int[] arr = new int[] {5, 3, 1};
        sol.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
