class Solution {
    public int maxSubArray(int[] nums) {
        // // Solve using simple
        // return solveRec(nums);

        // // Solve using recursion
        // return solveRec(nums, 0, false);

        // Solve using the recursion + memoization
        int[][] dp = new int[nums.length][2];
        for(int[] arr : dp) {
            Arrays.fill(arr, -100000);
        }
        return solveMem(nums, 0, 0, dp);

    }

    private int solveMem(int[] nums, int pos, int shouldPick, int[][] dp) {
        if(pos >= nums.length)
            return shouldPick == 1 ? 0 : -100000;
        if(dp[pos][shouldPick] != -100000) return dp[pos][shouldPick];
        if(shouldPick == 1)
            return dp[pos][shouldPick] = Math.max(0, nums[pos] + solveMem(nums, pos+1, 1, dp));
        return dp[pos][shouldPick] = Math.max(solveMem(nums, pos+1, 0, dp), nums[pos] + solveMem(nums, pos+1, 1, dp));
    }

    private int solveRec(int[] nums, int pos, boolean shouldPick) {
        if(pos >= nums.length)
            return shouldPick ? 0 : -100000;
        if(shouldPick)
            return Math.max(0, nums[pos] + solveRec(nums, pos+1, true));
        return Math.max(solveRec(nums, pos+1, false), nums[pos] + solveRec(nums, pos+1, true));
    }

    // O(n^2)
    private int solveRec(int[] nums) {
        int n = nums.length, ans = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i = 0;i<n;i++) {
            curSum = 0;
            for(int j=i;j<n;j++) {
                curSum += nums[j];
                ans = Math.max(ans, curSum);
            }
        }
        return ans;
    }
}