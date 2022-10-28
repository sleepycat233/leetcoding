class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        size = m * n
        
        def helper(index):
            row = index // n 
            col = index % n
            
            return (row, col)
        
        l = 0
        r = size-1
        
        while l <= r:
            mid = (l+r) // 2
            row, col = helper(mid)
            if matrix[row][col] > target:
                r = mid - 1
            elif matrix[row][col] < target:
                l = mid + 1
            else:
                return True
        
        return False