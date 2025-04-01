class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        return helper(questions, 0, dp);
    }

    private long helper(int[][] questions, int index, long[] dp) {
        if (index >= questions.length)
            return 0;

        if (dp[index] > 0)
            return dp[index];

        dp[index] = Math.max(helper(questions, index + 1, dp),
                questions[index][0] + helper(questions, index + 1 + questions[index][1], dp));

        return dp[index];
    }   
}