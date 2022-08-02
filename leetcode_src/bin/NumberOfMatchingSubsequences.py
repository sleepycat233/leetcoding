from typing import *

class Subseq:
    def __init__(self, s=None, index=0):
        self.s = s
        self.index = index


class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]):
        k = [chr(i) for i in range(ord('a'), ord('z')+1)]
        v = [[] for _ in range(26)]
        dsq = dict(zip(k, v))
        for w in words:
            dsq[w[0]].append(Subseq(w))

        ans = 0
        for c in s:
            clist = []
            oldList = dsq[c]
            dsq[c] = clist

            for sq in oldList:
                sq.index += 1
                if sq.index == len(sq.s):
                    ans += 1
                else:
                    init = sq.s[sq.index]
                    dsq[init].append(sq)

        return ans


    def numMatchingSubseq_naive(self, S, words):
        def isSubseq(word):
            it = iter(S)
            return all(c in it for c in word)

        return sum(isSubseq(word) for word in words)

print(Solution().numMatchingSubseq("abcd", ["a", "ad", "da"]))
