class MyCalendar:

    def __init__(self):
        self.booked = []

    def book(self, start: int, end: int) -> bool:
        i = bisect.bisect_right(self.booked, start)
        if i & 1 or (i < len(self.booked) and self.booked[i] < end):
            return False
        self.booked[i:i] = [start, end]
        return True

# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)