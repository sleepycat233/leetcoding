public class RangeSumQuery_SegmentTreeIterative {
    int[] tree;

    private void buildTree_iterative(int[] nums) {
        int n = nums.length;

        for (int i = n; i < n * 2; i++)
            tree[i] = nums[i - n];
        for (int j = n - 1; j > 0; j--)
            tree[j] = tree[j * 2] + tree[j * 2 + 1];
    }
}
