from typing import *

class Solution:
    def isPowerOfTwo_naive(self, n: int) -> bool:
        if n == 0:
            return False
        while n % 4 == 0:
            n /= 4
        return n == 1

    # turn off rightmost 1-bit
    def isPowerOfTwo1(self, n:int) -> bool:
        return n > 0 and (n-1) & n == 0

    # isolate rightmost 1-bit:
    def isPowerOfTwo2(self, n):
        return n > 0 and n & (-n) == n




if __name__ == '__main__':
    print(Solution().isPowerOfTwo2(16))
    print(Solution().isPowerOfTwo2(12))
