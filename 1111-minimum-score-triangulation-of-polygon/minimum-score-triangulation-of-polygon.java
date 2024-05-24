class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;

        // Tabulation
        int[][] dp = new int[n][n];
        return solveTab(values, 0, n-1, dp);

        // Recursion
        // return solve(values, 0, n-1);
    }

    private int solveTab(int[] values, int start, int end, int[][] dp) {
        if(start + 1 == end) return 0;
        int ans = Integer.MAX_VALUE;
        if(dp[start][end] != 0) return dp[start][end];
        for(int i = start+1;i<end; i++) {
            ans = Math.min(ans, values[i]*values[start]*values[end] + solveTab(values, start, i, dp) + solveTab(values, i, end, dp));
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