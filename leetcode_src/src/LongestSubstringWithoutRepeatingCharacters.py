class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        mapping = dict()

        res = 0
        i = 0
        for j, c in enumerate(s):
            if c in mapping:
                res = max(res, j - i)
                i = max(i, mapping[c]+1)

            mapping[c] = j

        return res

if __name__ == '__main__':
    # print(Solution().lengthOfLongestSubstring("abcabcbb"))
    # print(Solution().lengthOfLongestSubstring(" "))
    print(Solution().lengthOfLongestSubstring("tmmzuxt"))
