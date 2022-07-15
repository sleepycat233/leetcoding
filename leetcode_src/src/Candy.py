from typing import *

class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        left = [0] * n

        left[0] = 1
        for i in range(1, n):
            left[i] = left[i-1]+1 if ratings[i] > ratings[i-1] else 1

        right = 1
        res = max(right, left[n-1])
        for j in range(n-2, -1, -1):
            right = right+1 if ratings[j] > ratings[j+1] else 1
            res += max(right, left[j])

        return res

print(Solution().candy([2,0,1]))