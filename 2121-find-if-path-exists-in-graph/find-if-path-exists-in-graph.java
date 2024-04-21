class Solution {
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<n;i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        Queue<Integer>q = new LinkedList<>();
        q.add(source);
        boolean vis[] = new boolean[n+1];
        vis[source] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            if(node == destination) return true;
            for(Integer it:list.get(node)){
                if(vis[it] == false) {
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
        return false;

    }


}