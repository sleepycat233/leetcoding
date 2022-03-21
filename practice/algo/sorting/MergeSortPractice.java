import java.util.*;

public class MergeSortPractice {
    static public void sort(int[] a) {
        int[] res = divide(a, 0, a.length-1);
        for(int i = 0; i < a.length; i++) {
            a[i] = res[i];
        }
    }

    static private int[] divide(int[] a, int l, int r) {
        if(l == r) {
            return new int[]{a[l]};
        }
        else {
            int mid = (l+r)/2;
            return merge(divide(a, l, mid), divide(a, mid+1, r));
        }
    }

    static private int[] merge(int[] l1, int[] l2) {
        int i = 0, j = 0, k = 0;
        int[] res = new int[l1.length+l2.length];

        while(i < l1.length && j < l2.length) {
            if(l1[i] < l2[j]) {
                res[k++] = l1[i++];
            }
            else {
                res[k++] = l2[j++];
            }
        }
        while(i < l1.length) {
            res[k++] = l1[i++];
        }
        while(j < l2.length) {
            res[k++] = l2[j++];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 1, 2, 5};
        MergeSortPractice.sort(a);
        System.out.println(Arrays.toString(a));
    }

}