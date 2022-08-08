from typing import *
from bisect import bisect_left

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        sub = [nums[0]]

        for n in nums[1:]:
            if n > sub[-1]:
                sub.append(n)
            else:
                l = 0
                r = len(sub)-2
                while l < r:
                    mid = int((l+r)/2)
                    if n > sub[mid]:
                        l = mid
                    else:
                        r = mid+1
                if r > 0: sub[l] = n
                elif n < sub[0]: sub[0] = n
                else: sub[1] = n

        return len(sub)

    def lengthOfLIS2(self, nums: List[int]) -> int:
        sub = [nums[0]]

        for num in nums[1:]:
            if num > sub[-1]:
                sub.append(num)
            else:
                # Find the first element in sub that is greater than or equal to num
                i = 0
                while num > sub[i]:
                    i += 1
                sub[i] = num

        return len(sub)

def bs(a, x):
    l = 0
    r = len(a)-1
    while l < r:
        mid = int((l+r)/2)
        if x < a[mid]:
            l = mid
        else:
            r = mid-1

    return l

if __name__ == '__main__':
    a = [1, 3, 4]
    print(bs(a, 3))
    print(bisect_left(a, 3))
    # print(Solution().lengthOfLIS([4,10,4,3,8,9]))