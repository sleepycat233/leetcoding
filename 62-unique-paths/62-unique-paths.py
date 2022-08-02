class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        t = [[1 for _ in range(n)]]

        for i in range(1, m):
            t.append([0 for _ in range(n)])
            for j in range(n):
                if j == 0:
                    t[i][j] = 1
                else:
                    t[i][j] = t[i][j-1] + t[i-1][j]

        return t[m-1][n-1]