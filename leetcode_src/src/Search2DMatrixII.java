public class Search2DMatrixII {
    // z-search
    // O(m+n)
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

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrixII sol = new Search2DMatrixII();
        int matrix[][] = new int[][] {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}};

        System.out.println(sol.searchMatrix(matrix, 3));
        System.out.println(sol.searchMatrix(matrix, 8));
        System.out.println(sol.searchMatrix(matrix, 1));
        System.out.println(sol.searchMatrix(matrix, 10));
        System.out.println(sol.searchMatrix(matrix, 38));
    }
}
