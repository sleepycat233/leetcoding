class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = n*m-1;
        while(l <= r) {
            int mid = (l+r)/2;
            if(matrix[mid/n][mid%n] < target) {
                l = mid+1;
            }
            else if(matrix[mid/n][mid%n] > target) {
                r = mid-1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}