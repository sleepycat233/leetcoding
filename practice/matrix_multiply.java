package practice;

public class matrix_multiply
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

    public static void main(String[] args) {
        int[][] m1 = {
            {1, 2},
            {3, 4}
        };

        // System.out.format("%d, %d\n", m1.length, m1[0].length);
        m1 = power2(m1);
        print_matrix(m1);
    }
}