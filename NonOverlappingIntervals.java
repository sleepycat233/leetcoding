import java.util.*;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int[] t = new int[intervals.length];

        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     public int compare(int[] a, int[] b) {
        //         return Integer.compare(a[0], b[0]);
        //     }
        // });

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int[] i : intervals) {
            System.out.println(Arrays.toString(i));
        }

        for(int i = 0; i < intervals.length; i++) {
            t[i] = 1;
            for(int j = 0; j < i; j++) {
                if(intervals[j][1] <= intervals[i][0]) {
                    t[i] = Math.max(t[i], t[j]+1);
                } else {
                    // t[i] = Math.max(t[i], t[j]);
                }
            }
        }

        System.out.println(Arrays.toString(t));

        return intervals.length - Arrays.stream(t).max().getAsInt();
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        // Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        for (int[] i : intervals) {
            System.out.println(Arrays.toString(i));
        }

        int prev = intervals[0][1];
        int len = 1;
        for(int[] i : intervals) {
            if(i[0] >= prev) {
                len++;
                prev = i[1];
            }
        }

        return intervals.length - len;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals sol = new NonOverlappingIntervals();

        System.out.println(sol.eraseOverlapIntervals2(new int[][]{{1,2}, {3,4}, {2,5}, {1,3}}));
        System.out.println(sol.eraseOverlapIntervals2(new int[][]{{1,2}, {1,2}, {1,2}, {1,2}}));
        System.out.println(sol.eraseOverlapIntervals2(new int[][]{{1,100}, {11,22}, {1,11}, {2,12}}));
        System.out.println(sol.eraseOverlapIntervals2(new int[][]{{1,100}, {11,22}, {1,11}, {2,12}}));
    }
}
