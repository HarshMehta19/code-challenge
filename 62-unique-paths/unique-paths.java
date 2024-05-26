class Solution {
    public int uniquePaths(int m, int n) {
        // int[][] maze = new int[m][n];
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) { // init
            for (int j = 0; j < n; ++j) {
                dp[i][j] = -1;
            }
        }
        return solveMem(m,n, 0, 0, dp);
        // return solve(m, n, 0, 0);
    }

    private int solveMem(int m, int n, int row, int col, int[][] dp) {
        if(row == m || col == n) return 0;

        if(row == m-1 && col == n-1) return 1;
        if(dp[row][col] != -1) return dp[row][col];


        return dp[row][col] = solveMem(m,n, row+1, col, dp) + solveMem(m,n, row, col+1, dp);
    }
    private int solve(int m, int n, int row, int col) {
        if(row == m || col == n) return 0;

        if(row == m-1 && col == n-1) return 1;

        return solve(m,n, row+1, col) + solve(m,n, row, col+1);
    }
}