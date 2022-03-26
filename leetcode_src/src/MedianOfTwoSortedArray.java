import java.util.*;

public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int[] a = mergeTwoSortedArray(nums1, nums2);
        double midian = (double)(a[a.length/2] + a[(int)((double)a.length/2 - 0.5)]) / 2;
        return midian;
    }

    private int[] mergeTwoSortedArray(int[] nums1, int[] nums2)
    {
        int m = (nums1 != null) ? nums1.length : 0;
        int n = (nums2 != null) ? nums2.length : 0;
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

    // not good, move l1 and l2 is sufficient
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m1 = 0, m2 = 0;
        boolean rdone = false, ldone = false, found = false;
        int l1 = 0, r1 = (nums1 != null) ? nums1.length-1 : -1;
        int l2 = 0, r2 = (nums2 != null) ? nums2.length-1 : -1;
        // if(nums1 == null) ldone = true;
        // if(nums2 == null) rdone = true;

        while(found == false) {

            System.out.format("%d, %d, %d, %d\n", l1, r1, l2, r2);
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

    public static void main(String[] args)
    {
        MedianOfTwoSortedArray sol = new MedianOfTwoSortedArray();
        int[] n1 = new int[]{1, 7, 8};
        int[] n2 = new int[]{3, 5, 9};
        // int[] n1 = new int[]{1, 2, 3, 4, 9};
        // int[] n2 = new int[]{4, 5, 6};
        // System.out.println(Arrays.toString(sol.mergeTwoSortedArray(n1, n2)));
        System.out.println(sol.findMedianSortedArrays(n1, n2));
        System.out.println(sol.findMedianSortedArrays2(n1, n2));
    }
}
