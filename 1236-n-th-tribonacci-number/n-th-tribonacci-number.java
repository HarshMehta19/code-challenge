class Solution {
    public int tribonacci(int n) {
        
        
        if(n==0) return 0;
        if(n<=2) return 1;
        
        // int []dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return recursion(n, dp);

        // return solve(n);
        return solveTabSp(n);
    }

    // Tabulation + space complexity

    int solveTabSp(int n) {
        int first = 0, second = 1, third = 1;
        for(int i=3;i<=n;i++){
            int temp = first + second + third;

            first = second;
            second = third;
            third = temp;
        }
        return third;
    }
    
    // tablulation
    int solve(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1; dp[2] = 1;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    // Memoization
    int recursion(int n, int[] dp) {
        
        if(n <= 0) return 0;
        else if(n<=2) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = recursion(n-3, dp) + recursion(n-2, dp) + recursion(n-1, dp);
    }
}