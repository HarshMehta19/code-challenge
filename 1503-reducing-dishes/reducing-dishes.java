class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        // Tabulation
        return solveTab(satisfaction);
        // Memoization
        // int [][] dp = new int[satisfaction.length][satisfaction.length + 1];
        // for(int[] arr : dp) {
        //     Arrays.fill(arr, Integer.MIN_VALUE);
        // }

        // return solveMem(satisfaction, 0, 1, dp);

        // Recursion
        //return solve(satisfaction, 0, 1);
    }

    private int solveTab(int[] satisfaction) {
        int n = satisfaction.length;
        int [][] dp = new int[n+1][n + 1];
        // for(int[] arr : dp) {
        //     Arrays.fill(arr, Integer.MIN_VALUE);
        // }

        for(int index = n - 1;index >= 0; index --) {
            for(int time = index; time>=0; time--) {
                int taken = (time+1) * satisfaction[index] + dp[index + 1][time + 1];
                int notTaken = dp[index +1][time];
                dp[index][time] = Math.max(taken, notTaken);
            }
        }
        return dp[0][0];
    }

    private int solveMem(int[] satisfaction, int index, int time, int[][] dp) {
        if(index == satisfaction.length) return 0;
        if(dp[index][time] != Integer.MIN_VALUE) return dp[index][time];

        int taken = time * satisfaction[index] + solveMem(satisfaction, index + 1, time + 1, dp);
        int notTaken = solveMem(satisfaction, index +1, time, dp);

        return dp[index][time] = Math.max(taken, notTaken);
    }

    private int solve(int[] satisfaction, int index, int time) {
        if(index >= satisfaction.length) return 0;

        int taken = time * satisfaction[index] + solve(satisfaction, index + 1, time + 1);
        int notTaken = solve(satisfaction, index +1, time);

        return Math.max(taken, notTaken);
    }
}