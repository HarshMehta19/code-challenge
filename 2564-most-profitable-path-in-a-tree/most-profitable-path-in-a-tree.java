class Solution {
    static int[] par;
    static int result;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        final int n = amount.length;
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int count = 0;
        int[] visited = new int[n];
        bobTraversal(bob, -1, 1, visited, adj);

        return (int)dfs(0, -1, 1, visited, adj, amount);
    }

    private boolean bobTraversal(int src, int prev, int level, int[] visited, List<Integer>[] adj) {
        visited[src] = level;
        if (src == 0)
            return true;

        visited[src] = level;
        for (int nbr : adj[src]) {
            if (nbr != prev) {
                if(bobTraversal(nbr, src, level + 1, visited, adj)) return true;
            }
        }

        visited[src] = 0;
        return false;
    }

    private long dfs(int src, int prev, int level, int[] visited, List<Integer>[] adj, int[] amount) {
        long cost = 0;

        if(visited[src]==0) cost += amount[src];
        else if(visited[src]>level) cost += amount[src];
        else if(visited[src] == level) cost += (amount[src] / 2);

        long current = Long.MIN_VALUE;
        for(int nbr: adj[src]) {
            if(nbr != prev) {
                current = Math.max(dfs(nbr, src, level+1, visited, adj, amount), current);
            }
        }

        if(current == Long.MIN_VALUE) return cost;
        return cost + current;
    }
}