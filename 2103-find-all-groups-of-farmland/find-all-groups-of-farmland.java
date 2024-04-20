class Solution {
    int row = 0, col = 0;
    public int[][] findFarmland(int[][] land) {
        row = land.length;    
        col = land[0].length;
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(land[i][j] == 1) {
                    int[] coord = dfs(i, j , land);
                    res.add(coord);
                }
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    private int[] dfs(int i, int j, int[][] land) {
        int r1 = i,  c1 = j;
        int maxR = r1, maxC = c1;
        while(maxR < row && land[maxR][j] == 1) maxR++;
        while(maxC < col && land[r1][maxC] == 1) maxC++;
        
        for(int r = r1; r<maxR; r++) {
            for(int c = c1;c < maxC; c++) {
                land[r][c] = 0;
            }
        }
        maxR--;
        maxC--;
        return new int[]{r1, c1, maxR, maxC};

    }
}