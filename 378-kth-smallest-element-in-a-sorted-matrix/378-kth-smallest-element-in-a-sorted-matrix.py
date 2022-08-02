class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        while len(matrix) > 1:
            newMatrix = []
            for i in range(0, len(matrix), 2):
                if i+1 != len(matrix):
                    l = matrix[i]
                    r = matrix[i+1]
                    newMatrix.append(sorted(l + r))
                else:
                    newMatrix.append(matrix[i])
            matrix = newMatrix

        return matrix[0][k-1]

        