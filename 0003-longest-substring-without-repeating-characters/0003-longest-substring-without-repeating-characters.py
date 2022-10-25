class Solution:
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