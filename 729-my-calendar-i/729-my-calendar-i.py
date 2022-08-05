class MyCalendar:

    def __init__(self):
        self.booked = []

    def book(self, start: int, end: int) -> bool:
        i = bisect.bisect_right(self.booked, start)
        j = bisect.bisect_left(self.booked, end)
        if i % 2 == 0 and i == j:
            self.booked = self.booked[:i] + [start, end] + self.booked[i:]
            return True
        return False

# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)