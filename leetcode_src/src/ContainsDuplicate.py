from typing import *

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        s1 = set()

        for n in nums:
            if n in s1:
                return True
            else:
                s1.add(n)

        return False

    def containsDuplicate2(self, nums: List[int]) -> bool:
        return len(nums) != len(set(nums))

print(Solution().containsDuplicate2([1, 2, 3, 1]))
