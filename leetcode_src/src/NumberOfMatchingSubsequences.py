class Solution:
    def numMatchingSubseq(self, S, words):
        def isSubseq(word):
            it = iter(S)
            return all(c in it for c in word)

        return sum(isSubseq(word) for word in words)

print(Solution().numMatchingSubseq("abcd", ["a", "ad", "da"]))
