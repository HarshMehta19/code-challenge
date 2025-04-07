class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 1) return false;
        int totalSum = 0;
        for(int n : nums) totalSum+= n;

        if(totalSum %2 != 0) return false;

        int target = totalSum / 2;
        boolean[] dp = new boolean[target];
        dp[0] = true;
        for(int num: nums) {
            for(int j = target; j>=num;j--) {
                if(dp[j-num]) { // 10, 9, 8, 7, 
                    // System.out.println("j:" + j);
                    if(j == target) return true;
                    dp[j] = true;
                }
            }
        }
        return false;
    }
}