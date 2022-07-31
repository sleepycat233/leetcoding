public class RangeSumQuery_SegmentTreeIterative {
    int n;
    int[] tree;

    public RangeSumQuery_SegmentTreeIterative(int[] nums) {
        this.n = nums.length;
        this.tree = new int[n*2];
        buildTree_iterative(nums);
    }

    private void buildTree_iterative(int[] nums) {
        for (int i = n; i < n * 2; i++)
            tree[i] = nums[i - n];
        for (int j = n - 1; j > 0; j--)
            tree[j] = tree[j * 2] + tree[j * 2 + 1];
    }
}
