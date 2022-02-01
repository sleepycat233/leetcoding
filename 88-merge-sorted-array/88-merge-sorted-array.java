class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
                int p1 = m-1, p2 = n-1;

        while(p1 >= 0 || p2 >= 0) {
            int cur;
            if(p1 < 0) {
                cur = nums2[p2--];
            }
            else if (p2 < 0) {
                cur = nums1[p1--];
            }
            else if (nums1[p1] <= nums2[p2]) {
                cur = nums2[p2--];
            }
            else {
                cur = nums1[p1--];
            }
            nums1[p1+p2+2] = cur;
        }
    }
}