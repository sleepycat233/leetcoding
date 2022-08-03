class MyCalendar {
    List<int[]> bookings;
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int[] interval = new int[]{start, end};
        for (int[] book : bookings)
            if((start <= book[0] && end >= book[1]) ||
               (start >= book[0] && start < book[1]) ||
               (end > book[0] && end < book[1]))
                return false;
        bookings.add(interval);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */