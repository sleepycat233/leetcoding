import java.util.Set;
import java.util.TreeSet;

class MyCalendarI {
    TreeSet<int[]> booked;

    public MyCalendarI() {
        booked = new TreeSet<>((a, b) -> a[0] - b[0]);
    }

    public boolean book(int start, int end) {
        int[] meeting = new int[]{start, end};
        if(booked.isEmpty()) {
            booked.add(meeting);
            return true;
        }
        int[] tmp = new int[]{end, 0};
        int[] arr = booked.ceiling(tmp);
        int[] prev = (arr == null) ? booked.last() : booked.lower(tmp);
        if(prev == null || start >= prev[1]) {
            booked.add(meeting);
            return true;
        }
        return false;
    }
}