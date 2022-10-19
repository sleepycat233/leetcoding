from typing import *
from collections import defaultdict
from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        c = Counter(nums)
        return [n[0] for n in c.most_common(k)]

    #count occurrence with hashmap then sort by occurrence
    def topKFrequent2(self, nums: List[int], k: int) -> List[int]:
        frequency = defaultdict(int) # nums : occurrence
        for num in nums:
            frequency[num] += 1

        l1 = list(frequency.items())
        l1.sort(key = lambda e : e[1], reverse = True)

        return [l1[i][0] for i in range(k)]


if __name__ == '__main__':
    # e1 = element(1)
    # e1.occurrence = 2
    # e2 = element(2)
    # e2.occurrence = 3

    # l1 = [e2, e1]
    # l1.sort(key = lambda e : e.occurrence)

    print(Solution().topKFrequent([1,1,1,2,2,3], 2))
