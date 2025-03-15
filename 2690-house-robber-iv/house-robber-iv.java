class Solution {
    public int minCapability(int[] nums, int k) {
        int max = 1, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int left = min, right = max, n = nums.length;
        while (left < right) {
            int mid = (left + right) / 2, take = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    take += 1;
                    i++;
                }
            }
            if (take >= k)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}