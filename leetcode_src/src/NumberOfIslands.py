from typing import *

class Solution:
    def __init__(self):
        self.parent = []

    def find(self, a):
        if self.parent[a] < 0:
            return a
        else:
            self.parent[a] = self.find(self.parent[a])
            return self.parent[a]

    def union(self, a, b):
        p1 = self.find(a)
        p2 = self.find(b)
        if p1 != p2:
            if(-self.parent[p1] < -self.parent[p2]):
                p1, p2 = p2, p1
            self.parent[p1] += self.parent[p2]
            self.parent[p2] = p1
            return True

        return False

    def numIslands(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        self.parent = [-1] * (m * n)

        for r in range(m):
            for c in range(n):
                index = r*n+c
                if grid[r][c] == '1':
                    grid[r][c] = '0'
                    if c+1 < n and grid[r][c+1] == '1':
                        self.union(index, r*n+c+1)
                    if r+1 < m and grid[r+1][c] == '1':
                        self.union(index, (r+1)*n+c)
                    if c-1 > 0 and grid[r][c-1] == '1':
                        self.union(index, r*n+c-1)
                    if r-1 > 0 and grid[r-1][c] == '1':
                        self.union(index, (r-1)*n+c)
                else:
                    self.parent[index] = 0

        return len([x for x in self.parent if x < 0])

if __name__ == '__main__':
    grid = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","0","1","0","0"],
        ["0","0","0","1","1"]
    ]

    print(Solution().numIslands(grid))