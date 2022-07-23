import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {


    //! time limit exceed
    // insertion sort
    public List<Integer> countSmaller_naive(int[] nums) {
        Integer[] counts = new Integer[nums.length];
        int[] sorted = new int[nums.length];
        int k = -1;

        for(int i = nums.length-1; i >= 0; i--) {
            int key = nums[i];
            int j = k+1;
            while(j >= 1 && key <= sorted[j-1]) {
                sorted[j] = sorted[j-1];
                j--;
            }
            sorted[j] = key;
            k++;
            counts[i] = j;
        }

        return Arrays.asList(counts);
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf sol  = new CountOfSmallerNumbersAfterSelf();
        System.out.println(sol.countSmaller_naive(new int[]{5,2,6,1}));
    }
}
