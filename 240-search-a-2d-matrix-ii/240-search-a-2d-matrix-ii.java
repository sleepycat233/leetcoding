class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int x = n-1;
        int y = 0;

        while(x >= 0 && y < m) {
            if(matrix[y][x] == target) {
                return true;
            }
            else if(matrix[y][x] < target) {
                ++y;
            }
            else {
                --x;
            }
        }

        return false;    }
}