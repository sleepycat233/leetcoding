class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int[] a = mergeTwoSortedArray(nums1, nums2);
        double midian = (double)(a[a.length/2] + a[(int)((double)a.length/2 - 0.5)]) / 2;
        return midian;
    }

    private int[] mergeTwoSortedArray(int[] nums1, int[] nums2)
    {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (j < m && k < n) {
            if (nums1[j] <= nums2[k]) {
                res[i++] = nums1[j++];
            }
            else {
                res[i++] = nums2[k++];
            }
        }

        while (j < m) {
            res[i++] = nums1[j++];
        }
        while (k < n) {
            res[i++] = nums2[k++];
        }

        return res;
    }
}