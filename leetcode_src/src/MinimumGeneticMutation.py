from typing import *
import copy

class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        bank = set(bank)
        diff = []

        for i in range(len(start)):
            if start[i] != end[i]:
                diff.append((i, end[i]))

        def helper(remainings, curr):
            if curr == end:
                return True
            else:
                for replacement in remainings:
                    pivot = replacement[0]
                    replaced = curr[0:pivot] + replacement[1] + curr[pivot+1:]
                    if replaced in bank or replaced == end:
                        newRemains = copy.deepcopy(remainings)
                        newRemains.remove(replacement)
                        if helper(newRemains, replaced) == True:
                            return True

                return False

        if helper(diff, start) == True:
            return len(diff)
        else:
            return -1

if __name__ == '__main__':
    print(Solution().minMutation("GAGCGT", "GTGAGA", ["GAGCGA","GTGCGA"]))
