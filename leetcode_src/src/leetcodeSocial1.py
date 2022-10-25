from typing import *

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d1 = dict()

        for i, n in enumerate(nums):
            if n in d1:
                return [d1[n], i]
            else:
                d1[target-n] = i

    def isPalindrome(self, x: int) -> bool:
        if x < 0: return False
        return str(x) == str(x)[::-1]

    def isPalindrome2(self, x: int) -> bool:
        rev = 0
        ori = x

        while x > 0:
            rev *= 10
            rev += x % 10
            x //= 10
            
        return ori == rev

    def isValid(self, s:str) -> bool:
        stack = []

        def isOpen(c):
            return c == '(' or c == '[' or c == '{'

        def isMatched(l, r):
            if l == '(': return r == ')'
            elif l == '[': return r == ']'
            elif l == '{': return r == '}'

        for c in s:
            if isOpen(c):
                stack.append(c)
            elif stack:
                l = stack.pop()
                if not isMatched(l, c):
                    return False
            else:
                return False

        return not stack

    def isValid2(self, s: str) -> bool:
        mapping = {')':'(', ']':'[', '}':'{'}
        stack = []

        for c in s:
            if not c in mapping:
                stack.append(c)
            elif not stack or stack.pop() != mapping[c]:
                return False

        return not stack

    def lengthOfLongestSubstring(self, s: str) -> int:
        d1 = dict()
        res = 0
        left = 0

        for right, c in enumerate(s):
            if not c in d1:
                d1[c] = right

            else:
                res = max(res, right-left)
                i = left
                left = d1[c]+1
                for k in range(i, left):
                    del d1[s[k]]
                d1[c] = right

        res = max(res, len(s)-left)
        return res


if __name__ == '__main__':
    # print(Solution().twoSum([2,7,11,15], 9))
    print(Solution().isPalindrome2(121))
    # print(Solution().isValid2("([(])])"))
    # print(Solution().isValid2("([()])"))
    # print(Solution().isValid2("]"))

    # print(Solution().lengthOfLongestSubstring("abcabcbb"))
    # print(Solution().lengthOfLongestSubstring(" "))
    # print(Solution().lengthOfLongestSubstring("tmmzuxt"))
