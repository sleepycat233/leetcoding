import bisect
from typing import *

class MyCalendar:
    def __init__(self):
        self.booked = []

    def book(self, start: int, end: int) -> bool:
        i = bisect.bisect_right(self.booked, start)
        if i % 1 or (i < len(self.booked) and self.booked[i] < end):
            return False
        self.booked[i:i] = [start, end]
        return True


if __name__ == '__main__':
    cal = MyCalendar()
    cal.book(1, 2)
    cal.book(3, 4)
    cal.book(2, 3)
