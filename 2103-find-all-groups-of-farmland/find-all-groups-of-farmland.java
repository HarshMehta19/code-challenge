class Solution {
    int row = 0, col = 0;
    public int[][] findFarmland(int[][] land) {
        row = land.length;    
        col = land[0].length;
        Set<String> visited = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(land[i][j] == 1 && !visited.contains(i + ","+j)) {
                    int[] indexes = dfs(i, j, visited, land);
                    result.add(indexes);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    private int[] dfs(int i, int j, Set<String> visited, int[][] land) {
        // System.out.println("inside");
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {i, j});
        visited.add(i + ","+ j);

        int minR = i, minC = j;
        int maxR = i, maxC = j;

        while(!stack.isEmpty()) {
            // System.out.println("inside 1");
            int[] curr = stack.pop();
            int curX = curr[0], curY = curr[1];

            int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for(int[] dir : direction) {
                int posX = curX+dir[0];
                int posY = curY+dir[1];

                if(posX >=0 && posX < row && posY >=0 && posY<col && land[posX][posY] == 1
                    && !visited.contains(posX + ","+ posY)) {
                        visited.add(posX+","+ posY);
                        stack.push(new int[]{posX, posY});

                        minR = Math.min(minR, posX);
                        minC = Math.min(minC, posY);
                        maxR = Math.max(maxR, posX);
                        maxC = Math.max(maxC, posY);
                    }
            }
        }
        
        return new int[] {minR, minC, maxR, maxC};

    }
}