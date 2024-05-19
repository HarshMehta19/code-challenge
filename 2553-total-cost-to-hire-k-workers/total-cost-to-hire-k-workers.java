class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        // int i = 0;
        // int j = costs.length - 1;
        // PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        // PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        // long ans = 0;
        // while (k-- > 0) {
        //     while (pq1.size() < candidates && i <= j) {
        //         // System.out.println("i is: "+ i);
        //         pq1.offer(costs[i++]);
        //     }
        //     while (pq2.size() < candidates && i <= j) {
        //         // System.out.println("j is: "+ j);
                
        //         pq2.offer(costs[j--]);
        //     }

        //     int t1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
        //     int t2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

        //     if (t1 <= t2) {
        //         ans += t1;
        //         pq1.poll();
        //     } else {
        //         ans += t2;
        //         pq2.poll();
        //     }
        // }
        // return ans;
        int n = costs.length;
        long cost = 0;

        if (candidates * 2 + k > n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                cost += costs[i];
            }
            return cost;
        }
        // return 0;
        PriorityQueue<Integer> pre = new PriorityQueue<>();
        PriorityQueue<Integer> post = new PriorityQueue<>();

        for(int i =0;i<candidates;i++) {
            pre.offer(costs[i]);
            post.offer(costs[n - 1 - i]);
        }
        int i= candidates, j = n - 1 - candidates;

        while(k-- > 0) {
            if(pre.peek() <= post.peek()) {
                // System.out.println("pre: "+ pre);
                // System.out.println("post: "+ post);
                cost += pre.poll();
                // if(i <= j)
                pre.offer(costs[i++]);
            } else {
                // System.out.println("pre: "+ pre);
                // System.out.println("post: "+ post);
                cost += post.poll();
                // if(i<=j)
                post.offer(costs[j--]);
            }
        }

        return cost;



    }
}