class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // int n = nums1.length;
        // long res = 0, sum = 0;

        // if(k == 1) {
        //     for(int i = 0;i<n;i++) {
        //         res = Math.max(res, (nums1[i] * nums2[i]));
        //     }
        //     return res;
        // }
        // int[][] elements = new int[n][2];
        // for(int i=0;i<n;i++) {
        //     elements[i] = new int[]{nums2[i], nums1[i]};
        // }

        // Arrays.sort(elements, (a,b)-> b[0] - a[0]);
        // PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        // for(int[] element : elements) {
        //     pq.add(element[1]);
        //     sum+= element[1];

        //     if(pq.size() > k) sum -= pq.poll();
        //     if(pq.size() == k) res = Math.max(res, (sum * element[0]));
        // }
        
        // return res;

        long ans = 0;
        int N = nums1.length;

        if (k == 1) {
            for (int i = 0; i < N; i++) {
                long cur = (long) nums1[i] * nums2[i];
                ans = Math.max(ans, cur);
            }
            return ans;
        }

        int[][] arr = new int[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        Queue<Integer> queue = new PriorityQueue<>();
        long sum = 0;
        for (int i = N - 1; i >= 0; i--) {
            int num1 = arr[i][0];
            if (i <= N - k) {
                long cur = (sum + num1) * arr[i][1];
                ans = Math.max(ans, cur);
            }
            if (queue.size() < k - 1) {
                queue.add(num1);
                sum += num1;
            } else if (num1 > queue.peek()) {
                sum -= queue.poll();
                sum += num1;
                queue.add(num1);
            }
        }
        return ans;
    }
}