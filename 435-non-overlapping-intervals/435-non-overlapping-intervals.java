class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

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
}