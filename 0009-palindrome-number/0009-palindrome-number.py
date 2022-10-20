class Solution:
    def isPalindrome(self, n: int) -> bool:
        if n < 0: return False
        return str(n) == str(n)[::-1]