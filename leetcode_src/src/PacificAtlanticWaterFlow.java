import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow {
    private static final DIRECTIONS = new int[][]{{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private int m, n;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[n].length;

        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            dfs(r, 0, pacificReachable);
            dfs(r, n - 1, atlanticReachable);
        }
        for (int c = 0; c < n; c++) {
            dfs(0, c, pacificReachable);
            dfs(m-1, c, atlanticReachable);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacificReachable[i][j] == true && atlanticReachable[i][j] == true) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int row, int col, boolean[][] reachable) {
        reachable[row][col] = true;

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                continue;
            }

            if(reachable[newRow][newCol] == true) {
                continue;
            }

            if(heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(newRow, newCol, reachable)
        }
    }

    public static void main(String[] args) {
        
    }
}
