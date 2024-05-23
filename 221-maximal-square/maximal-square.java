class Solution {
    int maxi;
    public int maximalSquare(char[][] matrix) {
        maxi = 0;
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        solveMem(matrix, 0, 0, dp);
        return maxi * maxi;
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