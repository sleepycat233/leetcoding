import java.util.Arrays;

class MatrixMultiplication {
    public static int[][] multiply(int[][] A, int[][] B) {
        if(A[0].length != B.length) return null;

        int[][] res = new int[A.length][B[0].length];
        for(int ir = 0; ir < res.length; ir++) {
            for(int jr = 0; jr < res[0].length; jr++) {
                for(int k = 0; k < B.length; k++) {
                    res[ir][jr] += A[ir][k] * B[k][jr];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 1},{-1, 1}};
        int[][] B = new int[][]{{2, 0},{0, 1}};
        int[][] C = multiply(A, B);

        for(int[] col : C) {
            System.out.println(Arrays.toString(col));
        }
    }
}