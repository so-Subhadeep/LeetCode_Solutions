class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0) return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        Boolean[][][] dp = new Boolean[m][n][m + n];

        return dfs(0, 0, 0, grid, dp);
    }

    private boolean dfs(int r, int c, int balance, char[][] grid, Boolean[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) return false;

        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        if (dp[r][c][balance] != null) {
            return dp[r][c][balance];
        }

        boolean ans = false;

        if (r + 1 < m) {
            ans |= dfs(r + 1, c, balance, grid, dp);
        }

        if (c + 1 < n) {
            ans |= dfs(r, c + 1, balance, grid, dp);
        }

        return dp[r][c][balance] = ans;
    }
}
