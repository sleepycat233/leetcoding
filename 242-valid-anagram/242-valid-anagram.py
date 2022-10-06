class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        char = [0 for _ in range(26)]

        for c in s:
            char[ord(c)-97] += 1
        for c in t:
            char[ord(c)-97] -= 1

        for n in char:
            if n != 0:
                return False

        return True