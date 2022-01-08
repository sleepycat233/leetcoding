package practice;

public class MatrixMultiplication
{
    private static void print_matrix(int[][] m) {
        for(int col = 0; col < m.length; col++) {
            for(int row = 0; row < m[0].length; row++) {
                System.out.format("[%d] ", m[col][row]);
            }
            System.out.println();
        }
    }

    private static int[][] power2(int[][] m) {
        int[][] res = new int[m.length][m[0].length];

        for(int rcol = 0; rcol < res.length; rcol++) {
            for(int rrow = 0; rrow < res[0].length; rrow++) {
                for(int row = 0; row < res[0].length; row++) {
                    res[rcol][rrow] += m[rcol][row] * m[row][rrow];
                }
            }
        }

        return res;
    }

    public int[][] multiply(int[][] m1, int[][] m2) {
        int nrow = m1.length;
        int ncol = m2[0].length;
        int ntmp = m1[0].length;
        int[][] res = new int[nrow][ncol];

        for(int i = 0; i < nrow; i++) {
            for(int j = 0; j < ncol; j++) {
                for(int k = 0; k < ntmp; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // int[][] m1 = {
        //     {1, 2},
        //     {3, 4}
        // };

        int[][] m1 = {
            {1, 2, 5, 6},
            {3, 4, 7, 8}
        };

        int[][] m2 = {
            {3, 1, 0},
            {2, 5, 1},
            {4, 3, 2},
            {3, 1, 3},
        };

        int[][] res = new int[m1.length][m2[0].length];

        // System.out.format("%d, %d\n", m1.length, m1[0].length);
        // m1 = power2(m1);
        // print_matrix(m1);

        MatrixMultiplication sol = new MatrixMultiplication();
        res = sol.multiply(m1,m2);
        print_matrix(res);
    }
}