class Solution {
    int[] dp;
    int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp , -1);
        int ans = coinCount(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int coinCount(int[] coins, int amount) {
       if(amount == 0) return 0;

       if(amount <0) return Integer.MAX_VALUE;

        if(dp[amount] != -1) return dp[amount];
       int min_coin = Integer.MAX_VALUE;

       for(int i = 0; i<coins.length;i++) {
            int ans = coinCount(coins, amount - coins[i]);
            if(ans != Integer.MAX_VALUE)
                min_coin = Math.min(min_coin, 1 + ans);
       }
       return dp[amount] = min_coin;
    }
}