class Solution:
    def findBall(self, grid: List[List[int]]) -> List[int]:
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