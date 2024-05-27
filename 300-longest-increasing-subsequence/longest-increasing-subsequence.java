class Solution {
    public int lengthOfLIS(int[] nums) {
        // Most optimized one

        return solveOptimal(nums);
        
        // Space Optimization
        // int n = nums.length;
        // return solveSO(n, nums);
        
        // return solveTab(nums.length, nums);
        // int n = nums.length;
        // int[][] dp = new int[n][n+1];
        // for(int[] arr : dp) {
        //     Arrays.fill(arr, -1);
        // }
        // return solve(n, nums, 0, -1, dp);
    }

    private int solveOptimal(int a[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int length = 1;
        list.add(a[0]);

        for(int i=1;i<a.length;i++) {
            if(a[i] > list.get(list.size() - 1)){
                length++;
                list.add(a[i]);
            } else {
                int index = Collections.binarySearch(list, a[i]);

                if(index < 0){
                    index = -index - 1;
                }
                list.set(index, a[i]);

            }
        }
        return length;
    }

    private int solveSO(int n, int a[]) {
        int[] curr = new int[n+1];
        int[] next = new int[n+1];

        for(int i = n-1;i>=0;i--) {
            for(int j= i-1;j>=-1;j--) {
                int take = 0;
        
                if(j == -1 || a[i] > a[j]) {
                    take = 1 + next[i+1];
                }
                
                int notTake = next[j+1];
                
                curr[j+1] = Math.max(take, notTake);
            }
            next = curr;
         }
        return next[0];
    }

    private int solve(int n, int a[], int curr, int prev, int[][] dp) {
        if(curr == n) return 0;
        
        if(dp[curr][prev+1] != -1) return dp[curr][prev+1];
        
        int take = 0;
        
        if(prev == -1 || a[curr] > a[prev]) {
            take = 1 + solve(n, a, curr+1, curr, dp);    
        }
        
        int notTake = solve(n, a, curr+1, prev, dp);
        
        return dp[curr][prev+1] = Math.max(take, notTake);
    }

    private int solveTab(int n, int[] a) {
        int[][] dp = new int[n+1][n+1];
        for(int i = n-1;i>=0;i--) {
            for(int j= i-1;j>=-1;j--) {
                int take = 0;
        
                if(j == -1 || a[i] > a[j]) {
                    take = 1 + dp[i+1][i+1];
                }
                
                int notTake = dp[i+1][j+1];
                
                dp[i][j+1] = Math.max(take, notTake);
            }
         }
         return dp[0][0];
    }
}