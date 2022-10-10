from audioop import reverse
from typing import *

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        start = 0
        end = len(s)-1

        while(start < end):
            while(start < end and not s[start].isalnum()):
                start += 1
            while(start < end and not s[end].isalnum()):
                end -= 1
            if(s[start] != s[end]):
                return False

            start += 1
            end -= 1

        return True

    def isPalindrome2(self, s: str) -> bool:
        filtered = filter(lambda c : c.isalnum(), s)
        lower_filtered = map(lambda c : c.lower(), filtered)

        lower_filtered_list = list(lower_filtered)
        reverse_lower_filtered_list = lower_filtered_list[::-1]

        return lower_filtered_list == reverse_lower_filtered_list

print(Solution().isPalindrome2("A man, a plan, a canal: Panama"))
print(Solution().isPalindrome2("0p"))
