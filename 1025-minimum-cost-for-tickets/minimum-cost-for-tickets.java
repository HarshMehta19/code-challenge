class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        // Space optimization
        Queue<int[]> queue7 = new LinkedList<>();
        Queue<int[]> queue30 = new LinkedList<>();

        int cost = 0;

        
        for(int day : days) {
            while(!queue7.isEmpty() && 7 + queue7.peek()[0] <= day )
                queue7.poll();
            
            while(!queue30.isEmpty() && 30 + queue30.peek()[0] <= day )
                queue30.poll();

            queue7.offer(new int[]{day, costs[1] + cost});
            queue30.offer(new int[]{day, costs[2] + cost});

            cost = Math.min(cost + costs[0], Math.min(queue7.peek()[1], queue30.peek()[1]));
        }

        return cost;

        // Tabulation
        // return solveTab(days, costs);

        // Memoization
        // int[] dp = new int[days.length + 1];
        // Arrays.fill(dp, -1);

        // return solveMem(days, costs, 0, dp);

        // recursion
        // return solve(days, costs, 0);
    }

    int solveTab(int[] days, int[] costs) {
        int[] dp = new int[days.length+1];

        dp[days.length] = 0;

        for(int k = days.length-1;k>=0;k--) {
            int option1 = costs[0] + dp[k+1];
        
            // 7 Days pass
            int i;
            for(i = k;i< days.length && days[i] < days[k] + 7;i++);

            int option2 = costs[1] + dp[i];

            // 30 days pass
            for(i = k;i<days.length && days[i] < days[k] + 30; i++);

            int option3 = costs[2] + dp[i];

            dp[k] = Math.min(option1, Math.min(option2, option3));
        }
        return dp[0];
    }

    int solveMem(int[] days, int[] costs, int index, int[] dp) {
        if(index >= days.length) return 0;

        if(dp[index] != -1) return dp[index];

        int option1 = costs[0] + solveMem(days, costs, index+1, dp);
        
        // 7 Days pass
        int i;
        for(i = index;i< days.length && days[i] < days[index] + 7;i++);

        int option2 = costs[1] + solveMem(days, costs, i, dp);

        // 30 days pass
        for(i = index;i<days.length && days[i] < days[index] + 30; i++);

        int option3 = costs[2] + solveMem(days, costs, i, dp);

        return dp[index] = Math.min(option1, Math.min(option2, option3));
    }

    int solve(int[] days, int[] costs, int index) {
        if(index >= days.length) return 0;

        int option1 = costs[0] + solve(days, costs, index+1);
        
        // 7 Days pass
        int i;
        for(i = index;i< days.length && days[i] < days[index] + 7;i++);

        int option2 = costs[1] + solve(days, costs, i);

        // 30 days pass
        for(i = index;i<days.length && days[i] < days[index] + 30; i++);

        int option3 = costs[2] + solve(days, costs, i);

        return Math.min(option1, Math.min(option2, option3));
            

    }
}