class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;

        // Tabulation
        return solveTab(values);
        // Memoization
        // int[][] dp = new int[n][n];
        // return solveMem(values, 0, n-1, dp);

        // Recursion
        // return solve(values, 0, n-1);
    }

    private int solveTab(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for(int i = n-1;i>=0;i--) {
            for(int j=i+2;j<n;j++) {
                int ans = Integer.MAX_VALUE;
                for(int k = i+1;k<j; k++) {
                    ans = Math.min(ans, values[i]*values[k]*values[j] + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][n-1];
    }

    private int solveMem(int[] values, int start, int end, int[][] dp) {
        if(start + 1 == end) return 0;
        int ans = Integer.MAX_VALUE;
        if(dp[start][end] != 0) return dp[start][end];
        for(int i = start+1;i<end; i++) {
            ans = Math.min(ans, values[i]*values[start]*values[end] + solveMem(values, start, i, dp) + solveMem(values, i, end, dp));
        }
        return dp[start][end] = ans;
    }

    private int solve(int[] values, int start, int end) {
        if(start + 1 == end) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = start+1;i<end; i++) {
            ans = Math.min(ans, values[i]*values[start]*values[end] + solve(values, start, i) + solve(values, i, end));
        }
        return ans;
    }
}