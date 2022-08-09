from typing import *
import bisect


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


def bs(a, x):
    l = 0
    r = len(a)-1
    while l < r:
        mid = int((l+r)/2)
        if x < a[mid]:
            r = mid
        else:
            l = mid+1

    return r


def bs2(a, x):
    l = 0
    r = len(a)-1
    while l < r:
        mid = int((l+r)/2)
        if x == a[mid]:
            r = mid
            break
        elif x < a[mid]:
            r = mid
        else:
            l = mid+1

    return r

if __name__ == '__main__':
    a = [0, 3, 5]
    print(bs2(a, 2))
    print(bisect.bisect_left(a, 2))
    print(bisect.bisect_right(a, 2))
    print(Solution().lengthOfLIS([0, 1, 0, 3, 2, 3]))
