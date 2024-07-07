class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];

        return helper(word1, word2, 0, 0, dp);
    }

    private int helper(String word1, String word2, int index1, int index2, int[][] dp) {
        if(index1 == word1.length()) return word2.length() - index2;
        if(index2 == word2.length()) return word1.length() - index1;

        if(dp[index1][index2] > 0) return dp[index1][index2];

        int result;
        if(word1.charAt(index1) == word2.charAt(index2)){
            result = helper(word1, word2, index1+1, index2+1, dp);
        } else {
            result = 1 + helper(word1, word2, index1, index2+1, dp);

            result = Math.min(result, 1 + helper(word1, word2, index1+1, index2, dp));

            result = Math.min(result, 1 + helper(word1, word2, index1+1, index2+1, dp));
        }
        dp[index1][index2] = result;
        return result;
    }
}