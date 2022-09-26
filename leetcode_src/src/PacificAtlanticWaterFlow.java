import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow {
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;

        Set<int[]> pacific = new HashSet<>();
        Set<int[]> atlantic = new HashSet<>();

        // for(int row = 0; row < m; row++) {
        //     for(int col = 0; col < n; col++) {
        //         dfs_ocean(heights, new int[]{row, col}, row, col, pacific, atlantic);
        //     }
        // }
        dfs_ocean(heights, new int[]{1, 3}, 1, 3, pacific, atlantic);

        pacific.retainAll(atlantic);
        List<List<Integer>> res = new ArrayList<>();

        for(int[] coor : pacific) {
            List<Integer> li = List.of(coor[0], coor[1]);
            res.add(li);
        }

        return res;
    }

    private void dfs_ocean(int[][] heights, int[] peak, int row, int col, Set<int[]> pacific, Set<int[]> atlantic) {
        if(row == 0 || col == 0) {
            pacific.add(peak);
            return;
        }
        if(row == m || col == n) {
            atlantic.add(peak);
            return;
        }
        if(!atlantic.contains(peak) && col+1 < n && heights[row][col] >= heights[row][col+1]) {
                dfs_ocean(heights, peak, row, col+1, pacific, atlantic);
        }
        if (!atlantic.contains(peak) && row-1 > 0 && heights[row][col] >= heights[row-1][col]) {
                dfs_ocean(heights, peak, row-1, col, pacific, atlantic);
        }
        if (!pacific.contains(peak) && col-1 > 0 && heights[row][col] >= heights[row][col - 1]) {
            dfs_ocean(heights, peak, row, col - 1, pacific, atlantic);
        }
        if (!pacific.contains(peak) && row+1 < m && heights[row][col] >= heights[row+1][col]) {
            dfs_ocean(heights, peak, row+1, col, pacific, atlantic);
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow sol = new PacificAtlanticWaterFlow();

        int[][] heights = new int[][]
        {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        System.out.println(sol.pacificAtlantic(heights));
    }
}
