public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] t = new int[nums.length];
        int len = 1;
        for(int i = 0; i < nums.length; i++) {
            t[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    t[i] = Math.max(t[i], t[j] + 1);
                }
            }
            len = Math.max(len, t[i]);
        }

        return len;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
        System.out.println(sol.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(sol.lengthOfLIS(new int[] {1, 3, 6, 7, 9, 4, 10, 5, 6}));
        System.out.println(sol.lengthOfLIS(new int[] {1}));
    }
}
