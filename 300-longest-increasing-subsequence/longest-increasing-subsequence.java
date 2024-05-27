class Solution {
    public int lengthOfLIS(int[] nums) {
        return solveTab(nums.length, nums);
    }

    private int solveTab(int n, int[] a) {
        int[][] dp = new int[n+1][n+1];
        for(int i = n-1;i>=0;i--) {
            for(int j= i-1;j>=-1;j--) {
                int take = 0;
        
                if(j == -1 || a[i] > a[j]) {
                    take = 1 + dp[i+1][i+1];
                }
                
                int notTake = dp[i+1][j+1];
                
                dp[i][j+1] = Math.max(take, notTake);
            }
         }
         return dp[0][0];
    }
}