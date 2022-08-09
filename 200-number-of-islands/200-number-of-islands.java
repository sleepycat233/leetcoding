class Solution {
    int m;
    int n;

    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[m][n];

        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                if(grid[y][x] == '1' && visited[y][x] == false) {
                    dfs(grid, visited, x, y);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        if(x < 0 || y < 0 || x >= n || y >= m) {
            return;
        }
        else if(visited[y][x] == true || grid[y][x] == '0') {
            return;
        }
        else {
            visited[y][x] = true;
            dfs(grid, visited, x+1, y);
            dfs(grid, visited, x, y-1);
            dfs(grid, visited, x-1, y);
            dfs(grid, visited, x, y+1);
        }
    }
}