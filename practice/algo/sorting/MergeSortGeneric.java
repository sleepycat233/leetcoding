package algo.sorting;

import java.util.*;

public class MergeSortGeneric<T> {
    static public <T extends Comparable<? super T>> void sort(T[] a)
    {
        T[] res = divide(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            a[i] = res[i];
        }
    }

    static private <T extends Comparable<? super T>> T[] divide(T[] a, int l, int r)
    {
        if (l == r) {
            @SuppressWarnings("unchecked")
            T[] tmp = (T[]) new Comparable[1];
            tmp[0] = a[l];
            return tmp;
        }
        else {
            int mid = (l + r) / 2;
            return merge(divide(a, l, mid), divide(a, mid + 1, r));
        }
    }

    static private <T extends Comparable<? super T>> T[] merge(T[] l1, T[] l2)
    {
        int i = 0, j = 0, k = 0;
        @SuppressWarnings("unchecked")
        T[] res = (T[]) new Comparable[l1.length + l2.length];

        while (i < l1.length && j < l2.length) {
            if (l1[i].compareTo(l2[j]) < 0) {
                res[k++] = l1[i++];
            }
            else {
                res[k++] = l2[j++];
            }
        }
        while (i < l1.length) {
            res[k++] = l1[i++];
        }
        while (j < l2.length) {
            res[k++] = l2[j++];
        }

        return res;
    }

    public static void main(String[] args)
    {
        Integer[] a = new Integer[] {3, 1, 2, 5};
        String[] s = new String[] {"a", "c", "abfa", "DWQ", "b"};
        MergeSortGeneric.sort(a);
        MergeSortGeneric.sort(s);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(s));
    }
}