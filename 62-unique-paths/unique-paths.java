class Solution {
    public int uniquePaths(int m, int n) {
        
        //Tabulation
        return solveTab(m, n);

        // Memoization
        // int[][] dp = new int[m][n];
        // for (int i = 0; i < m; ++i) { // init
        //     for (int j = 0; j < n; ++j) {
        //         dp[i][j] = -1;
        //     }
        // }
        // return solveMem(m,n, 0, 0, dp);
        // return solve(m, n, 0, 0);
    }

    private int solveTab(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) dp[i][n-1] = 1;
  for (int i = 0; i < n; ++i) dp[m-1][i] = 1;
        for(int row = m-2;row>=0;row--) {
            for(int col = n-2;col>=0;col--) {
                dp[row][col] = dp[row+1][col] + dp[row][col+1];
            }
        }
        return dp[0][0];

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