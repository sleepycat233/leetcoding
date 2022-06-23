class Solution {
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
}