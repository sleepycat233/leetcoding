from typing import *
import math

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        lower, upper = float('inf'), float('-inf')

        for pile in piles:
            if pile > upper:
                upper = pile
            elif pile < lower:
                lower = pile

        if len(piles) == 1: lower = 1

        res = 0
        while lower <= upper:
            speed = (lower + upper) // 2

            remaining = h
            for pile in piles:
                remaining -= math.ceil(pile/speed)
                if remaining < 0:
                    break

            if remaining < 0:
                lower = speed + 1
            else:
                upper = speed - 1
                res = speed

        return res


if __name__ == '__main__':
    # print(Solution().minEatingSpeed([3, 6, 7, 11], 8))
    # print(Solution().minEatingSpeed([30, 11, 23, 4, 20], 6))
    print(Solution().minEatingSpeed([7], 6))
