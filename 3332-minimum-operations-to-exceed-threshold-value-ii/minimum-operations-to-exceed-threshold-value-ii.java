class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for(int i =0;i<nums.length;i++) {
            minHeap.add((long) nums[i]);
        }
        int ans = 0;
        while(!minHeap.isEmpty() && minHeap.peek() < k) {

            if(minHeap.size() < 2) return -1;

            long num1 = minHeap.poll(), num2 = minHeap.poll();
            minHeap.add(Math.min(num1, num2) * 2 + Math.max(num1, num2));
            ans++;
        }
        return ans;
    }
}