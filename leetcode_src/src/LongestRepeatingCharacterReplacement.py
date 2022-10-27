class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l = r = 0
        repeated = k
        n = len(s)

        while r < n:
            if s[r] == s[l]:
                r += 1
            elif repeated > 0:
                repeated -= 1
                r += 1
            else:
                res = max(res, r-l)
                repeated = k
                l = r-1 if k != 0 else r

        res = max(res, r-l)

        return res
