public class Find132Pattern {
    public boolean find132pattern(int[] nums) {

        for(int i = 1; i < nums.length-1; i++) {
            int mid = nums[i];
            int lo = Integer.MAX_VALUE;

            for(int l = 0; l < i; l++) {
                if(nums[l] < lo) lo = nums[l];
            }
            for(int r = i+1; r < nums.length; r++) {
                if(nums[r] > lo && nums[r] < mid) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Find132Pattern sol = new Find132Pattern();
        System.out.println(sol.find132pattern(new int[]{3,1,4,2}));
    }
}
