from typing import *

class Solution:
    def findBall_recursion(self, grid: List[List[int]]) -> List[int]:
        m = len(grid)
        n = len(grid[0])
        res = []

        def findDropColumn(row, col):
            if row == m:
                return col

            nextCol = col + grid[row][col]
            if nextCol >= 0 and nextCol < n \
                    and grid[row][nextCol] == grid[row][col]:
                return findDropColumn(row+1, nextCol)
            else:
                return -1

        for startpos in range(n):
            res.append(findDropColumn(0, startpos))

        return res

    def findBall_dp(self, grid: List[List[int]]) -> List[int]:
        m = len(grid)
        n = len(grid[0])
        table = [[-1 for _ in range(n)] for _ in range(m+1)]

        for row in range(m, -1, -1):
            for col in range(n):
                if row == m:
                    table[row][col] = col
                    continue

                nextCol = col + grid[row][col]
                if nextCol >= 0 and nextCol < n and grid[row][col] == grid[row][nextCol]:
                    table[row][col] = table[row+1][nextCol]
                else:
                    table[row][col] = -1

        # for row in table:
        #     print(row)
        # print()
        return table[0]


    def findBall_ballbyball(self, grid: List[List[int]]) -> List[int]:
        m = len(grid)
        n = len(grid[0])
        i = j = 0
        res = []

        for s in range(n):
            i = 0
            j = s
            while i >= 0 and i < m and j >= 0 and j < n:
                adjacent = j + grid[i][j]
                if adjacent >= 0 \
                        and adjacent < n \
                        and grid[i][j] == grid[i][adjacent]:
                    j += grid[i][j]
                    i += 1
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


    print(Solution().findBall_dp(g1))
    print(Solution().findBall_dp(g2))
    print(Solution().findBall_dp(g3))
    print(Solution().findBall_dp(g4))