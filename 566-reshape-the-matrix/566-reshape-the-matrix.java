class Solution {
    public int[][] matrixReshape(int[][] matrix, int r, int c) {
        if(matrix.length*matrix[0].length != r*c) return matrix;

        int[][] res = new int[r][c];
        int count = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                res[i][j] = matrix[count/matrix[0].length][count%matrix[0].length];
                count++;
            }
        }

        return res;
    }
}