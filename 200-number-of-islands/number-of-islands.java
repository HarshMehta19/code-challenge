class Solution {
    int row, col;
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        row = grid.length;
        col = grid[0].length;
        int res = 0;

        for(int i = 0;i<row;i++) {
            for(int j = 0; j<col;j++) {
                if(grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;

    }

    private void dfs(char[][] grid, int i, int j) {

        grid[i][j] = '0';
        if(i+1<row && grid[i+1][j] == '1')
            dfs(grid, i+1, j);
        if(i > 0 && grid[i-1][j] == '1')
            dfs(grid, i-1, j);
        if(j+1<col && grid[i][j+1] == '1')
            dfs(grid, i, j+1);
        if(j>0 && grid[i][j-1] == '1')
            dfs(grid, i, j-1);
    }
}