class MyCalendar:

    def __init__(self):
        self.slot = []

    def book(self, start: int, end: int) -> bool:
        i = bisect.bisect_right(self.slot, start)
        if i & 1 or (i < len(self.slot) and self.slot[i] < end):
            return False
        self.slot[i:i] = [start, end]
        return True

# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)