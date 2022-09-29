from typing import *

class Solution:
    def __init__(self):
        self.board = []
        self.n = 0

    def validateBoard(self):
        # turn off right most 1-bit
        def validate(li):
            n = 0
            for x in li:
                n <<= 1
                n += x
            return n & (n-1) == 0

        for r in range(self.n):
            for c in range(self.n):
                if self.board[r][c] == 1:
                    if (validate(self.board[r]) and \
                        validate([self.board[x][c] for x in range(self.n)]) and \
                        validate([self.board[x+r][x+c] for x in range(-self.n+1, self.n) if x+r >= 0 and x+r < self.n and x+c >= 0 and x+c < self.n]) and \
                        validate([self.board[x+r][-x+c] for x in range(-self.n+1, self.n) if x+r >= 0 and x+r < self.n and -x+c >= 0 and -x+c < self.n])) == False:
                        return False

        return True

    def render(self):
        res = []
        for row in self.board:
            s = ""
            for n in row:
                if n == 0:
                    s += '.'
                else:
                    s += 'Q'
            res.append(s)

        return res

    def nqueens_naive(self, n: int) -> List[List[str]]:
        self.board = [[0] * n for i in range(n)]
        self.n = n

        res = []

        def helper(queens, pos):
            row = pos // self.n
            col = pos % self.n

            if queens == self.n:
                res.append(self.render())
                return
            elif row >= self.n or col >= self.n:
                return
            else:
                self.board[row][col] = 1
                if self.validateBoard():
                    helper(queens+1, pos+1)
                    self.board[row][col] = 0
                else:
                    self.board[row][col] = 0
                    helper(queens, pos+1)


        for p in range(self.n):
            helper(0, p)

        return res

    def test(self):
        self.board = [[0] * 4 for i in range(4)]
        self.n = 4

        self.board[2][1] = 1
        self.board[1][2] = 1
        # self.board[2][3] = 1

        return self.validateBoard()

if __name__ == '__main__':
    res = Solution().nqueens_naive(7)

    for sol in res:
        for s in sol:
            print(s)
        print()
    # print(Solution().test())