// https://leetcode.com/problems/find-the-duplicate-number/

// thought process:
// - binary search:
// the pigeonhole principle states that if n items are put into m containers, with n>m, then at least one container must contain more than one item
// the problem has that n numbers(from 1 to n inclusive) has to fill n+1 slots, and allows only one repeated number; thus there exists one and only one number that is put into two or more slots.
//suppose _target_ is the duplicated number, count[i] represents the counting of numbers smaller or equals to i, we then have
// from [1, target-1], count[i] <= i,(the reason for < is that the dup number can appear many times(more than twice)), from [target, n], count[i] > i.
// thus, the smallest number that has the relation of count[i] > i is the target number.
// Binary Search is applicable to find this number because it exists within a bounded range from [1, n], and as i increases, count[i] increases monotonicly.

public class FindDuplicateNumber {
    // 1 2 3 4 5 5
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        int l = 1, r = n-1;
        while(l < r) {
            int m = (r+l)/2;
            int count = 0;
            for(int i = 0; i < n; i++) {
                if(nums[i] <= m) {
                    count++;
                }
            }
            if (count <= m)
                l = m + 1;
            else // count > m
                r = m;
        }
        return l;
    }

    // cycle detection
    public int findDuplicate2(int[] nums) {
        int fast = 0, slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        fast = 0;
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    public static void main(String[] args) {
        FindDuplicateNumber sol = new FindDuplicateNumber();
        System.out.println(sol.findDuplicate2(new int[]{1,3,4,2,2}));
        System.out.println(sol.findDuplicate2(new int[]{3,1,3,4,2}));
        System.out.println(sol.findDuplicate2(new int[]{1,2,3,4,4}));
    }
}
