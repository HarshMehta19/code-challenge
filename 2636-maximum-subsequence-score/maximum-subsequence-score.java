class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long res = 0, sum = 0;

        if(k == 1) {
            for(int i = 0;i<n;i++) {
                res = Math.max(res, (nums1[i] * nums2[i]));
            }
            return res;
        }
        int[][] elements = new int[n][2];
        for(int i=0;i<n;i++) {
            elements[i] = new int[]{nums2[i], nums1[i]};
        }

        Arrays.sort(elements, (a,b)-> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int[] element : elements) {
            pq.add(element[1]);
            sum+= element[1];

            if(pq.size() > k) sum -= pq.poll();
            if(pq.size() == k) res = Math.max(res, (sum * element[0]));
        }
        
        return res;

    }
}