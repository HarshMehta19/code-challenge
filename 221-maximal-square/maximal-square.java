class Solution {
    int maxi;
    public int maximalSquare(char[][] matrix) {

        // Tab
        solveTab(matrix);
        return maxi * maxi;
        // Memoization
        // maxi = 0;
        // Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        // solveMem(matrix, 0, 0, dp);
        // return maxi * maxi;
    }

    void solveTab(char[][] matrix){
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];

        for(int i=row-1;i>=0;i--) {
            for(int j=col-1;j>=0;j--) {
                // if(i+1 >= row || j+1 >= col) continue;
                int right = dp[i][j+1];
                int bottom = dp[i+1][j];
                int dia = dp[i+1][j+1];
                int ans = 0;
                if(matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(right, Math.min(bottom, dia));
                    maxi = Math.max(maxi, dp[i][j]);
                    // dp[i][j] = ans;
                } else
                    dp[i][j] = 0;
            }

        }
        // return dp[0][0];

    }

    public int solveMem(char[][] matrix, int i, int j, Integer[][] dp) {
        if(i>= matrix.length || j>= matrix[0].length) {
            return 0;
        }

        if(dp[i][j] != null) return dp[i][j];

        int right = solveMem(matrix, i, j+1, dp);
        int bottom = solveMem(matrix, i+1, j, dp);
        int dia = solveMem(matrix, i+1, j+1, dp);
        int ans = 0;
        if(matrix[i][j] == '1') {
            ans = 1 + Math.min(right, Math.min(bottom, dia));
            maxi = Math.max(maxi, ans);
            return dp[i][j] = ans;
        }
        return dp[i][j] = ans;
    }

    public int solve(char[][] matrix, int i, int j) {
        if(i>= matrix.length || j>= matrix[0].length) {
            return 0;
        }

        int right = solve(matrix, i, j+1);
        int bottom = solve(matrix, i+1, j);
        int dia = solve(matrix, i+1, j+1);

        if(matrix[i][j] == '1') {
            int ans = 1 + Math.min(right, Math.min(bottom, dia));
            maxi = Math.max(maxi, ans);
            return ans;
        }else{
            return 0;
        }
    }
}