class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        // for(int num : happiness) {
        //     pq.add(num);
        // }
        Arrays.sort(happiness);
        
        long maxCount = 0;
        int operations = 0;
        int length = happiness.length;
        while(operations < k && (length - 1)- operations >=0 ) {
            if(happiness[length - operations - 1] - operations <= 0)
                break;
            // int pollItem = pq.poll();
            // System.out.println("pollItem: "+ pollItem);
            maxCount+= happiness[length - operations - 1] - operations;
            operations++;
        }

        // System.out.println(pq.peek());
        // System.out.println(pq.peek());
        return maxCount;
    }
}