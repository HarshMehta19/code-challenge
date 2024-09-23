class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[51];
        Arrays.fill(dp, -1);
        return helper(s, dictionary, dp, 0);
    }

    int helper(String s, String[] dictionary, int[] dp, int index) {
        if(index == s.length())
            return 0;
        
        if(dp[index] == -1) {
            dp[index] = 1 + helper(s, dictionary, dp, index+1);

            for(String w: dictionary) {
                if ( index + w.length() <= s.length() && s.substring(index, index+w.length()).equals(w)){
                    dp[index] = Math.min(dp[index], helper(s, dictionary, dp, index + w.length()));
                }
            }
        }
        return dp[index];
    }
}