import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    //maxheap
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, nums.length);
        for(int i = nums.length - 1; i > nums.length - k; i--) {
            swap(nums, 0, heapSize-1);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for(int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    private void maxHeapify(int[] nums, int p, int heapSize) {
        int l = p * 2 + 1, r = p * 2 + 2, largest = p;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if(p != largest) {
            swap(nums, p, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // min heap
    public int findKthLargest_minheap(int[] nums, int k) {

        for(int i = 0; i < k; i++) {

        }

        return -1;
    }

    // quick sort - O(n)
    public int findKthLargest1(int[] nums, int k) {
        quickSelect(nums, k, 0, nums.length);
        return nums[k - 1];
    }

    private void quickSelect(int[] nums, int k, int l, int r) {
        if(l < r) {
            int pivot = partition(nums, l, r);
            if(pivot == k) return;
        }

    }

    private int partition(int[] nums, int l, int r) {
        return -1;
    }


    //naive
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest3(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int n : nums) {
            pq.add(n);
        }
        while (--k > 0) {
            pq.poll();
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray sol = new KthLargestElementInAnArray();
        System.out.println(sol.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(sol.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
