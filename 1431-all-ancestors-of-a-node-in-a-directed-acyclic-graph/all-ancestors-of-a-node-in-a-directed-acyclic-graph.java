class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];

        for(int i=0;i<n;i++)
        {
            res.add(new ArrayList<>());
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            graph[parent].add(child);
        }

        for(int i=0;i<n;i++)
            traversal(i, i, new boolean[n], graph, res);
        return res;

    }

    public void traversal(int child, int parent, boolean[] visited, List<Integer>[] graph, List<List<Integer>> res) {
        visited[child] = true;
        for(int edge : graph[child]){
            if(visited[edge]) continue;
            res.get(edge).add(parent);
            traversal(edge, parent, visited, graph, res);
        }
    }
}