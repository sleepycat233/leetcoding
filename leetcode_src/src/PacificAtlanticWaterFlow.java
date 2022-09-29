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

    }

    private void dfs(int row, int col, boolean[][] reachable) {
        reachable[row][col] = true;

        
    }

    public static void main(String[] args) {

    }
}
