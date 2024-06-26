class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        return Math.min(solve(cost, 0, dp), solve(cost, 1, dp));

    }

    int solve(int[] cost, int i, int[] dp) {
        if(i == cost.length - 1) return cost[i];
        if(i >= cost.length) return 0;
        if(dp[i] != 0) return dp[i];

        return dp[i] = cost[i] + Math.min(solve(cost, i+1, dp), solve(cost, i+2, dp));
    }
}