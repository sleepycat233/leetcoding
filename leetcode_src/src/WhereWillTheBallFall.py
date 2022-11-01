from typing import *

class Solution:
    def findBall(self, grid: List[List[int]]) -> List[int]:
        m = len(grid)
        n = len(grid[0])
        i = j = 0
        res = []

        for s in range(n):
            i = 0
            j = s
            while i >= 0 and i < m and j >= 0 and j < n:
                adjacent = j + grid[i][j]
                if adjacent >= 0 and adjacent < n:
                    if grid[i][j] == grid[i][adjacent]:
                        j += grid[i][j]
                        i += 1
                    else:
                        break
                else:
                    break

            if i == m:
                res.append(j)
            else:
                res.append(-1)

        return res

if __name__ == '__main__':
    g1 = [[1, -1]]
    g2 = [[1, 1]]
    g3 = [[-1, -1]]
    g4 = [[1, 1, 1, 1, 1, 1], [-1, -1, -1, -1, -1, -1],
          [1, 1, 1, 1, 1, 1], [-1, -1, -1, -1, -1, -1]]


    print(Solution().findBall(g1))
    print(Solution().findBall(g2))
    print(Solution().findBall(g3))
    print(Solution().findBall(g4))