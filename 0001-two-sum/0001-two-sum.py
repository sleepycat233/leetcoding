class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d1 = dict()

        for i, n in enumerate(nums):
            if n in d1:
                return [d1[n], i]
            else:
                d1[target-n] = i