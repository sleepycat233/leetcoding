from typing import *

class Solution:
    def isPowerOfFour1(self, n: int) -> bool:
        magic_num = 0b1010101010101010101010101010101
        return n > 0 and \
                n & n-1 == 0 and \
                n & magic_num == n





def getMagicNum():
    a = 2
    mn = 0
    for i in range(16):
        mn += a
        a <<= 2

    return mn

def getpow4():
    max_power = 15
    ans = [1] * (max_power+1)

    for i in range(1, max_power+1):
        ans[i] = 4 * ans[i-1]

    return ans



if __name__ == '__main__':
    n = getMagicNum()
    pow4 = getpow4()
    print(pow4)
    print(sum(pow4))
    print("{0:b}".format(sum(pow4)))
    print(n)
    print("{0:b}".format(n))