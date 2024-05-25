class Solution {
    public int minSideJumps(int[] obstacles) {
        // Tabulation
        return solveTab(obstacles);
        
        //Memoization
        // int[][] dp = new int[4][obstacles.length+1];
        // for(int[] arr : dp) {
        //     Arrays.fill(arr, Integer.MAX_VALUE);
        // }

        // return solveMem(obstacles, 2, 0, dp);
        // Recursion
        //return solve(obstacles, 2, 0);
    }

    public int solveTab(int[] obstacles) {
        int n = obstacles.length -1;
        int[][] dp = new int[4][obstacles.length];
        for(int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        dp[0][n] = 0;
        dp[1][n] = 0;
        dp[2][n] = 0;
        dp[3][n] = 0;

        for(int pos = n-1;pos>=0;pos--) {
            for(int lane=1;lane<=3;lane++){
                if(obstacles[pos + 1] != lane){
                    dp[lane][pos] = dp[lane][pos+1];
                } else{
                    int ans = Integer.MAX_VALUE;
                    for(int i =1;i<=3;i++){
                        if(i != lane && obstacles[pos] != i)
                            ans = Math.min(ans, 1 + dp[i][pos+1]);
                    }
                    dp[lane][pos] = ans;
                }
            }
        }
        return Math.min(dp[2][0], Math.min((dp[1][0] + 1), (dp[3][0] + 1)));//dp[lane][pos];

    }
    public int solveMem(int[] obstacles, int lane, int position, int[][] dp) {
        if(position == obstacles.length -1)
            return 0;

        if(dp[lane][position] != Integer.MAX_VALUE) return dp[lane][position];

        if(obstacles[position + 1] != lane){
            return dp[lane][position] = solveMem(obstacles, lane, position+1, dp);
        } else{
            // dp[lane][position] = Integer.MAX_VALUE;
            for(int i =1;i<=3;i++){
                if(i != lane && obstacles[position] != i)
                    dp[lane][position] = Math.min(dp[lane][position], 1+solveMem(obstacles, i, position, dp));
            }
            return dp[lane][position];
        }
    }
    public int solve(int[] obstacles, int lane, int position) {
        if(position == obstacles.length -1)
            return 0;

        if(obstacles[position + 1] != lane){
            return solve(obstacles, lane, position+1);
        } else{
            int ans = Integer.MAX_VALUE;
            for(int i =1;i<=3;i++){
                if(i != lane && obstacles[position] != i)
                    ans = Math.min(ans, 1+solve(obstacles, i, position));
            }
            return ans;
        }
    }
}