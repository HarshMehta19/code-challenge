class Solution {
    int MOD = (int)(1e9+7);
    public int numTilings(int n) {
        return solve(n);
    }

    private int solve(int n) {
        int dp[] = new int[n+4];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        // dp[3] = 3;
        for(int i=3;i<=n;i++){
            dp[i] = (((2 * dp[i-1]) % MOD) + (dp[i-3] % MOD)) % MOD;
        }
        return dp[n];

        // if(n<= 1) return 1;
        // else if(n == 2) return 2;
        // return (int)(2 * solve(n-1)%MOD + solve(n-3) % MOD) % MOD;
    }
}