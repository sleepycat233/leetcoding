class Solution:
    def romanToInt(self, s: str) -> int:
        ans = 0
        values = {"I": 1,
                 "V": 5,
                 "X": 10,
                 "L": 50,
                 "C": 100,
                 "D": 500,
                 "M": 1000}

        i = 0
        while i < len(s):
            if i+1 < len(s):
                if (b := values[s[i+1]]) > (a := values[s[i]]):
                    ans += b - a
                    i += 1
                else:
                    ans += a
            else:
                ans += values[s[i]]

            i += 1

        return ans        