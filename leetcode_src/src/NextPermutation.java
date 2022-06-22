import java.util.Arrays;
import java.util.stream.IntStream;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int prev = 0;
        
        for(int i = nums.length-1; i >= 0; i--) {
            if(i == nums.length-1 || nums[i] >= prev) {
                prev = nums[i];
            }
            else {
                int j = i+1;
                while(j < nums.length && nums[j] > nums[i]) {
                    j++;
                }
                swap(nums, i, j-1);
                reverse(nums, i+1, nums.length);
                return;
            }
        }

        reverse(nums, 0, nums.length);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 0 1 2 3 4
    private void reverse(int[] arr, int start, int end) {
        for(int i = start, j = end-1; i < (start+end+1)/2; i++, j--) {
            swap(arr, i, j);
        }
    }

    public static void main(String[] args) {
        NextPermutation sol = new NextPermutation();
/*         int[] test = IntStream.range(0, 5)
                        .toArray();

        sol.reverse(test, 2, 4);
        System.out.println(Arrays.toString(test));
 */
        // int[] res = new int[]{1, 2, 3};
        int[] res = new int[]{3,2,1};
        sol.nextPermutation(res);
        System.out.println(Arrays.toString(res));

    }
}
