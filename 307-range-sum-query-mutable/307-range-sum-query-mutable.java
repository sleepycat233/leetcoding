class NumArray {

    int[] tree;
    int n;

    int[] nums;

    public NumArray(int[] nums) {
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
        update_recursive(index, val);
    }

    private void update_iterative(int index, int val) {
        int diff = val - this.nums[index];
        int v = 1;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            tree[v] += diff;
            int m = (l + r) / 2;
            if (index <= m) {
                r = m;
                v = v * 2;
            } else if (index > m) {
                l = m + 1;
                v = v * 2 + 1;
            }
        }
        tree[v] += diff;
    }

    private void update_recursive(int index, int val) {
        helper(index, val, 1, 0, n-1);
    }

    private int helper(int index, int val, int v, int l, int r) {
        if(l == r) {
            int diff = val - tree[v];
            tree[v] += diff;
            return diff;
        }
        else {
            int m = (l+r)/2;
            int diff = -1;
            if(index <= m) {
                diff = helper(index, val, v*2, l, m);
                tree[v] += diff;
            }
            else {
                diff = helper(index, val, v * 2 + 1, m+1, r);
                tree[v] += diff;
            }
            return diff;
        }
    }

    public int sumRange(int left, int right) {
        return query(1, left, right, 0, n-1);
    }

    private int query(int v, int left, int right, int i, int j) {
        if(j < left || i > right) {
            return 0;
        }

        if(i >= left && j <= right) {
            return tree[v];
        }

        int m = (i + j) / 2;
        if(left > m) {
            return query(v * 2 + 1, left, right, m+1, j);
        }
        else if (right <= m) {
            return query(v * 2, left, right, i, m);
        }

        int leftQuery = query(v*2, left, m, i, m);
        int rightQuery = query(v*2+1, m+1, right, m+1, j);

        return leftQuery + rightQuery;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */