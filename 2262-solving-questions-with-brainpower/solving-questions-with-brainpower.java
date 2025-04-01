class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length + 1];
        int n = questions.length;
        for(int i=n-1;i>=0;i--) {
            int points = questions[i][0];
            int jump = questions[i][1];

            int nextPos = Math.min(n, jump + i + 1);
            dp[i] = Math.max(dp[i+1], points + dp[nextPos]);
        }

        return dp[0];
    }   
}