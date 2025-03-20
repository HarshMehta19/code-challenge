class Solution {
    int[] parent, minCost;
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        minCost = new int[n];

        Arrays.fill(parent, -1);
        Arrays.fill(minCost, -1);

        for(int[] edge : edges) {
            int lRoot = find(edge[0]), rRoot = find(edge[1]);
            if(lRoot != rRoot) {
                minCost[lRoot] &= minCost[rRoot];
                parent[rRoot] = lRoot;
            }
            minCost[lRoot] &= edge[2];
        }

        int[] result = new int[query.length];
        for(int i = 0; i<query.length;i++) {
            int u = query[i][0], v = query[i][1];
            int lRoot = find(u), rRoot = find(v);

            if(u == v) result[i] = 0;
            else if(lRoot != rRoot) result[i] = -1;
            else result[i] = minCost[lRoot];
        }

        return result;
    }

    private int find(int node) {
        if(parent[node] < 0) return node;
        return parent[node] = find(parent[node]);
    }
}