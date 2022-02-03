public class Search2DMatrix {
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

    //one time binary search
    public boolean searchMatrix2(int[][] matrix, int target) {
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

    //BFS

    public static void main(String[] args)
    {
        Search2DMatrix sol = new Search2DMatrix();
        int matrix[][] = new int[][]{{ 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 }};
        System.out.println(sol.searchMatrix(matrix, 11));
        System.out.println(sol.searchMatrix(matrix, 12));
        System.out.println(sol.searchMatrix(matrix, 15));
        System.out.println(sol.searchMatrix(matrix, 34));
        System.out.println(sol.searchMatrix2(matrix, 11));
        System.out.println(sol.searchMatrix2(matrix, 12));
        System.out.println(sol.searchMatrix2(matrix, 15));
        System.out.println(sol.searchMatrix2(matrix, 34));
    }
}
