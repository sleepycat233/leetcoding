import java.util.Deque;
import java.util.LinkedList;

class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Cell[][] thePromisedLand = new Cell[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                thePromisedLand[i][j] = new Cell(i, j, false);
            }
        }

        int maxArea = 0;
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(thePromisedLand[row][col].visited == false && grid[row][col] == 1) {
                    int area = bfs(grid, thePromisedLand, row, col);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private static class Cell {
        int row;
        int col;
        boolean visited;

        public Cell(int row, int col, boolean visited) {
            this.row = row;
            this.col = col;
            this.visited = visited;
        }
    }

    private int bfs(int[][] grid, Cell[][] theLand, int row, int col) {
        Deque<Cell> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int area = 0;
        Cell c = theLand[row][col];

        queue.add(c);
        c.visited = true;
        while(!queue.isEmpty()) {
            Cell me = queue.poll();
            Cell venture = null;
            area++;

            if (me.row - 1 >= 0) {
                venture = theLand[me.row - 1][me.col];
                if (grid[venture.row][venture.col] == 1 && venture.visited == false) {
                    venture.visited = true;
                    queue.add(venture);
                }
            }
            if(me.col+1 < n) {
                venture = theLand[me.row][me.col+1];
                if(grid[venture.row][venture.col] == 1 && venture.visited == false) {
                    venture.visited = true;
                    queue.add(venture);
                }
            }
            if (me.row + 1 < m) {
                venture = theLand[me.row+1][me.col];
                if (grid[venture.row][venture.col] == 1 && venture.visited == false) {
                    venture.visited = true;
                    queue.add(venture);
                }
            }
            if (me.col - 1 >= 0) {
                venture = theLand[me.row][me.col - 1];
                if (grid[venture.row][venture.col] == 1 && venture.visited == false) {
                    venture.visited = true;
                    queue.add(venture);
                }
            }

        }

        return area;
    }

    // abandon ship, dp failed :(
/*     public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] t = new int[m][n];
        int maxArea = 0;

        t[0][0] = grid[0][0];
        for(int col = 1; col < n; col++) {
            t[0][col] = (grid[0][col] == 1) ? t[0][col-1]+1 : 0;
        }

        for(int row = 1; row < m; row++) {
            t[row][0] = (grid[row][0] == 1) ? t[row-1][0]+1 : 0;
        }

        for(int row = 1; row < m; row++) {
            boolean countedLastRow = false;
            for(int col = 1; col < n; col++) {
                if(grid[row][col] == 1) {
                    int lastRow = 0;
                    if(!countedLastRow && grid[row-1][col] == 1) {
                        int tmpCol = col;
                        while(t[row-1][tmpCol] > 0) {
                            lastRow = t[row-1][tmpCol];
                            tmpCol++;
                        }

                        countedLastRow = true;
                    }
                    else if(countedLastRow && grid[row-1][col] == 0) {
                        countedLastRow = false;
                    }
                    //(counted && grid[row-1][col] == 1) || (!counted && grid[row-1][col] == 0)
                    t[row][col] = t[row][col-1] + 1 + lastRow;



                    maxArea = Math.max(maxArea, t[row][col]);
                }
            }
        }

        return maxArea;
    }
 */

    public static void main(String[] args) {
        MaxAreaOfIsland sol = new MaxAreaOfIsland();
        System.out.println(sol.maxAreaOfIsland(new int[][]{
            {0,0,1,0,0,0,0,1,0,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,1,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,1,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));

        System.out.println(sol.maxAreaOfIsland(new int[][]{
            {1,1,0,0,0,0,0,0,0,0,0,0,0},
            {1,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
        }));
    }
}
