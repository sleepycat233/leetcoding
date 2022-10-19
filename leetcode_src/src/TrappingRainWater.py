from typing import *

class Solution:
    def trap(self, height: List[int]) -> int:
        i = 0
        n = len(height)
        leftpass = [0 for _ in range(n)]
        rightpass = [0 for _ in range(n)]

        while i < n:
            j = i + 1
            while j < n and height[j] < height[i]:
                j += 1

            if j < n:
                for x in range(i+1, j):
                    leftpass[x] = height[i] - height[x]
                i = j
            else:
                i += 1

        i = n-1
        while i >= 0:
            j = i - 1
            while j >= 0 and height[j] < height[i]:
                j -= 1

            if j >= 0:
                for x in range(j, i+1):
                    rightpass[x] = height[i] - height[x]
                i = j
            else:
                i -= 1

        res = 0
        for x in range(n):
            res += max(leftpass[x], rightpass[x])

        return res

if __name__ == '__main__':
    print(Solution().trap([0,1,0,2,1,0,1,3,2,1,2,1]))