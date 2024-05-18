class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] elements = new int[n][2];
        for(int i=0;i<n;i++) {
            elements[i] = new int[]{nums2[i], nums1[i]};
        }

        Arrays.sort(elements, (a,b)-> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        long res = 0, sum = 0;
        for(int[] element : elements) {
            pq.add(element[1]);
            sum+= element[1];

            if(pq.size() > k) sum -= pq.poll();
            if(pq.size() == k) res = Math.max(res, (sum * element[0]));
        }
        // Arrays.sort(elements, (a,b)-> b[0] - a[0]);
        // ArrayList<Integer> list = new ArrayList<>();
        // long res = 0, sum = 0;
        // for(int[] element : elements) {
        //     list.add(element[1]);
        //     sum+= element[1];

        //     if(list.size() > k) sum -= list.remove(0);
        //     if(list.size() == k) res = Math.max(res, (sum * element[0]));
        // }
        return res;
    }
}