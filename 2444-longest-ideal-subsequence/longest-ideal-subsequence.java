class Solution {
    public int longestIdealString(String s, int k) {
        int[]dp = new int[27];
        int n = s.length();

        for(int i = 0;i<n;i++) {
        // for(int i = n-1; i >= 0 ;i--){
            char c = s.charAt(i);
            int idx = c - 'a';

            int max = Integer.MIN_VALUE;

            int left = Math.max((idx - k), 0);
            int right = Math.min((idx + k), 26);

            for(int x = left; x<=right; x++) {
                max = Math.max(max, dp[x]);
            }
            dp[idx] = max + 1;
        }

        int max = Integer.MIN_VALUE;
        
        for(int e : dp) {
            max = Math.max(max, e);
        }
        return max;

    }

    
}