class Solution {
    public int snakesAndLadders(int[][] board) {
        int rows = board.length, cols = board[0].length, target = rows * cols;
        int r, c, p;

        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {1, 0});

        visited[rows - 1][0] = true;

        while(!q.isEmpty()) {
            int[] boardPosVal = q.poll();
            int square = boardPosVal[0], moves = boardPosVal[1];    
            for(int i = 1;i<7;i++) {
                int nextSquare = square + i;
                int[] pos = findCoords(nextSquare, rows);
                if(board[pos[0]][pos[1]] != -1)
                    nextSquare = board[pos[0]][pos[1]];
                
                if(nextSquare == target) return moves + 1;

                if(visited[pos[0]][pos[1]] == false) {
                    visited[pos[0]][pos[1]] = true;
                    q.offer(new int[]{nextSquare, moves + 1});
                }
            }
        }
        return -1;
    }

    private int[] findCoords(int curr, int n) {
        int r = n - (curr - 1) / n-1;
        int c = (curr - 1) % n;

        if(r % 2 == n % 2) {
            return new int[]{r, n - 1 - c};
        }
        return new int[]{r, c};
    }
}