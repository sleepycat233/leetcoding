from typing import *

class Solution:
    def groupAnagram(self, strs: List[str]) -> List[List[str]]:
        resDict = dict()

        def getOrder(s1):
            count = [0 for _ in range(26)]
            for c in s1:
                count[ord(c)-97] += 1
            return tuple(count)

        for s1 in strs:
            o1 = getOrder(s1)
            if o1 in resDict:
                resDict[o1].append(s1)
            else:
                resDict[o1] = [s1]


        return list(resDict.values())

print(Solution().groupAnagram(["eat","tea","tan","ate","nat","bat"]))