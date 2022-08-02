class Solution:

    def kthSmallest(self, matrix:List[List[int]], k: int) -> int:
        while len(matrix) > 1:
            newMatrix = []
            for i in range(0, len(matrix), 2):
                if i+1 != len(matrix):
                    l = matrix[i]
                    r = matrix[i+1]
                    # newMatrix.append(sorted(l + r))
                    newMatrix.append(self.merge(l, r))
                else:
                    newMatrix.append(matrix[i])
            matrix = newMatrix

        return matrix[0][k-1]

    def merge(self, left, right):
        res = []
        l = r = 0
        while l < len(left) and r < len(right):
            if left[l] <= right[r]:
                res.append(left[l])
                l+=1
            else:
                res.append(right[r])
                r+=1
        while l < len(left):
            res.append(left[l])
            l+=1
        while r < len(right):
            res.append(right[r])
            r+=1

        return res
        