from typing import *

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def helper(run, sum, index):
            if sum == target:
                res.append([] + run)
            elif sum > target:
                return
            else:
                for i in range(index, len(candidates)):
                    can = candidates[i]
                    run.append(can)
                    helper(run, sum+can, i)
                    run.pop()


        helper([], 0, 0)
        return res

if __name__ == '__main__':
    print(Solution().combinationSum([2,3,6,7], 7))
