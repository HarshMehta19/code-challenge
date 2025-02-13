class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i =0;i<nums.length;i++) {
            if(nums[i] < k)
            minHeap.add(nums[i]);
        }
        int ans = 0;
        while(!minHeap.isEmpty()) {

            // if(minHeap.size() < 2) return -1;

            int num1 = minHeap.poll();
            ans++;
            if(minHeap.isEmpty()) break;

            int num2 = minHeap.poll();
            long val = 2l * num1 + num2;
            if(val<k)
                minHeap.add((int)val);
        }
        return ans;
    }
}