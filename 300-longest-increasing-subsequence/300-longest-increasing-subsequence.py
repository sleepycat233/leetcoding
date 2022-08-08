class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        m = len(nums)
        t = [1] * m
        
        for end in range(1, m):
            for start in range(end):
                if nums[start] < nums[end]:
                    t[end] = max(t[end],  t[start]+1)
        
        return max(t)

        