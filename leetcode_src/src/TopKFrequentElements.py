from typing import *
from collections import defaultdict

class element:
    def __init__(self, num):
        self.num = num
        self.occurance = 0

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frequency = defaultdict(int) # nums : occurance
        for num in nums:
            frequency[num] += 1

        l1 = list(frequency.items())
        l1.sort(key = lambda e : e[1], reverse = True)

        [x for _]

        return l1


if __name__ == '__main__':
    # e1 = element(1)
    # e1.occurance = 2
    # e2 = element(2)
    # e2.occurance = 3

    # l1 = [e2, e1]
    # l1.sort(key = lambda e : e.occurance)

    print(Solution().topKFrequent([1,1,2,2,2,3], 2))

    pass