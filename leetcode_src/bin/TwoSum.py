from typing import *

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = dict()

        for i in range(len(nums)):
            diff = target - nums[i]

            if nums[i] in dic:
                return [dic[nums[i]], i]
            else:
                dic[diff] = i

        return []

print(Solution().twoSum([2, 7, 11], 9))