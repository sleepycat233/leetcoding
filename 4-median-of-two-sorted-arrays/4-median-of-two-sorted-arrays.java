class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m1 = 0, m2 = 0;
        boolean rdone = false, ldone = false, found = false;
        int l1 = 0, r1 = (nums1 != null) ? nums1.length-1 : -1;
        int l2 = 0, r2 = (nums2 != null) ? nums2.length-1 : -1;
        // if(nums1 == null) ldone = true;
        // if(nums2 == null) rdone = true;

        while(found == false) {

            // System.out.format("%d, %d, %d, %d\n", l1, r1, l2, r2);
            if(l1 > r1) {
                ldone = true;
            }
            else if(l2 > r2) {
                rdone = true;
            }

            if(l1 == r1 && l2 == r2) {
                found = true;
                m1 = nums1[l1];
                m2 = nums2[l2];
            }
            else if (rdone == true && (r1 - l1 == 1 || l1 == r1)) {
                found = true;
                m1 = nums1[l1];
                m2 = nums1[r1];
            }
            else if (ldone == true && (r2 - l2 == 1 || l2 == r2)) {
                found = true;
                m1 = nums2[l2];
                m2 = nums2[r2];
            }
            else {
            }

            if(!rdone && !ldone) {
                if(nums1[l1] < nums2[l2]) {
                    l1++;
                }
                else {
                    l2++;
                }
                if(nums1[r1] > nums2[r2]) {
                    r1--;
                }
                else {
                    r2--;
                }
            }
            else if(rdone) {
                l1++;
                r1--;
            }
            else {
                l2++;
                r2--;
            }
        }

        return (double)(m1+m2) / 2;
    
    }
}