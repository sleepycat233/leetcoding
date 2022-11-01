class Solution:
    def findBall(self, grid: List[List[int]]) -> List[int]:
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