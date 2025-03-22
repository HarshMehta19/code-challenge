class Solution {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, Set<Integer>> nodes;

    public int countCompleteComponents(int n, int[][] edges) {
        nodes = new HashMap<>();
        for (int[] e : edges) {
            nodes.putIfAbsent(e[0], new HashSet<>());
            nodes.putIfAbsent(e[1], new HashSet<>());
            nodes.get(e[0]).add(e[1]);
            nodes.get(e[1]).add(e[0]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visited.contains(i))
                continue;
            if (bfs(i))
                result++;
        }

        return result;
    }

    private boolean bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited.add(i);
        int neighbours = nodes.getOrDefault(i, new HashSet<>()).size(), nodes_num = 0;
        boolean result = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            nodes_num++;
            if (nodes.getOrDefault(curr, new HashSet<>()).size() != neighbours)
                result = false;
            for(int neig : nodes.getOrDefault(curr, new HashSet<>())) {
                if(visited.contains(neig)) continue;
                visited.add(neig);
                q.offer(neig);
            }
        }

        return result && neighbours == nodes_num - 1;
    }
}