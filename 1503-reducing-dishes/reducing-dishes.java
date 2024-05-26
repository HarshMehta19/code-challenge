class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int [][] dp = new int[satisfaction.length][satisfaction.length + 1];
        for(int[] arr : dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }

        return solveMem(satisfaction, 0, 1, dp);

        // Recursion
        //return solve(satisfaction, 0, 1);
    }

    private int solveMem(int[] satisfaction, int index, int time, int[][] dp) {
        if(index >= satisfaction.length) return 0;
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