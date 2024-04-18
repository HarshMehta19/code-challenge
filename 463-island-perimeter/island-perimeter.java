class Solution {
    int totalCount = 0;
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int r =0;r<rows;r++) {
            for(int c=0;c<cols;c++) {
                if(grid[r][c] == 1) {
                    perimeter += 4;
                    if(r>0 && grid[r-1][c] == 1) perimeter -= 2;
                    if(c>0 && grid[r][c-1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;

        // int [][] visited = new int[grid.length][grid[0].length];
        // bfs(grid, 0, 0, visited);
        // return totalCount;
    }

    private void bfs(int[][] grid, int i, int j, int[][] visited) {
        if(!isValid(grid, i, j, visited)) return;
        if(visited[i][j] == 1) return;

        visited[i][j] = 1;
        if(grid[i][j] == 1) {
            checkPerimeter(grid, i, j, visited);
        }
        bfs(grid, i+1, j, visited);
        bfs(grid, i-1, j, visited);
        bfs(grid, i, j+1, visited);
        bfs(grid, i, j-1, visited);
    }

    private void checkPerimeter(int [][] grid, int i, int j, int [][] visited) {
        totalCount += 4;

        if(isValid(grid, i-1, j, visited) && grid[i-1][j] == 1 && visited[i-1][j] == 1) totalCount-=2;
        if(isValid(grid, i, j+1, visited) && grid[i][j+1] == 1 && visited[i][j+1] == 1) totalCount-=2;

        if(isValid(grid, i, j-1, visited) && grid[i][j-1] == 1 && visited[i][j-1] == 1) totalCount-=2;
        if(isValid(grid, i+1, j, visited) && grid[i+1][j] == 1 && visited[i+1][j] == 1) totalCount-=2;
    }

    private boolean isValid(int [][] grid, int i, int j, int [][] visited) {
        if(i < 0 || i>=grid.length || j <0 || j>=grid[0].length) return false;
        return true;
    }
}