class Solution {
    public int minSideJumps(int[] obstacles) {
        //Memoization
        int[][] dp = new int[4][obstacles.length+1];

        return solveMem(obstacles, 2, 0, dp);
        // Recursion
        //return solve(obstacles, 2, 0);
    }
    public int solveMem(int[] obstacles, int lane, int position, int[][] dp) {
        if(position == obstacles.length -1)
            return 0;

        if(dp[lane][position] != 0) return dp[lane][position];

        if(obstacles[position + 1] != lane){
            return solveMem(obstacles, lane, position+1, dp);
        } else{
            int ans = Integer.MAX_VALUE;
            for(int i =1;i<=3;i++){
                if(i != lane && obstacles[position] != i)
                    ans = Math.min(ans, 1+solveMem(obstacles, i, position, dp));
            }
            return dp[lane][position] = ans;
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