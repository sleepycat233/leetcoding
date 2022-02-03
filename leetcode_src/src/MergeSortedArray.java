import java.util.*;

public class MergeSortedArray {
    /* public void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> q = new LinkedList<>();

        for()
    } */

    //two pointer
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

    // reverse two pointer
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = n-1;

        while(p1 >= 0 || p2 >= 0) {
            int cur;
            if(p1 == -1) {
                cur = nums2[p2--];
            }
            else if (p2 == -1) {
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

        // System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args)
    {
        MergeSortedArray sol = new MergeSortedArray();
        int[] n1 = new int[]{1,3,4,7,0,0,0,0};
        int[] n2 = new int[]{0,1,2,3};
        sol.merge2(n1, 4, n2, 4);
    }

    //{4,5,6,7,0,0,0,0}
    //{0,1,2,3}
}
