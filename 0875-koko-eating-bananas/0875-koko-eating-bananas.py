class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        lower, upper = 0, float('-inf')

        for pile in piles:
            if pile > upper:
                upper = pile
        
        lower = 1

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