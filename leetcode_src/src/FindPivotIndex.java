public class FindPivotIndex {
    //optimal
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        for(int n : nums) totalSum += n;
        for(int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i] + left[i-1];
        }

        right[nums.length-1] = nums[nums.length-1];
        for (int j = nums.length-2; j >= 0; j--) {
            right[j] = nums[j] + right[j+1];
        }

        for(int p = 0; p < nums.length; p++) {
            int lnum = (p-1 >= 0) ? left[p-1] : 0;
            int rnum = (p+1 < nums.length) ? right[p+1] : 0;
            if(lnum == rnum) return p;
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex sol = new FindPivotIndex();
        System.out.println(sol.pivotIndex(new int[]{2,1,-1}));
    }
}
