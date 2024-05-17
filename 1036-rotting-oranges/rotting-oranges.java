class Solution {
    public int orangesRotting(int[][] grid) {
        int[] xDirection = new int[]{1, -1, 0, 0};
        int[] yDirection = new int[]{0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0, rotten = 0;
        int rows = grid.length, cols = grid[0].length;
        for(int row = 0;row<rows;row++) {
            for(int col = 0;col<cols;col++) {
                if(grid[row][col] == 0) continue;
                if(grid[row][col] == 2){
                    rotten++;    
                    queue.offer(new int[]{row, col});
                }
                else if(grid[row][col] == 1)
                    fresh++;
            }
        }
        if(fresh == 0) return 0;
        if(rotten == 0) return -1;
        int time = 0;
        int x, y;

        while(!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] dir = queue.poll();
                x = dir[0];
                y = dir[1];
                for(int move = 0;move<4;move++) {
                    int xDir = x+xDirection[move];
                    int yDir = y+yDirection[move];

                    if(!isValidMove(xDir, yDir, rows, cols)) continue;
                    
                    if(grid[xDir][yDir] == 1) {
                        grid[xDir][yDir] = 2;
                        queue.offer(new int[]{xDir, yDir});
                        fresh--;
                    }
                }
            }
            time++;

        }

        return fresh == 0 ? time : -1;
    }

    boolean isValidMove(int row, int col, int totalRows, int totalCols) {
        if(row < 0 || row >= totalRows || col < 0 || col >= totalCols) return false;

        return true;
    }
}