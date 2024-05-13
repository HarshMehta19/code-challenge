class Solution {
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        int[] parent = new int[size];
        for(int i=0;i<size;i++) {
            parent[i] = i;
        }
        if(isConnected.length == 0 || isConnected[0].length == 0 ) return 0;

        Set<Integer> set = new HashSet<>();
        for(int i =0;i<size;i++) {
            for(int j=i+1;j<size;j++) {
                if(isConnected[i][j] == 1){
                    union(i, j, parent);
                }
            }
        }

        for(int i=0;i<size;i++) {
            parent[i] = find(i, parent);
            set.add(parent[i]);
        }

        return set.size();
    }

    private int find(int x, int[] parent) {
        if(parent[x] != x){
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }


    private void union(int x, int y, int[] parent) {
        int parX = find(x, parent);
        int parY = find(y, parent);
        parent[parY] = parX;

    }
}