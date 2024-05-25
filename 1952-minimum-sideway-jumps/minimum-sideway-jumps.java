class Solution {
    public int minSideJumps(int[] obstacles) {
        //Memoization
        int[][] dp = new int[4][obstacles.length+1];
        for(int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        return solve(obstacles, 0, 2, dp);
        // Recursion
        //return solve(obstacles, 2, 0);
    }

    int solve(int[] obs,int pos,int lane,int[][] dp){
        if(pos==obs.length-1) return 0;
        if(dp[lane][pos]!=Integer.MAX_VALUE) return dp[lane][pos];
        if(obs[pos+1]!=lane){
            return dp[lane][pos]=solve(obs,pos+1,lane,dp);
        }
        else{
            //Side Jump
            for(int i=1;i<=3;i++){
                if(lane!=i && obs[pos]!=i){
                   dp[lane][pos]=Math.min(dp[lane][pos],1+solve(obs,pos,i,dp)); 
                }
            }
            return dp[lane][pos];
        }   
    }

    // public int solveMem(int[] obstacles, int lane, int position, int[][] dp) {
    //     if(position == obstacles.length -1)
    //         return 0;

    //     if(dp[lane][position] != Integer.MAX_VALUE) return dp[lane][position];

    //     if(obstacles[position + 1] != lane){
    //         return dp[lane][position] = solveMem(obstacles, lane, position+1, dp);
    //     } else{
    //         // dp[lane][position] = Integer.MAX_VALUE;
    //         for(int i =1;i<=3;i++){
    //             if(i != lane && obstacles[position] != i)
    //                 dp[lane][position] = Math.min(dp[lane][position], 1+solveMem(obstacles, i, position, dp));
    //         }
    //         return dp[lane][position];
    //     }
    // }
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