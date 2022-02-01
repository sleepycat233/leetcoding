class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
                int[] res = new int[m+n];
        int i = 0, j = 0, k = 0;
        while(j < m && k < n) {
            if(nums1[j] <= nums2[k]) {
                res[i] = nums1[j++];
                i++;
            }
            else {
                res[i] = nums2[k++];
                i++;
            }
        }

        while(j < m) {
            res[i] = nums1[j++];
            i++;
        }
        while(k < n) {
            res[i] = nums2[k++];
            i++;
        }

        for(i = 0; i < res.length; i++) {
            nums1[i] = res[i];
        }
    }
}