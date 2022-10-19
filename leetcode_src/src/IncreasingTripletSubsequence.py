from typing import *

class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        # n = len(nums)
        a = float('inf')
        b = float('inf')

        for n in nums:
            if n <= a:
                a = n
            elif n <= b:
                b = n
            else:
                return True

        return False

    # O(n^2)
    def increasingTriplet2(self, nums: List[int]) -> bool:
        n = len(nums)
        l, m, r = 0, 0, 0

        while l < n-2:
            m = l+1
            while m < n - 1:
                if nums[l] < nums[m]:
                    r = m + 1
                    while r < n and nums[r] <= nums[m]:
                        r += 1
                    if r < n and m < r and l < m:
                        return True
                m += 1

            l += 1

        return False


print(Solution().increasingTriplet2([5,4,4,3,4,5]))
print(Solution().increasingTriplet([1,5,0,4,1,0,3]))