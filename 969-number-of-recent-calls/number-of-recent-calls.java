class RecentCounter {
    // Queue<Integer> q;
    private int[] q = new int[10000];
    int start = 0, end = 0;
    public RecentCounter() {
        start = 0;
        end = 0;
    }
    
    public int ping(int t) {
        // System.out.println("size: "+ q.size());
        while(start<end && (t - q[start] > 3000))
            start++;
        q[end++] = t;
        return end - start;
        // q.add(t);
        // while(q.peek() < t - 3000)
        //     q.poll();
        // return q.size();
        
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */