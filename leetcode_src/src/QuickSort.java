import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] nums) {
        RandomizedQuickSort(nums, 0, nums.length-1);
    }

    private static void RandomizedQuickSort(int[] nums, int l, int r) {
        if(l < r) {
            int pivot = partition(nums, l, r);
            RandomizedQuickSort(nums, l, pivot-1);
            RandomizedQuickSort(nums, pivot+1, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = (int)(Math.random() * (r - l + 1) + l);
        swap(nums, pivot, r);
        int x = nums[r];

        int j = l-1;
        for(int i = l; i < r; i++) {
            if(nums[i] <= x) {
                swap(nums, j+1, i);
                j++;
            }
        }
        swap(nums, j+1, r);
        return j+1;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 5, 4, 2};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
