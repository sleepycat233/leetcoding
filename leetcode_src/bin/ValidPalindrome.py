from typing import *

class Solution:
    # def isAlphanumeric(self, c):
    #     return ord('a') <= ord(c) and ord(c) <= ord('z')

    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        start = 0
        end = len(s)-1

        while(start < end):
            while(start < end and not s[start].isalnum():
                start += 1
            while(start < end and not s[end].isalnum()):
                end -= 1
            if(start == end or s[start] != s[end]):
                return False

            start += 1
            end -= 1

        return True

# print(Solution().isPalindrome("A man, a plan, a canal: Panama"))
print(Solution().isPalindrome("0p"))
