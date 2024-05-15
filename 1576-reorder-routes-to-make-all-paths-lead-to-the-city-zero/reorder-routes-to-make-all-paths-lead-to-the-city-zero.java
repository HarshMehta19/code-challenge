class Solution {

    private int dfs(List<List<Integer>> nei, boolean[] visited, int from) {
        int count = 0;
        visited[from] = true;
        for(int to : nei.get(from)) {
            if(!visited[Math.abs(to)]) {
                count += dfs(nei, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }
        return count;
    }
    
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> nei = new ArrayList<>();
        for(int i=0;i<n;i++)
            nei.add(new ArrayList<>());

        for(int[] connection: connections) {
            nei.get(connection[0]).add(connection[1]);
            nei.get(connection[1]).add(-connection[0]);
        }

        return dfs(nei, new boolean[n], 0);
        
    }
}