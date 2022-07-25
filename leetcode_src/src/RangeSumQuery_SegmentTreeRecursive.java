import java.util.Arrays;
import java.util.Random;

public class RangeSumQuery_SegmentTreeRecursive {
    int[] tree;
    int n;

    int[] nums;

    public RangeSumQuery_SegmentTreeRecursive(int[] nums) {
        n = nums.length;
        this.nums = nums;
        tree = new int[n*4];
        buildTree_recursive(nums, 1, 0, n-1);
    }

    private void buildTree_recursive(int[] nums, int v, int l, int r) {
        if(l == r) {
            tree[v] = nums[l];
        }
        else {
            int m = (l+r)/2;
            buildTree_recursive(nums, v * 2, l, m);
            buildTree_recursive(nums, v * 2 + 1, m+1, r);
            tree[v] = tree[v*2] + tree[v*2+1];
        }
    }

    public void update(int index, int val) {
        int diff = val - this.nums[index];
        int v = 1;
        int l = 0;
        int r = n-1;

        while(l < r) {
            tree[v] += diff;
            int m = (l+r) / 2;
            if(index <= m) {
                r = m;
                v = v*2;
            }
            else if(index > m) {
                l = m+1;
                v = v*2+1;
            }
        }
        tree[v] += diff;
    }



    public int sumRange(int left, int right) {
        return -1;
    }

    public static void main(String[] args) {
        // int[] n = new int[]{18, 17, 13, 19, 15, 11, 20, 12, 33, 25};
        int[] n = new int[]{1, 2, 3, 4, 5, 6};
        Random r = new Random();

        RangeSumQuery_SegmentTreeRecursive sol = new RangeSumQuery_SegmentTreeRecursive(n);
        System.out.println(Arrays.toString(sol.tree));
        sol.update(4, 3);
        System.out.println(Arrays.toString(sol.tree));

        /* for(int i = 0; i < 10; i++) {
            // int[] n = new Random().ints(-100, 100).limit(r.nextInt((int)(3*1e4)+1)).toArray();
            int[] n = new Random().ints(-100, 100).limit(r.nextInt(10)+1).toArray();
            RangeSumQuery_SegmentTree sol = new RangeSumQuery_SegmentTree(n);
            System.out.println(Arrays.toString(sol.tree));
        } */

    }
}
