class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 0) {
                    dfs(grid, i, j, m, n);
                }
            }
        }
        
        int closedIslands = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    closedIslands++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        
        return closedIslands;
    }
    
    private void dfs(int[][] grid, int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 1) {
            return;
        }
        
        grid[r][c] = 1;
        
        dfs(grid, r + 1, c, m, n);
        dfs(grid, r - 1, c, m, n);
        dfs(grid, r, c + 1, m, n);
        dfs(grid, r, c - 1, m, n);
    }
}
