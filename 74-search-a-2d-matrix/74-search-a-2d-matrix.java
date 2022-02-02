class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row;
        for(row = 0; row < m; row++) {
            if(matrix[row][n-1] >= target) {
                int l = 0;
                int r = n-1;
                while(l <= r) {
                    int mid = (l+r)/2;
                    if(matrix[row][mid] == target) {
                        return true;
                    }
                    else if(matrix[row][mid] < target) {
                        l = mid+1;
                    }
                    else {
                        r = mid-1;
                    }
                }
            }
        }

        return false;
    }
}