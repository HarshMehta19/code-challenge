class Solution {
    public int countPaths(int n, int[][] roads) {
        // int minPath = Integer.MAX_INTEGER, result =0;
        final int MOD = 1000000007;
        ArrayList<ArrayList<int[]>> adj = new ArrayList();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int) curr[1];

            if(d > dist[node]) continue;

            for(int[]neighbor: adj.get(node)) {
                int nextNode = neighbor[0];
                int time = neighbor[1];

                if(dist[node] + time < dist[nextNode]) {
                    dist[nextNode] = dist[node] + time;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{dist[nextNode], nextNode});
                } else if(dist[node] + time == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}