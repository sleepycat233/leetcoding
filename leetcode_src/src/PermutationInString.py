from typing import *

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        occ1 = [0 for _ in range(26)]
        occ2 = [0 for _ in range(26)]

        if len(s1) > len(s2) return False

        for c in s1:
            occ1[ord(c) - ord('a')] += 1

        r = 0
        while r < len(s1):
            occ2[ord(s2[r]) - ord('a')] += 1

        for l in range(len(s2) - len(s1)):
