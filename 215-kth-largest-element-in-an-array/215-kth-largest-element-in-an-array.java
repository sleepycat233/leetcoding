class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int n : nums) {
            pq.add(n);
        }
        while(--k > 0) {
            pq.poll();
        }
        return pq.poll();
    }
}