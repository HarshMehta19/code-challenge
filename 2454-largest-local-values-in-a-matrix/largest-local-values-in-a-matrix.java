class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n-2][n-2];
        for(int i=0;i<n-2;i++) {
            for(int j=0;j<n-2;j++) {
                res[i][j] = getMax(grid, i, j);
                // for(int di=0;di<3;di++){
                //     for(int dj=0;dj<3;dj++){
                //         res[i][j] = Math.max(res[i][j], grid[i+di][j+dj]);
                //     }
                // }
            }
        }
        return res;
    }

    public int getMax(int[][]grid, int i, int j) {
        int max = 0;
        for(int di=i;di<i+3;di++){
            for(int dj=j;dj<j+3;dj++){
                max = Math.max(max, grid[di][dj]);
            }
        }
        return max;
    }
}