class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        sub = [nums[0]]

        for n in nums[1:]:
            if n > sub[-1]:
                sub.append(n)
            else:
                l = 0
                r = len(sub)-1
                while l < r:
                    mid = int((l+r)/2)
                    if n == sub[mid]:
                        r = mid
                        break
                    elif n < sub[mid]:
                        r = mid
                    else:
                        l = mid+1

                sub[r] = n

        return len(sub)